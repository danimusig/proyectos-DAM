package servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    public static Connection getConection() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/biblioteca";
        String user = "root";
        String password = "Stemdo01?";

        return DriverManager.getConnection(url, user, password);
    }
}
