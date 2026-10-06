import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArreglaFicheroTextoSimplificado {



    public static void main(String[] args) {
        static String nombreArchivo = "f_texto.txt";
        public static File archivoOriginal = archivoExistente(nombreArchivo);
        public static File fTemp;
        {
            try {
                fTemp = crearArchivoTemporal(nombreArchivo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (archivoOriginal.exists()) {
            System.out.println("El archivo " + nombreArchivo + " no existe");
        } else {
            try {
            procesarArchivo();
            } catch (IOException e) {

            } catch (Exception e) {

            }

        }
    }

    private static File archivoExistente(String nombreArchivo) {
        File f = new File(nombreArchivo);
        if (f.exists()) {
            return f;
        } else {
            return null;
        }
    }

    private static File crearArchivoTemporal(String nombreArchivo) throws IOException {
        return File.createTempFile(nombreArchivo, "");
    }

    private static void procesarArchivo() throws IOException {
        try (BufferedReader bfr = new BufferedReader(new FileReader(archivoOriginal));
             BufferedWriter bfw = new BufferedWriter(new FileWriter(fTemp))) {

            String linea = bfr.readLine();
            while (linea != null) {
                boolean principioLinea = true;
                boolean espacios = true;
                boolean primerAlfab = true;

                for (int i = 0; i < linea.length(); i++ ) {
                    char c = linea.charAt(i);
                    if (Character.isWhitespace(c)) {
                        if (!espacios && !principioLinea) {
                            bfw.write(c);
                        }
                        espacios = true;
                    } else if (Character.isAlphabetic(c)) {
                        if(!primerAlfab) {
                            primerAlfab = true;
                        } else {
                            bfw.write(c);
                            espacios = false;
                            principioLinea = false;
                        }
                    }
                    bfw.newLine();
                    linea = bfr.readLine();
                }
                fTemp.renameTo(new File(archivoOriginal.getName()));
                archivoOriginal.renameTo(
                        new File(
                                archivoOriginal.getName() + "." + new SimpleDateFormat("yyyyMMddHHmmss")
                                        .format(new Date()) + ".bak"
                        )
                );
            }
        }
    }
}