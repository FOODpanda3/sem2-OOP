/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventorymanagementsystem;


import javax.swing.JOptionPane;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jassen
 */
public class management extends javax.swing.JFrame {

    public management() {
        initComponents();
        setLocationRelativeTo(null);
         loadProducts(); 
         getAllCategory();
          addTableSelectionListener();
    }
    private void loadProducts() {
    String query = "SELECT * FROM products";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("item_name"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("quantity")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
}
private void getAllCategory (){
     Set<String> categories = new HashSet<>();
    category.removeAllItems();
    category.addItem("Select Category");

    String query = "SELECT DISTINCT category FROM products";
    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            String cat = rs.getString("category");
            if (categories.add(cat)) {
                category.addItem(cat);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error fetching categories: " + e.getMessage());
    }

}
 private void addTableSelectionListener() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow >= 0) {
                    itemname.setText(jTable1.getValueAt(selectedRow, 1).toString());
                    category.setSelectedItem(jTable1.getValueAt(selectedRow, 2).toString());
                    price.setText(jTable1.getValueAt(selectedRow, 3).toString());
                    quantity.setText(jTable1.getValueAt(selectedRow, 4).toString());
                }
            }
        });
    }
 private void performSearch(String searchText) {
    String query = "SELECT * FROM products WHERE item_name LIKE ?";
    
    // If search text is empty, load all products
    if (searchText.isEmpty()) {
        loadProducts();  // You should have a loadProducts method that loads all data.
        return;
    }

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setString(1, "%" + searchText + "%"); // Use LIKE to search for partial matches

        try (ResultSet rs = pstmt.executeQuery()) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);  // Clear the table before adding new data

            // Iterate through the results and add them to the table
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("item_name"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("quantity")
                });
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error during search: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        itemname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        save1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        category = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "item_name", "category", "price", "quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 680, 510));

        jLabel1.setText("PRODUCT:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 90, -1));

        itemname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemnameActionPerformed(evt);
            }
        });
        jPanel1.add(itemname, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 300, -1));

        jLabel2.setText("PRICE:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, -1, -1));

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 300, -1));

        jLabel3.setText("Category");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, -1, -1));

        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, 300, -1));

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 440, 90, 50));

        save1.setText("SAVE");
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });
        jPanel1.add(save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, 90, 50));

        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, 90, 50));

        jLabel4.setText("QUANTITY:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, -1, -1));
        jPanel1.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 300, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 340, -1));

        search.setText("search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        jButton1.setText("clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1070, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemnameActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
  String name = itemname.getText();
        String priceText = price.getText();
        String quantityText = quantity.getText();
        String selectedCategory = (String) category.getSelectedItem();

        if (name.isEmpty() || priceText.isEmpty() || quantityText.isEmpty() || selectedCategory.equals("Select Category")) {
            JOptionPane.showMessageDialog(null, "Please fill all fields and select a valid category.");
            return;
        }

        try {
            double priceValue = Double.parseDouble(priceText);
            int quantityValue = Integer.parseInt(quantityText);

            String query = "INSERT INTO products (item_name, price, quantity, category) VALUES (?, ?, ?, ?)";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, name);
                pstmt.setDouble(2, priceValue);
                pstmt.setInt(3, quantityValue);
                pstmt.setString(4, selectedCategory);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Product added successfully!");
                loadProducts();
                getAllCategory();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Price and Quantity must be numbers.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        itemname.setText("");
        price.setText("");
        quantity.setText("");
        category.setSelectedItem("Select Category");
    }//GEN-LAST:event_save1ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
            int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a product to update.");
            return;
        }

        String id = jTable1.getValueAt(selectedRow, 0).toString();
        String name = itemname.getText();
        String priceText = price.getText();
        String quantityText = quantity.getText();
        String selectedCategory = (String) category.getSelectedItem();

        if (name.isEmpty() || priceText.isEmpty() || quantityText.isEmpty() || selectedCategory.equals("Select Category")) {
            JOptionPane.showMessageDialog(null, "Please fill all fields and select a valid category.");
            return;
        }

        try {
            double priceValue = Double.parseDouble(priceText);
            int quantityValue = Integer.parseInt(quantityText);

            String query = "UPDATE products SET item_name = ?, price = ?, quantity = ?, category = ? WHERE id = ?";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, name);
                pstmt.setDouble(2, priceValue);
                pstmt.setInt(3, quantityValue);
                pstmt.setString(4, selectedCategory);
                pstmt.setInt(5, Integer.parseInt(id));
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Product updated successfully!");
                loadProducts();
                getAllCategory();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Price and Quantity must be numbers.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
           int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a product to delete.");
            return;
        }

        int id = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this product?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            String query = "DELETE FROM products WHERE id = ?";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Product deleted successfully!");
                loadProducts();
                getAllCategory();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    
    }//GEN-LAST:event_deleteActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
          String searchText = jTextField1.getText().trim().toLowerCase();
    performSearch(searchText);
    }//GEN-LAST:event_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
jTextField1.setText(""); 
    loadProducts();         
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> category;
    private javax.swing.JButton delete;
    private javax.swing.JTextField itemname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField price;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton save1;
    private javax.swing.JButton search;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
