package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import mainFolder.common.*;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;


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
	
	
	private JTextPane txtpnHiWePlan;
	private JTextPane txtpnHiWePlan_1;
	private JLabel lblNewLabel;

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
		
		txtpnHiWePlan = new JTextPane();
		txtpnHiWePlan.setText("Hi, we plan to working on this soon.\r\n\r\nFor now, enjoy our other features and we'll tell you when something new happens\r\n\r\nCheck out our github page at https://github.com/North-Pole-Neon/Tigris-Auxilium for new info and help");
		txtpnHiWePlan.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnHiWePlan.setEditable(false);
		GroupLayout gl_panelTBrowser = new GroupLayout(panelTBrowser);
		gl_panelTBrowser.setHorizontalGroup(
			gl_panelTBrowser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTBrowser.createSequentialGroup()
					.addGap(143)
					.addComponent(txtpnHiWePlan, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(309, Short.MAX_VALUE))
		);
		gl_panelTBrowser.setVerticalGroup(
			gl_panelTBrowser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTBrowser.createSequentialGroup()
					.addGap(52)
					.addComponent(txtpnHiWePlan, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(263, Short.MAX_VALUE))
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
			public void actionPerformed(ActionEvent e) {
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
				
				RWJsonBTabs.pathMaker(RWJsonUser.getOSVersion());
				RWJsonBTabs.LinksFileExists(RWJsonUser.getOSVersion());
				RWJsonBTabs.WriteToJson();
			System.out.println("Browser Tabs Saved");
			}
		});
		
		btnLoad = new JButton("Load");
		btnLoad.setVisible(true);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loadTabs();
			}
		});
		
		btnDefault = new JButton("Default");
		btnDefault.setVisible(false);
		
		lblNewLabel = new JLabel("Make sure to use full url address");
		GroupLayout gl_panelTTab = new GroupLayout(panelTTab);
		gl_panelTTab.setHorizontalGroup(
			gl_panelTTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTTab.createSequentialGroup()
					.addGap(38)
					.addComponent(btnRunTabs)
					.addGap(115)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelTTab.createSequentialGroup()
					.addGap(38)
					.addComponent(chckbx1)
					.addGap(93)
					.addComponent(comboBoxTab1, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelTTab.createSequentialGroup()
					.addGap(38)
					.addComponent(chckbx2)
					.addGap(93)
					.addComponent(comboBoxTab2, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelTTab.createSequentialGroup()
					.addGap(38)
					.addComponent(chckbx3)
					.addGap(93)
					.addComponent(comboBoxTab3, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(btnDefault))
				.addGroup(gl_panelTTab.createSequentialGroup()
					.addGap(38)
					.addComponent(chckbx4)
					.addGap(93)
					.addComponent(comboBoxTab4, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelTTab.createSequentialGroup()
					.addGap(38)
					.addComponent(chckbx5)
					.addGap(93)
					.addComponent(comboBoxTab5, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(btnLoad))
				.addGroup(gl_panelTTab.createSequentialGroup()
					.addGap(38)
					.addComponent(chckbx6)
					.addGap(93)
					.addComponent(comboBoxTab6, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelTTab.createSequentialGroup()
					.addGap(779)
					.addComponent(btnSave))
		);
		gl_panelTTab.setVerticalGroup(
			gl_panelTTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTTab.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRunTabs)
						.addGroup(gl_panelTTab.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel)))
					.addGap(18)
					.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbx1)
						.addGroup(gl_panelTTab.createSequentialGroup()
							.addGap(3)
							.addComponent(comboBoxTab1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTTab.createSequentialGroup()
							.addGap(2)
							.addComponent(chckbx2))
						.addComponent(comboBoxTab2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTTab.createSequentialGroup()
							.addGap(2)
							.addComponent(chckbx3))
						.addComponent(comboBoxTab3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelTTab.createSequentialGroup()
							.addGap(2)
							.addComponent(btnDefault)))
					.addGap(57)
					.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTTab.createSequentialGroup()
							.addGap(2)
							.addComponent(chckbx4))
						.addComponent(comboBoxTab4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTTab.createSequentialGroup()
							.addGap(2)
							.addComponent(chckbx5))
						.addComponent(comboBoxTab5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelTTab.createSequentialGroup()
							.addGap(16)
							.addComponent(btnLoad)))
					.addGap(5)
					.addGroup(gl_panelTTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTTab.createSequentialGroup()
							.addGap(2)
							.addComponent(chckbx6))
						.addComponent(comboBoxTab6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnSave))
		);
		panelTTab.setLayout(gl_panelTTab);
		
		JPanel panelTSettings = new JPanel();
		tabbedPane.addTab("Settings", null, panelTSettings, null);
		
		txtpnHiWePlan_1 = new JTextPane();
		txtpnHiWePlan_1.setText("Hi, we plan to working on this soon.\r\n\r\nFor now, enjoy our other features and we'll tell you when something new happens\r\n\r\nCheck out our github page at https://github.com/North-Pole-Neon/Tigris-Auxilium for new info and help");
		txtpnHiWePlan_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnHiWePlan_1.setEditable(false);
		panelTSettings.add(txtpnHiWePlan_1);

		
		
		 
		 loadTabs();
	}
	
	
	
	public void goToLinks() {
		
		if (chckbx1.isSelected() == true) { 
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(comboBoxTab1.getText()));
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
	
	
	public void loadTabs() {
		
		RWJsonBTabs.pathMaker(RWJsonUser.getOSVersion());
		RWJsonBTabs.LinksFileExists(RWJsonUser.getOSVersion());
		RWJsonBTabs.ReadToJson();
		
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
	
	
}
