package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;

public class PanelHelp extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8070104978562596980L;

	/*
	 * Create the panel.
	 */
	public PanelHelp() {
		setBounds(100, 100, 859, 438);
		setLayout(null);
		
		JTextPane txtpnHiWePlan_1 = new JTextPane();
		txtpnHiWePlan_1.setText("Hi, we plan to working on this soon.\r\n\r\nFor now, enjoy our other features and we'll tell you when something new happens\r\n\r\nCheck out our github page at https://github.com/North-Pole-Neon/Tigris-Auxilium for new info and help");
		txtpnHiWePlan_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnHiWePlan_1.setEditable(false);
		txtpnHiWePlan_1.setBounds(171, 28, 402, 95);
		add(txtpnHiWePlan_1);
		
		
	}

}
