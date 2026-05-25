/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.SimuladorControlador;
import Util.ExportadorReporte;
import javax.swing.JOptionPane;

public class MenuPrincipalFrame extends javax.swing.JFrame {

    private SimuladorControlador controlador;

    public MenuPrincipalFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public MenuPrincipalFrame(SimuladorControlador controlador) {
        initComponents();
        this.controlador = controlador;
        setLocationRelativeTo(null);
        cargarDatosUsuario();
    }

    private void cargarDatosUsuario() {
        if (controlador != null && controlador.getUsuarioActual() != null) {
            lblUsuario.setText("Usuario: " + controlador.getUsuarioActual().getNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnIniciarSimulacion = new javax.swing.JButton();
        btnVerProgreso = new javax.swing.JButton();
        btnExportarReporte = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        lblTitulo.setText("Menú Principal");

        lblUsuario.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        lblUsuario.setText("Usuario:");

        btnIniciarSimulacion.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btnIniciarSimulacion.setText("Iniciar simulación");
        btnIniciarSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSimulacionActionPerformed(evt);
            }
        });

        btnVerProgreso.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btnVerProgreso.setText("Ver progreso");
        btnVerProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProgresoActionPerformed(evt);
            }
        });

        btnExportarReporte.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btnExportarReporte.setText("Exportar reporte");
        btnExportarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarReporteActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Segoe UI Emoji", 3, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVerProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIniciarSimulacion)
                            .addComponent(btnExportarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lblUsuario)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitulo)
                .addGap(25, 25, 25)
                .addComponent(lblUsuario)
                .addGap(18, 18, 18)
                .addComponent(btnIniciarSimulacion)
                .addGap(18, 18, 18)
                .addComponent(btnVerProgreso)
                .addGap(18, 18, 18)
                .addComponent(btnExportarReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSimulacionActionPerformed
        SimuladorFrame simuladorFrame = new SimuladorFrame(controlador);
        simuladorFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIniciarSimulacionActionPerformed

    private void btnVerProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProgresoActionPerformed
        ProgresoFrame progresoFrame = new ProgresoFrame(controlador);
        progresoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVerProgresoActionPerformed

    private void btnExportarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarReporteActionPerformed
        if (controlador == null || controlador.getProgresoActual() == null) {
            JOptionPane.showMessageDialog(this, "No hay progreso para exportar.");
            return;
        }

        ExportadorReporte exportador = new ExportadorReporte();
        boolean exportado = exportador.exportarProgreso(
                controlador.getProgresoActual(),
                "reporte_" + controlador.getUsuarioActual().getNombre() + ".txt"
        );

        if (exportado) {
            JOptionPane.showMessageDialog(this, "Reporte exportado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo exportar el reporte.");
        }
    }//GEN-LAST:event_btnExportarReporteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Desea salir del simulador?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarReporte;
    private javax.swing.JButton btnIniciarSimulacion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerProgreso;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
