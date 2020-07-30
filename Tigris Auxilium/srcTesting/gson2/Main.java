package gson2;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {

		System.out.println("Hello");
		
		//serializeUserSimple();
		deserializeUserSimple();

	}

	private static void serializeUserSimple() {
		UserSimple user = new UserSimple("Tyler", "ty@gmail.com", 15, true);
	
		Gson gson = new Gson();
		String json = gson.toJson(user);
		
		System.out.println(json);
	
	}
	
	private static void deserializeUserSimple() {
		String userJson = "{'name':'Tyler','email':'ty@gmail.com','age':16,'isDeveloper':true}";
		
		Gson gson = new Gson();
		UserSimple userSimple = gson.fromJson(userJson, UserSimple.class);
		System.out.println(userSimple);

	}
}
