package gui;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ConsultaDistadoClase extends javax.swing.JFrame {

    public ConsultaDistadoClase() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        fieldInstiDepo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fieldInstiDepo.setText("Escriba la institución deportiva");
        fieldInstiDepo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldInstiDepoMouseClicked(evt);
            }
        });
        fieldInstiDepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldInstiDepoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel1.setText("Consulta de Dictado de Clase");

        jLabel2.setText("Caso de uso");

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setText("<---------");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton1 = new javax.swing.JButton();
        
                jButton1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
                jButton1.setText("Consultar");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton1ActionPerformed(evt);
                    }
                });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(fieldInstiDepo, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        							.addGap(52))
        						.addComponent(jLabel1)
        						.addComponent(jLabel2)))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton2)
        					.addPreferredGap(ComponentPlacement.RELATED, 210, Short.MAX_VALUE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jButton1))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addGap(1)
        			.addComponent(jLabel2)
        			.addGap(30)
        			.addComponent(fieldInstiDepo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton2)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void fieldInstiDepoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldInstiDepoMouseClicked
        if(fieldInstiDepo.getText().equals("Escriba la institución deportiva")){
            fieldInstiDepo.setText("");
        }
    }

    private void fieldInstiDepoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        
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
            java.util.logging.Logger.getLogger(ConsultaDistadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaDistadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaDistadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaDistadoClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaDistadoClase().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField fieldInstiDepo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
}
