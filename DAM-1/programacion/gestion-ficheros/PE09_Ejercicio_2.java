package pkg2026.pkg02.pkg28.pe09_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author dmunsig
 * @version 1.0
 * @see String
 * 
 */
public class PE09_Ejercicio_2 {
    
    public static void main(String[] args) {
        
        refactorizadorJava("archivoEjercicio2.java");
        
    }
    
    public static void refactorizadorJava(String rutaArchivo) {
        try {
            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("SinComentariosPrincipal.java");
            BufferedWriter bw = new BufferedWriter(fw);
            
            String linea;
            while((linea = br.readLine()) != null) {
                int indice = linea.indexOf("//"); //Busco la posicion del comienzo del comentario.
                if(indice != -1) {
                   linea = linea.substring(0, indice); //Hago una subcadena que lea desde la posicion 0 hasta la posicion del //.
                }
                bw.write(linea);
                bw.newLine();
            }
            br.close();
            fr.close();
            bw.close();
            fw.close();
            
            System.out.println("Archivo rafactorizado correctamente:\n  Comentarios de linea eliminados.");
        } catch (FileNotFoundException fnfex) {
            System.out.println(fnfex.getMessage());
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }
}
