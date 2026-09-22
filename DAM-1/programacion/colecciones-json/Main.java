package dms.dam1._pe08_colleciones_json;

/**
 * Clase Principal para probar el funcionamiento del complejo Los Javitos.
 * @author dmunsig
 * @version 2.0
 * @see String
 * @see Cliente
 * @see Alojamiento
 * @see Javitos
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("     INICIANDO SISTEMA DE GESTIÓN JAVITOS");
        System.out.println("=================================================");
        
        // Creo el complejo Javitos.
        Javitos complejo = new Javitos();

        // Importo desde el JSON ahora para usar esos datos en los metodos.
        System.out.println("\n>>> IMPORTANDO DATOS DESDE JSON <<<");
        complejo.importClientesFromJSON("clientes.json");
        complejo.importAlojamientosFromJSON("alojamientos.json");

        // Probamos que se ha importado correctamente.
        System.out.println("\nImportacion:");
        complejo.listadoClientes();  
        complejo.listadoAlojamientos();

        // Prueba de altas manuales
        System.out.println("\n\n>>> DANDO DE ALTA NUEVOS REGISTROS MANUALMENTE");
        
        // Creamos un cliente "VIP" que ha venido muchas veces
        Cliente clienteNuevo = new Cliente("Leopoldo el Hospedado", "99999999Z", "leopoldo@test.com", "Madrid");
        clienteNuevo.setVecesAlojado(20); // Lo ponemos con muchas visitas para probar el TOP
        complejo.altaCliente(clienteNuevo);

        // Creamos un alojamiento nuevo
        Alojamiento alojamientoNuevo = new Alojamiento("Cabaña del Bosque", 6, 200.0, true, true);
        alojamientoNuevo.setVecesAlquilado(50);
        complejo.altaAlojamiento(alojamientoNuevo);

        // Prueba ordenacion.
        System.out.println("\n\n>>> PRUEBA DE RANKINGS (TOP)");
        complejo.topClientes(); 
        complejo.topAlojamientos();

        // Borrado de registros.
        System.out.println("\n\n>>> ELIMINANDO REGISTROS");
        System.out.print("Intentando borrar a Mario Lopez (12345678A): ");
        complejo.bajaCliente("12345678A");
        
        System.out.print("Intentando borrar el alojamiento 'Pino': ");
        complejo.bajaAlojamiento("Pino");

        // Exportacion
        System.out.println("\n\n>>> 5. EXPORTANDO RESULTADOS FINALES A NUEVOS JSON...");
        
        // He visto en internet que es buena pratica guardar los datos en otro JSON para poder compararlos y facilitar el control de errores.
        complejo.exportClientesToJSON("clientes_final.json");
        complejo.exportAlojamientosToJSON("alojamientos_final.json");
        
        System.out.println("\n=================================================");
        System.out.println("   PRUEBA FINALIZADA CON ÉXITO");
        System.out.println("=================================================");
    }
}