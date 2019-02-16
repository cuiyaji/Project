/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Airliners;

import Business.Airliners;
import Business.TravelAgency;
import UserInterface.*;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Richard
 */
public class ManageAirlinersJPanel extends javax.swing.JPanel {

    private JPanel airLinersContainJPanel;
    private TravelAgency travelAgency;

    public ManageAirlinersJPanel(JPanel airLinersContainJPanel, TravelAgency travelAgency) {
       initComponents();
       this.airLinersContainJPanel = airLinersContainJPanel;
       this.travelAgency = travelAgency;
       refreshTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDirectory = new javax.swing.JTable();
        lblManage = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        removejButton1 = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        btnView1 = new javax.swing.JButton();

        tblDirectory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airliners ", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDirectory);

        lblManage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblManage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManage.setText("Manage Airliners");

        btnView.setText("View Airliner >>");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnShow.setText("Show All Airliner");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        btnAdd.setText("New Airliner >>");
        btnAdd.setToolTipText("");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        removejButton1.setText("Remove");
        removejButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removejButton1ActionPerformed(evt);
            }
        });

        BackBtn.setText("<< Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        btnView1.setText("View Flight >>");
        btnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblManage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(removejButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnView1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(183, 183, 183))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblManage, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removejButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnView1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 147, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        ViewAirlinersJPanel as = new ViewAirlinersJPanel(airLinersContainJPanel, travelAgency);
        airLinersContainJPanel.add("ViewAirlinersJPanel", as);
        CardLayout layout = (CardLayout)airLinersContainJPanel.getLayout();
        layout.next(airLinersContainJPanel);
    }//GEN-LAST:event_btnViewActionPerformed

    public void refreshTable() {
        int rowCount = tblDirectory.getRowCount();
        DefaultTableModel model = (DefaultTableModel)tblDirectory.getModel();
        for(int i = rowCount - 1; i >=0; i--) {
            model.removeRow(i);
        }
        
        for(Airliners s : travelAgency.airlinerDirectory.getAirlinerList()) {
            Object row[] = new Object[model.getColumnCount()];
            row[0]=s;
            row[1]=s.getAirlinerId();
            model.addRow(row);
        }
    }
    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel)tblDirectory.getModel();
        dtm.setRowCount(0);
        
        for(Airliners a : travelAgency.airlinerDirectory.getAirlinerList()){
            Object[] row = new Object[dtm.getColumnCount()];
            row[0]=a;
            row[1]=a.getAirlinerId();
            
            dtm.addRow(row);
        }
    }
    
    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
        populateTable();

    }//GEN-LAST:event_btnShowActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        AddAirlinersJPanel as = new AddAirlinersJPanel(airLinersContainJPanel, travelAgency);
        airLinersContainJPanel.add(" AddAirlinersJPanel", as);
        CardLayout layout = (CardLayout)airLinersContainJPanel.getLayout();
        layout.next(airLinersContainJPanel);
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void removejButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removejButton1ActionPerformed
        // TODO add your handling code here:
        int row = tblDirectory.getSelectedRow();
        
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Airliners s = (Airliners)tblDirectory.getValueAt(row, 0);
        
        travelAgency.airlinerDirectory.deleteAirliners(s);
        refreshTable();
    }//GEN-LAST:event_removejButton1ActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        airLinersContainJPanel.remove(this);
        CardLayout layout = (CardLayout)airLinersContainJPanel.getLayout();
        layout.previous(airLinersContainJPanel);
    }//GEN-LAST:event_BackBtnActionPerformed

    private void btnView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView1ActionPerformed
        ViewFlightJPanel as = new ViewFlightJPanel(airLinersContainJPanel, travelAgency);
        airLinersContainJPanel.add("ViewFlightJPanel", as);
        CardLayout layout = (CardLayout)airLinersContainJPanel.getLayout();
        layout.next(airLinersContainJPanel);
    }//GEN-LAST:event_btnView1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnView1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblManage;
    private javax.swing.JButton removejButton1;
    private javax.swing.JTable tblDirectory;
    // End of variables declaration//GEN-END:variables

    
}
