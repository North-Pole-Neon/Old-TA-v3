package mainFolder.common;


import java.sql.*;

import javax.swing.JOptionPane;

public class SqliteConnection {
	Connection conn = null;
	public static Connection dbConnectorPP() {
		
		String fullPath;
		String OS = RWJsonUser.osName;
		
		if (OS.equals("Windows 10") || OS.equals("Windows 8") || OS.equals("Windows 7")) {
			fullPath = "C:\\Test\\TA\\Data\\ProjectPlanner.sqlite";
			
		} else {
			
			String paths = System.getProperty("user.home");
			//System.out.println(paths);
			
			fullPath = paths + "/TA/Data/ProjectPlanner.sqlite";
			//System.out.println(full);
		} //XXX Needs to load all data first than work
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+fullPath);    
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			System.out.println("Connection Successful");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
public static Connection dbConnectorCol() {
		
		String fullPath;
		String OS = RWJsonUser.osName;
		
		/*if (OS.equals("Windows 10") || OS.equals("Windows 8") || OS.equals("Windows 7")) {
			fullPath = "C:\\Test\\TA\\Data\\Collections.sqlite";
			
		} else {
			
			String paths = System.getProperty("user.home");
			//System.out.println(paths);
			
			fullPath = paths + "/TA/Data/Collections.sqlite";
			//System.out.println(full);
		} //XXX Needs to load all data first than work */
		
		fullPath = "C:\\Users\\user\\Desktop\\Collections.sqlite";
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+fullPath);    
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			System.out.println("Connection Successful");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
}


///home/tyler/Documents/ProjectPlanner  |  jdbc:sqlite:C:\\Users\\user\\Desktop\\ProjectPlanner.sqlite |  "jdbc:sqlite:" + fullPath