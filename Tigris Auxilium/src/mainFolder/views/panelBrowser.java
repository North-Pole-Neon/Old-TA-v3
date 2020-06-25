package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class panelBrowser extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelBrowser() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(257, 91, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Browser");
		lblNewLabel.setBounds(85, 208, 46, 14);
		add(lblNewLabel);

	}

}
