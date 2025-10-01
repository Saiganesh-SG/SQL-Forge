package com.sqlforge.lessons;

import com.sqlforge.util.DatabaseManager;

/**
 * Lesson 5: Subqueries
 * Learn subqueries in WHERE, FROM, and SELECT clauses
 */
public class Lesson05_Subqueries {
    
    public static void run() {
        System.out.println("\n" + "#".repeat(80));
        System.out.println("LESSON 5: SUBQUERIES");
        System.out.println("#".repeat(80));
        
        // Example 1: Subquery in WHERE clause
        DatabaseManager.executeAndPrintQuery(
            "SELECT first_name, last_name, salary " +
            "FROM employees " +
            "WHERE salary > (SELECT AVG(salary) FROM employees)",
            "Example 1: Employees earning above average salary"
        );
        
        // Example 2: Subquery with IN operator
        DatabaseManager.executeAndPrintQuery(
            "SELECT * FROM customers " +
            "WHERE customer_id IN (SELECT customer_id FROM orders WHERE total_amount > 500)",
            "Example 2: Customers who have placed orders over $500"
        );
        
        // Example 3: Subquery in FROM clause
        DatabaseManager.executeAndPrintQuery(
            "SELECT category, avg_price " +
            "FROM (SELECT category, AVG(price) AS avg_price FROM products GROUP BY category) AS cat_avg " +
            "WHERE avg_price > 100",
            "Example 3: Categories with average price > $100"
        );
        
        // Example 4: Correlated subquery
        DatabaseManager.executeAndPrintQuery(
            "SELECT e1.first_name, e1.last_name, e1.salary, e1.department_id " +
            "FROM employees e1 " +
            "WHERE salary = (SELECT MAX(salary) FROM employees e2 WHERE e2.department_id = e1.department_id)",
            "Example 4: Highest paid employee in each department"
        );
        
        // Example 5: Subquery with EXISTS
        DatabaseManager.executeAndPrintQuery(
            "SELECT first_name, last_name " +
            "FROM customers c " +
            "WHERE EXISTS (SELECT 1 FROM orders o WHERE o.customer_id = c.customer_id AND o.status = 'Completed')",
            "Example 5: Customers with at least one completed order"
        );
        
        // Example 6: Subquery in SELECT clause
        DatabaseManager.executeAndPrintQuery(
            "SELECT first_name, last_name, " +
            "(SELECT COUNT(*) FROM orders o WHERE o.customer_id = c.customer_id) AS order_count " +
            "FROM customers c",
            "Example 6: Customer list with order count"
        );
    }
}
