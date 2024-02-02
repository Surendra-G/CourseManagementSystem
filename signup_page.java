package FinalPortfolio;
import FinalPortfolio.database;
import java.sql.*;
import java.util.regex.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class signup_page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField eMAIL;
    private JLabel FIRSTNAME;
    private JLabel LASTNAME;
    private JLabel gender;
    private JPasswordField password;
    private JPasswordField confirm_password;
    private JTextField ageTextField; 
    private String selectedGender = "";
    private JComboBox comboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    signup_page frame = new signup_page();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public signup_page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 975, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        firstname = new JTextField();
        firstname.setBounds(158, 81, 317, 30);
        firstname.setToolTipText("");
        contentPane.add(firstname);
        firstname.setColumns(10);
        
        lastname = new JTextField();
        lastname.setBounds(158, 116, 317, 30);
        lastname.setToolTipText("");
        lastname.setColumns(10);
        contentPane.add(lastname);
        
        eMAIL = new JTextField();
        eMAIL.setBounds(158, 229, 317, 30);
        contentPane.add(eMAIL);
        eMAIL.setColumns(10);
        
        JLabel heading = new JLabel(" COURSE MANAGEMENT SYSTEM");
        heading.setBounds(340, 0, 376, 52);
        heading.setBackground(new Color(128, 128, 0));
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(heading);
        
        FIRSTNAME = new JLabel("FIRST NAME:");
        FIRSTNAME.setBounds(69, 79, 98, 37);
        FIRSTNAME.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(FIRSTNAME);
        
        LASTNAME = new JLabel("LAST NAME:");
        LASTNAME.setBounds(70, 110, 81, 37);
        LASTNAME.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(LASTNAME);
        
        gender = new JLabel("GENDER:");
        gender.setBounds(89, 149, 61, 37);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(gender);
        
        JTextField ageTextField = new JTextField();
        ageTextField.setBounds(158, 184, 81, 30);
        contentPane.add(ageTextField);
        
        JLabel email = new JLabel("EMAIL:");
        email.setBounds(100, 223, 51, 37);
        email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(email);
        
        JLabel PASSWORD = new JLabel("PASSWORD:");
        PASSWORD.setBounds(69, 270, 81, 37);
        PASSWORD.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(PASSWORD);
        
        JLabel CONFIRM_PASSWORD = new JLabel("CONFIRM PASSWORD:");
        CONFIRM_PASSWORD.setBounds(10, 310, 153, 37);
        CONFIRM_PASSWORD.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(CONFIRM_PASSWORD);
        
        ButtonGroup genderGroup = new ButtonGroup();
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
        rdbtnNewRadioButton.setBounds(168, 157, 61, 21);
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(rdbtnNewRadioButton);
        genderGroup.add(rdbtnNewRadioButton);
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedGender = "Male";
            }
        });
        
        JRadioButton rdbtnFemale = new JRadioButton("Female");
        rdbtnFemale.setBounds(231, 157, 81, 21);
        rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(rdbtnFemale);
        genderGroup.add(rdbtnFemale);
        rdbtnFemale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedGender = "Female";
            }
        });
        
        JLabel BIRTHDATE = new JLabel("AGE:");
        BIRTHDATE.setBounds(114, 180, 37, 37);
        BIRTHDATE.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(BIRTHDATE);
        
        password = new JPasswordField();
        password.setBounds(158, 276, 317, 30);
        contentPane.add(password);
        
        confirm_password = new JPasswordField();
        confirm_password.setBounds(158, 316, 317, 30);
        contentPane.add(confirm_password);
        
        JButton signupBtn = new JButton("SIGNUP");
        signupBtn.setBounds(200, 420, 95, 32);
        signupBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String firstNameText = firstname.getText();
                String lastNameText = lastname.getText();
                String genderSelectionText = selectedGender;
                String ageText = ageTextField.getText().trim();
                String emailText = eMAIL.getText();
                String passwordText = new String(password.getPassword()); 
                String confirmPasswordText = new String(confirm_password.getPassword()); 
                
                String selectMode = (String) comboBox.getSelectedItem(); // Corrected variable name
                
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
                boolean passNew = pN.matches();
                
                String regexPC = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$#])[A-Za-z\\d@$#]{8,}$";
                Pattern passC = Pattern.compile(regexPC);
                
                Matcher pC = passC.matcher(confirmPasswordText);
                boolean passConfirm = pC.matches();
                
                System.out.println("fname: " + fname);
                System.out.println("lname: " + lname);
                System.out.println("Selected Gender: " + selectedGender);
                System.out.println("Age: " + ageText);
                System.out.println("Emailcheck: " + Emailcheck);
                System.out.println("SelectMode: "+selectMode);
                System.out.println("passNew: " + passNew);
                System.out.println("Passwords match: " + passwordText.equals(confirmPasswordText));
                
                if (firstNameText.isEmpty() || lastNameText.isEmpty() || genderSelectionText.isEmpty() || ageText.isEmpty() ||
                        emailText.isEmpty() || passwordText.isEmpty() || confirmPasswordText.isEmpty() || selectMode.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill up all the fields to sign up.");
                        return;
                    }
                
                if (!firstNameText.equals("") && !lastNameText.equals("") && !genderSelectionText.isEmpty() && !ageText.equals("")  && !emailText.equals("") && !passwordText.equals("") && !confirmPasswordText.equals("") && !selectMode.equals("--Select Options-- ")) {
                    if (fname && lname && Emailcheck && passNew && passwordText.equals(confirmPasswordText)) {
                        JOptionPane.showMessageDialog(null, "Sign Up success");
                        System.out.println("Successfully Executed!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Input. Please check the Entered Values.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill up all the fields to sign up.");
                }
                
                //converting the ageText into Integers
                int age;
                try {
                    age = Integer.parseInt(ageText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for age.");
                    return;
                }
                
                //for database connection for student
                if (selectMode.equals("Student")){
	                try (Connection connection = database.getConnection()) {
	                    // Insert signup data into the "Students" table
	                    String insertUserQuery = "INSERT INTO Students (FirstName, LastName, Gender, Age, Email, Password) VALUES (?, ?, ?, ?, ?, ?)";
	                    try (PreparedStatement statement = connection.prepareStatement(insertUserQuery)) {
	                        statement.setString(1, firstNameText);
	                        statement.setString(2, lastNameText);
	                        statement.setString(3, genderSelectionText);
	                        statement.setInt(4, age);
	                        statement.setString(5, emailText);
	                        statement.setString(6, passwordText);
	                        statement.executeUpdate();
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
	                }
                }
                
              //for database connection for Teacher
                if (selectMode.equals("Teacher")){
	                try (Connection connection = database.getConnection()) {
	                    // Insert signup data into the "Students" table
	                    String insertUserQuery = "INSERT INTO Teacher (FirstName, LastName, Gender, Age, Email, Password) VALUES (?, ?, ?, ?, ?, ?)";
	                    try (PreparedStatement statement = connection.prepareStatement(insertUserQuery)) {
	                    	statement.setString(1, firstNameText);
	                        statement.setString(2, lastNameText);
	                        statement.setString(3, genderSelectionText);
	                        statement.setInt(4, age);
	                        statement.setString(5, emailText);
	                        statement.setString(6, passwordText);
	                        statement.executeUpdate();
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
	                }
                }
                
              //for database connection for Admin
                if (selectMode.equals("Admin")){
	                try (Connection connection = database.getConnection()) {
	                    // Insert signup data into the "Admin" table
	                    String insertUserQuery = "INSERT INTO Admin (FirstName, LastName, Gender, Age, Email, Password) VALUES (?, ?, ?, ?, ?, ?)";
	                    try (PreparedStatement statement = connection.prepareStatement(insertUserQuery)) {
	                    	statement.setString(1, firstNameText);
	                        statement.setString(2, lastNameText);
	                        statement.setString(3, genderSelectionText);
	                        statement.setInt(4, age);
	                        statement.setString(5, emailText);
	                        statement.setString(6, passwordText);
	                        statement.executeUpdate();
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
	                }
                }

            }
        });
        signupBtn.setForeground(SystemColor.window);
        signupBtn.setBackground(SystemColor.desktop);
        signupBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(signupBtn);
        
        JButton LOGIN = new JButton("CANCEL");
        LOGIN.setBounds(315, 420, 95, 32);
        LOGIN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        LOGIN.setForeground(SystemColor.window);
        LOGIN.setBackground(SystemColor.desktop);
        LOGIN.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(LOGIN);
        
        
        comboBox = new JComboBox();
        comboBox.setBounds(158, 357, 317, 38);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Select Options-- ", "Student", "Teacher", "Admin"}));
        contentPane.add(comboBox);
        
        JLabel selectMode = new JLabel("Select Mode:");
        selectMode.setBounds(56, 368, 95, 14);
        selectMode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(selectMode);
        
        JLabel lblNewLabel_3 = new JLabel("Already have Account ?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(179, 467, 170, 39);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.setForeground(SystemColor.window);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_page lp = new login_page();
            	lp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(356, 476, 70, 23);
		contentPane.add(btnNewButton_1);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(582, 81, 358, 366);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Surendra\\eclipse-workspace\\Tutorial\\src\\FinalPortfolio\\images\\3.png"));
        contentPane.add(lblNewLabel);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("show");
        chckbxNewCheckBox.setBounds(481, 280, 60, 21);
        contentPane.add(chckbxNewCheckBox);
        
     // ActionListener for the "show" checkbox for password
        chckbxNewCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxNewCheckBox.isSelected()) {
                    password.setEchoChar((char) 0); // Show password
                } else {
                    password.setEchoChar('*'); // Hide password
                }
            }
        });
        
        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("show");
        chckbxNewCheckBox_1.setBounds(481, 320, 60, 21);
        contentPane.add(chckbxNewCheckBox_1);
        
        JLabel lblNewLabel_1 = new JLabel("Signup Page");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(208, 41, 128, 30);
        contentPane.add(lblNewLabel_1);
        
     // ActionListener for the "show" checkbox for Confirm_password
        chckbxNewCheckBox_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxNewCheckBox_1.isSelected()) {
                    confirm_password.setEchoChar((char) 0); // Show password
                } else {
                	confirm_password.setEchoChar('*'); // Hide password
                }
            }
        });
    }
}   
