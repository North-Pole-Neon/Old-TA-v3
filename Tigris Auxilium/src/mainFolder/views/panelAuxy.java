package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class panelAuxy extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelAuxy() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(267, 86, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(82, 139, 98, 60);
		add(lblNewLabel);

	}

}
