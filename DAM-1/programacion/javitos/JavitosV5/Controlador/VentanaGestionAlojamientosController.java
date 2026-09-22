package Controlador;

import Modelo.Alojamiento;
import Utils.Alerta;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class VentanaGestionAlojamientosController implements Initializable {

    @FXML
    private TableView<Alojamiento> tbAlojamientos;
    @FXML
    private TableColumn<?, ?> tbcNombreA;
    @FXML
    private TableColumn<?, ?> tbcCapacidad;
    @FXML
    private TableColumn<?, ?> tbcTarifa;
    @FXML
    private TableColumn<?, ?> tbcTieneChimenea;
    @FXML
    private TableColumn<?, ?> tbcTieneJacuzzi;
    @FXML
    private TableColumn<?, ?> tbcDisponibilidad;
    @FXML
    private TableColumn<?, ?> tbcVecesAlquilado;
    @FXML
    private Button btnAnyadirAlojamiento;
    @FXML
    private Button btnModificarAlojamiento;
    @FXML
    private Button btnEliminarAlojamiento;
    @FXML
    private Button btnVolverMenuP;
    @FXML
    private ComboBox<String> cmbFiltroAalojamiento;
    @FXML
    private Button btnLimpiarFiltro;

    private ObservableList<Alojamiento> alojamientos;

    private ObservableList<Alojamiento> alojamientosFiltrados;

    ObservableList<String> listaCapacidades;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            this.alojamientos = Alojamiento.getAlojamientos();
        } catch (SQLException e) {
            Alerta.error("Error en la base de datos :\n" + e.getMessage());
        }

        this.cmbFiltroAalojamiento.setItems(
                FXCollections.observableArrayList("2", "3", "4", "5", "6", "7", "8", "9", "10", "+10")
        );

        this.tbcNombreA.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tbcCapacidad.setCellValueFactory(new PropertyValueFactory("capacidad"));
        this.tbcTarifa.setCellValueFactory(new PropertyValueFactory("tarifa"));
        this.tbcTieneChimenea.setCellValueFactory(new PropertyValueFactory("tieneChimenea"));
        this.tbcTieneJacuzzi.setCellValueFactory(new PropertyValueFactory("tieneJacuzzi"));
        this.tbcDisponibilidad.setCellValueFactory(new PropertyValueFactory("alquiladaAhora"));
        this.tbcVecesAlquilado.setCellValueFactory(new PropertyValueFactory("numVecesAlquilado"));

        this.tbAlojamientos.setItems(this.alojamientos);
    }

    @FXML
    private void anyadirAlojamiento(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ventanaProcesarAlojamiento.fxml"));
            Parent root = loader.load();

            VentanaProcesarAlojamientoController controller = loader.getController();
            controller.initAttributes(this.alojamientos);

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("JavitOS - Añadir alojamiento");

            stage.showAndWait();
            this.tbAlojamientos.refresh();
        } catch (IOException e) {
            System.err.println("Error : \n" + e.getMessage());
        }
    }

    @FXML
    private void modificarAlojamiento(ActionEvent event) {
        Alojamiento alojamientoSeleccionado = this.tbAlojamientos.getSelectionModel().getSelectedItem();

        if (alojamientoSeleccionado == null) {
            Alerta.info("", "No ha seleccionado ningún alojamiento.");
            return;
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ventanaProcesarAlojamiento.fxml"));
                Parent root = loader.load();

                VentanaProcesarAlojamientoController controller = loader.getController();
                controller.initAttributes(this.alojamientos, alojamientoSeleccionado);

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setTitle("JavitOS - Modificar alojamiento");

                stage.showAndWait();
                this.tbAlojamientos.refresh();

            } catch (IOException e) {
                System.err.println("Error : \n" + e.getMessage());
            }
        }
    }

    @FXML
    private void eliminarAlojamiento(ActionEvent event) {
        Alojamiento a = this.tbAlojamientos.getSelectionModel().getSelectedItem();
        boolean esBorrado = false;

        if (a == null) {
            Alerta.info("", "No ha seleccionado ningún alojamiento.");
            return;
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null); // Opcional: texto del encabezado
            alert.setContentText("¿Estás seguro de borrar el alojamiento seleccionado?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    esBorrado = Alojamiento.eliminarAlojamiento(a);
                } catch (SQLException e) {
                    Alerta.error("Error en la base de datos : \n" + e.getMessage());
                    return;
                }

                if (esBorrado == true) {
                    this.alojamientos.remove(a);
                    Alerta.info("", "El alojamiento ha sido borrado.");
                } else {
                    Alerta.error("El alojamiento no pudo ser borrado.");
                    return;
                }
            }
        }
    }

    @FXML
    private void filtrarAlojamiento(ActionEvent event) {
        String seleccionado = this.cmbFiltroAalojamiento.getValue();

        // Si no hay nada seleccionado, mostrar todos los alojamientos
        if (seleccionado == null) {
            this.tbAlojamientos.setItems(this.alojamientos);
            return;
        }

        if (seleccionado.equals("+10")) {
            try {
                this.alojamientosFiltrados = Alojamiento.getAlojamientosAltaCapacidad();

            } catch (SQLException e) {
                Alerta.error("Error en la base de datos: \n" + e.getMessage());
                return;
            }
        } else {
            int numSeleccionado = Integer.parseInt(this.cmbFiltroAalojamiento.getValue());
            try {
                this.alojamientosFiltrados = Alojamiento.getAlojamientosFiltrados(numSeleccionado);
            } catch (SQLException e) {
                Alerta.error("Error en la base de datos: \n" + e.getMessage());
                return;
            }
        }

        // Si se encuentra algún match en la base de datos se añade a la lista y se refresca.
        if (!this.alojamientosFiltrados.isEmpty()) {
            this.tbAlojamientos.setItems(this.alojamientosFiltrados);

        } else { // Si no se vuelve a la lista original y se para el metodo.
            this.tbAlojamientos.setItems(this.alojamientos);
            return;
        }
    }

    @FXML
    private void limpiarFiltro(ActionEvent event) {
        this.cmbFiltroAalojamiento.getSelectionModel().clearSelection();
    }

    @FXML
    private void volverMenuP(ActionEvent event) {
        Stage stage = (Stage) this.btnVolverMenuP.getScene().getWindow();
        stage.close();
    }

}
