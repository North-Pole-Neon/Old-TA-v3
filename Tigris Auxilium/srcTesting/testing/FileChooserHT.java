package testing;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class FileChooserHT {

	public static void main(String[] args) {
		
		JButton open = new JButton();
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("C://Users/user/Desktop")); // . is current
		fc.setDialogTitle("Hello World");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
			
		}
		System.out.println(fc.getSelectedFile().getAbsolutePath());
	}

}
