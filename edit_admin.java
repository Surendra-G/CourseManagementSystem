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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class edit_admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField editadmin_fname;
	private JTextField editadmin_lname;
	private JTextField editadmin_email;
	private JTextField editadmin_course;
	private JTextField editadmin_age;
	private JTextField editadmin_gender;
	private JTextField editadmin_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_admin frame = new edit_admin();
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
	public edit_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 503);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Admin");
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
				String firstNameText = editadmin_fname.getText();
		        String lastNameText = editadmin_lname.getText();
		        String genderSelectionText = editadmin_gender.getText();
		        String ageText = editadmin_age.getText().trim();
		        String courseText = editadmin_course.getText();
		        String emailText = editadmin_email.getText();
		        String idText = editadmin_ID.getText();
		        
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
		        
		        
		        
		        // Update admin details in the database
		        try (Connection connection = database.getConnection()) {
		            String updateUserQuery = "UPDATE Admin SET FirstName = ?, LastName = ?, Gender = ?, Age = ?, Course = ?, Email = ? WHERE AdminID = ?";
		            
		            try (PreparedStatement statement = connection.prepareStatement(updateUserQuery)) {
		                statement.setString(1, firstNameText);
		                statement.setString(2, lastNameText);
		                statement.setString(3, genderSelectionText);
		                statement.setInt(4, age);
		                statement.setString(5, courseText);
		                statement.setString(6, emailText);
		                statement.setInt(7, id); // Assuming AdminID is the ID field for admin
		                
		                int rowsAffected = statement.executeUpdate();
		                
		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(null, "Admin Updated Successfully");
		                    dispose();
		                    Students stud = new Students();
		                    stud.setVisible(true);
		                } else {
		                    JOptionPane.showMessageDialog(null, "Failed to update admin details.");
		                }
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(292, 330, 134, 42);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("ID:");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3_1.setBounds(545, 213, 30, 21);
		contentPane.add(lblNewLabel_1_1_3_1);
		
		editadmin_fname = new JTextField();
		editadmin_fname.setBounds(240, 108, 222, 31);
		contentPane.add(editadmin_fname);
		editadmin_fname.setColumns(10);
		
		editadmin_lname = new JTextField();
		editadmin_lname.setColumns(10);
		editadmin_lname.setBounds(240, 156, 222, 31);
		contentPane.add(editadmin_lname);
		
		editadmin_email = new JTextField();
		editadmin_email.setColumns(10);
		editadmin_email.setBounds(241, 204, 222, 31);
		contentPane.add(editadmin_email);
		
		editadmin_course = new JTextField();
		editadmin_course.setColumns(10);
		editadmin_course.setBounds(240, 261, 222, 31);
		contentPane.add(editadmin_course);
		
		editadmin_age = new JTextField();
		editadmin_age.setColumns(10);
		editadmin_age.setBounds(577, 105, 87, 31);
		contentPane.add(editadmin_age);
		
		editadmin_gender = new JTextField();
		editadmin_gender.setColumns(10);
		editadmin_gender.setBounds(577, 162, 101, 31);
		contentPane.add(editadmin_gender);
		
		editadmin_ID = new JTextField();
		editadmin_ID.setColumns(10);
		editadmin_ID.setBounds(577, 210, 87, 31);
		contentPane.add(editadmin_ID);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin ad = new Admin();
				ad.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(480, 330, 134, 42);
		contentPane.add(btnCancel);
		
		
	}

}
