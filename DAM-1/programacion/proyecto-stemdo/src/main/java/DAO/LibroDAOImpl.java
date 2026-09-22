package DAO;

import modelo.Libro;
import servicio.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {

    @Override
    public boolean insertBook( Libro nuevoLibro) throws SQLException {
        String insertQuery = "INSERT INTO libros(titulo, autor, anio, genero) VALUES (?, ?, ?, ?);";

        try (Connection con = ConexionDB.getConection();
             PreparedStatement ps = con.prepareStatement(insertQuery)) {

            ps.setString(1, nuevoLibro.getTitulo());
            ps.setString(2, nuevoLibro.getAutor());
            ps.setInt(3, nuevoLibro.getAnio());
            ps.setString(4, nuevoLibro.getGenero());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;

        }
    }


    @Override
    public List<Libro> getAllBooks() throws SQLException {
        String selectAllQuery = "SELECT * FROM libros";
        List<Libro> existingBooks = new ArrayList<>();

        try (Connection con = ConexionDB.getConection();
             PreparedStatement ps = con.prepareStatement(selectAllQuery);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Libro bookAux = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("anio"),
                        rs.getString("genero")
                );

                existingBooks.add(bookAux);
            }
            return existingBooks;
        }
    }


    @Override
    public Libro getBookById(int idLibro) throws SQLException {
        String selectByIdQuery = "SELECT * FROM libros WHERE id = ?";

        try(Connection con = ConexionDB.getConection();
            PreparedStatement ps = con.prepareStatement(selectByIdQuery)) {
            ps.setInt(1, idLibro);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return new Libro(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getInt("anio"),
                            rs.getString("genero")
                    );
                }
            }
        }
        return null;
    }


    @Override
    public boolean updateCategory(int id, String nuevoGenero) throws SQLException {
        String updateCategoryQuery = "UPDATE libros SET genero = ? WHERE id = ?";

        try (Connection con = ConexionDB.getConection();
            PreparedStatement ps = con.prepareStatement(updateCategoryQuery)) {

            ps.setString(1, nuevoGenero);
            ps.setInt(2, id);

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }


    @Override
    public boolean deleteBook(int libroABorrar) throws SQLException {
        String deleteQuery = "DELETE FROM libros WHERE id = ?";

        try (Connection con = ConexionDB.getConection();
            PreparedStatement ps = con.prepareStatement(deleteQuery)) {

            ps.setInt(1, libroABorrar);

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }
}
