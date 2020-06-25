package ta.views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class PanelAuxy extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelAuxy() {
		
		JButton btnNewButton = new JButton("New button");
		
		JLabel lblNewLabel = new JLabel("New label");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(267, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(94))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(130)
					.addComponent(lblNewLabel)
					.addContainerGap(274, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addComponent(btnNewButton)
					.addGap(85)
					.addComponent(lblNewLabel)
					.addContainerGap(99, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
