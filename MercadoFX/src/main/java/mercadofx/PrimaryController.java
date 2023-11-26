package mercadofx;

import DAO.ProdutoDAO;
import Models.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.ToggleButton;

public class PrimaryController {

    @FXML
    private TextField codBarrasTextField;

    @FXML
    private TableView<Produto> produtosTableView;;
    ObservableList<Produto> listaDeProdutos = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Produto, Integer> colunaItem;

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
    void actionCodigoDeBarra(KeyEvent event) {
        String codBarras = codBarrasTextField.getText();
        buscarProdutoComCodBarras(codBarras);
    }

    @FXML
    public void initialize() {

        // Adicione um manipulador de eventos ao ToggleButton
        toggleCodRef.setOnAction(event -> {
            if (toggleCodRef.isSelected()) {
                toggleCodRef.setText("Ref.:");
            } else {
                toggleCodRef.setText("Cód.:");
            }
        });
    }

    public void buscarProdutoComCodBarras(String codBarras) {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = produtoDAO.getByCodBarras(codBarras);

        System.out.println(produto);
    }
}