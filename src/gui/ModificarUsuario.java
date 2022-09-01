package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.controlador.Fabrica;
import logica.controlador.IControlador;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;

public class ModificarUsuario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtFieldNombre;
	private JTextField txtFieldApellido;
	private JTextField txtFieldAnio;
	private JTextField txtfieldSitioWeb;
	private JTextField txtFieldDescripcion;
	private JTextField txtFieldInstitucion;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ModificarUsuario frame = new ModificarUsuario();
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
	public ModificarUsuario() {
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 363);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList listUsuarios = new JList();
		listUsuarios.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JScrollPane scrollPaneList = new JScrollPane(listUsuarios);
		scrollPaneList.setBounds(12, 24, 186, 302);
		contentPane.add(scrollPaneList);
		
		JPanel panelSocio = new JPanel();
		panelSocio.setBorder(null);
		panelSocio.setBackground(SystemColor.activeCaptionBorder);
		panelSocio.setBounds(203, 12, 415, 122);
		contentPane.add(panelSocio);
		panelSocio.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 39, 70, 15);
		panelSocio.add(lblNombre);
		
		JLabel lblDatosUsr = new JLabel("Datos para el usuario:");
		lblDatosUsr.setBounds(12, 12, 412, 15);
		panelSocio.add(lblDatosUsr);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(12, 66, 70, 15);
		panelSocio.add(lblApellido);
		
		JLabel lblFechaNac = new JLabel("Fecha de Nacimiento:");
		lblFechaNac.setBounds(12, 93, 158, 15);
		panelSocio.add(lblFechaNac);
		
		txtFieldNombre = new JTextField();
		txtFieldNombre.setBounds(86, 37, 134, 19);
		panelSocio.add(txtFieldNombre);
		txtFieldNombre.setColumns(10);
		
		txtFieldApellido = new JTextField();
		txtFieldApellido.setBounds(86, 64, 134, 19);
		panelSocio.add(txtFieldApellido);
		txtFieldApellido.setColumns(10);
		
		JComboBox cBoxMes = new JComboBox();
		cBoxMes.setModel(new DefaultComboBoxModel(
				new String[] {
						"-", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
						"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		cBoxMes.setBounds(171, 88, 110, 24);
		panelSocio.add(cBoxMes);
		
		JComboBox cBoxDia = new JComboBox();
		cBoxDia.setBounds(293, 88, 46, 24);
		panelSocio.add(cBoxDia);
		
		cBoxMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] dias = AltaUsuario.getDias(cBoxMes.getSelectedIndex());
				cBoxDia.setModel(new DefaultComboBoxModel(dias));
			}
		});
		
		txtFieldAnio = new JTextField();
		txtFieldAnio.setBounds(351, 88, 46, 24);
		panelSocio.add(txtFieldAnio);
		txtFieldAnio.setColumns(10);
		
		JPanel panelProfesor = new JPanel();
		panelProfesor.setBorder(null);
		panelProfesor.setBackground(SystemColor.activeCaptionBorder);
		panelProfesor.setBounds(203, 135, 415, 155);
		contentPane.add(panelProfesor);
		panelProfesor.setLayout(null);
		
		JLabel lblInstitucion = new JLabel("Institución:");
		lblInstitucion.setBounds(12, 0, 86, 15);
		panelProfesor.add(lblInstitucion);
		
		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(12, 27, 98, 15);
		panelProfesor.add(lblDescripcion);
		
		JLabel lblBiografia = new JLabel("Biografia:");
		lblBiografia.setBounds(12, 54, 70, 15);
		panelProfesor.add(lblBiografia);
		
		JTextArea textBiografia = new JTextArea(0,35);
		textBiografia.setWrapStyleWord(true);
		textBiografia.setLineWrap(true);
		
		JScrollPane scrollPaneBiografia = new JScrollPane(textBiografia);
		scrollPaneBiografia.setBounds(90, 56, 281, 54);
		panelProfesor.add(scrollPaneBiografia);
		
		JLabel lblSitioWeb = new JLabel("Sitio Web:");
		lblSitioWeb.setBounds(12, 130, 86, 15);
		panelProfesor.add(lblSitioWeb);
		
		txtfieldSitioWeb = new JTextField();
		txtfieldSitioWeb.setBounds(90, 128, 310, 19);
		panelProfesor.add(txtfieldSitioWeb);
		txtfieldSitioWeb.setColumns(10);
		
		txtFieldDescripcion = new JTextField();
		txtFieldDescripcion.setBounds(108, 25, 263, 19);
		panelProfesor.add(txtFieldDescripcion);
		txtFieldDescripcion.setColumns(10);
		
		txtFieldInstitucion = new JTextField();
		txtFieldInstitucion.setBounds(108, -2, 141, 19);
		panelProfesor.add(txtFieldInstitucion);
		txtFieldInstitucion.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(223, 301, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(484, 301, 117, 25);
		contentPane.add(btnConfirmar);
		
		JLabel lblElijaUnUsuario = new JLabel("Elija un Usuario:");
		lblElijaUnUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
		lblElijaUnUsuario.setBounds(12, 0, 149, 25);
		contentPane.add(lblElijaUnUsuario);
		txtFieldAnio.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (txtFieldAnio.getText().length() >= 4 ) // limit textfield to 3 characters
		            e.consume(); 
		    }  
		});
		
	}
}
