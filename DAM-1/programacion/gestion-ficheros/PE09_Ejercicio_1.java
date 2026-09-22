package pkg2026.pkg02.pkg28.pe09_ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * En este ejercicio creamos una clase que lee un archivo y lo lee de 24 en 24 lineas presionando ENTER.
 * @author dmunsig
 * @version 1.0
 * @see String
 * @see FileReader
 * @see BufferedReader
 * @throws FileNotFoundException
 * @throws IOException
 */
public class PE09_Ejercicio_1 {

    public static void main(String[] args) {
        
        leer_24_lineas("archivoEjercicio1.txt");
        
    }
    
    public static void leer_24_lineas(String rutaArchivo) {
        try {
            Scanner sc = new Scanner(System.in);
            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);
            
            int numLinea = 0; //Esta variable incrementa cada vez que se lee una linea.
            String linea;
            while ((linea = br.readLine()) != null) { 
                System.out.println(linea);
                numLinea++;
                if (numLinea == 24) {
                    System.out.println("Presione ENTER para continuar leyendo el archivo o para cerrar el programa cuando llegue al final");
                    sc.nextLine();
                    numLinea = 0; //Reinicio contador a 0 si el usuario sigue querer leyendo.
                }
            }
            br.close();
            fr.close();
            
        } catch(FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch(IllegalArgumentException iae) {
            System.out.println(iae.getMessage()); 
        } 
    }
}
