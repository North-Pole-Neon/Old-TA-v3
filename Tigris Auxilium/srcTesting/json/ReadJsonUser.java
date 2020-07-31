package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonUser {
	@SuppressWarnings("unchecked")
	public void ReadToJson() { //Static might be optional
		

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
        String firstName = (String) userObject.get("firstName");    
        System.out.println(firstName);
         
        //Get user last name
        String lastName = (String) userObject.get("lastName");  
        System.out.println(lastName);
         
        //Get user grade name
        String grade = (String) userObject.get("grade");    
        System.out.println(grade);
        
      //Get user isd name
        String isd = (String) userObject.get("isd");    
        System.out.println(isd);
        
      //Get user PcName name
        String PcName = (String) userObject.get("PCName");
        System.out.println(PcName);
    }
	
}
