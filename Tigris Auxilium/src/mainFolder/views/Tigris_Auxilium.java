package mainFolder.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mainFolder.common.PanelCalculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Toolkit;

import mainFolder.common.*;

public class Tigris_Auxilium {

	private JFrame frmTigrisAuxilium;

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

	/**
	 * Create the application.
	 */
	public Tigris_Auxilium() {
		initialize();
	}

	public void UserCheck() { //Trys to load Save File
		try {
			UBIC_GenRead userCheck  = new UBIC_GenRead();
			userCheck.RUserBasic();
			
			System.out.println(userCheck.userISD);
			//Try to find file
		}catch(Exception e1) {
			e1.printStackTrace();
			//go through setup
		}
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTigrisAuxilium = new JFrame();
		frmTigrisAuxilium.setIconImage(Toolkit.getDefaultToolkit().getImage(Tigris_Auxilium.class.getResource("/mainFolder/resources/NPN Logo.png")));
		frmTigrisAuxilium.setTitle("Tigris Auxilium");
		frmTigrisAuxilium.setBounds(100, 100, 800, 500);
		frmTigrisAuxilium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Basic Current Panel Algorithm //////////////
		
		
		
		// ///////////////////////////////////////////
		
		JPanel panelMenu = new JPanel();
		frmTigrisAuxilium.getContentPane().add(panelMenu, BorderLayout.NORTH);
		panelMenu.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton btnMenuBrowser = new JButton("Browser");
		panelMenu.add(btnMenuBrowser);
		
		JButton btnMenuApps = new JButton("Apps");
		panelMenu.add(btnMenuApps);
		
		JButton btnMenuCommunication = new JButton("Communication");
		panelMenu.add(btnMenuCommunication);
		
		JButton btnMenuHome = new JButton("Home");
		panelMenu.add(btnMenuHome);
		
		JButton btnMenuTools = new JButton("Tools");
		panelMenu.add(btnMenuTools);
		
		JButton btnMenuHomework = new JButton("Homework");
		panelMenu.add(btnMenuHomework);
		
		JButton btnMenuHelp = new JButton("Help");
		panelMenu.add(btnMenuHelp);
		
		PanelSetup panelMain = new PanelSetup();
		frmTigrisAuxilium.getContentPane().add(panelMain, BorderLayout.CENTER);
	}
}
