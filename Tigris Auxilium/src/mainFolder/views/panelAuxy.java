package mainFolder.views;

import javax.swing.JPanel;

import mainFolder.common.RWJsonUser;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

//Size of window 784, 438
public class panelAuxy extends JPanel {
	/*
	 * 
	 */
	private static final long serialVersionUID = -1904923341438159983L;
	//private String ownerName;
	
	
	/*
	 * Create the panel.
	 */
	public panelAuxy() {
		setLayout(null);
		setBounds(100, 100, 859, 438);
		
		
		JLabel lblWarning = new JLabel("Hi their " + RWJsonUser.firstName + ", the Home page is not ready yet. :(");
		lblWarning.setBounds(194, 30, 289, 16);
		add(lblWarning);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(panelAuxy.class.getResource("/mainFolder/resources/hello.png")));
		label.setBounds(120, 125, 167, 163);
		add(label);
		
		

	}
}
