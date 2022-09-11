package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JList;
import javax.imageio.ImageIO;
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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import logica.datatypes.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JCheckBox;

public class ModificarUsuario extends JFrame {

	private JPanel contentPane;
	private VentanaMensaje showMensaje;
	private JTable table;
	private JTextField txtFieldNombre;
	private JTextField txtFieldApellido;
	private JTextField txtFieldAnio;
	private JTextField txtFieldSitioWeb;
	private JTextField txtFieldDescripcion;
	private JTextField txtFieldInstitucion;
	private JComboBox cBoxMes;
	private JTextArea textBiografia;
	private JComboBox cBoxDia;
	private JTextField txtFieldImagen;

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
		setBounds(100, 100, 902, 396);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			Fabrica f = new Fabrica();
			IControlador sistema = f.getInterface();
			
			ArrayList<DtUsrKey> listaKeys = sistema.listarUsuarios();
			String[] arrayKeys = new String[listaKeys.size()];
			int i = 0;
			for (DtUsrKey keyUsr : listaKeys) {
				arrayKeys[i] = keyUsr.nickname + "<" + keyUsr.email + ">";
				i++;
			}
			JList listUsuarios = new JList();
			listUsuarios.setFont(new Font("Dialog", Font.BOLD, 10));
			listUsuarios.setModel(new AbstractListModel() {
				String[] values = arrayKeys;

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});

			JScrollPane scrollPaneList = new JScrollPane(listUsuarios);
			scrollPaneList.setBounds(12, 24, 259, 302);
			contentPane.add(scrollPaneList);

			JPanel panelSocio = new JPanel();
			panelSocio.setBorder(null);
			panelSocio.setBackground(SystemColor.activeCaptionBorder);
			panelSocio.setBounds(284, 12, 415, 155);
			contentPane.add(panelSocio);
			panelSocio.setLayout(null);
			//panelSocio.setVisible(false);

			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(12, 39, 70, 15);
			panelSocio.add(lblNombre);

			JLabel lblDatosUsr = new JLabel("");
			lblDatosUsr.setBounds(12, 12, 391, 15);
			panelSocio.add(lblDatosUsr);

			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(12, 66, 70, 15);
			panelSocio.add(lblApellido);

			JLabel lblFechaNac = new JLabel("Fecha de Nacimiento:");
			lblFechaNac.setBounds(12, 93, 158, 15);
			panelSocio.add(lblFechaNac);

			txtFieldNombre = new JTextField();
			txtFieldNombre.setEditable(false);
			txtFieldNombre.setBounds(86, 37, 134, 19);
			panelSocio.add(txtFieldNombre);
			txtFieldNombre.setColumns(10);

			txtFieldApellido = new JTextField();
			txtFieldApellido.setEditable(false);
			txtFieldApellido.setBounds(86, 64, 134, 19);
			panelSocio.add(txtFieldApellido);
			txtFieldApellido.setColumns(10);

			cBoxMes = new JComboBox();
			cBoxMes.setEditable(true);
			cBoxMes.setEnabled(false);
			cBoxMes.setModel(new DefaultComboBoxModel(new String[] { "-", "Enero", "Febrero", "Marzo", "Abril", "Mayo",
					"Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
			cBoxMes.setBounds(171, 88, 110, 24);
			panelSocio.add(cBoxMes);

			cBoxDia = new JComboBox();
			cBoxDia.setEditable(true);
			cBoxDia.setEnabled(false);
			cBoxDia.setBounds(293, 88, 46, 24);
			panelSocio.add(cBoxDia);

			cBoxMes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String[] dias = AltaUsuario.getDias(cBoxMes.getSelectedIndex());
					cBoxDia.setModel(new DefaultComboBoxModel(dias));
				}
			});

			txtFieldAnio = new JTextField();
			txtFieldAnio.setEditable(false);
			txtFieldAnio.setBounds(351, 88, 46, 24);
			panelSocio.add(txtFieldAnio);
			txtFieldAnio.setColumns(10);
			
