package jp.coressortidas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class App extends Application {
    PainelColor painelC = new PainelColor();
    
    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = loadFXML("BackGroundCollors");
        scene = new Scene(root,640, 405);
        stage.setTitle("Cores Aleatórias");
        stage.setScene(scene);
        stage.show();
      
    // Acesse o botão pelo ID definido no Scene Builder
        Button button = (Button) root.lookup("#sortearButton");
        
        button.setOnAction(event -> {
            //System.out.println("VIVO!?");
            painelC.btnSortearClicked(event);
        });
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void main(String[] args) {
        launch();
    }
}