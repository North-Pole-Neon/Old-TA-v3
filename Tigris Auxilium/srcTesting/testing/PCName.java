package testing;

import java.util.Map;
//import java.util.Properties;

public class PCName {

	static String PCNAME = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getComputerName();
		System.out.println(PCNAME);
		getOS();
	}

	public static void getComputerName() //-------------------------------------------------------
	{
	    Map<String, String> env = System.getenv();
	    if (env.containsKey("COMPUTERNAME"))
	        PCNAME = env.get("COMPUTERNAME");
	    else if (env.containsKey("HOSTNAME"))
	    	PCNAME = env.get("HOSTNAME");
	    else
	    	PCNAME = "Unknown Computer";
	}
	
	public static void getOS() {
		String os_name = null;
        os_name = System.getProperty("os.name");
        System.out.println("OS name is: " + os_name);
	}
}
