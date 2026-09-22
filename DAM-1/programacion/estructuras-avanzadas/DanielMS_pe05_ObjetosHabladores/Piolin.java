package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 *
 * @author DanielMS
 */
public class Piolin extends Canario implements Hablador {
    
    private int numPeliculas;
    
    public Piolin(String sexo, int edad, String canta, int numPeliculas) {
        super(sexo, edad, canta);
        
        this.numPeliculas = numPeliculas;
    }

    public int getNumPeliculas() {
        return numPeliculas;
    }

    public void setNumPeliculas(int nuevoNumPeliculas) {
        this.numPeliculas = nuevoNumPeliculas;
    }

    public void hablar() {
        System.out.println("Hola, soy piolin y se hablar.");
    }    
}