			JCheckBox checkBoxEditar = new JCheckBox("Editar");
			checkBoxEditar.setBackground(SystemColor.activeCaptionBorder);
			checkBoxEditar.setBounds(337, 35, 70, 23);
			panelSocio.add(checkBoxEditar);
			
			JLabel lblImagen_1 = new JLabel("Imagen(URL):");
			lblImagen_1.setBounds(12, 128, 102, 15);
			panelSocio.add(lblImagen_1);
			
			txtFieldImagen = new JTextField();
			txtFieldImagen.setBounds(116, 126, 277, 19);
			panelSocio.add(txtFieldImagen);
			txtFieldImagen.setColumns(10);

			JPanel panelProfesor = new JPanel();
			panelProfesor.setBorder(null);
			panelProfesor.setBackground(SystemColor.activeCaptionBorder);
			panelProfesor.setBounds(283, 171, 415, 155);
			panelProfesor.setVisible(false);
			contentPane.add(panelProfesor);
			panelProfesor.setLayout(null);
			//panelProfesor.setVisible(false);

			JLabel lblInstitucion = new JLabel("Institución:");
			lblInstitucion.setBounds(12, 0, 86, 15);
			panelProfesor.add(lblInstitucion);

			JLabel lblDescripcion = new JLabel("Descripción:");
			lblDescripcion.setBounds(12, 27, 98, 15);
			panelProfesor.add(lblDescripcion);

			JLabel lblBiografia = new JLabel("Biografia:");
			lblBiografia.setBounds(12, 54, 70, 15);
			panelProfesor.add(lblBiografia);

			textBiografia = new JTextArea(0, 35);
			textBiografia.setEditable(false);
			textBiografia.setWrapStyleWord(true);
			textBiografia.setLineWrap(true);

			JScrollPane scrollPaneBiografia = new JScrollPane(textBiografia);
			scrollPaneBiografia.setBounds(90, 56, 281, 54);
			panelProfesor.add(scrollPaneBiografia);

			JLabel lblSitioWeb = new JLabel("Sitio Web:");
			lblSitioWeb.setBounds(12, 130, 86, 15);
			panelProfesor.add(lblSitioWeb);

			txtFieldSitioWeb = new JTextField();
			txtFieldSitioWeb.setEditable(false);
			txtFieldSitioWeb.setBounds(90, 128, 310, 19);
			panelProfesor.add(txtFieldSitioWeb);
			txtFieldSitioWeb.setColumns(10);

			txtFieldDescripcion = new JTextField();
			txtFieldDescripcion.setEditable(false);
			txtFieldDescripcion.setBounds(108, 25, 263, 19);
			panelProfesor.add(txtFieldDescripcion);
			txtFieldDescripcion.setColumns(10);

