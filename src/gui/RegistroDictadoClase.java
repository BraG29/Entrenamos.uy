package gui;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import logica.controlador.Fabrica;
import logica.controlador.IControlador;

public class RegistroDictadoClase extends javax.swing.JFrame {

	private javax.swing.JComboBox<String> comboBoxInstituciones;
	private javax.swing.JComboBox<String> comboBoxActividadesDeportivas;
	private javax.swing.JComboBox<String> comboBoxClases;
	private javax.swing.JComboBox<String> comboBoxSocios;
	private javax.swing.JButton jButtonCancelar;
	private javax.swing.JButton btnAceptar;
	private javax.swing.JLabel labelTitulo;
	private javax.swing.JLabel labelComboBoxInstituciones;
	private javax.swing.JLabel labelComboBoxActividadesDeportivas;
	private javax.swing.JLabel labelComboBoxClases;
	private javax.swing.JLabel labelComboBoxSocios;

	public RegistroDictadoClase() {
		initComponents();
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
		labelComboBoxActividadesDeportivas = new javax.swing.JLabel();
		labelComboBoxInstituciones = new javax.swing.JLabel();
		labelComboBoxSocios = new javax.swing.JLabel();
		jButtonCancelar = new javax.swing.JButton();
		btnAceptar = new javax.swing.JButton();
		comboBoxInstituciones = new javax.swing.JComboBox<>();
		comboBoxClases = new javax.swing.JComboBox<>();
		comboBoxActividadesDeportivas = new javax.swing.JComboBox<>();
		comboBoxSocios = new javax.swing.JComboBox<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		labelTitulo.setFont(new java.awt.Font("Noto Sans", 0, 18));
		labelTitulo.setText("Consulta Dictado de Clases");
		labelComboBoxInstituciones.setText("Institución");
		labelComboBoxClases.setText("Clases");
		labelComboBoxSocios.setText("Socios");
		labelComboBoxActividadesDeportivas.setText("Actividad Deportiva");

		btnAceptar.setText("Aceptar");
		jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnAceptarEvent(evt);
			}
		});

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

		comboBoxActividadesDeportivas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboBoxActividadesActionPerformed(evt);
			}
		});

		comboBoxClases.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboBoxClasesActionPerformed(evt);
			}
		});

		comboBoxActividadesDeportivas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboBoxSociosActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addComponent(jButtonCancelar)
						.addPreferredGap(ComponentPlacement.RELATED, 269, Short.MAX_VALUE).addComponent(btnAceptar))
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(labelTitulo)
								.addGroup(layout.createSequentialGroup()
										.addComponent(comboBoxInstituciones, GroupLayout.PREFERRED_SIZE, 158,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(labelComboBoxInstituciones))))
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxSocios, 0, 158, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboBoxActividadesDeportivas, 0, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(comboBoxClases, 0, 158, Short.MAX_VALUE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(labelComboBoxClases)
								.addComponent(labelComboBoxActividadesDeportivas).addComponent(labelComboBoxSocios))
						.addContainerGap(133, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap().addComponent(labelTitulo).addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxInstituciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(labelComboBoxInstituciones))
				.addGap(23)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxActividadesDeportivas, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelComboBoxActividadesDeportivas))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxClases, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(labelComboBoxClases))
				.addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxSocios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(labelComboBoxSocios))
				.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jButtonCancelar)
						.addComponent(btnAceptar))));
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

	private void comboBoxSociosActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void btnAceptarEvent(java.awt.event.MouseEvent evt) {
		
		String inst = comboBoxInstituciones.getSelectedItem().toString();
		String actD = comboBoxActividadesDeportivas.getSelectedItem().toString();
		String clas = comboBoxClases.getSelectedItem().toString();
		String soci = comboBoxSocios.getSelectedItem().toString();		
		
		try {
			Fabrica fab = new Fabrica();
			IControlador controlador = fab.getInterface();
			controlador.registroDictadoClase(inst, actD, clas, soci);

		} catch (Exception e) {
			VentanaMensaje errorVentana = new VentanaMensaje("ERROR!", "Revise los campos.", java.awt.Color.RED);
			errorVentana.setVisible(true);
			return;
		}
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
			java.util.logging.Logger.getLogger(RegistroDictadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(RegistroDictadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(RegistroDictadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(RegistroDictadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new RegistroDictadoClase().setVisible(true);
			}
		});
	}
}
