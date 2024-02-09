package FinalPortfolio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class add_result extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField addresult_fname;
	private JTextField addresult_lname;
	private JTextField addresult_email;
	private JTextField addresult_course;
	private JTextField addresult_module;
	private JTextField addresult_marks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_result frame = new add_result();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public add_result() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Result");
		lblNewLabel.setBounds(292, 37, 134, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name: ");
		lblNewLabel_1.setBounds(135, 108, 95, 21);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name: ");
		lblNewLabel_1_1.setBounds(135, 159, 95, 21);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1_1);
		
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("E-mail: ");
		lblNewLabel_1_1_1.setBounds(163, 207, 68, 21);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1_1_1);
		
		
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Course: ");
		lblNewLabel_1_1_2.setBounds(163, 255, 67, 21);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1_1_2);
		
		
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Module:");
		lblNewLabel_1_1_3.setBounds(168, 306, 62, 21);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1_1_3);
		
		
		
		JButton btnNewButton = new JButton("Add ");
		btnNewButton.setBounds(315, 400, 134, 42);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = addresult_fname.getText();
				String lastName = addresult_lname.getText();
				String email = addresult_email.getText();
				String courseName = addresult_course.getText();
				String module = addresult_module.getText();
				String marksText = addresult_marks.getText();
				
				// Validate input
                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || courseName.isEmpty()
                        || module.isEmpty() || marksText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up all the add the result.");
                    return;
                }

                // Validate integer inputs
                int marks;

                try {
                	marks = Integer.parseInt(marksText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid integer values for Marks.");
                    return;
                }
                
             // Course added successfully
                JOptionPane.showMessageDialog(null, "Result Added Successfully");
                dispose();
                admin_result resforteach = new admin_result();
                resforteach.setVisible(true);

                // Insert course into database
                try (Connection connection = database.getConnection()) {
                    String insertUserQuery = "INSERT INTO Result (FirstName, LastName, Email, Module, CourseName, Marks) VALUES (?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement statement = connection.prepareStatement(insertUserQuery)) {
                        statement.setString(1, firstName);
                        statement.setString(2, lastName);
                        statement.setString(3, email);
                        statement.setString(4, module);
                        statement.setString(5, courseName);
                        statement.setInt(6, marks);
                        statement.executeUpdate();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());
                }

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Marks: ");
		lblNewLabel_1_1_3_1.setBounds(175, 347, 55, 21);
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1_1_3_1);
		
		addresult_fname = new JTextField();
		addresult_fname.setBounds(240, 102, 250, 30);
		contentPane.add(addresult_fname);
		addresult_fname.setColumns(10);
		
		addresult_lname = new JTextField();
		addresult_lname.setBounds(240, 150, 250, 30);
		addresult_lname.setColumns(10);
		contentPane.add(addresult_lname);
		
		addresult_email = new JTextField();
		addresult_email.setBounds(241, 198, 250, 30);
		addresult_email.setColumns(10);
		contentPane.add(addresult_email);
		
		addresult_course = new JTextField();
		addresult_course.setBounds(240, 253, 250, 30);
		addresult_course.setColumns(10);
		contentPane.add(addresult_course);
		
		addresult_module = new JTextField();
		addresult_module.setBounds(240, 300, 250, 30);
		addresult_module.setColumns(10);
		contentPane.add(addresult_module);
		
		addresult_marks = new JTextField();
		addresult_marks.setBounds(240, 345, 250, 30);
		addresult_marks.setColumns(10);
		contentPane.add(addresult_marks);
	}

}
