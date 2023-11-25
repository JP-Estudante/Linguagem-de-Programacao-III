package jp.coressortidas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PainelColor {

    @FXML
    private Pane painelDois;

    @FXML
    private Pane painelTres;

    @FXML
    private Pane painelUm;

    @FXML
    private Button sortearButton;

    @FXML
    void btnSortearClicked(ActionEvent event) {
        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTBLUE, null, null);
        Background background = new Background(backgroundFill);
        
        // Definindo o plano de fundo do Pane
        painelUm.setBackground(background);
    }
}
