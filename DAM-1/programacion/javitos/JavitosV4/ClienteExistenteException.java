package javitos_bbdd_relacionales;

/**
 *
 * @author dmunsig
 */
public class ClienteExistenteException extends Exception {
    
    ClienteExistenteException(String mensaje) {
        super(mensaje);
    }
}
