package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import mainFolder.common.RWJsonUser;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PanelSetup extends JPanel {
	
	private static final long serialVersionUID = 6593219351116763748L;
	private JTextField textFieldFName;
	private JTextField textFieldIsd;
	private JComboBox<?> comboBoxGrade;
	private JTextField textFieldLName;
	

	/*
	 * Create the panel.
	 */
	public PanelSetup() {
		
		JTextArea txtrHelloImAuxy = new JTextArea();
		txtrHelloImAuxy.setBounds(19, 33, 238, 139);
		txtrHelloImAuxy.setLineWrap(true);
		txtrHelloImAuxy.setWrapStyleWord(true);
		txtrHelloImAuxy.setText("Hello, I'm Auxy. I'm here to help you for when you ask. To start, I'm going to need you to fill this out quickly so I can help adjust to better fit your needs.");
		
		JPanel panel = new JPanel();
		panel.setBounds(293, 19, 430, 397);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(19, 190, 147, 148);
		lblNewLabel.setIcon(new ImageIcon(PanelSetup.class.getResource("/mainFolder/resources/NPN Logo.png")));
		
		JLabel lblFName = new JLabel("First Name");
		lblFName.setBounds(18, 69, 51, 14);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(18, 153, 29, 14);
		
		JLabel lblIsd = new JLabel("ISD");
		lblIsd.setBounds(18, 214, 17, 14);
		lblIsd.setToolTipText("\"School District #\" ex. SHS = 720");
		
		textFieldFName = new JTextField();
		textFieldFName.setBounds(172, 66, 86, 20);
		textFieldFName.setColumns(10);
		
		textFieldIsd = new JTextField();
		textFieldIsd.setBounds(172, 211, 86, 20);
		textFieldIsd.setColumns(10);
		
		String [] gradeListBox = {"9", "10", "11", "12"}; //Array of grade options
		comboBoxGrade = new JComboBox<Object>(gradeListBox);
		comboBoxGrade.setBounds(172, 150, 36, 20);
		
		JButton btnFinished = new JButton("Finished!");
		btnFinished.setBounds(172, 282, 75, 23);
		btnFinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Writes to VAR and casts to save
				//WriteJsonUser writeJsonUser = new WriteJsonUser();
				RWJsonUser.firstName = textFieldFName.getText();
				RWJsonUser.lastName = textFieldLName.getText();
				RWJsonUser.sGrade = (String) comboBoxGrade.getSelectedItem();
				RWJsonUser.sIsd = textFieldIsd.getText();
				RWJsonUser.getComputerName(false);
				RWJsonUser.setupCom = "true";
				RWJsonUser.WriteToJson();
				Tigris_Auxilium.panelMenu.setVisible(true);
				
				RWJsonUser.ReadToJson();
				
				
				buildSaveSys();
				
				
				
				//ReadJsonUser readJsonUser = new ReadJsonUser();
				//readJsonUser.ReadToJson();
				
				 
			}
		});
		
		JLabel lblLName = new JLabel("Last Name");
		lblLName.setBounds(18, 107, 51, 14);
		
		textFieldLName = new JTextField();
		textFieldLName.setBounds(172, 104, 86, 20);
		textFieldLName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Please exit and relaunch after setup");
		lblNewLabel_1.setBounds(172, 333, 174, 14);
		panel.setLayout(null);
		panel.add(lblFName);
		panel.add(lblIsd);
		panel.add(lblGrade);
		panel.add(lblLName);
		panel.add(textFieldLName);
		panel.add(textFieldFName);
		panel.add(textFieldIsd);
		panel.add(comboBoxGrade);
		panel.add(lblNewLabel_1);
		panel.add(btnFinished);
		setLayout(null);
		add(txtrHelloImAuxy);
		add(lblNewLabel);
		add(panel);

	}
	
	public void buildSaveSys() {
		
		copyFiles("ProjectPlanner.sqlite");
		copyFiles("Collections.sqlite");
	}
	
	public void copyFiles(String fileName) {
		
		Path source = null;
		try {
			source = Paths.get(PanelSetup.class.getResource("/mainFolder/resources/" + fileName).toURI());
		} catch (URISyntaxException e1) {
			
			e1.printStackTrace();
		}
	    
		
		Object OS = RWJsonUser.osName;
		String fullPath;
		if (OS.equals("Windows 10") || OS.equals("Windows 8") || OS.equals("Windows 7")) {
			fullPath = "C:\\Test\\TA\\Data\\"+fileName;
			
		} else {
			
			String paths = System.getProperty("user.home");
			//System.out.println(paths);
			
			fullPath = paths + "/TA/Data/"+fileName;
			//System.out.println(full);
		}
		
		
		Path destination = Paths.get(fullPath); //"C:\\Test\\TA\\Data\\" + fileName
		
	    
	    
	    try {
			Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
