package Controlador;

import Modelo.Alojamiento;
import Utils.Alerta;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class VentanaProcesarAlojamientoController implements Initializable {

    @FXML
    private TextField txfNombreA;
    @FXML
    private TextField txfTarifa;
    @FXML
    private CheckBox cboxDisponibilidad;
    @FXML
    private CheckBox cboxChimenea;
    @FXML
    private CheckBox cboxJacuzzi;
    @FXML
    private Slider sldhVecesAlquilada;
    @FXML
    private Label sldhValue;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnReiniciar;
    @FXML
    private Button btnVolver;
    @FXML
    private TextField txfCapacidad;

    private Alojamiento alojamientoProcesado;

    private ObservableList<Alojamiento> alojamientos;

    private String nombreOriginal;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.sldhValue.textProperty().bind(sldhVecesAlquilada.valueProperty().asString("%.0f"));
    }

    /**
     *
     * @param alojamientos
     */
    public void initAttributes(ObservableList<Alojamiento> alojamientos) {
        this.alojamientos = alojamientos;
    }

    /**
     *
     * @param alojamientos
     * @param a
     */
    public void initAttributes(ObservableList<Alojamiento> alojamientos, Alojamiento a) {
        this.alojamientos = alojamientos;
        this.alojamientoProcesado = a;
        this.nombreOriginal = a.getNombre();

        this.btnReiniciar.setDisable(true);

        this.txfNombreA.setText(this.alojamientoProcesado.getNombre());
        this.txfTarifa.setText(String.valueOf(this.alojamientoProcesado.getTarifa()));
        this.txfCapacidad.setText(String.valueOf(this.alojamientoProcesado.getCapacidad()));
        this.cboxChimenea.setSelected(this.alojamientoProcesado.getTieneChimenea());
        this.cboxJacuzzi.setSelected(this.alojamientoProcesado.getTieneJacuzzi());
        this.cboxDisponibilidad.setSelected(this.alojamientoProcesado.getAlquiladaAhora());
        this.sldhVecesAlquilada.setValue(this.alojamientoProcesado.getNumVecesAlquilado());
    }

    @FXML
    private void guardarAlojamiento(ActionEvent event) {
        // Campos vacíos
        if (txfNombreA.getText().trim().isEmpty()
                || txfCapacidad.getText().trim().isEmpty()
                || txfTarifa.getText().trim().isEmpty()) {
            Alerta.error("Todos los campos deben estar llenos.");
            return;
        }

        String nombre = txfNombreA.getText().trim();
        int capacidad;
        double tarifa;

        // Validar que capacidad sea un número entero positivo
        try {
            capacidad = Integer.parseInt(txfCapacidad.getText().trim());
            if (capacidad <= 0) {
                Alerta.error("La capacidad debe ser un número positivo.");
                return;
            }
        } catch (NumberFormatException e) {
            Alerta.error("La capacidad debe ser un número entero válido.");
            return;
        }

        // Validar tarifa: número decimal positivo
        try {
            tarifa = Double.parseDouble(txfTarifa.getText().trim());
            if (tarifa <= 0) {
                Alerta.error("La tarifa debe ser un número positivo.");
                return;
            }
        } catch (NumberFormatException e) {
            Alerta.error("La tarifa debe ser un número válido.");
            return;
        }

        boolean tieneChimenea = this.cboxChimenea.isSelected();
        boolean tieneJacuzzi = this.cboxJacuzzi.isSelected();
        boolean estaDisponible = this.cboxDisponibilidad.isSelected();
        int numVecesAlquilada = (int) this.sldhVecesAlquilada.getValue();

        // Si se importo un alojamiento desde la otra vista significa que queremos modificar, por eso creamos dos auxiliares de inicio de atributos.
        if (this.alojamientoProcesado != null) {
            // Actualizar el objeto existente (sin cambiar el nombre, que es PK)
            this.alojamientoProcesado.setNombre(nombre);
            this.alojamientoProcesado.setCapacidad(capacidad);
            this.alojamientoProcesado.setTarifa(tarifa);
            this.alojamientoProcesado.setTieneChimenea(tieneChimenea);
            this.alojamientoProcesado.setTieneJacuzzi(tieneJacuzzi);
            this.alojamientoProcesado.setAlquiladaAhora(estaDisponible);
            this.alojamientoProcesado.setNumVecesAlquilado(numVecesAlquilada);

            try {
                if (Alojamiento.modificarAlojamiento(this.alojamientoProcesado, this.nombreOriginal)) {
                    Alerta.info("", "Alojamiento modificado correctamente.");
                } else {
                    Alerta.error("No se pudo modificar el alojamiento.");
                    return;
                }
            } catch (SQLException e) {
                Alerta.error("Error en la base de datos: " + e.getMessage());
                return;
            }
        } // Modo CREACIÓN
        else {
            // Creo el nuevo alojamiento
            Alojamiento nuevoAlojamiento = new Alojamiento(
                    nombre, capacidad, tarifa, tieneChimenea, tieneJacuzzi,
                    estaDisponible, numVecesAlquilada
            );

            // Verifico que no exista ya en la lista
            if (this.alojamientos.contains(nuevoAlojamiento)) {
                Alerta.error("Ya existe un alojamiento con ese nombre.");
                return;
            }

            try {
                // Inserto en base de datos
                if (Alojamiento.insertarAlojamiento(nuevoAlojamiento)) {
                    // Añado a la lista para que aparezca en la tabla
                    this.alojamientos.add(nuevoAlojamiento);
                    Alerta.info("", "Alojamiento añadido correctamente.");
                } else {
                    Alerta.error("No se pudo añadir el alojamiento.");
                    return;
                }
            } catch (SQLException e) {
                Alerta.error("Error en la base de datos: " + e.getMessage());
                return;
            }
        }

        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void reiniciarCampos(ActionEvent event) {
        this.txfNombreA.clear();
        this.txfTarifa.clear();
        this.txfCapacidad.clear();
        this.cboxChimenea.setSelected(false);
        this.cboxJacuzzi.setSelected(false);
        this.cboxDisponibilidad.setSelected(false);
        this.sldhVecesAlquilada.setValue(0);
    }

    @FXML
    private void volver(ActionEvent event) {
        Stage stage = (Stage) this.btnVolver.getScene().getWindow();
        stage.close();
    }

}
