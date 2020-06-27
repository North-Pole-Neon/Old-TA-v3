package mainFolder.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UBIC_GenRead {

	
	public void Funny() {
		
		// /*
		
		UserBasicInfoClass Gen1 = new UserBasicInfoClass("Tyler", 10, 720); //Creates record
	
		try 
		{
			FileOutputStream fos = new FileOutputStream(new File("./srcTesting/savingVarables/UserBasicInfo.tigaux")); //Custom Extension
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		
			oos.writeObject(Gen1);
			oos.close();
			fos.close();
		
		}
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
		
		// */
		
		
		
		// /*
		try 
		{
			FileInputStream fis = new FileInputStream(new File("./srcTesting/savingVarables/UserBasicInfo.tigaux"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			UserBasicInfoClass Gen2 = (UserBasicInfoClass)ois.readObject();
			ois.close();
			fis.close();
			
			System.out.println(Gen2.getUserName()); //Use .get to reset the variables after launch
			
		}
		catch(IOException ex) 
		{
			ex.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		//  */
	}
	
	
	
}
