package Juego;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InicioSesion extends javax.swing.JFrame {
    ArrayList<Registros> Todoslos_Logs;
    ArrayList<Usuario> Usuarios;
    boolean CT_Nombre_Clickeado = false;
    boolean CT_Pass_Clickeado = false;

    fondoInicio fondo = new fondoInicio();

    public InicioSesion(ArrayList UsuariosObtenidos, ArrayList<Registros> Todoslos_Logs_A) {
        Usuarios = new ArrayList<>();
        if (UsuariosObtenidos != null) {
            Usuarios = UsuariosObtenidos;
        }

        Todoslos_Logs = new ArrayList<>();
        if (Todoslos_Logs_A != null) {
            Todoslos_Logs = Todoslos_Logs_A;
        }
        this.setContentPane(fondo);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Aceptar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 24));
        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("Contraseña:");

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 24));
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Harlow Solid Italic", 1, 72));
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Iniciar sesión");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(213, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(61, 61, 61)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(jButton2))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        String Nombre = jTextField1.getText();
        String Pass = new String(jPasswordField1.getPassword());

        for (int i = 0; i < Usuarios.size(); i++) {
            if (Usuarios.get(i).getUser().equals(Nombre) && Usuarios.get(i).isActivo()) {
                if (Usuarios.get(i).getContra().equals(Pass)) {
                    JOptionPane.showMessageDialog(null, "Se ha iniciado sesión correctamente");
                    MenuPrincipal ObjetoMenuPrincipal = new MenuPrincipal(i, Usuarios, this.Todoslos_Logs);
                    ObjetoMenuPrincipal.setVisible(true);
                    this.dispose();
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "El usuario no existe");
        jTextField1.setText("");
        jPasswordField1.setText("");
    }

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {
        if (!CT_Nombre_Clickeado) {
            jTextField1.setText("");
            CT_Nombre_Clickeado = true;
        }
    }

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {
        if (!CT_Pass_Clickeado) {
            jPasswordField1.setText("");
            CT_Pass_Clickeado = true;
        }
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        MenuInicio ObjetoMenuInicial = new MenuInicio(Usuarios, this.Todoslos_Logs);
        ObjetoMenuInicial.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new InicioSesion(null, null).setVisible(true);
        });
    }

    class fondoInicio extends JPanel {
        private Image fondo;

        public void paint(Graphics g) {
            fondo = new ImageIcon(getClass().getResource("/Imagenes/InicioSesion.jpg")).getImage();
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
