package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTools extends JPanel {

	/*
	 * 
	 */
	private static final long serialVersionUID = -2433832224159377567L;

	/*
	 * Create the panel.
	 */
	public PanelTools() {
		setBounds(100, 100, 859, 438);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hi their, the Tools page is not ready yet. :(");
		lblNewLabel.setBounds(160, 52, 312, 16);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(81, 94, 130, 154);
		add(panel);
		panel.setLayout(null);
		
		JButton btnHide = new JButton("Hide apps");
		btnHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHide.setBounds(10, 43, 89, 23);
		panel.add(btnHide);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSleep.setBounds(10, 77, 89, 23);
		panel.add(btnSleep);
		
		JButton btnShutDown = new JButton("Shutdown");
		btnShutDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShutDown.setBounds(10, 111, 89, 23);
		panel.add(btnShutDown);
		

	}
}
