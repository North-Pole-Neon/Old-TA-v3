package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//import mainFolder.resources.*;
// TODO Figure out import error
public class panelBrowser extends JPanel {
	private JComboBox comboBoxTab1;
	private JComboBox comboBoxTab2;
	private JComboBox comboBoxTab3;
	private JComboBox comboBoxTab4;
	private JComboBox comboBoxTab5;
	private JComboBox comboBoxTab6;
	private JCheckBox chckbx1;
	private JCheckBox chckbx2;
	private JCheckBox chckbx3;
	private JCheckBox chckbx4;
	private JCheckBox chckbx5;
	private JCheckBox chckbx6;

	/**
	 * Create the panel.
	 */
	public panelBrowser() {
		setBounds(100, 100, 859, 438);
		setLayout(new BorderLayout(0, 0));
		
		//URL myURL = new URL("http://example.com/");
		// This is the one vvv ---------------------------
		/*String url_open ="http://google.com";
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
		} catch (IOException e) {
			
			e.printStackTrace();
		}*/

		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JPanel panelTBrowser = new JPanel();
		tabbedPane.addTab("Browser", null, panelTBrowser, null);
		
		JLabel lblNewLabel = new JLabel("Hi their, the Browser page is not ready yet. :(");
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
		
		String [] ListBox1 = {"", "https://mail.google.com/", "https://calendar.google.com/", "https://shakopee.instructure.com/", "https://shakopeemn.infinitecampus.org/"};
		comboBoxTab1 = new JComboBox(ListBox1);
		comboBoxTab1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				hasClickedOut();
				System.out.println("It"); 
			}
		});
		comboBoxTab1.setEditable(true);
		
		//if (comboBoxTab1.mouseReleased)
		//mouseReleased
		
		//String boxlinkstring1= comboBoxTab1.getSelectedItem().toString();

		//JOptionPane.showMessageDialog(parentComponent, message);
		//comboBoxTab1.getSelectedItem();
		//JoptionPane.showinput
		
		comboBoxTab2 = new JComboBox(ListBox1);
		comboBoxTab2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) { 
			}
		});
		comboBoxTab2.setEditable(true);
		
		comboBoxTab3 = new JComboBox(ListBox1);
		comboBoxTab3.setEditable(true);
		
		comboBoxTab4 = new JComboBox(ListBox1);
		comboBoxTab4.setEditable(true);
		
		comboBoxTab5 = new JComboBox(ListBox1);
		comboBoxTab5.setEditable(true);
		
		comboBoxTab6 = new JComboBox(ListBox1);
		comboBoxTab6.setEditable(true);
		
		JButton btnRunTabs = new JButton("Open tabs now");
		btnRunTabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//TODO Find Alliterative that will prompt message
				goToLinks();
			}
		});
		GroupLayout gl_panelTTab = new GroupLayout(panelTTab);
		gl_panelTTab.setHorizontalGroup(
			gl_panelTTab.createParallelGroup(Alignment.LEADING)
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
								.addComponent(comboBoxTab5, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxTab4, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxTab3, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxTab2, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxTab1, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(177, Short.MAX_VALUE))
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
						.addComponent(comboBoxTab3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
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
					.addContainerGap(76, Short.MAX_VALUE))
		);
		panelTTab.setLayout(gl_panelTTab);
		
		JPanel panelTSettings = new JPanel();
		tabbedPane.addTab("Settings", null, panelTSettings, null);

	}
	public void goToLinks() {
		String boxlinkstring1= comboBoxTab1.getSelectedItem().toString();
		String boxlinkstring2= comboBoxTab2.getSelectedItem().toString();
		String boxlinkstring3= comboBoxTab3.getSelectedItem().toString();
		String boxlinkstring4= comboBoxTab4.getSelectedItem().toString();
		String boxlinkstring5= comboBoxTab5.getSelectedItem().toString();
		String boxlinkstring6= comboBoxTab6.getSelectedItem().toString();
		Boolean urlcheck1 = chckbx1.isSelected();
		Boolean urlcheck2 = chckbx2.isSelected();
		Boolean urlcheck3 = chckbx3.isSelected();
		Boolean urlcheck4 = chckbx4.isSelected();
		Boolean urlcheck5 = chckbx5.isSelected();
		Boolean urlcheck6 = chckbx6.isSelected();
		
		if (urlcheck1 == true) {
			String url_open1 =boxlinkstring1;
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open1));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if (urlcheck2 == true) {
			String url_open2 =boxlinkstring2;
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open2));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if (urlcheck3 == true) {
			String url_open3 =boxlinkstring3;
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open3));
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		if (urlcheck4 == true) {
			String url_open4 =boxlinkstring4;
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open4));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if (urlcheck5 == true) {
			String url_open5 =boxlinkstring5;
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open5));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if (urlcheck6 == true) {
			String url_open6 =boxlinkstring6;
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open6));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
				
	}
	
	
	private void hasClickedOut() { // TODO Figure out why it might not be  displaying
		ImageIcon iconmessage = new ImageIcon("./src/mainFolder/resources/NPN Logo.png");
		//String name = (String) JOptionPane.showInputDialog(null, "Please enter nickname", "Auxy", JOptionPane.QUESTION_MESSAGE, iconmessage, null, null);
		String name2 =JOptionPane.showInputDialog("Enter");
		System.out.println(/*name +*/ " and " + name2);
	}
}
