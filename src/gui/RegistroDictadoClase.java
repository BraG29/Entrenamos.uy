package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RegistroDictadoClase extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroDictadoClase frame = new RegistroDictadoClase();
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
	public RegistroDictadoClase() {
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 448);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInstitucion = new JLabel("Institución");
		lblInstitucion.setBounds(15, 29, 122, 20);
		contentPane.add(lblInstitucion);
		
		JComboBox cBoxInstitucion = new JComboBox();
		cBoxInstitucion.setModel(new DefaultComboBoxModel(new String[] {"IUA", "Saint Joseph", "Capuchinas"}));
		cBoxInstitucion.setBounds(137, 29, 112, 20);
		contentPane.add(cBoxInstitucion);
		
		JLabel lblTipoUsr = new JLabel("Actividades Deportivas:");
		lblTipoUsr.setBounds(15, 60, 122, 20);
		contentPane.add(lblTipoUsr);
		
		JComboBox cBoxActividadDeportiva = new JComboBox();
		cBoxActividadDeportiva.setModel(new DefaultComboBoxModel(new String[] {"Basketball", "Football", "Voleyball"}));
		cBoxActividadDeportiva.setBounds(137, 60, 112, 20);
		contentPane.add(cBoxActividadDeportiva);
		
		JLabel lblClases = new JLabel("Clases:");
		lblClases.setBounds(15, 91, 122, 20);
		contentPane.add(lblClases);
		
		JComboBox cBoxClase = new JComboBox();
		cBoxClase.setModel(new DefaultComboBoxModel(new String[] {"Mañana", "Tarde", "Noche"}));
		cBoxClase.setBounds(137, 91, 112, 20);
		contentPane.add(cBoxClase);
		
		JLabel lblListaDeSocios = new JLabel("Lista de Socios");
		lblListaDeSocios.setBounds(15, 122, 122, 20);
		contentPane.add(lblListaDeSocios);
		
		JComboBox cBoxClase_1 = new JComboBox();
		cBoxClase_1.setBounds(137, 121, 112, 20);
		contentPane.add(cBoxClase_1);
		
		JLabel lblFechaDisponibles = new JLabel("Fecha disponibles");
		lblFechaDisponibles.setBounds(15, 153, 122, 20);
		contentPane.add(lblFechaDisponibles);
		
		JComboBox cBoxClase_1_1 = new JComboBox();
		cBoxClase_1_1.setBounds(137, 152, 112, 20);
		contentPane.add(cBoxClase_1_1);
	}
	
}
