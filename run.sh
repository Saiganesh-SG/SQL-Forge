#!/bin/bash

# SQL-Forge Quick Start Script

echo "=================================="
echo "   SQL-Forge Quick Start"
echo "=================================="
echo ""

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven is not installed. Please install Maven first."
    echo "   Visit: https://maven.apache.org/install.html"
    exit 1
fi

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "❌ Java is not installed. Please install Java 11 or higher."
    echo "   Visit: https://adoptium.net/"
    exit 1
fi

echo "✓ Maven found: $(mvn --version | head -1)"
echo "✓ Java found: $(java -version 2>&1 | head -1)"
echo ""

# Build the project if target directory doesn't exist
if [ ! -d "target/classes" ]; then
    echo "Building the project..."
    mvn clean compile
    echo ""
fi

# Run the application
echo "Starting SQL-Forge..."
echo ""
mvn exec:java
