package FinalPortfolio;
import java.util.regex.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

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

public class projectno1 extends JFrame {

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
    private JDateChooser dateChooser;
    private String selectedGender = "";
    private JComboBox comboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    projectno1 frame = new projectno1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public projectno1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 975, 763);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        firstname = new JTextField();
        firstname.setBounds(185, 173, 317, 38);
        firstname.setToolTipText("");
        contentPane.add(firstname);
        firstname.setColumns(10);
        
        lastname = new JTextField();
        lastname.setBounds(632, 173, 268, 38);
        lastname.setToolTipText("");
        lastname.setColumns(10);
        contentPane.add(lastname);
        
        eMAIL = new JTextField();
        eMAIL.setBounds(185, 260, 317, 38);
        contentPane.add(eMAIL);
        eMAIL.setColumns(10);
        
        JLabel heading = new JLabel("WELCOME TO COURSE MANAGEMENT SYSTEM");
        heading.setBounds(158, 10, 742, 71);
        heading.setBackground(new Color(128, 128, 0));
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        contentPane.add(heading);
        
        FIRSTNAME = new JLabel("FIRST NAME:");
        FIRSTNAME.setBounds(69, 171, 98, 37);
        FIRSTNAME.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(FIRSTNAME);
        
        LASTNAME = new JLabel("LAST NAME:");
        LASTNAME.setBounds(541, 171, 81, 37);
        LASTNAME.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(LASTNAME);
        
        gender = new JLabel("GENDER:");
        gender.setBounds(89, 218, 61, 37);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(gender);
        
        JLabel email = new JLabel("EMAIL:");
        email.setBounds(99, 258, 51, 37);
        email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(email);
        
        JLabel PASSWORD = new JLabel("PASSWORD:");
        PASSWORD.setBounds(69, 326, 81, 37);
        PASSWORD.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(PASSWORD);
        
        JLabel CONFIRM_PASSWORD = new JLabel("CONFIRM PASSWORD:");
        CONFIRM_PASSWORD.setBounds(10, 383, 153, 37);
        CONFIRM_PASSWORD.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(CONFIRM_PASSWORD);
        
        ButtonGroup genderGroup = new ButtonGroup();
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
        rdbtnNewRadioButton.setBounds(184, 228, 61, 21);
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(rdbtnNewRadioButton);
        genderGroup.add(rdbtnNewRadioButton);
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedGender = "Male";
            }
        });
        
        JRadioButton rdbtnFemale = new JRadioButton("Female");
        rdbtnFemale.setBounds(265, 228, 81, 21);
        rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(rdbtnFemale);
        genderGroup.add(rdbtnFemale);
        rdbtnFemale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedGender = "Female";
            }
        });
        
        JLabel BIRTHDATE = new JLabel("DATE OF BIRTH:");
        BIRTHDATE.setBounds(512, 218, 109, 37);
        BIRTHDATE.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(BIRTHDATE);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(632, 218, 270, 30);
        contentPane.add(dateChooser);
        
        password = new JPasswordField();
        password.setBounds(185, 325, 317, 38);
        contentPane.add(password);
        
        confirm_password = new JPasswordField();
        confirm_password.setBounds(185, 382, 317, 38);
        contentPane.add(confirm_password);
        
        JButton signupBtn = new JButton("SIGNUP");
        signupBtn.setBounds(212, 501, 98, 38);
        signupBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String firstNameText = firstname.getText();
                String lastNameText = lastname.getText();
                String genderSelectionText = selectedGender;
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
                System.out.println("Emailcheck: " + Emailcheck);
                System.out.println("SelectMode: "+selectMode);
                System.out.println("passNew: " + passNew);
                System.out.println("Passwords match: " + passwordText.equals(confirmPasswordText));

                if (genderSelectionText == null || genderSelectionText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a gender.");
                    return;
                }
                if (selectMode == "Student") {
                	JOptionPane.showMessageDialog(null, "Sign Up success");
                	
                }else if(selectMode == "Admin") {
                	JOptionPane.showMessageDialog(null, "Sign Up success");
                	
                }else if(selectMode == "Teacher") {
                	JOptionPane.showMessageDialog(null, "Sign Up success");
                	
                }else {
                	JOptionPane.showMessageDialog(null, "Please Select the Mode");
                	return;
                }

                if (!firstNameText.equals("") && !lastNameText.equals("") && !selectMode.equals("") && genderSelectionText != null && !emailText.equals("") && !passwordText.equals("") && !confirmPasswordText.equals("")) {
                    if (fname && lname && Emailcheck && passNew && passwordText.equals(confirmPasswordText)) {
                        JOptionPane.showMessageDialog(null, "Sign Up success");
                        System.out.println("Successfully Executed!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Input. Please check the Entered Values.");
                    }
                }
            }
        });
        signupBtn.setForeground(SystemColor.window);
        signupBtn.setBackground(SystemColor.desktop);
        signupBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(signupBtn);
        
        JButton LOGIN = new JButton("LOGIN");
        LOGIN.setBounds(367, 501, 98, 38);
        LOGIN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        LOGIN.setForeground(SystemColor.window);
        LOGIN.setBackground(SystemColor.desktop);
        LOGIN.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(LOGIN);
        
        
        comboBox = new JComboBox();
        comboBox.setBounds(185, 442, 317, 38);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Select Options-- ", "Student", "Teacher", "Admin"}));
        contentPane.add(comboBox);
        
        JLabel selectMode = new JLabel("Select Mode:");
        selectMode.setBounds(69, 455, 95, 14);
        selectMode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(selectMode);
    }
}
