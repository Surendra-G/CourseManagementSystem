package FinalPortfolio;
import FinalPortfolio.database;
import FinalPortfolio.signup_page;





import java.awt.*;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JSpinner;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;



public class dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable dashboardTable2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void displayDashboard() {
	    DefaultTableModel dashboardModel = (DefaultTableModel)dashboardTable2.getModel();
	    dashboardModel.setRowCount(0); // Clear existing rows

	    String url = "jdbc:mysql://127.0.0.1:3306/coursemanagementsystem";
	    String username = "root";
	    String password = "";

	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        String query = "SELECT * FROM activity";
	        try (Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {
	            while (resultSet.next()) {
	                String id = resultSet.getString(1);
	                String activity = resultSet.getString(2);
	                String data[]= {id,activity	};
	                dashboardModel.addRow(data);
	                
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Create the frame.
	 */
	public dashboard() {
		String mode = login_page.selectMode;  
		Color color = Color.decode("#eae2d9");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 600);
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
        user_name.setBounds(615, 16, 175, 54);
        headerPanel.add(user_name);
        
        
        // Side Panel
        JPanel sidePanel = new JPanel(new GridLayout(0, 1));
        sidePanel.setPreferredSize(new Dimension(140, 0));
        JButton home = new JButton("DASHBOARD");
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	displayDashboard();
            	dashboard db = new dashboard();
        		db.setVisible(true);
        		dashboard.displayDashboard();
        		dispose();
            }
        });
        home.setBackground(Color.decode("#eae2d9"));
        
        JButton admin_panel = new JButton("Admin");
        admin_panel.addActionListener(new ActionListener() {
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
        admin_panel.setBackground(Color.decode("#eae2d9"));
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
        		if(mode.equals("students")) {
            		Setting set = new Setting();
            		set.setVisible(true);
            		dispose();
            	}else if(mode.equals("teachers")) {
            		Setting set = new Setting();
            		set.setVisible(true);
            		dispose();
            	}else if(mode.equals("admin")) {
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
        admin_panel.setPreferredSize(buttonSize);
        TeacherPanel.setPreferredSize(buttonSize);
        StudentPanel.setPreferredSize(buttonSize);
        SettingPanel.setPreferredSize(buttonSize);
        LogoutPanel.setPreferredSize(buttonSize);

        sidePanel.add(home);
        sidePanel.add(admin_panel);
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
        
        JLabel lblNewLabel = new JLabel("Welcome To Course Managment System");
        lblNewLabel.setBounds(201, 10, 288, 36);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPanel.add(lblNewLabel);
        
        JPanel for_student = new JPanel();
        for_student.setBounds(35, 52, 147, 138);
        for_student.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPanel.add(for_student);
        
        JPanel for_Teacher = new JPanel();
        for_Teacher.setBounds(241, 52, 152, 138);
        for_Teacher.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPanel.add(for_Teacher);
        
        JPanel for_course = new JPanel();
        for_course.setBounds(460, 52, 152, 130);
        for_Teacher.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("TOTAL TEACHERS");
        lblNewLabel_2.setBounds(22, 7, 108, 16);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        for_Teacher.add(lblNewLabel_2);
        
        JLabel count_teacher = new JLabel("0");
        count_teacher.setFont(new Font("Tahoma", Font.BOLD, 20));
        count_teacher.setBounds(59, 60, 45, 25);
        for_Teacher.add(count_teacher);
        for_student.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("TOTAL STUDENT");
        lblNewLabel_1.setBounds(22, 7, 102, 16);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        for_student.add(lblNewLabel_1);
        
        JLabel count_student = new JLabel("0");
        count_student.setFont(new Font("Tahoma", Font.BOLD, 20));
        count_student.setBounds(53, 54, 52, 41);
        for_student.add(count_student);
        contentPanel.add(for_course);
        for_course.setBorder(BorderFactory.createRaisedBevelBorder());
        for_course.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("TOTAL COURSES");
        lblNewLabel_3.setBounds(25, 7, 101, 16);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        for_course.add(lblNewLabel_3);
        
        JLabel count_course = new JLabel("0");
        count_course.setFont(new Font("Tahoma", Font.BOLD, 20));
        count_course.setBounds(53, 57, 45, 25);
        for_course.add(count_course);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 211, 577, 210);
        contentPanel.add(scrollPane);
        
        dashboardTable2 = new JTable();
        scrollPane.setViewportView(dashboardTable2);
        dashboardTable2.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[]{
        			"ID"	,"Activities"
        	}
        	
        ));
        
        dashboardTable2.getColumnModel().getColumn(0).setPreferredWidth(2);
        dashboardTable2.getColumnModel().getColumn(1).setPreferredWidth(360);

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