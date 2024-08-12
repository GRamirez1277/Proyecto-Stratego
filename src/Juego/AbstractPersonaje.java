package Juego;

public abstract class AbstractPersonaje {
    protected int rango;
    protected boolean vivo;
    protected boolean heroeVillano;
    protected String nombre;
    protected int id;

    public AbstractPersonaje(int rango, boolean heroeVillano, String nombre, int id) {
        this.rango = rango;
        this.heroeVillano = heroeVillano;
        this.nombre = nombre;
        this.id = id;
        this.vivo = true;
    }

    public int getRango() {
        return rango;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public boolean isHeroeVillano() {
        return heroeVillano;
    }
}