/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Business.Person;
import javax.swing.JOptionPane;
/**
 *
 * @author Richard
 */
public class RegisterJFrame extends javax.swing.JFrame {

    /**
     * Creates new form RegisterJFrame
     */
    private Person person;
    public RegisterJFrame() {
        initComponents();
    }
    public RegisterJFrame(Person person) {
        initComponents();
        this.person = person;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        controlJPanel = new javax.swing.JPanel();
        driverLicenseJB = new javax.swing.JButton();
        savingAccountJB = new javax.swing.JButton();
        checkingAccountJB = new javax.swing.JButton();
        personInfoJB = new javax.swing.JButton();
        addressJB = new javax.swing.JButton();
        medicalJB1 = new javax.swing.JButton();
        ReturnJB = new javax.swing.JButton();
        submitAllJB = new javax.swing.JButton();
        showJPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        controlJPanel.setBackground(new java.awt.Color(153, 153, 153));
        controlJPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        controlJPanel.setPreferredSize(new java.awt.Dimension(150, 500));

        driverLicenseJB.setText("Driver License");
        driverLicenseJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driverLicenseJBActionPerformed(evt);
            }
        });

        savingAccountJB.setText("Saving Account");
        savingAccountJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savingAccountJBActionPerformed(evt);
            }
        });

        checkingAccountJB.setText("Checking Account");
        checkingAccountJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkingAccountJBActionPerformed(evt);
            }
        });

        personInfoJB.setText("Person Info");
        personInfoJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personInfoJBActionPerformed(evt);
            }
        });

        addressJB.setText("Address");
        addressJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressJBActionPerformed(evt);
            }
        });

        medicalJB1.setText("Medical Info");
        medicalJB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalJB1ActionPerformed(evt);
            }
        });

        ReturnJB.setBackground(new java.awt.Color(51, 51, 51));
        ReturnJB.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ReturnJB.setForeground(new java.awt.Color(51, 51, 255));
        ReturnJB.setText("RETURN");
        ReturnJB.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        ReturnJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnJBActionPerformed(evt);
            }
        });

        submitAllJB.setBackground(new java.awt.Color(51, 51, 51));
        submitAllJB.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        submitAllJB.setForeground(new java.awt.Color(255, 0, 0));
        submitAllJB.setText("SUBMIT");
        submitAllJB.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        submitAllJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitAllJBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlJPanelLayout = new javax.swing.GroupLayout(controlJPanel);
        controlJPanel.setLayout(controlJPanelLayout);
        controlJPanelLayout.setHorizontalGroup(
            controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlJPanelLayout.createSequentialGroup()
                .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlJPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(personInfoJB)
                            .addGroup(controlJPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(addressJB))))
                    .addComponent(checkingAccountJB)
                    .addGroup(controlJPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ReturnJB)
                            .addComponent(submitAllJB))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(controlJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(savingAccountJB)
                    .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(medicalJB1)
                        .addComponent(driverLicenseJB)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlJPanelLayout.setVerticalGroup(
            controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlJPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(personInfoJB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addressJB)
                .addGap(18, 18, 18)
                .addComponent(savingAccountJB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkingAccountJB)
                .addGap(24, 24, 24)
                .addComponent(driverLicenseJB)
                .addGap(18, 18, 18)
                .addComponent(medicalJB1)
                .addGap(53, 53, 53)
                .addComponent(ReturnJB)
                .addGap(33, 33, 33)
                .addComponent(submitAllJB)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(controlJPanel);

        showJPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED))));
        showJPanel.setPreferredSize(new java.awt.Dimension(600, 500));

        javax.swing.GroupLayout showJPanelLayout = new javax.swing.GroupLayout(showJPanel);
        showJPanel.setLayout(showJPanelLayout);
        showJPanelLayout.setHorizontalGroup(
            showJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        showJPanelLayout.setVerticalGroup(
            showJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(showJPanel);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void driverLicenseJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driverLicenseJBActionPerformed
        // TODO add your handling code here:
        DriverLicenseInfoJPanel driverLicenseInfoJPanel = new DriverLicenseInfoJPanel(person, 1);
        jSplitPane1.setRightComponent(driverLicenseInfoJPanel);
    }//GEN-LAST:event_driverLicenseJBActionPerformed

    private void savingAccountJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savingAccountJBActionPerformed
        // TODO add your handling code here:
        AccountInfoJPanel accountInfoJPanel1 = new AccountInfoJPanel(person, "saving", 1);
        jSplitPane1.setRightComponent(accountInfoJPanel1);
    }//GEN-LAST:event_savingAccountJBActionPerformed

    private void checkingAccountJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkingAccountJBActionPerformed
        // TODO add your handling code here:
        AccountInfoJPanel accountInfoJPanel2 = new AccountInfoJPanel(person, "checking", 1);
        jSplitPane1.setRightComponent(accountInfoJPanel2);
    }//GEN-LAST:event_checkingAccountJBActionPerformed

    private void personInfoJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personInfoJBActionPerformed
        // TODO add your handling code here:
        PersonInfoJPanel personInfoJPanel = new PersonInfoJPanel(person, 1);
        jSplitPane1.setRightComponent(personInfoJPanel);
    }//GEN-LAST:event_personInfoJBActionPerformed

    private void addressJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressJBActionPerformed
        // TODO add your handling code here:
        AddressJPanel addressJPanel = new AddressJPanel(person, 1);
        jSplitPane1.setRightComponent(addressJPanel);
    }//GEN-LAST:event_addressJBActionPerformed

    private void medicalJB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicalJB1ActionPerformed
        // TODO add your handling code here:
        MedicalJPanel medicalJPanel = new MedicalJPanel(person, 1);
        jSplitPane1.setRightComponent(medicalJPanel);
    }//GEN-LAST:event_medicalJB1ActionPerformed

    private void ReturnJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnJBActionPerformed
        // TODO add your handling code here:
        this.dispose();
        WelcomeJFrame welcomeJFrame = new WelcomeJFrame();
        welcomeJFrame.setVisible(true);
    }//GEN-LAST:event_ReturnJBActionPerformed

    private void submitAllJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitAllJBActionPerformed
        // TODO add your handling code here:
        if(person.getFirstName() == null){
            JOptionPane.showMessageDialog(null, "Firstname Can Not Be EMPTY!!!");
            return; 
        }
        if(person.getAddress().getAddressLine1() == null){
            JOptionPane.showMessageDialog(null, "Address Line1 Can Not Be EMPTY!!!");
            return; 
        }
        if(person.getCheckingAccount().getBankAccountNumber() == null){
            JOptionPane.showMessageDialog(null, "Checking Bank Account Number Can Not Be EMPTY!!!");
            return; 
        }
        if(person.getMedicalRecord().getMedicalRecordNum()== null){
            JOptionPane.showMessageDialog(null, "Medical Record Number Can Not Be EMPTY!!!");
            return; 
        }
        if(person.getSavingAccount().getBankAccountNumber() == null){
            JOptionPane.showMessageDialog(null, "Saving Bank Account Number Can Not Be EMPTY!!!");
            return; 
        }
        if(person.getDriverLicense().getLicenseNumber() == null){
            JOptionPane.showMessageDialog(null, "Driver License Number Can Not Be EMPTY!!!");
            return; 
        }
        
        JOptionPane.showMessageDialog(null, "Create successfully","warning", JOptionPane.WARNING_MESSAGE);
        this.dispose();
        WelcomeJFrame welcomeJFrame = new WelcomeJFrame(person);
        welcomeJFrame.setVisible(true);
    }//GEN-LAST:event_submitAllJBActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReturnJB;
    private javax.swing.JButton addressJB;
    private javax.swing.JButton checkingAccountJB;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JButton driverLicenseJB;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton medicalJB1;
    private javax.swing.JButton personInfoJB;
    private javax.swing.JButton savingAccountJB;
    private javax.swing.JPanel showJPanel;
    private javax.swing.JButton submitAllJB;
    // End of variables declaration//GEN-END:variables
}
