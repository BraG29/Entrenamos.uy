package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.controlador.*;
import logica.datatypes.DtActividadDeportiva;
import logica.datatypes.DtCuponera;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextField;

public class ConsultaCuponeras extends JFrame {

	private JPanel contentPane;
	private ConsultaActividadDeportiva menuActividadDeportiva;
	private VentanaMensaje errorWindow;
	private JTextField txtDescripcion;
	private JTextField txtNombreCup;
	private JTextField txtDescripcionCup;
	private JTextField txtDescuentoCup;
	private JTextField txtAltaCup;
	private JTextField txtInicioCup;
	private JTextField txtFinCup;
	private JTextField txtCantClases;
	private JTextField txtNombreAct;
	private JTextField txtDuracion;
	private JTextField txtCosto;
	private JTextField txtAltaAct;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCuponeras frame = new ConsultaCuponeras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	/**
	 * Create the frame.
	 */
	public ConsultaCuponeras() {
		setTitle("Consulta de cuponeras de actividades deportivas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 514, 547);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//lbls y txtfields cuponera
		JLabel lblCantidadDeClases = new JLabel("Cantidad de clases:");
		lblCantidadDeClases.setBounds(12, 279, 149, 15);
		panel.add(lblCantidadDeClases);
		
		
		txtCantClases = new JTextField();
		txtCantClases.setBounds(157, 277, 326, 19);
		panel.add(txtCantClases);
		txtCantClases.setColumns(10);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(12, 171, 86, 15);
		panel.add(lblDescuento);
		
		txtDescuentoCup = new JTextField();
		txtDescuentoCup.setBounds(107, 169, 376, 19);
		panel.add(txtDescuentoCup);
		txtDescuentoCup.setColumns(10);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de fin:");
		lblFechaDeFin.setBounds(12, 252, 99, 15);
		panel.add(lblFechaDeFin);
		txtFinCup = new JTextField();
		txtFinCup.setBounds(119, 248, 364, 19);
		panel.add(txtFinCup);
		txtFinCup.setColumns(10);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio:");
		lblFechaDeInicio.setBounds(12, 225, 120, 15);
		panel.add(lblFechaDeInicio);
		
		txtInicioCup = new JTextField();
		txtInicioCup.setBounds(137, 223, 346, 19);
		panel.add(txtInicioCup);
		txtInicioCup.setColumns(10);
		
		
		JLabel lblFechaDeCreacin = new JLabel("Fecha de creación:");
		lblFechaDeCreacin.setBounds(12, 198, 139, 15);
		panel.add(lblFechaDeCreacin);
		
		txtAltaCup = new JTextField();
		txtAltaCup.setBounds(157, 196, 326, 19);
		panel.add(txtAltaCup);
		txtAltaCup.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 78, 65, 15);
		panel.add(lblNombre);
		
		txtNombreCup = new JTextField();
		txtNombreCup.setBounds(78, 76, 405, 19);
		panel.add(txtNombreCup);
		txtNombreCup.setColumns(10);

		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(12, 105, 92, 15);
		panel.add(lblDescripcin);

		txtDescripcionCup = new JTextField();
		txtDescripcionCup.setBounds(107, 105, 376, 54);
		panel.add(txtDescripcionCup);
		txtDescripcionCup.setColumns(10);
		
		//quito visibilidad de lables y text fields
		lblNombre.setVisible(false);
		lblDescripcin.setVisible(false);
		lblFechaDeCreacin.setVisible(false);
		lblFechaDeInicio.setVisible(false);
		lblFechaDeFin.setVisible(false);
		lblCantidadDeClases.setVisible(false);
		lblDescuento.setVisible(false);
		txtNombreCup.setVisible(false);
		txtDescripcionCup.setVisible(false);
		txtAltaCup.setVisible(false);
		txtInicioCup.setVisible(false);
		txtFinCup.setVisible(false);
		txtCantClases.setVisible(false);
		txtDescuentoCup.setVisible(false);
		
		//quito edicion de los text fields
		txtNombreCup.setEditable(false);
		txtDescripcionCup.setEditable(false);
		txtAltaCup.setEditable(false);
		txtInicioCup.setEditable(false);
		txtFinCup.setEditable(false);
		txtCantClases.setEditable(false);
		txtDescuentoCup.setEditable(false);
		
		JLabel lblSeleccionCuponera = new JLabel("Seleccione una cuponera:");
		lblSeleccionCuponera.setBounds(172, 19, 183, 15);
		panel.add(lblSeleccionCuponera);
		
        
		JComboBox comboBoxCuponera = new JComboBox();
		comboBoxCuponera.setBounds(172, 46, 183, 24);
		panel.add(comboBoxCuponera);
		
		Fabrica fab = new Fabrica();
		IControlador sistema = fab.getInterface();
		
		//le paso la lista de cuponeras al combobox
		String[] inicio = new String[] {"..."}; 
        comboBoxCuponera.setModel(new DefaultComboBoxModel(inicio));
        
        JComboBox comboBoxActividad = new JComboBox();
        comboBoxActividad.setBounds(172, 336, 183, 24);
        comboBoxActividad.setVisible(false);
        panel.add(comboBoxActividad);
        
   
        JLabel lblSeleccioneUnaActividad = new JLabel("Seleccione una actividad:");
	    lblSeleccioneUnaActividad.setBounds(175, 309, 180, 15);
	    panel.add(lblSeleccioneUnaActividad);
	     
	    
	    //lbls actividad
       
        JLabel lblNombreActividad = new JLabel("Nombre:");
        lblNombreActividad.setBounds(12, 369, 65, 15);
        panel.add(lblNombreActividad);
        
        txtNombreAct = new JTextField();
        txtNombreAct.setBounds(86, 367, 397, 19);
        panel.add(txtNombreAct);
        txtNombreAct.setColumns(10);
        
        
        JLabel lblDescripcinActividad = new JLabel("Descripción:");
        lblDescripcinActividad.setBounds(12, 396, 92, 15);
        panel.add(lblDescripcinActividad);
        
        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(119, 396, 364, 54);
        panel.add(txtDescripcion);
        txtDescripcion.setColumns(10);
        
        JLabel lblDuracin = new JLabel("Duración:");
        lblDuracin.setBounds(12, 464, 75, 15);
        panel.add(lblDuracin);
        
        txtDuracion = new JTextField();
        txtDuracion.setBounds(93, 462, 390, 19);
        panel.add(txtDuracion);
        txtDuracion.setColumns(10);

        JLabel lblCosto = new JLabel("Costo:");
        lblCosto.setBounds(12, 491, 53, 15);
        panel.add(lblCosto);
        
        txtCosto = new JTextField();
        txtCosto.setBounds(67, 491, 416, 19);
        panel.add(txtCosto);
        txtCosto.setColumns(10);
        
        JLabel lblFechaDeRegistro = new JLabel("Fecha de registro:");
        lblFechaDeRegistro.setBounds(12, 522, 139, 15);
        panel.add(lblFechaDeRegistro);
        
        txtAltaAct = new JTextField();
        txtAltaAct.setBounds(164, 520, 319, 19);
        panel.add(txtAltaAct);
        txtAltaAct.setColumns(10);
        
        JLabel lblErrorActividades = new JLabel("No hay actividades en esta cuponera");
        lblErrorActividades.setForeground(Color.RED);
        lblErrorActividades.setBounds(140, 383, 296, 15);
        panel.add(lblErrorActividades);
        
        //coloco visibilidad de todo en false
        lblErrorActividades.setVisible(false);
        txtNombreAct.setVisible(false);
        txtDuracion.setVisible(false);
        txtCosto.setVisible(false);
        txtAltaAct.setVisible(false);
        txtDescripcion.setVisible(false);
        lblFechaDeRegistro.setVisible(false);
        lblCosto.setVisible(false);
        lblDuracin.setVisible(false);
        lblDescripcinActividad.setVisible(false);
        lblNombreActividad.setVisible(false);
        lblSeleccioneUnaActividad.setVisible(false);
        
        //quito edicion de los text field
        txtNombreAct.setEditable(false);
        txtDuracion.setEditable(false);
        txtCosto.setEditable(false);
        txtAltaAct.setEditable(false);
        txtDescripcion.setEditable(false);
        
        
		java.util.List cuponeras = sistema.listaCuponerasRegistradas();
		
		for (int i = 0; i < cuponeras.size(); i++) {
			comboBoxCuponera.addItem(cuponeras.get(i));
		}
		
        //accion combobox Cuponera	
		comboBoxCuponera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre= comboBoxCuponera.getSelectedItem().toString();	//nombre de la cuponera q selecciono.
				System.out.println("combo box = " + comboBoxCuponera.getSelectedItem().toString());
				
				//DtCuponera datosCup = sistema.seleccionCuponera(nombre);
				DtCuponera datosCup = sistema.getDtCuponera(nombre);
				System.out.println("datoscup = " + datosCup.nombreCup + " "+ datosCup.descripcion);
				//controlar si esta vacio.
				
				int cuponera = comboBoxCuponera.getSelectedIndex();
				if(cuponera != 0) {
					
					txtNombreCup.setText(datosCup.nombreCup);
					lblNombre.setVisible(true);
					txtNombreCup.setVisible(true);
					
					txtDescripcionCup.setText(datosCup.descripcion);
					lblDescripcin.setVisible(true);
					txtDescripcionCup.setVisible(true);
					
					lblFechaDeInicio.setText("Fecha de inicio: ");
					txtInicioCup.setText("" + datosCup.fechaInicio);
					lblFechaDeInicio.setVisible(true);
					txtInicioCup.setVisible(true);
					
					lblFechaDeFin.setText("Fecha de fin: ");
					txtFinCup.setText("" + datosCup.fechaFin);
					lblFechaDeFin.setVisible(true);
					txtFinCup.setVisible(true);
					
					lblFechaDeCreacin.setText("Fecha de creación: ");
					txtAltaCup.setText("" + datosCup.fechaAlta);
					lblFechaDeCreacin.setVisible(true);
					txtAltaCup.setVisible(true);
					
					lblDescuento.setText("Descuento: ");
					txtDescuentoCup.setText("" + datosCup.descuento + "%");
					lblDescuento.setVisible(true);
					txtDescuentoCup.setVisible(true);
					
					lblCantidadDeClases.setText("Cantidad de clases: ");
					txtCantClases.setText("" + datosCup.cantClases);
					lblCantidadDeClases.setVisible(true);
					txtCantClases.setVisible(true);
					
					lblSeleccioneUnaActividad.setVisible(true);
					comboBoxActividad.setVisible(true);
					
					
					//accion combobox actividad
					String[] inicio = new String[] {"..."}; 
			        comboBoxActividad.setModel(new DefaultComboBoxModel(inicio));
			        	        
			        java.util.List actividades = (java.util.List<String>)datosCup.actividades;
			        for (int i = 0; i < actividades.size(); i++) {
						comboBoxActividad.addItem(actividades.get(i));
					}
       
					comboBoxActividad.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							String nombreActi = comboBoxActividad.getSelectedItem().toString();							
							//DtActividadDeportiva datosAct = sistema.seleccionActividad(nombreActi);
							DtActividadDeportiva datosAct = sistema.getDtActividadDepo(nombreActi);
							
							int actividad = comboBoxActividad.getSelectedIndex();
							
							if(actividad != 0) {						
								//lblErrorActividades.setVisible(false);
								
						        lblNombreActividad.setText("Nombre: ");
						        txtNombreAct.setText(datosAct.nombreAct);
								lblNombreActividad.setVisible(true);
								txtNombreAct.setVisible(true);
								
								lblDescripcinActividad.setText("Descripción: ");
								txtDescripcion.setText(datosAct.descripcion);
								txtDescripcion.setVisible(true);
								lblDescripcinActividad.setVisible(true);
								
								lblDuracin.setText("Duración: ");
								txtDuracion.setText(datosAct.duracion + " mins");
								lblDuracin.setVisible(true);
								txtDuracion.setVisible(true);
								
								lblCosto.setText("Costo: ");
								txtCosto.setText(datosAct.costo + "$");
								lblCosto.setVisible(true);
								txtCosto.setVisible(true);
								
								lblFechaDeRegistro.setText("Fecha de registro: ");
								txtAltaAct.setText("" + datosAct.fechaRegistro);
								lblFechaDeRegistro.setVisible(true);
								txtAltaAct.setVisible(true);
								
							}else {
								if(actividad == 0) {
									//lblErrorActividades.setVisible(true);
									txtNombreCup.setVisible(false);
									txtDescripcion.setVisible(false);
									txtDuracion.setVisible(false);
									txtCosto.setVisible(false);
									txtAltaAct.setVisible(false);
									lblNombreActividad.setVisible(false);
									lblDescripcinActividad.setVisible(false);
									lblDuracin.setVisible(false);
									lblCosto.setVisible(false);
									lblFechaDeRegistro.setVisible(false);									
								}
							}
						}
					});
					
				}else {
					if(cuponera == 0) {
						txtNombreCup.setVisible(false);
						txtDescripcionCup.setVisible(false);
						txtAltaCup.setVisible(false);
						txtInicioCup.setVisible(false);
						txtFinCup.setVisible(false);
						txtDescuentoCup.setVisible(false);
						txtCantClases.setVisible(false);
						lblNombre.setVisible(false);
						lblDescripcin.setVisible(false);
						lblFechaDeInicio.setVisible(false);
						lblFechaDeFin.setVisible(false);
						lblFechaDeCreacin.setVisible(false);
						lblDescuento.setVisible(false);
						lblCantidadDeClases.setVisible(false);
						lblSeleccioneUnaActividad.setVisible(false);
						comboBoxActividad.setVisible(false);
						
					}					
				}
			}
		});
        
       
        
	}
}
