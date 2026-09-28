import java.io.File;
import java.io.IOException;

public class CrearYLanzarProcesoSimple_ConProcessBuilder {
    public static void main(String[] args) {
        // Encierro toda la lógica con un try-catch y controlo los errores
        try {
            // Creo un proceso nuevo en dos pasos:
            // 1. Creo un ProcessBuilder con la instrucción y sus argumentos (ej: ls -l)
            ProcessBuilder obProBuil = new ProcessBuilder("ls", "-l");

            // Indicamos dónde buscar la instrucción.
            // Con "." usará el directorio actual del proyecto.
            obProBuil.directory(new File("."));

            // 2. Creo y lanzo el proceso
            Process obProcesoHijo = obProBuil.start();

            // waitFor() obliga a que el programa quede esperando a que finalice el proceso hijo.
            // Devuelve el código de salida (exit value) emitido por el proceso.
            int codExit = obProcesoHijo.waitFor();

            // Escribimos el resultado de la ejecución
            System.out.println("La ejecución de 'ls' y '-l' devuelve " + codExit);

        } catch (IOException ex) {
            System.err.println("Excepción de E/S!!");
            ex.printStackTrace();
            // Finaliza el programa provocando un código de salida específico
            System.exit(-1);
        } catch (InterruptedException ex) {
            System.err.println("El proceso hijo finalizó de forma incorrecta");
            ex.printStackTrace();
            System.exit(-2);
        }

        System.exit(0);
    }
}