package Controlador;

import Modelo.Alojamiento;
import Modelo.Cliente;
import Modelo.Reserva;
import Utils.Alerta;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controlador de la ventana para añadir/modificar una reserva.
 *
 * @author Daniel
 */
public class VentanaProcesarReservaController implements Initializable {

    @FXML
    private ComboBox<Cliente> cmbClientesReserva;
    @FXML
    private ComboBox<Alojamiento> cmbAlojamientosReservas;
    @FXML
    private TextField txfNombreCliente;
    @FXML
    private TextField txfDniCliente;
    @FXML
    private TextField txfEmailCliente;
    @FXML
    private TextField txfVecesAlojado;
    @FXML
    private TextField txfNombreAloja;
    @FXML
    private CheckBox chkbChimenea;
    @FXML
    private CheckBox chkbJacuzzi;
    @FXML
    private TextField txfTarifaNoche;
    @FXML
    private TextField txfVecesAlquilada;
    @FXML
    private DatePicker dtpFechaEntrada;
    @FXML
    private DatePicker dtpFechaSalida;
    @FXML
    private TextField txfTotal;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnGuardarReserva;
    @FXML
    private Button btnReiniciar;
    @FXML
    private ComboBox<String> cmbLugarResidencia;
    @FXML
    private ComboBox<String> cmbCapacidad;

