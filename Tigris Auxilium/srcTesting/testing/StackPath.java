package testing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StackPath {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*Path p = Paths.get(System.getProperty("user.home"));
		Path candidate = p.resolve("Documentes");
		if (!Files.isDirectory(candidate)) candidate = p.resolve("My Documents");
		if (!Files.isDirectory(candidate)) candidate = p;
		p = p.resolve("Test").resolve("user.txt");
		Files.createDirectories(p.getParent());
		System.out.println(p);*/
		String paths = System.getProperty("user.home");
		System.out.println(paths);
		System.getenv(paths);
		System.out.println(paths);
		
		String full = paths + "/Documents/Test/filesname.txt/";
		System.out.println(full);
	}

}
