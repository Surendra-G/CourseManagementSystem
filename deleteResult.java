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

public class deleteResult extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField deleteresult_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteResult frame = new deleteResult();
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
	public deleteResult() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 363);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Student's Result");
		lblNewLabel.setBounds(212, 70, 207, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(155, 150, 64, 20);
		contentPane.add(lblNewLabel_1);
		
		deleteresult_ID = new JTextField();
		deleteresult_ID.setBounds(226, 145, 169, 29);
		contentPane.add(deleteresult_ID);
		deleteresult_ID.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emailText = deleteresult_ID.getText();
                
               
                
                // Student's Result deleted successfully
                JOptionPane.showMessageDialog(null, "Student's Result Deleted Successfully");
                admin_result ar = new admin_result();
                ar.setVisible(true);
                dispose();

                // Delete student's result from database
                try (Connection connection = database.getConnection()) {
                    String deleteUserQuery = "DELETE FROM result WHERE Email = ?";

                    try (PreparedStatement statement = connection.prepareStatement(deleteUserQuery)) {
                        statement.setString(1, emailText);
                        
                        statement.executeUpdate();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());
                }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(181, 203, 113, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Enter the Email of the Student ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(226, 127, 193, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_result ar = new admin_result();
				ar.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(320, 203, 113, 33);
		contentPane.add(btnCancel);
	}
}
