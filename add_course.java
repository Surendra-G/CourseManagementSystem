package FinalPortfolio;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class add_course extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField addcourse_module;
    private JTextField addcourse_coursename;
    private JTextField addcourse_batch;
    private JTextField addcourse_seats;
    private JTextField addcourse_years;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    add_course frame = new add_course();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public add_course() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 779, 503);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Add course");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(342, 23, 134, 37);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Module: ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(163, 103, 95, 21);
        contentPane.add(lblNewLabel_1);
        
        
        
        JLabel lblNewLabel_1_1 = new JLabel("Course Name: ");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(125, 148, 106, 21);
        contentPane.add(lblNewLabel_1_1);
        
        
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Batch:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1.setBounds(174, 190, 68, 21);
        contentPane.add(lblNewLabel_1_1_1);
        
        
        
        JLabel lblNewLabel_1_1_2 = new JLabel("No.of.Seats:");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_2.setBounds(137, 233, 94, 21);
        contentPane.add(lblNewLabel_1_1_2);
        
        
        
        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ModuleText = addcourse_module.getText();
                String courseNameText = addcourse_coursename.getText();
                String BatchText = addcourse_batch.getText();
                String seatText = addcourse_seats.getText();
                String yearText = addcourse_years.getText();

                System.out.println("ModuleName: " + ModuleText);
                System.out.println("COurseName: " + courseNameText);
                System.out.println("Batch: " + BatchText);
                System.out.println("Seats: " + seatText);
                System.out.println("Years: " + yearText);

                // Validate input
                if (ModuleText.isEmpty() || courseNameText.isEmpty() || BatchText.isEmpty() || seatText.isEmpty()
                        || yearText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up all the fields to sign up.");
                    return;
                }

                // Validate integer inputs
                int batch;
                int seats;
                int years;

                try {
                    batch = Integer.parseInt(BatchText);
                    seats = Integer.parseInt(seatText);
                    years = Integer.parseInt(yearText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid integer values for Batch, Seats, and Years.");
                    return;
                }

                // Course added successfully
                JOptionPane.showMessageDialog(null, "Course Added Successfully");
                dispose();
                Courses stud = new Courses();
                stud.setVisible(true);

                // Insert course into database
                try (Connection connection = database.getConnection()) {
                    String insertUserQuery = "INSERT INTO Course (Module, CourseName, Batch, Seats, Years) VALUES (?, ?, ?, ?, ?)";

                    try (PreparedStatement statement = connection.prepareStatement(insertUserQuery)) {
                        statement.setString(1, ModuleText);
                        statement.setString(2, courseNameText);
                        statement.setInt(3, batch);
                        statement.setInt(4, seats);
                        statement.setInt(5, years);
                        statement.executeUpdate();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(331, 322, 134, 42);
        contentPane.add(btnNewButton);
        
        addcourse_module = new JTextField();
        addcourse_module.setBounds(241, 103, 243, 26);
        contentPane.add(addcourse_module);
        addcourse_module.setColumns(10);
        
        addcourse_coursename = new JTextField();
        addcourse_coursename.setColumns(10);
        addcourse_coursename.setBounds(241, 143, 249, 26);
        contentPane.add(addcourse_coursename);
        
        addcourse_batch = new JTextField();
        addcourse_batch.setColumns(10);
        addcourse_batch.setBounds(241, 190, 249, 26);
        contentPane.add(addcourse_batch);
        
        addcourse_seats = new JTextField();
        addcourse_seats.setColumns(10);
        addcourse_seats.setBounds(241, 233, 249, 26);
        contentPane.add(addcourse_seats);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Years:");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1_1.setBounds(163, 268, 68, 21);
        contentPane.add(lblNewLabel_1_1_1_1);
        
        addcourse_years = new JTextField();
        addcourse_years.setColumns(10);
        addcourse_years.setBounds(241, 268, 249, 26);
        contentPane.add(addcourse_years);
    }
}
