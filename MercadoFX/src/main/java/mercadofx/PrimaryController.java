package mercadofx;

import java.sql.Connection;
import java.sql.SQLException;

import DAO.ProdutoDAO;
import Models.Produto;
import db.ConnectionFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class PrimaryController {

    private ConnectionFactory connectionFactory;
    private ProdutoDAO produtoDAO;

    @FXML
    private TextField codBarrasTextField;

    @FXML
    private TableView<Produto> produtosTableView;
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
    void actionCodigoDeBarra(ActionEvent event) {
        String codBarras = codBarrasTextField.getText();
        System.out.println(codBarras);
        buscarProdutoComCodBarras(codBarras);
    }

    @FXML
    public void initialize() {
        toggleCodRef.setOnAction(event -> {
            if (toggleCodRef.isSelected()) {
                toggleCodRef.setText("Ref.:");
            } else {
                toggleCodRef.setText("Cód.:");
            }
        });

        connectionFactory = new ConnectionFactory();

        try (Connection conexao = connectionFactory.getConnection()) {
            produtoDAO = new ProdutoDAO(connectionFactory);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (SQLException ex) {
            System.err.println("Erro ao estabelecer a conexão com o banco de dados:");
            ex.printStackTrace();
        }
    }

    public void buscarProdutoComCodBarras(String codBarras) {
        try (Connection conexao = connectionFactory.getConnection()) {
            Produto produto = produtoDAO.getByCodBarras(codBarras);

            if (produto != null) {
                System.out.println("Produto encontrado: " + produto);
            } else {
                System.out.println("Produto não encontrado para o código de barras: " + codBarras);
            }

            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar produto por código de barras:");
            ex.printStackTrace();
        }
    }
}
