import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Esta clase accede a las utilidades de conversion de libreoffice usando Runtime.exec()
 * @author danielms
 * @version 2.0
 *
 */
public class ProcessBuilderLibreofficeTypeConverter {
    private static final Logger LOGGER = Logger.getLogger(RuntimeLibreofficeTypeConverter.class.getName());

    static {
        try {
            // Configura el logeo en archivo con rotación y formato de texto plano
            FileHandler fileHandler = new FileHandler("export_procesos.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println("No se pudo inicializar el manejador de archivos de log: " + e.getMessage());
        }
    }

    public static void exportador(String archivo, String formato) {

        LOGGER.info(String.format("Iniciando exportación. Archivo origen: '%s' -> Formato destino: '%s'", archivo, formato));
        long tiempoInicio = System.currentTimeMillis();


        String[] comandoExportacion = new String[]{
                "libreoffice",
                "--headless",
                "--convert-to",
                formato,
                archivo
        };
        try {
            // Creo el proceso
            ProcessBuilder exportador = new ProcessBuilder(comandoExportacion);
            exportador.redirectErrorStream(true);
            Process exportadorEnEjecucion = exportador.start();

            // Runtime.exec() mantiene divididas las salidas de e/s y error, ProcessBuilder permite el metodo redirectErrorStream(true) que manda los errores al mismo canal que la e/s.
            // Captura de stdout
            StringBuilder salidaProceso = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(exportadorEnEjecucion.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    salidaProceso.append(linea).append("\n");
                }
            }

            // Captura de stderr
            StringBuilder errorProceso = new StringBuilder();
            try (BufferedReader readerErr = new BufferedReader(new InputStreamReader(exportadorEnEjecucion.getErrorStream()))) {
                String linea;
                while ((linea = readerErr.readLine()) != null) {
                    errorProceso.append(linea).append("\n");
                }
            }

            int exitCode = exportadorEnEjecucion.exitValue();
            long duracion = System.currentTimeMillis() - tiempoInicio;

            if (exitCode != 0) {
                LOGGER.severe(String.format(
                        "Fallo en la exportación (Código de salida: %d). Tiempo: %d ms.\nDetalle de salida de LibreOffice:\n%s",
                        exitCode, duracion, salidaProceso.toString().trim()
                ));
                System.err.println("Error: No se pudo exportar el archivo. Revise los logs para más detalle.");
            } else {
                LOGGER.info(String.format(
                        "Exportación completada exitosamente en %d ms. Código de salida: %d.\nSalida de LibreOffice:\n%s",
                        duracion, exitCode, salidaProceso.toString().trim()
                ));
                System.out.println("La conversión fue realizada satisfactoriamente.");
            }

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error de E/S al intentar ejecutar la conversión del archivo: " + archivo, e);
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
                    System.out.println(" 1. XHTML");
                    System.out.println(" 2. PDF");
                    System.out.println(" 3. EPUB");
                    System.out.println(" 4. JPEG");
                    System.out.println(" 5. PNG");
                    System.out.println(" 6. WEBP");
                    System.out.println(" 0. Salir");
                    formato = sc.nextInt();

                    switch (formato) {
                        case 1:
                            exportador(archivo, "html");
                            break;
                        case 2:
                            exportador(archivo, "pdf");
                            break;
                        case 3:
                            exportador(archivo, "epub");
                            break;
                        case 4:
                            exportador(archivo, "jpeg");
                            break;
                        case 5:
                            exportador(archivo, "png");
                            break;
                        case 6:
                            exportador(archivo, "webp");
                            break;
                        default:
                            System.out.println("Cerrando programa.");
                    }
                } while (formato != 0);
            }
        } catch(InputMismatchException ex){
            LOGGER.warning("Entrada de usuario no válida introducida en el menú principal.");
            System.out.println("Debe introducir un tipo de dato válido.");
        }
    }
}
