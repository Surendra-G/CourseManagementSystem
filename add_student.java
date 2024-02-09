package FinalPortfolio;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class add_student extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField addstudent_fname;
	private JTextField addstudent_lname;
	private JTextField addstudent_email;
	private JTextField addstudent_course;
	private JTextField addstudent_age;
	private JTextField addstudent_gender;
	private JPasswordField addstudent_password;
	private JTextField chckbxNewCheckBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_student frame = new add_student();
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
	public add_student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(342, 23, 134, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(135, 108, 95, 21);
		contentPane.add(lblNewLabel_1);
		
		addstudent_fname = new JTextField();
		addstudent_fname.setBounds(240, 106, 236, 30);
		contentPane.add(addstudent_fname);
		addstudent_fname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(135, 159, 95, 21);
		contentPane.add(lblNewLabel_1_1);
		
		addstudent_lname = new JTextField();
		addstudent_lname.setColumns(10);
		addstudent_lname.setBounds(240, 157, 236, 30);
		contentPane.add(addstudent_lname);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("E-mail: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(163, 207, 68, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		addstudent_email = new JTextField();
		addstudent_email.setColumns(10);
		addstudent_email.setBounds(240, 205, 236, 30);
		contentPane.add(addstudent_email);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Course: ");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(163, 255, 67, 21);
		contentPane.add(lblNewLabel_1_1_2);
		
		addstudent_course = new JTextField();
		addstudent_course.setColumns(10);
		addstudent_course.setBounds(240, 253, 236, 30);
		contentPane.add(addstudent_course);
		
		JLabel lblNewLabel_1_2 = new JLabel("Age: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(533, 108, 52, 21);
		contentPane.add(lblNewLabel_1_2);
		
		addstudent_age = new JTextField();
		addstudent_age.setColumns(10);
		addstudent_age.setBounds(579, 106, 75, 30);
		contentPane.add(addstudent_age);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Gender: ");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(513, 165, 62, 21);
		contentPane.add(lblNewLabel_1_1_3);
		
		addstudent_gender = new JTextField();
		addstudent_gender.setColumns(10);
		addstudent_gender.setBounds(579, 157, 95, 30);
		contentPane.add(addstudent_gender);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Password: ");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_4.setBounds(146, 307, 95, 21);
		contentPane.add(lblNewLabel_1_1_4);
		
		addstudent_password = new JPasswordField();
		addstudent_password.setBounds(240, 305, 236, 30);
		contentPane.add(addstudent_password);
		
		JButton btnNewButton = new JButton("Add ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstNameText = addstudent_fname.getText();
                String lastNameText = addstudent_lname.getText();
                String genderSelectionText = addstudent_gender.getText();
                String ageText = addstudent_age.getText().trim();
                String courseText = addstudent_course.getText();
                String emailText = addstudent_email.getText();
                String passwordText = new String(addstudent_password.getPassword());
                
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
                            JOptionPane.showMessageDialog(null, "Student Added Successfully");
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
                            String insertUserQuery = "INSERT INTO Students (FirstName, LastName, Gender, Age, Course, Email, Password, UserType) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        
                        

                        try (PreparedStatement statement = connection.prepareStatement(insertUserQuery)) {
                            statement.setString(1, firstNameText);
                            statement.setString(2, lastNameText);
                            statement.setString(3, genderSelectionText);
                            statement.setInt(4, age);
                            statement.setString(5, courseText);
                            statement.setString(6, emailText);
                            statement.setString(7, passwordText);
                            statement.setString(8, "Student");
                            statement.executeUpdate();
                            
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());

                    }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(391, 370, 134, 42);
		contentPane.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("show");
		chckbxNewCheckBox.setBounds(482, 309, 93, 21);
		contentPane.add(chckbxNewCheckBox);
		
		
		chckbxNewCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxNewCheckBox.isSelected()) {
                	addstudent_password.setEchoChar((char) 0);
                } else {
                	addstudent_password.setEchoChar('*');
                }
            }
        });
	
	}
}
