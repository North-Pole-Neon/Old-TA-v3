package Misc;

import java.util.Map;

public class hostName {

	public static void main(String[] args) {
		System.out.println("hi");
		getComputerName();
		System.out.println(getComputerName());

	}
	
	private static String getComputerName()
	{
	    Map<String, String> env = System.getenv();
	    if (env.containsKey("COMPUTERNAME"))
	        return env.get("COMPUTERNAME");
	    else if (env.containsKey("HOSTNAME"))
	        return env.get("HOSTNAME");
	    else
	        return "Unknown Computer";
	}

}
