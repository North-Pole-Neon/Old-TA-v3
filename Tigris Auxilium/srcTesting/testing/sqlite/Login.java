package testing.sqlite;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	
	/*
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		connection = sqliteConnection.dbConnector();
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(219, 97, 73, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(200, 178, 91, 42);
		contentPane.add(lblPassword);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(374, 94, 159, 45);
		contentPane.add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select * from EmployeeInfo where username = ? and password = ? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldUN.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						count++;
					}
					if (count == 1) {
						JOptionPane.showMessageDialog(null, "Usernane and Password is correct");
						
						
					}
					else if (count>1) {
						JOptionPane.showMessageDialog(null, "Usernane and Password is duplicate");
					}
					else {
						JOptionPane.showMessageDialog(null, "Usernane and Password is incorrect");
					}
					
					rs.close();
					pst.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnLogin.setBounds(336, 322, 159, 59);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(382, 189, 151, 42);
		contentPane.add(passwordField);
		
		
	}
}
