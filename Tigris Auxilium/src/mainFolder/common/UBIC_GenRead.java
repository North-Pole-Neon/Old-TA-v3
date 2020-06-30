package mainFolder.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UBIC_GenRead {

	public String userNAME;
	public int userGRADE;
	public int userISD;
	public boolean setupCOMP;
	
	public void CUserBasic(String name, int grade, int isd, boolean done) { //Creates Save File
		
		
		
		UserBasicInfoClass Gen1 = new UserBasicInfoClass(name, grade, isd, done); //Creates record
	
		try 
		{
			FileOutputStream fos = new FileOutputStream(new File("./src/mainFolder/resources/UserBasicInfo.tigaux")); //Custom Extension
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		
			oos.writeObject(Gen1);
			oos.close();
			fos.close();
		
		}
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
		
		
		
		
		
		 
	}
	
	public void RUserBasic() { // Get user info
		
		
		try 
		{
			FileInputStream fis = new FileInputStream(new File("./src/mainFolder/resources/UserBasicInfo.tigaux"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			UserBasicInfoClass Gen2 = (UserBasicInfoClass)ois.readObject();
			ois.close();
			fis.close();
			
			System.out.println("Personal info: " + Gen2.getUserName() +", "+ Gen2.getUserGrade() +", "+ Gen2.getUserIsd() +", "+ Gen2.isSetupCompleted());
			// Thats a lot
			
			userNAME = Gen2.getUserName();
			userGRADE = Gen2.getUserGrade();
			userISD = Gen2.getUserIsd();
			
			
		}
		catch(IOException ex) 
		{
			ex.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		  
		
	}
	
	
	
	
}
