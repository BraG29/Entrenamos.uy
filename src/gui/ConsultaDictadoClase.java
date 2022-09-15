package gui;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import logica.controlador.Fabrica;
import logica.controlador.IControlador;

public class ConsultaDictadoClase extends javax.swing.JFrame {

	private javax.swing.JComboBox<String> comboBoxActividadesDeportivas;
	private javax.swing.JComboBox<String> comboBoxInstituciones;
	private javax.swing.JComboBox<String> comboBoxClases;
	private javax.swing.JButton jButtonCancelar;
	private javax.swing.JLabel labelTitulo;
	private javax.swing.JLabel labelComboBoxInstituciones;
	private javax.swing.JLabel labelComboBoxActividadesDeportivas;
	private javax.swing.JLabel labelComboBoxClases;
	private javax.swing.JLabel labelClaseHoraIni;
	private javax.swing.JLabel labelClaseCantMax;
	private javax.swing.JLabel labelClaseCantMin;
	private javax.swing.JLabel labelClaseFecha;
	private javax.swing.JLabel labelClaseRegistro;
	private javax.swing.JLabel labelClaseURL;

	public ConsultaDictadoClase() {
		initComponents();
		this.labelClaseURL.setVisible(false);
		this.labelClaseCantMax.setVisible(false);
		this.labelClaseCantMin.setVisible(false);
		this.labelClaseHoraIni.setVisible(false);
		this.labelClaseFecha.setVisible(false);
		this.labelClaseRegistro.setVisible(false);
		this.labelComboBoxClases.setVisible(false);
		this.labelComboBoxActividadesDeportivas.setVisible(false);
		this.comboBoxClases.setVisible(false);
		this.comboBoxActividadesDeportivas.setVisible(false);

		Fabrica f = new Fabrica();
		IControlador sistema = f.getInterface();
		ArrayList<String> listaInstituciones = sistema.getNombreInstituciones();
		String[] arrayNombresInstituciones = new String[listaInstituciones.size()];
		int i = 0;
		for (String index : listaInstituciones) {
			arrayNombresInstituciones[i] = index;
			i++;
		}

		this.comboBoxInstituciones.setModel(new DefaultComboBoxModel<String>(arrayNombresInstituciones));

	}

