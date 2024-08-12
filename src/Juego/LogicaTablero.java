package Juego;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class LogicaTablero {
    boolean AsignaciondeLugares = true;
    boolean TurnoHeroe = true;
    int ContadorSeleccion = 0;
    int GanadorPorBandera = 0;
    Personaje[][] MatrizTablero;
    Personaje[][] MatrizHeroe;
    Personaje[][] MatrizVillano;
    int seleccionX;
    int seleccionY;
    int seleccionHeroeX = -1;
    int seleccionHeroeY = -1;

    Dimension CoordTablero_Viejas = new Dimension(-1, -1);

    public LogicaTablero() {
        String NombresPersonajes[] = {"Black Widow", "Night Crawler", "Elektra", "Storm", "Dr. Strange", "Elena", "Gambit", "SpiderGirl", "Iceman", "Emma Frost",
            "She-Hulk", "Coloso", "Antman", "Bestia", "Mole", "Punisher", "Blade", "Ghost Rider", "Antorcha Humana", "Mujer Invisible",
            "Cíclope", "Thor", "Iron-Man", "Hulk", "Silver Surfer", "Daredevil", "Namor", "Aguja Dinamica", "Spiderman", "Nick Fury",
            "Profesor X", "Capitán América", "Mr. Fantastico", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "TIERRA"};
          String NombresPersonajesVillanos[] = {"Espia", "Centinela", "Centinela", "Ultron", "Morbius", "Sandman", "El Lider", "Poison", "Electro", "Rhino",
            "El Lagarto", "El Hombre Topo", "Jugernaut", "Carnage", "Black Cat", "Thanos", "Abominación", "Craven", "Mystique", "Octopus",
            "Misterioso", "Deadpool", "Wishplash", "Craneo Rojo", "Onslaught", "Spot", "Apocalypse", "Duende Verde", "Venom", "Kin Pin",
            "Magneto", "Galactus", "Doom", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "TIERRA"};
        MatrizTablero = new Personaje[10][10];
        MatrizHeroe = new Personaje[10][4];
        MatrizVillano = new Personaje[10][4];
        for (int i = 0; i < MatrizTablero.length; i++) {
            for (int j = 0; j < MatrizTablero[0].length; j++) {
                MatrizTablero[i][j] = null;
            }
        }
        MatrizTablero[4][2] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][2] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[4][3] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][3] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[4][6] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][6] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[4][7] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][7] = new Personaje(0, "Muro", -1, true);
        for (int i = 0; i < MatrizTablero.length; i++) {
            for (int j = 0; j < MatrizTablero[0].length; j++) {
                if (MatrizTablero[i][j] == null) {
                } else {
                }
            }
        }

        int RangosBase[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int PersonajesBase[] = {1, 8, 5, 4, 4, 4, 3, 2, 1, 1, 6, 1};
        int Lugar = 0;
        int Completados = 0;
        int Personajes = 1;
        for (int i = 0; i < MatrizHeroe.length; i++) {
            for (int j = 0; j < MatrizHeroe[0].length; j++) {
                if (Completados == 0) {
                    Completados = PersonajesBase[Lugar];
                }
                MatrizHeroe[i][j] = new Personaje(Personajes, NombresPersonajes[Personajes - 1], RangosBase[Lugar], true);
                Completados--;
                Personajes++;
                if (Completados == 0) {
                    Lugar++;
                }
            }
        }
        Lugar = 0;
        Completados = 0;
        Personajes = 1;
        for (int i = 0; i < MatrizVillano.length; i++) {
            for (int j = 0; j < MatrizVillano[0].length; j++) {
                if (Completados == 0) {
                    Completados = PersonajesBase[Lugar];
                }
                MatrizVillano[i][j] = new Personaje(Personajes, NombresPersonajes[Personajes - 1], RangosBase[Lugar], false);
                Completados--;
                Personajes++;
                if (Completados == 0) {
                    Lugar++;
                }
            }
        }
        for (int i = 0; i < MatrizVillano.length; i++) {

            for (int j = 0; j < MatrizVillano[0].length; j++) {
            }
        }
    }

    public LogicaTablero(boolean JuegodePrueba) {
        JuegodePrueba = true;
        AsignaciondeLugares = false;
        String NombresPersonajes[] = {"Black Widow", "Night Crawler", "Elektra", "Storm", "Dr. Strange", "Elena", "Gambit", "SpiderGirl", "Iceman", "Emma Frost",
            "She-Hulk", "Coloso", "Antman", "Bestia", "Mole", "Punisher", "Blade", "Ghost Rider", "Antorcha Humana", "Mujer Invisible",
            "Cíclope", "Thor", "Iron-Man", "Hulk", "Silver Surfer", "Daredevil", "Namor", "Wolverine", "Spiderman", "Nick Fury",
            "Profesor X", "Capitán América", "Mr. Fantastico", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "PLANETA"};
        
          String NombresPersonajesVillanos[] = {"Espia", "Centinela", "Centinela", "Ultron", "Morbius", "Sandman", "El Lider", "Poison", "Electro", "Rhino",
            "El Lagarto", "El Hombre Topo", "Jugernaut", "Carnage", "Black Cat", "Thanos", "Abominación", "Craven", "Mystique", "Octopus",
            "Misterioso", "Deadpool", "Wishplash", "Craneo Rojo", "Onslaught", "Spot", "Apocalypse", "Duende Verde", "Venom", "Kin Pin",
            "Magneto", "Galactus", "Doom", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "PLANETA"};
        MatrizTablero = new Personaje[10][10];
        MatrizHeroe = new Personaje[10][4];
        MatrizVillano = new Personaje[10][4];
        for (int i = 0; i < MatrizTablero.length; i++) {
            for (int j = 0; j < MatrizTablero[0].length; j++) {
                MatrizTablero[i][j] = null;
            }
        }
        MatrizTablero[4][2] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][2] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[4][3] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][3] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[4][6] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][6] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[4][7] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][7] = new Personaje(0, "Muro", -1, true);

        int RangosBase[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int PersonajesBase[] = {1, 8, 5, 4, 4, 4, 3, 2, 1, 1, 6, 1};
        int Lugar = 0;
        int Completados = 0;
        int Personajes = 1;
             ArrayList<Personaje> ListadeHeroes = new   ArrayList<Personaje>();
        
        for (int i = 0; i < MatrizHeroe.length; i++) {
            for (int j = 0; j < MatrizHeroe[0].length; j++) {
                if (Completados == 0) {
                    Completados = PersonajesBase[Lugar];
                }
                MatrizHeroe[i][j] = new Personaje(Personajes, NombresPersonajes[Personajes - 1], RangosBase[Lugar], true);
                 ListadeHeroes.add(new Personaje(Personajes, NombresPersonajes[Personajes - 1], RangosBase[Lugar], true));
                  Completados--;
                Personajes++;
                if (Completados == 0) {
                    Lugar++;
                }
            }
        }

        Lugar = 0;
        Completados = 0;
        Personajes = 1;
                 ArrayList<Personaje> ListadeVillanos = new   ArrayList<Personaje>();
        
        for (int i = 0; i < MatrizVillano.length; i++) {
            for (int j = 0; j < MatrizVillano[0].length; j++) {
                if (Completados == 0) {
                    Completados = PersonajesBase[Lugar];
                }
                MatrizVillano[i][j] = new Personaje(Personajes, NombresPersonajesVillanos[Personajes - 1], RangosBase[Lugar], false);
                  ListadeVillanos.add(new Personaje(Personajes, NombresPersonajesVillanos[Personajes - 1], RangosBase[Lugar], false));
                Completados--;
                Personajes++;
                if (Completados == 0) {
                    Lugar++;
                }

            }
        }
              LinkedHashSet<Integer> PosicionesHeroe = new LinkedHashSet<Integer>();
         Random randNum = new Random();
        for (int i = 0; i < 40; i++) {
            if (i == 0) {
  PosicionesHeroe.add(randNum.nextInt(39 - 32) + 32);
            } else if (i <= 3 && i >= 1) {
while(PosicionesHeroe.size() < 4){
             Integer[] LHSArray = new Integer[PosicionesHeroe.size()];
        LHSArray = PosicionesHeroe.toArray(LHSArray);
                     PosicionesHeroe.add((LHSArray[0])+1);
                        PosicionesHeroe.add((LHSArray[0])-1);
                              PosicionesHeroe.add((LHSArray[0])-10);
}
           } else if (i <= 6 && i >= 4) {
                while(PosicionesHeroe.size() < 7){
                  PosicionesHeroe.add(randNum.nextInt(40 - 21) + 21);
                } 
            } else if (i <= 14 && i >= 7) {
  while(PosicionesHeroe.size() < 15){
                 PosicionesHeroe.add(randNum.nextInt(20 - 1) + 1);
                 } 
            }else{
                     while (PosicionesHeroe.size() != 40) {
                         int Temporal = randNum.nextInt(40-1)+1;
         PosicionesHeroe.add(Temporal);
         if(Temporal==37){
              PosicionesHeroe.add(40);
         }
                     }
                     
            } 

        }
              Integer[] Posiciones = new Integer[PosicionesHeroe.size()];
        Posiciones = PosicionesHeroe.toArray(Posiciones);
        
        AsignarLugar(Posiciones, 0, ListadeHeroes, 39, false);
        for(int i = 1; i <= 6; i++){
            AsignarLugar(Posiciones, i, ListadeHeroes, 39-i, false);
        }
        for(int i = 7; i <= 14; i++){
            AsignarLugar(Posiciones, i, ListadeHeroes, 1+(i-7), false);
        }
          AsignarLugar(Posiciones, 15, ListadeHeroes, 0, false);
         for(int i = 16; i < 40; i++){
               AsignarLugar(Posiciones, i, ListadeHeroes, 9+(i-16), false);
         }
     LinkedHashSet<Integer> PosicionesVillano = new LinkedHashSet<Integer>();
         Random randNumV = new Random();
        for (int i = 0; i < 40; i++) {
            if (i == 0) {
  PosicionesVillano.add(randNum.nextInt(39 - 32) + 32);
            } else if (i <= 3 && i >= 1) {
while(PosicionesVillano.size() < 4){
             Integer[] LHSArray = new Integer[PosicionesVillano.size()];
        LHSArray = PosicionesVillano.toArray(LHSArray);
                     PosicionesVillano.add((LHSArray[0])+1);
                        PosicionesVillano.add((LHSArray[0])-1);
                              PosicionesVillano.add((LHSArray[0])-10);
}
           } else if (i <= 6 && i >= 4) {
                while(PosicionesVillano.size() < 7){
                  PosicionesVillano.add(randNum.nextInt(40 - 21) + 21);
                } 
            } else if (i <= 14 && i >= 7) {
  while(PosicionesVillano.size() < 15){
                 PosicionesVillano.add(randNum.nextInt(20 - 1) + 1);
                 } 
            }else{
                     while (PosicionesVillano.size() != 40) {
                         int Temporal = randNum.nextInt(40-1)+1;
         PosicionesVillano.add(Temporal);
         if(Temporal==37){
              PosicionesVillano.add(40);
         }
                     }
            } 

        }
          Integer[] PosicionesV = new Integer[PosicionesVillano.size()];
        Posiciones = PosicionesVillano.toArray(PosicionesV);
        AsignarLugar(PosicionesV, 0, ListadeVillanos, 39, true);
        for(int i = 1; i <= 6; i++){
            AsignarLugar(PosicionesV, i, ListadeVillanos, 39-i, true);
        }
        for(int i = 7; i <= 14; i++){
            AsignarLugar(PosicionesV, i, ListadeVillanos, 1+(i-7), true);
        }
          AsignarLugar(PosicionesV, 15, ListadeVillanos, 0, true);
          
         for(int i = 16; i < 40; i++){
               AsignarLugar(PosicionesV, i, ListadeVillanos, 9+(i-16), true);
         }
    }
    public void AsignarLugar( Integer[]  Posiciones, int i, ArrayList<Personaje> ListaPersonajes, int lugar, boolean EsVillano){
        if(EsVillano){
            switch (Posiciones[i]) {
    case 1:
   this.MatrizTablero[3][0] = ListaPersonajes.get(lugar);
        break;
    case 2:
         this.MatrizTablero[3][1] = ListaPersonajes.get(lugar);
        break;
    case 3:
           this.MatrizTablero[3][2] = ListaPersonajes.get(lugar);
        break;
    case 4:
        this.MatrizTablero[3][3] = ListaPersonajes.get(lugar);
        break;
    case 5:
     this.MatrizTablero[3][4] = ListaPersonajes.get(lugar);
        break;
    case 6:
        this.MatrizTablero[3][5] = ListaPersonajes.get(lugar);
        break;
    case 7:
          this.MatrizTablero[3][6] = ListaPersonajes.get(lugar);
        break;
    case 8:
          this.MatrizTablero[3][7] = ListaPersonajes.get(lugar);
        break;
    case 9:
         this.MatrizTablero[3][8] = ListaPersonajes.get(lugar);
        break;
    case 10:
         this.MatrizTablero[3][9] = ListaPersonajes.get(lugar);
        break;
    case 11:
      this.MatrizTablero[2][0] = ListaPersonajes.get(lugar);
        break;
    case 12:
         this.MatrizTablero[2][1] = ListaPersonajes.get(lugar);
        break;
    case 13:
        this.MatrizTablero[2][2] = ListaPersonajes.get(lugar);
        break;
    case 14:
        this.MatrizTablero[2][3] = ListaPersonajes.get(lugar);
        break;
    case 15:
     this.MatrizTablero[2][4] = ListaPersonajes.get(lugar);
        break;
    case 16:
         this.MatrizTablero[2][5] = ListaPersonajes.get(lugar);
        break;
    case 17:
       this.MatrizTablero[2][6] = ListaPersonajes.get(lugar);
        break;
    case 18:
          this.MatrizTablero[2][7] = ListaPersonajes.get(lugar);
        break;
    case 19:
         this.MatrizTablero[2][8] = ListaPersonajes.get(lugar);
        break;
    case 20:
          this.MatrizTablero[2][9] = ListaPersonajes.get(lugar);
        break;
    case 21:
       this.MatrizTablero[1][0] = ListaPersonajes.get(lugar);
        break;
    case 22:
         this.MatrizTablero[1][1] = ListaPersonajes.get(lugar);
        break;
    case 23:
         this.MatrizTablero[1][2] = ListaPersonajes.get(lugar);
        break;
    case 24:
         this.MatrizTablero[1][3] = ListaPersonajes.get(lugar);
        break;
    case 25:
         this.MatrizTablero[1][4] = ListaPersonajes.get(lugar);
        break;
    case 26:
         this.MatrizTablero[1][5] = ListaPersonajes.get(lugar);
        break;
    case 27:
          this.MatrizTablero[1][6] = ListaPersonajes.get(lugar);
        break;
    case 28:
         this.MatrizTablero[1][7] = ListaPersonajes.get(lugar);
        break;
    case 29:
        this.MatrizTablero[1][8] = ListaPersonajes.get(lugar);
        break;
    case 30:
        this.MatrizTablero[1][9] = ListaPersonajes.get(lugar);
        break;
    case 31:
            this.MatrizTablero[0][0] = ListaPersonajes.get(lugar);
        break;
    case 32:
            this.MatrizTablero[0][1] = ListaPersonajes.get(lugar);
        break;
    case 33:
          this.MatrizTablero[0][2] = ListaPersonajes.get(lugar);
        break;
    case 34:
            this.MatrizTablero[0][3] = ListaPersonajes.get(lugar);
        break;
    case 35:
           this.MatrizTablero[0][4] = ListaPersonajes.get(lugar);
        break;
    case 36:
            this.MatrizTablero[0][5] = ListaPersonajes.get(lugar);
        break;
    case 37:
           this.MatrizTablero[0][6] = ListaPersonajes.get(lugar);
        break;
    case 38:
            this.MatrizTablero[0][7] = ListaPersonajes.get(lugar);
        break;
    case 39:
           this.MatrizTablero[0][8] = ListaPersonajes.get(lugar);
        break;
    case 40:
           this.MatrizTablero[0][9] = ListaPersonajes.get(lugar);
        break;
   
}
        }else{
              switch (Posiciones[i]) {
    case 1:
   this.MatrizTablero[6][0] = ListaPersonajes.get(lugar);
        break;
    case 2:
         this.MatrizTablero[6][1] = ListaPersonajes.get(lugar);
        break;
    case 3:
           this.MatrizTablero[6][2] = ListaPersonajes.get(lugar);
        break;
    case 4:
        this.MatrizTablero[6][3] = ListaPersonajes.get(lugar);
        break;
    case 5:
     this.MatrizTablero[6][4] = ListaPersonajes.get(lugar);
        break;
    case 6:
        this.MatrizTablero[6][5] = ListaPersonajes.get(lugar);
        break;
    case 7:
          this.MatrizTablero[6][6] = ListaPersonajes.get(lugar);
        break;
    case 8:
          this.MatrizTablero[6][7] = ListaPersonajes.get(lugar);
        break;
    case 9:
         this.MatrizTablero[6][8] = ListaPersonajes.get(lugar);
        break;
    case 10:
         this.MatrizTablero[6][9] = ListaPersonajes.get(lugar);
        break;
    case 11:
      this.MatrizTablero[7][0] = ListaPersonajes.get(lugar);
        break;
    case 12:
         this.MatrizTablero[7][1] = ListaPersonajes.get(lugar);
        break;
    case 13:
        this.MatrizTablero[7][2] = ListaPersonajes.get(lugar);
        break;
    case 14:
        this.MatrizTablero[7][3] = ListaPersonajes.get(lugar);
        break;
    case 15:
     this.MatrizTablero[7][4] = ListaPersonajes.get(lugar);
        break;
    case 16:
         this.MatrizTablero[7][5] = ListaPersonajes.get(lugar);
        break;
    case 17:
       this.MatrizTablero[7][6] = ListaPersonajes.get(lugar);
        break;
    case 18:
          this.MatrizTablero[7][7] = ListaPersonajes.get(lugar);
        break;
    case 19:
         this.MatrizTablero[7][8] = ListaPersonajes.get(lugar);
        break;
    case 20:
          this.MatrizTablero[7][9] = ListaPersonajes.get(lugar);
        break;
    case 21:
       this.MatrizTablero[8][0] = ListaPersonajes.get(lugar);
        break;
    case 22:
         this.MatrizTablero[8][1] = ListaPersonajes.get(lugar);
        break;
    case 23:
         this.MatrizTablero[8][2] = ListaPersonajes.get(lugar);
        break;
    case 24:
         this.MatrizTablero[8][3] = ListaPersonajes.get(lugar);
        break;
    case 25:
         this.MatrizTablero[8][4] = ListaPersonajes.get(lugar);
        break;
    case 26:
         this.MatrizTablero[8][5] = ListaPersonajes.get(lugar);
        break;
    case 27:
          this.MatrizTablero[8][6] = ListaPersonajes.get(lugar);
        break;
    case 28:
         this.MatrizTablero[8][7] = ListaPersonajes.get(lugar);
        break;
    case 29:
        this.MatrizTablero[8][8] = ListaPersonajes.get(lugar);
        break;
    case 30:
        this.MatrizTablero[8][9] = ListaPersonajes.get(lugar);
        break;
    case 31:
            this.MatrizTablero[9][0] = ListaPersonajes.get(lugar);
        break;
    case 32:
            this.MatrizTablero[9][1] = ListaPersonajes.get(lugar);
        break;
    case 33:
          this.MatrizTablero[9][2] = ListaPersonajes.get(lugar);
        break;
    case 34:
            this.MatrizTablero[9][3] = ListaPersonajes.get(lugar);
        break;
    case 35:
           this.MatrizTablero[9][4] = ListaPersonajes.get(lugar);
        break;
    case 36:
            this.MatrizTablero[9][5] = ListaPersonajes.get(lugar);
        break;
    case 37:
           this.MatrizTablero[9][6] = ListaPersonajes.get(lugar);
        break;
    case 38:
            this.MatrizTablero[9][7] = ListaPersonajes.get(lugar);
        break;
    case 39:
           this.MatrizTablero[9][8] = ListaPersonajes.get(lugar);
        break;
    case 40:
           this.MatrizTablero[9][9] = ListaPersonajes.get(lugar);
        break;
}
        }
       
    }
    public Personaje[][] getMatrizTablero() {
        return this.MatrizTablero;
    }

    public Personaje[][] getMatrizHeroe() {
        return MatrizHeroe;
    }

    public Personaje[][] getMatrizVillano() {
        return MatrizVillano;
    }
    public int getGanadorPorBandera() {
        return GanadorPorBandera;
    }
    public boolean isTurnoHeroe() {
        return TurnoHeroe;
    }
    public void setMatrizTablero(Personaje[][] MatrizTablero) {
        this.MatrizTablero = MatrizTablero;
    }
    public void setMatrizHeroe(Personaje[][] MatrizHeroe) {
        this.MatrizHeroe = MatrizHeroe;
    }
    public void setMatrizVillano(Personaje[][] MatrizVillano) {
        this.MatrizVillano = MatrizVillano;
    }
    public void setTurnoHeroe(boolean TurnoHeroe) {
        this.TurnoHeroe = TurnoHeroe;
    }
    public void setGanadorPorBandera(int GanadorPorBandera) {
        this.GanadorPorBandera = GanadorPorBandera;
    }
    public boolean AunTieneNulos(int Posicion) {
        for (int i = 0; i < MatrizTablero.length; i++) {
            if (MatrizTablero[Posicion][i] == null) {
                return true;
            }
        }
        return false;
    }
    public boolean Movimiento(Dimension Tablero, Dimension CuadroHeroes, Dimension CuadroVillanos) {
        if (AsignaciondeLugares) {
            if (TurnoHeroe) {
                if ((CuadroHeroes.height != -1 && CuadroHeroes.width != -1)) {
                    MatrizTablero[Tablero.height][Tablero.width] = MatrizHeroe[CuadroHeroes.height][CuadroHeroes.width];
                    MatrizHeroe[CuadroHeroes.height][CuadroHeroes.width].setVivo(true);
                    ContadorSeleccion++;
                    if (ContadorSeleccion == 40) {
                        TurnoHeroe = false;
                    }
                    return true;
                }
            } else {
                if (CuadroVillanos.height != -1 && CuadroVillanos.width != -1) {

                    if (MatrizTablero[Tablero.height][Tablero.width] == null) {
                        MatrizTablero[Tablero.height][Tablero.width] = MatrizVillano[CuadroVillanos.height][CuadroVillanos.width];
                        MatrizVillano[CuadroVillanos.height][CuadroVillanos.width].setVivo(true);
                    }
                    ContadorSeleccion--;
                    if (ContadorSeleccion == 0) {
                        TurnoHeroe = true;
                        AsignaciondeLugares = false;
                    }
                    return true;
                }
            }
        } else {
            return Controlador_de_Movimientos(Tablero);
        }
        return false;
    }
    public boolean Controlador_de_Movimientos(Dimension CoordenadasNuevas) {
try{
        if (CoordTablero_Viejas.width == -1 && CoordTablero_Viejas.height == -1) {
            if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] == null) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un jugador");
                CoordTablero_Viejas = new Dimension(-1, -1);
                return false;
            }
            if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == 11) {
                JOptionPane.showMessageDialog(null, "Es una bomba, no se mueve");
                CoordTablero_Viejas = new Dimension(-1, -1);
                return false;
            }
            if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == 12) {
                JOptionPane.showMessageDialog(null, "Es un planeta, no se mueve");
                CoordTablero_Viejas = new Dimension(-1, -1);
                return false;
            }
            if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == 41) {
                JOptionPane.showMessageDialog(null, "Zona Prohibida");
                CoordTablero_Viejas = new Dimension(-1, -1);
                return false;
            }
            if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano() != this.TurnoHeroe) {
                JOptionPane.showMessageDialog(null, "No es su turno");
                CoordTablero_Viejas = new Dimension(-1, -1);
                return false;
            }
            CoordTablero_Viejas = new Dimension(CoordenadasNuevas.width, CoordenadasNuevas.height);
            return false;
        } else {
            if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] != null) { 
                if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == -1) {
                    JOptionPane.showMessageDialog(null, "Zona Prohibida");
                    CoordTablero_Viejas = new Dimension(-1, -1);
                    return false;
                } else if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano() != TurnoHeroe) {
                    if(MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango()==2){
                        int reply = 0;
                        if (reply == 0) {
                            return Combates(CoordenadasNuevas);
                    }}else
                    if ((CoordenadasNuevas.height == CoordTablero_Viejas.height + 1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height - 1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width +1)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width -1)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height+1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width+1)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height-1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width-1)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height+1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width-1)
                               || (CoordenadasNuevas.height == CoordTablero_Viejas.height-1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width+1)
                            ) {
                        int reply = 0;
                        if (reply == 0) {

                            return Combates(CoordenadasNuevas);
                        } else {
                            return false;
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "No se puede combatir" + MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano());

                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El lugar esta ocupado");
                    CoordTablero_Viejas = new Dimension(-1, -1);
                    return false;
                }
            }
            if (movimientos_porFicha(CoordenadasNuevas)) {
                MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] = MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width];
                MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = null;
                setTurnoHeroe(!this.TurnoHeroe);
                String Turno = "";
                if (TurnoHeroe) {
                    Turno = "héroes";
                } else {
                    Turno = "villanos";
                }
                JOptionPane.showMessageDialog(null, "Ahora es turno de los " + Turno);
                CoordTablero_Viejas = new Dimension(-1, -1);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Movimiento no válido");
            }
        }
        return false;
}catch(Exception e){
    return false;
}
    }
    public boolean movimientos_porFicha(Dimension CoordenadasNuevas) {
        if (CoordenadasNuevas.height != CoordTablero_Viejas.height && CoordenadasNuevas.width != CoordTablero_Viejas.width) {
            return false;
        } 
        if( MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango()!=2){
              if ((CoordenadasNuevas.height == CoordTablero_Viejas.height + 1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height - 1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width +1)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width -1)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height+1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width+1)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height-1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width-1)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height+1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width-1)
                               || (CoordenadasNuevas.height == CoordTablero_Viejas.height-1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width+1)
                            ) {
              return true;
              }
            return false;
        }
