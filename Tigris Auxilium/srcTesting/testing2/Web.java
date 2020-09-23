package testing2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Web extends JFrame{

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField addressBar;
	@SuppressWarnings("unused")
	private JEditorPane display;
	
	public Web() {
		super("Bucky Browser");
		addressBar = new JTextField("enter URL!");
		addressBar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				 //loadCrap(e.getActionCommand());
			}
		});
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
