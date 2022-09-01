package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private AltaUsuario menuAltaUsuario;
    private AltaActividadDeportiva menuAltaActividad;
    private ConsultaActividadDeportiva menuConsultaActividad;
    private AltaInstitucion menuAltaInstitucion;
    private ConsultaCuponeras menuCuponeras; //consulta cuponeras actividad deportiva

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 314);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Menu Administrador");
		lblTitulo.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(12, 12, 612, 39);
		contentPane.add(lblTitulo);
		
		JButton btnAltaUsuario = new JButton("Alta Usuario");
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuAltaUsuario = new AltaUsuario();
				menuAltaUsuario.setVisible(true);
			}
		});
		btnAltaUsuario.setBounds(12, 63, 298, 25);
		contentPane.add(btnAltaUsuario);
		
		JButton btnConsultaUsuario = new JButton("Consulta de Usuario");
		btnConsultaUsuario.setBounds(12, 100, 298, 25);
		contentPane.add(btnConsultaUsuario);
		
		JButton btnModoficarUsuario = new JButton("Modificar Datos de Usuario");
		btnModoficarUsuario.setBounds(12, 137, 298, 25);
		contentPane.add(btnModoficarUsuario);
		
		JButton btnAltaActividad = new JButton("Alta de Actividad Deportiva");
                btnAltaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuAltaActividad = new AltaActividadDeportiva();
				menuAltaActividad.setVisible(true);
			}
		});
		btnAltaActividad.setBounds(12, 174, 298, 25);
		contentPane.add(btnAltaActividad);
		
		JButton btnConsultaActividad = new JButton("Consulta de Actividad Deportiva");
                btnConsultaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuConsultaActividad = new ConsultaActividadDeportiva();
				menuConsultaActividad.setVisible(true);
			}
		});
		btnConsultaActividad.setBounds(12, 211, 298, 25);
		contentPane.add(btnConsultaActividad);
		
		JButton btnAltaClase = new JButton("Alta de dictado de Clase");
		btnAltaClase.setBounds(12, 248, 298, 25);
		contentPane.add(btnAltaClase);
		
		JButton btnConsultaClase = new JButton("Consulta de dictado de Clase");
		btnConsultaClase.setBounds(322, 63, 298, 25);
		contentPane.add(btnConsultaClase);
		
		JButton btnRegistroAClase = new JButton("Registro a dictado de Clase");
		btnRegistroAClase.setBounds(322, 100, 298, 25);
		contentPane.add(btnRegistroAClase);
		
		JButton btnCrearCuponera = new JButton("Crear Cuponera");
		btnCrearCuponera.setBounds(322, 137, 298, 25);
		contentPane.add(btnCrearCuponera);
		
		JButton btnConsultaCuponera = new JButton("Consulta de Cuponeras");
		btnConsultaCuponera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuCuponeras = new ConsultaCuponeras();
				menuCuponeras.setVisible(true);
			}
		});
		btnConsultaCuponera.setBounds(326, 211, 298, 25);
		contentPane.add(btnConsultaCuponera);
		
		JButton btnAgregarActividad = new JButton("Agregar Actividad a Cuponera");
		btnAgregarActividad.setBounds(322, 174, 298, 25);
		contentPane.add(btnAgregarActividad);
		
		JButton btnAltaInstitucion = new JButton("Alta de Institución Deportiva");
		btnAltaInstitucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuAltaInstitucion = new AltaInstitucion();
				menuAltaInstitucion.setVisible(true);
			}
		});
		btnAltaInstitucion.setBounds(322, 248, 298, 25);
		contentPane.add(btnAltaInstitucion);
	}
}
