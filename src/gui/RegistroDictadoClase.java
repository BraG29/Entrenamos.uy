package gui;

import java.util.ArrayList;
import logica.controlador.Fabrica;
import logica.controlador.IControlador;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class RegistroDictadoClase extends javax.swing.JFrame {
	private VentanaMensaje showMensaje;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnAgregar;
	private javax.swing.JComboBox<String> comboBoxActividad;
	private javax.swing.JComboBox<String> comboBoxInstitucion;
	private javax.swing.JComboBox<String> comboBoxClase;
	private javax.swing.JComboBox<String> comboBoxSocios;
	private javax.swing.JLabel labelTitulo;
	private javax.swing.JLabel labelInstitucion;
	private javax.swing.JLabel labelActividad;
	private javax.swing.JLabel labelClases;
	private javax.swing.JLabel labelSocios;

	public RegistroDictadoClase() {
		initComponents();
		this.labelActividad.setVisible(false);
		this.labelClases.setVisible(false);
		this.labelSocios.setVisible(false);
		this.comboBoxActividad.setVisible(false);
		this.comboBoxClase.setVisible(false);
		this.comboBoxSocios.setVisible(false);

		Fabrica fab = new Fabrica();
		IControlador controlador = fab.getInterface();
		ArrayList<String> arrStr = controlador.getNombreInstituciones();

		for (int i = 0; i < arrStr.size(); i++) {
			this.comboBoxInstitucion.addItem(arrStr.get(i));
		}
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		btnAgregar = new javax.swing.JButton();
		btnCancelar = new javax.swing.JButton();
		labelTitulo = new javax.swing.JLabel();
		labelInstitucion = new javax.swing.JLabel();
		labelActividad = new javax.swing.JLabel();
		labelClases = new javax.swing.JLabel();
		labelSocios = new javax.swing.JLabel();
		comboBoxInstitucion = new javax.swing.JComboBox<>();
		comboBoxActividad = new javax.swing.JComboBox<>();
		comboBoxClase = new javax.swing.JComboBox<>();
		comboBoxSocios = new javax.swing.JComboBox<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		labelTitulo.setFont(new java.awt.Font("Noto Sans", 0, 18));
		labelTitulo.setText("Registro a Dictado de Clases");
		labelInstitucion.setText("Institución");
		labelActividad.setText("Actividad Deportiva");
		labelClases.setText("Clases");
		labelSocios.setText("Socios");

		btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
		btnCancelar.setText("Atras");
		btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnCancelarMouseClicked(evt);
			}
		});

		comboBoxInstitucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
		comboBoxInstitucion.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboInstiActionPerformed(evt);
			}
		});

		comboBoxActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
		comboBoxActividad.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboActividadActionPerformed(evt);
			}
		});

		comboBoxClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
		comboBoxClase.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboClaseActionPerformed(evt);
			}
		});

		btnAgregar.setText("Agregar");
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBackground(new Color(30, 144, 255));
		btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnAgregarMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(
												btnCancelar)
												.addPreferredGap(ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
												.addComponent(btnAgregar).addGap(22))
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(Alignment.LEADING).addComponent(labelTitulo)
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(comboBoxActividad, Alignment.LEADING, 0,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(comboBoxInstitucion, Alignment.LEADING, 0,
																		158, Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(Alignment.LEADING)
																.addComponent(labelInstitucion)
																.addComponent(labelActividad)))
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
																.addComponent(comboBoxSocios, 0,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(comboBoxClase, 0, 158, Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(layout.createParallelGroup(Alignment.LEADING)
																.addComponent(labelSocios).addComponent(labelClases))))
												.addContainerGap(139, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(labelTitulo).addGap(18)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxInstitucion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(labelInstitucion))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxActividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(labelActividad))
						.addGap(8)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxClase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(labelClases))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxSocios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(labelSocios))
						.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnCancelar)
								.addComponent(btnAgregar))
						.addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
	}

	private void comboInstiActionPerformed(java.awt.event.ActionEvent evt) {

		if (comboBoxInstitucion.getSelectedIndex() != 0) {
			Fabrica fab = new Fabrica();
			IControlador controlador = fab.getInterface();

			comboBoxActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

			ArrayList<String> arrStr = controlador
					.consultarActividadDepo(comboBoxInstitucion.getSelectedItem().toString());
			for (int i = 0; i < arrStr.size(); i++) {
				comboBoxActividad.addItem(arrStr.get(i));
			}
			this.comboBoxActividad.setVisible(true);
			this.labelActividad.setVisible(true);

		} else {
			comboBoxActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
			comboBoxClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
			comboBoxSocios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
			this.comboBoxActividad.setVisible(false);
			this.comboBoxClase.setVisible(false);
			this.comboBoxSocios.setVisible(false);
			this.labelActividad.setVisible(false);
			this.labelClases.setVisible(false);
			this.labelSocios.setVisible(false);
		}
	}

	private void comboActividadActionPerformed(java.awt.event.ActionEvent evt) {
		if (comboBoxActividad.getSelectedIndex() != 0) {
			Fabrica fab = new Fabrica();
			IControlador controlador = fab.getInterface();

			comboBoxClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

			ArrayList<String> arrStr = controlador
					.getClasesVigentesPorActiDepo(comboBoxActividad.getSelectedItem().toString());
			for (int i = 0; i < arrStr.size(); i++) {
				comboBoxClase.addItem(arrStr.get(i));
			}
			this.comboBoxClase.setVisible(true);
			this.labelClases.setVisible(true);

		} else {
			comboBoxClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
			this.comboBoxClase.setVisible(false);
			this.labelClases.setVisible(false);
		}
	}

	private void comboClaseActionPerformed(java.awt.event.ActionEvent evt) {
		if (comboBoxClase.getSelectedIndex() != 0) {
			Fabrica fab = new Fabrica();
			IControlador controlador = fab.getInterface();

			comboBoxSocios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

			ArrayList<String> arrStr = controlador.getClasesPorActiDepo(comboBoxActividad.getSelectedItem().toString());
			for (int i = 0; i < arrStr.size(); i++) {
				comboBoxSocios.addItem(arrStr.get(i));
			}

			this.comboBoxSocios.setVisible(true);
			this.labelSocios.setVisible(true);

		} else {
			comboBoxSocios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
			this.comboBoxSocios.setVisible(false);
			this.labelSocios.setVisible(false);
		}
	}

	private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {
		try {
			if (comboBoxInstitucion.getSelectedIndex() == 0 && comboBoxActividad.getSelectedIndex() == 0
					&& comboBoxClase.getSelectedIndex() == 0 && comboBoxSocios.getSelectedIndex() == 0) {
				throw new IllegalArgumentException("Campos Incompletos");
			} else {
				Fabrica f = new Fabrica();
				IControlador sistema = f.getInterface();
				String clase, socio;
				clase = comboBoxClase.getSelectedItem().toString();
				socio = comboBoxSocios.getSelectedItem().toString();

				sistema.registroDictadoDeClase(clase, socio);

				String mensajeConfirmacion = "Se ha registrado el usuario a esa clase.";
				showMensaje = new VentanaMensaje("Usuario Creado", mensajeConfirmacion, Color.BLACK);
				showMensaje.setVisible(true);
			}

		} catch (Exception error) {
			showMensaje = new VentanaMensaje("ERROR", error.getMessage(), Color.RED);
			showMensaje.setVisible(true);
		}
	}

	private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {
		this.setVisible(false);
	}
}
