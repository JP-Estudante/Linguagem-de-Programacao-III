package mercadofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import db.ConnectionFactory;

public class App extends Application {

    @SuppressWarnings("unused")
    private static Stage primaryStage;
    private static Stage secondaryStage;
    private static Scene scene;
    private static DinheiroController dinheiroController;

    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        scene = new Scene(loadFXML("primary"), 1920, 1080);

        // Carregando um arquivo CSS
        scene.getStylesheets().add(getClass().getResource("table-view.css").toExternalForm());

        // Titulo da janela
        stage.setTitle("Xpress Sistemas");

        // Icone da janela
        stage.getIcons().add(new Image(getClass().getResourceAsStream("Logo-Xpress.png")));

        stage.setResizable(false);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

        // Obtendo a conexão com o banco de dados
        Connection connection = null;
        try {
            connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            System.err.println("Erro ao obter a conexão com o banco de dados: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        openSecondaryWindow(connection);

        // Configurando a referência de App no DinheiroController
        FXMLLoader dinheiroLoader = new FXMLLoader(getClass().getResource("dinheiro.fxml"));
        Parent dinheiroRoot = dinheiroLoader.load();
        dinheiroController = dinheiroLoader.getController();
        dinheiroController.setApp(this);
    }

    static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void openCartaoWindow(Connection connection) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("cartao.fxml"));
        Parent root = fxmlLoader.load();

        CartaoController cartaoController = fxmlLoader.getController();
        cartaoController.initialize(connection);

        Stage cartaoStage = new Stage();
        cartaoStage.initStyle(StageStyle.UNDECORATED);
        cartaoStage.initModality(Modality.APPLICATION_MODAL);
        cartaoStage.initOwner(primaryStage);
        cartaoStage.setScene(new Scene(root));

        // Adiciona um listener para detectar quando a janela Cartao está fechada
        cartaoStage.setOnHidden(event -> {
            // Remove o efeito de desfoque quando a janela Cartao é fechada
            scene.getRoot().setEffect(null);
        });

        // Adiciona um listener para detectar quando a janela Cartao está sendo
        // exibida
        cartaoStage.setOnShowing(event -> {
            // Adiciona o efeito de desfoque quando a janela Cartao está sendo exibida
            BoxBlur blur = new BoxBlur(2.6, 2.6, 2);
            scene.getRoot().setEffect(blur);
        });

        cartaoStage.show();
    }

    public static void openDinheiroWindow(Connection connection) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("dinheiro.fxml"));
        Parent root = fxmlLoader.load();

        dinheiroController.initialize(connection);

        Stage dinheiroStage = new Stage();
        dinheiroStage.initStyle(StageStyle.UNDECORATED);
        dinheiroStage.initModality(Modality.APPLICATION_MODAL);
        dinheiroStage.initOwner(primaryStage);
        dinheiroStage.setScene(new Scene(root));

        // Adiciona um listener para detectar quando a janela Dinheiro está fechada
        dinheiroStage.setOnHidden(event -> {
            // Remove o efeito de desfoque quando a janela Dinheiro é fechada
            scene.getRoot().setEffect(null);
        });

        // Adiciona um listener para detectar quando a janela Dinheiro está sendo
        // exibida
        dinheiroStage.setOnShowing(event -> {
            // Adiciona o efeito de desfoque quando a janela Dinheiro está sendo exibida
            BoxBlur blur = new BoxBlur(2.6, 2.6, 2);
            scene.getRoot().setEffect(blur);
        });

        dinheiroStage.show();
    }

    private void openSecondaryWindow(Connection connection) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("secondary.fxml"));
        Parent root = fxmlLoader.load();

        // Referência ao controlador
        SecondaryController secondaryController = fxmlLoader.getController();

        secondaryStage = new Stage();
        secondaryStage.initStyle(StageStyle.UNDECORATED);
        secondaryStage.initModality(Modality.APPLICATION_MODAL);

        // Definindo o PrimaryStage como proprietária da SecondaryStage
        secondaryStage.initOwner(primaryStage);

        secondaryStage.setScene(new Scene(root));

        // Adiciona um listener para detectar quando a janela Secondary está sendo
        // exibida
        secondaryStage.setOnShowing(event -> {
            // Adiciona o efeito de desfoque quando a janela Secondary está sendo exibida
            BoxBlur blur = new BoxBlur(2.6, 2.6, 2);
            scene.getRoot().setEffect(blur);
        });

        // Adiciona um listener para detectar quando a janela Secondary está sendo
        // fechada
        secondaryStage.setOnHidden(event -> {
            // Remove o efeito de desfoque quando a janela Secondary é fechada
            scene.getRoot().setEffect(null);
        });

        // Definindo a posição da janela secundária
        secondaryStage.centerOnScreen();

        secondaryController.setSecondaryStage(secondaryStage);
        secondaryController.initialize(connection);

        // Reduz a opacidade da janela principal
        secondaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}