package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTabbedPane;

public class PanelCommunication extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6574377807957655989L;

	/**
	 * Create the panel.
	 */
	public PanelCommunication() {
		setBounds(100, 100, 859, 438);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 839, 416);
		add(tabbedPane);
		
		JPanel pcEmail = new JPanel();
		tabbedPane.addTab("Email", null, pcEmail, null);
		
		JTextPane txtpnHiWePlan_1 = new JTextPane();
		pcEmail.add(txtpnHiWePlan_1);
		txtpnHiWePlan_1.setText("Hi, we plan to working on this soon.\r\n\r\nFor now, enjoy our other features and we'll tell you when something new happens\r\n\r\nCheck out our github page at https://github.com/North-Pole-Neon/Tigris-Auxilium for new info and help");
		txtpnHiWePlan_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnHiWePlan_1.setEditable(false);
		
		JPanel pcChat = new JPanel();
		tabbedPane.addTab("Chat", null, pcChat, null);
		
		JTextPane txtpnHiWePlan_1_1 = new JTextPane();
		txtpnHiWePlan_1_1.setText("Hi, we plan to working on this soon.\r\n\r\nFor now, enjoy our other features and we'll tell you when something new happens\r\n\r\nCheck out our github page at https://github.com/North-Pole-Neon/Tigris-Auxilium for new info and help");
		txtpnHiWePlan_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnHiWePlan_1_1.setEditable(false);
		pcChat.add(txtpnHiWePlan_1_1);
		
		
	}
}
