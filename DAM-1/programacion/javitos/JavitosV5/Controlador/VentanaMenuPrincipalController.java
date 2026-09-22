package Controlador;

import Modelo.Reserva;
import Utils.Alerta;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controlador de la ventana del menú principal. Muestra listados de reservas
 * activas y futuras.
 *
 * @author Daniel
 */
public class VentanaMenuPrincipalController implements Initializable {

    @FXML
    private Button btnGestorCliente;
    @FXML
    private Button btnGestorAlojamiento;
    @FXML
    private Button btnGestorReservas;
    @FXML
    private Button btnVolverLogin;
    @FXML
    private Label tbReservasFuturas;   // Se usará para mostrar el número de reservas futuras
    @FXML
    private TableView<Reserva> tbReservasActivas;
    @FXML
    private TableColumn<Reserva, String> tbcClienteActivo;
    @FXML
    private TableColumn<Reserva, String> tbcAlojamientoActivo;
    @FXML
    private TableColumn<Reserva, LocalDate> tbcFechaEntradaActiva;
    @FXML
    private TableColumn<Reserva, LocalDate> tbcFechaSalidaActiva;
    @FXML
    private TableColumn<Reserva, Double> tbcPrecioTotalActivo;
    @FXML
    private TableView<Reserva> tbReservas1;
    @FXML
    private TableColumn<Reserva, String> tbcClienteProximo;
    @FXML
    private TableColumn<Reserva, String> tbcAlojamientoProximo;
    @FXML
    private TableColumn<Reserva, LocalDate> tbcFechaEntradaProxima;
    @FXML
    private TableColumn<Reserva, LocalDate> tbcFechaSalidaProxima;
    @FXML
    private TableColumn<Reserva, Double> tbcPrecioTotalProximo;

    private ObservableList<Reserva> reservasActivas;
    private ObservableList<Reserva> reservasProximas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnGestorCliente.setText("👤  Clientes");
        btnGestorAlojamiento.setText("🏠  Alojamientos");
        btnGestorReservas.setText("📜  Reservas");

        // Cargo las reservas activas
        try {
            reservasActivas = Reserva.getReservasActivas();
        } catch (SQLException e) {
            Alerta.error("Error al cargar reservas activas:\n" + e.getMessage());
            reservasActivas = FXCollections.observableArrayList();
        }

        // Cargo las reservas futuras
        try {
            reservasProximas = Reserva.getReservasFuturas();
        } catch (SQLException e) {
            Alerta.error("Error al cargar reservas futuras:\n" + e.getMessage());
            reservasProximas = FXCollections.observableArrayList();
        }

        // Cargo las columnas.
        tbcClienteActivo.setCellValueFactory(new PropertyValueFactory<>("DNI_CLIENTE"));
        tbcAlojamientoActivo.setCellValueFactory(new PropertyValueFactory<>("nombreAlojamiento"));
        tbcFechaEntradaActiva.setCellValueFactory(new PropertyValueFactory<>("fechaEntrada"));
        tbcFechaSalidaActiva.setCellValueFactory(new PropertyValueFactory<>("fechaSalida"));
        tbcPrecioTotalActivo.setCellValueFactory(new PropertyValueFactory<>("total"));

        tbcClienteProximo.setCellValueFactory(new PropertyValueFactory<>("DNI_CLIENTE"));
        tbcAlojamientoProximo.setCellValueFactory(new PropertyValueFactory<>("nombreAlojamiento"));
        tbcFechaEntradaProxima.setCellValueFactory(new PropertyValueFactory<>("fechaEntrada"));
        tbcFechaSalidaProxima.setCellValueFactory(new PropertyValueFactory<>("fechaSalida"));
        tbcPrecioTotalProximo.setCellValueFactory(new PropertyValueFactory<>("total"));

        // Cargo las listas en las tablas.
        tbReservasActivas.setItems(reservasActivas);
        tbReservas1.setItems(reservasProximas);
    }

    @FXML
    private void gestionarCliente(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ventanaCliente.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("JavitOS - Clientes");
            stage.showAndWait();
        } catch (IOException e) {
            System.err.println("Error al abrir ventana de clientes: " + e.getMessage());
        }
    }

    @FXML
    private void gestionarAlojamiento(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ventanaAlojamiento.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("JavitOS - Alojamientos");
            stage.showAndWait();
        } catch (IOException e) {
            System.err.println("Error al abrir ventana de alojamientos: " + e.getMessage());
        }
    }

    @FXML
    private void gestionarReserva(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ventanaReservas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("JavitOS - Reservas");
            stage.showAndWait();
        } catch (IOException e) {
            System.err.println("Error al abrir ventana de reservas: " + e.getMessage());
        }
    }

    @FXML
    private void volverLogin(ActionEvent event) {
        Stage stage = (Stage) this.btnVolverLogin.getScene().getWindow();
        stage.close();
    }
}
