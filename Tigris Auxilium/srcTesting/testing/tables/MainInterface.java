package testing.tables;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

public class MainInterface extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8764595051058684818L;
	ArrayList<Food> foodlist;
	String header[] = new String[]{"Food Name", "Food Price", "Food Location"};
	DefaultTableModel dtm;
	int row,col;
	    /**
	     * Creates new form MainInterface
	     */
	    public MainInterface() {
	        initComponents();
	        foodlist = new ArrayList<>();
	        dtm = new DefaultTableModel(header,0);
	        jTable2.setModel(dtm);
	        this.setLocationRelativeTo(null);
	    }

	    /*
	     * This method is called from within the constructor to initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is always
	     * regenerated by the Form Editor.
	     */
	    
	    
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jPanel1 = new javax.swing.JPanel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel2.setBounds(12, 16, 54, 14);
	        jTextFoodName = new javax.swing.JTextField();
	        jTextFoodName.setBounds(84, 13, 398, 20);
	        jLabel3 = new javax.swing.JLabel();
	        jLabel3.setBounds(12, 39, 50, 14);
	        jTextFoodPrice = new javax.swing.JTextField();
	        jTextFoodPrice.setBounds(84, 39, 94, 20);
	        jLabel4 = new javax.swing.JLabel();
	        jLabel4.setBounds(12, 65, 67, 14);
	        jCBFoodLocation = new javax.swing.JComboBox<>();
	        jCBFoodLocation.setBounds(83, 65, 95, 20);
	        jPanel2 = new javax.swing.JPanel();
	        jButton1 = new javax.swing.JButton();
	        jButton1.setBounds(12, 13, 95, 23);
	        jButton2 = new javax.swing.JButton();
	        jButton2.setBounds(125, 13, 105, 23);
	        jButton3 = new javax.swing.JButton();
	        jButton3.setBounds(248, 13, 109, 23);
	        jButton4 = new javax.swing.JButton();
	        jButton4.setBounds(375, 13, 107, 23);
	        jScrollPane4 = new javax.swing.JScrollPane();
	        jTable2 = new javax.swing.JTable();

	        jLabel1.setText("jLabel1");

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setTitle("Food Application");
	        setResizable(false);

	        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

	        jLabel2.setText("Food Name");

	        jLabel3.setText("Food Price");

	        jLabel4.setText("Food Location");

	        jCBFoodLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MISC", "Petronas", "TNB", "Kachi", "Muamalat" }));
	        jCBFoodLocation.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jCBFoodLocationActionPerformed(evt);
	            }
	        });

	        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

	        jButton1.setText("Add");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jButton2.setText("Delete");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jButton3.setText("Update");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        jButton4.setText("Search");
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton4ActionPerformed(evt);
	            }
	        });

	        jTable2.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null}
	            },
	            new String [] {
	                "Title 1", "Title 2", "Title 3", "Title 4"
	            }
	        ));
	        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jTable2MouseClicked(evt);
	            }
	        });
	        jScrollPane4.setViewportView(jTable2);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        layout.setHorizontalGroup(
	        	layout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
	        				.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(jPanel2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
	        			.addContainerGap())
	        );
	        layout.setVerticalGroup(
	        	layout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
	        			.addGap(31)
	        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	        			.addGap(51)
	        			.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
	        			.addGap(13))
	        );
	        jPanel2.setLayout(null);
	        jPanel2.add(jButton1);
	        jPanel2.add(jButton2);
	        jPanel2.add(jButton3);
	        jPanel2.add(jButton4);
	        getContentPane().setLayout(layout);
	        jPanel1.setLayout(null);
	        jPanel1.add(jLabel2);
	        jPanel1.add(jLabel3);
	        jPanel1.add(jTextFoodName);
	        jPanel1.add(jTextFoodPrice);
	        jPanel1.add(jLabel4);
	        jPanel1.add(jCBFoodLocation);

	        pack();
	    }// </editor-fold>//GEN-END:initComponents

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	        // 
	        String foodname = jTextFoodName.getText();
	        double foodprice = Double.parseDouble(jTextFoodPrice.getText());
	        String foodloc = jCBFoodLocation.getSelectedItem().toString();
	        foodlist.add(new Food(foodname,foodloc,foodprice));
	        dtm.setRowCount(0);//reset data model
	        for (int i = 0; i < foodlist.size(); i++) {
	            Object[] objs = {foodlist.get(i).foodname,foodlist.get(i).foodprice,foodlist.get(i).foodloc};
	            dtm.addRow(objs);
	        }
	        //reset
	        clearField();
	    }//GEN-LAST:event_jButton1ActionPerformed

	    private void clearField(){
	        jTextFoodName.requestFocus();
	        jTextFoodName.setText("");
	        jTextFoodPrice.setText("");
	        jCBFoodLocation.setSelectedIndex(0);
	    }
	    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
	        // 
	        row = jTable2.getSelectedRow();
	        col = jTable2.getColumnCount();
	        System.out.println(row+","+col);
	        jTextFoodName.setText(dtm.getValueAt(row, 0).toString());
	        jTextFoodPrice.setText(dtm.getValueAt(row, 1).toString());
	        String location = dtm.getValueAt(row, 2).toString();
	        for (int i = 0; i<(jCBFoodLocation.getItemCount());i++){
	            if (jCBFoodLocation.getItemAt(i).equalsIgnoreCase(location)){
	                jCBFoodLocation.setSelectedIndex(i);
	            }
	        }
	    }//GEN-LAST:event_jTable2MouseClicked

	    private void jCBFoodLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBFoodLocationActionPerformed
	        // 
	    }//GEN-LAST:event_jCBFoodLocationActionPerformed

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	        
	        
	        int dialogButton = JOptionPane.YES_NO_OPTION;
	        int dialogResult = JOptionPane.showConfirmDialog(this, "Delete this data", "Delete", dialogButton);
	        if(dialogResult == 0) {
	            dtm.removeRow(row);
	            foodlist.remove(row);
	            dtm.setRowCount(0);//reset table and populate again with foodlist
	            for (int i = 0; i < foodlist.size(); i++) {
	                Object[] objs = {foodlist.get(i).foodname,foodlist.get(i).foodprice,foodlist.get(i).foodloc};
	                dtm.addRow(objs);
	            }
	            clearField();
	        } else {
	            
	        } 

	        
	    }//GEN-LAST:event_jButton2ActionPerformed

	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
	        // 
	        String updatedfoodname = jTextFoodName.getText();
	        double updatedfoodprice = Double.parseDouble(jTextFoodPrice.getText());
	        String updatedfoodloc = jCBFoodLocation.getSelectedItem().toString();
	        foodlist.get(row).foodname = updatedfoodname;
	        foodlist.get(row).foodprice = updatedfoodprice;
	        foodlist.get(row).foodloc = updatedfoodloc;
	        dtm.setRowCount(0);//reset table and repopulated
	        for (int i = 0; i < foodlist.size(); i++) {
	            Object[] objs = {foodlist.get(i).foodname,foodlist.get(i).foodprice,foodlist.get(i).foodloc};
	            dtm.addRow(objs);
	        }
	    }//GEN-LAST:event_jButton3ActionPerformed

	    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
	        
	        String input = JOptionPane.showInputDialog(this,"Search Food Name:");
	        for (int i = 0; i < foodlist.size(); i++) {
	            if (foodlist.get(i).foodname.equalsIgnoreCase(input)){
	                JOptionPane.showMessageDialog(jButton4, "Found!!!","Search Food",2);
	                jTextFoodName.setText(foodlist.get(i).foodname);
	                jTextFoodPrice.setText(String.valueOf(foodlist.get(i).foodprice));
	                String location = foodlist.get(i).foodloc;
	                 for (int j = 0; j<(jCBFoodLocation.getItemCount());j++){
	                    if (jCBFoodLocation.getItemAt(i).equalsIgnoreCase(location)){
	                        jCBFoodLocation.setSelectedIndex(i);
	                   }
	                }
	                 return;//Quit after found
	            }
	        }
	        JOptionPane.showMessageDialog(jButton4, "Not Found!!!","Search Food",2);

	    }//GEN-LAST:event_jButton4ActionPerformed

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String args[]) {
	        /* Set the Nimbus look and feel */
	        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	         */
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new MainInterface().setVisible(true);
	            }
	        });
	    }

	    // Variables declaration - do not modify//GEN-BEGIN:variables
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JComboBox<String> jCBFoodLocation;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    private javax.swing.JScrollPane jScrollPane4;
	    private javax.swing.JTable jTable2;
	    private javax.swing.JTextField jTextFoodName;
	    private javax.swing.JTextField jTextFoodPrice;
	    // End of variables declaration//GEN-END:variables
}