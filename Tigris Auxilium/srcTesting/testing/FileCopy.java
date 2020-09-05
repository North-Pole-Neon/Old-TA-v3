package testing;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import mainFolder.views.PanelSetup;

public class FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileCopy tests = new FileCopy();
		tests.makeFolder();
		
	}
	
	public void makeFolder() {
		makeFile("/mainFolder/resources/Test.txt");
	}
	
	public void makeFile(String path) {
		
		Path source = null;
		try {
			source = Paths.get(PanelSetup.class.getResource(path).toURI());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    Path destination = Paths.get("C:\\Test\\TA\\Data\\Test23.txt");
	 
	    try {
			Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
