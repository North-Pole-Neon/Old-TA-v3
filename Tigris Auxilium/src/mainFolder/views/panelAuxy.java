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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(267, 86, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Auxy panel");
		lblNewLabel.setBounds(194, 162, 98, 60);
		add(lblNewLabel);

	}
}
