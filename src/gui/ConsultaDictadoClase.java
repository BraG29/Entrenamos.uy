package gui;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class ConsultaDictadoClase extends javax.swing.JFrame {
    public ConsultaDictadoClase() {
        initComponents();
        this.labelClaseURL.setVisible(false);
        this.labelCantMax.setVisible(false);
        this.labelCantMin.setVisible(false);
        this.labelHoraIni.setVisible(false);
        this.labelFecha.setVisible(false);
        this.labelClases.setVisible(false);
        this.labelComboActi.setVisible(false);
        this.comboListarClases.setVisible(false);
        this.comboActi.setVisible(false);
        
        String[] opcionesInstitutos = new String[] {"-","Instituto1","Instituto2"}; 
        this.comboInsti.setModel(new DefaultComboBoxModel(opcionesInstitutos));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabelTitulo = new javax.swing.JLabel();
        labelClases = new javax.swing.JLabel();
        labelClaseURL = new javax.swing.JLabel();
        labelCantMax = new javax.swing.JLabel();
        labelCantMin = new javax.swing.JLabel();
        labelHoraIni = new javax.swing.JLabel();
        labelComboActi = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        jLabelComboInst = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        comboInsti = new javax.swing.JComboBox<>();
        comboListarClases = new javax.swing.JComboBox<>();
        comboActi = new javax.swing.JComboBox<>();
        panelAzul = new javax.swing.JPanel();
        botonConsulta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Noto Sans", 0, 18));
        jLabelTitulo.setText("Consulta Dictado de Clases");

        panelAzul.setBackground(new java.awt.Color(0, 153, 204));

        botonConsulta.setFont(new java.awt.Font("Noto Sans", 1, 18));
        botonConsulta.setText("Consultar");
        botonConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAzulLayout = new javax.swing.GroupLayout(panelAzul);
        panelAzul.setLayout(panelAzulLayout);
        panelAzulLayout.setHorizontalGroup(
            panelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonConsulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelAzulLayout.setVerticalGroup(
            panelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAzulLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButtonCancelar.setBackground(new java.awt.Color(255, 51, 51));
        jButtonCancelar.setText("Atras");
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboInsti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboInstiActionPerformed(evt);
            }
        });

        jLabelComboInst.setText("Institución");

        comboListarClases.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "clase1", "clase2" }));
        comboListarClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboListaActionPerformed(evt);
            }
        });

        labelClases.setText("Clases");

        labelClaseURL.setText("jLabelClURL");
        labelClaseURL.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                labelNombreActComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                labelNombreActComponentShown(evt);
            }
        });

        labelCantMax.setText("jLabelClCantMax");
        labelCantMax.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                labelDescComponentShown(evt);
            }
        });

        labelCantMin.setText("jLabelClCantMin");
        labelCantMin.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                labelDuracionComponentShown(evt);
            }
        });

        labelHoraIni.setText("jLabelClHoraIni");
        labelHoraIni.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                labelCostoComponentShown(evt);
            }
        });

        labelFecha.setText("jLabelClFecha");
        labelFecha.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                labelFechaComponentShown(evt);
            }
        });

        comboActi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboActi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActiActionPerformed(evt);
            }
        });

        labelComboActi.setText("Actividad Deportiva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboListarClases, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelClases))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labelFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addComponent(labelHoraIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCantMin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCantMax, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelClaseURL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboActi, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboInsti, javax.swing.GroupLayout.Alignment.LEADING, 0, 158, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelComboInst)
                                    .addComponent(labelComboActi))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboInsti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelComboInst))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboActi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelComboActi))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboListarClases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelClases))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelClaseURL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCantMax)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCantMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelHoraIni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButtonCancelar))
            .addComponent(panelAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
        pack();
    }

    private void botonConsultaActionPerformed(java.awt.event.ActionEvent evt) {
             
        if(this.comboListarClases.getSelectedIndex() != 0){
            //se abren los casos de uso del Lucas y EUwUgenio
        }else{
            VentanaMensaje errorVentana = new VentanaMensaje("ERROR!","Porfavor seleccione una clase",java.awt.Color.RED);
            errorVentana.setVisible(true);
            return;
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
    }

    private void comboInstiActionPerformed(java.awt.event.ActionEvent evt) {
        
        if(comboInsti.getSelectedIndex() != 0){
            //acá iria la función que consulta a la BdD por las Actividades Deportivas
            this.comboActi.setVisible(true);
            this.labelComboActi.setVisible(true);            
        }else{
            this.comboActi.setVisible(false);
            this.labelComboActi.setVisible(false);
        }
        
    }
    private void comboListaActionPerformed(java.awt.event.ActionEvent evt) {    	
    }

    private void labelNombreActComponentHidden(java.awt.event.ComponentEvent evt) {
    }

    private void labelNombreActComponentShown(java.awt.event.ComponentEvent evt) {
    	this.labelClaseURL.setText("URL: ");
    }

    private void labelDescComponentShown(java.awt.event.ComponentEvent evt) {
        this.labelCantMax.setText("Cantidad Maxima: ");
    }

    private void labelDuracionComponentShown(java.awt.event.ComponentEvent evt) {
        this.labelCantMin.setText("Cantidad Minima: ");
    }

    private void labelCostoComponentShown(java.awt.event.ComponentEvent evt) {
        this.labelHoraIni.setText("Hora Inicio: ");
    }

    private void labelFechaComponentShown(java.awt.event.ComponentEvent evt) {
        this.labelFecha.setText("Fecha: ");
    }

    private void comboActiActionPerformed(java.awt.event.ActionEvent evt) {

        if(comboInsti.getSelectedIndex() != 0){
            //acá iria la función que consulta a la BdD por los datos de la Actividad Deportiva
            
            //combos
            this.comboListarClases.setVisible(true);
            
            //labels
            this.labelClases.setVisible(true);
            this.labelClaseURL.setVisible(true);
            this.labelCantMax.setVisible(true);
            this.labelCantMin.setVisible(true);
            this.labelHoraIni.setVisible(true);
            this.labelFecha.setVisible(true);
            
        }else{
            //combos
            this.comboListarClases.setVisible(false);
            
            //labels
            this.labelClases.setVisible(false);
            this.labelClaseURL.setVisible(false);
            this.labelCantMax.setVisible(false);
            this.labelCantMin.setVisible(false);
            this.labelHoraIni.setVisible(false);
            this.labelFecha.setVisible(false);
        }        
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaDictadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaDictadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaDictadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaDictadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaDictadoClase().setVisible(true);
            }
        });
    }

    private javax.swing.JButton botonConsulta;
    private javax.swing.JComboBox<String> comboActi;
    private javax.swing.JComboBox<String> comboInsti;
    private javax.swing.JComboBox<String> comboListarClases;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelComboInst;
    private javax.swing.JLabel labelComboActi;
    private javax.swing.JLabel labelClases;
    private javax.swing.JLabel labelHoraIni;
    private javax.swing.JLabel labelCantMax;
    private javax.swing.JLabel labelCantMin;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelClaseURL;
    private javax.swing.JPanel panelAzul;
}
