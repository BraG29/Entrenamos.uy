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
		archivo = null;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JFileChooser fileChooser = new JFileChooser();
		contentPane.add(fileChooser, BorderLayout.CENTER);
		
		fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filterJPG = new FileNameExtensionFilter(".jpg", "jpg");
		FileNameExtensionFilter filterPNG = new FileNameExtensionFilter(".png", "png");
		FileNameExtensionFilter filterJPEG = new FileNameExtensionFilter(".jpeg", "jpeg");
		fileChooser.addChoosableFileFilter(filterJPG);
		fileChooser.addChoosableFileFilter(filterPNG);
		fileChooser.addChoosableFileFilter(filterJPEG);
		
		fileChooser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//actionCommand	"ApproveSelection" (id=97)
				//actionCommand	"CancelSelection" (id=64)	
				if(arg0.getActionCommand() == "ApproveSelection")
					archivo = fileChooser.getSelectedFile();
				setVisible(false);
			}
		});
		fileChooser.showOpenDialog(null);
	}
	
	public File getArchivo() {
		//setVisible(false);
		return this.archivo;
	}

}
