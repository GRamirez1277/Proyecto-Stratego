package Juego;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Batallas extends javax.swing.JFrame {
    ArrayList<Registros> Todoslos_Logs;
    ArrayList<Usuario> Usuarios;
    boolean ModoTutorial = true;
    int indexUser;

    fondoInicio fondo = new fondoInicio();

    public Batallas(int UserIndex, ArrayList<Usuario> UsuariosObtenidos, ArrayList<Registros> Todoslos_Logs_A) {
        indexUser = UserIndex;
        Usuarios = UsuariosObtenidos;

        Todoslos_Logs = new ArrayList<>();
        if (Todoslos_Logs_A != null) {
            Todoslos_Logs = Todoslos_Logs_A;
        }

        this.setContentPane(fondo);
        initComponents();
        this.setResizable(false);

        int CantUsuarA = 0;
        int CantUsuarH = 0;
        int Jugadas = 0;
        int JugadasH = 0;
        int JugadasV = 0;

        for (int i = 0; i < UsuariosObtenidos.size(); i++) {
            if (UsuariosObtenidos.get(i).isActivo()) {
                CantUsuarA++;
            }
            CantUsuarH++;

            Jugadas += UsuariosObtenidos.get(i).getPartidasHeroe() + UsuariosObtenidos.get(i).getPartidasVillano();
        }

        for (int i = 0; i < Todoslos_Logs_A.size(); i++) {
            if (!(Todoslos_Logs_A.get(i).obtenerLogHeroes_Ganados().equals(""))) {
                JugadasH++;
            }
            if (!(Todoslos_Logs_A.get(i).obtenerLogVillanos_Ganados().equals(""))) {
                JugadasV++;
            }
        }

        jLabel1.setText(jLabel1.getText() + CantUsuarA);
        jLabel2.setText(jLabel2.getText() + CantUsuarH);
        jLabel3.setText(jLabel3.getText() + Jugadas);
        jLabel4.setText(jLabel4.getText() + JugadasH);
        jLabel5.setText(jLabel5.getText() + JugadasV);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Volver");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Partidas jugadas: ");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Partidas ganadas como Villano: ");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Partidas ganadas como Héroe: ");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuarios históricos: ");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuarios activos: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 700, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 77, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jButton1))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        MenuPrincipal ObjMenuPrincipal = new MenuPrincipal(this.indexUser, this.Usuarios, this.Todoslos_Logs);
        ObjMenuPrincipal.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Batallas(-1, null, null).setVisible(true));
    }

    class fondoInicio extends JPanel {
        private Image fondo;

        public void paint(Graphics g) {
            fondo = new ImageIcon(getClass().getResource("/Imagenes/Batallas.jpg")).getImage();
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
