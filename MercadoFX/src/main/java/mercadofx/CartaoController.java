package mercadofx;

import java.sql.Connection;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CartaoController {
    private Connection connection;

    @FXML
    private TextField cupomTextField;

    @FXML
    private TextField valorFinalTextField;

    @FXML
    private TextField valorTotalTextField;

    public void initialize(Connection connection) {
        this.connection = connection;

        Platform.runLater(() -> cupomTextField.requestFocus());
    }

    @FXML
    void finalizarCupom(ActionEvent event) {   
        // Fecha o aplicativo
        Platform.exit();
    }

}
