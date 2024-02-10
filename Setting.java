package FinalPortfolio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Setting extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField setting_fname;
	private JTextField setting_lname;
	private JTextField setting_Email;
	private JTextField setting_ID;
	private JPasswordField old_passwordfield;
	private JPasswordField new_passwordfield;
	private JTextField password_ID_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Setting frame = new Setting();
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
	public Setting() {
		String mode = login_page.selectMode; 
		Color color = Color.decode("#eae2d9");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(830, 600);
        setLocationRelativeTo(null);
        setTitle("Course Management System");

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel(); 
        headerPanel.setBackground(SystemColor.controlHighlight);
        headerPanel.setPreferredSize(new Dimension(800, 70));
        JLabel headerLabel = new JLabel("Course Management System");
        headerLabel.setBounds(10, 16, 750, 54);
        headerLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(16, 10, 0, 10));
        headerPanel.setLayout(null);
        headerPanel.setLayout(null);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        headerLabel.setForeground(SystemColor.desktop);
        headerPanel.add(headerLabel);
        
        //adding the profile button inside the headerPanel
        ImageIcon profileIcon = new ImageIcon("C:\\Users\\Surendra\\eclipse-workspace\\Tutorial\\src\\FinalPortfolio\\images\\profile.png");

	     // Scale the image to the desired dimensions
	     Image scaledImage = profileIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	
	     // Create a new ImageIcon with the scaled image
	     ImageIcon scaledProfileIcon = new ImageIcon(scaledImage);
	
	     // Create the profile label with the scaled icon
	     JLabel profileLabel = new JLabel(scaledProfileIcon);
	     profileLabel.setBounds(750, 16, 30, 54);
	     profileLabel.setHorizontalAlignment(SwingConstants.RIGHT);

	     // Add the profile label to the headerPanel
	     headerPanel.add(profileLabel);
	     
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        JLabel user_name = new JLabel("UserName");
        user_name.setFont(new Font("Tahoma", Font.BOLD, 15));
        user_name.setBounds(629, 16, 161, 54);
        headerPanel.add(user_name);

     // Side Panel
        JPanel sidePanel = new JPanel(new GridLayout(0, 1));
        sidePanel.setPreferredSize(new Dimension(140, 0));
        JButton home = new JButton("DASHBOARD");
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dashboard.displayDashboard();
            	dashboard db = new dashboard();
        		db.setVisible(true);
        		dashboard.displayDashboard();
        		dispose();
            }
        });
        home.setBackground(Color.decode("#eae2d9"));

        JButton AdminPanel = new JButton("Admin");
        AdminPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (mode.equals("students") || (mode.equals("teachers")) ) {
                    for_admin ad = new for_admin();
                    ad.displayadminforstudent();
                    ad.setVisible(true);
                    dispose();
                }else if (mode.equals("admin")) {
                    Admin admin = new Admin();
                	admin.displayadminInfo();
                    admin.setVisible(true);
                    dispose();
                }
        	}
        });
        AdminPanel.setBackground(Color.decode("#eae2d9"));
        JButton TeacherPanel = new JButton("Teacher");
        TeacherPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (mode.equals("students")|| mode.equals("teachers") ) {
                    for_teacher teach = new for_teacher();
                    teach.displayteachertableInfo();
                    teach.setVisible(true);
                    dispose();
                }else if (mode.equals("admin")) {
                    Teachers teach = new Teachers();
                    teach.displayteacherInfo();
                    teach.setVisible(true);
                    dispose();
                }
        	}
        });
        TeacherPanel.setBackground(Color.decode("#eae2d9"));
        JButton StudentPanel = new JButton("Students");
        StudentPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(mode.equals("students") || (mode.equals("teachers")) ) {
                    for_student stud = new for_student();
                    stud.setVisible(true);
                    stud.displaystudenttableInfo();
                    dispose();
                }else if(mode.equals("admin")) {
                    Students stud = new Students();
                    stud.setVisible(true);
                    stud.displaystudentInfo();
                    dispose();
                }
        	}
        });
        StudentPanel.setBackground(Color.decode("#eae2d9"));
        
        JButton SettingPanel = new JButton("Setting");
        SettingPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (mode.equals("students")) {
                    Setting set = new Setting();
                    set.setVisible(true);
                    dispose();
                }else if (mode.equals("teachers")) {
                	Setting set = new Setting();
                    set.setVisible(true);
                    dispose();
                }else if (mode.equals("admin")) {
                	Setting set = new Setting();
                    set.setVisible(true);
                    dispose();
                }
        	}
        });
        SettingPanel.setBackground(Color.decode("#eae2d9"));
        JButton LogoutPanel = new JButton("Logout");
        LogoutPanel.setBackground(Color.decode("#eae2d9"));
        LogoutPanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login_page login = new login_page();
                login.setVisible(true);
            }
        });

        // changing the size of the button
        Dimension buttonSize = new Dimension(100, 20);
        home.setPreferredSize(new Dimension(150, 30));
        AdminPanel.setPreferredSize(buttonSize);
        TeacherPanel.setPreferredSize(buttonSize);
        StudentPanel.setPreferredSize(buttonSize);
        SettingPanel.setPreferredSize(buttonSize);
        LogoutPanel.setPreferredSize(buttonSize);

        sidePanel.add(home);
        sidePanel.add(AdminPanel);
        sidePanel.add(TeacherPanel);
        sidePanel.add(StudentPanel);
        JButton ResultPanel = new JButton("Result");
        ResultPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (mode.equals("students")) {
                    student_result res = new student_result();
                    res.setVisible(true);
                    res.displayresultforstudent();
                    dispose();
                }else if (mode.equals("teachers")) {
                	admin_result res = new admin_result();
                    res.setVisible(true);
                    res.displayresult();
                    dispose();
                }else if (mode.equals("admin")) {
                    admin_result res = new admin_result();
                    res.setVisible(true);
                    res.displayresult();
                    dispose();
                }
        	}
        });
        ResultPanel.setBackground(Color.decode("#eae2d9"));
        sidePanel.add(ResultPanel);
        sidePanel.add(SettingPanel);
        sidePanel.add(LogoutPanel);
        mainPanel.add(sidePanel, BorderLayout.WEST);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Settings");
        lblNewLabel.setBounds(264, 10, 148, 36);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPanel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("FirstName: ");
        lblNewLabel_1.setBounds(10, 70, 95, 26);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPanel.add(lblNewLabel_1);
        
        setting_fname = new JTextField();
        setting_fname.setBounds(93, 72, 158, 28);
        contentPanel.add(setting_fname);
        setting_fname.setColumns(10);
        
        JLabel lblNewLabel_1_1 = new JLabel("LastName: ");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(317, 74, 95, 26);
        contentPanel.add(lblNewLabel_1_1);
        
        setting_lname = new JTextField();
        setting_lname.setColumns(10);
        setting_lname.setBounds(403, 72, 158, 28);
        contentPanel.add(setting_lname);
        
        JLabel setting_email = new JLabel("E-mail: ");
        setting_email.setFont(new Font("Tahoma", Font.PLAIN, 15));
        setting_email.setBounds(10, 134, 95, 26);
        contentPanel.add(setting_email);
        
        setting_Email = new JTextField();
        setting_Email.setColumns(10);
        setting_Email.setBounds(93, 134, 158, 28);
        contentPanel.add(setting_Email);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("ID:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(371, 134, 41, 26);
        contentPanel.add(lblNewLabel_1_1_1);
        
        setting_ID = new JTextField();
        setting_ID.setColumns(10);
        setting_ID.setBounds(403, 132, 158, 28);
        contentPanel.add(setting_ID);
        
        JLabel lblSecurityPassword = new JLabel("Security & Password");
        lblSecurityPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSecurityPassword.setBounds(218, 204, 221, 36);
        contentPanel.add(lblSecurityPassword);
        
        JLabel lblNewLabel_1_2 = new JLabel("Old Password:");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(10, 250, 95, 26);
        contentPanel.add(lblNewLabel_1_2);
        
        old_passwordfield = new JPasswordField();
        old_passwordfield.setBounds(103, 250, 179, 28);
        contentPanel.add(old_passwordfield);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("New Password:");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_2_1.setBounds(304, 250, 108, 26);
        contentPanel.add(lblNewLabel_1_2_1);
        
        new_passwordfield = new JPasswordField();
        new_passwordfield.setBounds(416, 250, 179, 28);
        contentPanel.add(new_passwordfield);
        
        JButton btnNewButton = new JButton("Edit Profile");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String firstNameText = setting_fname.getText();
		        String lastNameText = setting_lname.getText();
		        String emailText = setting_Email.getText();
		        String idText = setting_ID.getText();
		        
		        // Check if all fields are filled
		        if (firstNameText.isEmpty() || lastNameText.isEmpty()  || emailText.isEmpty() || idText.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill up all the fields to Edit.");
		            return;
		        }

		        // Perform input validation
		        if (!firstNameText.matches("^[A-Z][a-z]+") || !lastNameText.matches("^[A-Z][a-z]+") || !emailText.matches("^[a-z]+[0-9]+[@][a-z]+[.][a-z]{3,7}")) {
		            JOptionPane.showMessageDialog(null, "Invalid Input. Please check the entered values.");
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
		        
		        
		        
		     String updateUserQuery = ""; 

		     // Determine the update query based on the user mode
		     if(mode.equals("students")) {
		         updateUserQuery = "UPDATE Students SET FirstName = ?, LastName = ?, Email = ? WHERE StudentID = ?";
		     } 
		     if(mode.equals("teachers")) {
		         updateUserQuery = "UPDATE Teachers SET FirstName = ?, LastName = ?, Email = ? WHERE TeacherID = ?";
		     } 
		     if(mode.equals("admin")) {
		         updateUserQuery = "UPDATE Admin SET FirstName = ?, LastName = ?, Email = ? WHERE AdminID = ?";
		     } 

		     // Update user details in the database
		     try (Connection connection = database.getConnection()) {
		         try (PreparedStatement statement = connection.prepareStatement(updateUserQuery)) {
		             statement.setString(1, firstNameText);
		             statement.setString(2, lastNameText);
		             statement.setString(3, emailText);
		             statement.setInt(4, id);

		             int rowsAffected = statement.executeUpdate();

		             if (rowsAffected > 0) {
		                 JOptionPane.showMessageDialog(null, "Edited Successfully");
		                 dispose();
		                 Setting stud = new Setting();
		                 stud.setVisible(true);
		             } else {
		                 JOptionPane.showMessageDialog(null, "Failed to Edit details.");
		             }
		         }
		     } catch (SQLException ex) {
		         ex.printStackTrace();
		         JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());
		     }

        	}
        });
        btnNewButton.setForeground(SystemColor.window);
        btnNewButton.setBackground(SystemColor.desktop);
        btnNewButton.setBounds(250, 179, 108, 25);
        contentPanel.add(btnNewButton);
        
        JButton change_password = new JButton("Change Password");
        change_password.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String oldpasswordText = new String(old_passwordfield.getPassword());
                String newpasswordText = new String(new_passwordfield.getPassword());
                String userIDText = password_ID_input.getText(); // Assuming this field is used to capture the user ID

                String updatePasswordQuery = ""; 
                if(mode.equals("students")) {
                    updatePasswordQuery = "UPDATE Students SET Password = ? WHERE StudentID = ?";
                }
                if(mode.equals("teachers")) {
                    updatePasswordQuery = "UPDATE Teachers SET Password = ? WHERE TeacherID = ?";
                }
                if(mode.equals("admin")) {
                    updatePasswordQuery = "UPDATE Admin SET Password = ? WHERE adminID = ?";
                }

                // Update password in the database
                try (Connection connection = database.getConnection()) {
                    try (PreparedStatement statement = connection.prepareStatement(updatePasswordQuery)) {
                        statement.setString(1, newpasswordText);
                        statement.setString(2, userIDText); // Set the user ID parameter

                        int rowsAffected = statement.executeUpdate();

                        if (rowsAffected >= 0 && !oldpasswordText.equals(newpasswordText)) {
                            JOptionPane.showMessageDialog(null, "Password updated successfully.");
                            dispose();
   		                 	Setting stud = new Setting();
   		                 	stud.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update password.");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());
                }
                

		        
        	}
        });
        change_password.setForeground(SystemColor.window);
        change_password.setBackground(SystemColor.desktop);
        change_password.setBounds(229, 334, 148, 36);
        contentPanel.add(change_password);
        
        JLabel lblHelpServices = new JLabel("Help & Services");
        lblHelpServices.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblHelpServices.setBounds(218, 380, 221, 36);
        contentPanel.add(lblHelpServices);
        
        JLabel lblNewLabel_2 = new JLabel("For any type of the Help & Services. Don't Forgot to Contact Herald College Kathmandu, Nepal\r\n\r\n");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(31, 413, 598, 26);
        contentPanel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Phone Number: 01-5970120");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(229, 434, 196, 26);
        contentPanel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("-----------------------------------------------------------------------------------------------------------------\r\n");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(20, 37, 640, 13);
        contentPanel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("-----------------------------------------------------------------------------------------------------------------\r\n");
        lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4_1.setBounds(31, 227, 640, 13);
        contentPanel.add(lblNewLabel_4_1);
        
        JLabel lblNewLabel_4_2 = new JLabel("-----------------------------------------------------------------------------------------------------------------\r\n");
        lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4_2.setBounds(20, 411, 640, 13);
        contentPanel.add(lblNewLabel_4_2);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("show");
        chckbxNewCheckBox.setBounds(595, 255, 93, 21);
        contentPanel.add(chckbxNewCheckBox);
        
       
        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("show");
        chckbxNewCheckBox_1.setBounds(101, 282, 93, 21);
        contentPanel.add(chckbxNewCheckBox_1);
        
        JLabel password_ID = new JLabel("ID:");
        password_ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
        password_ID.setBounds(264, 288, 41, 26);
        contentPanel.add(password_ID);
        
        password_ID_input = new JTextField();
        password_ID_input.setColumns(10);
        password_ID_input.setBounds(291, 286, 108, 28);
        contentPanel.add(password_ID_input);
        
        chckbxNewCheckBox_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (chckbxNewCheckBox_1.isSelected()) {
        			old_passwordfield.setEchoChar((char) 0);
                }
        		else {
        			old_passwordfield.setEchoChar('*');
                }
        	}
        });
        
        chckbxNewCheckBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (chckbxNewCheckBox.isSelected()) {
        			new_passwordfield.setEchoChar((char) 0);
                }
        		else {
        			new_passwordfield.setEchoChar('*');
                }
        	}
        });
        

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setToolTipText("");
        footerPanel.setBackground(Color.LIGHT_GRAY);
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel footerLabel = new JLabel("Made by Mr.Surendra Giri");
        footerLabel.setForeground(Color.BLACK);
        footerPanel.add(footerLabel);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        setVisible(true);
	}
}
