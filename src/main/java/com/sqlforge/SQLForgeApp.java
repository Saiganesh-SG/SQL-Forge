package com.sqlforge;

import com.sqlforge.lessons.*;
import com.sqlforge.util.DatabaseManager;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * SQL Forge - Interactive MySQL Learning Application
 * Learn SQL from basic to advanced concepts with hands-on examples
 */
public class SQLForgeApp {
    
    public static void main(String[] args) {
        try {
            // Initialize the database
            System.out.println("\n" + "=".repeat(80));
            System.out.println("                           WELCOME TO SQL FORGE");
            System.out.println("                    Your Interactive MySQL Learning Platform");
            System.out.println("=".repeat(80));
            
            DatabaseManager.initialize();
            
            // Interactive menu
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            
            while (running) {
                displayMenu();
                System.out.print("\nEnter your choice (0-7): ");
                
                String input = scanner.nextLine().trim();
                System.out.println();
                
                switch (input) {
                    case "1":
                        Lesson01_BasicSelect.run();
                        break;
                    case "2":
                        Lesson02_SortingAndFiltering.run();
                        break;
                    case "3":
                        Lesson03_AggregateFunctions.run();
                        break;
                    case "4":
                        Lesson04_Joins.run();
                        break;
                    case "5":
                        Lesson05_Subqueries.run();
                        break;
                    case "6":
                        Lesson06_DataManipulation.run();
                        // Reset database after data manipulation lesson
                        DatabaseManager.reset();
                        break;
                    case "7":
                        runAllLessons();
                        DatabaseManager.reset();
                        break;
                    case "0":
                        running = false;
                        System.out.println("Thank you for using SQL Forge! Happy Learning!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                
                if (running && !input.equals("0")) {
                    System.out.println("\n" + "=".repeat(80));
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                }
            }
            
            scanner.close();
            DatabaseManager.close();
            
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Application error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                              LESSON MENU");
        System.out.println("=".repeat(80));
        System.out.println("1. Lesson 1: Basic SELECT Statements");
        System.out.println("2. Lesson 2: Sorting and Advanced Filtering");
        System.out.println("3. Lesson 3: Aggregate Functions (COUNT, SUM, AVG, GROUP BY)");
        System.out.println("4. Lesson 4: JOINS (INNER, LEFT, Multiple Tables)");
        System.out.println("5. Lesson 5: Subqueries (Nested Queries)");
        System.out.println("6. Lesson 6: Data Manipulation (INSERT, UPDATE, DELETE)");
        System.out.println("7. Run All Lessons");
        System.out.println("0. Exit");
        System.out.println("=".repeat(80));
    }
    
    private static void runAllLessons() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("                        RUNNING ALL LESSONS");
        System.out.println("#".repeat(80));
        
        Lesson01_BasicSelect.run();
        Lesson02_SortingAndFiltering.run();
        Lesson03_AggregateFunctions.run();
        Lesson04_Joins.run();
        Lesson05_Subqueries.run();
        Lesson06_DataManipulation.run();
        
        System.out.println("\n" + "#".repeat(80));
        System.out.println("                    ALL LESSONS COMPLETED!");
        System.out.println("#".repeat(80));
    }
}
