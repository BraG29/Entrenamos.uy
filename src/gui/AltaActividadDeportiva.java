package gui;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import logica.controlador.IControlador;
import logica.controlador.Fabrica;

public class AltaActividadDeportiva extends javax.swing.JFrame {

    public LocalDateTime convertirALocalDateTime(Date dateAConvertir){
        return dateAConvertir.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    
    /**
     * Creates new form AltaActividadDeportiva
     */
    public AltaActividadDeportiva() {
//        Fabrica fab = new Fabrica();
//        IControlador controlador = fab.getInterface();
        
        initComponents();
    }
    
//     public AltaActividadDeportiva(IControlador controlador) {
////        Fabrica fab = new Fabrica();
////        IControlador controlador = fab.getInterface();
//        
//        initComponents();
//    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fieldInstiDepo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        fieldNombre = new javax.swing.JTextField();
        fieldDesc = new javax.swing.JTextField();
        fieldDuracion = new javax.swing.JTextField();
        spinnerCosto = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        spinnerFecha = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel1.setText("Dar de alta Actividad Deportiva");

        fieldInstiDepo.setText("Escriba la institución deportiva");
        fieldInstiDepo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldInstiDepoMouseClicked(evt);
            }
        });
        fieldInstiDepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldInstiDepoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jButton1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        fieldNombre.setText("Escriba el nombre");
        fieldNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldNombreMouseClicked(evt);
            }
        });
        fieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreActionPerformed(evt);
            }
        });

        fieldDesc.setText("Escriba la descripción");
        fieldDesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldDescMouseClicked(evt);
            }
        });
        fieldDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDescActionPerformed(evt);
            }
        });

        fieldDuracion.setText("Escriba la duración");
        fieldDuracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldDuracionMouseClicked(evt);
            }
        });
        fieldDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDuracionActionPerformed(evt);
            }
        });

        spinnerCosto.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel3.setText("Costo $");

        spinnerFecha.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1661233467001L), null, null, java.util.Calendar.DAY_OF_YEAR));

        jLabel4.setText("MM/DD/AA");

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setText("<---------");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spinnerCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fieldDuracion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldDesc, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldInstiDepo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(spinnerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel4))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(fieldInstiDepo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(fieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButton2))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldInstiDepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldInstiDepoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldInstiDepoActionPerformed

    private void fieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNombreActionPerformed

    private void fieldDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDescActionPerformed

    private void fieldDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDuracionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fieldInstiDepoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldInstiDepoMouseClicked
        if(fieldInstiDepo.getText().equals("Escriba la institución deportiva")){
            fieldInstiDepo.setText("");
        }
    }//GEN-LAST:event_fieldInstiDepoMouseClicked

    private void fieldNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldNombreMouseClicked
        if(fieldNombre.getText().equals("Escriba el nombre")){
            fieldNombre.setText("");
        }
    }//GEN-LAST:event_fieldNombreMouseClicked

    private void fieldDescMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldDescMouseClicked
        if(fieldDesc.getText().equals("Escriba la descripción")){
            fieldDesc.setText("");
        }
    }//GEN-LAST:event_fieldDescMouseClicked

    private void fieldDuracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldDuracionMouseClicked
        if(fieldDuracion.getText().equals("Escriba la duración")){
            fieldDuracion.setText("");
        }
    }//GEN-LAST:event_fieldDuracionMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String nombreActividad = fieldNombre.getText();
        String nombreInsti = fieldInstiDepo.getText();
        String desc = fieldDesc.getText();
        
        try{//se intenta parsear el float
            float dura = Float.parseFloat(fieldDuracion.getText());
            
            float costo = Float.parseFloat(spinnerCosto.getValue().toString());
            LocalDateTime fechaAlta = convertirALocalDateTime(((Date)spinnerFecha.getValue()));
        
            Fabrica fab = new Fabrica();
            IControlador controlador =  fab.getInterface();
            
            try{//se intenta persistir los datos
                controlador.altaActividadDepo(nombreActividad,nombreInsti,desc,dura,costo,fechaAlta);
                
            }catch(Exception e){//algo malió sal en la persistición
                VentanaMensaje errorVentana = new VentanaMensaje("ERROR!",e.getMessage(),java.awt.Color.RED);
                errorVentana.setVisible(true);
                return;
            }
            
        }catch(Exception e){//fallo el parseo del float
            VentanaMensaje errorVentana = new VentanaMensaje("ERROR!","caracteres invalidos en campo Duracion",java.awt.Color.RED);
            errorVentana.setVisible(true);
            return;
        }
        
        VentanaMensaje ventanaSatisfactoria = new VentanaMensaje("Actividad Deportiva","Se dio de alta la actividad satisfactoriamente",java.awt.Color.GREEN);
        ventanaSatisfactoria.setVisible(true);
        
        
         
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AltaActividadDeportiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaActividadDeportiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaActividadDeportiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaActividadDeportiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaActividadDeportiva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldDesc;
    private javax.swing.JTextField fieldDuracion;
    private javax.swing.JTextField fieldInstiDepo;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spinnerCosto;
    private javax.swing.JSpinner spinnerFecha;
    // End of variables declaration//GEN-END:variables
}
