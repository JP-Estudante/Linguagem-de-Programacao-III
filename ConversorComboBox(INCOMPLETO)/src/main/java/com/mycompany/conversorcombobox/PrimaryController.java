package com.mycompany.conversorcombobox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML
    private Button ButtonConverter;

    @FXML
    private ComboBox<String> ComboBoxDestino;
    //String valorDestino = ComboBoxDestino.getValue();
    
    @FXML
    private ComboBox<String> ComboBoxOrigem;

//    String valorOrigem = ComboBoxOrigem.getValue();
    
    @FXML
    private Label LabelResultado;

    @FXML
    private TextField TextFieldValor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBoxOrigem.getItems().addAll("USD", "EUR");
        ComboBoxOrigem.setValue("USD");
        
        ComboBoxDestino.getItems().addAll("USD", "EUR");
        ComboBoxDestino.setValue("EUR");
    }
    
    @FXML
    void ConverterButtonOnClicked(ActionEvent event) {
        if(ComboBoxOrigem.getValue() == "USD" && ComboBoxDestino.getValue() == "EUR"){
           valor = Double.parseDouble();
           LabelResultado.setText("Texte");
           
           
        }
    }
}
