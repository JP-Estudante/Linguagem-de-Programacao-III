package refrilistview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 350, 250);
        stage.setScene(scene);
        stage.setTitle("ListView Refri");
        stage.show();

        PrimaryController controller = fxmlLoader.getController();
        controller.carregarDados();
    }

    public static void main(String[] args) {
        launch();
    }

}