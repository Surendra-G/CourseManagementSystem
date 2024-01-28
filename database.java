package FinalPortfolio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {

    public static void main(String[] args) {
        // Database connection details
    	String url = "jdbc:mysql://127.0.0.1:3306/coursemanagementsystem";
        String username = "root";
        String password = "";

        // establish a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
