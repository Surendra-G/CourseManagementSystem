package FinalPortfolio;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/coursemanagementsystem";
        String username = "root";
        String password = "";

        // Create the database if it doesn't exist
        createDatabaseIfNotExists(url, username, password);

        return DriverManager.getConnection(url, username, password);
    }

    private static void createDatabaseIfNotExists(String url, String username, String password) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS coursemanagementsystem";
            try (PreparedStatement statement = connection.prepareStatement(createDatabaseQuery)) {
                statement.executeUpdate();
            }
            // Use the coursemanagementsystem database
            String useDatabaseQuery = "USE coursemanagementsystem";
            try (PreparedStatement statement = connection.prepareStatement(useDatabaseQuery)) {
                statement.executeUpdate();
            }
         // Creating the Students table if it doesn't exist in the database
            String createStudentsTableQuery = "CREATE TABLE IF NOT EXISTS Students ("
                    + "StudentID INT AUTO_INCREMENT PRIMARY KEY, "
                    + "FirstName VARCHAR(50) NOT NULL, "
                    + "LastName VARCHAR(50) NOT NULL, "
                    + "Gender ENUM('Male', 'Female', 'Other') NOT NULL, "
                    + "Age INT NOT NULL, "
                    + "Course VARCHAR(50) NOT NULL, "
                    + "Email VARCHAR(100) UNIQUE NOT NULL, "
                    + "Password VARCHAR(100) NOT NULL, "
                    + "UserType VARCHAR(20) NOT NULL DEFAULT 'Student')"; // Add UserType column
            try (PreparedStatement statement = connection.prepareStatement(createStudentsTableQuery)) {
                statement.executeUpdate();
            }

            // Creating the Teachers table if it doesn't exist in the database
            String createTeachersTableQuery = "CREATE TABLE IF NOT EXISTS Teachers ("
                    + "TeacherID INT AUTO_INCREMENT PRIMARY KEY, "
                    + "FirstName VARCHAR(50) NOT NULL, "
                    + "LastName VARCHAR(50) NOT NULL, "
                    + "Gender ENUM('Male', 'Female', 'Other') NOT NULL, "
                    + "Age INT NOT NULL, "
                    + "Course VARCHAR(50) NOT NULL, "
                    + "Email VARCHAR(100) UNIQUE NOT NULL, "
                    + "Password VARCHAR(100) NOT NULL, "
                    + "UserType VARCHAR(20) NOT NULL DEFAULT 'Teacher')"; // Add UserType column
            try (PreparedStatement statement = connection.prepareStatement(createTeachersTableQuery)) {
                statement.executeUpdate();
            }

            // Creating the Admin table if it doesn't exist in the database
            String createAdminTableQuery = "CREATE TABLE IF NOT EXISTS Admin ("
                    + "AdminID INT AUTO_INCREMENT PRIMARY KEY, "
                    + "FirstName VARCHAR(50) NOT NULL, "
                    + "LastName VARCHAR(50) NOT NULL, "
                    + "Gender ENUM('Male', 'Female', 'Other') NOT NULL, "
                    + "Age INT NOT NULL, "
                    + "Course VARCHAR(50) NOT NULL, "
                    + "Email VARCHAR(100) UNIQUE NOT NULL, "
                    + "Password VARCHAR(100) NOT NULL, "
                    + "UserType VARCHAR(20) NOT NULL DEFAULT 'Admin')"; // Add UserType column
            try (PreparedStatement statement = connection.prepareStatement(createAdminTableQuery)) {
                statement.executeUpdate();
            }
            
         // Creating the Admin table if it doesn't exist in the database
            String createCourseTableQuery = "CREATE TABLE IF NOT EXISTS Course ("
                    + "CourseID INT AUTO_INCREMENT PRIMARY KEY, "
                    + "Module VARCHAR(50) UNIQUE NOT NULL, "
                    + "CourseName VARCHAR(50) NOT NULL, "
                    + "Batch INT NOT NULL, "
                    + "Seats INT NOT NULL, "
                    + "Years INT NOT NULL)";
            try (PreparedStatement statement = connection.prepareStatement(createCourseTableQuery)) {
                statement.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
