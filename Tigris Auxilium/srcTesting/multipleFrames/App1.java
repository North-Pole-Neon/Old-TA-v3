package multipleFrames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class App1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main7(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App1 window = new App1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App1() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Apps");
		lblNewLabel.setBounds(160, 69, 123, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(172, 182, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}

}
