package FinalPortfolio;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class edit_student extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField editstudent_fname;
	private JTextField editstudent_lname;
	private JTextField editstudent_email;
	private JTextField editstudent_course;
	private JTextField editstudent_age;
	private JTextField editstudent_gender;
	private JTextField editstudent_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_student frame = new edit_student();
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
	public edit_student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(342, 23, 134, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(135, 108, 95, 21);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(135, 159, 95, 21);
		contentPane.add(lblNewLabel_1_1);
		
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("E-mail: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(163, 207, 68, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Course: ");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(163, 264, 67, 21);
		contentPane.add(lblNewLabel_1_1_2);
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Age: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(533, 108, 52, 21);
		contentPane.add(lblNewLabel_1_2);
		
		
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Gender: ");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(513, 165, 62, 21);
		contentPane.add(lblNewLabel_1_1_3);
		
		
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstNameText = editstudent_fname.getText();
		        String lastNameText = editstudent_lname.getText();
		        String genderSelectionText = editstudent_gender.getText();
		        String ageText = editstudent_age.getText().trim();
		        String courseText = editstudent_course.getText();
		        String emailText = editstudent_email.getText();
		        String idText = editstudent_ID.getText();
		        
		        // Check if all fields are filled
		        if (firstNameText.isEmpty() || lastNameText.isEmpty() || genderSelectionText.isEmpty() || ageText.isEmpty()
		            || courseText.isEmpty() || emailText.isEmpty() || idText.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill up all the fields to update.");
		            return;
		        }

		        // Perform input validation
		        if (!firstNameText.matches("^[A-Z][a-z]+") || !lastNameText.matches("^[A-Z][a-z]+") || !emailText.matches("^[a-z]+[0-9]+[@][a-z]+[.][a-z]{3,7}")) {
		            JOptionPane.showMessageDialog(null, "Invalid Input. Please check the entered values.");
		            return;
		        }

		        // Parse age to integer
		        int age;
		        try {
		            age = Integer.parseInt(ageText);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Please enter a valid integer for age.");
		            return;
		        }
		        
		     // Parse ID to integer
		        int id;
		        try {
		            id = Integer.parseInt(idText);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Please enter a valid integer for age.");
		            return;
		        }
		        
		        
		        
		        // Update Student details in the database
		        try (Connection connection = database.getConnection()) {
		            String updateUserQuery = "UPDATE Students SET FirstName = ?, LastName = ?, Gender = ?, Age = ?, Course = ?, Email = ? WHERE StudentID = ?";
		            
		            try (PreparedStatement statement = connection.prepareStatement(updateUserQuery)) {
		                statement.setString(1, firstNameText);
		                statement.setString(2, lastNameText);
		                statement.setString(3, genderSelectionText);
		                statement.setInt(4, age);
		                statement.setString(5, courseText);
		                statement.setString(6, emailText);
		                statement.setInt(7, id); 
		                
		                int rowsAffected = statement.executeUpdate();
		                
		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(null, "Student Updated Successfully");
		                    dispose();
		                    Students stud = new Students();
		                    stud.setVisible(true);
		                } else {
		                    JOptionPane.showMessageDialog(null, "Failed to update Student details.");
		                }
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(342, 330, 134, 42);
		contentPane.add(btnNewButton);
		
		editstudent_fname = new JTextField();
		editstudent_fname.setBounds(240, 105, 217, 31);
		contentPane.add(editstudent_fname);
		editstudent_fname.setColumns(10);
		
		editstudent_lname = new JTextField();
		editstudent_lname.setColumns(10);
		editstudent_lname.setBounds(240, 156, 217, 31);
		contentPane.add(editstudent_lname);
		
		editstudent_email = new JTextField();
		editstudent_email.setColumns(10);
		editstudent_email.setBounds(241, 204, 217, 31);
		contentPane.add(editstudent_email);
		
		editstudent_course = new JTextField();
		editstudent_course.setColumns(10);
		editstudent_course.setBounds(240, 261, 217, 31);
		contentPane.add(editstudent_course);
		
		editstudent_age = new JTextField();
		editstudent_age.setBounds(576, 105, 96, 32);
		contentPane.add(editstudent_age);
		editstudent_age.setColumns(10);
		
		editstudent_gender = new JTextField();
		editstudent_gender.setColumns(10);
		editstudent_gender.setBounds(576, 159, 96, 32);
		contentPane.add(editstudent_gender);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("ID:");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3_1.setBounds(545, 213, 30, 21);
		contentPane.add(lblNewLabel_1_1_3_1);
		
		editstudent_ID = new JTextField();
		editstudent_ID.setColumns(10);
		editstudent_ID.setBounds(576, 210, 96, 32);
		contentPane.add(editstudent_ID);
	}

}
