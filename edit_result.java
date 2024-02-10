package FinalPortfolio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class edit_result extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField editresult_ID;
	private JTextField editresult_module;
	private JTextField editresult_courseName;
	private JTextField editresult_marks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_result frame = new edit_result();
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
	public edit_result() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Result");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(299, 10, 134, 37);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CourseName:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(176, 223, 110, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Module:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(218, 160, 68, 21);
		contentPane.add(lblNewLabel_1_1_2);
		
		
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = editresult_ID.getText();
				String courseName = editresult_courseName.getText();
				String module = editresult_module.getText();
				String marksText = editresult_marks.getText();
				
				// Validate input
                if (idText.isEmpty()  || courseName.isEmpty() || module.isEmpty() || marksText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up all the add the result.");
                    return;
                }
                

                // Validate integer inputs
                int marks;
                int id;

                try {
                	marks = Integer.parseInt(marksText);
                	id = Integer.parseInt(idText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid integer values for Marks.");
                    return;
                }
                
             // Course added successfully
                JOptionPane.showMessageDialog(null, "Result Updated Successfully");
                dispose();
                admin_result resforteach = new admin_result();
                resforteach.setVisible(true);

                // Insert course into database
                try (Connection connection = database.getConnection()) { 
                	String updateUserQuery = "UPDATE result SET Module = ?, CourseName = ?, Marks = ? WHERE ID = ?";

                    try (PreparedStatement statement = connection.prepareStatement(updateUserQuery)) {
                        statement.setString(1, module);
                        statement.setString(2, courseName);
                        statement.setInt(3, marks);
                        statement.setInt(4, id);
                        statement.executeUpdate();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());
                }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(322, 361, 134, 42);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("ID:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(243, 102, 40, 21);
		contentPane.add(lblNewLabel_1_2);
		
		
		
		JLabel editcourse_year = new JLabel("Marks:");
		editcourse_year.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editcourse_year.setBounds(218, 298, 51, 21);
		contentPane.add(editcourse_year);
		
		editresult_ID = new JTextField();
		editresult_ID.setBounds(279, 95, 224, 28);
		contentPane.add(editresult_ID);
		editresult_ID.setColumns(10);
		
		editresult_module = new JTextField();
		editresult_module.setColumns(10);
		editresult_module.setBounds(279, 159, 224, 28);
		contentPane.add(editresult_module);
		
		editresult_courseName = new JTextField();
		editresult_courseName.setColumns(10);
		editresult_courseName.setBounds(279, 222, 224, 28);
		contentPane.add(editresult_courseName);
		
		editresult_marks = new JTextField();
		editresult_marks.setColumns(10);
		editresult_marks.setBounds(279, 290, 224, 28);
		contentPane.add(editresult_marks);
		
		
	}
}
