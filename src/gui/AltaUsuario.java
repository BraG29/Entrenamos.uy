package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Font;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JButton;
import clases.Fabrica;
import clases.IControlador;

public class AltaUsuario extends JFrame {

	private VentanaMensaje showMensaje;
	private JPanel contentPane;
	private JTextField txtFieldNick;
	private JTextField txtFieldNombre;
	private JTextField txtFieldApellido;
	private JTextField txtEmail;
	private JTextField txtFieldAnio;
	private JTextField txtFieldInstitucion;
	private JTextField txtFieldDescripcion;
	private JTextField txtFieldBiografia;
	private JTextField txtFieldSitioWeb;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AltaUsuario frame = new AltaUsuario();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AltaUsuario() {
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 448);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoUsr = new JLabel("Tipo de Usuario:");
		lblTipoUsr.setBounds(12, 38, 122, 15);
		contentPane.add(lblTipoUsr);
		
		JComboBox cBoxTipoUsr = new JComboBox();
		cBoxTipoUsr.setModel(new DefaultComboBoxModel(new String[] {"-", "Socio", "Profesor"}));
		cBoxTipoUsr.setBounds(137, 33, 112, 24);
		contentPane.add(cBoxTipoUsr);
		
		JPanel panelSocio = new JPanel();
		panelSocio.setForeground(new Color(51, 51, 51));
		panelSocio.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelSocio.setBackground(SystemColor.activeCaptionBorder);
		panelSocio.setBounds(12, 63, 374, 169);
		contentPane.add(panelSocio);
		panelSocio.setLayout(null);
		panelSocio.setVisible(false);
		
		JLabel lblNickname = new JLabel("Nickname:*");
		lblNickname.setBounds(12, 12, 82, 15);
		panelSocio.add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre:*");
		lblNombre.setBounds(12, 39, 82, 15);
		panelSocio.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:*");
		lblApellido.setBounds(12, 65, 82, 15);
		panelSocio.add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email:*");
		lblEmail.setBounds(12, 92, 82, 15);
		panelSocio.add(lblEmail);
		
		JLabel lblFechaNac = new JLabel("Fecha de Nacimiento:*");
		lblFechaNac.setBounds(12, 117, 167, 15);
		panelSocio.add(lblFechaNac);
		
		txtFieldNick = new JTextField();
		txtFieldNick.setBounds(112, 10, 174, 19);
		panelSocio.add(txtFieldNick);
		txtFieldNick.setColumns(10);
		
		txtFieldNombre = new JTextField();
		txtFieldNombre.setColumns(10);
		txtFieldNombre.setBounds(112, 37, 174, 19);
		panelSocio.add(txtFieldNombre);
		
		txtFieldApellido = new JTextField();
		txtFieldApellido.setColumns(10);
		txtFieldApellido.setBounds(112, 63, 174, 19);
		panelSocio.add(txtFieldApellido);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(112, 90, 174, 19);
		panelSocio.add(txtEmail);
		
