package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.controlador.Fabrica;
import logica.controlador.IControlador;

import java.awt.SystemColor;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import logica.controlador.IControlador;
//import logica.controlador.Fabrica;

public class MenuPrincipal extends JFrame {
    
    private JPanel contentPane;
    private AltaUsuario menuAltaUsuario; //º1 alta usuario
    //private ConsultaUsuario menuConsultaUsuario; //º2 consulta usuario
    private ModificarUsuario menuModificarUsuario; // º3 modificar datos usuario
    private AltaActividadDeportiva menuAltaActividad;//º4 alta actividad deportiva
    private ConsultaActividadDeportiva menuConsultaActividad; // º5 consulta de actividad deportiva
    private AltaClase menuAltaClase; // º6 alta dictado de clase
    private ConsultaDictadoClase menuConsultaDictadoClase; // º7 consulta de dictado de clase
    //private RegistroDictadoClase menuRegistroDictadoClase; // º8 Registro a dictado de clase
    private AltaCuponera menuAltaCuponera; // º9 Crear cuponera de actividades deportivas
    private AgregarActividadDeportivaCuponera menuAgregarActividad; //º10 Agregar actividad deportiva a cuponera    
    private ConsultaCuponeras menuCuponeras; //º11 Consulta de cuponeras de actividades deportivas
    private AltaInstitucion menuAltaInstitucion; // º12 Alta de institucion


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Fabrica fab = new Fabrica();
		IControlador sistema = fab.getInterface();
		sistema.initConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal(sistema);
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
	public MenuPrincipal(IControlador sistema) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				sistema.closeConnection();
			}
		});
		setTitle("Menu Principal");
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
		btnConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//menuConsultaUsuario = new ConsultaUsuario();
				//menuConsultaUsuario.setVisible(true);
			}
		});
		btnConsultaUsuario.setBounds(12, 100, 298, 25);
		contentPane.add(btnConsultaUsuario);
		
		JButton btnModoficarUsuario = new JButton("Modificar Datos de Usuario");
		btnModoficarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuModificarUsuario = new ModificarUsuario();
				menuModificarUsuario.setVisible(true);
			}
		});
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
                btnAltaClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuAltaClase = new AltaClase();
				menuAltaClase.setVisible(true);
			}
		});
		btnAltaClase.setBounds(12, 248, 298, 25);
		contentPane.add(btnAltaClase);
		
		JButton btnConsultaClase = new JButton("Consulta de dictado de Clase");
		btnConsultaClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuConsultaDictadoClase = new ConsultaDictadoClase();
				menuConsultaDictadoClase.setVisible(true);
			}
		});
		btnConsultaClase.setBounds(322, 63, 298, 25);
		contentPane.add(btnConsultaClase);
		
		JButton btnRegistroAClase = new JButton("Registro a dictado de Clase");
		btnRegistroAClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//menuRegistroDictadoClase = new RegistroDictadoClase();
				//menuRegistroDictadoClase.setVisible(true);
			}
		});
		btnRegistroAClase.setBounds(322, 100, 298, 25);
		contentPane.add(btnRegistroAClase);
		
		JButton btnCrearCuponera = new JButton("Crear Cuponera");
		btnCrearCuponera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuAltaCuponera = new AltaCuponera();
				menuAltaCuponera.setVisible(true);
			}
		});
		btnCrearCuponera.setBounds(322, 137, 298, 25);
		contentPane.add(btnCrearCuponera);
		
		JButton btnConsultaCuponera = new JButton("Consulta de Cuponeras");
		btnConsultaCuponera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuCuponeras = new ConsultaCuponeras();
				menuCuponeras.setVisible(true);
			}
		});
		btnConsultaCuponera.setBounds(322, 211, 298, 25);
		contentPane.add(btnConsultaCuponera);
		
		JButton btnAgregarActividad = new JButton("Agregar Actividad a Cuponera");
		btnAgregarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuAgregarActividad = new AgregarActividadDeportivaCuponera();
				menuAgregarActividad.setVisible(true);
			}
		});
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
