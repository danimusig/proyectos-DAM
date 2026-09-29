import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EscribeNumeroDeLineas {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Indicar por favor el nombre del fuchero: ");
            return;
        }
        String nomFich = args[0];

        try (BufferedReader fbr = new BufferedReader(new FileReader(nomFich))) {
            int i = 0;
            String linea = fbr.readLine();
            while (linea != null) {
                System.out.println("[%5d] %s " + i++ + " " + linea);
                System.out.println();
                linea = fbr.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existe fichero " + nomFich);
        } catch (IOException e) {
            System.out.println("Error de entrada y salida: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
