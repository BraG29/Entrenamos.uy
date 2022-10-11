package gui;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import logica.controlador.IControlador;
import logica.controlador.Fabrica;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class AltaActividadDeportiva extends javax.swing.JFrame {
	

    public LocalDateTime convertirALocalDateTime(Date dateAConvertir){
        return dateAConvertir.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    private File archivoAUsar = null;
    private VentanaFileChooser vntaFileChooser = null;
    
    
    /**
     * Creates new form AltaActividadDeportiva
     */
    public AltaActividadDeportiva() {
        Fabrica fab = new Fabrica();
        IControlador controlador = fab.getInterface();
        
        
        initComponents();
        
        ArrayList<String> arrStr = controlador.getNombreInstituciones();
        ArrayList<String> arrCat = controlador.getAllCategorias();
        
        DefaultListModel listModel;
        
        listModel = new DefaultListModel<>();
        
        for(int i = 0; i < arrCat.size();i++) {
        	listModel.addElement(arrCat.get(i));
        }

        for(int i = 0; i < arrStr.size();i++){
            this.comboInsti.addItem(arrStr.get(i));
        }
        
        this.list.setModel(listModel);
        
            //----------------escondo labels----------------------------
            this.lblNombre.setVisible(false);
            this.lblDesc.setVisible(false);
            this.lblDura.setVisible(false);
            this.lblURL.setVisible(false);
            this.lblCosto.setVisible(false);
            this.lblMMDDAA.setVisible(false);
            lblCategorias.setVisible(false);
            list.setVisible(false);
            panelDeScroleo.setVisible(false);
            //this.lblIMG_Seleccionada
            //----------------escondo los fields---------------------------
            this.fieldDesc.setVisible(false);
            this.fieldDuracion.setVisible(false);
            this.fieldNombre.setVisible(false);
            this.btnImportarIMG.setVisible(false);
            //----------------escondo los spinners---------------------------
            this.spinnerCosto.setVisible(false);
            this.spinnerFecha.setVisible(false);

            
    }
    
    
//     public AltaActividadDeportiva(IControlador controlador) {
//        Fabrica fab = new Fabrica();
//        IControlador controlador = fab.getInterface();
//        
//        initComponents();
//    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        fieldNombre = new javax.swing.JTextField();
        fieldDesc = new javax.swing.JTextField();
        fieldDuracion = new javax.swing.JTextField();
        spinnerCosto = new javax.swing.JSpinner();
        lblCosto = new javax.swing.JLabel();
        spinnerFecha = new javax.swing.JSpinner();
        lblMMDDAA = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        lblDura = new javax.swing.JLabel();
        lblURL = new javax.swing.JLabel();
        comboInsti = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        //lblCategorias = new JLabel();
        lblCategorias = new JLabel("Categorias"); //no le pongas el tipo al principio pajero
        list = new JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel1.setText("Dar de alta Actividad Deportiva");

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
        
        lblIMG_Seleccionada = new JLabel("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(lblIMG_Seleccionada)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(lblIMG_Seleccionada)
        			.addPreferredGap(ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1.setLayout(jPanel1Layout);

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

        lblCosto.setText("Costo $");

        spinnerFecha.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1661233467001L), null, null, java.util.Calendar.DAY_OF_YEAR));

        lblMMDDAA.setText("MM/DD/AA");

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setText("<---------");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        lblNombre.setText("Nombre");

        lblDesc.setText("Descripción");

        lblDura.setText("Duración");

        lblURL.setText("IMG");

        comboInsti.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        comboInsti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboInstiActionPerformed(evt);
            }
        });

        jLabel2.setText("Institución");
        
        btnImportarIMG = new JButton("Importar IMG");
        btnImportarIMG.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent arg0) {//----------------------------cuando toco el boton de importar imagen-----------------------------------------
        		
        			try {
            			vntaFileChooser = new VentanaFileChooser();
                		//vntFileChooser.setVisible(true);
                		
            			archivoAUsar = vntaFileChooser.getArchivo();
            			lblIMG_Seleccionada.setText("");
            			Image imgMuestra = ImageIO.read(archivoAUsar).getScaledInstance(100, 100, 100);
            			lblIMG_Seleccionada.setIcon(new ImageIcon(imgMuestra));

            		}catch(Exception e) {
            			System.out.println(e);
            			//vntaFileChooser.setVisible(true);
            			lblIMG_Seleccionada.setText("");
            		}
        		
        		
        		
        	}
        });
        
        panelDeScroleo = new JScrollPane();
        panelDeScroleo.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addContainerGap()
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jLabel1)
        							.addGroup(layout.createSequentialGroup()
        								.addGroup(layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(fieldDesc, Alignment.TRAILING, 171, 171, Short.MAX_VALUE)
        									.addComponent(fieldDuracion, Alignment.TRAILING, 171, 171, Short.MAX_VALUE)
        									.addComponent(fieldNombre, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        									.addComponent(comboInsti, Alignment.TRAILING, 0, 171, Short.MAX_VALUE)
        									.addComponent(spinnerFecha, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        									.addComponent(spinnerCosto, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addGroup(layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(lblDura)
        									.addComponent(lblNombre)
        									.addComponent(lblMMDDAA)
        									.addComponent(lblCosto)
        									.addComponent(lblDesc)
        									.addComponent(jLabel2))))
        						.addGap(29))
        					.addGroup(layout.createSequentialGroup()
        						.addGap(37)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addGroup(layout.createSequentialGroup()
        								.addGap(161)
        								.addComponent(lblURL))
        							.addComponent(btnImportarIMG))
        						.addPreferredGap(ComponentPlacement.RELATED))
        					.addGroup(layout.createSequentialGroup()
        						.addContainerGap()
        						.addComponent(panelDeScroleo, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(lblCategorias, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        						.addGap(8)))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton2)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(comboInsti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(12)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(fieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNombre))
        			.addGap(12)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(fieldDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDesc))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(fieldDuracion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDura))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(spinnerFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblMMDDAA))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCosto)
        				.addComponent(spinnerCosto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnImportarIMG)
        				.addComponent(lblURL))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(panelDeScroleo, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        					.addGap(30)
        					.addComponent(jButton2))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(42)
        					.addComponent(lblCategorias)
        					.addContainerGap())))
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        
        
        list.setModel(new AbstractListModel() {
        	String[] values = new String[] {};
        	public int getSize() {
        		return values.length;
        	}
        	public Object getElementAt(int index) {
        		return values[index];
        	}
        });
        panelDeScroleo.setViewportView(list);
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        String nombreInsti = this.comboInsti.getSelectedItem().toString();
        String desc = fieldDesc.getText();
        
        try{//se intenta parsear el float
            float dura = Float.parseFloat(fieldDuracion.getText());             
            float costo = Float.parseFloat(spinnerCosto.getValue().toString());
            LocalDateTime fechaAlta = convertirALocalDateTime(((Date)spinnerFecha.getValue()));
            ArrayList<String> catSeleccionadas = new ArrayList<String>();
            catSeleccionadas.addAll(this.list.getSelectedValuesList());

            Fabrica fab = new Fabrica();
            IControlador controlador =  fab.getInterface();
            
            try{//se intenta persistir los datos
            	
                controlador.altaActividadDepo(nombreActividad,nombreInsti,desc,dura,costo,fechaAlta,catSeleccionadas);

                if(this.archivoAUsar != null) {
                	controlador.guardarImagen(this.archivoAUsar,this.fieldNombre.getText(),"imgActis");
                }
                
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
        
        VentanaMensaje ventanaSatisfactoria = new VentanaMensaje("Actividad Deportiva","Se dio de alta la actividad satisfactoriamente",java.awt.Color.green.darker());
        ventanaSatisfactoria.setVisible(true);
        
        
         
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboInstiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboInstiActionPerformed
        // TODO add your handling code here:
        if(this.comboInsti.getSelectedIndex() != 0){
            //----------------muestro labels----------------------------
            this.lblNombre.setVisible(true);
            this.lblDesc.setVisible(true);
            this.lblDura.setVisible(true);
            this.lblURL.setVisible(true);
            this.lblCosto.setVisible(true);
            this.lblMMDDAA.setVisible(true);
            this.lblIMG_Seleccionada.setVisible(true);
            lblCategorias.setVisible(true);
            //----------------muestro los fields---------------------------
            this.fieldDesc.setVisible(true);
            this.fieldDuracion.setVisible(true);
            this.fieldNombre.setVisible(true);
            this.btnImportarIMG.setVisible(true);
            
            //this.fileChooser.setVisible(true);
            //----------------muestro los spinners-----------------------
            this.spinnerCosto.setVisible(true);
            this.spinnerFecha.setVisible(true);
            //----------------muestro LA LISTA----------------------------
            this.panelDeScroleo.setVisible(true);
            this.list.setVisible(true);

        }else{
            //----------------escondo labels----------------------------
            this.lblNombre.setVisible(false);
            this.lblDesc.setVisible(false);
            this.lblDura.setVisible(false);
            this.lblURL.setVisible(false);
            this.lblCosto.setVisible(false);
            this.lblMMDDAA.setVisible(false);
            this.lblIMG_Seleccionada.setVisible(false);
            this.lblCategorias.setVisible(false);
            //----------------escondo los fields---------------------------
            this.fieldDesc.setVisible(false);
            this.fieldDuracion.setVisible(false);
            this.fieldNombre.setVisible(false);
            this.btnImportarIMG.setVisible(false);
            //----------------escondo los spinners---------------------------
            this.spinnerCosto.setVisible(false);
            this.spinnerFecha.setVisible(false);
            
        }
    }//GEN-LAST:event_comboInstiActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AltaActividadDeportiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AltaActividadDeportiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AltaActividadDeportiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AltaActividadDeportiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AltaActividadDeportiva(em).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboInsti;
    private javax.swing.JTextField fieldDesc;
    private javax.swing.JTextField fieldDuracion;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblDura;
    private javax.swing.JLabel lblMMDDAA;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblURL;
    private javax.swing.JSpinner spinnerCosto;
    private javax.swing.JSpinner spinnerFecha;
    private JButton btnImportarIMG;
    private VentanaFileChooser vntFileChooser;
    private JLabel lblIMG_Seleccionada;
    private JList list;
    private javax.swing.JLabel lblCategorias;
    private JScrollPane panelDeScroleo;
}
