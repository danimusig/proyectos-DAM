package DAO;

import modelo.Libro;

import java.sql.SQLException;
import java.util.List;

public interface LibroDAO {

    boolean insertBook(Libro nuevoLibro) throws SQLException;
    List<Libro> getAllBooks() throws SQLException;
    Libro getBookById(int idLibro) throws SQLException;
    boolean updateCategory(int id, String genero) throws SQLException;
    boolean deleteBook(int idLibro) throws SQLException;

}
