import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ComunicacionEntreProcesos_Hijo {
    public static void main(String[] args) {
        String linea;
        int letras = 0, palabras = 0, lineas = 0;

        try {
            // 1. Canal para leer desde la entrada estándar
            InputStream streamLeerDeEstandar = System.in;
            InputStreamReader canalLeerDeEstandar = new InputStreamReader(streamLeerDeEstandar);
            BufferedReader maquinaLeerDeEstandar = new BufferedReader(canalLeerDeEstandar);

            // Lee la primera línea
            linea = maquinaLeerDeEstandar.readLine();

            while (linea != null && !linea.equals("FIN")) {
                lineas++;

                // Recorrer caracteres
                for (int i = 0; i < linea.length(); i++) {
                    char cadaChar = linea.charAt(i);
                    if (Character.isLetter(cadaChar) || Character.isDigit(cadaChar)) {
                        letras++;
                    }
                }

                // Separar palabras
                String[] elementos = linea.split("\\s+");
                if (linea.trim().length() > 0) {
                    palabras += elementos.length;
                }

                // Leer siguiente línea
                linea = maquinaLeerDeEstandar.readLine();
            }

            // Enviar respuesta por la salida estándar
            System.out.println("Se han encontrado " + lineas + " líneas, que en total contienen "
                    + palabras + " palabras y " + letras + " letras.");

        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }
}