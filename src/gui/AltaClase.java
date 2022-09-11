package gui;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import logica.controlador.IControlador;
import logica.controlador.Fabrica;
import java.util.ArrayList;


public class AltaClase extends javax.swing.JFrame {

    
     public LocalDateTime convertirALocalDateTime(Date dateAConvertir){
        return dateAConvertir.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    
    /**
     * Creates new form AltaClase
     */
    public AltaClase() {
        initComponents();
        
        this.labelActiDepo.setVisible(false);
        this.labelFechaIni.setVisible(false);
        this.labelMMDDAA1.setVisible(false);
        this.labelProfe.setVisible(false);

        this.labelMax.setVisible(false);
        this.labelMin.setVisible(false);
        this.labelSocios.setVisible(false);
            

        this.spinnerFechaIni.setVisible(false);
        this.spinnerMax.setVisible(false);
        this.spinnerMin.setVisible(false);
           
        this.comboActiDepo.setVisible(false);
        this.comboProfe.setVisible(false);
        this.textURL.setVisible(false);
        this.botonAceptar.setVisible(true);
        
        Fabrica fab = new Fabrica();
        IControlador controlador =  fab.getInterface();
        
        ArrayList<String> arrList = controlador.getNombreInstituciones();//consigo los nombres en ArrayList<String> de las instituciones que hay

        for (int i = 0; i < arrList.size(); i++){//itero para darles el valor 
            this.comboInsti.addItem(arrList.get(i)); 
        }

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
        jButton2 = new javax.swing.JButton();
        comboInsti = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        spinnerFechaIni = new javax.swing.JSpinner();
        labelSocios = new javax.swing.JLabel();
        spinnerMin = new javax.swing.JSpinner();
        spinnerMax = new javax.swing.JSpinner();
        labelMin = new javax.swing.JLabel();
        labelMax = new javax.swing.JLabel();
        textURL = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        botonAceptar = new javax.swing.JButton();
        labelMMDDAA1 = new javax.swing.JLabel();
        labelFechaIni = new javax.swing.JLabel();
        comboActiDepo = new javax.swing.JComboBox<>();
        labelActiDepo = new javax.swing.JLabel();
        comboProfe = new javax.swing.JComboBox<>();
        labelProfe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel1.setText("Alta de dictado de Clase");

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setText("<---------");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        comboInsti.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        comboInsti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboInstiMouseClicked(evt);
            }
        });
        comboInsti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboInstiActionPerformed(evt);
            }
        });

        jLabel3.setText("Institución");

        spinnerFechaIni.setModel(new javax.swing.SpinnerDateModel());

        labelSocios.setText("Socios:");

        spinnerMin.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        spinnerMax.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        labelMin.setText("min");

        labelMax.setText("max");

        textURL.setText("Escriba la URL asociada");
        textURL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textURLMouseClicked(evt);
            }
        });
        textURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textURLActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        botonAceptar.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        botonAceptar.setText("Aceptar");
        botonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAceptarMouseClicked(evt);
            }
        });
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonAceptar))
        );

        labelMMDDAA1.setText("MM/DD/AA");

        labelFechaIni.setText("fecha inicio");

        comboActiDepo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        labelActiDepo.setText("Actividad deportiva");

        comboProfe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        labelProfe.setText("Prof. que la dicta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(comboInsti, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(comboProfe, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelProfe)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textURL)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(spinnerFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMMDDAA1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelFechaIni))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelSocios)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinnerMin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(spinnerMax, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMax)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboActiDepo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelActiDepo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboInsti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboActiDepo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelActiDepo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMMDDAA1)
                    .addComponent(labelFechaIni))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboProfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelProfe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSocios)
                    .addComponent(spinnerMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMin)
                    .addComponent(labelMax))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButton2))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void textURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textURLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textURLActionPerformed

    private void botonAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAceptarMouseClicked

    }//GEN-LAST:event_botonAceptarMouseClicked

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String nombreInsti = comboInsti.getSelectedItem().toString();
        //String nombreClase = textNombreClase.getText();
        LocalDateTime fechaInicio = convertirALocalDateTime(((Date)this.spinnerFechaIni.getValue()));
        //String nombreProfe = textNombreProfe.getText();
        int sociosMin = ((Integer)spinnerMin.getValue());
        int sociosMax = ((Integer)spinnerMax.getValue());
        String URL = textURL.getText();
        LocalDate fechaAlta = LocalDate.now();
        
        if(sociosMin > sociosMax){//control de valores Socios
            VentanaMensaje ventanaError = new VentanaMensaje("ERROR!", "Socios min no puede ser mayor a Socios max", java.awt.Color.RED);
            ventanaError.setVisible(true);
            return;
            
        }else{
            if(comboActiDepo.getSelectedIndex() == 0 || comboProfe.getSelectedIndex() == 0 || URL.equals("") || comboInsti.getSelectedIndex() == 0){
                VentanaMensaje ventanaError = new VentanaMensaje("ERROR!", "Hay campos vacios sin rellenar", java.awt.Color.RED);
                ventanaError.setVisible(true);
                return;
            }else{
                
                //llamo a la función de verda
            }
        }
        
        //LocalDateTime fechaInicio = convertirALocalDateTime(((Date)this.spinnerFechaIni.getValue()));
        
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void comboInstiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboInstiActionPerformed
        if(this.comboInsti.getSelectedIndex() != 0){
            this.labelActiDepo.setVisible(true);
            this.labelFechaIni.setVisible(true);
            this.labelMMDDAA1.setVisible(true);
            this.labelProfe.setVisible(true);
            this.labelMax.setVisible(true);
            this.labelMin.setVisible(true);
            this.labelSocios.setVisible(true);
            
            //this.spinnerFechaFin.setVisible(true);
            this.spinnerFechaIni.setVisible(true);
            this.spinnerMax.setVisible(true);
            this.spinnerMin.setVisible(true);
            
            this.comboActiDepo.setVisible(true);
            this.comboProfe.setVisible(true);
            this.textURL.setVisible(true);
            //controlador.get
            //LLAMADO DE ALGOOOOOO
            
        }else{
            this.labelActiDepo.setVisible(false);
            this.labelFechaIni.setVisible(false);
            this.labelMMDDAA1.setVisible(false);
            this.labelProfe.setVisible(false);
            this.labelMax.setVisible(false);
            this.labelMin.setVisible(false);
            this.labelSocios.setVisible(false);
            
            //this.spinnerFechaFin.setVisible(false);
            this.spinnerFechaIni.setVisible(false);
            this.spinnerMax.setVisible(false);
            this.spinnerMin.setVisible(false);
            
            this.comboActiDepo.setVisible(false);
            this.comboProfe.setVisible(false);
            this.textURL.setVisible(false);
        }
    }//GEN-LAST:event_comboInstiActionPerformed

    private void textURLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textURLMouseClicked
        if(this.textURL.getText().equals("Escriba la URL asociada")){
            this.textURL.setText("");
        }
    }//GEN-LAST:event_textURLMouseClicked

    private void comboInstiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboInstiMouseClicked
    }//GEN-LAST:event_comboInstiMouseClicked

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
            java.util.logging.Logger.getLogger(AltaClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaClase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JComboBox<String> comboActiDepo;
    private javax.swing.JComboBox<String> comboInsti;
    private javax.swing.JComboBox<String> comboProfe;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelActiDepo;
    private javax.swing.JLabel labelFechaIni;
    private javax.swing.JLabel labelMMDDAA1;
    private javax.swing.JLabel labelMax;
    private javax.swing.JLabel labelMin;
    private javax.swing.JLabel labelProfe;
    private javax.swing.JLabel labelSocios;
    private javax.swing.JSpinner spinnerFechaIni;
    private javax.swing.JSpinner spinnerMax;
    private javax.swing.JSpinner spinnerMin;
    private javax.swing.JTextField textURL;
    // End of variables declaration//GEN-END:variables
}