		JComboBox cBoxMes = new JComboBox();
		cBoxMes.setModel(new DefaultComboBoxModel(
				new String[] {
						"-", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
						"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		cBoxMes.setBounds(53, 137, 113, 24);
		panelSocio.add(cBoxMes);
		
		JLabel lblMes = new JLabel("Mes:");
		lblMes.setBounds(12, 142, 48, 15);
		panelSocio.add(lblMes);
		
		JComboBox cBoxDia = new JComboBox();
		cBoxDia.setBounds(204, 137, 48, 24);
		panelSocio.add(cBoxDia);
		
		cBoxMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] dias = getDias(cBoxMes.getSelectedIndex());
				cBoxDia.setModel(new DefaultComboBoxModel(dias));
			}
		});
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setBounds(171, 142, 48, 15);
		panelSocio.add(lblDia);
		
		JLabel lblAnio = new JLabel("Año:");
		lblAnio.setBounds(259, 142, 32, 15);
		panelSocio.add(lblAnio);
		
		txtFieldAnio = new JTextField();
		txtFieldAnio.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtFieldAnio.getText().length() >= 4 ) // limit textfield to 3 characters
		            e.consume(); 
		    }  
		});
		txtFieldAnio.setBounds(300, 137, 62, 24);
		panelSocio.add(txtFieldAnio);
		txtFieldAnio.setColumns(10);
		
		JPanel panelProfesor = new JPanel();
		panelProfesor.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelProfesor.setBackground(SystemColor.activeCaptionBorder);
		panelProfesor.setForeground(Color.WHITE);
		panelProfesor.setBounds(12, 231, 374, 158);
		contentPane.add(panelProfesor);
		panelProfesor.setLayout(null);
		panelProfesor.setVisible(false);
		
		JLabel lblInstitucion = new JLabel("Institución:*");
		lblInstitucion.setBounds(12, 12, 89, 15);
		panelProfesor.add(lblInstitucion);
		
		txtFieldInstitucion = new JTextField();
		txtFieldInstitucion.setBounds(108, 10, 114, 19);
		panelProfesor.add(txtFieldInstitucion);
		txtFieldInstitucion.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripción:*");
		lblDescripcion.setBounds(12, 39, 93, 15);
		panelProfesor.add(lblDescripcion);
		
		txtFieldDescripcion = new JTextField();
		txtFieldDescripcion.setBounds(108, 32, 254, 30);
		panelProfesor.add(txtFieldDescripcion);
		txtFieldDescripcion.setColumns(10);
		
		JLabel lblBiografia = new JLabel("Biografia:");
		lblBiografia.setBounds(12, 66, 70, 15);
		panelProfesor.add(lblBiografia);
		
		txtFieldBiografia = new JTextField();
		txtFieldBiografia.setMaximumSize(new Dimension(254, 55));
		txtFieldBiografia.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtFieldBiografia.setAlignmentY(Component.TOP_ALIGNMENT);
		txtFieldBiografia.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtFieldBiografia.setToolTipText("");
		txtFieldBiografia.setHorizontalAlignment(SwingConstants.LEFT);
		txtFieldBiografia.setBounds(108, 64, 254, 30);
		panelProfesor.add(txtFieldBiografia);
		txtFieldBiografia.setColumns(10);
		
		JLabel lblSitioWeb = new JLabel("Sitio Web (URL):");
		lblSitioWeb.setBounds(12, 107, 114, 15);
		panelProfesor.add(lblSitioWeb);
		
		txtFieldSitioWeb = new JTextField();
		txtFieldSitioWeb.setBounds(130, 106, 232, 19);
		panelProfesor.add(txtFieldSitioWeb);
		txtFieldSitioWeb.setColumns(10);
		
		JLabel lblObligatorios = new JLabel("* Campos Obligatorios");
		lblObligatorios.setBounds(12, 134, 183, 15);
		panelProfesor.add(lblObligatorios);
		
		JButton bynCancelar = new JButton("Cancelar");
		bynCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		bynCancelar.setBounds(37, 386, 117, 25);
		contentPane.add(bynCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(240, 386, 117, 25);
		contentPane.add(btnConfirmar);
		
		JLabel lblTitulo = new JLabel("Alta de Usuario");
		lblTitulo.setFont(new Font("Yrsa Medium", Font.BOLD | Font.ITALIC, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 6, 412, 20);
		contentPane.add(lblTitulo);
		cBoxTipoUsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				int op = comboBoxTipoUsr.getSelectedIndex();
//				lblPrueba.setText(String.valueOf(op));
				int op = cBoxTipoUsr.getSelectedIndex();
				switch(op) {
				case 0:
					panelSocio.setVisible(false);
					panelProfesor.setVisible(false);
					break;
				case 1:
					panelSocio.setVisible(true);
					panelProfesor.setVisible(false);
					break;
				case 2:
					panelSocio.setVisible(true);
					panelProfesor.setVisible(true);
					break;
				}
			}
		});
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errorCamposClave = "Por favor rellene todos los campos claves";
				if(cBoxTipoUsr.getSelectedIndex() == 0) {
					showMensaje = new VentanaMensaje("ERROR","Seleccione un tipo de usuario",Color.RED);
					showMensaje.setVisible(true);
				}else {
					if(
							txtFieldNombre.getText().isEmpty() ||
							txtFieldNick.getText().isEmpty() ||
							txtFieldApellido.getText().isEmpty() ||
							txtEmail.getText().isEmpty() ||
							cBoxMes.getSelectedIndex() == 0 ||
							cBoxDia.getSelectedIndex() == 0 ||
							txtFieldAnio.getText().isEmpty()) {
						showMensaje = new VentanaMensaje("ERROR",errorCamposClave,Color.RED);
						showMensaje.setVisible(true);
					}else if(
							cBoxTipoUsr.getSelectedIndex() == 2 &&
							(txtFieldInstitucion.getText().isEmpty() ||
							txtFieldDescripcion.getText().isEmpty())) {
						showMensaje = new VentanaMensaje("ERROR",errorCamposClave,Color.RED);
						showMensaje.setVisible(true);
					}else {
						//Pasamos todos los controles del front estamos listo para llamar al back
						Fabrica f = new Fabrica();
						IControlador sistema = f.getInterface();
						boolean existe;
						LocalDate fechaNac;
						String nickname, nombre, apellido, email;
						nickname = txtFieldNick.getText();
						nombre = txtFieldNombre.getText();
						apellido = txtFieldApellido.getText();
						email = txtEmail.getText();
						fechaNac = LocalDate.of(
								Integer.parseInt(txtFieldAnio.getText()), cBoxMes.getSelectedIndex(),
								Integer.parseInt(cBoxDia.getSelectedItem().toString()));
						if(cBoxTipoUsr.getSelectedIndex() == 1) {
							existe = sistema.altaUsuario(nickname, nombre, apellido, email, fechaNac);
						}else {
							String institucion, descripcion, biografia, sitioWeb;
							institucion = txtFieldInstitucion.getText();
							descripcion = txtFieldDescripcion.getText();
							biografia = txtFieldBiografia.getText();
							sitioWeb = txtFieldSitioWeb.getText();
							existe = sistema.altaUsuario(
									nickname, nombre, apellido, email, fechaNac, institucion, descripcion, biografia, sitioWeb);
						}
						if(existe) {
							showMensaje = new VentanaMensaje("ERROR","En Nickname o Correo ingresado ya existe. Por favor intentelo de nuevo",Color.RED);
							showMensaje.setVisible(true);
						}
						else {
							String mensaje = "Se ha dado de alta al usuario " + nickname + " en el sistema";
							showMensaje = new VentanaMensaje("Usuario Creado", mensaje, Color.BLACK);
							setVisible(false);
						}
					}
				}
			}
		});
	}
	
	private String[] getDias(int mes) {
		String[] de31Dias = {
				"-","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
				"19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String[] de30Dias = {
				"-","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
				"19","20","21","22","23","24","25","26","27","28","29","30"
		};
		String[] de29Dias = {
				"-","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
				"19","20","21","22","23","24","25","26","27","28","29"
				
		};
		
		switch(mes) {
		case 2:
			return de29Dias;
		case 4:
		case 6:
		case 9:
		case 11:
			return de30Dias;
		}
		return de31Dias;
	}
}
