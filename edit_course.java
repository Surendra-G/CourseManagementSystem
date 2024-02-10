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

public class edit_course extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField editcourse_module;
	private JTextField editcourse_coursename;
	private JTextField editcourse_batch;
	private JTextField editcourse_seats;
	private JTextField editcourse_ID;
	private JTextField editcourse_year_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_course frame = new edit_course();
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
	public edit_course() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 503);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(342, 23, 134, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Module: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(163, 103, 95, 21);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Course Name: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(125, 148, 106, 21);
		contentPane.add(lblNewLabel_1_1);
		
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Batch:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(174, 190, 68, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		
		
		JLabel lblNewLabel_1_1_2 = new JLabel("No.of.Seats:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(137, 233, 94, 21);
		contentPane.add(lblNewLabel_1_1_2);
		
		
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String ModuleText = editcourse_module.getText();
			        String courseNameText = editcourse_coursename.getText();
			        String BatchText = editcourse_batch.getText();
			        String seatText = editcourse_seats.getText();
			        String yearText = editcourse_year_input.getText();
			        String idText = editcourse_ID.getText();

			        // Validate input
			        if (ModuleText.isEmpty() || courseNameText.isEmpty() || BatchText.isEmpty() || seatText.isEmpty()
			                || yearText.isEmpty() || idText.isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Please fill up all the fields to update.");
			            return;
			        }

			        // Validate integer inputs
			        int batch;
			        int seats;
			        int years;
			        int id;

			        try {
			            batch = Integer.parseInt(BatchText);
			            seats = Integer.parseInt(seatText);
			            years = Integer.parseInt(yearText);
			            id = Integer.parseInt(idText);
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(null, "Please enter valid integer values for Batch, Seats, Years, and ID.");
			            return;
			        }

			        // Course updated successfully
			        JOptionPane.showMessageDialog(null, "Course Updated Successfully");
			        dispose();
			        Courses stud = new Courses();
			        stud.setVisible(true);

			        // Update course details in the database
			        try (Connection connection = database.getConnection()) {
			            String updateUserQuery = "UPDATE Course SET Module = ?, CourseName = ?, Batch = ?, Seats = ?, Years = ? WHERE CourseID = ?";
			            
			            try (PreparedStatement statement = connection.prepareStatement(updateUserQuery)) {
			                statement.setString(1, ModuleText);
			                statement.setString(2, courseNameText);
			                statement.setInt(3, batch);
			                statement.setInt(4, seats);
			                statement.setString(5, yearText);
			                statement.setInt(6, id); 

			                int rowsAffected = statement.executeUpdate();
			                
			                if (rowsAffected > 0) {
			                    JOptionPane.showMessageDialog(null, "Course Updated Successfully");
			                    dispose();
			                    Courses course = new Courses();
			                    course.setVisible(true);
			                } else {
			                    JOptionPane.showMessageDialog(null, "Failed to update Course details.");
			                }
			            }
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + ex.getMessage());
			        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(331, 322, 134, 42);
		contentPane.add(btnNewButton);
		
		editcourse_module = new JTextField();
		editcourse_module.setBounds(241, 103, 174, 26);
		contentPane.add(editcourse_module);
		editcourse_module.setColumns(10);
		
		editcourse_coursename = new JTextField();
		editcourse_coursename.setColumns(10);
		editcourse_coursename.setBounds(241, 148, 174, 26);
		contentPane.add(editcourse_coursename);
		
		editcourse_batch = new JTextField();
		editcourse_batch.setColumns(10);
		editcourse_batch.setBounds(241, 185, 174, 26);
		contentPane.add(editcourse_batch);
		
		editcourse_seats = new JTextField();
		editcourse_seats.setColumns(10);
		editcourse_seats.setBounds(241, 233, 174, 26);
		contentPane.add(editcourse_seats);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(468, 111, 40, 21);
		contentPane.add(lblNewLabel_1_2);
		
		editcourse_ID = new JTextField();
		editcourse_ID.setColumns(10);
		editcourse_ID.setBounds(507, 106, 68, 26);
		contentPane.add(editcourse_ID);
		
		JLabel editcourse_year = new JLabel("Year:");
		editcourse_year.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editcourse_year.setBounds(457, 148, 51, 21);
		contentPane.add(editcourse_year);
		
		editcourse_year_input = new JTextField();
		editcourse_year_input.setColumns(10);
		editcourse_year_input.setBounds(507, 145, 68, 26);
		contentPane.add(editcourse_year_input);
		
		
	}

}
