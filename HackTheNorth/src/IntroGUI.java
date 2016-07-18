
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import matlabcontrol.MatlabInvocationException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jamie
 */
public class IntroGUI extends javax.swing.JFrame {
     String carrier; 
     public static String email; 
    /**
     * Creates new form IntroGUI
     */
    public IntroGUI() {
        initComponents();
        getContentPane().setBackground(Color.GRAY);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        helloUser = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        phoneNum = new javax.swing.JLabel();
        carrierList = new javax.swing.JComboBox();
        nextButton1 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));

        jButton1.setVisible(false);
        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Heiti TC", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Next >");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setLocation(new java.awt.Point(700, 250));
        setMaximumSize(new java.awt.Dimension(460, 260));
        setMinimumSize(new java.awt.Dimension(460, 260));
        setPreferredSize(new java.awt.Dimension(460, 260));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        helloUser.setFont(new java.awt.Font("Gidole", 0, 40)); // NOI18N
        helloUser.setForeground(new java.awt.Color(255, 255, 255));
        helloUser.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jason\\Desktop\\WuzzUP3.png")); // NOI18N
        helloUser.setText("WuzzUP");
        getContentPane().add(helloUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 150, 50));

        phoneNumberField.setBackground(new java.awt.Color(216, 216, 216));
        phoneNumberField.setFont(new java.awt.Font("Heiti TC", 0, 13)); // NOI18N
        phoneNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberFieldActionPerformed(evt);
            }
        });
        getContentPane().add(phoneNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 158, 150, 25));

        phoneNum.setFont(new java.awt.Font("Gidole", 0, 20)); // NOI18N
        phoneNum.setForeground(new java.awt.Color(255, 255, 255));
        phoneNum.setText("Enter Your Phone Number & Select Your Carrier");
        phoneNum.setMaximumSize(new java.awt.Dimension(400, 24));
        phoneNum.setMinimumSize(new java.awt.Dimension(400, 24));
        phoneNum.setPreferredSize(new java.awt.Dimension(400, 24));
        getContentPane().add(phoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 390, 30));

        carrierList.setBackground(new java.awt.Color(153, 153, 153));
        carrierList.setFont(new java.awt.Font("Heiti TC", 0, 13)); // NOI18N
        carrierList.setForeground(new java.awt.Color(102, 102, 102));
        carrierList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bell", "Fido", "Koodo", "Rogers", "Telus", "Virgin", "Wind" }));
        carrierList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carrierListActionPerformed(evt);
            }
        });
        getContentPane().add(carrierList, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 158, 90, 25));

        nextButton1.setBackground(new java.awt.Color(51, 51, 51));
        nextButton1.setFont(new java.awt.Font("Gidole", 0, 16)); // NOI18N
        nextButton1.setForeground(new java.awt.Color(255, 255, 255));
        nextButton1.setText("Confirm");
        nextButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 90, 40));
        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberFieldActionPerformed

    private void carrierListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carrierListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carrierListActionPerformed

    private void nextButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButton1ActionPerformed
        // TODO add your handling code here:
        String text = phoneNumberField.getText();
        int numDigit = text.length();
        carrier = (String)carrierList.getSelectedItem();
        email = null;
        
        //if(null != carrier)
        switch (carrier) {
            case "Koodo":
                email = text + "@msg.telus.com";
                break;
            case "Rogers":
                email = text + "@sms.rogers.com";
                break;
            case "Telus":
                email = text + "@msg.telus.com";
                break;
            case "Bell":
                email = text + "@txt.bellmobility.ca";
                break;
            case "Fido":
                email = text + "@sms.fido.ca";
                break;
            case "Virgin":
                email = text + "@vmobile.ca";
                break;
            case "Wind":
                email = text + "@txt.windmobile.ca";
                break;
            default:
                email = "Incorrect";
                break;
        }
        
        if(text.equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null,"Please enter your number");
        }
        else if(numDigit < 10 || numDigit > 10)
        {
            JOptionPane.showMessageDialog(null,"Incorrect Number; please enter again");
        }
        else if (numDigit == 10)
        {
            JOptionPane.showMessageDialog(null, "Your Email is: " + email);
            jButton1.setVisible(true);
            try {
                new Matlab().startMatlab();
            } catch (MatlabInvocationException ex) {
                Logger.getLogger(IntroGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(IntroGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_nextButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Matlab frame = new Matlab ();
        frame.setVisible(true);
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
            java.util.logging.Logger.getLogger(IntroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntroGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox carrierList;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel helloUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton nextButton1;
    private javax.swing.JLabel phoneNum;
    private javax.swing.JTextField phoneNumberField;
    // End of variables declaration//GEN-END:variables

    private void elseIf(boolean equalsIgnoreCase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}