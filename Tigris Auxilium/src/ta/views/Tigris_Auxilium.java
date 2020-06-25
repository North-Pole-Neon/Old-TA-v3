package ta.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Toolkit;

public class Tigris_Auxilium {

	private JFrame frmTigrisAuxilium;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tigris_Auxilium window = new Tigris_Auxilium();
					window.frmTigrisAuxilium.setVisible(true);
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
		frmTigrisAuxilium = new JFrame();
		frmTigrisAuxilium.setIconImage(Toolkit.getDefaultToolkit().getImage(Tigris_Auxilium.class.getResource("/ta/resources/NPN Logo.png")));
		frmTigrisAuxilium.setTitle("Tigris Auxilium");
		frmTigrisAuxilium.setBounds(100, 100, 592, 408);
		frmTigrisAuxilium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTigrisAuxilium.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelMenu = new JPanel();
		frmTigrisAuxilium.getContentPane().add(panelMenu, BorderLayout.NORTH);
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
		
		PanelAuxy panelMain = new PanelAuxy();
		frmTigrisAuxilium.getContentPane().add(panelMain, BorderLayout.CENTER);
	}

}
