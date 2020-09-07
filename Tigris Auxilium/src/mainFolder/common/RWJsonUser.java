package mainFolder.common;

import java.io.File;
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
	
	public static String osName;
	public static Boolean fileUserExists;
	public static Boolean folderUserExists;
	public static String finalPath;
	public static String UserFilePath;
	
		
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
	         
	        
	         
	        //Add user to list
	        JSONArray userList = new JSONArray();
	        userList.add(userObject);
	         
	        //Write JSON file
	        try (FileWriter file = new FileWriter(UserFilePath)) {
	 
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
	         
	        try (FileReader reader = new FileReader(UserFilePath))
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
		
		
		public static void getComputerName(Boolean test) //-----------------------------GET COMPUTER NAME--------------------------
		{
			String PCnameStr;
			
			
		    Map<String, String> env = System.getenv();
		    if (env.containsKey("COMPUTERNAME"))
		    	PCnameStr = env.get("COMPUTERNAME");
		    else if (env.containsKey("HOSTNAME"))
		    	PCnameStr = env.get("HOSTNAME");
		    else
		    	PCnameStr = "Unknown Computer";
		    
		    if(test == true) {
				PCNAME = PCnameStr;
			}else {
				PCName = PCnameStr;
			}
		}
		
		public static String getOSVersion() { //----------------------------------GET OS VERSION--------------------------------
			String os_name = null;
	        os_name = System.getProperty("os.name");
	        System.out.println("OS name is: " + os_name);
	        osName = os_name;
	        return os_name;
		}
		
		
		
		public static void pathMaker(String os) {//-------------------------------------PATH MAKER-------------------------------------
			String homePath;
			if (os.equals("Windows 10") || os.equals("Windows 8") || os.equals("Windows 7")) {
				homePath = "C:\\Test\\TA\\Data";
			} else {
				homePath = System.getProperty("user.home");
				homePath = homePath + "/TA/Data/";
			}
			
			System.out.println("Home dir path: " + homePath); //PRINT Home dir
			File fileDir = new File(homePath);
			if (!fileDir.exists()) fileDir.mkdirs(); //Might be an issue
			
			finalPath = homePath;
			
			if (os.equals("Windows 10") || os.equals("Windows 8") || os.equals("Windows 7")) {
				UserFilePath = finalPath + "\\User.json";
			} else {
				UserFilePath = finalPath + "/User.json";
			}
		
			System.out.println("User JSON file path is: " +UserFilePath); //PRINT finalPath
			
			
			
		}
		public static void userFileExists(String os) { //LATER Make universal for any file check
			if (os.equals("Windows 10") || os.equals("Windows 8") || os.equals("Windows 7")) {
				boolean temp = new File(UserFilePath).isFile();
				System.out.println("User file exists: " + temp); //PRINT User file exists
				fileUserExists = temp;
			} else {
				boolean temp = new File(UserFilePath).isFile();
				System.out.println("User file exists: " + temp);
				fileUserExists = temp;
			}
			
			
			
			
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
