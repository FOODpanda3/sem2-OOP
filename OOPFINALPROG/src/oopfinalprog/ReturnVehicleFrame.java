/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oopfinalprog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jassen
 */
public class ReturnVehicleFrame extends javax.swing.JFrame {
  private JTable rentalTable;
    private JScrollPane scrollPane;
    
    public ReturnVehicleFrame() {
        initComponents();
         loadVehicles();
         addTablePopupMenu();
           jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                   searchtxt.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyReleased(java.awt.event.KeyEvent evt) {
            performSearch();
        }
    });
    }

     private void loadVehicles() {
        String query = "SELECT * FROM vehicles";

        try (Connection conn = DBconnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0); // Clear existing rows

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getString("model"),
                    rs.getString("status"),
                    rs.getDouble("price")
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading vehicles: " + e.getMessage());
        }
    }
private void returnSelectedVehicle() {
   int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a vehicle to return.");
            return;
        }

        String status = (String) jTable1.getValueAt(selectedRow, 3); // status column

        if (!"Rented".equalsIgnoreCase(status)) {
            JOptionPane.showMessageDialog(this, "Selected vehicle is not currently rented.");
            return;
        }

        int vehicleId = (int) jTable1.getValueAt(selectedRow, 0); // id column

        String query = "UPDATE vehicles SET status = 'Available' WHERE id = " + vehicleId;

        try (Connection conn = DBconnection.getConnection();
             Statement stmt = conn.createStatement()) {

            int rowsUpdated = stmt.executeUpdate(query);

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Vehicle returned successfully.");
                loadVehicles(); // refresh the table
            } else {
                JOptionPane.showMessageDialog(this, "Failed to return vehicle.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
}
  private void addTablePopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem returnItem = new JMenuItem("Return Vehicle");
        returnItem.addActionListener(e -> returnSelectedVehicle());
        popupMenu.add(returnItem);

        jTable1.setComponentPopupMenu(popupMenu);
    }
   private void performSearch() {
    String keyword = searchtxt.getText().trim();

    String query = "SELECT * FROM vehicles WHERE type LIKE ? OR model LIKE ? OR status LIKE ?";

    try (Connection conn = DBconnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {

        String likeKeyword = "%" + keyword + "%";
        ps.setString(1, likeKeyword);
        ps.setString(2, likeKeyword);
        ps.setString(3, likeKeyword);

        ResultSet rs = ps.executeQuery();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear previous data

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("type"),
                rs.getString("model"),
                rs.getString("status"),
                rs.getDouble("price")
            });
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Search failed: " + e.getMessage());
    }
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
        jTable1 = new javax.swing.JTable();
        searchbtn = new javax.swing.JButton();
        searchtxt = new javax.swing.JTextField();

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "type", "model", "status", "price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        searchbtn.setText("search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(searchbtn)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbtn))
                .addContainerGap(27, Short.MAX_VALUE))
        );

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

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        performSearch();
    }//GEN-LAST:event_searchbtnActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnVehicleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnVehicleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnVehicleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnVehicleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnVehicleFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logout;
    private javax.swing.JButton receipt;
    private javax.swing.JButton rentbtn;
    private javax.swing.JButton returnbtn;
    private javax.swing.JButton searchbtn;
    private javax.swing.JTextField searchtxt;
    // End of variables declaration//GEN-END:variables
}
