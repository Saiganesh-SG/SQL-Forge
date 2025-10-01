# SQL-Forge Quick Start Guide

## What is SQL-Forge?

SQL-Forge is an interactive Java-based application designed to teach MySQL queries from basic to advanced concepts. It uses an in-memory H2 database with MySQL compatibility mode, so you don't need to install a separate database server!

## Prerequisites

- **Java 11 or higher** - [Download from Adoptium](https://adoptium.net/)
- **Maven 3.6 or higher** - [Download from Apache Maven](https://maven.apache.org/download.cgi)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Saiganesh-SG/SQL-Forge.git
   cd SQL-Forge
   ```

2. Build the project (first time only):
   ```bash
   mvn clean compile
   ```

## Running SQL-Forge

### Quick Start

**On Linux/Mac:**
```bash
./run.sh
```

**On Windows:**
```cmd
run.bat
```

### Using Maven Directly

```bash
mvn exec:java
```

## What You'll Learn

SQL-Forge includes 6 comprehensive lessons:

### Lesson 1: Basic SELECT Statements
- Selecting all columns vs specific columns
- Filtering with WHERE clause
- Comparison operators
- Pattern matching with LIKE

### Lesson 2: Sorting and Advanced Filtering
- ORDER BY (ascending and descending)
- LIMIT clause
- Complex WHERE conditions (AND, OR)
- BETWEEN and IN operators

### Lesson 3: Aggregate Functions
- COUNT, SUM, AVG, MIN, MAX
- GROUP BY clause
- HAVING clause for filtered aggregates

### Lesson 4: JOINS
- INNER JOIN
- LEFT JOIN
- Multi-table joins
- JOINs with WHERE and aggregates

### Lesson 5: Subqueries
- Subqueries in WHERE clause
- Subqueries with IN operator
- Subqueries in FROM clause
- Correlated subqueries
- EXISTS operator
- Subqueries in SELECT clause

### Lesson 6: Data Manipulation
- INSERT statements
- UPDATE statements
- DELETE statements
- Data modifications with calculations

## Sample Database Schema

The application uses a realistic business database with:

- **departments** - Company departments (Sales, Engineering, HR, Marketing)
- **employees** - Employee records with salaries and hire dates
- **customers** - Customer contact information from various countries
- **products** - Product catalog (Electronics and Furniture)
- **orders** - Customer orders with dates and statuses
- **order_items** - Individual items in each order

All data is automatically loaded on startup from `src/main/resources/schema.sql`.

## Customizing the Database

Want to add your own tables or data? Simply edit:

```
src/main/resources/schema.sql
```

The database will automatically use your changes on the next run!

## Tips for Learning

1. **Start with Lesson 1** and progress sequentially - each lesson builds on the previous one
2. **Read the queries carefully** - understand what each SQL statement is doing
3. **Examine the output** - see how the data is structured and filtered
4. **Experiment** - modify the lesson files to try your own queries
5. **Use "Run All Lessons"** to see a complete demonstration

## Example Usage

```
================================================================================
                           WELCOME TO SQL FORGE
                    Your Interactive MySQL Learning Platform
================================================================================
✓ Database initialized successfully with sample data

================================================================================
                              LESSON MENU
================================================================================
1. Lesson 1: Basic SELECT Statements
2. Lesson 2: Sorting and Advanced Filtering
3. Lesson 3: Aggregate Functions (COUNT, SUM, AVG, GROUP BY)
4. Lesson 4: JOINS (INNER, LEFT, Multiple Tables)
5. Lesson 5: Subqueries (Nested Queries)
6. Lesson 6: Data Manipulation (INSERT, UPDATE, DELETE)
7. Run All Lessons
0. Exit
================================================================================

Enter your choice (0-7):
```

## Troubleshooting

### "Maven is not installed"
Install Maven from https://maven.apache.org/install.html

### "Java is not installed"
Install Java 11+ from https://adoptium.net/

### Build fails
Try cleaning the project:
```bash
mvn clean
mvn compile
```

### Need help?
Open an issue on GitHub: https://github.com/Saiganesh-SG/SQL-Forge/issues

## Next Steps

After completing all lessons, you can:

1. **Modify the lessons** - Add your own SQL examples
2. **Create new lessons** - Follow the pattern in the `lessons` package
3. **Customize the database** - Add tables and data relevant to your learning goals
4. **Practice queries** - Use the DatabaseManager utilities in your own code

## License

MIT License - See [LICENSE](LICENSE) file for details.

---

**Happy SQL Learning!** 🎓✨
