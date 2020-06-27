package tabswitching;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hope1 extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hope1 frame = new Hope1();
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
	public Hope1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(38, 92, 368, 160);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		layeredPane.add(panel, "name_216163423400307");
		
		JLabel lblNewLabel = new JLabel("this is panel 1");
		panel.add(lblNewLabel);
		
		panel2 = new JPanel();
		layeredPane.add(panel2, "name_216243142814807");
		
		JLabel lblNewLabel_1 = new JLabel("this panel 2");
		panel2.add(lblNewLabel_1);
		
		JButton btn1 = new JButton("s1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel);
				layeredPane.repaint();
				layeredPane.validate();
			}
		});
		btn1.setBounds(30, 21, 117, 29);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("s2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel2);
				layeredPane.repaint();
				layeredPane.validate();
			}
		});
		btn2.setBounds(168, 21, 117, 29);
		contentPane.add(btn2);
	}

}
