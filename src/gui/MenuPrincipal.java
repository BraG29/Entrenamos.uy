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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.awt.event.ActionEvent;
//import logica.controlador.IControlador;
//import logica.controlador.Fabrica;

public class MenuPrincipal extends JFrame {
    
//    Fabrica fab = new Fabrica();
//    IControlador controlador = fab.getInterface();

    private JPanel contentPane;
    private AltaUsuario menuAltaUsuario; //º1 alta usuario
    private ConsultaUsuario menuConsultaUsuario; //º2 consulta usuario
    private ModificarUsuario menuModificarUsuario; // º3 modificar datos usuario
    private AltaActividadDeportiva menuAltaActividad;//º4 alta actividad deportiva
    private ConsultaActividadDeportiva menuConsultaActividad; // º5 consulta de actividad deportiva
    private AltaClase menuAltaClase; // º6 alta dictado de clase
    private ConsultaDictadoClase menuConsultaDictadoClase; // º7 consulta de dictado de clase
    private RegistroDictadoClase menuRegistroDictadoClase; // º8 Registro a dictado de clase
    private AltaCuponera menuAltaCuponera; // º9 Crear cuponera de actividades deportivas
    private AgregarActividadDeportivaCuponera menuAgregarActividad; //º10 Agregar actividad deportiva a cuponera    
    private ConsultaCuponeras menuCuponeras; //º11 Consulta de cuponeras de actividades deportivas
    private AltaInstitucion menuAltaInstitucion; // º12 Alta de institucion


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceApp");
//		EntityManager em = emf.createEntityManager();
//		
//		try {
//			
//			em.getTransaction().begin();
//		}catch(Exception e) {
//			em.getTransaction().rollback();
//		}
//		
//		em.close();
//		emf.close();

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
		setTitle("Menu Principal");
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 355);
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
				menuConsultaUsuario = new ConsultaUsuario();
				menuConsultaUsuario.setVisible(true);
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
				menuRegistroDictadoClase = new RegistroDictadoClase();
				menuRegistroDictadoClase.setVisible(true);
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
		
		JButton btnCargarDatos = new JButton("Cargar Datos de Prueba");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fabrica fab = new Fabrica();
				cargarSocios(fab);
				cargarInstituciones(fab);
				cargarProfesores(fab);
			}
		});
		btnCargarDatos.setBounds(12, 285, 298, 25);
		contentPane.add(btnCargarDatos);
	}
	
	public void cargarSocios(Fabrica fab) {
		IControlador sistema = fab.getInterface();
		List<String> nicks = Arrays.asList(
				new String[] {
						"Emi71",
						"caro",
						"euge",
						"guille",
						"sergiop",
						"andy",
						"tonyp",
						"m1k4",
						"charly"
				});
		List<String> nombres= Arrays.asList(
				new String[] {
						"Emiliano",
						"Carolina",
						"Eugenia",
						"Guillermo",
						"Sergio",
						"Andrés",
						"Antonio",
						"Micaela",
						"Carlos"
				});
		List<String> apellidos = Arrays.asList(
				new String[] {
						"Lucas",
						"Omega",
						"Williams",
						"Hector",
						"Perez",
						"Roman",
						"Paz",
						"Lopez",
						"Boston"
				});
		List<String> emails = Arrays.asList(
				new String[] {
					"emi71@gmail.com",
					"caro@gmail.com",
					"e.will@gmail.com",
					"ghector@gmail.com",
					"sergi@gmail.com.uy",
					"chino@gmail.org.uy",
					"eltony@gmail.org.uy",
					"mika@gmail.com.ar",
					"charly@gmail.com.uy"
				});
		List<LocalDate> fechas = Arrays.asList(
				new LocalDate[] {
						LocalDate.of(1971,12,31), 
						LocalDate.of(1983,11,15), 
						LocalDate.of(1990,4,15),
						LocalDate.of(1959,5,15),
						LocalDate.of(1951,1,28),
						LocalDate.of(1976,3,17), 
						LocalDate.of(1955,2,14), 
						LocalDate.of(1987,2,23),
						LocalDate.of(1937,5,8)   
				});
		List<String> imagenes = Arrays.asList(
				new String[] {
						"https://bit.ly/3lxoBvZ",
						"https://bit.ly/3AfcJER",
						"https://bit.ly/3Afz59x",
						"https://bit.ly/2XkrKH9",
						"https://bit.ly/3ElkVG2",
						"https://bit.ly/3hDWgTD",
						"https://bit.ly/3Ai4jMW",
						"https://bit.ly/3zglsWf",
						"https://bit.ly/2YRWDTQ"
				});
		for(int i=0; i<nicks.size(); i++) {
			sistema.altaUsuario(
					nicks.get(i), nombres.get(i), apellidos.get(i), emails.get(i), fechas.get(i), imagenes.get(i));
		}
				
	}
	
	public void cargarInstituciones(Fabrica fab) {
		IControlador sistema = fab.getInterface();
		List<String> nombres = Arrays.asList(
				new String[] {
						"Instituto Natural",
						"Fuerza Bruta",
						"Telón",
						"Olympic",
				});
		List<String> descripciones = Arrays.asList(
				new String[] {
						"Clases de gimnasia, aeróbica, spinning y yoga. ",
						"Gimnasio especializado en el desarrollo de la "
						+ "musculatura.",
						"Actividades deportivas para todas las edades",
						"Gimnasia y Aparatos ",
				});
		List<String> sitiosWeb = Arrays.asList(
				new String[] {
						"https://www.inatural.com/",
						"https://www.musculos.com/",
						"https://telon.com.uy/",
						"https://www.olympic21.com/",
				});
		
		for(int i = 0; i < nombres.size(); i++) {
			sistema.altaInstitucion(
					nombres.get(i), descripciones.get(i), sitiosWeb.get(i));
		}
	}
	
	public void cargarProfesores(Fabrica fab) {
		IControlador sistema = fab.getInterface();
		List<String> nicks = Arrays.asList(
				new String[] {
						"viktor",
						"denis",
						"clazar",
						"TheBoss",
						"Nelson",
						"lale",
						"prisc",
						"dagost",
						"aldo"
				});
		List<String> nombres= Arrays.asList(
				new String[] {
						"Victor",
						"Denis",
						"Carla",
						"Bruno",
						"Luis",
						"Laura",
						"Priscila",
						"Daiana",
						"Aldo"
				});		
//		List<String> = Arrays.asList(
//						new String[] {
//								"",
//								"",
//								"",
//								"",
//								"",
//								"",
//								"",
//								"",
//								""
//						});
		List<String> apellidos = Arrays.asList(
				new String[] {
						"Perez",
						"Miguel",
						"Lazaro",
						"Sosa",
						"Nelson",
						"Leyes",
						"Pappo",
						"Agostini",
						"Vivaldi",
				});
		List<String> emails = Arrays.asList(
				new String[] {
					"vperez@fuerza.com",
					"den80@fuerza.com",
					"claz4r0@hotmail.com",
					"bruceTheBoss@gmail.c",
					"nelson@hotmail.com",
					"la_le@outlook.com",
					"pripa@gmail.com",
					"d_1940_ago@gmail.co",
					"aldo@ outlook.com"
				});
		List<LocalDate> fechas = Arrays.asList(
				new LocalDate[] {
						LocalDate.of(1977,1,1), 
						LocalDate.of(1980,6,14), 
						LocalDate.of(1953,6,22),
						LocalDate.of(1949,9,23),
						LocalDate.of(1998,1,1),
						LocalDate.of(1987,2,14), 
						LocalDate.of(1981,8,13), 
						LocalDate.of(1940,3,5),
						LocalDate.of(1952,7,17)   
				});
		List<String> imagenes = Arrays.asList(
				new String[] {
						"https://bit.ly/3zetdMl",
						"https://bit.ly/3lKq8Px",
						"https://bit.ly/2VJvT6S",
						"https://bit.ly/3kdT9TV",
						"https://bit.ly/3lxsDo7",
						"https://bit.ly/3EmlY8F",
						"https://static9.depositphotos.com/1687987/1171/i/450/depositphotos_11715353-stock-photo-young-woman-portrait.jpg",
						"https://bit.ly/3hB3zvo",
						"https://bit.ly/2VLnzUj"
				});
		List<String> instituciones = Arrays.asList(
				new String[] {
						"Fuerza Bruta",//1
						"Telón",//2
						"Instituto Natural",//3
						"Fuerza Bruta",//4
						"Telón",//5
						"Telón",//6
						"Olympic",//7
						"Olympic",//8
						"Telón",//9
				});
		List<String> descripciones = Arrays.asList(
				new String[] {
						"Victor es un apasionado de los músculos. Sus clases "
						+"son organizadas en función de distintos aparatos y "
						+"pesas con el objetivo de desarrollar músculos",
						
						"A Denis le interesan los deportes con pelota, "
						+ "principalmente el voleibol y el handball ",
						
						"Carlos es un profesor muy divertido cuyas clases de "
						+ "aeróbica están cargadas de energía.",
						
						"Bruno es un ex-boxeardor que busca "
						+ "entrenar a futuros campeones.",
						
						"Profesor de natación. Especializado en braza y "
						+ "mariposa",
						
						"Luego de una exitosa carrera como jugadora de futbol "
						+ "profesional. Laura dedica sus clases a enseñar tácticas "
						+ "de futbol",
						
						"Laura tiene un gran interés por los deportes olímpicos.",
						
						"Profesora dedicada y exigente. No acepta un “no "
						+ "puedo” como respuesta",
						
						"Dada su gran estatura Aldo siempre jugó al basquetbol, "
						+ "hoy se dedica a enseñarlo."
				});		
		List<String> biografias = Arrays.asList(
		new String[] {
				"Victor nació en Moscow en 1977. En "
				+ "el año 2005 emigró a Uruguay luego "
				+ "de quedar encantado con el país en "
				+ "un viaje turístico.",
				
				"Denis fue un jugador de voleibol "
				+ "profesional. ",
				
				"El interés por la actividad física llevo "
				+ "a Carlos a dejar su trabajo en un "
				+ "estudio contable y abrir su propio "
				+ "gimnasio."
				+ "",
				
				"Bruno, mejor conocido como "
				+ "Bruce en el ring, compitió "
				+ "como boxeador entre los años "
				+ "60s y 70s.",
				
				"",//vacio
				
				"Jugadora profesional de futbol desde "
				+ "2010 a 2020.",
				
				"",//vacio
				
				"",//vacio
				
				""//vacio
		});
		List<String> sitiosWeb = Arrays.asList(
		new String[] {
				"http://www.vikgym.com/",
				"http://www.depecho.com/",
				"http://www.enforma.com/",
				"http://www.bruce.net/",
				"http://www.nelson.uy/",
				"http://www.laley.com/",
				"http://www.pi314.net/",
				"http://www.dygym.com/",
				"http://www.sportsaldo.net/"
		});
		for(int i=0; i<nicks.size(); i++) {
			sistema.altaUsuario(
					nicks.get(i), nombres.get(i), apellidos.get(i), emails.get(i), fechas.get(i), imagenes.get(i),
					instituciones.get(i), descripciones.get(i), biografias.get(i), sitiosWeb.get(i));
		}

	}

}
