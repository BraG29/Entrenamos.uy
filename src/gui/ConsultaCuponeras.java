package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	 */
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
	
	 
	/**
	 * Create the frame.
	 */
	public ConsultaCuponeras() {
		setTitle("Consulta de cuponeras de actividades deportivas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 302, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//lbls cuponera
		JLabel lblCantidadDeClases = new JLabel("Cantidad de clases:");
		lblCantidadDeClases.setBounds(12, 266, 140, 15);
		panel.add(lblCantidadDeClases);
		lblCantidadDeClases.setVisible(false);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(12, 158, 110, 15);
		panel.add(lblDescuento);
		lblDescuento.setVisible(false);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de fin:");
		lblFechaDeFin.setBounds(12, 239, 110, 15);
		panel.add(lblFechaDeFin);
		lblFechaDeFin.setVisible(false);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio:");
		lblFechaDeInicio.setBounds(12, 212, 110, 15);
		panel.add(lblFechaDeInicio);
		lblFechaDeInicio.setVisible(false);
		
		JLabel lblFechaDeCreacin = new JLabel("Fecha de creación:");
		lblFechaDeCreacin.setBounds(12, 185, 140, 15);
		panel.add(lblFechaDeCreacin);
		lblFechaDeCreacin.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 78, 70, 15);
		panel.add(lblNombre);
		lblNombre.setVisible(false);
		
		JLabel lblSeleccionCuponera = new JLabel("Seleccione una cuponera:");
		lblSeleccionCuponera.setBounds(52, 19, 183, 15);
		panel.add(lblSeleccionCuponera);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(12, 105, 87, 15);
		panel.add(lblDescripcin);
		lblDescripcin.setVisible(false);
		
		JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.YELLOW);
        panel_1.setBounds(298, 0, 340, 300);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
		
		//lbls actividad
        JLabel lblNombreActividad = new JLabel("Nombre:");
        lblNombreActividad.setBounds(45, 85, 70, 15);
        panel_1.add(lblNombreActividad);
        lblNombreActividad.setVisible(false);
        
        JLabel lblDescripcinActividad = new JLabel("Descripción:");
        lblDescripcinActividad.setBounds(45, 112, 95, 15);
        panel_1.add(lblDescripcinActividad);
        lblDescripcinActividad.setVisible(false);
        
        JLabel lblDuracin = new JLabel("Duración:");
        lblDuracin.setBounds(45, 175, 70, 15);
        panel_1.add(lblDuracin);
        lblDuracin.setVisible(false);
        
        JLabel lblCosto = new JLabel("Costo:");
        lblCosto.setBounds(45, 203, 70, 15);
        panel_1.add(lblCosto);
        lblCosto.setVisible(false);
        
        JLabel lblFechaDeRegistro = new JLabel("Fecha de registro:");
        lblFechaDeRegistro.setBounds(45, 233, 149, 15);
        panel_1.add(lblFechaDeRegistro);
        lblFechaDeRegistro.setVisible(false);
      
		JComboBox comboBoxActividad = new JComboBox();
		comboBoxActividad.setBounds(63, 49, 180, 24);
		panel_1.add(comboBoxActividad);
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
	    
	       
        JLabel lblSeleccioneUnaActividad = new JLabel("Seleccione una actividad:");
        lblSeleccioneUnaActividad.setBounds(63, 22, 180, 15);
        panel_1.add(lblSeleccioneUnaActividad);
        lblSeleccioneUnaActividad.setVisible(true);
        
		JComboBox comboBoxCuponera = new JComboBox();
		comboBoxCuponera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cuponera = comboBoxCuponera.getSelectedIndex();
					if(cuponera != 0) {
					lblNombre.setVisible(true);
					lblDescripcin.setVisible(true);
					lblFechaDeInicio.setVisible(true);
					lblFechaDeFin.setVisible(true);
					lblFechaDeCreacin.setVisible(true);
					lblDescuento.setVisible(true);
					lblCantidadDeClases.setVisible(true);
					lblSeleccioneUnaActividad.setVisible(true);
					comboBoxActividad.setVisible(true);
				}else {
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
		});
		comboBoxCuponera.setBounds(52, 46, 183, 24);
		panel.add(comboBoxCuponera);
		
		
		
		
		
		//martin
		String[] holiwi = new String[] {"-","holiwi","owo"}; //llamada a una función futura       
        comboBoxCuponera.setModel(new DefaultComboBoxModel(holiwi));
        
        String[] holix = new String[] {"-","holiwi","owo"}; //llamada a una función futura      
        comboBoxActividad.setModel(new DefaultComboBoxModel(holix));

        JButton btnCanclear = new JButton("X");
        btnCanclear.setBounds(291, 266, 49, 34);
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
