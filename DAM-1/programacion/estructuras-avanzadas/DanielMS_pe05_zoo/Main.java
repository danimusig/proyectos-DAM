package DAM1.DanielMS_pe05_zoo;

import java.time.LocalDate;

/**
 * Clase principal donde pruebo los objetos de las otras clases.
 * @author DanielMS
 * @version 1.0
 * @see String
 * @see LoboGris
 * @see OsoIberico
 * @see Aguila
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("--- Gestion de Alimentacion del Zoo ---");
        
        //Creo un ejemplar de LoboGris
        LocalDate fechaLobo = LocalDate.of(2023, 5, 10);
        LoboGris lobo1 = new LoboGris("Canela", fechaLobo, "Sierra de la Culebra");
        
        //Creo un ejemplar de OsoIberico
        LocalDate fechaOso = LocalDate.of(2022, 11, 25);
        OsoIberico oso1 = new OsoIberico("Pardo", fechaOso, "Cordillera Betica");
        
        //Creo un ejemplar de Aguila
        LocalDate fechaAguila = LocalDate.of(2024, 1, 15);
        Aguila aguila1 = new Aguila("Icaro", fechaAguila, "Extremadura");
        
        //Muestro al Lobo Gris
        System.out.println(lobo1.toString());
        System.out.println(" Nombre de alimento (Getter): " + lobo1.getNOMALIMENTO());
        
        System.out.println("\n");
        
        //Muestro al Oso Iberico
        System.out.println(oso1.toString());
        System.out.println(" Fecha de entrada (Getter): " + oso1.getFechaEntrada());

        System.out.println("\n");

        //Muestro al Aguila
        System.out.println(aguila1.toString());
        System.out.println(" Cantidad de alimento (Getter): " + aguila1.getCantidad() + " kg");
        
        System.out.println("\n");
        
        //Muestro al Lobo Gris y le cambio el nombre.
        lobo1.setNombre("Lobo Feroz");
        System.out.println("\n Se ha modificado el nombre del lobo a: " + lobo1.getNombre());
    }    
}
