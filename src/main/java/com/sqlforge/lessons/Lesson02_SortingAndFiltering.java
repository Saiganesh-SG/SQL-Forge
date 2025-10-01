package com.sqlforge.lessons;

import com.sqlforge.util.DatabaseManager;

/**
 * Lesson 2: Sorting and Advanced Filtering
 * Learn ORDER BY, LIMIT, and complex WHERE conditions
 */
public class Lesson02_SortingAndFiltering {
    
    public static void run() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("LESSON 2: SORTING AND ADVANCED FILTERING");
        System.out.println("#".repeat(80));
        
        // Example 1: ORDER BY ascending
        DatabaseManager.executeAndPrintQuery(
            "SELECT first_name, last_name, salary FROM employees ORDER BY salary ASC",
            "Example 1: Sort by salary (ascending)"
        );
        
        // Example 2: ORDER BY descending
        DatabaseManager.executeAndPrintQuery(
            "SELECT first_name, last_name, salary FROM employees ORDER BY salary DESC",
            "Example 2: Sort by salary (descending)"
        );
        
        // Example 3: LIMIT clause
        DatabaseManager.executeAndPrintQuery(
            "SELECT first_name, last_name, salary FROM employees ORDER BY salary DESC LIMIT 3",
            "Example 3: Top 3 highest paid employees"
        );
        
        // Example 4: Multiple conditions with AND
        DatabaseManager.executeAndPrintQuery(
            "SELECT * FROM products WHERE category = 'Electronics' AND price < 500",
            "Example 4: Multiple conditions with AND"
        );
        
        // Example 5: Multiple conditions with OR
        DatabaseManager.executeAndPrintQuery(
            "SELECT * FROM customers WHERE country = 'USA' OR country = 'Canada'",
            "Example 5: Multiple conditions with OR"
        );
        
        // Example 6: BETWEEN operator
        DatabaseManager.executeAndPrintQuery(
            "SELECT product_name, price FROM products WHERE price BETWEEN 50 AND 300",
            "Example 6: Using BETWEEN operator"
        );
        
        // Example 7: IN operator
        DatabaseManager.executeAndPrintQuery(
            "SELECT * FROM customers WHERE country IN ('USA', 'UK', 'Australia')",
            "Example 7: Using IN operator"
        );
    }
}
