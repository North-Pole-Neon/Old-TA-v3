package mainFolder.common;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Current State /////////////////////////////////////////////////////////////////////////////////////////////////////



// size is 300x400
public class PanelCalculator extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5164058914575168704L;

	private JTextField textAnswerBox;

	/**
	 * Create the panel.
	 */
	
	// Vars for first numbers
	private String firstNumStr = "";
	private int firstNum;
	private String secondNumStr = "";
	private int secondNum;
	private boolean hasFirstNum = false; //TODO Look into this waste
	private String currentOp = "Blank";
	private int finalAns;
	private String finalAnsStr = "";
	private String currentNum = "";
	
	//Signals
	private boolean hasopted = false; //TODO Look into this waste
	
	
	public PanelCalculator() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.1);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		
		// Text box  here v /////////////////////////////////////////////////////////////////////
		textAnswerBox = new JTextField();
		textAnswerBox.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		splitPane.setLeftComponent(textAnswerBox);
		textAnswerBox.setColumns(10);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		
		JButton btnCalcCE = new JButton("CE");
		btnCalcCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNumStr = "";
				secondNumStr = "";
			}
		});
		btnCalcCE.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnDel = new JButton("Del");
		btnDel.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalcDivide = new JButton("/");
		btnCalcDivide.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalc7 = new JButton("7");
		btnCalc7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentNum = textAnswerBox.getText();
				textAnswerBox.setText(currentNum + 7);
			}
		});
		btnCalc7.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalc8 = new JButton("8");
		btnCalc8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentNum = textAnswerBox.getText();
				textAnswerBox.setText(currentNum + 8);
			}
		});
		btnCalc8.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalc9 = new JButton("9");
		btnCalc9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentNum = textAnswerBox.getText();
				textAnswerBox.setText(currentNum + 9);
			}
		});
		btnCalc9.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnX = new JButton("x");
		btnX.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalc6 = new JButton("6");
		btnCalc6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentNum = textAnswerBox.getText();
				textAnswerBox.setText(currentNum + 6);
			}
		});
		btnCalc6.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalc5 = new JButton("5");
		btnCalc5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentNum = textAnswerBox.getText();
				textAnswerBox.setText(currentNum + 5);
			}
		});
		btnCalc5.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalc4 = new JButton("4");
		btnCalc4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentNum = textAnswerBox.getText();
				textAnswerBox.setText(currentNum + 4);
			}
		});
		btnCalc4.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalc1 = new JButton("1");
		btnCalc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentNum = textAnswerBox.getText();
				textAnswerBox.setText(currentNum + 1);
			}
		});
		btnCalc1.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalc2 = new JButton("2");
		btnCalc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentNum = textAnswerBox.getText();
				textAnswerBox.setText(currentNum + 2);
			}
		});
		btnCalc2.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalc3 = new JButton("3");
		btnCalc3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentNum = textAnswerBox.getText();
				textAnswerBox.setText(currentNum + 3);
			}
		});
		btnCalc3.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalcAdd = new JButton("+");
		btnCalcAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOp = "add"; //sets op to add
				
				firstNumStr = textAnswerBox.getText(); //Sets FNS to what's in box
				firstNum = Integer.parseInt(firstNumStr); // Sets FN to int version of FNS
				hasFirstNum = true; //Declares that its has its first number
				
				textAnswerBox.setText(""); //Clears text field
			}
		});
		btnCalcAdd.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalcEqaul = new JButton("=");
		btnCalcEqaul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				secondNumStr = textAnswerBox.getText();
				secondNum = Integer.parseInt(secondNumStr);
				
				// Add both numbers
				switch(currentOp) {
				case "add":
					System.out.println("add");
					finalAns = firstNum + secondNum;
					finalAnsStr = Integer.toString(finalAns);
					textAnswerBox.setText(finalAnsStr);
					break;
				case "sub":
					System.out.println("sub");
					finalAns = firstNum - secondNum;
					break;
				case "multi":
					System.out.println("multi");
					finalAns = firstNum * secondNum;
					break;
				case "div":
					System.out.println("div");
					finalAns = firstNum / secondNum;
					break;
				}
			}
		});
		btnCalcEqaul.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalcdec = new JButton(".");
		btnCalcdec.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnCalc0 = new JButton("0");
		btnCalc0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentNum = textAnswerBox.getText();
				textAnswerBox.setText(currentNum + 0);
			}
		});
		btnCalc0.setFont(new Font("Verdana", Font.BOLD, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnCalcCE, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnC, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDel, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCalcDivide, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnCalc7, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCalc8, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCalc9, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnCalc4, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCalc5, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCalc6, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnMinus, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
								.addComponent(btnX, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnCalc1, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCalc2, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCalc3, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(67)
									.addComponent(btnCalc0, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCalcdec, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCalcEqaul, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
								.addComponent(btnCalcAdd, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))))
					.addGap(19))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(85)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalcDivide, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnDel, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnC, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnCalcCE, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalc7, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnCalc8, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnCalc9, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnX, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnMinus, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnCalc6, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnCalc5, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnCalc4, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalc1, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnCalc2, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnCalc3, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnCalcAdd, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalcEqaul, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnCalcdec, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnCalc0, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addGap(20))
		);
		panel.setLayout(gl_panel);

	}
	
	public void addToBox() {
		
	}
	

}
