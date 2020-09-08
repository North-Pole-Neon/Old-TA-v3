package mainFolder.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RWJsonBTabs {

	// Might need to be static
	// Make 6
		public static String link1;
		public static String link1Cb;
		public static String link2;
		public static String link2Cb;
		public static String link3;
		public static String link3Cb;
		public static String link4;
		public static String link4Cb;
		public static String link5;
		public static String link5Cb;
		public static String link6;
		public static String link6Cb;
		//public static String setupCom = "false";
		public boolean bSetupCom = false;
		
		public static String finalPath;
		public static String LinksFilePath;
		public static Boolean fileLinksExists;
		
		@SuppressWarnings("unchecked")
		public static void WriteToJson() {

			//First user
		        JSONObject linkdata1 = new JSONObject();
		        linkdata1.put("jlink1", link1);
		        linkdata1.put("jlink1Cb", link1Cb);
		        linkdata1.put("jlink2", link2);
		        linkdata1.put("jlink2Cb", link2Cb);
		        linkdata1.put("jlink3", link3);
		        linkdata1.put("jlink3Cb", link3Cb);
		        linkdata1.put("jlink4", link4);
		        linkdata1.put("jlink4Cb", link4Cb);
		        linkdata1.put("jlink5", link5);
		        linkdata1.put("jlink5Cb", link5Cb);
		        linkdata1.put("jlink6", link6);
		        linkdata1.put("jlink6Cb", link6Cb);
		        
		        JSONObject userObject = new JSONObject(); 
		        userObject.put("linkSet1", linkdata1);
		         
		     
		         
		        //Add user to list
		        JSONArray userList = new JSONArray();
		        userList.add(userObject);
		        //employeeList.add(employeeObject2);
		         
		        //Write JSON file FileWriter file = new FileWriter("assets/JSON Files/Links.json")
		        try (FileWriter file = new FileWriter(LinksFilePath)) {
		        	
		        	file.write(userList.toJSONString());
		        	file.flush();
		        	file.close(); //Might be problem
		 
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        System.out.println("JSON Link file created"); //PRINT JSON Link file created
		    }
			
			@SuppressWarnings("unchecked")
			public static void ReadToJson() { //Static might be optional -------------------------------------------------------------------
				

				//JSON parser object to parse read file
		        JSONParser jsonParser = new JSONParser();
		        
		        try (FileReader reader = new FileReader(LinksFilePath))	
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
		        JSONObject userObject = (JSONObject) user.get("linkSet1");
		        
		        //Get 1st link data
		        link1 = (String) userObject.get("jlink1");
		        link1Cb = (String) userObject.get("jlink1Cb");    
		        
		      //Get 2nd link data
		        link2 = (String) userObject.get("jlink2");
		        link2Cb = (String) userObject.get("jlink2Cb");    
		       
		      //Get 3rd link data
		        link3 = (String) userObject.get("jlink3");
		        link3Cb = (String) userObject.get("jlink3Cb");    
		        
		      //Get 4th link data
		        link4 = (String) userObject.get("jlink4");
		        link4Cb = (String) userObject.get("jlink4Cb");    
		        
		      //Get 5th link data
		        link5 = (String) userObject.get("jlink5");
		        link5Cb = (String) userObject.get("jlink5Cb");    
		        
		      //Get first link data
		        link6 = (String) userObject.get("jlink6");
		        link6Cb = (String) userObject.get("jlink6Cb");
		        
		        System.out.println(link1 +" "+ link1Cb +" | "+link2 +" "+ link2Cb);//PRINT Links and chbx
		        System.out.println(link3 +" "+ link3Cb +" | "+link4 +" "+ link4Cb);
		        System.out.println(link5 +" "+ link5Cb +" | "+link6 +" "+ link6Cb);
		        
		    }
			
			public static void pathMaker(String os) {
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
					LinksFilePath = finalPath + "\\Links.json";
				} else {
					LinksFilePath = finalPath + "/Links.json";
				}
			
				System.out.println("User JSON file path is: " +LinksFilePath); //PRINT finalPath
				
				
				
			}
			public static void LinksFileExists(String os) { //LATER Follow Universal idea on RWJsonUser
					boolean temp = new File(LinksFilePath).isFile();
					System.out.println("User file exists: " + temp); //PRINT User file exists
					fileLinksExists = temp;
				
	}
}
