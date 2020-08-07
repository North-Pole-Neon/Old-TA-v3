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
		
		File f;
		String fileName;
		
		f = new File(ogPath);
		fileName = f.getName();
		// TODO Make applescripts use getPath
		
		//-------Shorten for just folder tool
		if (os.equals("Windows 10") || os.equals("Windows 8") || os.equals("Windows 7")) {
			String path = "C:\\Test\\TA\\Data";
			File file = new File(path);
			finalPath = path;
			UserFilePath = finalPath + "\\User.json"; //TODO Needs to be name of file // <-- Important part
			if (!file.exists()) file.mkdirs(); //Might be an issue
			
		} else {
			
			String paths = System.getProperty("user.home"); //Get path
			System.out.println(paths); //PRINT Paths
			
			full = paths + "/TA/Data/"; //Create basic path
			System.out.println(full); //Print path
			
			File file = new File(full); //Creates path
			
			finalPath = full;
			UserFilePath = finalPath + "/User.json"; // <-- Important part
			if (!file.exists()) file.mkdirs(); //Might be an issue
			
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
