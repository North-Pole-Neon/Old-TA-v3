package mainFolder.common;

import javax.swing.table.DefaultTableModel;

public class SerializeHWT implements java.io.Serializable{

	/*
	 * 
	 */
	private static final long serialVersionUID = 8873421550420311240L;
	public String name;
	public String address;
	
	public DefaultTableModel tablesave;
	
	public void mailCheck() {
	      System.out.println("Mailing a check to " + name + " " + address);
	   }
}
