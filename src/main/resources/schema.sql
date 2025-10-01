-- SQL Forge Database Schema
-- This script initializes the in-memory database with sample data for learning SQL

-- Drop tables if they exist (for clean restarts)
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

-- Create Departments table
CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    location VARCHAR(100)
);

-- Create Employees table
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    department_id INT,
    salary DECIMAL(10, 2),
    hire_date DATE,
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

-- Create Customers table
CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    city VARCHAR(50),
    country VARCHAR(50)
);

-- Create Products table
CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    price DECIMAL(10, 2),
    stock_quantity INT
);

-- Create Orders table
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    total_amount DECIMAL(10, 2),
    status VARCHAR(20),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Create Order Items table
CREATE TABLE order_items (
    order_item_id INT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    price DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- Insert sample data into Departments
INSERT INTO departments VALUES (1, 'Sales', 'New York');
INSERT INTO departments VALUES (2, 'Engineering', 'San Francisco');
INSERT INTO departments VALUES (3, 'HR', 'Chicago');
INSERT INTO departments VALUES (4, 'Marketing', 'Los Angeles');

-- Insert sample data into Employees
INSERT INTO employees VALUES (1, 'John', 'Doe', 'john.doe@company.com', 1, 75000.00, '2020-01-15');
INSERT INTO employees VALUES (2, 'Jane', 'Smith', 'jane.smith@company.com', 2, 95000.00, '2019-03-22');
INSERT INTO employees VALUES (3, 'Mike', 'Johnson', 'mike.j@company.com', 2, 85000.00, '2021-06-10');
INSERT INTO employees VALUES (4, 'Emily', 'Brown', 'emily.b@company.com', 3, 65000.00, '2020-08-05');
INSERT INTO employees VALUES (5, 'David', 'Wilson', 'david.w@company.com', 1, 70000.00, '2022-02-14');
INSERT INTO employees VALUES (6, 'Sarah', 'Davis', 'sarah.d@company.com', 4, 72000.00, '2021-11-20');

-- Insert sample data into Customers
INSERT INTO customers VALUES (1, 'Alice', 'Anderson', 'alice.a@email.com', '555-0101', 'Boston', 'USA');
INSERT INTO customers VALUES (2, 'Bob', 'Baker', 'bob.b@email.com', '555-0102', 'Seattle', 'USA');
INSERT INTO customers VALUES (3, 'Carol', 'Clark', 'carol.c@email.com', '555-0103', 'Toronto', 'Canada');
INSERT INTO customers VALUES (4, 'Daniel', 'Davis', 'daniel.d@email.com', '555-0104', 'London', 'UK');
INSERT INTO customers VALUES (5, 'Eva', 'Evans', 'eva.e@email.com', '555-0105', 'Sydney', 'Australia');

-- Insert sample data into Products
INSERT INTO products VALUES (1, 'Laptop', 'Electronics', 999.99, 50);
INSERT INTO products VALUES (2, 'Mouse', 'Electronics', 29.99, 200);
INSERT INTO products VALUES (3, 'Keyboard', 'Electronics', 79.99, 150);
INSERT INTO products VALUES (4, 'Monitor', 'Electronics', 299.99, 75);
INSERT INTO products VALUES (5, 'Desk Chair', 'Furniture', 199.99, 30);
INSERT INTO products VALUES (6, 'Desk', 'Furniture', 399.99, 20);

-- Insert sample data into Orders
INSERT INTO orders VALUES (1, 1, '2024-01-10', 1079.98, 'Completed');
INSERT INTO orders VALUES (2, 2, '2024-01-15', 329.98, 'Completed');
INSERT INTO orders VALUES (3, 3, '2024-01-20', 999.99, 'Shipped');
INSERT INTO orders VALUES (4, 1, '2024-02-01', 599.98, 'Processing');
INSERT INTO orders VALUES (5, 4, '2024-02-05', 709.97, 'Completed');

-- Insert sample data into Order Items
INSERT INTO order_items VALUES (1, 1, 1, 1, 999.99);
INSERT INTO order_items VALUES (2, 1, 3, 1, 79.99);
INSERT INTO order_items VALUES (3, 2, 4, 1, 299.99);
INSERT INTO order_items VALUES (4, 2, 2, 1, 29.99);
INSERT INTO order_items VALUES (5, 3, 1, 1, 999.99);
INSERT INTO order_items VALUES (6, 4, 5, 3, 199.99);
INSERT INTO order_items VALUES (7, 5, 3, 2, 79.99);
INSERT INTO order_items VALUES (8, 5, 2, 1, 29.99);
INSERT INTO order_items VALUES (9, 5, 6, 1, 399.99);
