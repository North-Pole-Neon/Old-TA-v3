package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Desktop;

import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import mainFolder.common.MacAppInstaller;
import mainFolder.common.OSDetector;
import mainFolder.common.SqliteConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelApps extends JPanel { //NOTES: Make query to create table for list and entry for paths

	/*
	 * 
	 */
	private static final long serialVersionUID = -3602828320124508292L;
	
	Connection connection = null;
	
	private JTextField textFieldiDmg;
	private JTextField textFieldiPkg;
	private JTextField textFieldiapp;
	private JTextField textFieldC_ListEdit;
	private JTable tableC;
	private JTextField textFieldCName;
	private JTextField textFieldCPath;
	private JComboBox comboBoxCList;
	private JList listC;

	/*
	 * Create the panel.
	 */
	public PanelApps() { //FIXME /////////////////////  Add JfileChooser to button
		connection = SqliteConnection.dbConnectorCol();
		
		setBounds(100, 100, 859, 438);
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelTMain = new JPanel();
		tabbedPane.addTab("Apps", null, panelTMain, null);
		
		JPanel panelTColl = new JPanel();
		tabbedPane.addTab("Collections", null, panelTColl, null);
		panelTColl.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 156, 271);
		panelTColl.add(scrollPane);
		
		listC = new JList();
		listC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //XXX Needs to load table and enter text
				
				textFieldC_ListEdit.setText(listC.getSelectedValue().toString());
				refreshTable();
				
				
			}
		});
		scrollPane.setViewportView(listC);
		
		
		
		textFieldC_ListEdit = new JTextField();
		textFieldC_ListEdit.setBounds(10, 38, 156, 20);
		panelTColl.add(textFieldC_ListEdit);
		textFieldC_ListEdit.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(386, 11, 415, 362);
		panelTColl.add(scrollPane_1);
		
		tableC = new JTable();
		tableC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //TODO Make into currently selected cell instead of click
				
				try {
					int row = tableC.getSelectedRow();
					String name= (tableC.getModel().getValueAt(row, 0)).toString();
					//System.out.println(name);
					
					String query = "select * from "+listC.getSelectedValue().toString()+" where name = \""+name+"\"";
					//System.out.println(query);
					PreparedStatement pst =  connection.prepareStatement(query);
					
					//pst.setString(1, (String)comboBoxName.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						textFieldCName.setText(rs.getString("Name"));
						textFieldCPath.setText(rs.getString("Path"));
					}
					
					pst.close();
					rs.close();
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane_1.setViewportView(tableC);
		
		JPanel panelCName = new JPanel();
		panelCName.setBorder(new TitledBorder(null, "Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCName.setBounds(176, 159, 200, 42);
		panelTColl.add(panelCName);
		panelCName.setLayout(new BorderLayout(0, 0));
		
		textFieldCName = new JTextField();
		panelCName.add(textFieldCName, BorderLayout.CENTER);
		textFieldCName.setColumns(10);
		
		JPanel panelCPath = new JPanel();
		panelCPath.setBorder(new TitledBorder(null, "Path", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCPath.setBounds(176, 212, 196, 42);
		panelTColl.add(panelCPath);
		panelCPath.setLayout(new BoxLayout(panelCPath, BoxLayout.X_AXIS));
		
		textFieldCPath = new JTextField();
		panelCPath.add(textFieldCPath);
		textFieldCPath.setColumns(10);
		
		JButton btnCPath = new JButton("...");
		btnCPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCPath.setFont(new Font("Tahoma", Font.BOLD, 8));
		panelCPath.add(btnCPath);
		
		JButton btnCTAdd = new JButton("Add");
		btnCTAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "insert into "+listC.getSelectedValue().toString()+" (Name,Path) values (?, ?)";
					PreparedStatement pst =  connection.prepareStatement(query);
					pst.setString(1, textFieldCName.getText());
					pst.setString(2, textFieldCPath.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pst.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
				
			}
		});
		btnCTAdd.setBounds(283, 265, 89, 23);
		panelTColl.add(btnCTAdd);
		
		JButton btnCTDelete = new JButton("Delete");
		btnCTDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "delete from "+listC.getSelectedValue().toString()+" where Name= \""+textFieldCName.getText()+"\" ";
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
		});
		btnCTDelete.setBounds(283, 299, 89, 23);
		panelTColl.add(btnCTDelete);
		
		comboBoxCList = new JComboBox();
		comboBoxCList.setModel(new DefaultComboBoxModel(new String[] {"Open", "Update", "Create", "Delete"}));
		comboBoxCList.setBounds(10, 95, 80, 22);
		panelTColl.add(comboBoxCList);
		
		JButton btnCListDo = new JButton("Do"); //Do function based on combo
		btnCListDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch (comboBoxCList.getSelectedItem().toString()) {
				// ----------------------------------------------------------------------------
				case "Open": //TODO Make able to open on click
					
					try {
						String query = "select Path from "+listC.getSelectedValue().toString();
						System.out.println(query);
						PreparedStatement pst =  connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						
						//JOptionPane.showMessageDialog(null, "Data Deleted");
						
						while(rs.next()) {
							File filename = new File(rs.getString("Path"));
							open(filename);
						}
						
						pst.close();
						rs.close();
						
					}catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
					
					//refreshTable();
					System.out.println("Opened list");
					break;
					// ----------------------------------------------------------------------------
				case "Update":
					
					
					
					refreshCList();
					
					
					System.out.println("Updated list");
					break;
					// ----------------------------------------------------------------------------
				case "Create":
					
					try {
						String query = "CREATE TABLE "+textFieldC_ListEdit.getText()+" (Name TEXT PRIMARY KEY NOT NULL, Path TEXT NOT NULL) " ;
						PreparedStatement pst =  connection.prepareStatement(query);
						
						//pst.setString(1, textFieldC_ListEdit.getText());
						pst.execute();
						
						pst.close();
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					refreshCList();
					
					System.out.println("Created table: " +textFieldC_ListEdit.getText());
					break;
					// ----------------------------------------------------------------------------
				case "Delete":
					
					try {
						String query = "DROP TABLE "+listC.getSelectedValue().toString();
						PreparedStatement pst =  connection.prepareStatement(query);
						
						//pst.setString(1, textFieldC_ListEdit.getText());
						pst.execute();
						
						pst.close();
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					refreshCList();
					
					System.out.println("Deleted table: " + textFieldC_ListEdit.getText());
					break;
					// ----------------------------------------------------------------------------
				default:
					System.out.println("`Do` function can't recongize comboBox");
				}
				
			}
		});
		btnCListDo.setBounds(100, 94, 66, 23);
		panelTColl.add(btnCListDo);
		
		JButton btnCTUpdate = new JButton("Update");
		btnCTUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refreshTable();
				
			}
		});
		btnCTUpdate.setBounds(283, 333, 89, 23);
		panelTColl.add(btnCTUpdate);
		
		JPanel panelInstal = new JPanel();
		tabbedPane.addTab("Install", null, panelInstal, null);
		
		JPanel paneliApp = new JPanel();
		paneliApp.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		textFieldiapp = new JTextField();
		textFieldiapp.setColumns(10);
		
		JButton btniAppCreate = new JButton("Create");
		btniAppCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					MacAppInstaller.appInstall(textFieldiapp.getText());
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel lbliapp = new JLabel(".app");
		lbliapp.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_paneliApp = new GroupLayout(paneliApp);
		gl_paneliApp.setHorizontalGroup(
			gl_paneliApp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_paneliApp.createSequentialGroup()
					.addGap(4)
					.addComponent(lbliapp)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldiapp, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btniAppCreate, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		gl_paneliApp.setVerticalGroup(
			gl_paneliApp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_paneliApp.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_paneliApp.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldiapp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbliapp)
						.addComponent(btniAppCreate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(22))
		);
		paneliApp.setLayout(gl_paneliApp);
		
		JPanel paneliDmg = new JPanel();
		paneliDmg.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JLabel lbliDmg = new JLabel("DMG");
		lbliDmg.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldiDmg = new JTextField();
		textFieldiDmg.setColumns(10);
		
		JButton btniDmgCreate = new JButton("Create");
		btniDmgCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MacAppInstaller.dmgInstall(textFieldiDmg.getText());
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_paneliDmg = new GroupLayout(paneliDmg);
		gl_paneliDmg.setHorizontalGroup(
			gl_paneliDmg.createParallelGroup(Alignment.LEADING)
				.addGap(0, 519, Short.MAX_VALUE)
				.addGroup(gl_paneliDmg.createSequentialGroup()
					.addGap(4)
					.addComponent(lbliDmg)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldiDmg, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btniDmgCreate, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		gl_paneliDmg.setVerticalGroup(
			gl_paneliDmg.createParallelGroup(Alignment.LEADING)
				.addGap(0, 78, Short.MAX_VALUE)
				.addGroup(gl_paneliDmg.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_paneliDmg.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldiDmg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbliDmg)
						.addComponent(btniDmgCreate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(22))
		);
		paneliDmg.setLayout(gl_paneliDmg);
		
		JPanel paneliPkg = new JPanel();
		paneliPkg.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JLabel lbliPkg = new JLabel("PKG");
		lbliPkg.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldiPkg = new JTextField();
		textFieldiPkg.setColumns(10);
		
		JButton btniPkgCreate = new JButton("Create");
		btniPkgCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MacAppInstaller.pkgInstall(textFieldiPkg.getText());
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_paneliPkg = new GroupLayout(paneliPkg);
		gl_paneliPkg.setHorizontalGroup(
			gl_paneliPkg.createParallelGroup(Alignment.LEADING)
				.addGap(0, 519, Short.MAX_VALUE)
				.addGroup(gl_paneliPkg.createSequentialGroup()
					.addGap(4)
					.addComponent(lbliPkg)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldiPkg, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btniPkgCreate, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		gl_paneliPkg.setVerticalGroup(
			gl_paneliPkg.createParallelGroup(Alignment.LEADING)
				.addGap(0, 78, Short.MAX_VALUE)
				.addGroup(gl_paneliPkg.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_paneliPkg.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldiPkg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbliPkg)
						.addComponent(btniPkgCreate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(22))
		);
		paneliPkg.setLayout(gl_paneliPkg);
		
		JTextPane txtpnHowToUse = new JTextPane();
		txtpnHowToUse.setText("How to use Install feature?\r\n1. Enter in full path for file \" /Users/######/Desktop/Spotify.app/ \"\r\n2. Press Create\r\n3. Find new file located in the directory");
		GroupLayout gl_panelInstal = new GroupLayout(panelInstal);
		gl_panelInstal.setHorizontalGroup(
			gl_panelInstal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInstal.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_panelInstal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInstal.createSequentialGroup()
							.addComponent(txtpnHowToUse, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panelInstal.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelInstal.createSequentialGroup()
								.addComponent(paneliPkg, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
								.addGap(288))
							.addGroup(gl_panelInstal.createSequentialGroup()
								.addComponent(paneliDmg, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
								.addGap(288))
							.addGroup(gl_panelInstal.createSequentialGroup()
								.addComponent(paneliApp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(288)))))
		);
		gl_panelInstal.setVerticalGroup(
			gl_panelInstal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInstal.createSequentialGroup()
					.addGap(24)
					.addComponent(paneliApp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(paneliDmg, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(paneliPkg, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnHowToUse, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
					.addGap(29))
		);
		panelInstal.setLayout(gl_panelInstal);
		
		
		
		
	}
	
	public void refreshTable() { //NEW
		try {
			String query = "select * from "+ listC.getSelectedValue().toString();
			PreparedStatement pst =  connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableC.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refreshCList() {
	
		DefaultListModel<String> DLM = new DefaultListModel<String>();
		try {
			String query = "select name FROM sqlite_master WHERE type ='table' AND name NOT LIKE 'sqlite_%'";
			PreparedStatement pst =  connection.prepareStatement(query);
			
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("name"));
				DLM.addElement(rs.getString("name"));
			}
			
			pst.close();
			rs.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		listC.setModel(DLM);
		
	}
	
	
	
	
	public static boolean open(File file)
	{
	    try
	    {
	        if (OSDetector.isWindows())
	        {
	            Runtime.getRuntime().exec(new String[]
	            {"rundll32", "url.dll,FileProtocolHandler",
	             file.getAbsolutePath()});
	            return true;
	        } else if (OSDetector.isLinux() || OSDetector.isMac())
	        {
	            Runtime.getRuntime().exec(new String[]{"/usr/bin/open",
	                                                   file.getAbsolutePath()});
	            return true;
	        } else
	        {
	            // Unknown OS, try with desktop
	            if (Desktop.isDesktopSupported())
	            {
	                Desktop.getDesktop().open(file);
	                return true;
	            }
	            else
	            {
	                return false;
	            }
	        }
	    } catch (Exception e)
	    {
	        e.printStackTrace(System.err);
	        return false;
	    }
	}
	
}
