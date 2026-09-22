package DAM1.DanielMS_pe05_ObjetosHabladores;

/**
 *
 * @author DanielMS
 */
public class Profesor extends Persona implements Hablador {
    
    private String despacho;
    
    private String email;

    public Profesor(String nombre, int edad, String despacho, String email) {
        super(nombre, edad);
        
        this.despacho = despacho;
        
        this.email = email;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String nuevoEmail) {
        this.email = nuevoEmail;
    }
    
    public void hablar() {
        System.out.println("Hola, soy un profesor y se hablar.");
    }
    
    
}
