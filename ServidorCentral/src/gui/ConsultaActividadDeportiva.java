package gui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import logica.controlador.Controlador;
import logica.controlador.Fabrica;
import logica.controlador.IControlador;
import logica.datatypes.DtActividadDeportiva;
import logica.datatypes.DtClase;
import logica.datatypes.DtCuponera;
import logica.datatypes.DtInstitucion;

import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Rectangle;
import javax.swing.JList;
import javax.swing.JScrollPane;




public class ConsultaActividadDeportiva extends javax.swing.JFrame {
	
	private ArrayList<String> listaClases = new ArrayList<>();
	private ArrayList<String> listaCuponeras = new ArrayList<>();
	private HashMap<String,DtInstitucion> hashInfo = new HashMap<>();
	
    public ConsultaActividadDeportiva() {
        initComponents();
        
        this.labelNombreAct.setVisible(false);
        this.labelDesc.setVisible(false);
        this.labelDuracion.setVisible(false);
        this.labelCosto.setVisible(false);
        this.labelFechaAlta.setVisible(false);
        this.labelClases.setVisible(false);
        this.labelActi.setVisible(false);
        this.labelFecha.setVisible(false);
        this.lblCat.setVisible(false);
        
        this.comboLista.setVisible(false);
        this.comboActi.setVisible(false);
        this.scrollPane.setVisible(false);
        this.list.setVisible(false);
        
        //String[] holiwi = new String[] {"-","holiwi","owo"};
        
        Fabrica fab = new Fabrica();
        IControlador controlador = fab.getInterface();
        
        this.hashInfo = controlador.getHashDtInstis();
        
        ArrayList<String> arrStr = new ArrayList<String>();
        arrStr.addAll(this.hashInfo.keySet());
        
        
        for(int i = 0;i < arrStr.size();i++) {
        	this.comboInsti.addItem(arrStr.get(i));
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
        panelAzul = new javax.swing.JPanel();
        botonConsulta = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboInsti = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboLista = new javax.swing.JComboBox<>();
        labelClases = new javax.swing.JLabel();
        labelNombreAct = new javax.swing.JLabel();
        labelDesc = new javax.swing.JLabel();
        labelDuracion = new javax.swing.JLabel();
        labelCosto = new javax.swing.JLabel();
        labelFechaAlta = new javax.swing.JLabel();
        comboActi = new javax.swing.JComboBox<>();
        labelActi = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        list = new JList();
        scrollPane = new JScrollPane();
        lblCat = new JLabel("Categorias asoc.");
        
        lblImagen.setBounds(new Rectangle(0, 0, 120, 120));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel1.setText("Consulta de Actividad Deportiva");

        panelAzul.setBackground(new java.awt.Color(0, 153, 204));

        botonConsulta.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        botonConsulta.setText("Consultar");
        botonConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultaActionPerformed(evt);
            }
        });
        

        javax.swing.GroupLayout panelAzulLayout = new javax.swing.GroupLayout(panelAzul);
        panelAzulLayout.setHorizontalGroup(
        	panelAzulLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(botonConsulta, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addComponent(lblImagen, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );
        panelAzulLayout.setVerticalGroup(
        	panelAzulLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(panelAzulLayout.createSequentialGroup()
        			.addComponent(lblImagen, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
        			.addComponent(botonConsulta, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        );
        panelAzul.setLayout(panelAzulLayout);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setText("<---------");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboInsti.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        comboInsti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboInstiActionPerformed(evt);
            }
        });

        jLabel3.setText("Instituci??n");

        comboLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        comboLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboListaActionPerformed(evt);
            }
        });

        labelClases.setText("Clases/Cuponeras");

        labelNombreAct.setText("jLabel5");
        labelNombreAct.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                labelNombreActComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                labelNombreActComponentShown(evt);
            }
        });

        labelDesc.setText("jLabel5");
        labelDesc.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                labelDescComponentShown(evt);
            }
        });

        labelDuracion.setText("jLabel5");
        labelDuracion.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                labelDuracionComponentShown(evt);
            }
        });

        labelCosto.setText("jLabel5");
        labelCosto.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                labelCostoComponentShown(evt);
            }
        });

        labelFechaAlta.setText("jLabel5");
        labelFechaAlta.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                labelFechaAltaComponentShown(evt);
            }
        });

        comboActi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        comboActi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActiActionPerformed(evt);
            }
        });

        labelActi.setText("Actividad Deportiva");

        labelFecha.setText("jLabel2");
        
        
        


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jLabel1, Alignment.LEADING)
        						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        							.addComponent(comboLista, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(labelClases))
        						.addGroup(Alignment.LEADING, layout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(labelFechaAlta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        							.addComponent(labelCosto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(labelDuracion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(labelDesc, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(labelNombreAct, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        								.addComponent(comboActi, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(comboInsti, Alignment.LEADING, 0, 158, Short.MAX_VALUE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel3)
        								.addComponent(labelActi)))
        						.addComponent(labelFecha, Alignment.LEADING)
        						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(lblCat)))
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton2)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addComponent(panelAzul, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(comboInsti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(comboActi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(labelActi))
        			.addGap(8)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(comboLista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(labelClases))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(labelNombreAct)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(labelDesc)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(labelDuracion)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(labelCosto)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(labelFechaAlta)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(labelFecha)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton2))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(68)
        					.addComponent(lblCat)
        					.addContainerGap())))
        		.addComponent(panelAzul, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        
        
        scrollPane.setViewportView(list);
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultaActionPerformed-----------------------------------------------------
             
        if(this.comboLista.getSelectedIndex() != 0 && this.comboActi.getSelectedIndex() != 0 && this.comboInsti.getSelectedIndex() != 0){
            //se abren los casos de uso del Lucas y EUwUgenio, MENTIRA
        	Fabrica fab = new Fabrica();
        	IControlador controlador = fab.getInterface();
        	
        	if(!this.listaClases.contains(this.comboLista.getSelectedItem().toString())) {
        		DtCuponera DtAUsar = controlador.getDtCuponera(this.comboLista.getSelectedItem().toString());
        		
        		ArrayList<String> arrCat = new ArrayList<>();
        		ArrayList<String> arrActisAMostrar = new ArrayList<>();
        		arrActisAMostrar.addAll(DtAUsar.actividades);
        		
        		for(int i = 0;i < arrActisAMostrar.size();i++) {
        			 ArrayList<String> arr = controlador.getCategoriaXActi(arrActisAMostrar.get(i));
        			 
        			 for(int c = 0; c < arr.size();c++) {
        				 arrCat.add(arrActisAMostrar.get(i) + "/" + arr.get(c));
        			 }
        		}
        		
        		
        		//String[] arrActi = (String[])DtAUsar.actividades.toArray();
        		
        		//for(int i = 0;i < DtAUsar.actividades.size();i++) {//consigo el tama??o del arr de las actividades de las cuponeras
        			
        			//for(int c = 0;c < this.hashInfo.get(this.comboInsti.getSelectedItem().toString()).size();c++) {//itero dentro del ArrayList de DtActividades para la institucion que estoy parado
        				
        				//if(this.hashInfo.get(this.comboInsti.getSelectedItem().toString()).get(c).nombreAct.equals(arrActi[i])) {//si encontre la DtActividad correspondiente al nombre de la actividad donde est?? parada arrActi
        					
        					//for(int z = 0; z < this.hashInfo.get(this.comboInsti.getSelectedItem().toString()).get(c).categorias.size();z++) {
        				//}
//        				arrCat.add(arrActi[i] + "/" + arrActi.);
        			//}
        			
        			//arrCat.add(arrActi[i] + "/" + this.hashInfo.get(this.comboInsti.getSelectedItem().toString()).));
        			
//        			for(int c = 0;c < arrActi.length;c++) {
//        				arrCat.add(arrActi[i] + "/" + arrActi.);
//        			}
        			
        			
        		//}
        		
        		System.out.print(DtAUsar.nombreCup + DtAUsar.descripcion);
        		VentanaConsulta consultaDevuelta = new VentanaConsulta(DtAUsar,arrCat);
        		consultaDevuelta.setVisible(true);
        		
        	}else {
        		DtClase DtAUsar = controlador.getDtClaseXInsti(this.comboInsti.getSelectedItem().toString(),this.comboActi.getSelectedItem().toString(),this.comboLista.getSelectedItem().toString());
        		//System.out.print(DtAUsar.nombreClase + "ALGO PORfa");
        		VentanaConsulta consultaDevuelta = new VentanaConsulta(DtAUsar);
        		consultaDevuelta.setVisible(true);
        	}
        }else{
            VentanaMensaje errorVentana = new VentanaMensaje("ERROR!","Hay campos sin rellenar",java.awt.Color.RED);
            errorVentana.setVisible(true);
            return;
        }
    }//GEN-LAST:event_botonConsultaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void comboInstiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboInstiActionPerformed
        
        if(comboInsti.getSelectedIndex() != 0){      	
        	//------------------_Itero para darle valor al comboBox de Actividades Deportivas------------------------------------
        	comboActi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        	
        	//
        	//ArrayList<String> arrStr = controlador.consultarActividadDepo(comboInsti.getSelectedItem().toString());
        	ArrayList<DtActividadDeportiva> arrDtActi = this.hashInfo.get(comboInsti.getSelectedItem().toString()).actividades;
        	
        	
        	for(int i = 0;i < arrDtActi.size();i++) {
        		comboActi.addItem(arrDtActi.get(i).nombreAct);
        	}
        	//--------------------muestro el resto de componentes----------------------------------------------------------------
            this.comboActi.setVisible(true);
            this.labelActi.setVisible(true);
            
            //--------------------escondo los componentes innecesarios-----------------------------------------------------------
            
        }else{
        	//--------------------restauro el valor que ten??a originalmente el comboBox de Actividades----------------------------
        	comboActi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        	
        	//--------------------Escondo el resto de componentes-----------------------------------------------------------------
            this.comboActi.setVisible(false);
            this.comboLista.setVisible(false);
            this.labelActi.setVisible(false);
            this.labelClases.setVisible(false);
            this.labelNombreAct.setVisible(false);
            this.labelDesc.setVisible(false);
            this.labelDuracion.setVisible(false);
            this.labelCosto.setVisible(false);
            this.labelFechaAlta.setVisible(false);
			this.lblImagen.setText("");
			this.lblImagen.setVisible(false);
			this.lblCat.setVisible(false);
			
	        this.scrollPane.setVisible(false);
	        this.list.setVisible(false);
        }
        
    }//GEN-LAST:event_comboInstiActionPerformed

    private void comboListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboListaActionPerformed
    
