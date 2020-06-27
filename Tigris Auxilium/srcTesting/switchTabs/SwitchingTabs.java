package switchTabs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwitchingTabs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwitchingTabs frame = new SwitchingTabs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwitchingTabs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPaneMain = new JLayeredPane();
		layeredPaneMain.setBounds(32, 119, 445, 200);
		contentPane.add(layeredPaneMain);
		layeredPaneMain.setLayout(new CardLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		layeredPaneMain.add(panel1, "name_209707958344088");
		
		JLabel lblNewLabel = new JLabel("1");
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(124)
					.addComponent(lblNewLabel)
					.addContainerGap(260, Short.MAX_VALUE))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel1.createSequentialGroup()
					.addContainerGap(93, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(91))
		);
		panel1.setLayout(gl_panel1);
		
		JPanel panel2 = new JPanel();
		layeredPaneMain.add(panel2, "name_209791079784497");
		
		JButton btnNewButton = new JButton("New button");
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel2.createSequentialGroup()
					.addContainerGap(215, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(113))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGap(74)
					.addComponent(btnNewButton)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		panel2.setLayout(gl_panel2);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPaneMain.removeAll();
				layeredPaneMain.add(panel1);
				layeredPaneMain.repaint();
				layeredPaneMain.validate();
			}
		});
		btn1.setBounds(24, 33, 117, 29);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPaneMain.removeAll();
				layeredPaneMain.add(panel2);
				layeredPaneMain.repaint();
				layeredPaneMain.validate();
			}
		});
		btn2.setBounds(176, 33, 117, 29);
		contentPane.add(btn2);
	}
}
