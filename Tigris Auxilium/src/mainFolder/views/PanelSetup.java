package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import mainFolder.common.*;

public class PanelSetup extends JPanel {
	private JTextField textFieldName;
	private JTextField textFieldIsd;

	/**
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
					.addContainerGap(15, Short.MAX_VALUE))
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
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		JLabel lblName = new JLabel("First Name");
		
		JLabel lblGrade = new JLabel("Grade");
		
		JLabel lblIsd = new JLabel("ISD");
		lblIsd.setToolTipText("\"School District #\" ex. SHS = 720");
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		
		textFieldIsd = new JTextField();
		textFieldIsd.setColumns(10);
		
		String [] gradeListBox = {"9", "10", "11", "12"}; //Array of grade options
		JComboBox<?> comboBoxGrade = new JComboBox<Object>(gradeListBox);
		
		JButton btnFinished = new JButton("Finished!");
		btnFinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UBIC_GenRead tests = new UBIC_GenRead(); //Instance UBIC Class
				tests.userNAME = textFieldName.getText(); 
				tests.userGRADE = Integer.parseInt((String) comboBoxGrade.getSelectedItem()); //Converts comboBox to int and sets var
				tests.userISD = Integer.parseInt(textFieldIsd.getText());
				tests.setupCOMP = true;
				tests.CUserBasic(tests.userNAME, tests.userGRADE, tests.userISD, tests.setupCOMP);
				tests.RUserBasic();
				 
			}
		});
		//comboBox.getSelectedItem();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(lblIsd)
						.addComponent(lblGrade))
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFinished)
						.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldIsd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrade)
						.addComponent(comboBoxGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsd)
						.addComponent(textFieldIsd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addComponent(btnFinished)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
}
