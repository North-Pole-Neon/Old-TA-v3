package gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonTest { //Add write to file

	public static void main(String[] args) {
		Customer c1 = new Customer();
		//c1.setName("YRR");
		c1.setCustID("123XYZ");
		c1.setOverdue(45.6f);
		
		//Ster
		//Gson json= new Gson();
		Gson json = new GsonBuilder().serializeNulls().create();
		
		String response= json.toJson(c1);
		
		System.out.println(response);
		
		
		//DeSter
		Customer c2 = json.fromJson(response, Customer.class);
		
		System.out.println(c2.getName());
		
		
		
		//Arrays
		ArrayList<Customer> customerAL= new ArrayList<Customer>();
		customerAL.add(c1);
		customerAL.add(new Customer());
		
		String responseAL=json.toJson(customerAL);
		
		System.out.println(responseAL);
		
		Type customerALType = new TypeToken<ArrayList<Customer>>(){}.getType();
		ArrayList<Customer> customerAL2 = json.fromJson(responseAL, customerALType);
		Customer c3= customerAL2.get(0);
		
		System.out.println(c3.getName());
	}

}
