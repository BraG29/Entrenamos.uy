package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//obtengo actividades para el combobox
		//java.util.List ActividadesIngresadas = sistema.listActividadesIngresada();
		/*
		for (int i = 0; i < ActividadesIngresadas.size(); i++) {
			comboBoxCuponera.addItem(ActividadesIngresadas.get(i));
		}*/
		
		//String actividadSeleccionada = null;
		
		JComboBox comboBoxActividad = new JComboBox();
		comboBoxActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//actividadSeleccionada = comboBoxActividad.getSelectedItem().toString(); obtengo nombre de actividad a cambiar estado
			}
		});
		
		comboBoxActividad.setBounds(117, 26, 220, 24);
		contentPane.add(comboBoxActividad);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//funcion cambio estado  y le paso actividad seleccionada
			}
		});
		btnAceptar.setBounds(238, 156, 117, 25);
		contentPane.add(btnAceptar);
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//funcion cambio estado  y le paso actividad seleccionada
			}
		});
		btnRechazar.setBounds(90, 156, 117, 25);
		contentPane.add(btnRechazar);
	}
}
