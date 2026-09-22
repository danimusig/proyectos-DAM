package Controlador;

import Modelo.Cliente;
import Utils.Alerta;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class VentanaGestionClientesController implements Initializable {

    @FXML
    private TableView<Cliente> tbClientes;
    @FXML
    private TableColumn<?, ?> tbcDni;
    @FXML
    private TableColumn<?, ?> tbcNombre;
    @FXML
    private TableColumn<?, ?> tbcEmail;
    @FXML
    private TableColumn<?, ?> tbcLugarResidencia;
    @FXML
    private TableColumn<?, ?> tbcVecesAlojado;
    @FXML
    private Button btnAnyadirCliente;
    @FXML
    private Button btnModificarCliente;
    @FXML
    private Button btnEliminarCliente;
    @FXML
    private Button btnVolverMenuP;
    @FXML
    private TextField txfFiltradoDni;
    @FXML
    private Button btnLimpiarFiltro;

    private ObservableList<Cliente> clientes;

    private ObservableList<Cliente> filtroClientes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.clientes = Cliente.getClientes();
        } catch (SQLException e) {
            Alerta.error("Error en la base de datos \n:" + e.getMessage());
        }
        this.filtroClientes = FXCollections.observableArrayList();

        this.tbcDni.setCellValueFactory(new PropertyValueFactory("DNI_CLIENTE"));
        this.tbcNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tbcEmail.setCellValueFactory(new PropertyValueFactory("email"));
        this.tbcLugarResidencia.setCellValueFactory(new PropertyValueFactory("lugarResidencia"));
        this.tbcVecesAlojado.setCellValueFactory(new PropertyValueFactory("numVecesAlojado"));

        this.tbClientes.setItems(this.clientes);
    }

    @FXML
    private void anyadirCliente(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ventanaProcesarCliente.fxml"));
            Parent root = loader.load();

            VentanaProcesarClienteController controller = loader.getController();
            controller.initAttributes(this.clientes);
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("JavitOS - Añadir clientes");

            stage.showAndWait();
            this.tbClientes.refresh();

        } catch (IOException e) {
            System.err.println("Error : \n" + e.getMessage());
        }
    }

    @FXML
    private void modificarCliente(ActionEvent event) {
        Cliente clienteSeleccionado = this.tbClientes.getSelectionModel().getSelectedItem();

        if (clienteSeleccionado == null) {
            Alerta.info("", "No ha seleccionado ningún cliente.");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ventanaProcesarCliente.fxml"));
                Parent root = loader.load();

                VentanaProcesarClienteController controller = loader.getController();
                controller.initAttributes(this.clientes, clienteSeleccionado);

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setTitle("JavitOS - Modificar clientes");

                stage.showAndWait();
                this.tbClientes.refresh();

            } catch (IOException e) {
                System.err.println("Error : \n" + e.getMessage());
            }
        }

    }

    @FXML
    private void eliminarCliente(ActionEvent event) {
        Cliente c = this.tbClientes.getSelectionModel().getSelectedItem();

        if (c == null) {
            Alerta.info("", "No ha seleccionado ningún cliente.");
            return;
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null); // Opcional: texto del encabezado
            alert.setContentText("¿Estás seguro de borrar el cliente seleccionado?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    boolean esBorrado = Cliente.eliminarCliente(c);

                    if (esBorrado == true) {
                        this.clientes.remove(c);
                        this.tbClientes.refresh();
                        Alerta.info("", "Cliente eliminado correctamente.");
                    } else {
                        Alerta.error("No se pudo eliminar el cliente.");
                    }
                } catch (SQLException e) {
                    Alerta.error("Error en la base de datos \n:" + e.getMessage());
                    return;
                }
            }
        }
    }

    @FXML
    private void filtrarClientes(KeyEvent event) {
        String textoFiltro = this.txfFiltradoDni.getText().trim();

        // Si el campo está vacío, mostrar todos los clientes
        if (textoFiltro.isEmpty()) {
            this.tbClientes.setItems(this.clientes);
            return;
        }

        // Si hay texto, filtrar por DNI (contiene)
        this.filtroClientes.clear();
        for (Cliente c : this.clientes) {
            if (c.getDNI_CLIENTE().toLowerCase().contains(textoFiltro.toLowerCase())) {
                this.filtroClientes.add(c);
            }
        }
        this.tbClientes.setItems(this.filtroClientes);
    }

    @FXML
    private void limpiarFiltro(ActionEvent event) {
        this.txfFiltradoDni.clear();
        this.tbClientes.setItems(this.clientes);
    }

    @FXML
    private void volverMenuP(ActionEvent event) {
        Stage stage = (Stage) this.btnVolverMenuP.getScene().getWindow();
        stage.close();
    }
}
