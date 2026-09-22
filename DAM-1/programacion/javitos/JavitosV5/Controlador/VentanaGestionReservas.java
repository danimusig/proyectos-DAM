package Controlador;

import Modelo.Alojamiento;
import Modelo.Reserva;
import Utils.Alerta;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controlador de la ventana de gestión de reservas.
 *
 * @author Daniel
 */
public class VentanaGestionReservas implements Initializable {

    @FXML
    private TableView<Reserva> tbReservas;
    @FXML
    private TableColumn<Reserva, String> tbcCliente;
    @FXML
    private TableColumn<Reserva, String> tbcAlojamiento;
    @FXML
    private TableColumn<Reserva, LocalDate> tbcFechaEntrada;
    @FXML
    private TableColumn<Reserva, LocalDate> tbcFechaSalida;
    @FXML
    private TableColumn<Reserva, Double> tbcPrecioTotal;
    @FXML
    private Button btnAnyadirReserva;
    @FXML
    private Button btnModificarReserva;
    @FXML
    private Button btnEliminarReserva;
    @FXML
    private Button btnVolverMenuP;
    @FXML
    private ComboBox<String> cmbFiltroAlojamiento;
    @FXML
    private TextField txfDniCliente;

    private ObservableList<Reserva> reservas;
    private ObservableList<Alojamiento> alojamientos;
    private ObservableList<Reserva> reservasFiltradas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Obtengo los datos de la base de datos, si falla inicio las observablelist vacias.
        try {
            reservas = Reserva.getReservas();
            alojamientos = Alojamiento.getAlojamientos();
        } catch (SQLException e) {
            Alerta.error("Error en la base de datos:\n" + e.getMessage());
            reservas = FXCollections.observableArrayList();
            alojamientos = FXCollections.observableArrayList();
        }
        
        // Inicio las combobox 
        ObservableList<String> nombresAlojamientos = FXCollections.observableArrayList();
        nombresAlojamientos.add("Todos");
        for (Alojamiento a : alojamientos) {
            nombresAlojamientos.add(a.getNombre());
        }
        cmbFiltroAlojamiento.setItems(nombresAlojamientos);
        cmbFiltroAlojamiento.setValue("Todos");

        // Configurar columnas
        tbcCliente.setCellValueFactory(new PropertyValueFactory<>("DNI_CLIENTE"));
        tbcAlojamiento.setCellValueFactory(new PropertyValueFactory<>("nombreAlojamiento"));
        tbcFechaEntrada.setCellValueFactory(new PropertyValueFactory<>("fechaEntrada"));
        tbcFechaSalida.setCellValueFactory(new PropertyValueFactory<>("fechaSalida"));
        tbcPrecioTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        // Muestro todas las reservas
        reservasFiltradas = FXCollections.observableArrayList(reservas);
        tbReservas.setItems(reservasFiltradas);


    }

    @FXML
    private void anyadirReserva(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ventanaProcesarReserva.fxml"));
            Parent root = loader.load();
            VentanaProcesarReservaController controller = loader.getController();
            controller.initAttributes(reservas);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.setTitle("JavitOS - Añadir reserva");
            stage.showAndWait();
            tbReservas.refresh();
            // Refrescar la lista filtrada después de un posible añadido
            aplicarFiltros();
        } catch (IOException e) {
            System.err.println("Error al abrir ventana de nueva reserva: " + e.getMessage());
        }
    }

    @FXML
    private void modificarReserva(ActionEvent event) {
        Reserva seleccionada = tbReservas.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            Alerta.info("", "Seleccione una reserva de la tabla.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ventanaProcesarReserva.fxml"));
            Parent root = loader.load();
            VentanaProcesarReservaController controller = loader.getController();
            controller.initAttributes(reservas, seleccionada);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.setTitle("JavitOS - Modificar reserva");
            stage.showAndWait();
            tbReservas.refresh();
            aplicarFiltros();
        } catch (IOException e) {
            System.err.println("Error al abrir ventana de modificar reserva: " + e.getMessage());
        }
    }

    @FXML
    private void eliminarReserva(ActionEvent event) {
        Reserva r = tbReservas.getSelectionModel().getSelectedItem();
        if (r == null) {
            Alerta.info("", "No ha seleccionado ninguna reserva.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText("¿Está seguro de borrar la reserva seleccionada?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                if (Reserva.eliminarReserva(r)) {
                    reservas.remove(r);  // también se quita de la lista maestra
                    aplicarFiltros();    // refrescar la vista
                    Alerta.info("", "Reserva eliminada correctamente.");
                } else {
                    Alerta.error("No se pudo eliminar la reserva.");
                }
            } catch (SQLException e) {
                Alerta.error("Error de base de datos:\n" + e.getMessage());
            }
        }
    }

    @FXML
    private void filtrarAlojamiento(ActionEvent event) {
        aplicarFiltros();
    }

    @FXML
    private void filtrarCliente(KeyEvent event) {
        aplicarFiltros();
    }

    @FXML
    /**
     * Aplica los filtros combinados por alojamiento y DNI de cliente. Se
     * ejecuta cada vez que cambian los criterios de filtro y después de añadir,
     * modificar o eliminar reservas.
     */
    private void aplicarFiltros() {
        String alojamientoSeleccionado = cmbFiltroAlojamiento.getValue();
        String textoDni = txfDniCliente.getText().trim().toUpperCase();

        reservasFiltradas.clear();
        
        // Busco si hay algun elemento con el nombre o el dni de los elementos de los filtros (txfield y cmbbox).
        for (Reserva r : reservas) {
            boolean coincide = true;

            // Filtro por alojamiento
            if (alojamientoSeleccionado != null && !alojamientoSeleccionado.isEmpty() && !alojamientoSeleccionado.equals("Todos")) {
                if (!r.getNombreAlojamiento().equals(alojamientoSeleccionado)) {
                    coincide = false;
                }
            }

            // Filtro por DNI
            if (!textoDni.isEmpty()) {
                if (!r.getDNI_CLIENTE().toUpperCase().contains(textoDni)) {
                    coincide = false;
                }
            }

            if (coincide) {
                reservasFiltradas.add(r);
            }
        }
        
        tbReservas.setItems(reservasFiltradas);
    }

    @FXML
    private void volverMenuP(ActionEvent event) {
        Stage stage = (Stage) btnVolverMenuP.getScene().getWindow();
        stage.close();
    }
}
