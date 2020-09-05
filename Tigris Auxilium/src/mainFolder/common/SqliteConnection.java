package mainFolder.common;


import java.sql.*;

import javax.swing.JOptionPane;

public class SqliteConnection {
	Connection conn = null;
	//String path = this.getClass().getClassLoader().getResource(<ProjectPlanner>).toExternalForm();
	public static Connection dbConnector() {
		
		String fullPath;
		String OS = RWJsonUser.osName;
		
		if (OS.equals("Windows 10") || OS.equals("Windows 8") || OS.equals("Windows 7")) {
			fullPath = "C:\\Test\\TA\\Data\\ProjectPlanner.sqlite";
			
		} else {
			
			String paths = System.getProperty("user.home");
			//System.out.println(paths);
			
			fullPath = paths + "/TA/Data/ProjectPlanner.sqlite";
			//System.out.println(full);
		} //FIXME Needs to load all data first than work
		
		try {
			Class.forName("org.sqlite.JDBC");
			// FIXME Copy file to new host. Make create file script in data folder
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+fullPath); // /home/tyler/Documents/ProjectPlanner  |  jdbc:sqlite:C:\\Users\\user\\Desktop\\ProjectPlanner.sqlite |  "jdbc:sqlite:" + fullPath   
			JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
}
