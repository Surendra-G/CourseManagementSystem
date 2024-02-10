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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class add_admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField addadmin_fname;
	private JTextField addadmin_lname;
	private JTextField addadmin_email;
	private JTextField addadmin_course;
	private JTextField addadmin_age;
	private JTextField addadmin_gender;
	private JPasswordField addadmin_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_admin frame = new add_admin();
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
	public add_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 503);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(363, 26, 134, 37);
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
		lblNewLabel_1_1_2.setBounds(163, 255, 67, 21);
		contentPane.add(lblNewLabel_1_1_2);
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Age: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(533, 108, 52, 21);
		contentPane.add(lblNewLabel_1_2);
		
		
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Gender: ");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(513, 165, 62, 21);
		contentPane.add(lblNewLabel_1_1_3);
		
		
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Password: ");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_4.setBounds(146, 307, 95, 21);
		contentPane.add(lblNewLabel_1_1_4);
		
		
		
		JButton btnNewButton = new JButton("Add ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstNameText = addadmin_fname.getText();
                String lastNameText = addadmin_lname.getText();
                String genderSelectionText = addadmin_gender.getText();
                String ageText = addadmin_age.getText().trim();
                String courseText = addadmin_course.getText();
                String emailText = addadmin_email.getText();
                String passwordText = new String(addadmin_password.getPassword());
                
                String regexFN = "^[A-Z][a-z]+";
                Pattern Fname = Pattern.compile(regexFN);

                Matcher FN = Fname.matcher(firstNameText);
                boolean fname = FN.matches();

                String regexLN = "^[A-Z][a-z]+";
                Pattern Lname = Pattern.compile(regexLN);

                Matcher LN = Lname.matcher(lastNameText);
                boolean lname = LN.matches();

                String regexEm = "^[a-z]+[0-9]+[@][a-z]+[.][a-z]{3,7}";
                Pattern EmailRegex = Pattern.compile(regexEm);

                Matcher EmailMatch = EmailRegex.matcher(emailText);
                boolean Emailcheck = EmailMatch.matches();

                String regexP = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$#])[A-Za-z\\d@$#]{8,}$";
                Pattern passN = Pattern.compile(regexP);

                Matcher pN = passN.matcher(passwordText);
                boolean password = pN.matches();

                System.out.println("fname: " + fname);
                System.out.println("lname: " + lname);
                System.out.println("Selected Gender: " + genderSelectionText);
                System.out.println("Age: " + ageText);
                System.out.println("Course: " + courseText);
                System.out.println("Emailcheck: " + Emailcheck);
                System.out.println("password: " + password);
                
                if (firstNameText.isEmpty() || lastNameText.isEmpty() || genderSelectionText.isEmpty() || ageText.isEmpty()
                    	||	courseText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill up all the fields to sign up.");
                        return;
                    }

                    if (!firstNameText.equals("") && !lastNameText.equals("") && !genderSelectionText.isEmpty()
                            && !ageText.equals("") && !courseText.equals("") && !emailText.equals("") && !passwordText.equals("")) {
                        if (fname && lname && Emailcheck && password ) {
                            JOptionPane.showMessageDialog(null, "Admin Added Successfully");
                            dispose();
                            Students stud = new Students();
                            stud.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Input. Please check the Entered Values.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please fill up all the fields to sign up.");
                    }

                    int age;
                    try {
                        age = Integer.parseInt(ageText);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid integer for age.");
                        return;
                    }
                    
                    try (Connection connection = database.getConnection()) {
                            String insertUserQuery = "INSERT INTO Admin (FirstName, LastName, Gender, Age, Course, Email, Password, UserType) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        
                        

                        try (PreparedStatement statement = connection.prepareStatement(insertUserQuery)) {
                            statement.setString(1, firstNameText);
                            statement.setString(2, lastNameText);
                            statement.setString(3, genderSelectionText);
                            statement.setInt(4, age);
                            statement.setString(5, courseText);
                            statement.setString(6, emailText);
                            statement.setString(7, passwordText);
                            statement.setString(8, "Admin");
                            statement.executeUpdate();
                            
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());

                    }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(302, 372, 134, 42);
		contentPane.add(btnNewButton);
		
		addadmin_fname = new JTextField();
		addadmin_fname.setBounds(228, 108, 224, 31);
		contentPane.add(addadmin_fname);
		addadmin_fname.setColumns(10);
		
		addadmin_lname = new JTextField();
		addadmin_lname.setColumns(10);
		addadmin_lname.setBounds(228, 156, 224, 31);
		contentPane.add(addadmin_lname);
		
		addadmin_email = new JTextField();
		addadmin_email.setColumns(10);
		addadmin_email.setBounds(228, 204, 224, 31);
		contentPane.add(addadmin_email);
		
		addadmin_course = new JTextField();
		addadmin_course.setColumns(10);
		addadmin_course.setBounds(228, 252, 224, 31);
		contentPane.add(addadmin_course);
		
		addadmin_age = new JTextField();
		addadmin_age.setColumns(10);
		addadmin_age.setBounds(572, 105, 121, 31);
		contentPane.add(addadmin_age);
		
		addadmin_gender = new JTextField();
		addadmin_gender.setColumns(10);
		addadmin_gender.setBounds(573, 159, 121, 31);
		contentPane.add(addadmin_gender);
		
		addadmin_password = new JPasswordField();
		addadmin_password.setBounds(228, 310, 224, 31);
		contentPane.add(addadmin_password);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin ad = new Admin();
				ad.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(496, 372, 134, 42);
		contentPane.add(btnCancel);
	}

}
