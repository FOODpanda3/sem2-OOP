/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication22;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TransactionFrame1 extends javax.swing.JFrame {

   private List<Object[]> selectedProducts;
   
    public TransactionFrame1(List<Object[]> products) {
        initComponents();
 this.selectedProducts = (products != null) ? products : new java.util.ArrayList<>();

 
   
  
    updateComboBox();

    this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        quantity = new javax.swing.JSpinner();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Reciept = new javax.swing.JTextArea();
        cash = new javax.swing.JRadioButton();
        card = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        selectproduct = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        Delete1 = new javax.swing.JButton();
        addtoCart1 = new javax.swing.JButton();
        total1 = new javax.swing.JButton();
        Quantity = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product", "Prize", "Quantity", "total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 22, 550, 440));

        Reciept.setColumns(20);
        Reciept.setRows(5);
        jScrollPane2.setViewportView(Reciept);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, 440));

        cash.setText("CASH");
        cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashActionPerformed(evt);
            }
        });
        getContentPane().add(cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        card.setText("Card");
        card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardActionPerformed(evt);
            }
        });
        getContentPane().add(card, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, -1));

        jLabel1.setText("Select Payment Method");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        selectproduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectproductActionPerformed(evt);
            }
        });
        getContentPane().add(selectproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 140, -1));

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 560, 130, 40));

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 510, 150, 40));

        Delete1.setText("Delete");
        Delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete1ActionPerformed(evt);
            }
        });
        getContentPane().add(Delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, 150, 40));

        addtoCart1.setText("ADD ");
        addtoCart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoCart1ActionPerformed(evt);
            }
        });
        getContentPane().add(addtoCart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 130, 40));

        total1.setText("Total");
        total1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total1ActionPerformed(evt);
            }
        });
        getContentPane().add(total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 560, 130, 40));

        Quantity.setText("Quantity");
        Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityActionPerformed(evt);
            }
        });
        getContentPane().add(Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void addProductToTable(String id, String product, Double price, int quantity, double total) {
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).toString().equals(id)) {
              
                int existingQuantity = Integer.parseInt(model.getValueAt(i, 3).toString());
                int newQuantity = existingQuantity + quantity;
                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(price * newQuantity, i, 4);
                return;
            }
        }

   
        model.addRow(new Object[]{id, product, price, quantity, total});
}
    private void cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
          DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Reciept.setText("");
        Quantity.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void Delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete1ActionPerformed
          int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }//GEN-LAST:event_Delete1ActionPerformed

    private void cardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardActionPerformed
        
    }//GEN-LAST:event_cardActionPerformed

    private void selectproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectproductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectproductActionPerformed

    private void addtoCart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoCart1ActionPerformed
     String selectedItem = (String) selectproduct.getSelectedItem();
        String quantityText = Quantity.getText();

       
        if (selectedItem == null || selectedItem.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a product.");
            return;
        }

        
        if (quantityText.isEmpty() || !quantityText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity.");
            return;
        }

        int quantity = Integer.parseInt(quantityText);

      
        String[] parts = selectedItem.split(" - ");
        if (parts.length < 2) {
            JOptionPane.showMessageDialog(this, "Invalid product format.");
            return;
        }

        String productId = parts[0];
        String productName = parts[1];

        
        double price = getProductPriceById(productId);
        double total = price * quantity;

      
        addProductToTable(productId, productName, price, quantity, total);
    }//GEN-LAST:event_addtoCart1ActionPerformed
private double getProductPriceById (String productId) {
     for (Object[] product : selectedProducts) {
            if (product[0].toString().equals(productId)) {
                return (Double) product[2];
            }
        }
        return 0.0;
}
    private void QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityActionPerformed

    private void total1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total1ActionPerformed
      DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
      
        double totalAmount = 0;
        Reciept.setText("Receipt:\n-------------------\n");

        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1) != null && model.getValueAt(i, 2) != null && model.getValueAt(i, 3) != null) {
                String product = model.getValueAt(i, 1).toString();
                double price = Double.parseDouble(model.getValueAt(i, 2).toString());
                int quantity = Integer.parseInt(model.getValueAt(i, 3).toString());
                double total = price * quantity;
                totalAmount += total;
                Reciept.append(product + " x" + quantity + " = $" + total + "\n");
            }
        }
        Reciept.append("-------------------\n");
        Reciept.append("Total: $" + totalAmount + "\n");
        Reciept.append("Payment Method: " + (cash.isSelected() ? "Cash" : card.isSelected() ? "Card" : "Not Selected"));
    
    }//GEN-LAST:event_total1ActionPerformed
  private void updateComboBox() {
   DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        selectproduct.removeAllItems();

         for (Object[] product : selectedProducts) {
            if (product.length >= 2) {
                String id = product[0].toString();
                String productName = product[1].toString();
                selectproduct.addItem(id + " - " + productName);
            }
        }
}
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       this.dispose(); 
    new MainFrame().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(TransactionFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete1;
    private javax.swing.JTextField Quantity;
    private javax.swing.JTextArea Reciept;
    private javax.swing.JButton addtoCart1;
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton card;
    private javax.swing.JRadioButton cash;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner quantity;
    private javax.swing.JButton reset;
    private javax.swing.JComboBox<String> selectproduct;
    private javax.swing.JButton total1;
    // End of variables declaration//GEN-END:variables
}
