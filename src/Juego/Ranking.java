package Juego;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ranking extends javax.swing.JFrame {
    ArrayList<Usuario> Usuarios;
    int G_Indice;
    ArrayList<Registros> Todoslos_Logs;

    fondoInicio fondo = new fondoInicio();

    public Ranking(ArrayList<Usuario> UsuariosObtenidos, int Indice, ArrayList<Registros> Todoslos_Logs_A) {
        Usuarios = UsuariosObtenidos;
        G_Indice = Indice;

        Todoslos_Logs = new ArrayList<>();
        if (Todoslos_Logs_A != null) {
            Todoslos_Logs = Todoslos_Logs_A;
        }
        this.setContentPane(fondo);
        initComponents();
        cargarListaUsuarios(UsuariosObtenidos);
    }

    private void cargarListaUsuarios(ArrayList<Usuario> UsuariosObtenidos) {
        int contador = 0;
        for (Usuario usuario : UsuariosObtenidos) {
            if (usuario.isActivo()) {
                contador++;
            }
        }

        String[] listaUsuarios = new String[contador];
        int posicion = 0;

        for (Usuario usuario : UsuariosObtenidos) {
            if (usuario.isActivo()) {
                listaUsuarios[posicion] = usuario.getUser() + " - " + usuario.getPuntos();
                posicion++;
            }
        }

        // Ordenar la lista por puntos de mayor a menor
        for (int i = 0; i < posicion - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < posicion; j++) {
                Double puntos1 = getPuntosFromUsuario(listaUsuarios[maxIndex]);
                Double puntos2 = getPuntosFromUsuario(listaUsuarios[j]);
                if (puntos2 > puntos1) {
                    maxIndex = j;
                }
            }
            String temp = listaUsuarios[i];
            listaUsuarios[i] = listaUsuarios[maxIndex];
            listaUsuarios[maxIndex] = temp;
        }

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return listaUsuarios.length; }
            public String getElementAt(int i) { return (i + 1) + " - " + listaUsuarios[i]; }
        });
    }

    private Double getPuntosFromUsuario(String usuario) {
        int separadorIndex = usuario.lastIndexOf(" - ");
        String puntosString = usuario.substring(separadorIndex + 3);
        return Double.parseDouble(puntosString);
    }

    // Código autogenerado por el editor de GUI de NetBeans
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setBackground(new java.awt.Color(0, 0, 0));
        jList1.setBorder(null);
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Volver");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jButton1))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        MenuPrincipal ObjMenuPrincipal = new MenuPrincipal(this.G_Indice, this.Usuarios, this.Todoslos_Logs);
        ObjMenuPrincipal.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ranking(null, -1, null).setVisible(true);
            }
        });
    }

    class fondoInicio extends JPanel {
        private Image fondo;

        public void paint(Graphics g) {
            fondo = new ImageIcon(getClass().getResource("/Imagenes/Ranking.jpg")).getImage();
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration
}
