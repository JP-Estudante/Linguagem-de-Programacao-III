package mercadofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    private static Stage primaryStage;
    private static Stage secondaryStage;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        scene = new Scene(loadFXML("primary"), 640, 480);
    
    
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    
        openSecondaryWindow();
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

    private void openSecondaryWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("secondary.fxml"));
        Parent root = fxmlLoader.load();
    
        secondaryStage = new Stage();
        secondaryStage.initStyle(StageStyle.UNDECORATED);
        secondaryStage.initModality(Modality.APPLICATION_MODAL);
    
        // Aplicando o estilo com a borda
        root.getStyleClass().add("bordered-window");
        secondaryStage.setScene(new Scene(root));
    
        // Definindo a posição da janela secundária 
        secondaryStage.setX(primaryStage.getX() + (primaryStage.getWidth() - secondaryStage.getWidth()) / 2 + 2000);
        secondaryStage.setY(primaryStage.getY() + (primaryStage.getHeight() - secondaryStage.getHeight()) / 2 + 2000);
    
        secondaryStage.setOnHidden(event -> {
            System.out.println("Janela secundária foi fechada!");
        });
    
        secondaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
