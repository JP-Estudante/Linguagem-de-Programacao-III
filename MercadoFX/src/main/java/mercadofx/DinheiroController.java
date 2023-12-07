package mercadofx;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import DAO.CategoriaDAO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DinheiroController implements Initializable {

    private Stage dinheiroStage;
    private App app;

    public DinheiroController() {
        
    }

    public DinheiroController(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    public void setDinheiroStage(Stage dinheiroStage) {
        this.dinheiroStage = dinheiroStage;
    }

    public void setApp(App app) {
        this.app = app;
    }

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

    private CategoriaDAO categoriaDAO;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Defina o foco no TextField desejado
        Platform.runLater(() -> valorRecebidoTextField.requestFocus());
    }

    @FXML
    void finalizarCupom(ActionEvent event) {
        // Fecha o aplicativo
        Platform.exit();
    }
    

    public void initialize(Connection connection) {
    }
}
