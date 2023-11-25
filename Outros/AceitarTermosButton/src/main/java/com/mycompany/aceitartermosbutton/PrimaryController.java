package com.mycompany.aceitartermosbutton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class PrimaryController {

    @FXML
    private CheckBox concordoButton;

    @FXML
    private Button copiarButton;

    @FXML
    private Button proximoButton;

    @FXML
    private Button selecionarButton;

    @FXML
    private TextArea termoArea;
    
    @FXML
    void concordoButtonClicked(ActionEvent event) {
        if(concordoButton.isSelected())
            proximoButton.setDisable(false);
        else
            proximoButton.setDisable(true);
    }
    
    @FXML
    void copiarButtonClicked(ActionEvent event) {
        termoArea.copy();
    }

    @FXML
    void proximoButtonClicked(ActionEvent event) {
        System.out.println("Termos Aceitos");
    }

    @FXML
    void selecionarButtonClicked(ActionEvent event) {
        termoArea.selectAll();
    }
    
    
}
