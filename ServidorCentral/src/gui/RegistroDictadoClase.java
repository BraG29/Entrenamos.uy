package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.dom4j.IllegalAddException;
import org.hibernate.boot.internal.SessionFactoryOptionsBuilder;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import logica.controlador.Fabrica;
import logica.controlador.IControlador;
import logica.datatypes.DtActividadDeportiva;
import logica.datatypes.DtClase;
import logica.datatypes.DtInstitucion;
import logica.datatypes.DtSocio;
import logica.datatypes.DtUsrKey;
import logica.institucion.Categoria;
import logica.institucion.Estado;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;

public class RegistroDictadoClase extends JFrame {

	private JPanel contentPane;
	private String[] nomClases; 
	private DtUsrKey dtKeySocio;
	private VentanaMensaje mensaje;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistroDictadoClase frame = new RegistroDictadoClase();
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
	public RegistroDictadoClase() {
		setBackground(SystemColor.inactiveCaption);
		setForeground(SystemColor.activeCaptionText);
		setTitle("Registro a Clase");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 565, 424);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Fabrica fabrica = new Fabrica();
		IControlador sistema = fabrica.getInterface();
		
		ArrayList<DtSocio> listSocios = sistema.getSocios();
		String[] cargaLista = {""};
		for(int i = 0; i < listSocios.size(); i++) {
			cargaLista[i] = listSocios.get(i).nickname;
		}
		
		
		JList listUsr = new JList();
		listUsr.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				for(DtSocio dtS : listSocios) {
					if(dtS.nickname.equals(listUsr.getSelectedValue().toString()))
						dtKeySocio = new DtUsrKey(dtS.nickname, dtS.email);
				}
			}
		});
		listUsr.setModel(new AbstractListModel() {
			String[] values = cargaLista;

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JScrollPane scrollList = new JScrollPane(listUsr);
		scrollList.setBounds(12, 69, 153, 288);
		
		contentPane.add(scrollList);
		
		JLabel lblElijaUnSocio = new JLabel("Elija un Socio:");
		lblElijaUnSocio.setBounds(12, 41, 98, 15);
		contentPane.add(lblElijaUnSocio);
		
		JComboBox cBTipoListado = new JComboBox();
		cBTipoListado.setEnabled(false);
		cBTipoListado.setBounds(192, 36, 112, 24);
		contentPane.add(cBTipoListado);
		
		JLabel lblListarActividadesDeportivas = new JLabel("<html><body>Listar Actividades<br>Deportivas por:</body></html>");
		lblListarActividadesDeportivas.setBounds(192, 0, 136, 33);
		contentPane.add(lblListarActividadesDeportivas);
		
		String[] cBInicio = {"-"};
		HashMap mapInsti = sistema.getHashDtInstis();
		java.util.Collection<DtInstitucion> listInstituciones = mapInsti.values();
		Set<String> listInstiString = mapInsti.keySet();
		ArrayList<DtActividadDeportiva> listAllActividades = new ArrayList<>();
		for(DtInstitucion i : listInstituciones) {
			for(DtActividadDeportiva dtAC : i.actividades) {
				if(dtAC.estadoActual == Estado.ACEPTADA)
					listAllActividades.add(dtAC);
			}
		}
		
		ArrayList<String> listCategorias = sistema.listaCategorias();
		
		String[] nomInstituciones = new String[listInstiString.size() + 1];
		
		
		System.arraycopy(cBInicio, 0, nomInstituciones, 0, 1);
		System.arraycopy(
				listInstiString.toArray(new String[listInstiString.size()]), 0, nomInstituciones, 1, listInstiString.size());
		
		String[] nomCategorias = new String[listCategorias.size() + 1];
		System.arraycopy(cBInicio, 0, nomCategorias, 0, 1);
		System.arraycopy(
				listCategorias.toArray(new String[listCategorias.size()]), 0, nomCategorias, 1, listCategorias.size());
		
		JList listActividades = new JList();
		
		JScrollPane scrollActividades = new JScrollPane(listActividades);
		scrollActividades.setBounds(192, 69, 153, 288);
		contentPane.add(scrollActividades);
		
		JRadioButton rdbtnCategoria = new JRadioButton("Categoria");
		rdbtnCategoria.setBackground(SystemColor.activeCaptionBorder);
		rdbtnCategoria.setBounds(329, -4, 98, 25);
		contentPane.add(rdbtnCategoria);
		
		JRadioButton rdbtnInstitucion = new JRadioButton("Institucion");
		rdbtnInstitucion.setBackground(SystemColor.activeCaptionBorder);
		rdbtnInstitucion.setBounds(329, 20, 106, 23);
		contentPane.add(rdbtnInstitucion);
		
		JList listClase = new JList();
		
		JScrollPane scrollClase = new JScrollPane(listClase);
		scrollClase.setBounds(372, 69, 153, 288);
		contentPane.add(scrollClase);
		
		JLabel lblElijaUnaClase = new JLabel("Elija una Clase:");
		lblElijaUnaClase.setBounds(372, 51, 112, 15);
		contentPane.add(lblElijaUnaClase);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(12, 359, 112, 28);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(413, 359, 112, 28);
		contentPane.add(btnAceptar);
		
		rdbtnCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnInstitucion.isSelected())
					rdbtnInstitucion.setSelected(false);
				cBTipoListado.setModel(new DefaultComboBoxModel(nomCategorias));
				cBTipoListado.setEnabled(true);
			}
		});
		
		
		rdbtnInstitucion.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnCategoria.isSelected())
					rdbtnCategoria.setSelected(false);
				cBTipoListado.setModel(new DefaultComboBoxModel(nomInstituciones));
				cBTipoListado.setEnabled(true);
				
								
			}
		});
		
		cBTipoListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cBTipoListado.getSelectedIndex() == 0)
					listActividades.setModel(null);
				
				if(rdbtnInstitucion.isSelected()) {
					String nomInst = cBTipoListado.getSelectedItem().toString();
					DtInstitucion dtInst =(DtInstitucion) mapInsti.get(nomInst);
					String[] nomActividadesXInsti = new String[dtInst.actividades.size()];
					for(int i = 0; i < nomActividadesXInsti.length; i++) {
						for(DtActividadDeportiva dtAC : dtInst.actividades) {
							if(dtAC.estadoActual == Estado.ACEPTADA)
								nomActividadesXInsti[i] = dtInst.actividades.get(i).nombreAct;
						}
					}
					listActividades.setModel(new AbstractListModel() {
						String[] values = nomActividadesXInsti;

						public int getSize() {
							return values.length;
						}

						public Object getElementAt(int index) {
							return values[index];
						}
						
					});
				}
				
				else{
					String[] nomActividadesXCat = new String[listAllActividades.size()];
					int c = 0;
					for(DtActividadDeportiva dtAC : listAllActividades) {
						for(int i = 0; i < dtAC.categorias.size(); i++) {
							if(dtAC.categorias.get(i).equals(cBTipoListado.getSelectedItem().toString())) {
								nomActividadesXCat[c] = dtAC.nombreAct;
								c++;
							}
						}
					}
					listActividades.setModel(new AbstractListModel() {
						String[] values = nomActividadesXCat;

						public int getSize() {
							return values.length;
						}

						public Object getElementAt(int index) {
							return values[index];
						}
						
					});
					
				}
			}
		});
		
		listActividades.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				ArrayList<DtClase> listDtClases = new ArrayList<>();
				for(DtActividadDeportiva dtAC : listAllActividades) {
					if(dtAC.nombreAct.equals(listActividades.getSelectedValue().toString())) {
						listDtClases = dtAC.clases;
						break;
					}
				}
				nomClases = new String[listDtClases.size()];
				for(int i=0; i<listDtClases.size(); i++) {
					nomClases[i] = listDtClases.get(i).nombreClase;
				}
				listClase.setModel(new AbstractListModel() {
					String[] values = nomClases;

					public int getSize() {
						return values.length;
					}

					public Object getElementAt(int index) {
						return values[index];
					}
					
				});
			}
		});
		
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String clase = new String();
				try {
					if(
							listUsr.getSelectedValue() == null ||
							listActividades.getSelectedValue() == null ||
							listClase.getSelectedValue() == null
							) {
						throw new IllegalAddException("Seleccione todo lo necesario por favor");
					}
					
					String actividad = listActividades.getSelectedValue().toString();
					clase = listClase.getSelectedValue().toString();
					
					sistema.registroDictadoClase( actividad, clase, dtKeySocio);
					mensaje = new VentanaMensaje(
							"Dictado a Clase hecho", 
							"<html><body>Se ha registrado al usuario: "+dtKeySocio.nickname+"<br>a la clase: "+clase+"</body></html>",
							Color.BLACK);
					mensaje.setVisible(true);
					
				} catch (IllegalAddException e) {
					mensaje = new VentanaMensaje("ERROR", e.getMessage(), Color.RED);
					mensaje.setVisible(true);
				} catch(IllegalArgumentException e) {
					mensaje = new VentanaMensaje("ERROR", e.getMessage(), Color.RED);
					mensaje.setVisible(true);
				}
					
			}
		});
		
		
		
	}
}
