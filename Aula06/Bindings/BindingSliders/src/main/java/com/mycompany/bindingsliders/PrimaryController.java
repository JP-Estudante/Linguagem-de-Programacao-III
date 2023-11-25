package com.mycompany.bindingsliders;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class PrimaryController implements Initializable{

    @FXML
    private Label label1;

    @FXML
    private Slider slider1;

    @FXML
    private Slider slider2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        slider1.valueProperty().bind(slider2.valueProperty());
        label1.textProperty().bind(
            Bindings.format(
                "%.2f",
                    slider1.valueProperty()
            )
        );
    }
    
}
