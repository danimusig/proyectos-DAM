package DAM1.DanielMS_pe05_museo;

/**
 * Clase principal donde pruebo los objetos de las otras clases.
 * @author DanielMS
 * @version 1.0
 * @see Administrativo
 * @see Vigilante
 * @see Conservador
 */
public class Main {

    public static void main(String[] args) {
        //Creo los trabajadores.
        Administrativo admin1 = new Administrativo("Daniel", "1234567-D", "ES459012391818", 40, "Tarde");
        Vigilante vigil1 = new Vigilante("Pepe", "341246352-J", "FO980811110292", 1111103);
        Conservador conser1 = new Conservador("Luis", "212345123-J", "ES123123123123");
        
        //Muestro su informacion
        System.out.print(vigil1.toString());
        System.out.print(admin1.toString());
        System.out.print(conser1.toString());
    }
}
