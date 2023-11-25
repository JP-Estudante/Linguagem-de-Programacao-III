package jp.radiobuttonlistener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;

public class PrimaryController {

    @FXML
    private Label labelPerso;

    @FXML
    private Label labelProp;

    @FXML
    private Label labelSalvar;

    @FXML
    private RadioButton personalizacao;

    @FXML
    private RadioButton propriedades;

    @FXML
    private RadioButton salvar;

    @FXML
    void persoActionClicked(ActionEvent event) {
        if (personalizacao.isSelected()) {
            System.out.println("Personalização está selecionada!");
            labelPerso.setTextFill(Color.GREEN);
            labelPerso.setText("Ligado");
        } else {
            labelPerso.setTextFill(Color.RED);
            labelPerso.setText("Desligado");
        }
    }

    @FXML
    void propActionClicked(ActionEvent event) {
        if (propriedades.isSelected()) {
            System.out.println("Propriedades está selecionada!");
            labelProp.setTextFill(Color.GREEN);
            labelProp.setText("Ligado");
        } else {
            labelProp.setTextFill(Color.RED);
            labelProp.setText("Desligado");
        }
    }

    @FXML
    void salvarActionClicked(ActionEvent event) {
        if (salvar.isSelected()) {
            System.out.println("Salvar está selecionada!");
            labelSalvar.setTextFill(Color.GREEN);
            labelSalvar.setText("Ligado");
        } else {
            labelSalvar.setTextFill(Color.RED);
            labelSalvar.setText("Desligado");
        }
    }

}
