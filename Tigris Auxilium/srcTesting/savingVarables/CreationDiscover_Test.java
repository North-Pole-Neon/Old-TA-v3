
package savingVarables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CreationDiscover_Test {

	public static void main(String[] args) {
		

		///*
		PersonalTesting Test1 = new PersonalTesting("Tyler", 10, 720); //Creates record
		
		try {
			FileOutputStream fos = new FileOutputStream(new File("./srcTesting/savingVarables/UserBasicInfo.tigaux")); //Custom Extension
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(Test1);
			oos.close();
			fos.close();
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		//*/
		
		/*
		try {
			FileInputStream fis = new FileInputStream(new File("./srcTesting/savingVarables/UserBasicInfo.tigaux"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			PersonalTesting Test2 = (PersonalTesting)ois.readObject();
			ois.close();
			fis.close();
			
			System.out.println(Test2.getName()); //Use .get to reset the varaibles after launch
			
		}catch(IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		*/
		
		
	}

}
