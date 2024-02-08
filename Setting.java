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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Setting extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField setting_fname;
	private JTextField setting_lname;
	private JTextField setting_Email;
	private JTextField setting_ID;
	private JPasswordField old_passwordfield;
	private JPasswordField new_passwordfield;

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
		Color color = Color.decode("#eae2d9");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("Course Management System");

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel(); 
        headerPanel.setBackground(SystemColor.controlHighlight);
        headerPanel.setPreferredSize(new Dimension(800, 70));
        JLabel headerLabel = new JLabel("Course Management System");
        headerLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(16, 10, 0, 10));
        headerPanel.setLayout(new BorderLayout(0, 0));
        headerPanel.setLayout(new BorderLayout(0, 0));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        headerLabel.setForeground(SystemColor.desktop);
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        
        //adding the profile button inside the headerPanel
        ImageIcon profileIcon = new ImageIcon("C:\\Users\\Surendra\\eclipse-workspace\\Tutorial\\src\\FinalPortfolio\\images\\profile.png");

	     // Scale the image to the desired dimensions
	     Image scaledImage = profileIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	
	     // Create a new ImageIcon with the scaled image
	     ImageIcon scaledProfileIcon = new ImageIcon(scaledImage);
	
	     // Create the profile label with the scaled icon
	     JLabel profileLabel = new JLabel(scaledProfileIcon);
	     profileLabel.setHorizontalAlignment(SwingConstants.RIGHT);

	     // Add the profile label to the headerPanel
	     headerPanel.add(profileLabel, BorderLayout.EAST);
	     
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        
////        try (Connection connection = database.getConnection()){
//        	
//        }
////        String userName = firstNameText + lastNameText;

        // Side Panel
        JPanel sidePanel = new JPanel(new GridLayout(0, 1));
        sidePanel.setPreferredSize(new Dimension(140, 0));
        JButton home = new JButton("DASHBOARD");
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dashboard db = new dashboard();
                db.setVisible(true);
                dispose();
            }
        });
        home.setBackground(Color.decode("#eae2d9"));

        JButton AdminPanel = new JButton("Admin");
        AdminPanel.setBackground(Color.decode("#eae2d9"));
        JButton TeacherPanel = new JButton("Teacher");
        TeacherPanel.setBackground(Color.decode("#eae2d9"));
        JButton StudentPanel = new JButton("Students");
        StudentPanel.setBackground(Color.decode("#eae2d9"));
        
        JButton SettingPanel = new JButton("Setting");
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
        		Result res = new Result();
        		res.setVisible(true);
        		dispose();
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
        lblNewLabel_1_2.setBounds(10, 262, 95, 26);
        contentPanel.add(lblNewLabel_1_2);
        
        old_passwordfield = new JPasswordField();
        old_passwordfield.setBounds(115, 264, 179, 28);
        contentPanel.add(old_passwordfield);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("New Password:");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_2_1.setBounds(304, 262, 108, 26);
        contentPanel.add(lblNewLabel_1_2_1);
        
        new_passwordfield = new JPasswordField();
        new_passwordfield.setBounds(422, 260, 179, 28);
        contentPanel.add(new_passwordfield);
        
        JButton btnNewButton = new JButton("Edit Profile");
        btnNewButton.setForeground(SystemColor.window);
        btnNewButton.setBackground(SystemColor.desktop);
        btnNewButton.setBounds(250, 179, 108, 25);
        contentPanel.add(btnNewButton);
        
        JButton change_password = new JButton("Change Password");
        change_password.setForeground(SystemColor.window);
        change_password.setBackground(SystemColor.desktop);
        change_password.setBounds(229, 305, 148, 36);
        contentPanel.add(change_password);
        
        JLabel lblHelpServices = new JLabel("Help & Services");
        lblHelpServices.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblHelpServices.setBounds(218, 352, 221, 36);
        contentPanel.add(lblHelpServices);
        
        JLabel lblNewLabel_2 = new JLabel("For any type of the Help & Services. Don't Forgot to Contact Herald College Kathmandu, Nepal\r\n\r\n");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(31, 398, 598, 26);
        contentPanel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Phone Number: 01-5970120");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(243, 423, 196, 26);
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
        lblNewLabel_4_2.setBounds(20, 382, 640, 13);
        contentPanel.add(lblNewLabel_4_2);
        
        
        
        
        
        

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
