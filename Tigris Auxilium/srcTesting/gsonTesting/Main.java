package gsonTesting;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Gson 01");
		
		//serializeUserSimple();
		deserializeUserSimple();

	}
	
	private static void serializeUserSimple() {
		UserSimple user = new UserSimple("Norman", "name@gmail.com", 27, true );
		
		Gson gson = new Gson();
		String json = gson.toJson(user);
		
		System.out.println(json);
	}
	
	
	
	private static void deserializeUserSimple() {
		String userJson = "{'age':25,'email':'name@gmail.com','isDeveloper':true,'name':'Norman'}";
		
		Gson gson = new Gson();
		UserSimple userSimple = gson.fromJson(userJson, UserSimple.class);
		
		System.out.println(userSimple);
	}

}
