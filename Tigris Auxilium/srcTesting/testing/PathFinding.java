package testing;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathFinding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//c:\\Test\\folders\\myfile.txt
		Path path = Paths.get("c:\\Test\\folders\\myfile.txt");
		Path projects = Paths.get("c:\\Test", "folders");
		System.out.println(path);
		System.out.println(projects);
		System.out.println();

		String originalPath =
		        "d:\\data\\projects\\a-project\\.\\another-project";

		Path path1 = Paths.get(originalPath);
		System.out.println("path1 = " + path1);

		Path path2 = path1.normalize();
		System.out.println("path2 = " + path2);
	}

}
