package testing;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SerialTest implements java.io.Serializable{ //TODO Make basic script than just change path name

	public String name;
	   public String address;
	   public transient int SSN;
	   public int number;
	   public DefaultTableModel tablesave;
	
	   public void mailCheck() {
		      System.out.println("Mailing a check to " + name + " " + address);
		   }

}
