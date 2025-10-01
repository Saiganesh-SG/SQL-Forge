package com.sqlforge.lessons;

import com.sqlforge.util.DatabaseManager;

/**
 * Lesson 1: Basic SELECT Statements
 * Learn how to retrieve data from a single table
 */
public class Lesson01_BasicSelect {
    
    public static void run() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("LESSON 1: BASIC SELECT STATEMENTS");
        System.out.println("#".repeat(80));
        
        // Example 1: Select all columns from a table
        DatabaseManager.executeAndPrintQuery(
            "SELECT * FROM customers",
            "Example 1: Select all columns from customers table"
        );
        
        // Example 2: Select specific columns
        DatabaseManager.executeAndPrintQuery(
            "SELECT first_name, last_name, email FROM customers",
            "Example 2: Select specific columns"
        );
        
        // Example 3: Using WHERE clause
        DatabaseManager.executeAndPrintQuery(
            "SELECT * FROM customers WHERE country = 'USA'",
            "Example 3: Filter records with WHERE clause"
        );
        
        // Example 4: Using comparison operators
        DatabaseManager.executeAndPrintQuery(
            "SELECT product_name, price FROM products WHERE price > 100",
            "Example 4: Using comparison operators (price > 100)"
        );
        
        // Example 5: Using LIKE for pattern matching
        DatabaseManager.executeAndPrintQuery(
            "SELECT * FROM employees WHERE email LIKE '%company.com'",
            "Example 5: Pattern matching with LIKE"
        );
    }
}
