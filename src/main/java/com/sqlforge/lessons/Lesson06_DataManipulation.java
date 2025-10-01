package com.sqlforge.lessons;

import com.sqlforge.util.DatabaseManager;

/**
 * Lesson 6: Data Manipulation (INSERT, UPDATE, DELETE)
 * Learn how to modify data in tables
 */
public class Lesson06_DataManipulation {
    
    public static void run() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("LESSON 6: DATA MANIPULATION (INSERT, UPDATE, DELETE)");
        System.out.println("#".repeat(80));
        
        // Example 1: INSERT a new customer
        DatabaseManager.executeUpdate(
            "INSERT INTO customers (customer_id, first_name, last_name, email, phone, city, country) " +
            "VALUES (6, 'Frank', 'Foster', 'frank.f@email.com', '555-0106', 'Paris', 'France')",
            "Example 1: Insert a new customer"
        );
        
        // Verify the insert
        DatabaseManager.executeAndPrintQuery(
            "SELECT * FROM customers WHERE customer_id = 6",
            "Verify: Show the newly inserted customer"
        );
        
        // Example 2: UPDATE a customer's information
        DatabaseManager.executeUpdate(
            "UPDATE customers SET city = 'Lyon', phone = '555-0107' WHERE customer_id = 6",
            "Example 2: Update customer information"
        );
        
        // Verify the update
        DatabaseManager.executeAndPrintQuery(
            "SELECT * FROM customers WHERE customer_id = 6",
            "Verify: Show the updated customer"
        );
        
        // Example 3: UPDATE with calculation
        DatabaseManager.executeUpdate(
            "UPDATE products SET price = price * 1.10 WHERE category = 'Electronics'",
            "Example 3: Increase all Electronics prices by 10%"
        );
        
        // Verify the update
        DatabaseManager.executeAndPrintQuery(
            "SELECT product_name, category, price FROM products WHERE category = 'Electronics'",
            "Verify: Show updated Electronics prices"
        );
        
        // Example 4: DELETE a record
        DatabaseManager.executeUpdate(
            "DELETE FROM customers WHERE customer_id = 6",
            "Example 4: Delete the test customer"
        );
        
        // Verify the delete
        DatabaseManager.executeAndPrintQuery(
            "SELECT COUNT(*) AS remaining_customers FROM customers",
            "Verify: Count remaining customers"
        );
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("NOTE: Database will be reset after this lesson to restore original data");
        System.out.println("=".repeat(80));
    }
}
