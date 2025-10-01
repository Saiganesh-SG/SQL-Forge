package com.sqlforge.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.stream.Collectors;

/**
 * Database Manager for SQL Forge
 * Manages the in-memory H2 database with MySQL compatibility mode
 */
public class DatabaseManager {
    
    private static final String DB_URL = "jdbc:h2:mem:sqlforge;MODE=MySQL;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
    
    private static Connection connection;
    
    /**
     * Initialize the database with schema and sample data
     */
    public static void initialize() throws SQLException {
        try {
            // Load H2 driver
            Class.forName("org.h2.Driver");
            
            // Create connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            // Load and execute schema.sql
            String schema = loadSchemaFromResource();
            executeScript(schema);
            
            System.out.println("✓ Database initialized successfully with sample data");
            
        } catch (ClassNotFoundException e) {
            throw new SQLException("H2 Driver not found", e);
        } catch (Exception e) {
            throw new SQLException("Failed to initialize database", e);
        }
    }
    
    /**
     * Get the database connection
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            initialize();
        }
        return connection;
    }
    
    /**
     * Execute a SQL query and print results
     */
    public static void executeAndPrintQuery(String query, String description) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println(description);
        System.out.println("=".repeat(80));
        System.out.println("Query: " + query);
        System.out.println("-".repeat(80));
        
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            
            // Print column headers
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-20s", metaData.getColumnName(i));
            }
            System.out.println();
            System.out.println("-".repeat(80));
            
            // Print rows
            int rowCount = 0;
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    Object value = rs.getObject(i);
                    System.out.printf("%-20s", value != null ? value.toString() : "NULL");
                }
                System.out.println();
                rowCount++;
            }
            
            System.out.println("-".repeat(80));
            System.out.println(rowCount + " row(s) returned");
            
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
    }
    
    /**
     * Execute a SQL update/insert/delete statement
     */
    public static int executeUpdate(String sql, String description) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println(description);
        System.out.println("=".repeat(80));
        System.out.println("Query: " + sql);
        System.out.println("-".repeat(80));
        
        try (Statement stmt = getConnection().createStatement()) {
            int result = stmt.executeUpdate(sql);
            System.out.println(result + " row(s) affected");
            return result;
        } catch (SQLException e) {
            System.err.println("Error executing update: " + e.getMessage());
            return -1;
        }
    }
    
    /**
     * Load schema.sql from resources
     */
    private static String loadSchemaFromResource() throws Exception {
        InputStream is = DatabaseManager.class.getClassLoader().getResourceAsStream("schema.sql");
        if (is == null) {
            throw new Exception("schema.sql not found in resources");
        }
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }
    
    /**
     * Execute a SQL script
     */
    private static void executeScript(String script) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            // Remove comments and split by semicolon
            String[] lines = script.split("\n");
            StringBuilder currentStatement = new StringBuilder();
            
            for (String line : lines) {
                line = line.trim();
                // Skip comment lines
                if (line.startsWith("--") || line.isEmpty()) {
                    continue;
                }
                
                currentStatement.append(line).append(" ");
                
                // If line ends with semicolon, execute the statement
                if (line.endsWith(";")) {
                    String sql = currentStatement.toString().trim();
                    if (!sql.isEmpty()) {
                        // Remove trailing semicolon
                        sql = sql.substring(0, sql.length() - 1);
                        stmt.execute(sql);
                    }
                    currentStatement = new StringBuilder();
                }
            }
            
            // Execute any remaining statement
            String sql = currentStatement.toString().trim();
            if (!sql.isEmpty()) {
                if (sql.endsWith(";")) {
                    sql = sql.substring(0, sql.length() - 1);
                }
                stmt.execute(sql);
            }
        }
    }
    
    /**
     * Close the database connection
     */
    public static void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("\n✓ Database connection closed");
            }
        } catch (SQLException e) {
            System.err.println("Error closing database: " + e.getMessage());
        }
    }
    
    /**
     * Reset the database (drop and recreate all tables)
     */
    public static void reset() throws SQLException {
        try {
            String schema = loadSchemaFromResource();
            executeScript(schema);
            System.out.println("✓ Database reset successfully");
        } catch (Exception e) {
            throw new SQLException("Failed to reset database", e);
        }
    }
}