    private ObservableList<Cliente> listaClientes;
    private ObservableList<Alojamiento> listaAlojamientos;
    private ObservableList<Reserva> listaReservas;
    private Reserva reservaProcesada;
    private String nombreAlojamientoOriginal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            listaClientes = Cliente.getClientes();
            listaAlojamientos = Alojamiento.getAlojamientos();
        } catch (SQLException e) {
            Alerta.error("Error al cargar datos:\n" + e.getMessage());
            listaClientes = FXCollections.observableArrayList();
            listaAlojamientos = FXCollections.observableArrayList();
        }

        cmbClientesReserva.setItems(listaClientes);
        cmbAlojamientosReservas.setItems(listaAlojamientos);

        cmbLugarResidencia.setItems(FXCollections.observableArrayList(
                "Huelva", "Andalucía", "España", "Europa", "Mundo"));

        cmbCapacidad.setItems(FXCollections.observableArrayList(
                "2", "3", "4", "5", "6", "7", "8", "9", "10", "+10"));
        cmbCapacidad.setDisable(true);
    }

    /**
     * Inicializa el controlador para crear una nueva reserva (todos los campos
     * habilitados).
     */
    public void initAttributes(ObservableList<Reserva> reservasExistentes) {
        this.listaReservas = reservasExistentes;
        this.reservaProcesada = null;
        this.nombreAlojamientoOriginal = null;
        btnReiniciar.setDisable(false);

        habilitarCampos(true);
    }

    /**
     * Inicializa el controlador para modificar una reserva existente. Solo se
     * pueden modificar el alojamiento y las fechas.
     */
    public void initAttributes(ObservableList<Reserva> reservasExistentes, Reserva reservaSeleccionada) {
        this.listaReservas = reservasExistentes;
        this.reservaProcesada = reservaSeleccionada;
        this.btnReiniciar.setDisable(true);

        // Busco los datos de los objetos Cliente y Alojamiento asociados a esa reserva.
        for (Cliente c : listaClientes) {
            if (c.getDNI_CLIENTE().equals(reservaSeleccionada.getDNI_CLIENTE())) {
                cmbClientesReserva.setValue(c);
                break;
            }
        }

        for (Alojamiento a : listaAlojamientos) {
            if (a.getNombre().equals(reservaSeleccionada.getNombreAlojamiento())) {
                cmbAlojamientosReservas.setValue(a);
                break;
            }
        }

        dtpFechaEntrada.setValue(reservaSeleccionada.getFechaEntrada());
        dtpFechaSalida.setValue(reservaSeleccionada.getFechaSalida());
        calcularTotal(null);

        // Deshabilita casi todos los campos menos la seleccion de alojamiento y la fecha de la reserva
        habilitarCampos(false);
    }

    /**
     * Habilita o deshabilita los campos según el modo.
     *
     * @param nuevo true = modo nuevo (todo habilitado), false = modificación
     * (solo alojamiento y fechas).
     */
    private void habilitarCampos(boolean nuevo) {
        // Cliente siempre se deshabilita en modificación
        cmbClientesReserva.setDisable(!nuevo);
        txfNombreCliente.setDisable(!nuevo);
        txfDniCliente.setDisable(!nuevo);
        txfEmailCliente.setDisable(!nuevo);
        txfVecesAlojado.setDisable(!nuevo);
        cmbLugarResidencia.setDisable(!nuevo);

        // Alojamiento: solo el ComboBox se habilita/deshabilita; los detalles siempre bloqueados visualmente
        cmbAlojamientosReservas.setDisable(false);   // siempre se puede cambiar
        txfNombreAloja.setDisable(true);            // siempre solo lectura
        chkbChimenea.setDisable(true);
        chkbJacuzzi.setDisable(true);
        txfTarifaNoche.setDisable(true);
        txfVecesAlquilada.setDisable(true);
        // cmbCapacidad ya está deshabilitado en initialize()

        // Fechas siempre habilitadas
        dtpFechaEntrada.setDisable(false);
        dtpFechaSalida.setDisable(false);
    }

    @FXML
    private void seleccionarCliente(ActionEvent event) {
        Cliente clienteSeleccionado = cmbClientesReserva.getValue();
        if (clienteSeleccionado != null) {
            txfNombreCliente.setText(clienteSeleccionado.getNombre());
            txfDniCliente.setText(clienteSeleccionado.getDNI_CLIENTE());
            txfEmailCliente.setText(clienteSeleccionado.getEmail());
            txfVecesAlojado.setText(String.valueOf(clienteSeleccionado.getNumVecesAlojado()));
            cmbLugarResidencia.setValue(clienteSeleccionado.getLugarResidencia());
        }
    }

    @FXML
    private void seleccionarAlojamiento(ActionEvent event) {
        Alojamiento alojamientoSeleccionado = cmbAlojamientosReservas.getValue();
        if (alojamientoSeleccionado != null) {
            txfNombreAloja.setText(alojamientoSeleccionado.getNombre());
            chkbChimenea.setSelected(alojamientoSeleccionado.getTieneChimenea());
            chkbJacuzzi.setSelected(alojamientoSeleccionado.getTieneJacuzzi());
            txfTarifaNoche.setText(String.valueOf(alojamientoSeleccionado.getTarifa()));
            txfVecesAlquilada.setText(String.valueOf(alojamientoSeleccionado.getNumVecesAlquilado()));
            cmbCapacidad.setValue(String.valueOf(alojamientoSeleccionado.getCapacidad()));
            calcularTotal(null);
        }
    }

    @FXML
    private void calcularTotal(ActionEvent event) {
        LocalDate entrada = dtpFechaEntrada.getValue();
        LocalDate salida = dtpFechaSalida.getValue();
        String tarifaStr = txfTarifaNoche.getText().trim();

        if (entrada != null && salida != null && !tarifaStr.isEmpty() && salida.isAfter(entrada)) {
            try {
                double tarifa = Double.parseDouble(tarifaStr);
                long dias = ChronoUnit.DAYS.between(entrada, salida);
                double total = tarifa * dias;
                txfTotal.setText(String.format("%.2f", total));
            } catch (NumberFormatException e) {
                txfTotal.setText("0.00");
            }
        } else {
            txfTotal.setText("0.00");
        }
    }

    @FXML
    private void guardarReserva(ActionEvent event) {
        // Validar selecciones básicas
        if (cmbClientesReserva.getValue() == null) {
            Alerta.error("Debe seleccionar un cliente.");
            return;
        }
        if (cmbAlojamientosReservas.getValue() == null) {
            Alerta.error("Debe seleccionar un alojamiento.");
            return;
        }
        if (dtpFechaEntrada.getValue() == null || dtpFechaSalida.getValue() == null) {
            Alerta.error("Debe introducir ambas fechas.");
            return;
        }

        LocalDate entrada = dtpFechaEntrada.getValue();
        LocalDate salida = dtpFechaSalida.getValue();

        // Orden de fechas
        if (!salida.isAfter(entrada)) {
            Alerta.error("La fecha de salida debe ser posterior a la de entrada.");
            return;
        }

        // Validar que el total calculado sea un número positivo
        double total;
        try {
            total = Double.parseDouble(txfTotal.getText());
            if (total <= 0) {
                Alerta.error("El total debe ser mayor que cero.");
                return;
            }
        } catch (NumberFormatException e) {
            Alerta.error("El total no es un número válido.");
            return;
        }

        String dni = cmbClientesReserva.getValue().getDNI_CLIENTE();
        String nombreAloja = cmbAlojamientosReservas.getValue().getNombre();
        Reserva nuevaReserva = new Reserva(dni, nombreAloja, entrada, salida, total, true);

        try {
            if (reservaProcesada == null) {  // Inserción
                if (Reserva.insertarReserva(nuevaReserva)) {
                    listaReservas.add(nuevaReserva);

                    // Aumentar contadores de cliente y alojamiento
                    Cliente cliente = cmbClientesReserva.getValue();
                    cliente.alojar();  // +1 veces alojado
                    Cliente.modificarCliente(cliente, cliente.getDNI_CLIENTE()); // Lo modifico indicando el nombre antiguo ya que es la PK

                    Alojamiento alojamiento = cmbAlojamientosReservas.getValue();
                    alojamiento.alquilar();  // +1 veces alquilado y marca como alquilado ahora
                    Alojamiento.modificarAlojamiento(alojamiento, alojamiento.getNombre()); // Lo modifico indicando el nombre antiguo ya que es la PK

                    Alerta.info("", "Reserva añadida correctamente.");
                } else {
                    Alerta.error("No se pudo guardar la reserva.");
                }
            } else {  // Modificación
                if (Reserva.modificarReserva(nuevaReserva, nombreAlojamientoOriginal)) {
                    int idx = listaReservas.indexOf(reservaProcesada);
                    if (idx >= 0) {
                        listaReservas.set(idx, nuevaReserva);
                    }
                    Alerta.info("", "Reserva modificada correctamente.");
                } else {
                    Alerta.error("No se pudo modificar la reserva.");
                }
            }
        } catch (SQLException e) {
            Alerta.error("Error de base de datos:\n" + e.getMessage());
        }

        Stage stage = (Stage) btnGuardarReserva.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void reiniciarCampos(ActionEvent event) {
        cmbClientesReserva.getSelectionModel().clearSelection();
        cmbAlojamientosReservas.getSelectionModel().clearSelection();
        txfNombreCliente.clear();
        txfDniCliente.clear();
        txfEmailCliente.clear();
        txfVecesAlojado.clear();
        txfNombreAloja.clear();
        chkbChimenea.setSelected(false);
        chkbJacuzzi.setSelected(false);
        txfTarifaNoche.clear();
        txfVecesAlquilada.clear();
        dtpFechaEntrada.setValue(null);
        dtpFechaSalida.setValue(null);
        txfTotal.clear();
        cmbLugarResidencia.getSelectionModel().clearSelection();
        cmbCapacidad.setValue(null);
    }

    @FXML
    private void volver(ActionEvent event) {
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        stage.close();
    }
}
