package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
//import java.io.File;
import java.io.IOException;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

import mainFolder.common.*;
import javax.swing.JTextField;


public class panelBrowser extends JPanel {
	/*
	 * 
	 */
	private static final long serialVersionUID = -500545164741919679L;
	private JTextField comboBoxTab1;
	private JTextField comboBoxTab2;
	private JTextField comboBoxTab3;
	private JTextField comboBoxTab4;
	private JTextField comboBoxTab5;
	private JTextField comboBoxTab6;
	private JCheckBox chckbx1;
	private JCheckBox chckbx2;
	private JCheckBox chckbx3;
	private JCheckBox chckbx4;
	private JCheckBox chckbx5;
	private JCheckBox chckbx6;
	private JButton btnSave;
	private JButton btnLoad;
	private JButton btnDefault;
	
	
	String boxlinkstring1; 
	String boxlinkstring2; 
	String boxlinkstring3; 
	String boxlinkstring4; 
	String boxlinkstring5;
	String boxlinkstring6;
	String urlcheck1;
	String urlcheck2;
	String urlcheck3;
	String urlcheck4;
	String urlcheck5;
	String urlcheck6;

	/*
	 * Create the panel.
	 */
	public panelBrowser() {
		setBounds(100, 100, 859, 438);
		setLayout(new BorderLayout(0, 0));
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JPanel panelTBrowser = new JPanel();
		tabbedPane.addTab("Browser", null, panelTBrowser, null);
		
		JLabel lblNewLabel = new JLabel("Hi their "+ RWJsonUser.firstName +", the Browser page is not ready yet. :(");
		GroupLayout gl_panelTBrowser = new GroupLayout(panelTBrowser);
		gl_panelTBrowser.setHorizontalGroup(
			gl_panelTBrowser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTBrowser.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_panelTBrowser.setVerticalGroup(
			gl_panelTBrowser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTBrowser.createSequentialGroup()
					.addGap(68)
					.addComponent(lblNewLabel)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		panelTBrowser.setLayout(gl_panelTBrowser);
		
		JPanel panelTTab = new JPanel();
		tabbedPane.addTab("Tabs", null, panelTTab, null);
		
		chckbx1 = new JCheckBox("1. ");
		
		chckbx2 = new JCheckBox("2. ");
		
		chckbx3 = new JCheckBox("3. ");
		
		chckbx4 = new JCheckBox("4. ");
		
		chckbx5 = new JCheckBox("5. ");
		
		chckbx6 = new JCheckBox("6. ");
		
		comboBoxTab1 = new JTextField();
		comboBoxTab1.setEditable(true);
		
		comboBoxTab2 = new JTextField();
		comboBoxTab2.setEditable(true);
		
		comboBoxTab3 = new JTextField();
		comboBoxTab3.setEditable(true);
		
		comboBoxTab4 = new JTextField();
		comboBoxTab4.setEditable(true);
		
		comboBoxTab5 = new JTextField();
		comboBoxTab5.setEditable(true);
		
		comboBoxTab6 = new JTextField();
		comboBoxTab6.setEditable(true);
		
		JButton btnRunTabs = new JButton("Open tabs now");
		btnRunTabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//LATER Find way to prompt message to user for name
				goToLinks();
				System.out.println("Opening Web pages"); //PRINT "Opening Web pages"
			}
		});
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RWJsonBTabs.link1 = comboBoxTab1.getText();
				RWJsonBTabs.link1Cb = String.valueOf(chckbx1.isSelected());
				RWJsonBTabs.link2 = comboBoxTab2.getText();
				RWJsonBTabs.link2Cb = String.valueOf(chckbx2.isSelected());
				RWJsonBTabs.link3 = comboBoxTab3.getText();
				RWJsonBTabs.link3Cb = String.valueOf(chckbx3.isSelected());
				RWJsonBTabs.link4 = comboBoxTab4.getText();
				RWJsonBTabs.link4Cb = String.valueOf(chckbx4.isSelected());
				RWJsonBTabs.link5 = comboBoxTab5.getText();
				RWJsonBTabs.link5Cb = String.valueOf(chckbx5.isSelected());
				RWJsonBTabs.link6 = comboBoxTab6.getText();
				RWJsonBTabs.link6Cb = String.valueOf(chckbx6.isSelected());
				
