@echo off
echo ================================
echo To-Do Management System Launcher
echo ================================
echo.

echo Checking Java installation...
java -version
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 17 or higher
    pause
    exit /b 1
)
echo.

echo Checking Maven installation...
call mvn -version
if %errorlevel% neq 0 (
    echo ERROR: Maven is not installed or not in PATH
    echo Please install Maven 3.6 or higher
    pause
    exit /b 1
)
echo.

echo Building the project...
call mvn clean install -DskipTests
if %errorlevel% neq 0 (
    echo ERROR: Build failed
    pause
    exit /b 1
)
echo.

echo ================================
echo Starting To-Do Management System
echo ================================
echo Application will be available at: http://localhost:8080
echo Press Ctrl+C to stop the application
echo.

call mvn spring-boot:run

pause
