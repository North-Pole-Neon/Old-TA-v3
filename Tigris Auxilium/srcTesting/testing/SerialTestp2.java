package testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialTestp2 {

	public static String names;
	
	public static void main(String[] args) {
		
		deser();
		
		//SerialTest r = new SerialTest();
		//String test = r.name;
		System.out.println("Good morning, " + names);
	}

	public static void ser() {
		SerialTest e = new SerialTest();
	      e.name = "Reyan Ali";
	      e.address = "Phokka Kuan, Ambehta Peer";
	      e.SSN = 11122333;
	      e.number = 101;
	      
	      try {
	         FileOutputStream fileOut =
	         new FileOutputStream("C:\\Test\\TA\\Data\\employee.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
	         System.out.println("Serialized data is saved in C:\\Test\\TA\\Data\\employee.ser");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public static void deser() {
		
		SerialTest e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("C:\\Test\\TA\\Data\\employee.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (SerialTest) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	      names = e.name;
	      System.out.println("Deserialized Employee...");
	      System.out.println("Name: " + e.name);
	      System.out.println("Address: " + e.address);
	      System.out.println("SSN: " + e.SSN);
	      System.out.println("Number: " + e.number);
	      System.out.println("Test: " + names);
		
	}
	
}
