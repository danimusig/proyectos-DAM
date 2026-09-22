package dam1_dmunsig_ListaArray;

/**
 *
 * @author dmunsig
 */
public class Main {

    public static void main(String[] args) {
        ListaNumerica miLista = new ListaNumerica();

        System.out.println("-- Insercion al final y al principio --");
        miLista.insertarAlFinal(10);
        miLista.insertarAlFinal(20);
        miLista.insertarAlPrincipio(5); 
        // Resultado esperado: [5, 10, 20, ...]
        System.out.println(miLista.toString());

        System.out.println("\n-- Insercion en posicion --");
        miLista.insertarEnLaPosicion(1, 7); 
        // Resultado esperado: [5, 7, 10, 20, ...]
        System.out.println(miLista.toString());

        System.out.println("\n-- Busqueda --");
        int valor = miLista.buscar(2);
        System.out.println("En la posicion 2 esta el: " + valor);

        System.out.println("\n -- Eliminacion --");
        miLista.eliminarLaPrimera(); // Quita el 5
        miLista.eliminar(1);        // Quita el 10 (que ahora estaba en la pos 1)
        miLista.eliminiarLaUltima(); // Quita el 20
        
        System.out.println(miLista.toString());

        System.out.println("\n -- Union de Listas --");
        ListaNumerica otraLista = new ListaNumerica();
        otraLista.insertarAlFinal(100);
        otraLista.insertarAlFinal(200);
        
        miLista.unirDosListas(otraLista);
    }
}
