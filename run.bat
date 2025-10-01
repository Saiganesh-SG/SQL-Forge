@echo off
REM SQL-Forge Quick Start Script for Windows

echo ==================================
echo    SQL-Forge Quick Start
echo ==================================
echo.

REM Check if Maven is installed
where mvn >nul 2>&1
if %errorlevel% neq 0 (
    echo [X] Maven is not installed. Please install Maven first.
    echo     Visit: https://maven.apache.org/install.html
    exit /b 1
)

REM Check if Java is installed
where java >nul 2>&1
if %errorlevel% neq 0 (
    echo [X] Java is not installed. Please install Java 11 or higher.
    echo     Visit: https://adoptium.net/
    exit /b 1
)

echo [OK] Maven found
echo [OK] Java found
echo.

REM Build the project if target directory doesn't exist
if not exist "target\classes" (
    echo Building the project...
    call mvn clean compile
    echo.
)

REM Run the application
echo Starting SQL-Forge...
echo.
call mvn exec:java
