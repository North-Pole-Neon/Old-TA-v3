package mainFolder.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RWJsonUser {

	// Might need to be static
	public static String firstName;
	public static String lastName;
	public static String sGrade;
	public int iGrade = Integer.parseInt(sGrade);
	public static String sIsd;
	public int iIsd = Integer.parseInt(sIsd);
	public static String PCName;
	public static String PCNAME;
	public static String setupCom = "false";
	public boolean bSetupCom = false;
		
	@SuppressWarnings("unchecked")
	public static void WriteToJson() {

		//First user
	        JSONObject userDetails = new JSONObject();
	        userDetails.put("firstName", firstName);
	        userDetails.put("lastName", lastName);
	        userDetails.put("grade", sGrade);
	        userDetails.put("isd", sIsd);
	        userDetails.put("PCName", PCName);
	        userDetails.put("setupCom", setupCom);
	         
	        JSONObject userObject = new JSONObject(); 
	        userObject.put("user", userDetails);
	         
	        //Second user
	        /*JSONObject employeeDetails2 = new JSONObject();
	        employeeDetails2.put("firstName", "Tyler");
	        employeeDetails2.put("lastName", "Johnson");
	        employeeDetails2.put("grade", "11");
	        employeeDetails2.put("isd", "420");
	        employeeDetails2.put("PCName", "PhillDESK");
	         
	        JSONObject employeeObject2 = new JSONObject(); 
	        employeeObject2.put("employee", employeeDetails2);*/
	         
	        //Add user to list
	        JSONArray userList = new JSONArray();
	        userList.add(userObject);
	        //employeeList.add(employeeObject2);
	         
	        //Write JSON file
	        try (FileWriter file = new FileWriter("assets/JSON Files/User.json")) {
	 
	            file.write(userList.toJSONString());
	            file.flush();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        System.out.println("JSON Created"); //PRINT JSON Created
	    }
		
		@SuppressWarnings("unchecked")
		public static void ReadToJson() { //Static might be optional -------------------------------------------------------------------
			

			//JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();
	         
	        try (FileReader reader = new FileReader("assets/JSON Files/User.json"))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray userList = (JSONArray) obj;
	            System.out.println(userList);
	             
	            //Iterate over user array
	            userList.forEach( emp -> parseUserObject( (JSONObject) emp ) );
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

		}
		
		private static void parseUserObject(JSONObject user) 
	    {
	        //Get user object within list
	        JSONObject userObject = (JSONObject) user.get("user");
	        
	        //Get user first name
	        firstName = (String) userObject.get("firstName");    
	        System.out.println(firstName);
	        
	        
	        //Get user last name
	        lastName = (String) userObject.get("lastName");  
	        System.out.println(lastName);
	        
	        
	        //Get user grade name
	        sGrade = (String) userObject.get("grade");    
	        System.out.println(sGrade);
	        
	        
	      //Get user isd name
	        sIsd = (String) userObject.get("isd");    
	        System.out.println(sIsd);
	        
	        
	      //Get user PcName name
	        PCName = (String) userObject.get("PCName");
	        System.out.println(PCName);
	        
	        //Get user setup status
	        setupCom = (String) userObject.get("setupCom");
	        System.out.println(setupCom);
	        
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
		
		public static void clearUserData() {
			firstName = null;
			lastName = null;
			sGrade = null;
			sIsd = null;
			PCName = null;
			setupCom = null;
			WriteToJson();
		}
		
}

/*
 *What to have here:
 * Have global variables be listed
 * 
 * Write Function
 *  Names be based on variables
 *  LATER Universal saving function
 *  
 * Read Function
 * 	Assign variables after load
 * 
 * PC Name finder
 */
