package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class ConexionDB {
    
    public static Connection establecerConexion()  throws SQLException {
        String url = "jdbc:mysql://localhost:3306/javitos";
        String username = "root";
        String pwd = "admin";
        
        return DriverManager.getConnection(url, username, pwd);
    }
}
