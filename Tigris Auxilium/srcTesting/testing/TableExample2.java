package testing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class TableExample2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableExample2 frame = new TableExample2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	
	DefaultTableModel tableModel = new DefaultTableModel();
	public TableExample2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		
		
		JPanel panelEntry = new JPanel();
		contentPane.add(panelEntry);
		panelEntry.setLayout(null);
		
		JButton btnAddRow = new JButton("Add Row");
		btnAddRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.insertRow(tableModel.getRowCount(), new Object[] { "" });
			}
		});
		btnAddRow.setBounds(22, 24, 89, 23);
		panelEntry.add(btnAddRow);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // check for selected row first
	            if(table.getSelectedRow() != -1) {
	               // remove selected row from the model
	            	tableModel.removeRow(table.getSelectedRow());
	               JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
	            }
			}
		});
		btnDelete.setBounds(22, 75, 89, 23);
		panelEntry.add(btnDelete);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ser();
				
				/*try {
					exportTable(table, new File("C:\\Test\\TA\\Data\\tables.xls"));
				} catch (IOException e1) {
					// 
					e1.printStackTrace();
				}*/
			}
		});
		btnSave.setBounds(22, 137, 89, 23);
		panelEntry.add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deser(); //Just need to note column changes when loaded
				//table =
				
				//arrayTesting();
				
				TableColumn testColumn = table.getColumnModel().getColumn(2);
			      JComboBox<String> comboBox = new JComboBox<>();
			      comboBox.addItem("Asia");
			      comboBox.addItem("Europe");
			      testColumn.setCellEditor(new DefaultCellEditor(comboBox));
				
				
			}
		});
		btnLoad.setBounds(22, 198, 89, 23);
		panelEntry.add(btnLoad);
		
		JPanel panelTable = new JPanel();
		contentPane.add(panelTable);
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 311, 453);
		panelTable.add(scrollPane);
		
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		tableModel.addColumn("Languages");
		tableModel.addColumn("Years");
		tableModel.addColumn("");
		
		TableColumn testColumn = table.getColumnModel().getColumn(2);
	      JComboBox<String> comboBox = new JComboBox<>();
	      comboBox.addItem("Asia");
	      comboBox.addItem("Europe");
	      testColumn.setCellEditor(new DefaultCellEditor(comboBox)); //table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboBox));

	      table.setRowHeight(table.getRowHeight() + 20);
	      
		tableModel.insertRow(0, new Object[] { "CSS", "2" });
	    
		//tableModel.insertRow(0, new Object[] { "HTML5" });
		//tableModel.insertRow(0, new Object[] { "JavaScript" });
		//tableModel.insertRow(0, new Object[] { "jQuery" });
		tableModel.insertRow(tableModel.getRowCount(), new Object[] { "Python", "5" });
	    tableModel.insertRow(tableModel.getRowCount(), new Object[] { "ExpressJS" });
	    tableModel.insertRow(tableModel.getRowCount(), new Object[] { "Java" });
	    
	    System.out.println(table.getModel().getValueAt(0, 0));
	    System.out.println(getTableData(table));

	}
	
	
	public void ser() {
		SerialTest e = new SerialTest();
	      e.name = "Reyan Ali";
	      e.address = "Phokka Kuan, Ambehta Peer";
	      e.SSN = 11122333;
	      e.number = 101;
	      e.tablesave = tableModel;
	      
	      try {
	         FileOutputStream fileOut =
	         new FileOutputStream("C:\\Test\\TA\\Data\\table.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in C:\\Test\\TA\\Data\\table.ser");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public static void deser() {
		
		SerialTest e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("C:\\Test\\TA\\Data\\table.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (SerialTest) in.readObject();
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
	      
	      System.out.println("Deserialized Employee...");
	      System.out.println("Name: " + e.name);
	      System.out.println("Address: " + e.address);
	      System.out.println("SSN: " + e.SSN);
	      System.out.println("Number: " + e.number);
	      table.setModel(e.tablesave);
	}
	
	
	
	
	
	
	
	public void exportTable(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
        FileWriter out = new FileWriter(file);
        for(int i=0; i < model.getColumnCount(); i++) {
    out.write(model.getColumnName(i) + "\t");
        }
        out.write("\n");

        for(int i=0; i< model.getRowCount(); i++) {
    for(int j=0; j < model.getColumnCount(); j++) {
        out.write(model.getValueAt(i,j)+"\t");
        }
        out.write("\n");
    }

    out.close();
    System.out.println("write out to: " + file);
	}
	
	@SuppressWarnings("unused")
	private void arrayTesting() {
		int[] intArr = new int[5];
		System.out.println(intArr.length);
		
		int[] myArr = {6, 42, 3, 7};
		int sum=0;
		for(int x=0; x<myArr.length; x++) {
		   sum += myArr[x];
		}
		System.out.println(sum);
	}
	
	public Object[][] getTableData (JTable table) {
	    TableModel dtm = table.getModel();
	    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
	    Object[][] tableData = new Object[nRow][nCol];
	    for (int i = 0 ; i < nRow ; i++)
	        for (int j = 0 ; j < nCol ; j++)
	            tableData[i][j] = dtm.getValueAt(i,j);
	    return tableData;
	}
}
