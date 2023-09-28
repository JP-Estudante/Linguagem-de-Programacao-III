package jp.colorpickerproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PrimaryController {

    @FXML
    private CheckBox checkBox1;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Pane painel1;

    @FXML
    private Pane painel2;

    @FXML
    private Rectangle rectangle1;

    @FXML
    private Rectangle rectangle2;

    @FXML // Método chamado quando checkBox1 é acionado
    void checkBox1OnActon(ActionEvent event) {
        atualizarColorPickerStatus(); // Chama a função para atualizar o estado do ColorPicker
    }

    @FXML // Método chamado quando checkBox2 é acionado
    void checkBox2OnActon(ActionEvent event) {
        atualizarColorPickerStatus(); // Chama a função para atualizar o estado do ColorPicker
    }

    @FXML // Método chamado quando o usuário seleciona uma cor no ColorPicker
    void colorPickerOnAction(ActionEvent event) {
        Color corSelecionada = colorPicker.getValue(); // Obtém a cor

        if (checkBox1.isSelected() && checkBox2.isSelected()) { // Define a cor para ambos os retângulos
            rectangle1.setFill(corSelecionada);
            rectangle2.setFill(corSelecionada);

        } else if (checkBox1.isSelected()) { // Define a cor para o retangulo 1
            rectangle1.setFill(corSelecionada);

        } else if (checkBox2.isSelected()) // Define a cor para o retangulo 2
            rectangle2.setFill(corSelecionada);
    }

    // Método que atualiza o estado do ColorPicker com base nos CheckBoxes
    private void atualizarColorPickerStatus() {
        if (checkBox1.isSelected() || checkBox2.isSelected()) // Se um estiver selecionado habilita o ColorPicker
            colorPicker.setDisable(false);

        else // Se nenhum estiver selecionado, desabilita o ColorPicker
            colorPicker.setDisable(true);
    }
}
