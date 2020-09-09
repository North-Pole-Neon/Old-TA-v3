package mainFolder.common;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class SqliteConnection { //TODO Needs to load app, copy files, connect
	Connection conn = null;
	
public Connection dbConnector(String fName) {
		
		String fullPath;
		String OS = RWJsonUser.osName;
		
		if (OS.equals("Windows 10") || OS.equals("Windows 8") || OS.equals("Windows 7")) {
			fullPath = "C:\\Test\\TA\\Data\\"+fName+".sqlite";
			
		} else {
			
			fullPath = System.getProperty("user.home") + "/TA/Data/"+fName+".sqlite";
			//System.out.println(full);
		} 
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+fullPath);
			System.out.println("Connection Successful with: " + fName);//PRINT Connection Successful
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}


///home/tyler/Documents/ProjectPlanner  |  jdbc:sqlite:C:\\Users\\user\\Desktop\\ProjectPlanner.sqlite |  "jdbc:sqlite:" + fullPath