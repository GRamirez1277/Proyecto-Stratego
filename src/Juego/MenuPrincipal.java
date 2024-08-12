package Juego;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuPrincipal extends javax.swing.JFrame {
    ArrayList<Registros> Todoslos_Logs;
    ArrayList<Usuario> Usuarios;
    int indexUser;

    fondoInicio fondo = new fondoInicio();

    public MenuPrincipal(int UserIndex, ArrayList UsuariosObtenidos, ArrayList<Registros> Todoslos_Logs_A) {
        indexUser = UserIndex;
        Usuarios = UsuariosObtenidos;
        Todoslos_Logs = new ArrayList<Registros>();
        if (Todoslos_Logs_A != null) {
            Todoslos_Logs = Todoslos_Logs_A;
        }
        this.setContentPane(fondo);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jButton1 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Iniciar Juego");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton3.setText("Mi Perfil");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Universo Marvel");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setText("Cerrar Sesion");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(292, 292, 292)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(297, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(178, 178, 178)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(200, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        if (Usuarios.size() > 1) {
            Tablero tb = new Tablero(indexUser, Usuarios, Todoslos_Logs);
            tb.setVisible(true);
            this.dispose();
        }
    }

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
        Perfil ObjPerfil = new Perfil(indexUser, Usuarios, this.Todoslos_Logs);
        ObjPerfil.setVisible(true);
        this.setVisible(false);
    }

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {
        String[] buttons = {"Ranking", "Batallas"};
        int returnValue = JOptionPane.showOptionDialog(null, "", "Elija una opción",
                JOptionPane.WARNING_MESSAGE, 1, null, buttons, buttons[0]);

        if (returnValue == 0) {
            Ranking ObjRank = new Ranking(this.Usuarios, this.indexUser, this.Todoslos_Logs);
            ObjRank.setVisible(true);
            this.setVisible(false);
        } else if (returnValue == 1) {
            Batallas ObjBatallas = new Batallas(this.indexUser, this.Usuarios, this.Todoslos_Logs);
            ObjBatallas.setVisible(true);
            this.setVisible(false);
        }
    }

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {
        String[] buttons = {"Sí", "No"};
        int returnValue = JOptionPane.showOptionDialog(null, "Desea cerrar la sesión?", "Elija una opción",
                JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[0]);

        if (returnValue == 0) {
            MenuInicio ObjMenuI = new MenuInicio(Usuarios, this.Todoslos_Logs);
            ObjMenuI.setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal(-1, null, null).setVisible(true);
            }
        });
    }

    class fondoInicio extends JPanel {
        private Image fondo;

        @Override
        public void paint(Graphics g) {
            fondo = new ImageIcon(getClass().getResource("/Imagenes/MenuPrincipal.jpg")).getImage();
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
}
