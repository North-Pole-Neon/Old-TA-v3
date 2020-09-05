package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import mainFolder.common.SerializeHWT;
import mainFolder.common.SqliteConnection;
import net.proteanit.sql.DbUtils;
import testing.SerialTest;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;

public class PanelHomework extends JPanel {

	/*
	 * TODO Make Nested tables with buttons for homework
	 */
	private static final long serialVersionUID = -4160000612194093406L;

	/*
	 * Create the panel.
	 */
	
	private static JTable tablePP;
	
	 DefaultTableModel tableModelPP = new DefaultTableModel();
	
	public PanelHomework() {
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
		
		JScrollPane scrollPanePP = new JScrollPane();
		scrollPanePP.setBounds(10, 11, 810, 211);
		pProject.add(scrollPanePP);
		
		tablePP = new JTable(tableModelPP);
		scrollPanePP.setViewportView(tablePP);
		
		tableModelPP.addColumn("#");
		tableModelPP.addColumn("Name");
		tableModelPP.addColumn("Description");
		tableModelPP.addColumn("Priority");
		tableModelPP.addColumn("Due Date");
		tableModelPP.addColumn("Status");
		tableModelPP.addColumn("Cat");
		
		TableColumn TColumnPri = tablePP.getColumnModel().getColumn(3);
	    JComboBox<String> comboBoxTCPri = new JComboBox<>();
	    comboBoxTCPri.addItem("Low");
	    comboBoxTCPri.addItem("Med");
	    comboBoxTCPri.addItem("High");
	    TColumnPri.setCellEditor(new DefaultCellEditor(comboBoxTCPri));
	    
	    TableColumn TColumnStat = tablePP.getColumnModel().getColumn(5);
	    JComboBox<String> comboBoxTCStat = new JComboBox<>();
	    comboBoxTCStat.addItem("Not Started");
	    comboBoxTCStat.addItem("In Progress");
	    comboBoxTCStat.addItem("Review");
	    comboBoxTCStat.addItem("Completed");
	    TColumnStat.setCellEditor(new DefaultCellEditor(comboBoxTCStat));
	    
	    TableColumn TColumnCat = tablePP.getColumnModel().getColumn(6);
	    JComboBox<String> comboBoxTCCat = new JComboBox<>();
	    comboBoxTCCat.addItem("1");
	    comboBoxTCCat.addItem("2");
	    comboBoxTCCat.addItem("3");
	    comboBoxTCCat.addItem("4");
	    TColumnCat.setCellEditor(new DefaultCellEditor(comboBoxTCCat));
	    
	    //tablePP.setModel(tableModelPP);
		
		JButton btnAddRow = new JButton("Add Row");
		btnAddRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModelPP.insertRow(tableModelPP.getRowCount(), new Object[] { "" });
			}
		});
		btnAddRow.setBounds(50, 249, 89, 23);
		pProject.add(btnAddRow);
		
		JButton btnDeleteRow = new JButton("Delete Row");
		btnDeleteRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 // check for selected row first
	            if(tablePP.getSelectedRow() != -1) {
	               // remove selected row from the model
	            	tableModelPP.removeRow(tablePP.getSelectedRow());
	               JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
	            }
				
			}
		});
		btnDeleteRow.setBounds(50, 283, 89, 23);
		pProject.add(btnDeleteRow);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strPP();
			}
		});
		btnSave.setBounds(149, 249, 89, 23);
		pProject.add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() { //TODO Make Joptionpane to ask load old or select file
			public void actionPerformed(ActionEvent e) {
				destrPP();
			}
		});
		btnLoad.setBounds(149, 283, 89, 23);
		pProject.add(btnLoad);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		
	}
	
	 void strPP() {
		
			SerializeHWT e = new SerializeHWT();
		      
		      e.tablesave = tableModelPP;//tableModelPP tablePP.getModel()
		      
		      try {
		         FileOutputStream fileOut =
		         new FileOutputStream("C:\\Test\\TA\\Data\\tablePP.tiax");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(e);
		         out.close();
		         fileOut.close();
		         System.out.printf("Serialized data is saved in C:\\Test\\TA\\Data\\tablePP.tiax");
		      } catch (IOException i) {
		         i.printStackTrace();
		      }
		
		
	}
	
	 void destrPP() {
		
		SerializeHWT e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("C:\\Test\\TA\\Data\\tablePP.tiax");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (SerializeHWT) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	      
	      System.out.println("Deserialized Project Table...");
	      tableModelPP = e.tablesave;
	      //tablePP.setModel(e.tablesave);
		
	}
}
