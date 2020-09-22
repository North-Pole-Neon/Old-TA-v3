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
	
	public static void appInstall(String ogPath) throws IOException {
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
		
		//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv--Makes Folder--vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv 1st 
		f = new File(ogPath);
		fileName = f.getName(); // ---------------Gets file name---
		// 
		
		
			String paths = System.getProperty("user.home"); //Get path
			System.out.println(paths); //PRINT Paths
			
			full = paths + "/Desktop/FixedApps/" + fileName; //Create basic path
			String fullContent = full + "/Contents/";
			System.out.println(full); //Print path
			
			File file = new File(full); //Creates path
			
			finalPath = fullContent;
			NewFilePath = finalPath; // 
			if (!file.exists()) file.mkdirs();
			
		
		System.out.println(finalPath); //PRINT finalPath
		
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		
		
		
		//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv --Copies file-- vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		
		
		
		String contentPath = ogPath + "/Contents/";//Copies file contents
		Path source = Paths.get(contentPath); //
	    Path destination = Paths.get(NewFilePath);
	 
	    Files.copy(source, destination,  StandardCopyOption.COPY_ATTRIBUTES);
	    
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

	  //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv --Rename file-- vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
	    //Get path as text for source2
	    //String nfpStr = NewFilePath - "/Contents/"
	    Path source2 = Paths.get(full);
	    Path target = Paths.get(full + ".app/"); //Might need to remove initial extension

	    try{

	      Files.move(source2, target);

	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	}
	
	
	public static void dmgInstall(String dmgPath) throws InterruptedException, IOException {
		ShellRunner sr = new ShellRunner();
		sr.macShell("hdiutil attach" + dmgPath);
		appInstall(dmgPath);//
	}
	
	public static void pkgInstall(String pkgPath) throws InterruptedException {
		
		
		// Make 1st folder path --vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		String full;
		File f;
		String fileName;
		
		f = new File(pkgPath);
		fileName = f.getName(); // ---------------Gets file name---
		// 
		
		
			String paths = System.getProperty("user.home"); //Get path
			System.out.println(paths); //PRINT Paths
			
			full = paths + "/Desktop/FixedApps/" + fileName; //Create basic path
			
			System.out.println(full); //Print path
			
			//File file = new File(full); //Creates path
			//if (!file.exists()) file.mkdirs();//Maybe don't create file but get path
			
			//----------------------------------------------------------------
		
			// Expand script--vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
			ShellRunner sr = new ShellRunner();
			sr.macShell("pkgutil --expand " + pkgPath + " " + full);
			//--------------------------------------------------------
			
			// Find pkg/payload--vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
			
			//
			String newFull = full + "/" +fileName + "/Payload"; //Complete guess
			String extFull = paths + "/Desktop/FixedApps/" +  "New " + fileName;
			//------------------------------------------------------
			
			// Create end folder--vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
			File file2 = new File(extFull);
			if (!file2.exists()) file2.mkdirs();
			//-----------------------------------------------------------
			
			//Payload extract-- vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
			sr.macShell("Tar -xvf " + newFull + " -C " + extFull);
			//-------------------------------------------------------
			//
	}
}

/*
 *     Create folder 

    Pkgutil –expand + filePath + folder path 

    Delete folder 

    Re-enter the  command 

    Find pkg file inside extracted folder 

    Find Payload 

    New folder 

    Tar –xvf + Payload + -C + folderPath 

    Seek .app 
 */