package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 *
 * @author DanielMS
 */
public class Lavadora extends Aparato {
    
    private int alto;
    
    private int ancho;
    
    public Lavadora(int consumo, double precio, int alto, int ancho) {
        super(consumo, precio);
        
        this.alto = alto;
        
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int nuevoAlto) {
        this.alto = nuevoAlto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int nuevoAncho) {
        this.ancho = nuevoAncho;
    }
}
