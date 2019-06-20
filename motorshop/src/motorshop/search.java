/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motorshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aniket
 */
public class search extends javax.swing.JFrame {

    /**
     * Creates new form search
     */
    public search() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        searchNameTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        revenueTable = new javax.swing.JTable();
        total = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(809, 554));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("ItemName");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(304, 28, 100, 21);

        searchNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchNameTFActionPerformed(evt);
            }
        });
        getContentPane().add(searchNameTF);
        searchNameTF.setBounds(240, 60, 214, 27);

        jButton1.setText("Get Details");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(270, 110, 160, 30);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Result");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 140, 80, 20);

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item_ID", "Item_Name", "Vendor_Name", "Quantity", "Threshold value"
            }
        ));
        itemTable.setGridColor(java.awt.Color.white);
        itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(itemTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 170, 785, 140);

        jButton3.setText("Get Revenue");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(210, 330, 210, 40);

        revenueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item_Name", "Revenue"
            }
        ));
        jScrollPane2.setViewportView(revenueTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(62, 380, 490, 160);

        total.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        total.setForeground(java.awt.Color.white);
        getContentPane().add(total);
        total.setBounds(630, 450, 80, 40);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Total");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(650, 410, 36, 18);

        jButton2.setText("Home");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(70, 50, 90, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon("/home/aniket/NetBeansProjects/motorshop/Images/check.jpg")); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 10, 810, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchNameTFActionPerformed

    private void itemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTableMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_itemTableMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root" ,"123");  
            ResultSet rs2 = null;
            PreparedStatement ps2 = null;

            ps2 = con.prepareStatement("select * from stock WHERE Item_Name = ?");
            ps2.setString(1, searchNameTF.getText());
            rs2 = ps2.executeQuery();

            try {
                while ( rs2.next() ){
                    DefaultTableModel model2 = (DefaultTableModel)itemTable.getModel();
                    String[] row2 = new String[5];
                    row2[0] = rs2.getString("Item_ID");
                    row2[1] = rs2.getString("Item_Name");
                    row2[2] = rs2.getString("VendorName");
                    row2[3] = rs2.getString("Quantity");
                    row2[4] = rs2.getString("ThresholdValue");

                    model2.addRow(row2);
                    System.out.println(row2);
                    }
                //browseTable.setVisible(false);
            } catch ( Exception e ){
                System.out.println(e);
            }

        } catch ( Exception e ){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
                // TODO add your handling code here:
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        int sum = 0 ;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root" ,"123");  
            ResultSet rs2 = null;
            PreparedStatement ps2 = null;

            ps2 = con.prepareStatement("select * from stock WHERE Item_Name = ?");
            ps2.setString(1, searchNameTF.getText());
            rs2 = ps2.executeQuery();

            try {
                while ( rs2.next() ){
                    DefaultTableModel model2 = (DefaultTableModel)revenueTable.getModel();
                    String[] row2 = new String[2];
                    row2[0] = rs2.getString("Item_Name");
                    row2[1] = rs2.getString("Revenue");
                    sum = sum + Integer.parseInt(row2[1]);
                    model2.addRow(row2);
                    System.out.println(sum);
                    }
                total.setText(Integer.toString(sum));
                //browseTable.setVisible(false);
            } catch ( Exception e ){
                System.out.println(e);
            }

        } catch ( Exception e ){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        UI u = new UI();
        this.dispose();
        u.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable itemTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable revenueTable;
    private javax.swing.JTextField searchNameTF;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