	private void initComponents() {
		labelTitulo = new javax.swing.JLabel();
		labelComboBoxClases = new javax.swing.JLabel();
		labelClaseURL = new javax.swing.JLabel();
		labelClaseCantMax = new javax.swing.JLabel();
		labelClaseCantMin = new javax.swing.JLabel();
		labelClaseHoraIni = new javax.swing.JLabel();
		labelClaseRegistro = new javax.swing.JLabel();
		labelComboBoxActividadesDeportivas = new javax.swing.JLabel();
		labelClaseFecha = new javax.swing.JLabel();
		labelComboBoxInstituciones = new javax.swing.JLabel();
		jButtonCancelar = new javax.swing.JButton();
		comboBoxInstituciones = new javax.swing.JComboBox<>();
		comboBoxClases = new javax.swing.JComboBox<>();
		comboBoxActividadesDeportivas = new javax.swing.JComboBox<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		labelTitulo.setFont(new java.awt.Font("Noto Sans", 0, 18));
		labelTitulo.setText("Consulta Dictado de Clases");
		labelComboBoxInstituciones.setText("Institución");
		labelComboBoxClases.setText("Clases");
		labelClaseURL.setText("jLabelClURL");
		labelClaseCantMax.setText("jLabelClCantMax");
		labelClaseCantMin.setText("jLabelClCantMin");
		labelClaseHoraIni.setText("jLabelClHoraIni");
		labelClaseFecha.setText("jLabelClFecha");
		labelComboBoxActividadesDeportivas.setText("Actividad Deportiva");
		labelClaseRegistro.setText("jLabelClRegistro");

		jButtonCancelar.setBackground(new java.awt.Color(255, 51, 51));
		jButtonCancelar.setText("Atras");
		jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButtonCancelar(evt);
			}
		});

		comboBoxInstituciones.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboBoxInstitucionActionPerformed(evt);
			}
		});

		comboBoxClases.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboBoxClasesActionPerformed(evt);
			}
		});

		comboBoxActividadesDeportivas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboBoxActividadesActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jButtonCancelar).addGroup(layout
						.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(labelTitulo)
								.addGroup(layout.createSequentialGroup()
										.addComponent(comboBoxClases, GroupLayout.PREFERRED_SIZE, 158,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelComboBoxClases))
								.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(labelClaseFecha, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252,
												Short.MAX_VALUE)
										.addComponent(labelClaseHoraIni, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(labelClaseCantMin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(labelClaseCantMax, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(labelClaseURL, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(
										layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(comboBoxActividadesDeportivas, Alignment.LEADING,
																0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(comboBoxInstituciones, Alignment.LEADING, 0, 158,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addComponent(labelComboBoxInstituciones)
														.addComponent(labelComboBoxActividadesDeportivas)))))
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(labelClaseRegistro,
								GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)))
				.addGap(133)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap().addComponent(labelTitulo).addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxInstituciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(labelComboBoxInstituciones))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxActividadesDeportivas, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelComboBoxActividadesDeportivas))
				.addGap(8)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxClases, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(labelComboBoxClases))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(labelClaseURL)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelClaseCantMax)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelClaseCantMin)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelClaseHoraIni)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelClaseFecha)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelClaseRegistro)
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jButtonCancelar)));
		getContentPane().setLayout(layout);
		pack();
	}

	private void comboBoxInstitucionActionPerformed(java.awt.event.ActionEvent evt) {
		/*
		 * if (comboBoxInstituciones.getSelectedIndex() != 0) {
		 * 
		 * 
		 * } else { this.comboBoxActividadesDeportivas.setVisible(false);
		 * this.labelComboBoxActividadesDeportivas.setVisible(false);
		 * this.comboBoxClases.setVisible(false);
		 * this.labelComboBoxClases.setVisible(false); }
		 */
		this.comboBoxActividadesDeportivas.setVisible(true);
		this.labelComboBoxActividadesDeportivas.setVisible(true);

		String institucionActual = comboBoxInstituciones.getSelectedItem().toString();

		Fabrica f = new Fabrica();
		IControlador sistema = f.getInterface();
		ArrayList<String> listaActividadesDeportivas = sistema.consultarActividadDepo(institucionActual);
		String[] arrayNombresActividadesDeportivas = new String[listaActividadesDeportivas.size()];
		int i = 0;
		for (String index : listaActividadesDeportivas) {
			arrayNombresActividadesDeportivas[i] = index;
			i++;
		}

		this.comboBoxActividadesDeportivas
				.setModel(new DefaultComboBoxModel<String>(arrayNombresActividadesDeportivas));

	}

	private void comboBoxActividadesActionPerformed(java.awt.event.ActionEvent evt) {
		/*
		 * if (comboBoxActividadesDeportivas.getSelectedIndex() != 0) {
		 * 
		 * comboBoxClases.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
		 * "-", "clase1", "clase2" }));
		 * 
		 * } else { this.comboBoxClases.setVisible(false);
		 * this.labelComboBoxClases.setVisible(false); }
		 */

		this.comboBoxClases.setVisible(true);
		this.labelComboBoxClases.setVisible(true);

		String actividadActual = comboBoxActividadesDeportivas.getSelectedItem().toString();
		Fabrica f = new Fabrica();
		IControlador sistema = f.getInterface();
		ArrayList<String> listaClases = sistema.consultarClases(actividadActual);
		String[] arrayNombresClases = new String[listaClases.size()];
		int i = 0;
		for (String index : listaClases) {
			arrayNombresClases[i] = index;
			i++;
		}

		this.comboBoxClases.setModel(new DefaultComboBoxModel<String>(arrayNombresClases));
	}

	private void comboBoxClasesActionPerformed(java.awt.event.ActionEvent evt) {
		Fabrica f = new Fabrica();
		IControlador sistema = f.getInterface();
		String[] listaClases = sistema.getUnaClase(comboBoxClases.getSelectedItem().toString());

		this.labelClaseURL.setVisible(true);
		this.labelClaseCantMax.setVisible(true);
		this.labelClaseCantMin.setVisible(true);
		this.labelClaseHoraIni.setVisible(true);
		this.labelClaseFecha.setVisible(true);
		this.labelClaseRegistro.setVisible(true);

		this.labelClaseURL.setText("URL: " + listaClases[0]);
		this.labelClaseCantMax.setText("Max: " + listaClases[1]);
		this.labelClaseCantMin.setText("Min: " + listaClases[2]);
		this.labelClaseHoraIni.setText("Inicio: " + listaClases[3]);
		this.labelClaseFecha.setText("Fecha: " + listaClases[4]);
		this.labelClaseRegistro.setText("Registro: " + listaClases[5]);

		/*
		 * if (comboBoxClases.getSelectedIndex() != 0) { } else {
		 * this.labelClaseURL.setVisible(false);
		 * this.labelClaseCantMax.setVisible(false);
		 * this.labelClaseCantMin.setVisible(false);
		 * this.labelClaseHoraIni.setVisible(false);
		 * this.labelClaseFecha.setVisible(false);
		 * this.labelClaseRegistro.setVisible(false); }
		 */
	}

	private void jButtonCancelar(java.awt.event.MouseEvent evt) {
		this.setVisible(false);
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
			java.util.logging.Logger.getLogger(ConsultaDictadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ConsultaDictadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ConsultaDictadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ConsultaDictadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ConsultaDictadoClase().setVisible(true);
			}
		});
	}
}
