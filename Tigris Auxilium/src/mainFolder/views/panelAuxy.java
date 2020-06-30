package mainFolder.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import mainFolder.common.UBIC_GenRead;

//Size of window 784, 438
public class panelAuxy extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1904923341438159983L;
	private String ownerName;
	
	
	/**
	 * Create the panel.
	 */
	public panelAuxy() {
		setLayout(null);
		setBounds(100, 100, 859, 438);
		
		UBIC_GenRead userInfo = new UBIC_GenRead();
		userInfo.RUserBasic();
		ownerName = userInfo.userNAME;
		
		
		JLabel lblWarning = new JLabel("Hi their " + ownerName + ", the Home page is not ready yet. :(");
		lblWarning.setBounds(194, 30, 289, 16);
		add(lblWarning);
		
		

	}
}
