package mercadofx;

import java.io.IOException;

import DAO.CategoriaDAO;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class CupomUtil {
    public static void limparCupomEFecharConexao(ActionEvent event, CategoriaDAO categoriaDAO) {
        App newApp = new App();

        Stage newPrimaryStage = new Stage();

        try {
            newApp.start(newPrimaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Fechando o estágio anterior (o estágio atual)
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

        // Fechando a conexão com o banco de dados
        if (categoriaDAO != null) {
            categoriaDAO.closeConnection();
        }
    }
}
