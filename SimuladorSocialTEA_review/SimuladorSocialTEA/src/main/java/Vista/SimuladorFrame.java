/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.SimuladorControlador;
import Modelo.OpcionRespuesta;
import Modelo.ResultadoEvaluacion;
import Modelo.SituacionSocial;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class SimuladorFrame extends javax.swing.JFrame {

    private SimuladorControlador controlador;
    private ArrayList<SituacionSocial> situacionesActuales;
    private ArrayList<OpcionRespuesta> opcionesActuales;

    public SimuladorFrame() {
        setLocationRelativeTo(null);
        initComponents();
    }

    public SimuladorFrame(SimuladorControlador controlador) {
        initComponents();
        this.controlador = controlador;
        this.situacionesActuales = new ArrayList<>();
        this.opcionesActuales = new ArrayList<>();
        setLocationRelativeTo(null);
        cargarCategorias();
    }

    private void cargarCategorias() {
        cmbCategoria.removeAllItems();

        if (controlador != null) {
            for (String categoria : controlador.obtenerCategorias()) {
                cmbCategoria.addItem(categoria);
            }
        }

        if (cmbCategoria.getItemCount() > 0) {
            cmbCategoria.setSelectedIndex(0);
            cargarSituaciones();
        }
    }

    private void cargarSituaciones() {
        cmbSituacion.removeAllItems();
        txtDescripcion.setText("");
        cmbOpciones.removeAllItems();

        if (controlador == null || cmbCategoria.getSelectedItem() == null) {
            return;
        }

        String categoria = cmbCategoria.getSelectedItem().toString();
        situacionesActuales = controlador.obtenerSituacionesPorCategoria(categoria);

        for (SituacionSocial situacion : situacionesActuales) {
            cmbSituacion.addItem(situacion.getTitulo());
        }

        if (cmbSituacion.getItemCount() > 0) {
            cmbSituacion.setSelectedIndex(0);
            cargarDatosSituacion();
        }
    }

    private void cargarDatosSituacion() {
        cmbOpciones.removeAllItems();
        opcionesActuales = new ArrayList<>();
        
        SituacionSocial situacion = obtenerSituacionSeleccionada();
        
        
        if (situacion == null) {
            txtDescripcion.setText("");
            return;
        }

        txtDescripcion.setText(situacion.getDescripcion());

        for (OpcionRespuesta opcion : situacion.getOpciones()) {
            opcionesActuales.add(opcion);
            cmbOpciones.addItem(opcion.getTexto());
        }
    }

    private SituacionSocial obtenerSituacionSeleccionada() {
    int indice = cmbSituacion.getSelectedIndex();

    if (indice >= 0 && indice < situacionesActuales.size()) {
        return situacionesActuales.get(indice);
    }

    return null;
}

    private OpcionRespuesta obtenerOpcionSeleccionada() {
    int indice = cmbOpciones.getSelectedIndex();

    if (indice >= 0 && indice < opcionesActuales.size()) {
        return opcionesActuales.get(indice);
    }

    return null;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblSituacion = new javax.swing.JLabel();
        lblOpciones = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbSituacion = new javax.swing.JComboBox<>();
        cmbOpciones = new javax.swing.JComboBox<>();
        btnResponder = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        lblTitulo.setText("Simulador de Situaciones Sociales");

        lblCategoria.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        lblCategoria.setText("Categoría:");

        lblSituacion.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        lblSituacion.setText("Situación:");

        lblOpciones.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        lblOpciones.setText("Respuesta:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        cmbSituacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSituacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSituacionActionPerformed(evt);
            }
        });

        cmbOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOpcionesActionPerformed(evt);
            }
        });

        btnResponder.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btnResponder.setText("Responder");
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDescripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVolver)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitulo)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCategoria)
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblOpciones)
                                .addComponent(cmbOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSituacion)))
                        .addComponent(btnResponder)))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSituacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(lblOpciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnResponder)
                .addGap(4, 4, 4)
                .addComponent(btnVolver)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        cargarSituaciones();
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void cmbSituacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSituacionActionPerformed
        cargarDatosSituacion();
    }//GEN-LAST:event_cmbSituacionActionPerformed

    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderActionPerformed
        SituacionSocial situacion = obtenerSituacionSeleccionada();
        OpcionRespuesta opcion = obtenerOpcionSeleccionada();

        if (situacion == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una situación.");
            return;
        }

        if (opcion == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una respuesta.");
            return;
        }

        ResultadoEvaluacion resultado = controlador.responder(situacion, opcion);

        JOptionPane.showMessageDialog(
                this,
                resultado.getMensaje(),
                resultado.isCorrecta() ? "Respuesta adecuada" : "Retroalimentación",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_btnResponderActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuPrincipalFrame menu = new MenuPrincipalFrame(controlador);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cmbOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOpcionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOpcionesActionPerformed

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
            java.util.logging.Logger.getLogger(SimuladorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimuladorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimuladorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimuladorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimuladorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResponder;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbOpciones;
    private javax.swing.JComboBox<String> cmbSituacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblOpciones;
    private javax.swing.JLabel lblSituacion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
