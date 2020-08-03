package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import mainFolder.common.RWJsonUser;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import mainFolder.common.*;

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
		txtrHelloImAuxy.setLineWrap(true);
		txtrHelloImAuxy.setWrapStyleWord(true);
		txtrHelloImAuxy.setText("Hello, I'm Auxy. I'm here to help you for when you ask. To start, I'm going to need you to fill this out quickly so I can help adjust to better fit your needs.");
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(txtrHelloImAuxy, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(txtrHelloImAuxy, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		JLabel lblFName = new JLabel("First Name");
		
		JLabel lblGrade = new JLabel("Grade");
		
		JLabel lblIsd = new JLabel("ISD");
		lblIsd.setToolTipText("\"School District #\" ex. SHS = 720");
		
		textFieldFName = new JTextField();
		textFieldFName.setColumns(10);
		
		textFieldIsd = new JTextField();
		textFieldIsd.setColumns(10);
		
		String [] gradeListBox = {"9", "10", "11", "12"}; //Array of grade options
		comboBoxGrade = new JComboBox<Object>(gradeListBox);
		
		JButton btnFinished = new JButton("Finished!");
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
				
				
				
				
				//ReadJsonUser readJsonUser = new ReadJsonUser();
				//readJsonUser.ReadToJson();
				
				 
			}
		});
		
		JLabel lblLName = new JLabel("Last Name");
		
		textFieldLName = new JTextField();
		textFieldLName.setColumns(10);
		//comboBox.getSelectedItem(); OLDCODE Save
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFName)
						.addComponent(lblIsd)
						.addComponent(lblGrade)
						.addComponent(lblLName, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldLName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFinished)
						.addComponent(textFieldFName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldIsd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFName)
						.addComponent(textFieldFName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLName)
						.addComponent(textFieldLName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrade)
						.addComponent(comboBoxGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsd)
						.addComponent(textFieldIsd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addComponent(btnFinished)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
}
