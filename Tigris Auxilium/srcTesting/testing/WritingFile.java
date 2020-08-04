package testing;

import java.io.File;
import java.io.FileWriter;

public class WritingFile {

	static String data = "This is THe DATA in the output file from a jar. Did it work!?!!";
	//static String paths;
	static String full;
	//static String tester = "/Users/226331/Documents/Test/filesname.txt/";
	public static void main(String[] args) {
		
		pathMaker();
		makeFile();
	}

	public static void pathMaker() {
		//Path path = new Paths.get("test.txt");
		String paths = System.getProperty("user.home");
		System.out.println(paths);
		//System.getenv(paths);
		//System.out.println(paths);
		
		full = paths + "/Documents/Test/filesname.txt/";
		System.out.println(full);
	}
	public static void makeFile() {
		try {
		      // Creates a FileWriter
		    	File myFile = new File(full);
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
	}
	
}