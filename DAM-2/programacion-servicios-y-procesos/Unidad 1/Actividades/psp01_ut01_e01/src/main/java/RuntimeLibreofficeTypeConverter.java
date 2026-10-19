import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase accede a las utilidades de conversion de libreoffice usando Runtime
 * @author danielms
 * @version 1.0
 *
 */
public class RuntimeLibreofficeTypeConverter {

    public static void convertirPDF(String archivo) {
        try {
            Process conversorPDF = Runtime.getRuntime().exec("libreoffice --headless --convert-to pdf " + archivo);

            int codigoRetorno = conversorPDF.waitFor();
            if (codigoRetorno != 0) {
                System.out.println("Hubo un error al hacer la conversion.");
            } else {
                System.out.println("Conversion realizada exitosamente.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void convertirJPEG(String archivo) {
        try {
            Process conversorJPEG = Runtime.getRuntime().exec("libreoffice --headless --convert-to jpeg " + archivo);

            int codigoRetorno = conversorJPEG.waitFor();
            if (codigoRetorno != 0) {
                System.out.println("Hubo un error al hacer la conversion.");
            } else {
                System.out.println("Conversion realizada exitosamente.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void convertirHTML(String archivo) {
        try {
            Process conversorHTML = Runtime.getRuntime().exec("libreoffice --headless --convert-to html " + archivo);

            int codigoRetorno = conversorHTML.waitFor();
            if (codigoRetorno != 0) {
                System.out.println("Hubo un error al hacer la conversion.");
            } else {
                System.out.println("Conversion realizada exitosamente.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("- Introduzca la ruta al archivo que desea convertir: ");
            String archivo = sc.nextLine().trim();
            if (!new File(archivo).exists()) {
                do {
                    System.out.println(" El archivo a convertir no existe.");
                    System.out.println(" - Reintroduzca la ruta al archivo: (0 para salir)");
                    archivo = sc.nextLine().trim();
                    if (archivo.equals("0")) break;
                } while (!new File(archivo).exists());
            } else {

                int formato;

                do {
                    System.out.println(" - Seleccione el formato al que desea exportar: ");
                    System.out.println(" 1. PDF");
                    System.out.println(" 2. JPEG");
                    System.out.println(" 3. HTML");
                    System.out.println(" 4. Salir");
                    formato = sc.nextInt();

                    switch (formato) {
                        case 1:
                            convertirPDF(archivo);
                            break;
                        case 2:
                            convertirJPEG(archivo);
                            break;
                        case 3:
                            convertirHTML(archivo);
                            break;
                        default:
                            System.out.println("Cerrando programa.");
                    }
                } while (formato != 4);
            }
        } catch(InputMismatchException ex){
            System.out.println("ERROR: Debe introducir un numero.");
        }
    }
}
