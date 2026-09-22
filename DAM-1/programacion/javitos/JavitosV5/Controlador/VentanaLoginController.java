package Controlador;

import Utils.Alerta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controlador de la ventana de login.
 *
 * @author Daniel
 */
public class VentanaLoginController implements Initializable {

    @FXML
    private TextField txfNombreUsuario;
    @FXML
    private PasswordField txfContrasenyaUsuario;
    @FXML
    private Button btnIniciarSesion;
    @FXML
    private Button btnRegistrarUsuario;

    private static final String ARCHIVO_USUARIOS = "usuarios.txt";

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Me aseguro de que exista el archivo.
        File file = new File(ARCHIVO_USUARIOS);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Alerta.error("Error al crear el archivo de usuarios:\n" + e.getMessage());
            }
        }
    }

    @FXML
    private void iniciarSesion(ActionEvent event) {
        String usuario = this.txfNombreUsuario.getText().trim();
        String contrasena = this.txfContrasenyaUsuario.getText();

        // Validación de campos vacíos
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            Alerta.error("Debe introducir usuario y contraseña.");
            return;
        }

        // Busco al usuario
        String passwordGuardada = buscarPassword(usuario);
        
        // Si no hay contraseña asociada a ese usuario se avisa.
        if (passwordGuardada == null) {
            Alerta.error("El usuario no está registrado.");
            return;
        }
        
        // Si hay contraseña asociada pero no es la introducida en el campo se avisa.
        if (!passwordGuardada.equals(contrasena)) {
            Alerta.error("Contraseña incorrecta.");
            return;
        }

        // Login exitoso
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ventanaMenuPrincipal.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("JavitOS - Menú Principal");
            stage.showAndWait();
        } catch (IOException e) {
            System.err.println("Error al abrir el menú principal: " + e.getMessage());
            Alerta.error("Error al abrir el menú principal:\n" + e.getMessage());
        }
    }

    @FXML
    private void registrarUsuario(ActionEvent event) {
        String usuario = this.txfNombreUsuario.getText().trim();
        String contrasena = this.txfContrasenyaUsuario.getText();

        // Validacion de datos.
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            Alerta.error("Debe introducir usuario y contraseña.");
            return;
        }
        // Longitud minima de la contraseña.
        if (contrasena.length() < 8) {
            Alerta.error("La contraseña debe tener al menos 8 caracteres.");
            return;
        }

        // Verifico que el usuario no exista utilizando el mismo metodo que con la contraseña.
        String existe = buscarPassword(usuario);
        if (existe != null) {
            Alerta.error("El usuario ya existe.");
            return;
        }

        // Añado el nuevo usuario al archivo
        FileWriter fw = null;
        BufferedWriter writer = null;
        try {
            fw = new FileWriter(ARCHIVO_USUARIOS);
            writer = new BufferedWriter(fw);

            // Si el archivo ya tiene contenido, añadimos un espacio delante
            File file = new File(ARCHIVO_USUARIOS);
            if (file.length() > 0) {
                writer.write(" ");
            }
            writer.write(usuario + ";" + contrasena);

            Alerta.info("", "Usuario registrado correctamente.");
            this.txfNombreUsuario.clear();
            this.txfContrasenyaUsuario.clear();

        } catch (IOException e) {
            Alerta.error("Error al escribir en el archivo de usuarios:\n" + e.getMessage());
        } finally {
            
            try { // Si el reader se ha iniciado (Se ha leido el archivo), se cierran los recursos
                if (writer != null) {
                    writer.close();
                } else if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                // Se ignora pero es encesario para los metodos .close();
            }
        }
    }

    /**
     * Busca la contraseña del usuario introducido en el archivo.
     * @param usuarioBuscado El usuario si se encuentra un match.
     * @return 
     */
    private String buscarPassword(String usuarioBuscado) {
        File file = new File(ARCHIVO_USUARIOS);
        // Si el archivo no existe 
        if (!file.exists() || file.length() == 0) {
            return null;
        }
        
        // Inicio el reader antes para facilitar 
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            // Si el archivo no existe no se saca contraseña y saltara una alerta en el metodo de iniciar sesion.
            if (!file.exists() || file.length() == 0) {
            return null;
            }
        
            fr = new FileReader(file);
            reader = new BufferedReader(fr);

            String linea = reader.readLine();
            if (linea != null) {
                // Creo un array con cada linea que representa el usuario;contraseña.
                String[] tokens = linea.split("\\s+");
                for (String token : tokens) { // Por cada linea 
                    // Cada token tiene formato "usuario;contraseña"
                    if (token.contains(";")) {
                        // Divido en dos partes el usuario si la linea es valida (contiene ;)
                        // La posicion 0 del array guarda el usuario y la 1 la contraseña.
                        String[] partes = token.split(";", 2);
                        // Si el array contiene los dos campos y el usuario esta en el archivo devuelve la contraseña.
                        // Para compararla con la introducida.
                        if (partes.length == 2 && partes[0].equals(usuarioBuscado)) {
                            return partes[1];
                        }
                    }
                }
            }
        } catch (IOException e) { // Capturo el error si no se puede leer el archivo/no se encuentra.
            Alerta.error("Error al leer el archivo de usuarios:\n" + e.getMessage());
        } finally {
            try {
                // Si el reader se ha iniciado (Se ha leido el archivo), se cierran los recursos
                if (reader != null) {
                    reader.close();
                } else if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                 // Se ignora pero es encesario para los metodos .close();
            }
        }
        return null;
    }
}
