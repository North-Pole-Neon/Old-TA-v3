package testing;

import java.io.FileWriter;

public class WritingFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String data = "This is the data in the output file from a jar";

	    try {
	      // Creates a FileWriter
	      FileWriter output = new FileWriter("C:\\Test\\filename.txt");

	      // Writes the string to the file
	      output.write(data);

	      // Closes the writer
	      output.close();
	    }

	    catch (Exception e) {
	      e.getStackTrace();
	    }

	}

}
