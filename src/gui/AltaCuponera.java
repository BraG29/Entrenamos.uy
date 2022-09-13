package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import logica.controlador.IControlador;
import logica.controlador.Fabrica;
import javax.swing.JComboBox;

public class AltaCuponera extends javax.swing.JFrame {

	public LocalDateTime convertirALocalDateTime(Date dateAConvertir) {
		return dateAConvertir.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public AltaCuponera() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jButtonCancelar = new javax.swing.JButton();
		spinnerDescuento = new javax.swing.JSpinner();
		textNombre = new javax.swing.JTextField();
		textDescripcion = new JTextField();
		botonAceptar = new javax.swing.JButton();
		jLabelTitulo = new javax.swing.JLabel();
		labelFechaIni = new javax.swing.JLabel();
		textFieldAnioIni = new javax.swing.JTextField();
		textFieldAnioFin = new javax.swing.JTextField();
		textFieldAnioAlta = new javax.swing.JTextField();
		comboBoxDiaIni = new javax.swing.JComboBox();
		comboBoxDiaFin = new javax.swing.JComboBox();
		comboBoxDiaAlta = new javax.swing.JComboBox();
		comboBoxMesIni = new javax.swing.JComboBox();
		comboBoxMesFin = new javax.swing.JComboBox();
		comboBoxMesAlta = new javax.swing.JComboBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabelTitulo.setFont(new java.awt.Font("Noto Sans", 0, 18));
		jLabelTitulo.setText("Alta de Cuponeras");

		jButtonCancelar.setBackground(new java.awt.Color(255, 51, 51));
		jButtonCancelar.setText("Atras");
		jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton2MouseClicked(evt);
			}
		});

		textNombre.setText("Nombre");
		textNombre.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				textNombreClaseMouseClicked(evt);
			}
		});
		textNombre.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textNombreClaseActionPerformed(evt);
			}
		});

		jPanel1.setBackground(new java.awt.Color(0, 153, 204));

		botonAceptar.setFont(new java.awt.Font("Noto Sans", 1, 18));
		botonAceptar.setText("Aceptar");
		botonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				botonAceptarMouseClicked(evt);
			}
		});
		botonAceptar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonAceptarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(botonAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)));

		labelFechaIni.setText("Fecha Inicio");

		textDescripcion.setText("Descripcion");
		textDescripcion.setColumns(10);

		JLabel jLabelFechaFin = new JLabel("Fecha Fin");

		spinnerDescuento.setModel(new SpinnerNumberModel(0, 0, 100, 1));

		JLabel jLabelDescuento = new JLabel("Descuento");

		JLabel lblFechaAlta = new JLabel("Fecha Alta");

		comboBoxMesIni.setModel(new DefaultComboBoxModel(new String[] { "-", "Enero", "Febrero", "Marzo", "Abril",
				"Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

		comboBoxMesFin.setModel(new DefaultComboBoxModel(new String[] { "-", "Enero", "Febrero", "Marzo", "Abril",
				"Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

		comboBoxMesAlta.setModel(new DefaultComboBoxModel(new String[] { "-", "Enero", "Febrero", "Marzo", "Abril",
				"Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

		comboBoxMesIni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] dias = getDias(comboBoxMesIni.getSelectedIndex());
				comboBoxDiaIni.setModel(new DefaultComboBoxModel(dias));
			}
		});

		comboBoxMesFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] dias = getDias(comboBoxMesFin.getSelectedIndex());
				comboBoxDiaFin.setModel(new DefaultComboBoxModel(dias));
			}
		});

		comboBoxMesAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] dias = getDias(comboBoxMesAlta.getSelectedIndex());
				comboBoxDiaAlta.setModel(new DefaultComboBoxModel(dias));
			}
		});

		textFieldAnioIni.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (textFieldAnioIni.getText().length() >= 4)
					e.consume();
			}
		});

		textFieldAnioFin.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (textFieldAnioFin.getText().length() >= 4)
					e.consume();
			}
		});

		textFieldAnioAlta.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (textFieldAnioAlta.getText().length() >= 4)
					e.consume();
			}
		});

		textFieldAnioIni.setColumns(10);
		textFieldAnioFin.setColumns(10);
		textFieldAnioAlta.setColumns(10);

		lblMes = new JLabel("Mes");
		lblDia = new JLabel("Dia");
		lblAo = new JLabel("Año");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup().addComponent(jLabelTitulo).addGap(131))
						.addComponent(textNombre, 287, 341, Short.MAX_VALUE)
						.addComponent(textDescripcion, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout
														.createSequentialGroup()
														.addGroup(layout.createParallelGroup(Alignment.TRAILING)
																.addComponent(comboBoxMesFin, 0, 98, Short.MAX_VALUE)
																.addComponent(
																		comboBoxMesAlta, Alignment.LEADING, 0, 98,
																		Short.MAX_VALUE)
																.addComponent(comboBoxMesIni, 0, 98, Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(Alignment.TRAILING)
																.addGroup(layout.createSequentialGroup()
																		.addGroup(layout
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(comboBoxDiaAlta, 0, 57,
																						Short.MAX_VALUE)
																				.addComponent(comboBoxDiaFin, 0, 57,
																						Short.MAX_VALUE)
																				.addComponent(comboBoxDiaIni,
																						Alignment.TRAILING, 0, 57,
																						Short.MAX_VALUE))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(layout
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(textFieldAnioAlta, 0, 0,
																						Short.MAX_VALUE)
																				.addComponent(textFieldAnioFin, 0, 0,
																						Short.MAX_VALUE)
																				.addComponent(textFieldAnioIni,
																						GroupLayout.PREFERRED_SIZE, 67,
																						GroupLayout.PREFERRED_SIZE)))
																.addGroup(layout.createSequentialGroup()
																		.addComponent(lblDia).addGap(59)
																		.addComponent(lblAo).addGap(21))))
														.addGroup(layout.createSequentialGroup().addComponent(lblMes)
																.addPreferredGap(ComponentPlacement.RELATED, 211,
																		Short.MAX_VALUE)))
												.addGap(18))
										.addGroup(layout.createSequentialGroup()
												.addComponent(spinnerDescuento, GroupLayout.DEFAULT_SIZE, 246,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(jLabelDescuento)
										.addComponent(lblFechaAlta).addComponent(jLabelFechaFin)
										.addComponent(labelFechaIni)))
						.addComponent(jButtonCancelar))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabelTitulo)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(textDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(lblMes)
								.addComponent(lblDia).addComponent(lblAo))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(comboBoxMesFin, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBoxDiaFin, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(textFieldAnioIni, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBoxDiaIni, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(labelFechaIni)
												.addComponent(comboBoxMesIni, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(15)
										.addGroup(layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(textFieldAnioFin, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabelFechaFin))
										.addGap(18)))
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxMesAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxDiaAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldAnioAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFechaAlta))
						.addGap(8)
						.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(jLabelDescuento)
								.addComponent(spinnerDescuento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(jButtonCancelar).addGap(4))
				.addComponent(jPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
		this.setVisible(false);
	}

	private void textNombreClaseActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void botonAceptarMouseClicked(java.awt.event.MouseEvent evt) {

	}

	private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
		String errorCamposClave = "Por favor rellene todos los campos claves";
		if (textFieldAnioIni.getText().isEmpty() || textFieldAnioFin.getText().isEmpty()
				|| textFieldAnioAlta.getText().isEmpty() || comboBoxMesIni.getSelectedIndex() == 0
				|| comboBoxMesFin.getSelectedIndex() == 0 || comboBoxMesAlta.getSelectedIndex() == 0
				|| comboBoxDiaIni.getSelectedIndex() == 0 || comboBoxDiaFin.getSelectedIndex() == 0
				|| comboBoxDiaAlta.getSelectedIndex() == 0) {
			throw new IllegalArgumentException(errorCamposClave);
		} else {

			String _nombre = textNombre.getText();
			String _descripcion = textDescripcion.getText();
			float _descuento = Float.parseFloat(spinnerDescuento.getValue().toString());

			LocalDate _fechaInicio = LocalDate.of(Integer.parseInt(textFieldAnioIni.getText()),
					comboBoxMesIni.getSelectedIndex(), comboBoxDiaIni.getSelectedIndex());
			LocalDate _fechaFin = LocalDate.of(Integer.parseInt(textFieldAnioFin.getText()),
					comboBoxMesFin.getSelectedIndex(), comboBoxDiaFin.getSelectedIndex());
			LocalDate _fechaAlta = LocalDate.of(Integer.parseInt(textFieldAnioAlta.getText()),
					comboBoxMesAlta.getSelectedIndex(), comboBoxDiaAlta.getSelectedIndex());

			try {
				Fabrica fab = new Fabrica();
				IControlador controlador = fab.getInterface();
				controlador.altaCuponera(_nombre, _descripcion, _fechaInicio, _fechaFin,_fechaAlta, _descuento);

			} catch (Exception e) {
				VentanaMensaje errorVentana = new VentanaMensaje("ERROR!", "Revise los campos.", java.awt.Color.RED);
				errorVentana.setVisible(true);
				return;
			}
		}
	}

	private void textNombreClaseMouseClicked(java.awt.event.MouseEvent evt) {
		if (this.textNombre.getText().equals("Escriba el nombre de la clase")) {
			this.textNombre.setText("");
		}
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AltaCuponera.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AltaCuponera.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AltaCuponera.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AltaCuponera.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AltaCuponera().setVisible(true);
			}
		});
	}

	private javax.swing.JButton botonAceptar;
	private javax.swing.JButton jButtonCancelar;
	private javax.swing.JLabel jLabelTitulo;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel labelFechaIni;
	private javax.swing.JTextField textNombre;
	private javax.swing.JTextField textDescripcion;
	private javax.swing.JSpinner spinnerDescuento;
	private javax.swing.JTextField textFieldAnioIni;
	private javax.swing.JTextField textFieldAnioFin;
	private javax.swing.JTextField textFieldAnioAlta;
	private javax.swing.JComboBox comboBoxDiaIni;
	private javax.swing.JComboBox comboBoxDiaFin;
	private javax.swing.JComboBox comboBoxDiaAlta;
	private javax.swing.JComboBox comboBoxMesIni;
	private javax.swing.JComboBox comboBoxMesFin;
	private javax.swing.JComboBox comboBoxMesAlta;
	private JLabel lblMes;
	private JLabel lblDia;
	private JLabel lblAo;

	public static String[] getDias(int mes) {
		String[] de31Dias = { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		String[] de30Dias = { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
		String[] de29Dias = { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"

		};

		switch (mes) {
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
