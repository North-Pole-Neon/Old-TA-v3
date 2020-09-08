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

public class Tigris_Auxilium {

	private JFrame frmTigrisAuxilium;
	private JPanel panelPPComms;
	private static JPanel panelPPAuxy;
	private static JPanel panelPPApps;
	private static JPanel panelPPBrowser;
	private static JLayeredPane layeredPane;
	private JPanel panelPPTools;
	private JPanel panelPPHelp;
	private JPanel panelPPHomework;
	private JPanel panelHPSetup;
	public static JPanel panelMenu;
	private panelBrowser panelBrowserCon;
	private PanelApps panelAppsCon;
	private static panelAuxy panelAuxyCon;
	private PanelCommunication panelCommsCon;
	private PanelHomework panelHomeWorkCon;
	private PanelHelp panelHelpCon;
	private PanelSetup panelSetupCon;
	
	

	/*
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
	 * Create the application
	 */
	public Tigris_Auxilium() {
		RWJsonUser.getOSVersion();
		initialize();
		RWJsonUser.pathMaker();
		
		userDataCheck();
		
		
		
	}

	public void userDataCheck() {
		RWJsonUser.userFileExists();
		if (RWJsonUser.fileUserExists == true) {
			
			RWJsonUser.ReadToJson();
			RWJsonUser.getComputerName(true);
			System.out.println("New: " + RWJsonUser.PCNAME + " Orginal:" + RWJsonUser.PCName); //PRINT PC Names
			//String pcName = RWJsonUser.getComputerName();
			if (RWJsonUser.PCName.equals(RWJsonUser.PCNAME) && RWJsonUser.setupCom.equals("true")) {
				
				loadAfterSU();
				
				
				frmTigrisAuxilium.setTitle("Tigris Auxilium - Hi, " + RWJsonUser.firstName);
			} else {
				//RWJsonUser.clearUserData();
				
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
		
			
		} else {
			//RWJsonUser.clearUserData();
			
			//Basic Logic for loading page
			layeredPane.removeAll();
			layeredPane.add(panelHPSetup);
			layeredPane.repaint();
			layeredPane.validate();
			
			panelMenu.setVisible(false);
		}
		
		
		
		
	}
	
	
	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {//LATER Check load state with Auxy when started
		frmTigrisAuxilium = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frmTigrisAuxilium.getContentPane().getLayout();
		borderLayout.setVgap(2);
		frmTigrisAuxilium.setIconImage(Toolkit.getDefaultToolkit().getImage(Tigris_Auxilium.class.getResource("/mainFolder/resources/NPN Logo.png")));
		frmTigrisAuxilium.setTitle("Tigris Auxilium");
		frmTigrisAuxilium.setBounds(100, 100, 875, 500);
		frmTigrisAuxilium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //LATER Look into close options
		
		
		
		panelMenu = new JPanel();
		frmTigrisAuxilium.getContentPane().add(panelMenu, BorderLayout.NORTH);
		panelMenu.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton btnMenuBrowser = new JButton("Browser");
		btnMenuBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBrowserCon = new panelBrowser();
				panelPPBrowser.add(panelBrowserCon, BorderLayout.CENTER);
				
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
				panelAppsCon = new PanelApps();
				panelPPApps.add(panelAppsCon, BorderLayout.CENTER);
				
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
				panelCommsCon = new PanelCommunication();
				panelPPComms.add(panelCommsCon, BorderLayout.CENTER);
				
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
				panelAuxyCon = new panelAuxy();
				panelPPAuxy.add(panelAuxyCon, BorderLayout.CENTER);
				
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
				PanelTools panelToolsCon = new PanelTools();
				panelPPTools.add(panelToolsCon, BorderLayout.CENTER);
				
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
				panelHomeWorkCon = new PanelHomework();
				panelPPHomework.add(panelHomeWorkCon, BorderLayout.CENTER);
				
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
				panelHelpCon = new PanelHelp();
				panelPPHelp.add(panelHelpCon, BorderLayout.CENTER);
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
		
		//panelBrowserCon = new panelBrowser();
		//panelPPBrowser.add(panelBrowserCon, BorderLayout.CENTER);
		
		panelPPApps = new JPanel();
		layeredPane.add(panelPPApps, "name_218716231119131");
		panelPPApps.setLayout(new BorderLayout(0, 0));
		
		//panelAppsCon = new PanelApps();
		//panelPPApps.add(panelAppsCon, BorderLayout.CENTER);
		
		panelPPAuxy = new JPanel();
		layeredPane.add(panelPPAuxy, "name_218745368112737");
		panelPPAuxy.setLayout(new BorderLayout(0, 0));
		
		//panelAuxyCon = new panelAuxy();
		//panelPPAuxy.add(panelAuxyCon, BorderLayout.CENTER);
		
		panelPPComms = new JPanel();
		layeredPane.add(panelPPComms, "name_218759284414287");
		panelPPComms.setLayout(new BorderLayout(0, 0));
		
		//panelCommsCon = new PanelCommunication();
		//panelPPComms.add(panelCommsCon, BorderLayout.CENTER);
		
		panelPPTools = new JPanel();
		layeredPane.add(panelPPTools, "name_220041051331141");
		panelPPTools.setLayout(new BorderLayout(0, 0));
		
		//PanelTools panelToolsCon = new PanelTools();
		//panelPPTools.add(panelToolsCon, BorderLayout.CENTER);
		
		panelPPHomework = new JPanel();
		layeredPane.add(panelPPHomework, "name_220051324127449");
		panelPPHomework.setLayout(new BorderLayout(0, 0));
		
		//panelHomeWorkCon = new PanelHomework();
		//panelPPHomework.add(panelHomeWorkCon, BorderLayout.CENTER);
		
		panelPPHelp = new JPanel();
		layeredPane.add(panelPPHelp, "name_220054956754493");
		panelPPHelp.setLayout(new BorderLayout(0, 0));
		
		//panelHelpCon = new PanelHelp();
		//panelPPHelp.add(panelHelpCon, BorderLayout.CENTER);
		
		panelHPSetup = new JPanel(); //Setup panel
		layeredPane.add(panelHPSetup, "name_271936022556661");
		panelHPSetup.setLayout(new BorderLayout(0, 0));
		
		panelSetupCon = new PanelSetup();
		panelHPSetup.add(panelSetupCon, BorderLayout.CENTER);
	}
	
	public static void loadAfterSU() {
		panelAuxyCon = new panelAuxy();
		panelPPAuxy.add(panelAuxyCon, BorderLayout.CENTER);
		
		layeredPane.removeAll();
		layeredPane.add(panelPPAuxy);
		layeredPane.repaint();
		layeredPane.validate();
	}
	
	
}
