package mainFolder.common;

import java.sql.*;

import javax.swing.JOptionPane;

public class SqliteConnection {
	Connection conn = null;
	//String path = this.getClass().getClassLoader().getResource(<ProjectPlanner>).toExternalForm();
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			// FIXME Copy file to new host. Make create file script in data folder
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\user\\Desktop\\ProjectPlanner.sqlite"); // /home/tyler/Documents/ProjectPlanner
			JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
}
