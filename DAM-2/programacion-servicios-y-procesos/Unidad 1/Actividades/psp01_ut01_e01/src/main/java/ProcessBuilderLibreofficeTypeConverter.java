import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase accede a las utilidades de conversion de libreoffice usando ProcessBuilder
 * @author danielms
 * @version 1.0
 *
 */
public class ProcessBuilderLibreofficeTypeConverter {

    public static void convertirPDF(String archivo) {
        try {
            String[] comandoConvertirPDF = new String[5];
            comandoConvertirPDF[0] = "libreoffice";
            comandoConvertirPDF[1] = "--headless";
            comandoConvertirPDF[2] = "--convert-to";
            comandoConvertirPDF[3] = "pdf";
            comandoConvertirPDF[4] = archivo;

            ProcessBuilder procesoCreado = new ProcessBuilder(comandoConvertirPDF);
            Process procesoEnEjecucion = procesoCreado.start();

            procesoEnEjecucion.waitFor();
            // Validacion básica en un futuro se podría avisar de cual fue el error basándose en el exit value.
            if (procesoEnEjecucion.exitValue() != 0) {
                System.err.println("Error: No se pudo exportar el archivo a PDF.");
            } else {
                System.out.println("La conversion fue realizada satisfactoriamente.");
            }
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void convertirJPEG(String archivo) {
        try {
            String[] comandoConvertirJPEG = new String[5];
            comandoConvertirJPEG[0] = "libreoffice";
            comandoConvertirJPEG[1] = "--headless";
            comandoConvertirJPEG[2] = "--convert-to";
            comandoConvertirJPEG[3] = "jpeg";
            comandoConvertirJPEG[4] = archivo;

            ProcessBuilder procesoCreado = new ProcessBuilder(comandoConvertirJPEG);
            Process procesoEnEjecucion = procesoCreado.start();

            procesoEnEjecucion.waitFor();

            if (procesoEnEjecucion.exitValue() != 0) {
                System.err.println("Error: No se pudo exportar el archivo a JPEG.");
            } else {
                System.out.println("La conversion fue realizada satisfactoriamente.");
            }
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void convertirHTML(String archivo) {
        try {
            String[] comandoConvertirHTML = new String[5];
            comandoConvertirHTML[0] = "libreoffice";
            comandoConvertirHTML[1] = "--headless";
            comandoConvertirHTML[2] = "--convert-to";
            comandoConvertirHTML[3] = "html";
            comandoConvertirHTML[4] = archivo;

            ProcessBuilder procesoCreado = new ProcessBuilder(comandoConvertirHTML);
            Process procesoEnEjecucion = procesoCreado.start();

            procesoEnEjecucion.waitFor();

            if (procesoEnEjecucion.exitValue() != 0) {
                System.err.println("Error: No se pudo exportar el archivo a HTML.");
            } else {
                System.out.println("La conversion fue realizada satisfactoriamente.");
            }
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }

    }


    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println(" - Introduzca la ruta al archivo que desea convertir:");
            String archivo = sc.nextLine().trim();
            if (!new File(archivo).exists()) {
                do {
                    System.out.println(" El archivo a convertir no existe.");
                    System.out.println(" - Introduzca la ruta al archivo: (0 para salir)");
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
            System.out.println("Debe introducir un tipo de dato válido.");
        }
    }
}
