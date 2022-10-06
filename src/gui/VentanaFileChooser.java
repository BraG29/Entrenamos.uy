package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.awt.event.ActionEvent;

public class VentanaFileChooser extends JFrame {

	private JPanel contentPane;
	private File archivo;

	private JFileChooser fileChooser;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaFileChooser frame = new VentanaFileChooser(latchRecibido);
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
	public VentanaFileChooser() {
		//setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.fileChooser = new JFileChooser();

		
		this.fileChooser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				archivo = fileChooser.getSelectedFile();
			}
		});
		contentPane.add(this.fileChooser, BorderLayout.CENTER);
		
		this.fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filterJPG = new FileNameExtensionFilter(".jpg", "jpg");
		FileNameExtensionFilter filterPNG = new FileNameExtensionFilter(".png", "png");
		FileNameExtensionFilter filterJPEG = new FileNameExtensionFilter(".jpeg", "jpeg");
		this.fileChooser.addChoosableFileFilter(filterJPG);
		this.fileChooser.addChoosableFileFilter(filterPNG);
		this.fileChooser.addChoosableFileFilter(filterJPEG);
		
		this.fileChooser.showOpenDialog(null);
	}
	
	public File getArchivo() {
		setVisible(false);
		return this.archivo;
	}

}
