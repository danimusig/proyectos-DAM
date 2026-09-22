package DAM1.DanielMS_pe05_PenyaBetica;

/**
 * Clase Principal para probar los metodos y objetos de las otras clases.
 * @author DanielMS
 * @version 1.0
 * @see String
 * @see Nombre
 * @see Nif
 * @see Fecha
 * @see Socio
 */
public class Main {
    
    public static void main(String[] args) {
        
        //Creo los objetos necesarios para crear al primer socio.
        Nombre nombre1 = new Nombre("Daniel", "Muñoz Sigmund");
        Nif nif1 = new Nif(21016765, 'd');
        Fecha fechaNacimiento1 = new Fecha(24,8,2000);
        Fecha FechaAlta1 = new Fecha(14,12,2025);
        //Creo el socio.
        Socio socio1 = new Socio(nombre1, nif1, fechaNacimiento1, 1, FechaAlta1);
        
        //Muestro informacion sobre el socio.
        System.out.print(socio1.toString());

    }
}
