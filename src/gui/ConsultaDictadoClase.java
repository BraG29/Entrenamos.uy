package gui;

import java.util.ArrayList;
import logica.controlador.Fabrica;
import logica.controlador.IControlador;
import logica.datatypes.DtActividadDeportiva;
import logica.datatypes.DtClase;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ConsultaDictadoClase extends javax.swing.JFrame {
	private ArrayList<String> listaClases = new ArrayList<>();
	private javax.swing.JButton btnCancelar;
	private javax.swing.JComboBox<String> comboBoxActividad;
	private javax.swing.JComboBox<String> comboBoxInstitucion;
	private javax.swing.JComboBox<String> comboBoxClase;
	private javax.swing.JLabel labelTitulo;
	private javax.swing.JLabel labelInstitucion;
	private javax.swing.JLabel labelActividad;
	private javax.swing.JLabel labelClases;
	private javax.swing.JLabel labelCantMin;
	private javax.swing.JLabel labelFecha;
	private javax.swing.JLabel labelHoraIni;
	private javax.swing.JLabel labelURL;
	private javax.swing.JLabel labelCantMax;
	private javax.swing.JLabel labelNombre;
	private javax.swing.JLabel labelRegistro;

	public ConsultaDictadoClase() {
		initComponents();

		this.labelNombre.setVisible(false);
		this.labelFecha.setVisible(false);
		this.labelHoraIni.setVisible(false);
		this.labelCantMin.setVisible(false);
		this.labelCantMax.setVisible(false);
		this.labelClases.setVisible(false);
		this.labelActividad.setVisible(false);
		this.labelURL.setVisible(false);
		this.labelRegistro.setVisible(false);
		this.comboBoxClase.setVisible(false);
		this.comboBoxActividad.setVisible(false);

		Fabrica fab = new Fabrica();
		IControlador controlador = fab.getInterface();
		ArrayList<String> arrStr = controlador.getNombreInstituciones();

		for (int i = 0; i < arrStr.size(); i++) {
			this.comboBoxInstitucion.addItem(arrStr.get(i));
		}
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		btnCancelar = new javax.swing.JButton();
		labelTitulo = new javax.swing.JLabel();
		labelInstitucion = new javax.swing.JLabel();
		labelClases = new javax.swing.JLabel();
		labelNombre = new javax.swing.JLabel();
		labelFecha = new javax.swing.JLabel();
		labelHoraIni = new javax.swing.JLabel();
		labelCantMin = new javax.swing.JLabel();
		labelCantMax = new javax.swing.JLabel();
		labelActividad = new javax.swing.JLabel();
		labelURL = new javax.swing.JLabel();
		labelRegistro = new javax.swing.JLabel();
		comboBoxInstitucion = new javax.swing.JComboBox<>();
		comboBoxActividad = new javax.swing.JComboBox<>();
		comboBoxClase = new javax.swing.JComboBox<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		labelTitulo.setFont(new java.awt.Font("Noto Sans", 0, 18));
		labelTitulo.setText("Consulta de Dictado de Clases");
		labelNombre.setText("Nombre");
		labelInstitucion.setText("Institución");
		labelClases.setText("Clases");
		labelFecha.setText("Fecha");
		labelHoraIni.setText("HoraIni");
		labelCantMin.setText("CantMin");
		labelCantMax.setText("CantMax");
		labelActividad.setText("Actividad Deportiva");
		labelURL.setText("URL");
		labelRegistro.setText("Registro");

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
				comboActiActionPerformed(evt);
			}
		});

		comboBoxClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
		comboBoxClase.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboClaseActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout
										.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addComponent(labelURL, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
												.addComponent(labelTitulo).addGroup(layout.createSequentialGroup()
														.addComponent(comboBoxClase, GroupLayout.PREFERRED_SIZE, 158,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(labelClases))
												.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(labelCantMax, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
														.addComponent(labelCantMin, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(labelHoraIni, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(labelFecha, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(labelNombre, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(comboBoxActividad, Alignment.LEADING, 0,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(comboBoxInstitucion, Alignment.LEADING, 0,
																		158, Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(Alignment.LEADING)
																.addComponent(labelInstitucion)
																.addComponent(labelActividad))))
										.addGap(67))
								.addGroup(layout.createSequentialGroup()
										.addComponent(labelRegistro, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addComponent(btnCancelar)));
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
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelNombre)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelFecha)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelHoraIni)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelCantMin)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelCantMax)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(labelURL, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(labelRegistro)
								.addComponent(btnCancelar))
						.addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
	}

	private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {
		this.setVisible(false);
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
			this.comboBoxActividad.setVisible(false);
			this.comboBoxClase.setVisible(false);
			this.labelActividad.setVisible(false);
			this.labelClases.setVisible(false);
			this.labelNombre.setVisible(false);
			this.labelFecha.setVisible(false);
			this.labelHoraIni.setVisible(false);
			this.labelCantMin.setVisible(false);
			this.labelCantMax.setVisible(false);
			this.labelURL.setVisible(false);
			this.labelRegistro.setVisible(false);
		}
	}

	private void comboActiActionPerformed(java.awt.event.ActionEvent evt) {

		if (comboBoxActividad.getSelectedIndex() != 0) {
			Fabrica fab = new Fabrica();
			IControlador controlador = fab.getInterface();

			comboBoxClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

			ArrayList<String> arrStr = controlador.getClasesPorActiDepo(comboBoxActividad.getSelectedItem().toString());
			for (int i = 0; i < arrStr.size(); i++) {
				comboBoxClase.addItem(arrStr.get(i));
			}
			this.comboBoxClase.setVisible(true);
			this.labelClases.setVisible(true);

		} else {
			comboBoxClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
			this.comboBoxClase.setVisible(false);
			this.labelClases.setVisible(false);
			this.labelNombre.setVisible(false);
			this.labelFecha.setVisible(false);
			this.labelHoraIni.setVisible(false);
			this.labelCantMin.setVisible(false);
			this.labelCantMax.setVisible(false);
			this.labelURL.setVisible(false);
			this.labelRegistro.setVisible(false);
		}
	}

	private void comboClaseActionPerformed(java.awt.event.ActionEvent evt) {

		if (comboBoxClase.getSelectedIndex() != 0) {
			Fabrica fab = new Fabrica();
			IControlador controlador = fab.getInterface();
			String nombreInstitucion = this.comboBoxInstitucion.getSelectedItem().toString();
			String nombreActividad = this.comboBoxActividad.getSelectedItem().toString();
			String nombreClase = this.comboBoxClase.getSelectedItem().toString();

			DtClase dtClase = controlador.getDtClaseXInsti(nombreInstitucion, nombreActividad, nombreClase);

			this.labelNombre.setVisible(true);
			this.labelNombre.setText("Nombre: " + dtClase.nombreClase.toString());

			this.labelFecha.setVisible(true);
			this.labelFecha.setText("Fecha: " + dtClase.fecha.toString());

			this.labelHoraIni.setVisible(true);
			this.labelHoraIni.setText("Hora inicio: " + dtClase.horaIni.toString());

			this.labelCantMin.setVisible(true);
			this.labelCantMin.setText("Cantidad minima: " + dtClase.cantMin);

			this.labelCantMax.setVisible(true);
			this.labelCantMax.setText("Cantidad maxima: " + dtClase.cantMax);

			this.labelURL.setVisible(true);
			this.labelURL.setText("URL: " + dtClase.claseURL.toString());

			this.labelRegistro.setVisible(true);
			this.labelRegistro.setText("Registro: " + dtClase.fechaRegistro.toString());

		} else {
			this.labelNombre.setVisible(false);
			this.labelFecha.setVisible(false);
			this.labelHoraIni.setVisible(false);
			this.labelCantMin.setVisible(false);
			this.labelCantMax.setVisible(false);
			this.labelURL.setVisible(false);
			this.labelRegistro.setVisible(false);
		}
	}
}
