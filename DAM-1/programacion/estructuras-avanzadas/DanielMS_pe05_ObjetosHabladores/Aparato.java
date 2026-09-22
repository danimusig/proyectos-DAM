package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 *
 * @author DanielMS
 */
public class Aparato {
    
    private int consumo;
    
    private double precio;

    public Aparato(int consumo, double precio) {
        this.consumo = consumo;
        this.precio = precio;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int nuevoConsumo) {
        this.consumo = nuevoConsumo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }
}
