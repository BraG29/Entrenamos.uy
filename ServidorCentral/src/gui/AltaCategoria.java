package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import logica.controlador.Fabrica;
import logica.controlador.IControlador;

public class AltaCategoria extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCategoria frame = new AltaCategoria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaCategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(0, 153, 204));
		panel.setBounds(327, 0, 125, 275);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Noto Sans", Font.BOLD, 18));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(txtNom.getText().equals("")) {
						throw new Exception("Nombre Categoría no puede ser vacio");
					}
					String nomCat = txtNom.getText();
					
					
					Fabrica fab = new Fabrica();
					IControlador controlador = fab.getInterface();
					
					
					try {
						controlador.altaCategoria(nomCat);	
					}catch(Exception e) {
						throw new Exception(e.getMessage());	
					}
				}catch(Exception e) {
					VentanaMensaje vntError = new VentanaMensaje("ERROR!", e.getMessage().toString(), java.awt.Color.RED);
					vntError.setVisible(true);
					return;
				}
				
				VentanaMensaje vntBien = new VentanaMensaje("ERROR!", "Se dió de alta la categoria!", java.awt.Color.GREEN.darker());
				vntBien.setVisible(true);
			}
		});
		btnAceptar.setBounds(0, 250, 117, 25);
		panel.add(btnAceptar);
		
		JButton btnSalida = new JButton("<--------");
		btnSalida.setBackground(Color.RED);
		btnSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnSalida.setBounds(0, 250, 91, 25);
		contentPane.add(btnSalida);
		
		JLabel lblTitulo = new JLabel("Alta de Categoría");
		lblTitulo.setFont(new Font("Noto Sans", Font.PLAIN, 18));
		lblTitulo.setBounds(8, 4, 238, 25);
		contentPane.add(lblTitulo);
		
		txtNom = new JTextField();
		txtNom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtNom.getText().equals("Escriba el nombre de la categoría")) {
					txtNom.setText("");
				}
			}
		});
		txtNom.setText("Escriba el nombre de la categoría");
		txtNom.setBounds(8, 58, 231, 19);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNombCat = new JLabel("Nombre");
		lblNombCat.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombCat.setBounds(259, 60, 62, 15);
		contentPane.add(lblNombCat);
	}
}
