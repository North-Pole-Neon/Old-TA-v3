package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

import mainFolder.common.SqliteConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class PanelHomework extends JPanel {

	/*
	 * 
	 */
	private static final long serialVersionUID = -4160000612194093406L;
	private JTextField first;
	private JTextField second;
	private JTextField third;

	/*
	 * Create the panel.
	 */
	
	Connection connection = null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	private JTable table;
	
	public PanelHomework() {
		setBounds(100, 100, 859, 438);
		setLayout(null);
		
		connection = SqliteConnection.dbConnector();
		
		
		JLabel lblNewLabel = new JLabel("Hi their, the Homework page is not ready yet. :(");
		lblNewLabel.setBounds(203, 12, 428, 16);
		add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 35, 835, 391);
		add(tabbedPane);
		
		JPanel pProject = new JPanel();
		tabbedPane.addTab("Project Planner", null, pProject, null);
		pProject.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 12, 477, 202);
		pProject.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		first = new JTextField();
		first.setBounds(50, 226, 114, 19);
		pProject.add(first);
		first.setColumns(10);
		
		second = new JTextField();
		second.setBounds(193, 226, 114, 19);
		pProject.add(second);
		second.setColumns(10);
		
		third = new JTextField();
		third.setBounds(337, 226, 114, 19);
		pProject.add(third);
		third.setColumns(10);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DefaultTableModel model = (DefaultTableModel)table.getModel();
				//model.addRow(new Object [] {Integer.parseInt(first.getText()), Integer.parseInt(second.getText()), third.getText()}); //Save with sqlite
			}
		});
		btnRun.setBounds(193, 257, 117, 25);
		pProject.add(btnRun);
		
		JButton btnLoadTable = new JButton("Load data");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from ProjectInfo"; //Alt: "select ID, Name, Username from ProjectInfo"
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnLoadTable.setBounds(625, 32, 117, 25);
		pProject.add(btnLoadTable);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel ppLogin = new JPanel();
		tabbedPane.addTab("test Login", null, ppLogin, null);
		ppLogin.setLayout(null);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(388, 70, 114, 19);
		ppLogin.add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(PanelHomework.class.getResource("/mainFolder/resources/Ok-icon.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*try { //OLDCODE sql login
					String query = "select * from ProjectInfo where Username=? and Password=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldUN.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					
					while(rs.next()) { //LATER Use while loop for constant checks in future
						count = count + 1; //count++
					}
					if(count == 1) {
						JOptionPane.showMessageDialog(null, "Username and Password is correct");
					} else if(count >1) {
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					} else {
						JOptionPane.showMessageDialog(null, "Username and Password is incorrect /n Try again");
					}
					rs.close();
					pst.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					
				}*/
				
			}
		});
		btnLogin.setBounds(261, 250, 117, 25);
		ppLogin.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(406, 115, 123, 25);
		ppLogin.add(passwordField);
		
		
	}
}
