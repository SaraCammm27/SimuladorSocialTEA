/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.SimuladorControlador;
import Modelo.Progreso;
public class ProgresoFrame extends javax.swing.JFrame {

   private SimuladorControlador controlador;
   
    public ProgresoFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public ProgresoFrame(SimuladorControlador controlador) {
    initComponents();
    this.controlador = controlador;
    setLocationRelativeTo(null);
    cargarProgreso();
}
    
   private void cargarProgreso() {
    if (controlador == null || controlador.getUsuarioActual() == null || controlador.getProgresoActual() == null) {
        lblUsuario.setText("Usuario: No disponible");
        lblPuntaje.setText("Puntaje: 0");
        lblCompletadas.setText("Situaciones completadas: 0");
        lblNivel.setText("Nivel: Sin nivel");
        txtResumen.setText("No hay progreso disponible.");
        return;
    }

    Progreso progreso = controlador.getProgresoActual();

    lblUsuario.setText("Usuario: " + controlador.getUsuarioActual().getNombre());
    lblPuntaje.setText("Puntaje: " + progreso.getPuntajeAcumulado());
    lblCompletadas.setText("Situaciones completadas: " + progreso.getSituacionesCompletadas());
    lblNivel.setText("Nivel: " + progreso.getNivel());
    txtResumen.setText(progreso.obtenerResumen());
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblPuntaje = new javax.swing.JLabel();
        lblCompletadas = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResumen = new javax.swing.JTextArea();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        lblTitulo.setText("Progreso del Usuario");

        lblUsuario.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        lblUsuario.setText("Usuario:");

        lblPuntaje.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        lblPuntaje.setText("Puntaje:");

        lblCompletadas.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        lblCompletadas.setText("Situaciones completadas:");

        lblNivel.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        lblNivel.setText("Nivel:");

        txtResumen.setEditable(false);
        txtResumen.setColumns(20);
        txtResumen.setLineWrap(true);
        txtResumen.setRows(5);
        txtResumen.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtResumen);

        btnVolver.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVolver)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPuntaje)
                                .addGap(38, 38, 38)
                                .addComponent(lblCompletadas)
                                .addGap(18, 18, 18)
                                .addComponent(lblNivel))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblTitulo)))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(lblPuntaje)
                    .addComponent(lblCompletadas)
                    .addComponent(lblNivel))
                .addGap(67, 67, 67)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    MenuPrincipalFrame menu = new MenuPrincipalFrame(controlador);
    menu.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(ProgresoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgresoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgresoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgresoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgresoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCompletadas;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextArea txtResumen;
    // End of variables declaration//GEN-END:variables
}
