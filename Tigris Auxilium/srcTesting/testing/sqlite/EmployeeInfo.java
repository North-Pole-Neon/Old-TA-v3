package testing.sqlite;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class EmployeeInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4844863174009329621L;
	private JPanel contentPane;
	private JTable table;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo frame = new EmployeeInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null; //NEW
	private JTextField textFieldEID;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldAge;
	private JComboBox<String> comboBoxName;
	private JList<String> list;
	private JTextField textFieldSearch;
	private JComboBox<Object> comboBoxSelect;
	private JMenuBar menuBar;
	
	public void refreshTable() { //NEW
		try {
			String query = "select EID,Name,Surname,Age from EmployeeInfo"; //If you want all use * "select * from EmployeeInfo"
			PreparedStatement pst =  connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fillComboBox() {//NEW
		try {
			String query = "select * from EmployeeInfo";
			PreparedStatement pst =  connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				comboBoxName.addItem(rs.getString("Name"));
			}
			
			pst.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadList() {
		
		try {
			String query = "select * from EmployeeInfo";
			PreparedStatement pst =  connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			DefaultListModel<String> DLM = new DefaultListModel<String>();
			
			while(rs.next())
			{
				DLM.addElement(rs.getString("Name"));
			}

			list.setModel(DLM);
			
			pst.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * Create the frame.
	 */
	public EmployeeInfo() {
		connection = sqliteConnection.dbConnector(); //NEW
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 539);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNewMenu = new JMenu("New");
		mnFile.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Java Project");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Project");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Open File");
		mnFile.add(mntmNewMenuItem_2);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("New radio item");
		mnNewMenu_1.add(rdbtnmntmNewRadioItem);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("New check item");
		mnNewMenu_1.add(chckbxmntmNewCheckItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Load");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select EID,Name,Surname,Age from EmployeeInfo"; //If you want all use * "select * from EmployeeInfo"
					PreparedStatement pst =  connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
					
					table.getSelectionModel().clearSelection(); //Additive
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				changeTable(table, 0);
				
			}
			
		});
		btnLoadTable.setBounds(304, 45, 89, 23);
		contentPane.add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(205, 79, 563, 396);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				getSelectedCell();
				
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				
				getSelectedCell();
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblEID = new JLabel("EID");
		lblEID.setBounds(10, 80, 46, 14);
		contentPane.add(lblEID);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 139, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 210, 46, 14);
		contentPane.add(lblSurname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 270, 46, 14);
		contentPane.add(lblAge);
		
		textFieldEID = new JTextField();
		textFieldEID.setBounds(85, 77, 86, 20);
		contentPane.add(textFieldEID);
		textFieldEID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(85, 136, 86, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setBounds(85, 207, 86, 20);
		contentPane.add(textFieldSurname);
		textFieldSurname.setColumns(10);
		
		textFieldAge = new JTextField();
		textFieldAge.setBounds(85, 267, 86, 20);
		contentPane.add(textFieldAge);
		textFieldAge.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "insert into EmployeeInfo (EID,Name,Surname,Age) values (?, ?, ?, ?)";
					PreparedStatement pst =  connection.prepareStatement(query);
					pst.setString(1, textFieldEID.getText());
					pst.setString(2, textFieldName.getText());
					pst.setString(3, textFieldSurname.getText());
					pst.setString(4, textFieldAge.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pst.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
				
			}
		});
		btnSave.setBounds(205, 11, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					//String query = "Update EmployeeInfo set EID= " + textFieldEID.getText() +" ,name= "+textFieldName.getText() +" ,surname= " +textFieldSurname.getText() +" , age= "+ textFieldAge.getText()+" where EID= "+textFieldEID.getText()+" "; //where EID=`"+textFieldEID.getText()+"`
					
					 String query = "UPDATE EmployeeInfo SET EID = ?, name = ?, surname = ?, age = ? WHERE EID = ?";
				     PreparedStatement pst = connection.prepareStatement(query);
					
					 pst.setString(1, textFieldEID.getText());
				     pst.setString(2, textFieldName.getText());
				     pst.setString(3, textFieldSurname.getText());
				     pst.setString(4, textFieldAge.getText());
				     pst.setString(5, textFieldEID.getText());
					
					System.out.println(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					pst.close();
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
			}
		});
		btnUpdate.setBounds(205, 45, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Are you sure?","Delete", JOptionPane.YES_NO_OPTION);
				
				if(action == 0) {
				try {
					String query = "delete from EmployeeInfo where EID="+textFieldEID.getText()+" ";
					System.out.println(query);
					PreparedStatement pst =  connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					
					pst.close();
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
			}
			}
		});
		btnDelete.setBounds(304, 11, 89, 23);
		contentPane.add(btnDelete);
		
		comboBoxName = new JComboBox<String>();
		comboBoxName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select * from EmployeeInfo where name = ? ";
					PreparedStatement pst =  connection.prepareStatement(query);
					
					pst.setString(1, (String)comboBoxName.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						textFieldEID.setText(rs.getString("EID"));
						textFieldName.setText(rs.getString("Name"));
						textFieldSurname.setText(rs.getString("Surname"));
						textFieldAge.setText(rs.getString("Age"));
					}
					
					pst.close();
					rs.close();
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		comboBoxName.setBounds(10, 30, 155, 23);
		contentPane.add(comboBoxName);
		
		list = new JList<String>();
		list.setBounds(10, 319, 155, 156);
		contentPane.add(list);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String selection = (String)comboBoxSelect.getSelectedItem();
					String query = "select EID,Name,Surname,Age from EmployeeInfo where "+ selection+" = ? "; //
					//System.out.println(query);
					PreparedStatement pst =  connection.prepareStatement(query);
					
					//pst.setString(1, selection);
					pst.setString(1, textFieldSearch.getText());
					
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					//while(rs.next()) {
						
					//}
					
					pst.close();
					rs.close();
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		textFieldSearch.setBounds(607, 31, 127, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		comboBoxSelect = new JComboBox<Object>();
		comboBoxSelect.setModel(new DefaultComboBoxModel<Object>(new String[] {"EID", "Name", "Surname", "Age"}));
		comboBoxSelect.setBounds(459, 30, 117, 23);
		contentPane.add(comboBoxSelect);
		
		//refreshTable(); //NEW
		fillComboBox(); //NEW
		loadList(); //NEW
	}
	
	public void changeTable(JTable table, int column_index) {
        table.getColumnModel().getColumn(column_index).setCellRenderer(new DefaultTableCellRenderer() {
            /*
			 * 
			 */
			private static final long serialVersionUID = 4659549927243423545L;

			@Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int st_val = Integer.parseInt(table.getValueAt(row, 0).toString());
                int req_val = 3;
                if (st_val < req_val) {
                    c.setBackground(Color.MAGENTA);
                } else {
                    c.setBackground(Color.GREEN);
                }
                return c;
            }
        });
    }
	
	public void getSelectedCell() {
		try {
			int row = table.getSelectedRow();
			String EID_= (table.getModel().getValueAt(row, 0)).toString();
			
			String query = "select * from EmployeeInfo where EID = "+EID_+" ";
			PreparedStatement pst =  connection.prepareStatement(query);
			
			//pst.setString(1, (String)comboBoxName.getSelectedItem());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				textFieldEID.setText(rs.getString("EID"));
				textFieldName.setText(rs.getString("Name"));
				textFieldSurname.setText(rs.getString("Surname"));
				textFieldAge.setText(rs.getString("Age"));
			}
			
			pst.close();
			rs.close();
			
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
}

/*
 * public void changeTable(JTable table, int column_index) {
        table.getColumnModel().getColumn(column_index).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int st_val = Integer.parseInt(table.getValueAt(row, 0).toString());
                int req_val = 3;
                if (st_val < req_val) {
                    c.setBackground(Color.MAGENTA);
                } else {
                    c.setBackground(Color.GREEN);
                }
                return c;
            }
        });
    }
    */
