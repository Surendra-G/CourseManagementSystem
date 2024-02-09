package FinalPortfolio;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class edit_student extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField editstudent_fname;
	private JTextField editstudent_lname;
	private JTextField editstudent_email;
	private JTextField editstudent_course;
	private JTextField editstudent_age;
	private JTextField editstudent_gender;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_student frame = new edit_student();
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
	public edit_student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(342, 23, 134, 37);
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
		lblNewLabel_1_1_2.setBounds(163, 264, 67, 21);
		contentPane.add(lblNewLabel_1_1_2);
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Age: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(533, 108, 52, 21);
		contentPane.add(lblNewLabel_1_2);
		
		
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Gender: ");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(513, 165, 62, 21);
		contentPane.add(lblNewLabel_1_1_3);
		
		
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(342, 330, 134, 42);
		contentPane.add(btnNewButton);
		
		editstudent_fname = new JTextField();
		editstudent_fname.setBounds(240, 105, 217, 31);
		contentPane.add(editstudent_fname);
		editstudent_fname.setColumns(10);
		
		editstudent_lname = new JTextField();
		editstudent_lname.setColumns(10);
		editstudent_lname.setBounds(240, 156, 217, 31);
		contentPane.add(editstudent_lname);
		
		editstudent_email = new JTextField();
		editstudent_email.setColumns(10);
		editstudent_email.setBounds(241, 204, 217, 31);
		contentPane.add(editstudent_email);
		
		editstudent_course = new JTextField();
		editstudent_course.setColumns(10);
		editstudent_course.setBounds(240, 261, 217, 31);
		contentPane.add(editstudent_course);
		
		editstudent_age = new JTextField();
		editstudent_age.setBounds(576, 105, 96, 32);
		contentPane.add(editstudent_age);
		editstudent_age.setColumns(10);
		
		editstudent_gender = new JTextField();
		editstudent_gender.setColumns(10);
		editstudent_gender.setBounds(576, 159, 96, 32);
		contentPane.add(editstudent_gender);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("ID:");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3_1.setBounds(545, 213, 30, 21);
		contentPane.add(lblNewLabel_1_1_3_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(576, 210, 96, 32);
		contentPane.add(textField);
	}

}
