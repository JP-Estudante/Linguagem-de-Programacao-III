package com.mycompany.coressortidas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.Random;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    private Label corUmLabel;

    @FXML
    private Label corDoisLabel;

    @FXML
    private Label corTresLabel;
    
    @FXML   
    private Pane painelDois;

    @FXML
    private Pane painelTres;

    @FXML
    private Pane painelUm;

    @FXML
    void SortearButtonClicked(ActionEvent event) {
        Color corUm = gerarCorAleatoriamente();
        Color corDois = gerarCorAleatoriamente();
        Color corTres = gerarCorAleatoriamente();

        painelUm.setStyle("-fx-background-color: " + toHexColor(corUm) + ";");
        painelDois.setStyle("-fx-background-color: " + toHexColor(corDois) + ";");
        painelTres.setStyle("-fx-background-color: " + toHexColor(corTres) + ";");
        
        corUmLabel.setText(toHexColor(corUm));
        corDoisLabel.setText(toHexColor(corDois));
        corTresLabel.setText(toHexColor(corTres));
    }

    private Color gerarCorAleatoriamente() {
        Random randColor = new Random();
        int r = randColor.nextInt(256);
        int g = randColor.nextInt(256);
        int b = randColor.nextInt(256);
        return Color.rgb(r, g, b);
    }

    private String toHexColor(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }
}