				RWJsonBTabs.WriteToJson();
			System.out.println(RWJsonBTabs.link1);
			System.out.println(RWJsonBTabs.link1Cb);
			}
		});
		
		btnLoad = new JButton("Load");
		btnLoad.setVisible(true); //Work with it later
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Look here --------------------------------------------------------------------
				
				//RWJsonBTabs.ReadToJson();
				RWJsonBTabs tests = new RWJsonBTabs();
				tests.ReadToJson();
				comboBoxTab1.setText(RWJsonBTabs.link1);
				chckbx1.setSelected(Boolean.parseBoolean(RWJsonBTabs.link1Cb));
				comboBoxTab2.setText(RWJsonBTabs.link2);
				chckbx2.setSelected(Boolean.parseBoolean(RWJsonBTabs.link2Cb));
				comboBoxTab3.setText(RWJsonBTabs.link3);
				chckbx3.setSelected(Boolean.parseBoolean(RWJsonBTabs.link3Cb));
				comboBoxTab4.setText(RWJsonBTabs.link4);
				chckbx4.setSelected(Boolean.parseBoolean(RWJsonBTabs.link4Cb));
				comboBoxTab5.setText(RWJsonBTabs.link5);
				chckbx5.setSelected(Boolean.parseBoolean(RWJsonBTabs.link5Cb));
				comboBoxTab6.setText(RWJsonBTabs.link6);
				chckbx6.setSelected(Boolean.parseBoolean(RWJsonBTabs.link6Cb));
				
			}
		});
		
		btnDefault = new JButton("Default"); // LATER Add default text possible
		btnDefault.setVisible(false); //Work with it later
		GroupLayout gl_panelTTab = new GroupLayout(panelTTab);
		gl_panelTTab.setHorizontalGroup(
			gl_panelTTab.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelTTab.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRunTabs)
						.addGroup(gl_panelTTab.createSequentialGroup()
							.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbx1)
								.addComponent(chckbx2)
								.addComponent(chckbx3)
								.addComponent(chckbx4)
								.addComponent(chckbx5)
								.addComponent(chckbx6))
							.addGap(93)
							.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxTab6, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxTab4, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxTab2, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxTab1, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_panelTTab.createSequentialGroup()
									.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBoxTab3, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBoxTab5, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))
									.addGap(59)
									.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING)
										.addComponent(btnLoad)
										.addComponent(btnDefault))
									.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)))))
					.addContainerGap())
				.addGroup(gl_panelTTab.createSequentialGroup()
					.addContainerGap(745, Short.MAX_VALUE)
					.addComponent(btnSave)
					.addGap(18))
		);
		gl_panelTTab.setVerticalGroup(
			gl_panelTTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTTab.createSequentialGroup()
					.addGap(26)
					.addComponent(btnRunTabs)
					.addGap(18)
					.addGroup(gl_panelTTab.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBoxTab1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbx1))
					.addGap(18)
					.addGroup(gl_panelTTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbx2)
						.addComponent(comboBoxTab2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelTTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbx3)
						.addComponent(comboBoxTab3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDefault))
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelTTab.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panelTTab.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbx4)
								.addComponent(comboBoxTab4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelTTab.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbx5)
								.addComponent(comboBoxTab5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelTTab.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbx6)
								.addComponent(comboBoxTab6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(Alignment.TRAILING, gl_panelTTab.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLoad)
							.addGap(49)))
					.addComponent(btnSave)
					.addGap(20))
		);
		panelTTab.setLayout(gl_panelTTab);
		
		JPanel panelTSettings = new JPanel();
		tabbedPane.addTab("Settings", null, panelTSettings, null);

		
		 boxlinkstring1= comboBoxTab1.getText();
		 boxlinkstring2= comboBoxTab2.getText();
		 boxlinkstring3= comboBoxTab3.getText();
		 boxlinkstring4= comboBoxTab4.getText();
		 boxlinkstring5= comboBoxTab5.getText();
		 boxlinkstring6= comboBoxTab6.getText();
		 urlcheck1 = String.valueOf(chckbx1.isSelected());
		 urlcheck2 = String.valueOf(chckbx2.isSelected());
		 urlcheck3 = String.valueOf(chckbx3.isSelected());
		 urlcheck4 = String.valueOf(chckbx4.isSelected());
		 urlcheck5 = String.valueOf(chckbx5.isSelected());
		 urlcheck6 = String.valueOf(chckbx6.isSelected());
	}
	
	
	
	public void goToLinks() { //LATER Maybe change this around with new & org
		// Want to load in background
		/*
		 * What needs to happen:
		 * Checks status
		 * Load
		 */
		
		if (chckbx1.isSelected() == true) { //LATER make "urlcheck1.equals("true")" work
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(comboBoxTab1.getText())); //LATER Make "boxlinkstring1" Work
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if (chckbx2.isSelected() == true) {
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(comboBoxTab2.getText()));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if (chckbx3.isSelected() == true) {
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(comboBoxTab3.getText()));
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		if (chckbx4.isSelected() == true) {
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(comboBoxTab4.getText()));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if (chckbx5.isSelected() == true) {
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(comboBoxTab5.getText()));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if (chckbx6.isSelected() == true) {
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(comboBoxTab6.getText()));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
				
	}
	
	public void checkBoxLoad() { // Need to make opposite for save
		if (chckbx1.isSelected() == true) {
			urlcheck1 = "true";
		} else {
			urlcheck1 = "false";
		}
		
		
	}
	
	
	
	
	/* //Check for save file OLDCODE
	public void tabSaveExists() {
		File tempFile = new File("./src/mainFolder/resources/BrowserTabSave.tigaux");
		boolean exists = tempFile.exists();
		
		
		if (exists == true) {  //Load save file  and change text boxes and variables OLDCODE Save
			BrowserTab_GenRead loadtabs = new BrowserTab_GenRead();
			loadtabs.readTabSave();
			comboBoxTab1.setText(loadtabs.tab1LINK);
			comboBoxTab2.setText(loadtabs.tab2LINK);
			comboBoxTab3.setText(loadtabs.tab3LINK);
			comboBoxTab4.setText(loadtabs.tab4LINK);
			comboBoxTab5.setText(loadtabs.tab5LINK);
			comboBoxTab6.setText(loadtabs.tab6LINK);
			
			chckbx1.setSelected(loadtabs.tab1LINKCbx);
			chckbx2.setSelected(loadtabs.tab2LINKCbx);
			chckbx3.setSelected(loadtabs.tab3LINKCbx);
			chckbx4.setSelected(loadtabs.tab4LINKCbx);
			chckbx5.setSelected(loadtabs.tab5LINKCbx);
			chckbx6.setSelected(loadtabs.tab6LINKCbx);
			
			String boxlinkstring1= comboBoxTab1.getText(); //TODO Check what to do with this
			String boxlinkstring2= comboBoxTab2.getText();
			String boxlinkstring3= comboBoxTab3.getText();
			String boxlinkstring4= comboBoxTab4.getText();
			String boxlinkstring5= comboBoxTab5.getText();
			String boxlinkstring6= comboBoxTab6.getText();
			Boolean urlcheck1 = chckbx1.isSelected(); //TODO Doesn't save check boxes
			Boolean urlcheck2 = chckbx2.isSelected();
			Boolean urlcheck3 = chckbx3.isSelected();
			Boolean urlcheck4 = chckbx4.isSelected();
			Boolean urlcheck5 = chckbx5.isSelected();
			Boolean urlcheck6 = chckbx6.isSelected();
			
		}else if (exists == false) {
			
		}
		
	}*/
	
	
}
