package mainFolder.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ShellRunner {
	
	public static Boolean isWin;
	
	@SuppressWarnings("unused")
	private String wSleep = "rundll32.exe powrprof.dll,SetSuspendState 0,1,0";
	@SuppressWarnings("unused")
	private String wShutdown = "shutdown /s";
	
	@SuppressWarnings("unused")
	private String mSleep = "pmset sleepnow";
	//Can't shutdown mac without sudo
	
	public static void winShell() {
		try {
			Process p = Runtime.getRuntime().exec("cmd /c min"); // Can execute commands with "cmd /c " + Command 
			
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
	
	public void macShell(String com) throws InterruptedException {
		 String [] command = {"sh", com}; //Can turn to command "/Users/226331/Desktop/fun.sh"
		 ProcessBuilder processBuilder = new ProcessBuilder(command);
		 processBuilder.directory(new File(System.getProperty("user.home")));
		 
		 try {
			 Process process = processBuilder.start();
			 BufferedReader reader = new BufferedReader  (new InputStreamReader(process.getInputStream()));
			 
			 String line;
			 
			 while ((line = reader.readLine()) != null) {
				 System.out.println(line);
				 
			 }
			 int exitCode = process.waitFor();
			 
			 System.out.println("\nExited with error code : " + exitCode);
		 }catch (IOException e) {
			 e.printStackTrace();
		 }
	}
}
