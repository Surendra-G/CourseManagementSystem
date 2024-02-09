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

public class edit_teacher extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField editteacher_fname;
	private JTextField editteacher_lname;
	private JTextField editteacher_email;
	private JTextField editteacher_course;
	private JTextField editteacher_age;
	private JTextField editteacher_gender;
	private JTextField editteacher_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_teacher frame = new edit_teacher();
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
	public edit_teacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Teacher");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(324, 23, 134, 37);
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
				String firstNameText = editteacher_fname.getText();
		        String lastNameText = editteacher_lname.getText();
		        String genderSelectionText = editteacher_gender.getText();
		        String ageText = editteacher_age.getText().trim();
		        String courseText = editteacher_course.getText();
		        String emailText = editteacher_email.getText();
		        String idText = editteacher_ID.getText();
		        
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
		            String updateUserQuery = "UPDATE Teachers SET FirstName = ?, LastName = ?, Gender = ?, Age = ?, Course = ?, Email = ? WHERE TeacherID = ?";
		            
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
		                    JOptionPane.showMessageDialog(null, "Teacher Updated Successfully");
		                    dispose();
		                    Teachers teach = new Teachers();
		                    teach.setVisible(true);
		                } else {
		                    JOptionPane.showMessageDialog(null, "Failed to update Teacher details.");
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
		
		editteacher_fname = new JTextField();
		editteacher_fname.setBounds(225, 108, 231, 26);
		contentPane.add(editteacher_fname);
		editteacher_fname.setColumns(10);
		
		editteacher_lname = new JTextField();
		editteacher_lname.setColumns(10);
		editteacher_lname.setBounds(225, 154, 231, 26);
		contentPane.add(editteacher_lname);
		
		editteacher_email = new JTextField();
		editteacher_email.setColumns(10);
		editteacher_email.setBounds(227, 202, 231, 26);
		contentPane.add(editteacher_email);
		
		editteacher_course = new JTextField();
		editteacher_course.setColumns(10);
		editteacher_course.setBounds(225, 264, 231, 26);
		contentPane.add(editteacher_course);
		
		editteacher_age = new JTextField();
		editteacher_age.setColumns(10);
		editteacher_age.setBounds(570, 108, 115, 26);
		contentPane.add(editteacher_age);
		
		editteacher_gender = new JTextField();
		editteacher_gender.setColumns(10);
		editteacher_gender.setBounds(570, 159, 115, 26);
		contentPane.add(editteacher_gender);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("ID:");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3_1.setBounds(540, 207, 35, 21);
		contentPane.add(lblNewLabel_1_1_3_1);
		
		editteacher_ID = new JTextField();
		editteacher_ID.setColumns(10);
		editteacher_ID.setBounds(570, 202, 115, 26);
		contentPane.add(editteacher_ID);
		
		
	}

}
