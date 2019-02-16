/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Business.CheckingAccount;
import javax.swing.JOptionPane;
/**
 *
 * @author liuyi
 */
public class CreateCheckingAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CheckingAccountJPanel
     */
    private CheckingAccount checkingaccount;
    public CreateCheckingAccountJPanel(CheckingAccount checkingaccount) {
        initComponents();
        this.checkingaccount=checkingaccount;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AccountnumTxtField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        TypeTxtField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        BanknameTxtField = new javax.swing.JTextField();
        BalanceTxtField = new javax.swing.JTextField();
        RoutingnumTxtField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CreateCheckingBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(249, 254, 254));
        setPreferredSize(new java.awt.Dimension(1010, 1166));

        AccountnumTxtField.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        AccountnumTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountnumTxtFieldActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("Account balance:");

        TypeTxtField.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        TypeTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeTxtFieldActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("Bank routing number:");

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Bank account number:");

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("Account type:");

        BanknameTxtField.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        BanknameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BanknameTxtFieldActionPerformed(evt);
            }
        });

        BalanceTxtField.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        BalanceTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BalanceTxtFieldActionPerformed(evt);
            }
        });

        RoutingnumTxtField.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        RoutingnumTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoutingnumTxtFieldActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("Bank name:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel9.setText("Checking Account Information");

        CreateCheckingBtn.setBackground(new java.awt.Color(249, 254, 254));
        CreateCheckingBtn.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        CreateCheckingBtn.setForeground(new java.awt.Color(0, 153, 153));
        CreateCheckingBtn.setText("Create");
        CreateCheckingBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        CreateCheckingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateCheckingBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BalanceTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                    .addComponent(TypeTxtField)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(AccountnumTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(3, 3, 3))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel18))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BanknameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(RoutingnumTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel22)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(CreateCheckingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel9)))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel9)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(BanknameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(RoutingnumTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(AccountnumTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(BalanceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(TypeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113)
                .addComponent(CreateCheckingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AccountnumTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountnumTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AccountnumTxtFieldActionPerformed

    private void TypeTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeTxtFieldActionPerformed

    private void BanknameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BanknameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BanknameTxtFieldActionPerformed

    private void BalanceTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BalanceTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BalanceTxtFieldActionPerformed

    private void RoutingnumTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoutingnumTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoutingnumTxtFieldActionPerformed

    private void CreateCheckingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateCheckingBtnActionPerformed
        // TODO add your handling code here:
        // binding user input to checking account
        checkingaccount.setAccountnum(AccountnumTxtField.getText());
        checkingaccount.setBalance(BalanceTxtField.getText());
        checkingaccount.setBankname(BanknameTxtField.getText());
         checkingaccount.setRoutingnum(RoutingnumTxtField.getText());
         checkingaccount.setType(TypeTxtField.getText());
        JOptionPane.showConfirmDialog(null,"Are you sure to create the checking account information?");
        JOptionPane.showMessageDialog(null,"Create checking account information successfully");
    }//GEN-LAST:event_CreateCheckingBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccountnumTxtField;
    private javax.swing.JTextField BalanceTxtField;
    private javax.swing.JTextField BanknameTxtField;
    private javax.swing.JButton CreateCheckingBtn;
    private javax.swing.JTextField RoutingnumTxtField;
    private javax.swing.JTextField TypeTxtField;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
