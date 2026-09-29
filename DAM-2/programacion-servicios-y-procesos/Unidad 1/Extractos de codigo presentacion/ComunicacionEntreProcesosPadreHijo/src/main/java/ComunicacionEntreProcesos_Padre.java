import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class ComunicacionEntreProcesos_Padre {
    public static void main(String[] args) {
        try {
            // 1. Crear y lanzar el proceso hijo ejecutable .jar
            ProcessBuilder proBuil = new ProcessBuilder("java", "");
            Process procesoHijo = proBuil.start();

            // 2. Canal para leer del teclado
            InputStream streamLeerDeTeclado = System.in;
            InputStreamReader canalLeerDeTeclado = new InputStreamReader(streamLeerDeTeclado);
            BufferedReader maquinaLeerDeTeclado = new BufferedReader(canalLeerDeTeclado);

            // 3. Canal para leer lo que emita el proceso hijo (su System.out)
            InputStream streamLeerDeHijo = procesoHijo.getInputStream();
            InputStreamReader canalLeerDeHijo = new InputStreamReader(streamLeerDeHijo);
            BufferedReader maquinaLeerDeHijo = new BufferedReader(canalLeerDeHijo);

            // 4. Canal para escribir datos hacia el proceso hijo (su System.in)
            OutputStream streamEscribirEnHijo = procesoHijo.getOutputStream();
            PrintStream maquinaEscribirEnHijo = new PrintStream(streamEscribirEnHijo, true);

            // 5. Leer de teclado y enviar al hijo
            System.out.println("Introduce varias lineas de texto, y acaba con una linea que sea FIN:");
            String lineaLeidaPorTeclado = maquinaLeerDeTeclado.readLine();

            while (lineaLeidaPorTeclado != null && !lineaLeidaPorTeclado.equals("FIN")) {
                // Enviar línea al proceso hijo
                maquinaEscribirEnHijo.println(lineaLeidaPorTeclado);
                lineaLeidaPorTeclado = maquinaLeerDeTeclado.readLine();
            }

            // Se envía también el comando FIN para detener la lectura del hijo
            if (lineaLeidaPorTeclado != null) {
                maquinaEscribirEnHijo.println(lineaLeidaPorTeclado);
            }

            // 6. Leer la respuesta enviada por el hijo
            String textoEnviadoPorElHijo = maquinaLeerDeHijo.readLine();
            System.out.println("Respuesta del proceso hijo:");
            System.out.println(textoEnviadoPorElHijo);

            // Cerrar flujos
            maquinaEscribirEnHijo.close();
            maquinaLeerDeHijo.close();
            maquinaLeerDeTeclado.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}