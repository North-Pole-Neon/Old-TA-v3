package testing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ColorTable extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4573490557858518120L;
	private JPanel contentPane;
	private JTable table;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColorTable frame = new ColorTable();
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
	public ColorTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"blue", "Wood", "1"},
				{null, "Can", "3"},
				{"grey", "Pully", "2"},
			},
			new String[] {
				"Desc", "Name", "Status"
			}
		));
		table.setBounds(35, 11, 512, 361);
		contentPane.add(table);
	}
	
	
}
