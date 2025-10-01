# SQL-Forge

🔧 **Your Interactive MySQL Learning Platform**

SQL-Forge is a Java-based educational application designed to help you learn MySQL from basic to advanced concepts through hands-on examples. It uses an in-memory H2 database with MySQL compatibility mode, allowing you to practice SQL queries without setting up a separate database server.

## 📚 Features

- **In-Memory Database**: Uses H2 database with MySQL compatibility mode - no installation required
- **Centralized Schema Management**: All database tables and sample data defined in a single `schema.sql` file
- **Progressive Learning**: 6 lessons covering SQL fundamentals to advanced topics
- **Hands-On Examples**: Each lesson includes multiple practical examples with output
- **Interactive Menu**: Choose which lessons to run or execute all at once
- **Auto-Reset**: Database automatically resets after data manipulation to maintain consistency

## 📖 Lessons Covered

1. **Basic SELECT Statements** - Learn to retrieve data from tables
2. **Sorting and Advanced Filtering** - Master ORDER BY, LIMIT, and complex WHERE conditions
3. **Aggregate Functions** - Work with COUNT, SUM, AVG, MIN, MAX, and GROUP BY
4. **JOINS** - Understand INNER JOIN, LEFT JOIN, and multi-table relationships
5. **Subqueries** - Learn nested queries and correlated subqueries
6. **Data Manipulation** - Practice INSERT, UPDATE, and DELETE operations

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Building the Project

```bash
# Clone the repository
git clone https://github.com/Saiganesh-SG/SQL-Forge.git
cd SQL-Forge

# Build the project
mvn clean compile
```

### Running the Application

```bash
# Run using Maven
mvn exec:java

# Or build and run the JAR
mvn package
java -jar target/sql-forge-1.0-SNAPSHOT.jar
```

## 📊 Database Schema

The application uses a sample business database with the following tables:

- **departments** - Company departments
- **employees** - Employee information with department relationships
- **customers** - Customer contact information
- **products** - Product catalog with categories and prices
- **orders** - Customer orders
- **order_items** - Individual items in each order

All schema definitions and sample data are in `src/main/resources/schema.sql` - you can modify this file to customize the learning environment.

## 🎯 How to Use

1. **Start the Application**: Run `mvn exec:java`
2. **Choose a Lesson**: Select from the menu (1-6) or run all lessons (7)
3. **Review Output**: Each query is displayed with its results in a formatted table
4. **Learn by Example**: Study the queries and their outputs to understand SQL concepts
5. **Modify and Experiment**: Edit the lesson files to try your own queries

## 🛠️ Project Structure

```
SQL-Forge/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── sqlforge/
│   │   │           ├── SQLForgeApp.java          # Main application
│   │   │           ├── lessons/                   # Lesson classes
│   │   │           │   ├── Lesson01_BasicSelect.java
│   │   │           │   ├── Lesson02_SortingAndFiltering.java
│   │   │           │   ├── Lesson03_AggregateFunctions.java
│   │   │           │   ├── Lesson04_Joins.java
│   │   │           │   ├── Lesson05_Subqueries.java
│   │   │           │   └── Lesson06_DataManipulation.java
│   │   │           └── util/
│   │   │               └── DatabaseManager.java   # Database utilities
│   │   └── resources/
│   │       └── schema.sql                         # Centralized DB schema
│   └── test/
│       └── java/                                  # Test files
├── pom.xml                                        # Maven configuration
└── README.md                                      # This file
```

## 🔧 Customization

### Modifying the Database Schema

Edit `src/main/resources/schema.sql` to:
- Add new tables
- Modify existing table structures
- Change sample data
- Add more realistic datasets

The database will automatically use your updated schema on the next run.

### Adding New Lessons

1. Create a new class in `src/main/java/com/sqlforge/lessons/`
2. Follow the pattern of existing lessons
3. Use `DatabaseManager.executeAndPrintQuery()` for SELECT queries
4. Use `DatabaseManager.executeUpdate()` for INSERT/UPDATE/DELETE
5. Add your lesson to the menu in `SQLForgeApp.java`

## 🤝 Contributing

Contributions are welcome! Feel free to:
- Add new lessons
- Improve existing examples
- Enhance the database schema
- Fix bugs or improve documentation

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Built with [H2 Database](https://www.h2database.com/) for in-memory MySQL compatibility
- Designed for educational purposes to help learners master SQL

---

**Happy Learning!** 🎓✨