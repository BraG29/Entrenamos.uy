package gui;
import javax.swing.GroupLayout.Alignment;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

public class ConsultaDistadoClase extends javax.swing.JFrame {

	private JPanel contentPane;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ConsultaDistadoClase frame = new ConsultaDistadoClase();
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
	public ConsultaDistadoClase() {
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 448);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInstitucin = new JLabel("Institución");
		lblInstitucin.setBounds(15, 29, 122, 20);
		contentPane.add(lblInstitucin);
		
		JLabel lblTipoUsr = new JLabel("Actividades Deportivas:");
		lblTipoUsr.setBounds(15, 60, 122, 20);
		contentPane.add(lblTipoUsr);
		
		JLabel lblClases = new JLabel("Clases:");
		lblClases.setBounds(15, 91, 122, 20);
		contentPane.add(lblClases);
		
		JComboBox cBoxInstitucion = new JComboBox();
		cBoxInstitucion.setModel(new DefaultComboBoxModel(new String[] {"IUA", "Saint Joseph", "Capuchinas"}));
		cBoxInstitucion.setBounds(137, 29, 112, 20);
		contentPane.add(cBoxInstitucion);
		
		JComboBox cBoxActividadDeportiva = new JComboBox();
		cBoxActividadDeportiva.setModel(new DefaultComboBoxModel(new String[] {"Basketball", "Football", "Voleyball"}));
		cBoxActividadDeportiva.setBounds(137, 60, 112, 20);
		contentPane.add(cBoxActividadDeportiva);
		
		JComboBox cBoxClase = new JComboBox();
		cBoxClase.setModel(new DefaultComboBoxModel(new String[] {"Mañana", "Tarde", "Noche"}));
		cBoxClase.setBounds(137, 91, 112, 20);
		contentPane.add(cBoxClase);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(15, 122, 122, 20);
		contentPane.add(lblNombre);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(15, 153, 122, 20);
		contentPane.add(lblFecha);
		
		JLabel lblHoraDeInicio = new JLabel("Hora de inicio");
		lblHoraDeInicio.setBounds(15, 184, 122, 20);
		contentPane.add(lblHoraDeInicio);
		
		JLabel lblCantidadMxima = new JLabel("Cantidad máxima");
		lblCantidadMxima.setBounds(15, 246, 122, 20);
		contentPane.add(lblCantidadMxima);
		
		JLabel lblCantidadMnima = new JLabel("Cantidad mínima");
		lblCantidadMnima.setBounds(15, 215, 122, 20);
		contentPane.add(lblCantidadMnima);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(15, 277, 122, 20);
		contentPane.add(lblUrl);
		
		JLabel lblCantidadMxima_1_1 = new JLabel("Fecha de Registro");
		lblCantidadMxima_1_1.setBounds(15, 308, 122, 20);
		contentPane.add(lblCantidadMxima_1_1);		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(137, 122, 210, 20);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(137, 153, 210, 20);
		contentPane.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(137, 184, 210, 20);
		contentPane.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(137, 215, 210, 20);
		contentPane.add(textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(137, 246, 210, 20);
		contentPane.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(137, 277, 210, 20);
		contentPane.add(textPane_5);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setBounds(137, 308, 210, 20);
		contentPane.add(textPane_6);
	}
}
