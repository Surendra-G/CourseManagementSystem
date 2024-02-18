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

public class delete_teacher extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField deleteteacher_ID;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    delete_teacher frame = new delete_teacher();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public delete_teacher() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 621, 363);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Delete Teacher");
        lblNewLabel.setBounds(227, 64, 181, 33);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("ID:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(173, 150, 64, 20);
        contentPane.add(lblNewLabel_1);
        
        
        
        JButton btnNewButton = new JButton("Delete");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idText = deleteteacher_ID.getText();
                
                int id;
                try {
                    id = Integer.parseInt(idText);
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid integer values for ID.");
                    return;
                }
                
                // Teacher deleted successfully
                JOptionPane.showMessageDialog(null, "Teacher Deleted Successfully");
                dispose();
                Courses stud = new Courses();
                stud.setVisible(true);

                // Delete teacher from database
                try (Connection connection = database.getConnection()) {
                    String deleteUserQuery = "DELETE FROM Teachers WHERE TeacherID = ?";

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
        btnNewButton.setBounds(186, 218, 113, 33);
        contentPane.add(btnNewButton);
        
        deleteteacher_ID = new JTextField();
        deleteteacher_ID.setBounds(227, 148, 169, 33);
        contentPane.add(deleteteacher_ID);
        deleteteacher_ID.setColumns(10);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Teachers at = new Teachers();
        		at.setVisible(true);
        		dispose();
        	}
        });
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCancel.setBounds(328, 218, 113, 33);
        contentPane.add(btnCancel);
    }

}
