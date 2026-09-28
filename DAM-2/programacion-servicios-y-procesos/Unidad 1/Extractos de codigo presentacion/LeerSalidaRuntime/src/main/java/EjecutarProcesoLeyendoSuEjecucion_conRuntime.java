import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EjecutarProcesoLeyendoSuEjecucion_conRuntime {
    public static void main(String[] args) {
        Runtime builder = Runtime.getRuntime();
        String cmd = "ls -l";

        try {
            // Ejecutamos el proceso
            Process out = builder.exec(cmd);

            // Lector para interceptar la salida del proceso
            BufferedReader bf = new BufferedReader(new InputStreamReader(out.getInputStream()));

            System.out.println("La ejecución del proceso devuelve: ");
            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
            }

            bf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}