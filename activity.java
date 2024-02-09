package FinalPortfolio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class activity {

    public static void Activity() {
    	String url = "jdbc:mysql://127.0.0.1:3306/coursemanagementsystem";
        String username = "root";
        String password = "";
        String email = login_page.mail();
        String user = login_page.comboVal();

        try (Connection connection = database.getConnection()) {
            // Get current time
            String time = currentTime();

            // Define activity message
            String activity = "logged in by: '" + user + "', email: '" + email + "' at '" + time + "'";

            // Create SQL query to insert activity
            String inserting = "INSERT INTO Activity (Activities) VALUES (?)";
            try (PreparedStatement pstmt = connection.prepareStatement(inserting)) {
                pstmt.setString(1, activity);
                pstmt.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static String currentTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }
}
