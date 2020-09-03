package testing.tables;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tables extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	
	ArrayList<Food> foodlist; //XXX New Stuff
	String header[] = new String[] {"Food Name", "Food Price", "Food Location"};
	DefaultTableModel dtm;
	int row,col;
	private JComboBox comboBoxLocation;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tables frame = new Tables();
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
	public Tables() {
		initComponents();
		foodlist = new ArrayList<>(); //XXX New Stuff
		dtm = new DefaultTableModel(header, 0);
		table.setModel(dtm);
		this.setLocationRelativeTo(null);
		
	}
	
	
	void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel1Text = new JPanel();
		contentPane.add(panel1Text);
		panel1Text.setLayout(null);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(184, 27, 325, 20);
		panel1Text.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(184, 71, 325, 20);
		panel1Text.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		comboBoxLocation = new JComboBox();
		comboBoxLocation.setBounds(184, 131, 258, 22);
		panel1Text.add(comboBoxLocation);
		
		JPanel panel2Btns = new JPanel();
		contentPane.add(panel2Btns);
		panel2Btns.setLayout(null);
		
		JButton btn1Add = new JButton("Add");
		btn1Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String foodname = textFieldName.getText();
				double foodprice = Double.parseDouble(textFieldPrice.getText());
				String foodloc = comboBoxLocation.getSelectedItem().toString();
				foodlist.add(new Food(foodname,foodloc,foodprice));
				dtm.setRowCount(0);
				for (int i = 0; i < foodlist.size(); i++ ) {
					Object[] objs = {foodlist.get(i).foodname,foodlist.get(i).foodprice,foodlist.get(i).foodloc};
					dtm.addRow(objs);
				}
			clearField();
			}
		});
		
		
		
		btn1Add.setBounds(10, 91, 89, 23);
		panel2Btns.add(btn1Add);
		
		JButton btn2Delete = new JButton("Delete");
		btn2Delete.setBounds(170, 91, 89, 23);
		panel2Btns.add(btn2Delete);
		
		JButton btn3Update = new JButton("Update");
		btn3Update.setBounds(400, 91, 89, 23);
		panel2Btns.add(btn3Update);
		
		JButton btn4Search = new JButton("Search");
		btn4Search.setBounds(592, 91, 89, 23);
		panel2Btns.add(btn4Search);
		
		JPanel pane3Table = new JPanel();
		contentPane.add(pane3Table);
		pane3Table.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(94, 11, 570, 159);
		pane3Table.add(scrollPane);
		
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		pane3Table.add(table);
	}
	
	private void clearField() {
		textFieldName.requestFocus();//Might need to use focusinwindow
		//textFieldName.requestFocusInWindow();
		textFieldName.setText("");
		textFieldPrice.setText("");
		comboBoxLocation.setSelectedIndex(0);
	}
}
