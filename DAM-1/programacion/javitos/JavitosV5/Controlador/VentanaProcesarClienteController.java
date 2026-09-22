package Controlador;

import Modelo.Cliente;
import Utils.Alerta;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class VentanaProcesarClienteController implements Initializable {

    @FXML
    private TextField txfNombreC;
    @FXML
    private TextField txfDni;
    @FXML
    private TextField txfEmail;
    @FXML
    private Button btnGuardar;
    @FXML
    private ComboBox<String> cmbLugarResidencia;
    @FXML
    private Slider sldhVecesAlojado;
    @FXML
    private Label sldhValue;
    @FXML
    private Button btnReiniciar;
    @FXML
    private Button btnVolver;

    private Cliente clienteProcesado;

    private ObservableList<Cliente> clientes;

    private ObservableList<String> listaLugaresResidencia;

    private String dniOriginal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicio los lugares de residencia directamente ya que son fijos.
        this.cmbLugarResidencia.setItems(FXCollections.observableArrayList(
                "Huelva", "Andalucía", "España", "Europa", "Mundo"));
        // Uso el metodo bind para que se pueda ver el valor del slider ya que no puede por si solo.
        this.sldhValue.textProperty().bind(sldhVecesAlojado.valueProperty().asString("%.0f"));
    }

    public void initAttributes(ObservableList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void initAttributes(ObservableList<Cliente> clientes, Cliente cliente) {
        this.clientes = clientes;
        this.clienteProcesado = cliente;
        this.dniOriginal = cliente.getDNI_CLIENTE();

        this.btnReiniciar.setDisable(true);

        this.txfNombreC.setText(this.clienteProcesado.getNombre());
        this.txfDni.setText(String.valueOf(this.clienteProcesado.getDNI_CLIENTE()));
        this.txfEmail.setText(String.valueOf(this.clienteProcesado.getEmail()));

        this.sldhVecesAlojado.setValue(this.clienteProcesado.getNumVecesAlojado());
    }
 

    @FXML
    private void guardarCliente(ActionEvent event) {

        // Validaciones
    // 1. Campos vacíos
        if (txfNombreC.getText().trim().isEmpty()
                || txfDni.getText().trim().isEmpty()
                || txfEmail.getText().trim().isEmpty()
                || cmbLugarResidencia.getValue() == null) {
            Alerta.error("Todos los campos deben estar llenos.");
            return;
        }

        String nombre = txfNombreC.getText().trim();
        String dni = txfDni.getText().trim();
        String email = txfEmail.getText().trim();
        String lugarResidencia = cmbLugarResidencia.getValue();
        int vecesAlojado = (int) sldhVecesAlojado.getValue();

        // 2. Validar DNI: 8 dígitos + 1 letra mayúscula
        if (!dni.matches("[0-9]{8}[A-Z]")) {
            Alerta.error("El DNI debe tener 8 números seguidos de una letra mayúscula (ej. 12345678A).");
            return;
        }

        // 3. Validar email: formato básico
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            Alerta.error("El email no tiene un formato válido (ej. usuario@dominio.com).");
            return;
        }

        int numVecesAlojado;
        try {
            numVecesAlojado = (int) this.sldhVecesAlojado.getValue();
        } catch (NumberFormatException e) {
            Alerta.error("Numero de veces alojado no válido.");
            return;
        }

        String nuevoDNI_CLIENTE = this.txfDni.getText().trim();
        String nuevoNombre = txfNombreC.getText().trim();
        String nuevoEmail = this.txfEmail.getText().trim();
        String nuevoLugarResidencia = this.cmbLugarResidencia.getSelectionModel().getSelectedItem();
        int nuevoNumVecesAlojado = (int) this.sldhVecesAlojado.getValue();

        // Se se inicio el cliente procesado se empieza en modo modificar.
        if (this.clienteProcesado != null) {

            this.clienteProcesado.setNombre(nuevoNombre);
            this.clienteProcesado.setEmail(nuevoEmail);
            this.clienteProcesado.setLugarResidencia(nuevoLugarResidencia);
            this.clienteProcesado.setNumVecesAlojado(numVecesAlojado);

            try {
                if (Cliente.modificarCliente(this.clienteProcesado, this.dniOriginal)) {
                    Alerta.info("", "Cliente modificado correctamente.");
                } else {
                    Alerta.error("No se pudo modificar el cliente.");
                    return;
                }
            } catch (SQLException e) {
                Alerta.error("Error en la base de datos: " + e.getMessage());
                return;
            }
        } else {
            // Creo el nuevo alojamiento
            Cliente nuevoCliente = new Cliente(
                    nuevoDNI_CLIENTE, nuevoNombre, nuevoEmail, nuevoLugarResidencia, nuevoNumVecesAlojado
            );

            // Verifio que no exista ya en la lista
            if (this.clientes.contains(nuevoCliente)) {
                Alerta.error("Ya existe un cliente con ese DNI.");
                return;
            }

            try {
                // Inserto en base de datos
                if (Cliente.insertarCliente(nuevoCliente)) {
                    // Añado a la lista observable para que aparezca en la tabla
                    this.clientes.add(nuevoCliente);
                    Alerta.info("", "Cliente añadido correctamente.");
                } else {
                    Alerta.error("No se pudo añadir el cliente.");
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
        this.txfNombreC.clear();
        this.txfDni.clear();
        this.txfEmail.clear();
        this.cmbLugarResidencia.getSelectionModel().clearSelection();
        this.sldhVecesAlojado.setValue(0);
    }

    @FXML
    private void volver(ActionEvent event) {
        Stage stage = (Stage) this.btnVolver.getScene().getWindow();
        stage.close();
    }

}
