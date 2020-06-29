package testingmessages;

import javax.swing.JOptionPane;



public class InputTest {
	
	public static void main(String[] args) {
		String first_name1 = JOptionPane.showInputDialog("First Name");
		String secondname = JOptionPane.showInputDialog("Second");
		
		String full = first_name1 + secondname;
		JOptionPane.showMessageDialog(null, full);
	}
	
	
	



}
