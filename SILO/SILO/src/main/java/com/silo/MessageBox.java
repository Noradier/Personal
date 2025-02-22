/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silo;

import com.silo.controller.CreateDNCtl;
import com.silo.db.DeliveryNote;
import java.text.ParseException;
import java.util.Date;

public class MessageBox extends javax.swing.JFrame {

    private CreateDNCtl createDNCtl;
    private DeliveryNoteForm deliveryNoteForm;
    
    public MessageBox() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        okButton.setText("OK");
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onOKButtonClick(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(okButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onOKButtonClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onOKButtonClick
        // TODO add your handling code here:
        Date orderDate = null, deliveryDate = null;
        
        try{
            orderDate = createDNCtl.getDateFormat().parse(deliveryNoteForm.getOrderDateTF());
            deliveryDate = createDNCtl.getDateFormat().parse(deliveryNoteForm.getDeliveryDateTF());
        } catch(ParseException e){
            
        }
        
        createDNCtl.addDeliveryNote(new DeliveryNote(
                deliveryNoteForm.getInvoiceNumberTF(),
                deliveryNoteForm.getDeliveryNoteNumberTF(),
                deliveryNoteForm.getCustomerNameTF(),
                "new",
                orderDate,
                deliveryDate
        ));
    }//GEN-LAST:event_onOKButtonClick

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    
    public void setMessageLabel(String message){
        messageLabel.setText(message);
    }

    public void setCreateDNCtl(CreateDNCtl createDNCtl) {
        this.createDNCtl = createDNCtl;
        this.createDNCtl.setConfirmation(this);
    }

    public void setDeliveryNoteForm(DeliveryNoteForm deliveryNoteForm) {
        this.deliveryNoteForm = deliveryNoteForm;
    }
    
}
