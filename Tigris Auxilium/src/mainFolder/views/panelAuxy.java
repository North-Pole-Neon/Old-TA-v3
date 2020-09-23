package mainFolder.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import mainFolder.common.Auxy;

//Size of window 784, 438
public class panelAuxy extends JPanel {
	/*
	 * 
	 */
	private static final long serialVersionUID = -1904923341438159983L;
	private JTextField textFieldQuestion;
	public JTextPane textPaneAns;
	//private String ownerName;
	
	
	/*
	 * Create the panel.
	 */
	public panelAuxy() {
		setLayout(null);
		setBounds(100, 100, 859, 438);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(panelAuxy.class.getResource("/mainFolder/resources/hello.png")));
		label.setBounds(35, 142, 151, 163);
		add(label);
		
		JPanel pAskQ = new JPanel();
		pAskQ.setBorder(new TitledBorder(null, "Ask Auxy", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pAskQ.setBounds(272, 167, 374, 82);
		add(pAskQ);
		pAskQ.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel pcAskQ = new JPanel();
		pAskQ.add(pcAskQ);
		pcAskQ.setLayout(new BoxLayout(pcAskQ, BoxLayout.X_AXIS));
		
		textFieldQuestion = new JTextField();
		pcAskQ.add(textFieldQuestion);
		textFieldQuestion.setColumns(10);
		
		JButton btnAsk = new JButton("Ask");
		btnAsk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Auxy auxy = new Auxy();
				textPaneAns.setText(auxy.processAns(textFieldQuestion.getText()));
			}
		});
		pcAskQ.add(btnAsk);
		
		textPaneAns = new JTextPane();
		textPaneAns.setEditable(false);
		pAskQ.add(textPaneAns);
		
		JLabel lblNewLabel = new JLabel("Hi there, we're in early development so, not everything will work or be visible.");
		lblNewLabel.setBounds(151, 46, 533, 33);
		add(lblNewLabel);
		
		

	}
}
