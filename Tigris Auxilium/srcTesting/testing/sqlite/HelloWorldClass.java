package testing.sqlite;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class HelloWorldClass extends JFrame {

	private JPanel contentPane;
	private JLabel lblClock;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorldClass frame = new HelloWorldClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public void clock() {
		
		/*Thread clock = new Thread() {
			public void run() {
				try {
					for (;;) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);

						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						
						lblClock.setText("Time " + hour +":"+ minute +":" + second+ " Date " + day + "/" + month +"/" + year);
						
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					}
					
			}
		};
		
		clock.run();*/
		
		
	}
	
	public HelloWorldClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnClick = new JButton("Click");
		btnClick.setBounds(153, 33, 89, 33);
		contentPane.add(btnClick);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(46, 42, 46, 14);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(493, 41, 138, 210);
		contentPane.add(list);
		
		JButton btnLoadValue = new JButton("Load Value");
		btnLoadValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel DLM = new DefaultListModel();
				DLM.addElement("Mark");
				DLM.addElement("July");
				DLM.addElement("John");
				DLM.addElement("Markus");
				DLM.addElement("Peter");
				list.setModel(DLM);
			}
		});
		btnLoadValue.setBounds(385, 38, 89, 23);
		contentPane.add(btnLoadValue);
		
		lblClock = new JLabel("Clock");
		lblClock.setBounds(46, 133, 253, 42);
		contentPane.add(lblClock);
		

		clock();
	}
}
