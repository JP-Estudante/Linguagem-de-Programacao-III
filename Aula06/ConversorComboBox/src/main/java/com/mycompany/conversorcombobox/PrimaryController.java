package com.mycompany.conversorcombobox;

import java.net.URL;
import java.text.DecimalFormat;
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

    @FXML
    private ComboBox<String> ComboBoxOrigem;

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

    String valor;
    double valorConvertido;
    DecimalFormat df = new DecimalFormat("0.00");

    @FXML
    void ConverterButtonOnClicked(ActionEvent event) {
        String origem = ComboBoxOrigem.getValue();
        String destino = ComboBoxDestino.getValue();

        if ("USD".equals(origem) && "EUR".equals(destino)) {
            valor = TextFieldValor.getText();
            for (char c : valor.toCharArray())
                if (!Character.isDigit(c))
                    LabelResultado.setText("Valor inválido");

            valorConvertido = ToDouble(valor);
            valorConvertido = valorConvertido * 0.94;

            LabelResultado.setText(df.format(valorConvertido));
        } else if ("EUR".equals(origem) && "USD".equals(destino)) {
            valor = TextFieldValor.getText();
            for (char c : valor.toCharArray())
                if (!Character.isDigit(c))
                    LabelResultado.setText("Valor inválido");

            valor = TextFieldValor.getText();
            valorConvertido = ToDouble(valor);
            valorConvertido = valorConvertido * 1.07;

            LabelResultado.setText(df.format(valorConvertido));
        } else {
            LabelResultado.setText("Conversão inválida");
        }
    }

    private double ToDouble(String string) {
        String valorString;
        double valorDouble;

        valorString = TextFieldValor.getText();
        valorDouble = Double.parseDouble(valorString);
        return valorDouble;
    }
}
