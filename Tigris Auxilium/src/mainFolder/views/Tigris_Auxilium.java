package mainFolder.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Toolkit;

import mainFolder.common.*;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class Tigris_Auxilium {
//FIXME TRY TO FOLLOW CONSTRUCTOR LIKE UBIC & CALL FUNCTIONS BETWEEN EACH OTHER
	private JFrame frmTigrisAuxilium;
	private JPanel panelPPComms;
	private JPanel panelPPAuxy;
	private JPanel panelPPApps;
	private JPanel panelPPBrowser;
	private JLayeredPane layeredPane;
	private JPanel panelPPTools;
	private JPanel panelPPHelp;
	private JPanel panelPPHomework;
	private JPanel panelHPSetup;
	public static JPanel panelMenu;
	
	//public static boolean plzSave; LATER Old Saved Code

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tigris_Auxilium window = new Tigris_Auxilium();
					window.frmTigrisAuxilium.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/*
	  Create the application.
	 */
	public Tigris_Auxilium() {
		initialize();
		userDataCheck();
		
		/*layeredPane.removeAll();
		layeredPane.add(panelPPAuxy); //Make this work on launch
		layeredPane.repaint();
		layeredPane.validate();*/
		
		
		/*//Basic Logic for loading page
		layeredPane.removeAll();
		layeredPane.add(panelHPSetup);
		layeredPane.repaint();
		layeredPane.validate();//*/
		
		//UserCheck(); OLDCODE Save
		
		/*while(PanelSetup.goodToGo == true) { //TEMP
			System.out.println("Connection " + plzSave);
			
		}*/
		
		
		
	}

	public void userDataCheck() {
		RWJsonUser.ReadToJson();
		RWJsonUser.getComputerName();
		System.out.println("New: " + RWJsonUser.PCNAME + " Orginal:" + RWJsonUser.PCName); //PRINT PC Names
		//String pcName = RWJsonUser.getComputerName();
		if (RWJsonUser.PCName.equals(RWJsonUser.PCNAME) && RWJsonUser.setupCom.equals("true")) {
			layeredPane.removeAll();
			layeredPane.add(panelPPAuxy); //Make this work on launch
			layeredPane.repaint();
			layeredPane.validate();
		} else {
			RWJsonUser.clearUserData();
			
			//Basic Logic for loading page
			layeredPane.removeAll();
			layeredPane.add(panelHPSetup);
			layeredPane.repaint();
			layeredPane.validate();
			
			panelMenu.setVisible(false);
			
			/*if(RWJsonUser.PCName.equals(RWJsonUser.PCNAME) && RWJsonUser.setupCom.equals("true")) {
				layeredPane.removeAll();
				layeredPane.add(panelPPAuxy); //Make this work on launch
				layeredPane.repaint();
				layeredPane.validate();
			}*/
			
		}
		
		
		
		
	}
	
	
	/* OLDCODE Save
	 	public void UserCheck() { // LATER Work on auto close system and opening panels outside of others
		try {
			UBIC_GenRead userCheck  = new UBIC_GenRead();
			userCheck.RUserBasic(); //Looks for file
			PanelSetup setupIn = new PanelSetup();
			setupIn.userInfoExists(); // Checks if file exists then reads into memory
			if(setupIn.userFileExists == false) { // Opens setup panel
				layeredPane.removeAll(); 
				layeredPane.add(panelHPSetup);
				layeredPane.repaint();
				layeredPane.validate();
				//panelMenu.setVisible(false); //Disable menu
				
				System.out.println("File created"); //PRINT "File created"
				System.out.println(PanelSetup.goodToGo); //TEMP
				while(PanelSetup.goodToGo == true) {// TEMP
					System.out.println("Connection " + plzSave);
					
				}
			}
			
		}catch(Exception e1) {
			
			e1.printStackTrace();
		}
	} */
	

	
	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTigrisAuxilium = new JFrame();
		frmTigrisAuxilium.setIconImage(Toolkit.getDefaultToolkit().getImage(Tigris_Auxilium.class.getResource("/mainFolder/resources/NPN Logo.png")));
		frmTigrisAuxilium.setTitle("Tigris Auxilium");  //LATER Make title TA with name
		frmTigrisAuxilium.setBounds(100, 100, 875, 500);
		frmTigrisAuxilium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //LATER Look into close options
		
		
		
		panelMenu = new JPanel();
		frmTigrisAuxilium.getContentPane().add(panelMenu, BorderLayout.NORTH);
		panelMenu.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton btnMenuBrowser = new JButton("Browser");
		btnMenuBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelPPBrowser);
				layeredPane.repaint();
				layeredPane.validate();
			}
		});
		panelMenu.add(btnMenuBrowser);
		
		JButton btnMenuApps = new JButton("Apps");
		btnMenuApps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelPPApps);
				layeredPane.repaint();
				layeredPane.validate();
			}
		});
		panelMenu.add(btnMenuApps);
		
		JButton btnMenuCommunication = new JButton("Communication");
		btnMenuCommunication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelPPComms);
				layeredPane.repaint();
				layeredPane.validate();
			}
		});
		panelMenu.add(btnMenuCommunication);
		
		JButton btnMenuHome = new JButton("Home");
		btnMenuHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelPPAuxy);
				layeredPane.repaint();
				layeredPane.validate();
			}
		});
		panelMenu.add(btnMenuHome);
		
		JButton btnMenuTools = new JButton("Tools");
		btnMenuTools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelPPTools);
				layeredPane.repaint();
				layeredPane.validate();
			}
		});
		panelMenu.add(btnMenuTools);
		
		JButton btnMenuHomework = new JButton("Homework");
		btnMenuHomework.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelPPHomework);
				layeredPane.repaint();
				layeredPane.validate();
			}
		});
		panelMenu.add(btnMenuHomework);
		
		JButton btnMenuHelp = new JButton("Help");
		btnMenuHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelPPHelp);
				layeredPane.repaint();
				layeredPane.validate();
			}
		});
		panelMenu.add(btnMenuHelp);
		
		layeredPane = new JLayeredPane();
		frmTigrisAuxilium.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelPPBrowser = new JPanel();
		layeredPane.add(panelPPBrowser, "name_216881785358769");
		panelPPBrowser.setLayout(new BorderLayout(0, 0));
		
		panelBrowser panelBrowserCon = new panelBrowser();
		panelPPBrowser.add(panelBrowserCon, BorderLayout.CENTER);
		panelBrowserCon.tabSaveExists(); //Loads save file
		
		panelPPApps = new JPanel();
		layeredPane.add(panelPPApps, "name_218716231119131");
		panelPPApps.setLayout(new BorderLayout(0, 0));
		
		PanelApps panelAppsCon = new PanelApps();
		panelPPApps.add(panelAppsCon, BorderLayout.CENTER);
		
		panelPPAuxy = new JPanel();
		layeredPane.add(panelPPAuxy, "name_218745368112737");
		panelPPAuxy.setLayout(new BorderLayout(0, 0));
		
		panelAuxy panelAuxyCon = new panelAuxy();
		panelPPAuxy.add(panelAuxyCon, BorderLayout.CENTER);
		
		panelPPComms = new JPanel();
		layeredPane.add(panelPPComms, "name_218759284414287");
		panelPPComms.setLayout(new BorderLayout(0, 0));
		
		PanelCommunication panelCommsCon = new PanelCommunication();
		panelPPComms.add(panelCommsCon, BorderLayout.CENTER);
		panelCommsCon.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelPPTools = new JPanel();
		layeredPane.add(panelPPTools, "name_220041051331141");
		panelPPTools.setLayout(new BorderLayout(0, 0));
		
		PanelTools panelToolsCon = new PanelTools();
		panelPPTools.add(panelToolsCon, BorderLayout.CENTER);
		
		panelPPHomework = new JPanel();
		layeredPane.add(panelPPHomework, "name_220051324127449");
		panelPPHomework.setLayout(new BorderLayout(0, 0));
		
		PanelHomework panelHomeWorkCon = new PanelHomework();
		panelPPHomework.add(panelHomeWorkCon, BorderLayout.CENTER);
		
		panelPPHelp = new JPanel();
		layeredPane.add(panelPPHelp, "name_220054956754493");
		panelPPHelp.setLayout(new BorderLayout(0, 0));
		
		PanelHelp panelHelpCon = new PanelHelp();
		panelPPHelp.add(panelHelpCon, BorderLayout.CENTER);
		
		panelHPSetup = new JPanel(); //Setup panel
		layeredPane.add(panelHPSetup, "name_271936022556661");
		panelHPSetup.setLayout(new BorderLayout(0, 0));
		
		PanelSetup panelSetupCon = new PanelSetup();
		panelHPSetup.add(panelSetupCon, BorderLayout.CENTER);
	}
	
	
}
