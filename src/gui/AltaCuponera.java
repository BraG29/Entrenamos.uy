package gui;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import logica.controlador.IControlador;
import logica.controlador.Fabrica;

public class AltaCuponera extends javax.swing.JFrame {

	public LocalDateTime convertirALocalDateTime(Date dateAConvertir) {
		return dateAConvertir.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public AltaCuponera() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jLabelTitulo = new javax.swing.JLabel();
		jButtonCancelar = new javax.swing.JButton();
		spinnerFechaIni = new javax.swing.JSpinner();
		textNombre = new javax.swing.JTextField();
		jPanel1 = new javax.swing.JPanel();
		botonAceptar = new javax.swing.JButton();
		labelFechaIni = new javax.swing.JLabel();

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

		spinnerFechaIni.setModel(new javax.swing.SpinnerDateModel());

		textNombre.setText("Escriba el nombre de la cuponera");
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

		textDescripcion = new JTextField();
		textDescripcion.setText("Escriba la descripcion");
		textDescripcion.setColumns(10);

		spinnerFechaFin = new JSpinner();
		spinnerFechaFin.setModel(
				new SpinnerDateModel(new Date(1662346800000L), new Date(1662346800000L), null, Calendar.DAY_OF_YEAR));

		JLabel jLabelFechaFin = new JLabel("Fecha Fin");

		JSpinner spinnerDescuento = new JSpinner();
		spinnerDescuento.setModel(new SpinnerNumberModel(0, 0, 100, 1));

		JLabel jLabelDescuento = new JLabel("Descuento");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addComponent(jButtonCancelar).addComponent(jLabelTitulo))
										.addGap(131))
								.addGroup(Alignment.TRAILING,
										layout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(textDescripcion, Alignment.LEADING)
												.addComponent(textNombre, Alignment.LEADING, 287, 287, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(spinnerDescuento, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
										.addComponent(spinnerFechaFin, GroupLayout.PREFERRED_SIZE, 192, Short.MAX_VALUE)
										.addComponent(spinnerFechaIni, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												192, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(Alignment.TRAILING)
												.addGroup(layout.createSequentialGroup().addComponent(jLabelDescuento)
														.addGap(7))
												.addComponent(jLabelFechaFin).addComponent(labelFechaIni))))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap().addComponent(jLabelTitulo).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(textDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(labelFechaIni).addComponent(
						spinnerFechaIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinnerFechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabelFechaFin))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinnerDescuento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabelDescuento))
				.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE).addComponent(jButtonCancelar))
				.addComponent(jPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE));
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
		String _nombre = textNombre.getText();
		String _descripcion = textDescripcion.getText();
		LocalDateTime _fechaInicio = convertirALocalDateTime(((Date) this.spinnerFechaIni.getValue()));
		LocalDateTime _fechaFin = convertirALocalDateTime(((Date) this.spinnerFechaFin.getValue()));
		float _descuento = Float.parseFloat(spinnerDescuento.getValue().toString());

		try {
			Fabrica fab = new Fabrica();
			IControlador controlador = fab.getInterface();
			controlador.altaCuponera(_nombre, _descripcion, _fechaInicio, _fechaFin, _descuento);

		} catch (Exception e) {
			VentanaMensaje errorVentana = new VentanaMensaje("ERROR!", "Revise los campos.", java.awt.Color.RED);
			errorVentana.setVisible(true);
			return;
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
	private javax.swing.JSpinner spinnerFechaIni;
	private javax.swing.JTextField textNombre;
	private javax.swing.JTextField textDescripcion;
	private javax.swing.JSpinner spinnerFechaFin;
	private javax.swing.JSpinner spinnerDescuento;
}
