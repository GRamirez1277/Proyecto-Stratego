package Juego;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CrearPlayer extends javax.swing.JFrame {
    ArrayList<Registros> Todoslos_Logs;
    ArrayList<Usuario> Usuarios;
    boolean CT_Nombre_Clickeado = false;
    boolean CT_Pass_Clickeado = false;

    fondoInicio fondo = new fondoInicio();

    public CrearPlayer(ArrayList<Usuario> UsuariosObtenidos, ArrayList<Registros> Todoslos_Logs_A) {
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
        jTextField1.setText("");
        jPasswordField1.setText("");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jButton1.setText("Crear");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); 
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); 
        jLabel3.setText("Nombre");

        jLabel1.setFont(new java.awt.Font("Harlow Solid Italic", 1, 48)); 
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setText("Crear Player");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addGap(273, 273, 273))
            .addGroup(layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jButton2))
        );

        pack();
        setLocationRelativeTo(null);
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

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        String Nombre = jTextField1.getText();
        String Pass = jPasswordField1.getText();

        if (jPasswordField1.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener exactamente 5 caracteres");
            jPasswordField1.setText("");
            return;
        }
        for (Usuario usuario : Usuarios) {
            if (usuario.getUser().equals(Nombre)) {
                JOptionPane.showMessageDialog(null, "Error. El usuario ya existe", Pass, 2);
                jTextField1.setText("");
                jPasswordField1.setText("");
                return;
            }
        }
        Usuario UsuarioCreado = new Usuario(Nombre, Pass);
        Usuarios.add(UsuarioCreado);
        JOptionPane.showMessageDialog(null, "Usuario creado con éxito");

        MenuInicio ObjetoMenuInicial = new MenuInicio(Usuarios, this.Todoslos_Logs);
        ObjetoMenuInicial.setVisible(true);
        this.dispose();
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        MenuInicio ObjetoMenuInicial = new MenuInicio(Usuarios, this.Todoslos_Logs);
        ObjetoMenuInicial.setVisible(true);
        this.dispose();
    }

    class fondoInicio extends JPanel {
        private Image fondo;

        public void paint(Graphics g) {
            fondo = new ImageIcon(getClass().getResource("/Imagenes/CrearPlayer.jpg")).getImage();
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CrearPlayer(null, null).setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration
}
