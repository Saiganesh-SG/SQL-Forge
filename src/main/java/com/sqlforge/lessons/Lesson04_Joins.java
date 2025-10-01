package com.sqlforge.lessons;

import com.sqlforge.util.DatabaseManager;

/**
 * Lesson 4: JOINS
 * Learn INNER JOIN, LEFT JOIN, RIGHT JOIN, and FULL JOIN
 */
public class Lesson04_Joins {
    
    public static void run() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("LESSON 4: JOINS");
        System.out.println("#".repeat(80));
        
        // Example 1: INNER JOIN
        DatabaseManager.executeAndPrintQuery(
            "SELECT e.first_name, e.last_name, d.department_name " +
            "FROM employees e INNER JOIN departments d ON e.department_id = d.department_id",
            "Example 1: INNER JOIN - Employees with their departments"
        );
        
        // Example 2: LEFT JOIN
        DatabaseManager.executeAndPrintQuery(
            "SELECT e.first_name, e.last_name, d.department_name " +
            "FROM employees e LEFT JOIN departments d ON e.department_id = d.department_id",
            "Example 2: LEFT JOIN - All employees with department info (if available)"
        );
        
        // Example 3: Multiple table join
        DatabaseManager.executeAndPrintQuery(
            "SELECT c.first_name, c.last_name, o.order_id, o.order_date, o.total_amount " +
            "FROM customers c INNER JOIN orders o ON c.customer_id = o.customer_id " +
            "ORDER BY o.order_date",
            "Example 3: Customers with their orders"
        );
        
        // Example 4: Three table join
        DatabaseManager.executeAndPrintQuery(
            "SELECT o.order_id, c.first_name, c.last_name, p.product_name, oi.quantity, oi.price " +
            "FROM orders o " +
            "INNER JOIN customers c ON o.customer_id = c.customer_id " +
            "INNER JOIN order_items oi ON o.order_id = oi.order_id " +
            "INNER JOIN products p ON oi.product_id = p.product_id " +
            "ORDER BY o.order_id",
            "Example 4: Order details with customer and product information"
        );
        
        // Example 5: JOIN with WHERE clause
        DatabaseManager.executeAndPrintQuery(
            "SELECT e.first_name, e.last_name, e.salary, d.department_name " +
            "FROM employees e INNER JOIN departments d ON e.department_id = d.department_id " +
            "WHERE e.salary > 75000 " +
            "ORDER BY e.salary DESC",
            "Example 5: High-earning employees with department info"
        );
        
        // Example 6: JOIN with aggregate functions
        DatabaseManager.executeAndPrintQuery(
            "SELECT d.department_name, COUNT(*) AS employee_count, AVG(e.salary) AS avg_salary " +
            "FROM employees e INNER JOIN departments d ON e.department_id = d.department_id " +
            "GROUP BY d.department_name",
            "Example 6: Employee count and average salary by department"
        );
    }
}
