import java.io.IOException;

public class EjempoRuntime {
    public static void main(String[] args) {
        try {
            // Ejemplo 1: Ejecutar sin parámetros
            Runtime.getRuntime().exec("Notepad.exe");

            // Ejemplo 2: Ejecutar pasando un archivo como argumento
            Runtime.getRuntime().exec("Notepad.exe notas.txt");

            // Ejemplo 3: Usando un array de Strings
            String[] infoProceso = {"Notepad.exe", "notas.txt"};
            Process proceso = Runtime.getRuntime().exec(infoProceso);

            // Esperar a que el proceso termine y obtener el código de salida
            int codigoRetorno = proceso.waitFor();
            System.out.println("Fin de la ejecución: " + codigoRetorno);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
