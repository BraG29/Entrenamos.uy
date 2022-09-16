package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.controlador.*;
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

public class ConsultaCuponeras extends JFrame {

	private JPanel contentPane;
	private ConsultaActividadDeportiva menuActividadDeportiva;
	private VentanaMensaje errorWindow;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 388, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//lbls cuponera
		JLabel lblCantidadDeClases = new JLabel("Cantidad de clases:");
		lblCantidadDeClases.setBounds(12, 266, 290, 15);
		panel.add(lblCantidadDeClases);
		lblCantidadDeClases.setVisible(false);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(12, 158, 278, 15);
		panel.add(lblDescuento);
		lblDescuento.setVisible(false);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de fin:");
		lblFechaDeFin.setBounds(12, 239, 364, 15);
		panel.add(lblFechaDeFin);
		lblFechaDeFin.setVisible(false);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio:");
		lblFechaDeInicio.setBounds(12, 212, 364, 15);
		panel.add(lblFechaDeInicio);
		lblFechaDeInicio.setVisible(false);
		
		JLabel lblFechaDeCreacin = new JLabel("Fecha de creación:");
		lblFechaDeCreacin.setBounds(12, 185, 364, 15);
		panel.add(lblFechaDeCreacin);
		lblFechaDeCreacin.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 78, 376, 15);
		panel.add(lblNombre);
		lblNombre.setVisible(false);
		
		JLabel lblSeleccionCuponera = new JLabel("Seleccione una cuponera:");
		lblSeleccionCuponera.setBounds(52, 19, 183, 15);
		panel.add(lblSeleccionCuponera);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(12, 96, 364, 35);
		panel.add(lblDescripcin);
		lblDescripcin.setVisible(false);
		
		JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.YELLOW);
        panel_1.setBounds(389, 0, 445, 300);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
		
		//lbls actividad
       
        JLabel lblNombreActividad = new JLabel("Nombre:");
        lblNombreActividad.setBounds(20, 83, 413, 15);
        panel_1.add(lblNombreActividad);
        lblNombreActividad.setVisible(false);
        
        JLabel lblDescripcinActividad = new JLabel("Descripción:");
        lblDescripcinActividad.setBounds(20, 110, 413, 15);
        panel_1.add(lblDescripcinActividad);
        lblDescripcinActividad.setVisible(false);
        
        JLabel lblDuracin = new JLabel("Duración:");
        lblDuracin.setBounds(20, 168, 404, 15);
        panel_1.add(lblDuracin);
        lblDuracin.setVisible(false);
        
        JLabel lblCosto = new JLabel("Costo:");
        lblCosto.setBounds(20, 195, 149, 15);
        panel_1.add(lblCosto);
        lblCosto.setVisible(false);
        
        JLabel lblFechaDeRegistro = new JLabel("Fecha de registro:");
        lblFechaDeRegistro.setBounds(20, 222, 413, 15);
        panel_1.add(lblFechaDeRegistro);
        lblFechaDeRegistro.setVisible(false);
      
	       
        JLabel lblSeleccioneUnaActividad = new JLabel("Seleccione una actividad:");
        lblSeleccioneUnaActividad.setBounds(135, 22, 180, 15);
        panel_1.add(lblSeleccioneUnaActividad);
        lblSeleccioneUnaActividad.setVisible(true);

        JComboBox comboBoxActividad = new JComboBox();
        comboBoxActividad.setBounds(100, 49, 228, 24);
        panel_1.add(comboBoxActividad);
        
		JComboBox comboBoxCuponera = new JComboBox();
		comboBoxCuponera.setBounds(52, 46, 183, 24);
		panel.add(comboBoxCuponera);
		
		Fabrica fab = new Fabrica();
		IControlador sistema = fab.getInterface();
		
		
		//le paso la lista de cuponeras al combobox
		String[] inicio = new String[] {"..."}; 
        comboBoxCuponera.setModel(new DefaultComboBoxModel(inicio));
        
		java.util.List cuponeras = sistema.listaCuponerasRegistradas();
		
		
		for (int i = 0; i < cuponeras.size(); i++) {
			comboBoxCuponera.addItem(cuponeras.get(i));
		}
		
        //accion combobox Cuponera	
		comboBoxCuponera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre= comboBoxCuponera.getSelectedItem().toString();	//nombre de la cuponera q selecciono.
				DtCuponera datosCup = sistema.seleccionCuponera(nombre);
				
				//controlar si esta vacio.
				
				int cuponera = comboBoxCuponera.getSelectedIndex();
				if(cuponera != 0) {

					lblNombre.setText("Nombre: " + datosCup.nombreCup);
					lblNombre.setVisible(true);
					
					lblDescripcin.setText("Descripción: " + datosCup.descripcion);
					lblDescripcin.setVisible(true);
					
					lblFechaDeInicio.setText("Fecha de inicio: " + datosCup.fechaInicio);
					lblFechaDeInicio.setVisible(true);
					
					lblFechaDeFin.setText("Fecha de fin: " + datosCup.fechaFin);
					lblFechaDeFin.setVisible(true);
					
					lblFechaDeCreacin.setText("Fecha de creación: " + datosCup.fechaAlta);
					lblFechaDeCreacin.setVisible(true);
					
					lblDescuento.setText("Descuento: " + datosCup.descuento);
					lblDescuento.setVisible(true);
					
					lblCantidadDeClases.setText("Cantidad de clases: " + datosCup.cantClases);
					lblCantidadDeClases.setVisible(true);
					
					lblSeleccioneUnaActividad.setVisible(true);
					comboBoxActividad.setVisible(true);
					
					
					 	//accion combobox actividad
					String[] inicio = new String[] {"..."}; 
			        comboBoxActividad.setModel(new DefaultComboBoxModel(inicio));
			        
			        String nombreAct = null;
			        String descAct = null;
			        Float duracion = null;
			        Float costo = null;
			        LocalDate fechaRegistro = null;
			        
			        java.util.List actividades = (java.util.List<String>)datosCup.actividades;
			        for (int i = 0; i < actividades.size(); i++) {
						comboBoxActividad.addItem(actividades.get(i));
					}
			        
					comboBoxActividad.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int actividad = comboBoxActividad.getSelectedIndex();
							if(actividad >= 0) {
								
						        JLabel lblNombreActividad = new JLabel("Nombre:");
								lblNombreActividad.setVisible(true);
								
								JLabel lblDescripcinActividad = new JLabel("Descripción:");
								lblDescripcinActividad.setVisible(true);
								
								JLabel lblDuracin = new JLabel("Duración:");
								lblDuracin.setVisible(true);
								
								JLabel lblCosto = new JLabel("Costo:");
								lblCosto.setVisible(true);
								
								JLabel lblFechaDeRegistro = new JLabel("Fecha de registro:");
								lblFechaDeRegistro.setVisible(true);
								
							}else {
								lblNombreActividad.setVisible(false);
								lblDescripcinActividad.setVisible(false);
								lblDuracin.setVisible(false);
								lblCosto.setVisible(false);
								lblFechaDeRegistro.setVisible(false);
							}
						}
					});
					
				}else {
					if(cuponera == 0) {
						
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

		/*
		//accion combobox actividad
		comboBoxActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int actividad = comboBoxActividad.getSelectedIndex();
				if(actividad != 0) {
					lblNombreActividad.setVisible(true);
					lblDescripcinActividad.setVisible(true);
					lblDuracin.setVisible(true);
					lblCosto.setVisible(true);
					lblFechaDeRegistro.setVisible(true);
				}else {
					lblNombreActividad.setVisible(false);
					lblDescripcinActividad.setVisible(false);
					lblDuracin.setVisible(false);
					lblCosto.setVisible(false);
					lblFechaDeRegistro.setVisible(false);
				}
			}
		});
		*/

        JButton btnCanclear = new JButton("X");
        btnCanclear.setBounds(396, 266, 49, 34);
        panel_1.add(btnCanclear);
        btnCanclear.setForeground(Color.WHITE);
        btnCanclear.setBackground(Color.RED);
        btnCanclear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		setVisible(false);
        	}
        });
        
       
        
	}
}
