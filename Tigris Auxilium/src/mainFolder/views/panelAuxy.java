package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

//Size of window 784, 438
public class panelAuxy extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelAuxy() {
		setLayout(null);
		setBounds(100, 100, 859, 438);
		
		JLabel lblWarning = new JLabel("Hi their, the Home page is not ready yet. :(");
		lblWarning.setBounds(194, 30, 289, 16);
		add(lblWarning);

	}
}
