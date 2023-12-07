package mercadofx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DinheiroController implements Initializable {

    private Stage dinheiroStage;
    private App app;
    private String valorTotal;

    @FXML
    private TextField cupomTextField;

    @FXML
    private TextField trocoTextField;

    @FXML
    private TextField valorFinalTextField;

    @FXML
    private TextField valorRecebidoTextField;

    @FXML
    private TextField valorTotalTextField;

    public DinheiroController() {
    }

    public void setDinheiroStage(Stage dinheiroStage) {
        this.dinheiroStage = dinheiroStage;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
        valorTotalTextField.setText(valorTotal);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Defina o foco no TextField desejado
        Platform.runLater(() -> valorRecebidoTextField.requestFocus());

        PrimaryController.addOnChangeScreenListener((newScreen, userData) -> {
            // Verifica se a nova tela é o DinheiroController
            if ("DinheiroController".equals(newScreen)) {

                String valorTotal = (String) userData;
                setValorTotal(valorTotal);
            }
        });
    }

    @FXML
    void finalizarCupom() {
        Platform.exit();
    }


}