return true;
    }
    public boolean Combates(Dimension CoordenadasNuevas) {
        ImageIcon icon1;
        ImageIcon icon2;
        if (this.TurnoHeroe) {
            icon1 = new ImageIcon(getClass().getResource("/Imagenes/Fichas/Villanos/" + MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getID() + ".jpg"));
            icon2 = new ImageIcon(getClass().getResource("/Imagenes/Fichas/Heroes/" + MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getID() + ".jpg"));
        } else {
            icon1 = new ImageIcon(getClass().getResource("/Imagenes/Fichas/Heroes/" + MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getID() + ".jpg"));
            icon2 = new ImageIcon(getClass().getResource("/Imagenes/Fichas/Villanos/" + MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getID() + ".jpg"));
        }
        String Texto = 
                MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getNombre() +"de Rango: " + MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango()
                + " VS "+   MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getNombre()
                + "de Rango: "+ MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango();
        JPanel Panel_Combate = new JPanel();
        JPanel Temporal = new JPanel();
        JLabel MostrarTexto = new JLabel(Texto, SwingConstants.CENTER);
        Panel_Combate.setLayout(new BorderLayout()); 
        Panel_Combate.add(MostrarTexto, BorderLayout.NORTH);
        Panel_Combate.add(Temporal, BorderLayout.CENTER);
        Panel_Combate.add(MostrarTexto, BorderLayout.SOUTH);
       setTurnoHeroe(!this.TurnoHeroe);
        if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] == null || MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] == null) {
            JOptionPane.showMessageDialog(null, "Combate no válido");
            return false;
        }
        if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == 12) {
if(MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].isHeroe_Villano()){
      JOptionPane.showMessageDialog(
                null,
                "Has salavado la Tierra!",
                "Encontró la Tierra", JOptionPane.PLAIN_MESSAGE,icon2 );
   this.setGanadorPorBandera(1);
}else{
           JOptionPane.showMessageDialog(
                null,
                "Has conquistado la Tierra!",
                "Encontró la Tierra", JOptionPane.PLAIN_MESSAGE,icon1 );
    this.setGanadorPorBandera(2);
}
            return true;
        }
        if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == 11) {
            if (MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango() == 3) {
               JOptionPane.showMessageDialog(
                null,
                "No explotó",
                "BOMBA", JOptionPane.PLAIN_MESSAGE,icon2 );
                PersonajeMuerto(MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano(), MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getID());
                MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] = MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width];
                      MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = null;
                return true;
            } 
               JOptionPane.showMessageDialog(
                null,
                "Explotó",
                "BOMBA", JOptionPane.PLAIN_MESSAGE,icon1 );
                PersonajeMuerto(MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].isHeroe_Villano(), MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getID());
                MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = null;
            return true;
        }
             JOptionPane.showMessageDialog(
                null,
                Panel_Combate,
                "Pelea en curso", JOptionPane.PLAIN_MESSAGE);
        if (MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango() == 1 && MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == 10) {
            PersonajeMuerto(MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano(), MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango());
            MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] = MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width];
             MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = null;
            return true;
        }
        if (MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango() > MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango()) {
            PersonajeMuerto(MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano(), MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getID());
            MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] = MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width];
             MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = null;
            return true;
        }
        if (MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango() < MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango()) {
            PersonajeMuerto(MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].isHeroe_Villano(), MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getID());
            MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width];
                 MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width]= null;
            return true;
        }
        if (MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango() == MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango()) {
            PersonajeMuerto(MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano(), MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getID());
            PersonajeMuerto(MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].isHeroe_Villano(), MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getID());
            MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] = null;
            MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = null;
            return true;
        }
        return false;
    }
    public void PersonajeMuerto(boolean esHeroeVillano, int IdPersonaje) {
        if (esHeroeVillano) {
            for (int i = 0; i < this.MatrizHeroe.length; i++) {
                for (int j = 0; j < this.MatrizHeroe[0].length; j++) {
                    if (this.MatrizHeroe[i][j].getID() == IdPersonaje) {
                        this.MatrizHeroe[i][j].setVivo(false);
                    }
                }
            }
        } else {
            for (int i = 0; i < this.MatrizVillano.length; i++) {
                for (int j = 0; j < this.MatrizVillano[0].length; j++) {
                    if (this.MatrizVillano[i][j].getID() == IdPersonaje) {
                        this.MatrizVillano[i][j].setVivo(false);
                    }
                }
            }

        }
    }
    public int SinMovimientos(){
        boolean VillanoTieneMovimientos = false;
         boolean HeroeTieneMovimientos = false;
    for (int i = 0; i < this.MatrizTablero.length; i++) {
                for (int j = 0; j < this.MatrizTablero[0].length; j++) {
                    if(MatrizTablero[i][j] != null){
                        if(MatrizTablero[i][j].isHeroe_Villano()){
                            if(i==0 && j==0){
                                 if(this.MatrizTablero[i][j+1]==null
                                   || this.MatrizTablero[i+1][j]==null){
                            HeroeTieneMovimientos=true;
                            }
                            }else if(i==0 && j==9){
                                 if( this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null    ){
                                 HeroeTieneMovimientos=true;
                            }
                            }else if(i==9 && j==0){
                                 if(this.MatrizTablero[i-1][j]==null 
                                    || this.MatrizTablero[i][j+1]==null){
                                 HeroeTieneMovimientos=true;
                            }
                            }else if(i==9 && j==9){
                                 if(this.MatrizTablero[i-1][j]==null 
                                    || this.MatrizTablero[i][j-1]==null   ){
                                 HeroeTieneMovimientos=true;
                            }
                            }else if(i==0){
                                 if(this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null    ||this.MatrizTablero[i][j+1]==null){
                                 HeroeTieneMovimientos=true;
                            }
                            }else if(j==0){
                                 if(this.MatrizTablero[i-1][j]==null || this.MatrizTablero[i+1][j]==null
                                     ||this.MatrizTablero[i][j+1]==null){
                                 HeroeTieneMovimientos=true;
                            }
                            }else if(i==9){
                                 if(this.MatrizTablero[i-1][j]==null 
                                    || this.MatrizTablero[i][j-1]==null    ||this.MatrizTablero[i][j+1]==null){
                                 HeroeTieneMovimientos=true;
                            }
                            }else if(j==9){
                                 if(this.MatrizTablero[i-1][j]==null || this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null   ){
                                 HeroeTieneMovimientos=true;  
                            }
                            }else if(this.MatrizTablero[i-1][j]==null || this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null    ||this.MatrizTablero[i][j+1]==null){
                                 HeroeTieneMovimientos=true;  
                            }
                    }else{
                                if(i==0 && j==0){
                                 if(this.MatrizTablero[i][j+1]==null
                                   || this.MatrizTablero[i+1][j]==null){
                                VillanoTieneMovimientos=true;  
                            }
                            }else if(i==0 && j==9){
                                 if( this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null    ){
                                     VillanoTieneMovimientos=true;   
                            }
                            }else if(i==9 && j==0){
                                 if(this.MatrizTablero[i-1][j]==null 
                                    || this.MatrizTablero[i][j+1]==null){
                                     VillanoTieneMovimientos=true;   
                            }
                            }else if(i==9 && j==9){
                                 if(this.MatrizTablero[i-1][j]==null 
                                    || this.MatrizTablero[i][j-1]==null   ){
                                     VillanoTieneMovimientos=true;   
                            }
                            }else if(i==0){
                                 if(this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null    ||this.MatrizTablero[i][j+1]==null){
                                     VillanoTieneMovimientos=true;   
                            }
                            }else if(j==0){
                                 if(this.MatrizTablero[i-1][j]==null || this.MatrizTablero[i+1][j]==null
                                     ||this.MatrizTablero[i][j+1]==null){
                                     VillanoTieneMovimientos=true;   
                            }
                            }else if(i==9){
                                 if(this.MatrizTablero[i-1][j]==null 
                                    || this.MatrizTablero[i][j-1]==null    ||this.MatrizTablero[i][j+1]==null){
                                     VillanoTieneMovimientos=true;   
                            }
                            }else if(j==9){
                                 if(this.MatrizTablero[i-1][j]==null || this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null   ){
                                     VillanoTieneMovimientos=true;   
                            }
                            }else if(this.MatrizTablero[i-1][j]==null || this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null    ||this.MatrizTablero[i][j+1]==null){
                                     VillanoTieneMovimientos=true;                           
                            }                       
                        }                   
                    }
                }
    }
    if(VillanoTieneMovimientos && HeroeTieneMovimientos){
        return 1;
    }else if(VillanoTieneMovimientos){
        return 2;
    }else if(HeroeTieneMovimientos){
        return 3;
    }else{
        return 4;
    }
    }
}
