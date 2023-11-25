package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

public class PrimaryController implements Initializable {

    @FXML
    private TextField field1;

    @FXML
    private TextField field2;

    @FXML
    private StringProperty observada;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        observada = new SimpleStringProperty();

        field1.textProperty().bindBidirectional(observada);
        field2.textProperty().bind(observada);

        TextFormatter<String> textFormatterField1 = createTextFormatter();
        TextFormatter<String> textFormatterField2 = createTextFormatter();

        field1.setTextFormatter(textFormatterField1);
        field2.setTextFormatter(textFormatterField2);

        observada.addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                System.out.println("Valor Antigo " + t);
                System.out.println("Valor Novo " + t1);
            }
        });
    }

    // Método para formatar em uppercase
    private TextFormatter<String> createTextFormatter() {
        return new TextFormatter<>(
                (StringConverter<String>) new StringConverter<String>() {
                    @Override
                    public String toString(String object) {
                        return object;
                    }

                    @Override
                    public String fromString(String string) {
                        return string.toUpperCase();
                    }
                });
    }
}
