
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juan
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setSize(320, 220);

        this.setLocationRelativeTo(null);
        cerrar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginlbl = new javax.swing.JLabel();
        usuariolbl = new javax.swing.JLabel();
        contraseñalbl = new javax.swing.JLabel();
        usuariotxt = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        SalirButton = new javax.swing.JButton();
        IngresarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(305, 165));
        setResizable(false);
        getContentPane().setLayout(null);

        loginlbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginlbl.setForeground(new java.awt.Color(102, 0, 102));
        loginlbl.setText("LOGIN");
        getContentPane().add(loginlbl);
        loginlbl.setBounds(120, 0, 81, 29);

        usuariolbl.setBackground(new java.awt.Color(0, 0, 0));
        usuariolbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usuariolbl.setForeground(new java.awt.Color(255, 255, 255));
        usuariolbl.setText("USUARIO:");
        getContentPane().add(usuariolbl);
        usuariolbl.setBounds(20, 50, 86, 15);

        contraseñalbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        contraseñalbl.setForeground(new java.awt.Color(255, 255, 255));
        contraseñalbl.setText("CONTRASEÑA:");
        getContentPane().add(contraseñalbl);
        contraseñalbl.setBounds(20, 90, 86, 15);
        getContentPane().add(usuariotxt);
        usuariotxt.setBounds(150, 40, 144, 30);

        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(PasswordField);
        PasswordField.setBounds(150, 80, 144, 30);

        SalirButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SalirButton.setText("SALIR");
        SalirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SalirButton);
        SalirButton.setBounds(200, 130, 71, 23);

        IngresarButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        IngresarButton.setText("INGRESAR");
        IngresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(IngresarButton);
        IngresarButton.setBounds(60, 130, 95, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/carretera.png.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -30, 380, 250);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void SalirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirButtonActionPerformed
    public void cerrar() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void confirmarSalida() {
        int valor = JOptionPane.showConfirmDialog(this, "Esta seguro de cerrar sesion", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (valor == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Gracias por su visita", "Hasta Pronto", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    private void IngresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarButtonActionPerformed
        String usuario = "Andrea";
        String usuario2 = "kenny";
        String usuario3 = "Angel";
        String password = "12345";
        String password2 = "kenny";
        String password3 = "admin";
        if (usuariotxt.getText().equals(usuario) && PasswordField.getText().equals(password) || usuariotxt.getText().equals(usuario2)
                && PasswordField.getText().equals(password2) || usuariotxt.getText().equals(usuario3) && PasswordField.getText().equals(password3)) {

            venta1 pri = new venta1();

            pri.setVisible(true);
            dispose();

        } else {
            JOptionPane.showMessageDialog(null, "usuario o  contraseña incorrecta");
            PasswordField.setText("");
            usuariotxt.setText("");
        }
    }//GEN-LAST:event_IngresarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Login().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IngresarButton;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton SalirButton;
    private javax.swing.JLabel contraseñalbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel loginlbl;
    private javax.swing.JLabel usuariolbl;
    private javax.swing.JTextField usuariotxt;
    // End of variables declaration//GEN-END:variables
}
