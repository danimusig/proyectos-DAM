import servicio.BibliotecaService;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Scanner sn= new Scanner(System.in);
        boolean exit = false;
        int menuOption;
        BibliotecaService services = new BibliotecaService();

        while(!exit) {
            System.out.println("\n/******************************************************/");
            System.out.println("/**************** = MENÚ BIBLIOTECA = *****************/");
            System.out.println("/******************************************************/");
            System.out.println("/*  1. Registrar un libro.                            */");
            System.out.println("/*  2. Mostrar todos los libros.                      */");
            System.out.println("/*  3. Buscar libro por ID.                           */");
            System.out.println("/*  4. Actualizar género de un libro.                 */");
            System.out.println("/*  5. Eliminar un libro.                             */");
            System.out.println("/*  0. Salir                                          */");
            System.out.println("/******************************************************/");

            try {
                System.out.println("Eliga la acción deseada: ");
                menuOption = sn.nextInt();

                switch (menuOption) {
                    case 1: services.addToLibrary(); break;
                    case 2: services.displayLibrary(); break;
                    case 3: services.searchBookById(); break;
                    case 4: services.updateCategory(); break;
                    case 5: services.deleteBook(); break;
                    case 0: exit = true; break;
                    default: System.out.println("Solo números entre 0 y 5");
                }
            } catch (InputMismatchException ex) {
                System.out.println("ERROR: El carácter introducido no coincide con ninguna de las opciones.");
                sn.next();
            }
        }
    }
}
