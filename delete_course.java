package FinalPortfolio;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class delete_course extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField deletecourse_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_course frame = new delete_course();
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
	public delete_course() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Course");
		lblNewLabel.setBounds(214, 82, 167, 33);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(173, 150, 64, 20);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = deletecourse_ID.getText();
                
                int id;
                try {
                    id = Integer.parseInt(idText);
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid integer values for ID.");
                    return;
                }
                
                // Teacher deleted successfully
                JOptionPane.showMessageDialog(null, "Course Deleted Successfully");
                dispose();
                Courses stud = new Courses();
                stud.setVisible(true);

                // Delete teacher from database
                try (Connection connection = database.getConnection()) {
                    String deleteUserQuery = "DELETE FROM Course WHERE CourseID = ?";

                    try (PreparedStatement statement = connection.prepareStatement(deleteUserQuery)) {
                        statement.setInt(1, id);
                        
                        statement.executeUpdate();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());
                }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(243, 218, 113, 33);
		contentPane.add(btnNewButton);
		
		deletecourse_ID = new JTextField();
		deletecourse_ID.setBounds(214, 150, 167, 25);
		contentPane.add(deletecourse_ID);
		deletecourse_ID.setColumns(10);
	}

}
