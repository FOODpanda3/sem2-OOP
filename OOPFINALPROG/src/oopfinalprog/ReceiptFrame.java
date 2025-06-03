/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oopfinalprog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Jassen
 */
public class ReceiptFrame extends javax.swing.JFrame {

    /**
     * Creates new form ReceiptFrame
     */
    public ReceiptFrame() {
        initComponents();
        loadReceipt();
        
    }

   private void loadReceipt() {
        StringBuilder receiptText = new StringBuilder();
        receiptText.append("=== Rental Receipt ===\n\n");

        double total = 0;

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM vehicles WHERE status = 'Rented'");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String model = rs.getString("model");
                String type = rs.getString("type");
                double price = rs.getDouble("price");

                receiptText.append(String.format("Model: %-15s Type: %-10s Price: ₱%.2f\n", model, type, price));
                total += price;
            }

            receiptText.append("\n----------------------------\n");
            receiptText.append(String.format("Total Rental Cost: ₱%.2f", total));

        } catch (SQLException e) {
            receiptText.append("\nError loading receipt: ").append(e.getMessage());
        }

        reciept.setText(receiptText.toString());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        receipt = new javax.swing.JButton();
        rentbtn = new javax.swing.JButton();
        returnbtn = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reciept = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receipt.setText("Receipt");
        receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiptActionPerformed(evt);
            }
        });
        jPanel2.add(receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 90, 60));

        rentbtn.setText("Rent");
        rentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentbtnActionPerformed(evt);
            }
        });
        jPanel2.add(rentbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 90, 60));

        returnbtn.setText("Return");
        returnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbtnActionPerformed(evt);
            }
        });
        jPanel2.add(returnbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 90, 60));

        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel2.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 90, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 650));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reciept.setColumns(20);
        reciept.setRows(5);
        jScrollPane1.setViewportView(reciept);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 590));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 920, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptActionPerformed
        new ReceiptFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_receiptActionPerformed

    private void rentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentbtnActionPerformed
        new RentVehicleFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rentbtnActionPerformed

    private void returnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbtnActionPerformed
        new ReturnVehicleFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnbtnActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        new Login().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(ReceiptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceiptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceiptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceiptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceiptFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JButton receipt;
    private javax.swing.JTextArea reciept;
    private javax.swing.JButton rentbtn;
    private javax.swing.JButton returnbtn;
    // End of variables declaration//GEN-END:variables
}
