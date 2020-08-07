package mainFolder.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MacAppInstaller {

	public static String ogAppPath;
	public static String nAppPath;
	public static String ogDMGPath;
	public static String nDMGPath;
	public static String ogPKGPath;
	public static String nPKGPath;
	
	public static void appInstall(String os, String ogPath) throws IOException {
		/*
		 * Gen folder
		 * Copy data
		 * Rename file
		 */
		String full;
		String finalPath;
		String UserFilePath;
		//String finalPath;
		
		//-------Shorten for just folder tool
		if (os.equals("Windows 10") || os.equals("Windows 8") || os.equals("Windows 7")) {
			String path = "C:\\Test\\TA\\Data";
			File file = new File(path);
			if (!file.exists()) file.mkdirs(); //Might be an issue
			finalPath = path;
			UserFilePath = finalPath + "\\User.json"; //TODO Needs to be name of file
		} else {
			//Path path = new Paths.get("test.txt");
			String paths = System.getProperty("user.home");
			System.out.println(paths); //PRINT Paths
			
			full = paths + "/TA/Data/";
			System.out.println(full);
			
			File file = new File(full);
			if (!file.exists()) file.mkdirs(); //Might be an issue
			finalPath = full;
			UserFilePath = finalPath + "/User.json";
		}
		System.out.println(finalPath); //PRINT finalPath
		
		//Check if file exists
		boolean temp = new File("C:\\Test\\TA\\Data\\junk.txt").isFile();
		System.out.println(temp);
		//-------
		
		//Copies
		Path source = Paths.get("c:/temp/testoriginal.txt");
	    Path destination = Paths.get("c:/temp/testcopied.txt");
	 
	    Files.copy(source, destination,  StandardCopyOption.COPY_ATTRIBUTES);
	    
	}
}
