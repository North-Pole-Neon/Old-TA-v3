package mainFolder.common.UserSavingScripts;

import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJsonUser {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		

		//First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Phill");
        employeeDetails.put("lastName", "Moen");
        employeeDetails.put("grade", "10");
        employeeDetails.put("isd", "720");
        employeeDetails.put("PCName", "TYLERDESK");
         
        JSONObject employeeObject = new JSONObject(); 
        employeeObject.put("employee", employeeDetails);
         
        //Second Employee
        /*JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Tyler");
        employeeDetails2.put("lastName", "Johnson");
        employeeDetails2.put("grade", "11");
        employeeDetails2.put("isd", "420");
        employeeDetails2.put("PCName", "PhillDESK");
         
        JSONObject employeeObject2 = new JSONObject(); 
        employeeObject2.put("employee", employeeDetails2);*/
         
        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        //employeeList.add(employeeObject2);
         
        //Write JSON file
        try (FileWriter file = new FileWriter("assets/JSON Files/User.json")) {
 
            file.write(employeeList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}
