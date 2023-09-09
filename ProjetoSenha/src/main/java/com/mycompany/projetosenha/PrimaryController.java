package com.mycompany.projetosenha;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;

public class PrimaryController {


    @FXML
    private Label digiteLabel;

    @FXML
    private Button enviarButton;

    @FXML
    private Label especiaisLabel;

    @FXML
    private GridPane gridPane;

    @FXML
    private Label maiusculoLabel;

    @FXML
    private Label minusculoLabel;

    @FXML
    private Label numericosLabel;

    @FXML
    private PasswordField senhaField;

    @FXML
    void enviarButtonClicked(ActionEvent event) {
        String senhaDigitada = senhaField.getText();
        int maiusculos = 0, minusculos = 0,  numericos = 0, especiais = 0;
        
        for(char c : senhaDigitada.toCharArray()){
            if(Character.isUpperCase(c))
                maiusculos++;
            
            if(Character.isLowerCase(c))
                minusculos++;
            
            if(Character.isDigit(c))
                numericos++;
            
            if(!Character.isLetterOrDigit(c))
                especiais++;
            
        }
            System.out.println("Maiúsculos: " + maiusculos + "\nMinúsculos: "+ minusculos + "\nNuméricos: " + numericos + "\nEspeciais: " + especiais);
            
            if(maiusculos > 0 || minusculos > 0 || numericos > 0 || especiais > 0){
                gridPane.setVisible(true);
                maiusculoLabel.setText(Integer.toString(maiusculos));
                minusculoLabel.setText(Integer.toString(minusculos));
                numericosLabel.setText(Integer.toString(numericos));
                especiaisLabel.setText(Integer.toString(especiais));
                
            }
    }

}
