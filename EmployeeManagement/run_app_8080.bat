@echo off
REM Run Employee Management Application on Port 8080

cls
echo =====================================================
echo   Employee Management Application
echo =====================================================
echo.
echo Starting application on Port 8080...
echo.
echo Profile: dev (H2 Database)
echo Database: In-Memory H2
echo Access: http://localhost:8080
echo H2 Console: http://localhost:8080/h2-console
echo.
echo =====================================================
echo.

cd C:\Users\Rishabh\IdeaProjects\EmployeeManagement

mvn spring-boot:run

pause

