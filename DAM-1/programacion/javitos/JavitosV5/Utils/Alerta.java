package Utils;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Daniel
 */
public class Alerta {
    
    public static Alert error(String msgError) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText(null);
        errorAlert.setTitle("Error: ");
        errorAlert.setContentText(msgError);
        errorAlert.showAndWait();
        return errorAlert;
    }
    
    public static Alert info( String tituloInfo, String msgInfo) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText(null);
        infoAlert.setTitle(tituloInfo);
        infoAlert.setContentText(msgInfo);
        infoAlert.showAndWait();
        return infoAlert;
    }
    
}
