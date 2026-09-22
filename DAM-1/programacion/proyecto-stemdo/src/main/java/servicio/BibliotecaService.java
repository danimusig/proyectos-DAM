package servicio;

import modelo.Libro;
import DAO.LibroDAO;
import DAO.LibroDAOImpl;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BibliotecaService {

    Scanner sn = new Scanner(System.in); //Declaro el Scanner aqui para poder usarlo en todos los metodos directamente.


    private final LibroDAO libroDAO;

    public BibliotecaService() {
        this.libroDAO = new LibroDAOImpl();
    }

    public void addToLibrary() {

        try {
            System.out.println("\n/**************** = AÑADIR LIBRO = ****************/");

            System.out.println("- Introduzca el nombre del libro: ");
            String titulo = sn.nextLine().trim();

            System.out.println("- Introduzca el autor del libro: ");
            String autor = sn.nextLine().trim();

            System.out.println("- Introduzca el anio de publicación: ");
            int anioPublicacion = sn.nextInt();
            sn.nextLine();

            System.out.println("- Introduzca el género del libro: ");
            String genero = sn.nextLine().trim();

            if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty()) {
                System.out.println("No se pueden dejar campos vacíos.");
                return;
            }

            Libro libroAux = new Libro(
                    titulo,
                    autor,
                    anioPublicacion,
                    genero
            );

            List<Libro> existingBooks = libroDAO.getAllBooks();

            if (!existingBooks.contains(libroAux)) {
                boolean bookInserted = libroDAO.insertBook(libroAux);

                if (bookInserted) {
                    System.out.println("El libro fué insertado correctamente.");
                } else {
                    System.out.println("ERROR: Error en la inserción del libro.");
                }
            } else {
                System.out.println("ALERTA: El libro ya se encuentra registrado.");
            }
        } catch (InputMismatchException ex) {
            System.out.println("ERROR: Tipo de dato introducido erróneo.");
        } catch (SQLException ex) {
            System.out.println("ERROR: Fallo en la base de datos \n " + ex.getMessage());
        }
    }


    public void displayLibrary() {
        System.out.println("\n/**************** = LISTADO DE LIBROS = ****************/");

        try {
            List<Libro> existingBooks = libroDAO.getAllBooks();

            if (!existingBooks.isEmpty()) {
                for (Libro libroTemp: existingBooks) {
                    System.out.println(libroTemp.toString());
                }
            } else {
                System.out.println("ALERTA: La biblioteca está vacía.");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: Fallo en la base de datos \n " + ex.getMessage());
        }
    }


    public void searchBookById() {
        System.out.println("\n/**************** = BUSCAR UN LIBRO = ****************/");

        try {
            System.out.println("- Introduzca el id del libro deseado: ");
            int idLibro = sn.nextInt();

            Libro obtainedBook  = libroDAO.getBookById(idLibro);

            if (obtainedBook != null) {
                System.out.println("Libro encontrado en el sistema: ");
                System.out.println(obtainedBook);
            } else {
                System.out.println("ALERTA: No hay ningún libro que coincida con esa id");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: Fallo en la base de datos \n " + ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("ERROR: El tipo de dato introducido es erróneo.");
        }
    }


    public void updateCategory()  {
        System.out.println("\n/**************** = MODIFICAR CATEGORIA = ****************/");
        System.out.println("- Introduzca la id del libro que quiere actualizar: ");
        int idLibro = sn.nextInt();
        sn.nextLine();

        try {
            Libro obtainedBook = libroDAO.getBookById(idLibro);

            // Si el libro no existe se avisa y se para la ejecucion del método.
            if (obtainedBook != null) {
                System.out.println("Libro encontrado en el sistema: ");
                System.out.println(obtainedBook);

                System.out.println("- Introduzca el nuevo género: ");
                String newCategory = sn.nextLine().trim();

                // Si la categoría introducida es igual que la que ya tiene el objeto se avisa y se para la ejecución
                if (!newCategory.equals(obtainedBook.getGenero())) {
                    boolean bookIsUpdated = libroDAO.updateCategory(idLibro, newCategory);

                    if (bookIsUpdated) {
                        System.out.println("El género del libro fue actualizado a: " + newCategory);
                    } else {
                        System.out.println("ERROR: Fallo en la base de datos");
                    }
                } else {
                    System.out.println("AVISO: El género introducido es igual al existente.");
                }
            } else {
                System.out.println("AVISO: No hay ningún libro que coincida con esa id");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: Fallo en la base de datos \n " + ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("ERROR: El tipo de dato introducido es erróneo.");
        }
    }


    public void deleteBook() {
        System.out.println("\n/**************** = BORRAR LIBRO = ****************/");

        System.out.println("- Introduzca el id del libro que desea borrar: ");
        int idLibro = sn.nextInt();
        sn.nextLine();

        try {
            Libro obtainedBook = libroDAO.getBookById(idLibro);

            if (obtainedBook != null) {
                System.out.println("¿Seguro que desea borrar el siguiente libro? (si/no)");
                System.out.println(obtainedBook);
                String deleteConfirmation = sn.nextLine().trim().toLowerCase();

                if(deleteConfirmation.equals("si")) {
                    boolean bookIsDeleted = libroDAO.deleteBook(idLibro);

                    if (bookIsDeleted) {
                        System.out.println("El libro fue borrado correctamente.");
                    } else {
                        System.out.println("ERROR: Fallo en la base de datos.");
                    }
                } else {
                    System.out.println("Operación cancelada...");
                }
            } else {
                System.out.println("AVISO: No hay ningún libro que coincida con esa id");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: Fallo en la base de datos \n " + ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("ERROR: El tipo de dato introducido es erróneo.");
        }
    }
}
