/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Business.Person;
import Business.Address;
import javax.swing.JOptionPane;

/**
 *
 * @author Richard
 */
public class AddressJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddressJPanel
     */
    private Person person;
    int type;
    public AddressJPanel(){
        initComponents();
    }
    
    public void inite(){
        stL1JTF.setText("73 CParty Street");
        
        stL2JTF.setText("781");
        
        cityJTF.setText("Boston");
        
        countryJTF.setText("M.A");
        
        zipcodeJTF.setText("02746");
        
        stateJTF.setText("U.S.A");
        type=2;
        
    }
    
    public AddressJPanel(Person person, int type) {
        initComponents();
        this.person = person;
        this.type = type;
        if(type == 2){
            displayPerson(person);
        }
    }
    private void displayPerson(Person person){
        Address address = person.getAddress();
        String streetLine1 = address.getAddressLine1();
        stL1JTF.setText(streetLine1);
        stL1JTF.setEnabled(false);
        
        String streetLine2 = address.getAddressLine2();
        stL2JTF.setText(streetLine2);
        stL2JTF.setEnabled(false);
        
        String city = address.getCity();
        cityJTF.setText(city);
        cityJTF.setEnabled(false);
        
        String country = address.getCountry();
        countryJTF.setText(country);
        countryJTF.setEnabled(false);
        
        String zipcode = address.getZipCode();
        zipcodeJTF.setText(zipcode);
        zipcodeJTF.setEnabled(false);
        
        String state = address.getState();
        stateJTF.setText(state);
        stateJTF.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AdJPanel = new javax.swing.JPanel();
        streetL1JLab = new javax.swing.JLabel();
        streetL2JLab = new javax.swing.JLabel();
        cityJLab = new javax.swing.JLabel();
        stateJLab = new javax.swing.JLabel();
        zipcodeJLab = new javax.swing.JLabel();
        countJLab = new javax.swing.JLabel();
        stL1JTF = new javax.swing.JTextField();
        stL2JTF = new javax.swing.JTextField();
        cityJTF = new javax.swing.JTextField();
        stateJTF = new javax.swing.JTextField();
        zipcodeJTF = new javax.swing.JTextField();
        countryJTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 500));

        AdJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));

        streetL1JLab.setText("Street Line1");

        streetL2JLab.setText("Street Line2");

        cityJLab.setText("City");

        stateJLab.setText("State");

        zipcodeJLab.setText("Zip Code");

        countJLab.setText("Country");

        javax.swing.GroupLayout AdJPanelLayout = new javax.swing.GroupLayout(AdJPanel);
        AdJPanel.setLayout(AdJPanelLayout);
        AdJPanelLayout.setHorizontalGroup(
            AdJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdJPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(AdJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(streetL1JLab)
                    .addComponent(countJLab)
                    .addComponent(zipcodeJLab)
                    .addComponent(stateJLab)
                    .addComponent(cityJLab)
                    .addComponent(streetL2JLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AdJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stL1JTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stL2JTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityJTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateJTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipcodeJTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countryJTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        AdJPanelLayout.setVerticalGroup(
            AdJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdJPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(AdJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AdJPanelLayout.createSequentialGroup()
                        .addGroup(AdJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(streetL1JLab)
                            .addComponent(stL1JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(streetL2JLab))
                    .addComponent(stL2JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityJLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateJLab)
                    .addComponent(stateJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipcodeJLab)
                    .addComponent(zipcodeJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countJLab)
                    .addComponent(countryJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jButton1.setText("SUBMIT&NEXT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(AdJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jButton1)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AdJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(type == 2){
            JOptionPane.showMessageDialog(null,"You Cannot Change Information");
            
        }else{
        Address address = new Address();
        address.setAddressLine1(stL1JTF.getText());
        address.setAddressLine2(stL2JTF.getText());
        address.setCity(cityJTF.getText());
        address.setState(stateJTF.getText());
        address.setZipCode(zipcodeJTF.getText());
        address.setCountry(countryJTF.getText());
        person.setAddress(address);
        

        JOptionPane.showMessageDialog(null, "Create Address Information successfully","warning", JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdJPanel;
    private javax.swing.JLabel cityJLab;
    private javax.swing.JTextField cityJTF;
    private javax.swing.JLabel countJLab;
    private javax.swing.JTextField countryJTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField stL1JTF;
    private javax.swing.JTextField stL2JTF;
    private javax.swing.JLabel stateJLab;
    private javax.swing.JTextField stateJTF;
    private javax.swing.JLabel streetL1JLab;
    private javax.swing.JLabel streetL2JLab;
    private javax.swing.JLabel zipcodeJLab;
    private javax.swing.JTextField zipcodeJTF;
    // End of variables declaration//GEN-END:variables
}
