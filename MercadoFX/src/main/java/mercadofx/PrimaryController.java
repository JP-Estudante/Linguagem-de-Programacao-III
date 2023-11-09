package mercadofx;

import Models.Produto;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ToggleButton;

public class PrimaryController {

    @FXML
    private TableView<Produto> tabelaProdutos;

    @FXML
    private TableColumn<Produto, String> colunaItem;

    @FXML
    private TableColumn<Produto, String> colunaDescricao;

    @FXML
    private TableColumn<Produto, Integer> colunaQuantidade;

    @FXML
    private TableColumn<Produto, Double> colunaValorUnitario;

    @FXML
    private TableColumn<Produto, Double> colunaValorTotal;

    @FXML
    private ToggleButton toggleCodRef;

    @FXML
    public void initialize() {
        // Configurar as colunas para exibir os valores apropriados
        colunaItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colunaValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        colunaValorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));

        // Adicionar produtos à tabela
        tabelaProdutos.getItems().addAll(
            new Produto("1", "Descrição do Produto 1", 5, 10.0),
            new Produto("2", "Descrição do Produto 2", 3, 15.0),
            new Produto("3", "Descrição do Produto 3", 2, 12.5),
            new Produto("4", "Descrição do Produto 4", 4, 8.0),
            new Produto("5", "Descrição do Produto   5", 6, 9.0),
            new Produto("6", "Descrição do Produto 6", 1, 20.0)
        );

        // Adicione um manipulador de eventos ao ToggleButton
        toggleCodRef.setOnAction(event -> {
            if (toggleCodRef.isSelected()) {
                toggleCodRef.setText("Ref.:");
            } else {
                toggleCodRef.setText("Cód.:");
            }
        });
    }
}
