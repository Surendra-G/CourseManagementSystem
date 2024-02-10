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
import javax.swing.JCheckBox;

public class add_teacher extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField addteacher_fname;
	private JTextField addteacher_lname;
	private JTextField addteacher_email;
	private JTextField addteacher_course;
	private JTextField addteacher_age;
	private JTextField addteacher_gender;
	private JPasswordField addteacher_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_teacher frame = new add_teacher();
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
	public add_teacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 503);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Teachers");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(333, 23, 149, 37);
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
				String firstNameText = addteacher_fname.getText();
                String lastNameText = addteacher_lname.getText();
                String genderSelectionText = addteacher_gender.getText();
                String ageText = addteacher_age.getText().trim();
                String courseText = addteacher_course.getText();
                String emailText = addteacher_email.getText();
                String passwordText = new String(addteacher_password.getPassword());
                
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
                            JOptionPane.showMessageDialog(null, "Teacher Added Successfully");
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
                            String insertUserQuery = "INSERT INTO Teachers (FirstName, LastName, Gender, Age, Course, Email, Password, UserType) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        
                        

                        try (PreparedStatement statement = connection.prepareStatement(insertUserQuery)) {
                            statement.setString(1, firstNameText);
                            statement.setString(2, lastNameText);
                            statement.setString(3, genderSelectionText);
                            statement.setInt(4, age);
                            statement.setString(5, courseText);
                            statement.setString(6, emailText);
                            statement.setString(7, passwordText);
                            statement.setString(8, "Teacher");
                            statement.executeUpdate();
                            
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());

                    }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(294, 365, 134, 42);
		contentPane.add(btnNewButton);
		
		addteacher_fname = new JTextField();
		addteacher_fname.setBounds(238, 106, 228, 29);
		contentPane.add(addteacher_fname);
		addteacher_fname.setColumns(10);
		
		addteacher_lname = new JTextField();
		addteacher_lname.setColumns(10);
		addteacher_lname.setBounds(240, 157, 228, 29);
		contentPane.add(addteacher_lname);
		
		addteacher_email = new JTextField();
		addteacher_email.setColumns(10);
		addteacher_email.setBounds(238, 207, 228, 29);
		contentPane.add(addteacher_email);
		
		addteacher_course = new JTextField();
		addteacher_course.setColumns(10);
		addteacher_course.setBounds(238, 258, 228, 29);
		contentPane.add(addteacher_course);
		
		addteacher_age = new JTextField();
		addteacher_age.setColumns(10);
		addteacher_age.setBounds(577, 108, 96, 29);
		contentPane.add(addteacher_age);
		
		addteacher_gender = new JTextField();
		addteacher_gender.setColumns(10);
		addteacher_gender.setBounds(577, 162, 96, 29);
		contentPane.add(addteacher_gender);
		
		addteacher_password = new JPasswordField();
		addteacher_password.setBounds(238, 304, 228, 32);
		contentPane.add(addteacher_password);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("show");
		chckbxNewCheckBox.setBounds(472, 309, 93, 21);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teachers goteach = new Teachers();
				goteach.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(485, 365, 134, 42);
		contentPane.add(btnCancel);
		
		
		chckbxNewCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxNewCheckBox.isSelected()) {
                	addteacher_password.setEchoChar((char) 0);
                } else {
                	addteacher_password.setEchoChar('*');
                }
            }
        });
	}

}
