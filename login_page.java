package FinalPortfolio;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.Color;
import FinalPortfolio.database;
public class login_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_page frame = new login_page();
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
	public login_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Management System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(61, 10, 347, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login Here");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(168, 82, 119, 29);
		contentPane.add(lblNewLabel_1);
		
		emailField = new JTextField();
		emailField.setBounds(111, 169, 237, 29);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(49, 174, 52, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(25, 228, 76, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emailText = new String(emailField.getText()); 
		        String PasswordText = new String(passwordField.getPassword()); 
		        String selectMode = (String) comboBox.getSelectedItem(); 
				if (emailText.isEmpty() || PasswordText.isEmpty() ) {
	                JOptionPane.showMessageDialog(null, "Please fill up all the fields to sign up.");
	                return;
	            }
				if (selectMode == "Student" || selectMode == "Admin" || selectMode == "Teacher" ) {
                	JOptionPane.showMessageDialog(null, "Sign Up success");
                	
                }else {
                	JOptionPane.showMessageDialog(null, "Please Select the Mode");
                	return;
                }
				
				try (Connection connection = database.getConnection()) {
				    // Authenticate the user against the appropriate section of the database
				    String authenticateUserQuery = "SELECT * FROM " + selectMode + " WHERE Email = ? AND Password = ?";
				    try (PreparedStatement statement = connection.prepareStatement(authenticateUserQuery)) {
				        statement.setString(1, emailText);
				        statement.setString(2, PasswordText);
				        try (ResultSet resultSet = statement.executeQuery()) {
				            if (resultSet.next()) {
				                // User exists, redirect to dashboard
				                // Implement redirection logic here based on selectMode
				                String userType = resultSet.getString("UserType"); // Assuming you have a column UserType in each user table
				                switch (userType) {
				                    case "Admin":
				                        // Redirect to admin dashboard
				                        break;
				                    case "Student":
				                        // Redirect to student dashboard
				                        break;
				                    case "Teacher":
				                        // Redirect to teacher dashboard
				                        break;
				                    default:
				                        // Handle unknown user type
				                        break;
				                }
				            } else {
				                // User does not exist or invalid credentials
				                JOptionPane.showMessageDialog(null, "Invalid email or password.");
				            }
				        }
				    }
				} catch (SQLException ex) {
				    ex.printStackTrace();
				    JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
				}

			}
		});
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setBackground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(181, 311, 95, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Don't have Account ?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(93, 350, 157, 39);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("SignUp");
		btnNewButton_1.setForeground(SystemColor.window);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup_page lp = new signup_page();
            	lp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(253, 359, 70, 23);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 223, 237, 29);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Surendra\\eclipse-workspace\\Tutorial\\src\\FinalPortfolio\\images\\3.png"));
		lblNewLabel_4.setBounds(462, 105, 376, 299);
		contentPane.add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("show");
		chckbxNewCheckBox.setBounds(354, 227, 65, 21);
		contentPane.add(chckbxNewCheckBox);
		
		comboBox = new JComboBox();
        comboBox.setBounds(111, 262, 237, 29);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Select Options-- ", "Student", "Teacher", "Admin"}));
        contentPane.add(comboBox);
        
        JLabel selectMode = new JLabel("Select Mode:");
        selectMode.setBounds(10, 272, 95, 14);
        selectMode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(selectMode);
		
		// ActionListener for the "show" checkBox for password
		chckbxNewCheckBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxNewCheckBox.isSelected()) {
		        	passwordField.setEchoChar((char) 0); // Show password
		        } else {
		        	passwordField.setEchoChar('*'); // Hide password
		        }
		    }
		});
		
		
	}
}