			txtFieldInstitucion = new JTextField();
			txtFieldInstitucion.setEditable(false);
			txtFieldInstitucion.setBounds(108, -2, 141, 19);
			panelProfesor.add(txtFieldInstitucion);
			txtFieldInstitucion.setColumns(10);

			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);				
				}
			});
			btnCancelar.setBounds(296, 334, 117, 25);
			contentPane.add(btnCancelar);

			JButton btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setBounds(592, 334, 117, 25);
			contentPane.add(btnConfirmar);

			JLabel lblElijaUnUsuario = new JLabel("Elija un Usuario:");
			lblElijaUnUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
			lblElijaUnUsuario.setBounds(12, 0, 149, 25);
			contentPane.add(lblElijaUnUsuario);
			
			JLabel lblImagen = new JLabel("");
			lblImagen.setBounds(705, 70, 180, 180);
			contentPane.add(lblImagen);
			txtFieldAnio.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (txtFieldAnio.getText().length() >= 4) // limit textfield to 3 characters
						e.consume();
				}
			});

			listUsuarios.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					checkBoxEditar.setSelected(false);
					editableFalse();
					lblDatosUsr.setText("Datos para el usuario "+listUsuarios.getSelectedValue()+":");
					DtUsuario dtU;
					int indexJList = listUsuarios.getSelectedIndex();
					dtU = sistema.getDatosUsuario(listaKeys.get(indexJList));
					if (dtU instanceof DtSocio) {
						panelProfesor.setVisible(false);
						panelSocio.setVisible(true);
						
					} else {
						panelSocio.setVisible(true);
						panelProfesor.setVisible(true);
						DtProfesor dtP = (DtProfesor)dtU;
						txtFieldInstitucion.setText(dtP.institucion);
						textBiografia.setText(dtP.biografia);
						txtFieldDescripcion.setText(dtP.descripcion);
						txtFieldSitioWeb.setText(dtP.sitioWeb);
					}
					txtFieldNombre.setText(dtU.nombre);
					txtFieldApellido.setText(dtU.apellido);
					cBoxMes.setSelectedIndex(dtU.fechaNac.getMonthValue());
					cBoxDia.setSelectedIndex(dtU.fechaNac.getDayOfMonth());
					txtFieldAnio.setText(String.valueOf(dtU.fechaNac.getYear()));
					txtFieldImagen.setText(dtU.imagenUrl);
					Image imagen = null;
					try {
						URL url = new URL(txtFieldImagen.getText());
						imagen = ImageIO.read(url).getScaledInstance(180, 180, 100);
					} catch (IOException e) {
						e.printStackTrace();
					}
					lblImagen.setIcon(new ImageIcon(imagen));
				}
			});
			checkBoxEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(checkBoxEditar.isSelected()) {
						editableTrue();
					}else {
						editableFalse();					
					}
				}
			});
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						if(!checkBoxEditar.isSelected())
							throw new IllegalArgumentException("No se ha seleccionado la opción de Editar");
						String nombre = txtFieldNombre.getText();
						String apellido = txtFieldApellido.getText();
						LocalDate fNac = LocalDate.of(Integer.parseInt(txtFieldAnio.getText()),
								cBoxMes.getSelectedIndex(),
								cBoxDia.getSelectedIndex());
						String imagen = txtFieldImagen.getText();
						if(!panelProfesor.isVisible()) {
							sistema.modificarDatos(nombre, apellido, fNac, imagen);
						}else {
							String institucion = txtFieldInstitucion.getText();
							String descripcion = txtFieldDescripcion.getText();
							String biografia = textBiografia.getText();
							String sitioWeb = txtFieldSitioWeb.getText();
							sistema.modificarDatos(nombre, apellido, fNac, imagen, institucion, descripcion, biografia, sitioWeb);
						}
					} catch (IllegalArgumentException error) {
						showMensaje = new VentanaMensaje("ERROR", error.getMessage(), Color.RED);
						showMensaje.setVisible(true);
					}
					showMensaje = new VentanaMensaje("DATOS MODIFICADOS", "Los datos se modificaron correctamente", Color.BLACK);
					showMensaje.setVisible(true);
					
				}
			});

		} catch (IllegalArgumentException error) {
			showMensaje = new VentanaMensaje("ERROR", error.getMessage(), Color.RED);
			showMensaje.setVisible(true);
		}

	}

	private void editableFalse() {
		txtFieldNombre.setEditable(false);
		txtFieldApellido.setEditable(false);
		txtFieldDescripcion.setEditable(false);
		txtFieldInstitucion.setEditable(false);
		txtFieldSitioWeb.setEditable(false);
		txtFieldAnio.setEditable(false);
		textBiografia.setEditable(false);
		cBoxMes.setEnabled(false);
		cBoxDia.setEnabled(false);
		txtFieldImagen.setEditable(false);

	}

	private void editableTrue() {
		txtFieldNombre.setEditable(true);
		txtFieldApellido.setEditable(true);
		txtFieldDescripcion.setEditable(true);
		txtFieldInstitucion.setEditable(true);
		txtFieldSitioWeb.setEditable(true);
		txtFieldAnio.setEditable(true);
		textBiografia.setEditable(true);
		cBoxMes.setEnabled(true);
		cBoxDia.setEnabled(true);
		txtFieldImagen.setEditable(true);
	}
}
