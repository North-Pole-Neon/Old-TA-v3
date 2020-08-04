package testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class Shells {

	public static void main(String[] args) {
		winShell();
	}
	
	public static void winShell() {
		try {
			Process p = Runtime.getRuntime().exec("cmd /c scripts\\test.bat");
			
			InputStream is = p.getInputStream();
			
			int i = 0;
			StringBuffer sb = new StringBuffer();
			while ((i = is.read()) != -1)
				sb.append((char)i);
			
			System.out.println(sb.toString());
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void macShell() {
		 
	}
	
	


}
