package testing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TableExample3Test extends JFrame{

	/*
	 * 
	 */
	private static final long serialVersionUID = -1823241640737955755L;

	public static void main(String[] args) {

		Vector<String> headers = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();

		File file = new File("C:\\Test\\TA\\Data\\tables.xls");
		try {
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		headers.clear();
		for (int i = 0; i < sheet.getColumns(); i++) {
		Cell cell1 = sheet.getCell(i, 0);
		headers.add(cell1.getContents());
		}
		data.clear();
		for (int j = 1; j < sheet.getRows(); j++) {
		Vector<String> d = new Vector<String>();
		for (int i = 0; i < sheet.getColumns(); i++) {
		Cell cell = sheet.getCell(i, j);
		d.add(cell.getContents());
		}
		d.add("\n");
		data.add(d);
		}
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel(data,headers);
		table.setModel(model);
		table.setAutoCreateRowSorter(true);
		model = new DefaultTableModel(data, headers);
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		JFrame f=new JFrame();
		f.add(scroll);
		f.setSize(400, 200);
		f.setResizable(true);
		f.setVisible(true);
		}
	
}
