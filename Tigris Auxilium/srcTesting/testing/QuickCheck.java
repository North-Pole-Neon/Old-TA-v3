package testing;

import java.io.File;

public class QuickCheck {

	public static void main(String[] args) {
		//pathCheck();
		//stringTest();
		osName();
	}

	static void pathCheck() {
		String full;
		String path;
		String os = "Windows 10";
		
		
		if (os.equals("Windows 10") || os.equals("Windows 8") || os.equals("Windows 7")) {
			path = "C:\\Test\\TA\\Data";
			File file = new File(path);
			if (!file.exists()) file.mkdirs(); //Might be an issue
			
		} else {
			//Path path = new Paths.get("test.txt");
			path = System.getProperty("user.home");
			System.out.println(path);

			full = path + "/TA/Data/";
			System.out.println(full);
			
			File file = new File(full);
			if (!file.exists()) file.mkdirs(); //Might be an issue
		}
	}
	
	static void stringTest() {
		String path = "Hello";
		path = path + " World";
		System.out.println(path);
	}
	
	static void osName() {
		 String os = System.getProperty("os.name").toLowerCase();
		 System.out.println(os);
	}
	
}