//    	System.out.println("antes del clearear listaClases");
//        this.listaClases.clear();
//        this.listaClases.addAll(arrStr2);
//        
//        System.out.println("antes del clearear listaCuponeras");
//        this.listaCuponeras.clear();
//        this.listaCuponeras.addAll(arrStr);
        

    }//GEN-LAST:event_comboListaActionPerformed

    private void labelNombreActComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_labelNombreActComponentHidden

    }//GEN-LAST:event_labelNombreActComponentHidden

    private void labelNombreActComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_labelNombreActComponentShown
        //this.labelNombreAct.setText("Nombre: ");
    }//GEN-LAST:event_labelNombreActComponentShown

    private void labelDescComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_labelDescComponentShown
        //this.labelDesc.setText("Descripci??n: ");
    }//GEN-LAST:event_labelDescComponentShown

    private void labelDuracionComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_labelDuracionComponentShown
        //this.labelDuracion.setText("Duraci??n (mins): ");
    }//GEN-LAST:event_labelDuracionComponentShown

    private void labelCostoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_labelCostoComponentShown
        //this.labelCosto.setText("Costo: ");
    }//GEN-LAST:event_labelCostoComponentShown

    private void labelFechaAltaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_labelFechaAltaComponentShown
        //this.labelFecha.setText("Fecha registro: ");
    }//GEN-LAST:event_labelFechaAltaComponentShown

    private void comboActiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActiActionPerformed

        if(comboInsti.getSelectedIndex() != 0 && comboActi.getSelectedIndex() != 0){

        	ArrayList<DtActividadDeportiva> arrDtActi = this.hashInfo.get(comboInsti.getSelectedItem().toString()).actividades;
        	DtActividadDeportiva dtActi = arrDtActi.get(comboActi.getSelectedIndex() -1);//ver bien lo del -1

            //combos
            this.comboLista.setVisible(true);

            //labels
            this.labelClases.setVisible(true);
            
            this.labelNombreAct.setVisible(true);
            this.labelNombreAct.setText("Nombre: " + dtActi.nombreAct);
            
            this.labelDesc.setVisible(true);
            this.labelDesc.setText("Descripci??n: " + dtActi.descripcion);
            
            this.labelDuracion.setVisible(true);
            this.labelDuracion.setText("Duraci??n (mins): " + Float.toString(dtActi.duracion));
            
            this.labelCosto.setVisible(true);
            this.labelCosto.setText("Costo: " +  Float.toString(dtActi.costo) + "$");
            
            this.lblImagen.setVisible(true);
            
            this.labelFechaAlta.setVisible(true);
            this.labelFechaAlta.setText("Fecha de Alta: " + dtActi.fechaRegistro.toString());
            
            this.lblCat.setVisible(true);
            
            this.scrollPane.setVisible(true);
            this.list.setVisible(true);
            
            //----------------------------consigo los DtActividades pertinentes-------------------------------------------------------------------
            ArrayList<String> arrStr = new ArrayList<String>();
            ArrayList<String> arrStr2 = new ArrayList<String>();
            ArrayList<String> arrStr3 = new ArrayList<String>();
            
            
            DefaultListModel listModel = new DefaultListModel();
            
            
            for(int i = 0;i < dtActi.cuponeras.size();i++) {
            	arrStr.add(dtActi.cuponeras.get(i).nombreCup);
            }
  
            for(int i = 0;i < dtActi.clases.size();i++) {
            	arrStr2.add(dtActi.clases.get(i).nombreClase);
            }
            
            for(int i = 0;i < dtActi.categorias.size();i++) {
            	arrStr3.add(dtActi.categorias.get(i));
            }
            
            comboLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
            

            this.listaClases.clear();
            this.listaClases.addAll(arrStr2);

            this.listaCuponeras.clear();
            this.listaCuponeras.addAll(arrStr);


            
            //System.out.println("antes de iterar");
            for(int i = 0; i < arrStr.size();i++) {
            	this.comboLista.addItem(arrStr.get(i));
            	//this.listaCuponeras.add(arrStr.get(i));
            }
            
            for(int i = 0; i < arrStr2.size();i++) {
            	this.comboLista.addItem(arrStr2.get(i));
            	//this.listaClases.add(arrStr2.get(i));
            }
            
            for(int i = 0; i < arrStr3.size();i++) {
            	listModel.addElement(arrStr3.get(i));
            	//this.listaClases.add(arrStr2.get(i));
            }
        
            
            this.list.setModel(listModel);
            
            System.out.println(dtActi.clases);

            
            String rutaDir = System.getProperty("user.dir");
            Image imagen = null;
			try {
				imagen = ImageIO.read(new File(rutaDir+"/src/imgActis/"+"."+ comboActi.getSelectedItem().toString()));//busco la imagen
				imagen = imagen.getScaledInstance(120, 120, 120);
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(imagen != null) {
					lblImagen.setIcon(new ImageIcon(imagen));
				}else {
					lblImagen.setIcon(null);
					lblImagen.setText("No se encontr?? la foto asociada");
				}
			}
        }else{
            //combos
            this.comboLista.setVisible(false);
            
            //labels
            this.labelClases.setVisible(false);
            this.labelNombreAct.setVisible(false);
            this.labelDesc.setVisible(false);
            this.labelDuracion.setVisible(false);
            this.labelCosto.setVisible(false);
            this.labelFechaAlta.setVisible(false);
            this.lblCat.setVisible(false);
            
            this.scrollPane.setVisible(false);
            this.list.setVisible(false);
        }
        
    }//GEN-LAST:event_comboActiActionPerformed

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
//            java.util.logging.Logger.getLogger(ConsultaActividadDeportiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ConsultaActividadDeportiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ConsultaActividadDeportiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ConsultaActividadDeportiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConsultaActividadDeportiva().setVisible(true);//FUNCA IGUAL VOS CONFIA
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConsulta;
    private javax.swing.JComboBox<String> comboActi;
    private javax.swing.JComboBox<String> comboInsti;
    private javax.swing.JComboBox<String> comboLista;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelActi;
    private javax.swing.JLabel labelClases;
    private javax.swing.JLabel labelCosto;
    private javax.swing.JLabel labelDesc;
    private javax.swing.JLabel labelDuracion;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelFechaAlta;
    private javax.swing.JLabel labelNombreAct;
    private javax.swing.JPanel panelAzul;
    private JLabel lblImagen;
    private JScrollPane scrollPane;
    private JList list;
    private JLabel lblCat;
}
