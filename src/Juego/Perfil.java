package Juego;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Perfil extends javax.swing.JFrame {
    private ArrayList<Usuario> Usuarios;
    private ArrayList<Registros> Todoslos_Logs;
    private int indexUser;
    
    private FondoInicio fondo = new FondoInicio();

    public Perfil(int UserIndex, ArrayList<Usuario> UsuariosObtenidos, ArrayList<Registros> Todoslos_Logs_A) {
        this.indexUser = UserIndex;
        this.Usuarios = UsuariosObtenidos;
        this.Todoslos_Logs = (Todoslos_Logs_A != null) ? Todoslos_Logs_A : new ArrayList<Registros>();
        this.setContentPane(fondo);
        initComponents();
        this.setResizable(false);

        String Texto = "<html><br><br>Nombre: " + Usuarios.get(indexUser).getUser() + "<br><br>"
                + "Puntos: " + Usuarios.get(indexUser).getPuntos() + "<br><br>"
                + "Jugadas Héroes: " + Usuarios.get(indexUser).getPartidasHeroe() + "<br><br>"
                + "Jugadas Villano: " + Usuarios.get(indexUser).getPartidasVillano() + "</html>";
        jLabel1.setText(Texto);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Últimos juegos");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Nombre: ");
        jLabel1.setOpaque(true);

        jButton4.setText("Volver");
        jButton4.addActionListener(evt -> jButton4ActionPerformed(evt));

        jButton5.setText("Cambiar mi contraseña");
        jButton5.addActionListener(evt -> jButton5ActionPerformed(evt));

        jButton6.setText("Eliminar mi cuenta");
        jButton6.addActionListener(evt -> jButton6ActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(394, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(376, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jButton4))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        UltimosJuegos ObjLOGS = new UltimosJuegos(this.indexUser, this.Usuarios, this.Todoslos_Logs);
        ObjLOGS.setVisible(true);
        this.setVisible(false);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        MenuPrincipal ObjMenuPrincipal = new MenuPrincipal(indexUser, Usuarios, this.Todoslos_Logs);
        ObjMenuPrincipal.setVisible(true);
        this.setVisible(false);
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String Contra = JOptionPane.showInputDialog("Ingrese su contraseña actual: ");
            if (Contra == null) {
                return;
            }
            if (Usuarios.get(indexUser).getContra().equals(Contra)) {
                String ContraNueva;
                do {
                    ContraNueva = JOptionPane.showInputDialog("Ingrese su nueva contraseña - (5 caracteres exactamente): ");
                    if (ContraNueva == null) {
                        return;
                    }
                } while (ContraNueva.length() != 5);

                Usuarios.get(indexUser).setContra(ContraNueva);
                JOptionPane.showMessageDialog(null, "Se cambió la contraseña correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña no es correcta");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String Contra = JOptionPane.showInputDialog("Ingrese su contraseña: ");
            if (Contra == null) {
                return;
            }
            if (Usuarios.get(indexUser).getContra().equals(Contra) && Usuarios.get(indexUser).isActivo()) {
                Usuarios.remove(indexUser);
                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
                MenuInicio ObjMenuI = new MenuInicio(this.Usuarios, this.Todoslos_Logs);
                ObjMenuI.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña no es correcta");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Perfil(-1, null, null).setVisible(true));
    }

    class FondoInicio extends JPanel {
        private Image fondo;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            fondo = new ImageIcon(getClass().getResource("/Imagenes/Perfil.jpg")).getImage();
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
}
