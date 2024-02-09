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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class Students extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable studentInfoTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Students frame = new Students();
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
	public Students() {
		String mode = login_page.selectMode; 
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
	     profileLabel.setBounds(760, 16, 30, 54);
	     profileLabel.setHorizontalAlignment(SwingConstants.RIGHT);

	     // Add the profile label to the headerPanel
	     headerPanel.add(profileLabel);
	     
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        JLabel user_name = new JLabel("UserName");
        user_name.setFont(new Font("Tahoma", Font.BOLD, 15));
        user_name.setBounds(615, 16, 175, 54);
        headerPanel.add(user_name);
        


     // Side Panel
        JPanel sidePanel = new JPanel(new GridLayout(0, 1));
        sidePanel.setPreferredSize(new Dimension(140, 0));
        JButton home = new JButton("DASHBOARD");
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (mode.equals("students")) {
            		for_dashboard db = new for_dashboard();
            		db.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("teachers")) {
            		for_dashboard db = new for_dashboard();
            		db.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("admin")) {
            		dashboard db = new dashboard();
            		db.setVisible(true);
            		dispose();
            	}
            }
        });
        home.setBackground(Color.decode("#eae2d9"));

        JButton AdminPanel = new JButton("Admin");
        AdminPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (mode.equals("students")) {
            		for_admin ad = new for_admin();
            		ad.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("teachers")) {
            		for_admin ad = new for_admin();
            		ad.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("admin")) {
            		Admin ad = new Admin();
            		ad.setVisible(true);
            		dispose();
            	}
        	}
        });
        AdminPanel.setBackground(Color.decode("#eae2d9"));
        JButton TeacherPanel = new JButton("Teacher");
        TeacherPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(mode.equals("students")) {
            		for_teacher teach = new for_teacher();
            		teach.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("teachers")) {
            		for_teacher teach = new for_teacher();
            		teach.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("admin")) {
            		Teachers teach = new Teachers();
            		teach.setVisible(true);
            		dispose();
            	}
        	}
        });
        TeacherPanel.setBackground(Color.decode("#eae2d9"));
        JButton StudentPanel = new JButton("Students");
        StudentPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(mode.equals("students")) {
            		for_student stud = new for_student();
            		stud.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("teachers")) {
            		Students stud = new Students();
            		stud.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("admin")) {
            		Students stud = new Students();
            		stud.setVisible(true);
            		dispose();
            	}
        	}
        });
        StudentPanel.setBackground(Color.decode("#eae2d9"));
        
        JButton SettingPanel = new JButton("Setting");
        SettingPanel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(mode.equals("students")) {
            		Setting set = new Setting();
            		set.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("teachers")) {
            		Setting set = new Setting();
            		set.setVisible(true);
            		dispose();
            	}
            	if(mode.equals("admin")) {
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
                    dispose();
                }
                if (mode.equals("teachers")) {
                    resultForTeacher res = new resultForTeacher();
                    res.setVisible(true);
                    dispose();
                }
                if (mode.equals("admin")) {
                    admin_result res = new admin_result();
                    res.setVisible(true);
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
        
        JLabel lblNewLabel = new JLabel("Student Information");
        lblNewLabel.setBounds(244, 10, 182, 36);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPanel.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(20, 77, 313, 36);
        contentPanel.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------");
        lblNewLabel_1.setBounds(46, 36, 630, 22);
        contentPanel.add(lblNewLabel_1);
        
        JButton teacher_add_btn = new JButton("Add ");
        teacher_add_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		add_student adstud = new add_student();
        		adstud.setVisible(true);
        		dispose();
        	}
        });
        teacher_add_btn.setBounds(341, 79, 85, 30);
        contentPanel.add(teacher_add_btn);
        
        JButton teacher_edit_btn = new JButton("Edit");
        teacher_edit_btn.setBounds(436, 79, 85, 30);
        teacher_edit_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		edit_student edstud = new edit_student();
        		edstud.setVisible(true);
        		dispose();
        		
        	}
        });
        contentPanel.add(teacher_edit_btn);
        
        JButton teacher_delete_btn = new JButton("Delete");
        teacher_delete_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		delete_student delstud = new delete_student();
        		delstud.setVisible(true);
        		dispose();
        	}
        });
        teacher_delete_btn.setBounds(531, 79, 85, 30);
        contentPanel.add(teacher_delete_btn);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 132, 610, 266);
        contentPanel.add(scrollPane);
        
        studentInfoTable = new JTable();
        scrollPane.setViewportView(studentInfoTable);
        studentInfoTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"ID", "FirstName", "LastName", "Email", "Course"
        	}
        ));
        
        
        
        
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
