package com.sqlforge.lessons;

import com.sqlforge.util.DatabaseManager;

/**
 * Lesson 3: Aggregate Functions
 * Learn COUNT, SUM, AVG, MIN, MAX, and GROUP BY
 */
public class Lesson03_AggregateFunctions {
    
    public static void run() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("LESSON 3: AGGREGATE FUNCTIONS");
        System.out.println("#".repeat(80));
        
        // Example 1: COUNT function
        DatabaseManager.executeAndPrintQuery(
            "SELECT COUNT(*) AS total_customers FROM customers",
            "Example 1: Count total number of customers"
        );
        
        // Example 2: SUM function
        DatabaseManager.executeAndPrintQuery(
            "SELECT SUM(salary) AS total_payroll FROM employees",
            "Example 2: Sum of all employee salaries"
        );
        
        // Example 3: AVG function
        DatabaseManager.executeAndPrintQuery(
            "SELECT AVG(salary) AS average_salary FROM employees",
            "Example 3: Average employee salary"
        );
        
        // Example 4: MIN and MAX functions
        DatabaseManager.executeAndPrintQuery(
            "SELECT MIN(price) AS cheapest, MAX(price) AS most_expensive FROM products",
            "Example 4: Find minimum and maximum product prices"
        );
        
        // Example 5: GROUP BY
        DatabaseManager.executeAndPrintQuery(
            "SELECT category, COUNT(*) AS product_count FROM products GROUP BY category",
            "Example 5: Count products by category"
        );
        
        // Example 6: GROUP BY with aggregate function
        DatabaseManager.executeAndPrintQuery(
            "SELECT country, COUNT(*) AS customer_count FROM customers GROUP BY country",
            "Example 6: Count customers by country"
        );
        
        // Example 7: HAVING clause
        DatabaseManager.executeAndPrintQuery(
            "SELECT department_id, AVG(salary) AS avg_salary FROM employees GROUP BY department_id HAVING AVG(salary) > 70000",
            "Example 7: Departments with average salary > 70000"
        );
        
        // Example 8: Multiple aggregations
        DatabaseManager.executeAndPrintQuery(
            "SELECT category, COUNT(*) AS count, AVG(price) AS avg_price, SUM(stock_quantity) AS total_stock FROM products GROUP BY category",
            "Example 8: Multiple aggregations by category"
        );
    }
}
