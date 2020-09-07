package testing;

import javax.swing.table.DefaultTableModel;

public class SerialTest implements java.io.Serializable{ 

	/*
	 * 
	 */
	private static final long serialVersionUID = -9020848592215378492L;
	public String name;
	   public String address;
	   public transient int SSN;
	   public int number;
	   public DefaultTableModel tablesave;
	
	   public void mailCheck() {
		      System.out.println("Mailing a check to " + name + " " + address);
		   }

}
