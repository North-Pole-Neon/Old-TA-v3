package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import mainFolder.common.SqliteConnection;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelHomework extends JPanel {

	/*
	 * TODO Make Nested tables with buttons for homework
	 */
	private static final long serialVersionUID = -4160000612194093406L;
	
	Connection connection = null;
	
	private JTextField textFieldSearch;
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	private JTextField textFieldStatus;
	private JTextField textFieldPriority;
	private JTextField textFieldDueDate;
	private JTextField textFieldCat;
	private JTable tablePP;
	
	
	public void refreshTable() { //NEW
		try {
			String query = "select * from ProjectInfo"; //If you want all use * "select * from "
			PreparedStatement pst =  connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tablePP.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PanelHomework() {
		connection = SqliteConnection.dbConnectorPP();
		
		setBounds(100, 100, 859, 438);
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Hi their, the Homework page is not ready yet. :(");
		lblNewLabel.setBounds(203, 12, 428, 16);
		add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 35, 835, 391);
		add(tabbedPane);
		
		JPanel pProject = new JPanel();
		tabbedPane.addTab("Project Planner", null, pProject, null);
		pProject.setLayout(null);
		
		JPanel panelCB_Search = new JPanel();
		panelCB_Search.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCB_Search.setBounds(639, 11, 181, 42);
		pProject.add(panelCB_Search);
		panelCB_Search.setLayout(new BoxLayout(panelCB_Search, BoxLayout.X_AXIS));
		
		JComboBox comboBoxSearchPP = new JComboBox();
		comboBoxSearchPP.setModel(new DefaultComboBoxModel(new String[] {"Name", "Description", "Status", "Priority", "DueDate", "Cat"}));
		comboBoxSearchPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelCB_Search.add(comboBoxSearchPP);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String ser = "'%"+ textFieldSearch.getText() +"%'";
				try {
					String selection = (String)comboBoxSearchPP.getSelectedItem();
					String query = "select * from ProjectInfo where "+selection+" LIKE "+ser; // "select * from ProjectInfo where "+ selection+" = ? "
					System.out.println(query);
					//"select * from ProjectInfo where column LIKE"+"`%" +selection+"%`"+" = ? "
					//"select * from ProjectInfo where "+selection+" LIKE ?"
					PreparedStatement pst =  connection.prepareStatement(query);
					
					//pst.setString(1, selection);
					//pst.setString(1, textFieldSearch.getText());
					//pst.setString(1, "'%"+ textFieldSearch.getText() +"%'");
					
					
					
					/*
					 * String selection = (String)comboBoxSearchPP.getSelectedItem();
					String query = "select * from ProjectInfo where ? LIKE" + "'%"+ "?" +"%'"; // "select * from ProjectInfo where "+ selection+" = ? "
					System.out.println(query);
					//"select * from ProjectInfo where column LIKE"+"`%" +selection+"%`"+" = ? "
					PreparedStatement pst =  connection.prepareStatement(query);
					
					pst.setString(1, selection);
					pst.setString(2, textFieldSearch.getText());
					 */
					
					
					ResultSet rs = pst.executeQuery();
					
					System.out.println(rs);
					
					tablePP.setModel(DbUtils.resultSetToTableModel(rs));
					
					while(rs.next()) {
						ser = "'%"+ textFieldSearch.getText() +"%'";
					}
					
					pst.close();
					rs.close();
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		panelCB_Search.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Task Editor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 11, 480, 62);
		pProject.add(panel);
		panel.setLayout(new GridLayout(2, 6, 0, 0));
		
		JLabel lblName = new JLabel("Name");
		panel.add(lblName);
		
		JLabel lblDescription = new JLabel("Description");
		panel.add(lblDescription);
		
		JLabel lblStatus = new JLabel("Status");
		panel.add(lblStatus);
		
		JLabel lblPriority = new JLabel("Priority");
		panel.add(lblPriority);
		
		JLabel lblDueDate = new JLabel("Due Date");
		panel.add(lblDueDate);
		
		JLabel lblCat = new JLabel("Cat");
		panel.add(lblCat);
		
		textFieldName = new JTextField();
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldDescription = new JTextField();
		panel.add(textFieldDescription);
		textFieldDescription.setColumns(10);
		
		textFieldStatus = new JTextField();
		panel.add(textFieldStatus);
		textFieldStatus.setColumns(10);
		
		textFieldPriority = new JTextField();
		panel.add(textFieldPriority);
		textFieldPriority.setColumns(10);
		
		textFieldDueDate = new JTextField();
		panel.add(textFieldDueDate);
		textFieldDueDate.setColumns(10);
		
		textFieldCat = new JTextField();
		panel.add(textFieldCat);
		textFieldCat.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "insert into ProjectInfo (Name,Description,Status,Priority,DueDate,Cat) values (?, ?, ?, ?, ?, ?)";
					System.out.println("//////" + query);
					PreparedStatement pst =  connection.prepareStatement(query);
					pst.setString(1, textFieldName.getText());
					pst.setString(2, textFieldDescription.getText());
					pst.setString(3, textFieldStatus.getText());
					pst.setString(4, textFieldPriority.getText());
					pst.setString(5, textFieldDueDate.getText());
					pst.setString(6, textFieldCat.getText());
					System.out.println("//////" + query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pst.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
				
			}
		});
		btnAdd.setBounds(488, 16, 74, 23);
		pProject.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int action = JOptionPane.showConfirmDialog(null, "Are you sure?","Delete", JOptionPane.YES_NO_OPTION);//LATER add show again question
				
				if(action == 0) {
				try {
					String query = "delete from ProjectInfo where Name = ?";
					System.out.println(query);
					PreparedStatement pst =  connection.prepareStatement(query);
					
					pst.setString(1, textFieldName.getText());
					
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
		btnDelete.setBounds(488, 50, 74, 23);
		pProject.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update"); //Make load in menu bar
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//String query = "Update EmployeeInfo set EID= " + textFieldEID.getText() +" ,name= "+textFieldName.getText() +" ,surname= " +textFieldSurname.getText() +" , age= "+ textFieldAge.getText()+" where EID= "+textFieldEID.getText()+" "; //where EID=`"+textFieldEID.getText()+"`
					
					 String query = "UPDATE ProjectInfo SET Name = ?, Description = ?, Status = ?, Priority = ?, DueDate = ?, Cat = ? WHERE Name = ?";
				     PreparedStatement pst = connection.prepareStatement(query);
					
				     System.out.println(query);
				     
					 pst.setString(1, textFieldName.getText());
				     pst.setString(2, textFieldDescription.getText());
				     pst.setString(3, textFieldStatus.getText());
				     pst.setString(4, textFieldPriority.getText());
				     pst.setString(5, textFieldDueDate.getText());
				     pst.setString(6, textFieldCat.getText());
				     pst.setString(7, textFieldName.getText());
					
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
		btnUpdate.setBounds(563, 16, 74, 23);
		pProject.add(btnUpdate);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select * from ProjectInfo"; //If you want all use * "select * from ProjectInfo"
					PreparedStatement pst =  connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tablePP.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
					
					tablePP.getSelectionModel().clearSelection(); //Additive
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnLoad.setBounds(563, 50, 74, 23);
		pProject.add(btnLoad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 84, 804, 268);
		pProject.add(scrollPane);
		
		tablePP = new JTable();
		tablePP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row = tablePP.getSelectedRow();
					String ID_= (tablePP.getModel().getValueAt(row, 0)).toString();
					
					String query = "select * from ProjectInfo where ID = "+ID_+" ";
					PreparedStatement pst =  connection.prepareStatement(query);
					
					//pst.setString(1, (String)comboBoxName.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						textFieldName.setText(rs.getString("Name"));
						textFieldDescription.setText(rs.getString("Description"));
						textFieldStatus.setText(rs.getString("Status"));
						textFieldPriority.setText(rs.getString("Priority"));
						textFieldDueDate.setText(rs.getString("DueDate"));
						textFieldCat.setText(rs.getString("Cat"));
					}
					
					pst.close();
					rs.close();
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(tablePP);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		
	}
}
