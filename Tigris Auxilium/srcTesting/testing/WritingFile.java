package testing;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritingFile {

	static String data = "This is the data's in the output file from a jar. Did it work!?!!";
	String paths;
	static String full;
	public static void main(String[] args) {
		
		pathMaker();
		//makeFile();
	}

	public static void pathMaker() {
		//Path path = new Paths.get("test.txt");
		String paths = System.getProperty("user.home");
		System.out.println(paths);
		System.getenv(paths);
		System.out.println(paths);
		
		String full = paths + "/Documents/Test/filesname.txt/";
		System.out.println(full);
		makeFile();
	}
	public static void makeFile() {
		try {
		      // Creates a FileWriter
		    	File myFile = new File("/Users/226331/Documents/Test/filesname.txt/");
		    FileWriter output = new FileWriter(myFile);

		      // Writes the string to the file
		      output.write(data);

		      // Closes the writer
		      output.close();
		    }

		    catch (Exception e) {
		      e.getStackTrace();
		      e.printStackTrace();
		    }
		
		    //String desktop = System.getProperty("user.home") + "/Desktop/";
		    //File myFile = new File(desktop +"MyFile.txt");
	}
	
}