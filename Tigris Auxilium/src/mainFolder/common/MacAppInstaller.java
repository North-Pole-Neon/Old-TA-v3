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
		String NewFilePath;
		
		File f;
		String fileName;
		
		//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv--Makes Folder--vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		f = new File(ogPath);
		fileName = f.getName();
		// TODO Make applescripts use getPath
		
		//-------Shorten for just folder tool
		if (os.equals("Windows 10") || os.equals("Windows 8") || os.equals("Windows 7")) {
			String path = "C:\\Test\\TA\\Data";
			File file = new File(path);
			finalPath = path;
			NewFilePath = finalPath + "\\" + fileName; //CHXME file name might have extension
			if (!file.exists()) file.mkdirs(); 
			
		} else {
			
			String paths = System.getProperty("user.home"); //Get path
			System.out.println(paths); //PRINT Paths
			
			full = paths + "/TA/Data/"; //Create basic path
			System.out.println(full); //Print path
			
			File file = new File(full); //Creates path
			
			finalPath = full;
			NewFilePath = finalPath + "/" + finalPath; // CHXME file name
			if (!file.exists()) file.mkdirs();
			
		}
		System.out.println(finalPath); //PRINT finalPath
		
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		
		
		//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv --Copies file-- vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		Path source = Paths.get(ogPath); //TODO String to path
	    Path destination = Paths.get(NewFilePath);
	 
	    Files.copy(source, destination,  StandardCopyOption.COPY_ATTRIBUTES);
	    
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

	}
}
//226715