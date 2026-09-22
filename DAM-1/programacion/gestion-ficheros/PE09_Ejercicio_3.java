package pkg2026.pkg02.pkg28.pe09_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dmunsig
 */
public class PE09_Ejercicio_3 {
    
    public static void main(String[] args) {  
        String rutaArchivo = "mymoviedb.tsv";
        List<Pelicula> listaPeliculas = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            while((linea = br.readLine()) != null) {
                String[] datos = linea.split("\t");
                
                LocalDate fechaPeli = LocalDate.parse(datos[0], formato);
                double popularidad = Double.parseDouble(datos[3]);
                int votos = Integer.parseInt(datos[4]);                
                double puntuacionMedia = Double.parseDouble(datos[5]);
                List<String> generos = Arrays.asList(datos[7].split(",\\s*"));
                
                Pelicula peliculaTemp = new Pelicula(fechaPeli,datos[1],datos[2], popularidad, votos, puntuacionMedia, datos[6], generos, datos[8]);
                listaPeliculas.add(peliculaTemp);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException fnfex) {
            System.out.println(fnfex.getMessage());
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        
        generarPeliculaBin(listaPeliculas);
        generarPeliculaPorAnyoBin(listaPeliculas);
        generarPelisPorGeneroTXT(listaPeliculas);
    }
    
    public static void generarPeliculaBin(List<Pelicula> listaPeliculas) {
        try {
            FileOutputStream fos = new FileOutputStream("mymoviedb.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Pelicula p : listaPeliculas) {
                oos.writeObject(p);
            }
            oos.close();
            fos.close();
            System.out.println("Se ha generado el archivo binario correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }    
    }
    
    public static void generarPeliculaPorAnyoBin(List<Pelicula> listaPeliculas) {
        Scanner sc = new Scanner(System.in);
        int anyo;
        try { 
            System.out.println("Introduzca el anyo para generar una lista de peliculas de ese anyo: ");
            anyo = sc.nextInt();
            if (anyo < 1900 || anyo > LocalDate.now().getYear() + 5) {
                System.out.println("Año no válido. Operación cancelada.");
                return;
            }
            
            FileOutputStream fos = new FileOutputStream("mymoviedb_" + anyo + ".bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Pelicula p : listaPeliculas) {
                if(p.getFechaLanzamiento().getYear() == anyo) {
                    oos.writeObject(p);
                }
            }
            oos.close();
            fos.close();
            System.out.println("Se ha generado el archivo binario de peliculas del " + anyo + " correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }    
    }
    
    public static void generarPelisPorGeneroTXT(List<Pelicula> listaPeliculas) {
        Scanner sc = new Scanner(System.in);
        
        try {
            FileWriter fw = new FileWriter("pelisPorGenero.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            List<String> generoUsuario = new ArrayList<>();
            String inputUsuario = " ";
            
            while (!inputUsuario.equals("Salir")) {
                System.out.println("Introduzca un genero o Salir para terminar de añadir generos:");
                inputUsuario = sc.nextLine();
                generoUsuario.add(inputUsuario);
            }
            generoUsuario.removeLast(); //Borro "Salir" de la lista.
            
            for(int i = 0; i < listaPeliculas.size(); i++) {
                if (generoUsuario.containsAll(listaPeliculas)) {
                    bw.write(listaPeliculas.get(i).toString());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void mostrarPelisPuntuacionAlta(List<Pelicula> listaPeliculas) {
        Scanner sc = new Scanner(System.in);
        List<Pelicula> copiaListaPeliculas = new ArrayList<>(listaPeliculas);
        
        System.out.println("Introduzca el numero de peliculas que desea ver: ");
        int cantPelicula = sc.nextInt();
        
        Collections.sort(copiaListaPeliculas);
        
        for(int i = 0; i < cantPelicula; i++) {
            System.out.println(copiaListaPeliculas.get(i).toString());
        }
    }
}


