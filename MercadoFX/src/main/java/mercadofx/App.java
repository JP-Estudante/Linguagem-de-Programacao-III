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

    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        scene = new Scene(loadFXML("primary"), 640, 480);

        // Carregando um arquivo CSS
        scene.getStylesheets().add(getClass().getResource("table-view.css").toExternalForm());

        // Criando um efeito de desfoque
        BoxBlur blur = new BoxBlur(2.6, 2.6, 2);
        scene.getRoot().setEffect(blur);

        // Titulo da janela
        stage.setTitle("Xpress Sistemas");

        // Icone da janel
        stage.getIcons().add(new Image(getClass().getResourceAsStream("Logo-Xpress.png")));

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

        // Definindo a posição da janela secundária
        secondaryStage.centerOnScreen();

        secondaryController.setSecondaryStage(secondaryStage);

        secondaryController.initialize(connection);

        secondaryStage.setOnHidden(event -> {
            // Remove o efeito de desfoque
            scene.getRoot().setEffect(null);
        });

        // Reduz a opacidade da janela principal
        secondaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}