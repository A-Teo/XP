/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sisxp;

import javax.swing.JFrame;
import vistas.PlanillaDeGastos;
import controladores.*;

/**
 *
 * @author WVasquez
 */
public class MainPage extends JFrame {

    /**
     * Creates new form MainPage
     */
    public MainPage() {
        
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        RegistrarButton = new javax.swing.JButton();
        DocsButton = new javax.swing.JButton();
        VerButton = new javax.swing.JButton();
        GastosButton = new javax.swing.JButton();
        ConverterButton = new javax.swing.JButton();
        regExpositorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setAlignmentX(0.0F);
        Panel.setLayout(new javax.swing.BoxLayout(Panel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        RegistrarButton.setText("Registrar Charla");
        RegistrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarButtonActionPerformed(evt);
            }
        });

        DocsButton.setText("Docs");
        DocsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocsButtonActionPerformed(evt);
            }
        });

        VerButton.setText("Ver Charlas");

        GastosButton.setText("Gestor de Gastos");
        GastosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GastosButtonActionPerformed(evt);
            }
        });

        ConverterButton.setText("Convertidor");
        ConverterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConverterButtonActionPerformed(evt);
            }
        });

        regExpositorButton.setText("Registrar Expositor");
        regExpositorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regExpositorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(regExpositorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConverterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GastosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DocsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegistrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(ConverterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RegistrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DocsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GastosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(regExpositorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        Panel.add(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarButtonActionPerformed
        // TODO add your handling code here:
        RegistrarCharla rc = new RegistrarCharla();
        this.dispose();
        rc.setVisible(true);
    }//GEN-LAST:event_RegistrarButtonActionPerformed

    private void DocsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocsButtonActionPerformed
        // TODO add your handling code here:
        Docs view = new Docs();
        this.dispose();
        view.setVisible(true);
    }//GEN-LAST:event_DocsButtonActionPerformed

    private void GastosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GastosButtonActionPerformed
        // TODO add your handling code here:
        PlanillaDeGastos pl = new PlanillaDeGastos();
        this.dispose();
        pl.setVisible(true);
    }//GEN-LAST:event_GastosButtonActionPerformed

    private void ConverterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConverterButtonActionPerformed
        // TODO add your handling code here:
        convertidor.controladorCambio con = new convertidor.controladorCambio();
        
                
                
    }//GEN-LAST:event_ConverterButtonActionPerformed

    private void regExpositorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regExpositorButtonActionPerformed
        // TODO add your handling code here:
        
        //Kelly Aqui----------------------------********************************---------------**********
    }//GEN-LAST:event_regExpositorButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConverterButton;
    private javax.swing.JButton DocsButton;
    private javax.swing.JButton GastosButton;
    private javax.swing.JPanel Panel;
    private javax.swing.JButton RegistrarButton;
    private javax.swing.JButton VerButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton regExpositorButton;
    // End of variables declaration//GEN-END:variables
}
