package mainFolder.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

public class Tigris_Auxilium {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tigris_Auxilium window = new Tigris_Auxilium();
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
	public Tigris_Auxilium() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, BorderLayout.NORTH);
		panelMenu.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		panelMenu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panelMenu.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panelMenu.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panelMenu.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panelMenu.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panelMenu.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		panelMenu.add(btnNewButton_6);
		
		panelAuxy panelMain = new panelAuxy();
		frame.getContentPane().add(panelMain, BorderLayout.CENTER);
	}

}
