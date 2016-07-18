
import java.awt.Color;

import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabConnectionListener;
import matlabcontrol.MatlabInvocationException;
//import matlabcontrol.RemoteMatlabProxy;
//import matlabcontrol.RemoteMatlabProxyFactory;
import matlabcontrol.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jamie
 */
public class Matlab extends javax.swing.JFrame {

    /**
     * Creates new form CalibrationGUI
     */
    public Matlab() {
        initComponents();
        //getContentPane().setBackground(Color.darkGray);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(385, 270));
        setMinimumSize(new java.awt.Dimension(385, 270));
        setPreferredSize(new java.awt.Dimension(385, 270));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Please Stay Stationary for the Program to Calibrate");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 6, 329, -1));

        jButton1.setText("Start ");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 272, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void startMatlab()throws MatlabConnectionException, MatlabInvocationException, Exception {                                         
        // TODO add your handling code here:
        this.setVisible(false);
        Matlab frame = new Matlab ();
        frame.setVisible(true);
        MatlabProxyFactory factory = new MatlabProxyFactory();
        MatlabProxy proxy = factory.getProxy();
        System.out.println(proxy.isConnected());
        try{
            Object o = true;
            proxy.eval("addpath('C:\\Users\\Jason\\Desktop\\HTN 2015\\HackTheNorth\\Matlab')");
            String matlabcommand = "sleepdetection('" + IntroGUI.email +"')";
            proxy.eval(matlabcommand);
        }catch (MatlabInvocationException e){
            e.printStackTrace();
        }
        
    } 
    
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
            java.util.logging.Logger.getLogger(Matlab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Matlab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Matlab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Matlab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Matlab().setVisible(true);
                 
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
