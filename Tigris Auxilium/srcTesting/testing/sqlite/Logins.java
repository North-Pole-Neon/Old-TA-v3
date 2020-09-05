package testing.sqlite;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Logins {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logins window = new Logins();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Logins() {
		initialize();
	}

	Connection connection = null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 828, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
connection = sqliteConnection.dbConnector();
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(219, 97, 73, 14);
		frame.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(200, 178, 91, 42);
		frame.add(lblPassword);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(374, 94, 159, 45);
		frame.add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
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
						
						frame.dispose();
						EmployeeInfo emplInfo = new EmployeeInfo();
						emplInfo.setVisible(true);
						
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
		frame.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(382, 189, 151, 42);
		frame.add(passwordField);
	}

}
