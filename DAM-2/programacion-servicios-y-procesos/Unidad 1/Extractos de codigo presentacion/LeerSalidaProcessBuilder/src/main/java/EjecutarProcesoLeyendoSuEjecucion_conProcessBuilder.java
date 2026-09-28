import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EjecutarProcesoLeyendoSuEjecucion_conProcessBuilder {
    public static void main(String[] args) {
        try {
            // Creo un array con el comando y argumentos
            String[] argumentos = new String[2];
            argumentos[0] = "ls";
            argumentos[1] = "-l";

            // 1. Instanciar el ProcessBuilder
            ProcessBuilder obProBuil = new ProcessBuilder(argumentos);

            // 2. Arrancar el proceso
            Process obProceso = obProBuil.start();

            // Creo un stream que se engancha a la salida estándar del proceso hijo
            InputStream obInpStr = obProceso.getInputStream();
            InputStreamReader obInpStrRea = new InputStreamReader(obInpStr);
            BufferedReader obBufRea = new BufferedReader(obInpStrRea);

            System.out.println("La ejecución del proceso devuelve: ");

            // Bucle para leer línea a línea la salida generada por el proceso
            String line;
            while ((line = obBufRea.readLine()) != null) {
                System.out.println(line);
            }

            obBufRea.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}