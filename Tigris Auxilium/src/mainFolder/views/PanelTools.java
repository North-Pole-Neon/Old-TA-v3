package mainFolder.views;

import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import org.j2mT.*;

import mainFolder.common.CryptFile;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import java.awt.Font;

public class PanelTools extends JPanel {

	/*
	 * 
	 */
	private static final long serialVersionUID = -2433832224159377567L;
	private JTextField textFieldIfPath;
	private JTextField textFieldOuPath;

	/*
	 * Create the panel.
	 */
	public PanelTools() {
		setBounds(100, 100, 859, 438);
		setLayout(null);
		
		AppleScript aps = new AppleScript();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 839, 416);
		add(tabbedPane);
		
		JPanel cPanelPower = new JPanel();
		tabbedPane.addTab("Power", null, cPanelPower, null);
		cPanelPower.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(39, 34, 130, 154);
		cPanelPower.add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
		JButton btnHide = new JButton("Hide apps");
		btnHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aps.MultilineAppleScriptTest(MtBasic.shideAll);
			}
		});
		btnHide.setBounds(10, 43, 89, 23);
		panel.add(btnHide);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aps.MultilineAppleScriptTest(MtBasic.sSleep);
			}
		});
		btnSleep.setBounds(10, 77, 89, 23);
		panel.add(btnSleep);
		
		JButton btnShutDown = new JButton("Shutdown");
		btnShutDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Term term = new Term();
				term.MacTerminalCommand(MtBasic.tShutdown);
			}
		});
		btnShutDown.setBounds(10, 111, 89, 23);
		panel.add(btnShutDown);
		
		JPanel cPanelFile = new JPanel();
		tabbedPane.addTab("Encryption", null, cPanelFile, null);
		cPanelFile.setLayout(null);
		
		JRadioButton rdbtnEnEN = new JRadioButton("Encrypt");
		rdbtnEnEN.setBounds(57, 177, 109, 23);
		cPanelFile.add(rdbtnEnEN);
		
		JRadioButton rdbtnEnDE = new JRadioButton("Decrypt");
		rdbtnEnDE.setBounds(57, 203, 109, 23);
		cPanelFile.add(rdbtnEnDE);
		
		ButtonGroup bgroupen = new ButtonGroup();
		bgroupen.add(rdbtnEnEN);
		bgroupen.add(rdbtnEnDE);
		
		JButton btnEnRun = new JButton("Run");
		btnEnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(bgroupen.);
				if(rdbtnEnEN.isSelected()) {
					CryptFile.fileE(textFieldIfPath.getText(), textFieldOuPath.getText(), "password");
				}else {
					CryptFile.fileD(textFieldIfPath.getText(), textFieldOuPath.getText(), "password");
				}
			}
		});
		btnEnRun.setBounds(226, 203, 89, 23);
		cPanelFile.add(btnEnRun);
		
		JPanel ccpanInPath = new JPanel();
		ccpanInPath.setBorder(new TitledBorder(null, "Input File Path", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ccpanInPath.setBounds(57, 41, 387, 45);
		cPanelFile.add(ccpanInPath);
		ccpanInPath.setLayout(new BoxLayout(ccpanInPath, BoxLayout.X_AXIS));
		
		textFieldIfPath = new JTextField();
		ccpanInPath.add(textFieldIfPath);
		textFieldIfPath.setColumns(10);
		
		JButton btnInP = new JButton("...");
		btnInP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton open = new JButton();
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("C://Users/user/Desktop")); // . is current
				fc.setDialogTitle("Input File");
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fc.getSelectedFile().getAbsolutePath());
					textFieldIfPath.setText(fc.getSelectedFile().getAbsolutePath());
				}
				
			}
		});
		ccpanInPath.add(btnInP);
		
		JPanel ccpanOuPath = new JPanel();
		ccpanOuPath.setBorder(new TitledBorder(null, "Output File Path", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ccpanOuPath.setBounds(57, 97, 387, 45);
		cPanelFile.add(ccpanOuPath);
		ccpanOuPath.setLayout(new BoxLayout(ccpanOuPath, BoxLayout.X_AXIS));
		
		textFieldOuPath = new JTextField();
		ccpanOuPath.add(textFieldOuPath);
		textFieldOuPath.setColumns(10);
		
		JButton btnOuP = new JButton("...");
		btnOuP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JButton open = new JButton();
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("C://Users/user/Desktop")); // . is current
				fc.setDialogTitle("Output File");
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fc.getSelectedFile().getAbsolutePath());
					textFieldOuPath.setText(fc.getSelectedFile().getAbsolutePath());
				}
				
			}
		});
		ccpanOuPath.add(btnOuP);
		
		JPanel pcSync = new JPanel();
		tabbedPane.addTab("Sync", null, pcSync, null);
		pcSync.setLayout(null);
		
		JTextPane txtpnHiWePlan_1 = new JTextPane();
		txtpnHiWePlan_1.setText("Hi, we plan to working on this soon.\r\n\r\nFor now, enjoy our other features and we'll tell you when something new happens\r\n\r\nCheck out our github page at https://github.com/North-Pole-Neon/Tigris-Auxilium for new info and help");
		txtpnHiWePlan_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnHiWePlan_1.setEditable(false);
		txtpnHiWePlan_1.setBounds(180, 111, 402, 95);
		pcSync.add(txtpnHiWePlan_1);
		

	}
	
	public void AsHide() //Should Hide apps CHXME Hide apps mac
	  {
	    Runtime runtime = Runtime.getRuntime();
	    
	    // an applescript command that is multiple lines long.
	    // just create a java string, and remember the newline characters.
	    String applescriptCommand =  "tell application \"TextExpander\" to launch\n" + 
	    											"\n" + 
	    											"tell application \"Finder\"\n" + 
	    											"\n" + 
	    											"set visible of process \"TextExpander\" to false\n" + 
	    											"\n" + 
	    											"end tell";

	    String[] args = { "osascript", "-e", applescriptCommand };

	    try
	    {
	      @SuppressWarnings("unused")
		Process process = runtime.exec(args);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }
	
	
	public void MultilineAppleScriptTest() //template
	  {
	    Runtime runtime = Runtime.getRuntime();
	    
	    // an applescript command that is multiple lines long.
	    // just create a java string, and remember the newline characters.
	    String applescriptCommand =  "tell app \"iTunes\"\n" + 
	                                   "activate\n" +
	                                   "set sound volume to 40\n" + 
	                                   "set EQ enabled to true\n" +
	                                   "play\n" +
	                                 "end tell";

	    String[] args = { "osascript", "-e", applescriptCommand };

	    try
	    {
	      @SuppressWarnings("unused")
		Process process = runtime.exec(args);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }
}


/*
 * Applescript tell
 * 
 * "tell app \"iTunes\"\n" + 
	                                   "activate\n" +
	                                   "set sound volume to 40\n" + 
	                                   "set EQ enabled to true\n" +
	                                   "play\n" +
	                                 "end tell";
*/