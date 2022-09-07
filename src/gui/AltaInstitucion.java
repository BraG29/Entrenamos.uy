package gui;

import java.awt.BorderLayout;
import logica.controlador.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AltaInstitucion extends JFrame {

	private JPanel contentPane;
	private JTextField txtIngreseNombreInst;
	private JTextField txtIngreseDescripcion;
	private JTextField txtIngreseURL;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AltaInstitucion frame = new AltaInstitucion();
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
	public AltaInstitucion() {
		setTitle("Alta institución deportiva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 290);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("(*) Nombre:");
		lblNombre.setBounds(42, 23, 80, 15);
		contentPane.add(lblNombre);
		txtIngreseNombreInst = new JTextField(); 
		txtIngreseNombreInst.setForeground(Color.GRAY);
		txtIngreseNombreInst.setText("Ingrese nombre de institución");
		txtIngreseNombreInst.setBounds(126, 21, 328, 19);
		contentPane.add(txtIngreseNombreInst);
		txtIngreseNombreInst.setColumns(10);
		txtIngreseNombreInst.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (txtIngreseNombreInst.getText().equals("Ingrese nombre de institución")){ //si el texto es igual a eso
					txtIngreseNombreInst.setText(""); //dejo el campo vacio
					txtIngreseNombreInst.setForeground(Color.black);//color de la fuente en negro
				}
			}
		});
		
		
		JLabel lblDescripcion = new JLabel("(*) Descripcion:");
		lblDescripcion.setBounds(12, 81, 111, 15);
		contentPane.add(lblDescripcion);	
		txtIngreseDescripcion = new JTextField();	
		txtIngreseDescripcion.setForeground(Color.GRAY);
		txtIngreseDescripcion.setText("Ingrese una descripción");
		txtIngreseDescripcion.setColumns(10);
		txtIngreseDescripcion.setBounds(126, 79, 328, 19);
		contentPane.add(txtIngreseDescripcion);	
		txtIngreseDescripcion.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (txtIngreseDescripcion.getText().equals("Ingrese una descripción")){ //si el texto es igual a eso
					txtIngreseDescripcion.setText(""); //dejo el campo vacio
					txtIngreseDescripcion.setForeground(Color.black);//color de la fuente en negro
				}
			}
		});
		
		
		JLabel lblUrl = new JLabel("(*)  URL:");
		lblUrl.setBounds(66, 138, 56, 15);
		contentPane.add(lblUrl);	
		txtIngreseURL = new JTextField();
		txtIngreseURL.setForeground(Color.GRAY);
		txtIngreseURL.setText("Ingrese una URL");
		txtIngreseURL.setColumns(10);
		txtIngreseURL.setBounds(126, 136, 328, 19);
		contentPane.add(txtIngreseURL);
		txtIngreseURL.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(txtIngreseURL.getText().equals("Ingrese una URL")) {
					txtIngreseURL.setText("");
					txtIngreseURL.setForeground(Color.black);
				}
			}
		});
		
	
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(250, 228, 117, 25);
		contentPane.add(btnCancelar);
		
		JLabel lblErrorNombre = new JLabel("Por favor, ingrese un nombre.");
		lblErrorNombre.setBounds(136, 52, 212, 15);
		contentPane.add(lblErrorNombre);
		lblErrorNombre.setVisible(false);
		
		JLabel lblErrorDesc = new JLabel("Por favor, ingrese una descripción.");
		lblErrorDesc.setBounds(136, 110, 259, 15);
		contentPane.add(lblErrorDesc);
		lblErrorDesc.setVisible(false);
		
		JLabel lblErrorURL = new JLabel("Por favor, ingrese una URL.");
		lblErrorURL.setBounds(136, 167, 212, 15);
		contentPane.add(lblErrorURL);
		lblErrorURL.setVisible(true);
		
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Fabrica fab = new Fabrica();
				IControlador controlador = fab.getInterface();
				String nombreInst, descripcion, URL;
		
				//NOMBRE
				if (txtIngreseNombreInst.getText().equals("Ingrese nombre de institución") || txtIngreseNombreInst.getText().equals("")){ 
					txtIngreseNombreInst.setForeground(Color.RED);
					lblErrorNombre.setForeground(Color.RED);
					txtIngreseNombreInst.setBorder(BorderFactory.createLineBorder(Color.RED));
					lblErrorNombre.setVisible(true);
					
				}
				//DESC
				if (txtIngreseDescripcion.getText().equals("Ingrese una descripción") || txtIngreseDescripcion.getText().equals("")){ 
					txtIngreseDescripcion.setForeground(Color.RED);
					lblErrorDesc.setForeground(Color.RED);
					txtIngreseDescripcion.setForeground(Color.RED);
					lblErrorDesc.setVisible(true);

				}
				//URL
				if(txtIngreseURL.getText().equals("Ingrese o pegue una URL") || txtIngreseURL.getText().equals("")) {
					txtIngreseURL.setForeground(Color.RED);
					lblErrorURL.setForeground(Color.RED);
					txtIngreseURL.setBorder(BorderFactory.createLineBorder(Color.RED));
					lblErrorURL.setVisible(true);
	
				}
				
				nombreInst = txtIngreseNombreInst.getText();
				descripcion = txtIngreseDescripcion.getText();
				URL = txtIngreseURL.getText();
				
				controlador.altaInstitucion(nombreInst, descripcion, URL);
				
			}
		});
		btnCrear.setBounds(106, 228, 117, 25);
		contentPane.add(btnCrear);
		
		
		
		
		JLabel lblCamposObligatorios = new JLabel("* Campos obligatorios");
		lblCamposObligatorios.setBounds(146, 201, 161, 15);
		contentPane.add(lblCamposObligatorios);
	}
}
