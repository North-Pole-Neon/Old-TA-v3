package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelApps extends JPanel {

	/*
	 * 
	 */
	private static final long serialVersionUID = -3602828320124508292L;
	private JTextField textFieldiDmg;
	private JTextField textFieldiPkg;
	private JTextField textFieldiapp;

	/*
	 * Create the panel.
	 */
	public PanelApps() {
		setBounds(100, 100, 859, 438);
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelTMain = new JPanel();
		tabbedPane.addTab("Apps", null, panelTMain, null);
		
		JPanel panelTColl = new JPanel();
		tabbedPane.addTab("Collections", null, panelTColl, null);
		
		JPanel panelInstal = new JPanel();
		tabbedPane.addTab("Install", null, panelInstal, null);
		
		JPanel paneliApp = new JPanel();
		paneliApp.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		textFieldiapp = new JTextField();
		textFieldiapp.setColumns(10);
		
		JButton btniAppCreate = new JButton("Create");
		btniAppCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
}
