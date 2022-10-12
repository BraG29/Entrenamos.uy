package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.controlador.Fabrica;
import logica.controlador.IControlador;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AceptarRechazarActividades extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AceptarRechazarActividades frame = new AceptarRechazarActividades();
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
	public AceptarRechazarActividades() {
		setTitle("Aceptar o rechazar actividades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//boton para cambiar estado a aceptada
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(238, 156, 117, 25);
		contentPane.add(btnAceptar);
		
		
		
		//boton para cambiar estado a rechazada
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.setBounds(90, 156, 117, 25);
		contentPane.add(btnRechazar);
	
		//obtengo actividades para el combobox
		JComboBox comboBoxActividad = new JComboBox();
		
		String[] inicio = new String[] {"..."}; 
        comboBoxActividad.setModel(new DefaultComboBoxModel(inicio));
		
		Fabrica fab = new Fabrica();
		IControlador sistema = fab.getInterface();
		
		java.util.List ActividadesIngresadas = sistema.listaActividadesIngresada();
		
		for (int i = 0; i < ActividadesIngresadas.size(); i++) {
			comboBoxActividad.addItem(ActividadesIngresadas.get(i));
		}
		
		comboBoxActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String actividadSeleccionada = comboBoxActividad.getSelectedItem().toString();// obtengo nombre de actividad a cambiar estado
				//actividad aceptada
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						sistema.rechazoAceptoActividad(actividadSeleccionada, 1);
					}
				});
				
				//actividad rechazada
				btnRechazar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						sistema.rechazoAceptoActividad(actividadSeleccionada, 2);
					}
				});
			} 
		});
		
		comboBoxActividad.setBounds(117, 26, 220, 24);
		contentPane.add(comboBoxActividad);

	}
}
