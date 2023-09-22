package com.mycompany.bidingexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable{

    @FXML
    private Label Label;

    @FXML
    private TextField TextField;

    @FXML
    private StringProperty variavelObservada;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        variavelObservada = new SimpleStringProperty();
        
        TextField.textProperty().bindBidirectional(variavelObservada);
        Label.textProperty().bind(variavelObservada);
        
        variavelObservada.addListener(new ChangeListener(){
        
        @Override
        public void changed(ObservableValue ov, Object t, Object t1){
            System.out.println("VariavelObservada -> Valor Antigo" + t);
            System.out.println("VariavelObservada -> Valor Novo" + t1);
            }
        });
    }
    
    
}
