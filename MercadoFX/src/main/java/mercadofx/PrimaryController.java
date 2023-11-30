package mercadofx;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import Models.Categoria;
import Models.Produto;
import db.ConnectionFactory;
import db.SQLiteDBManager;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class PrimaryController {

    private ConnectionFactory connectionFactory;
    private ProdutoDAO produtoDAO;
    private CategoriaDAO categoriaDAO;

    SQLiteDBManager dbManager = new SQLiteDBManager();

    @FXML
    private TextField codBarrasTextField;

    @FXML
    private TableView<Produto> tabelaProdutos;
    ObservableList<Produto> listaDeProdutos = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Produto, Integer> colunaItem;

    @FXML
    private TableColumn<Produto, String> colunaDescricao;

    @FXML
    private TableColumn<Produto, Categoria> colunaCategoria;

    @FXML
    private TableColumn<Produto, Double> colunaValorUnitario;

    @FXML
    private TableColumn<Produto, ?> colunaQuantidade;

    @FXML
    private ToggleButton toggleCodRef;

    @FXML // Evento de leitura do codigo de barras
    void actionCodigoDeBarra(ActionEvent event) {
        String codBarras = codBarrasTextField.getText();
        System.out.println(codBarras);

        buscarProdutoComCodBarras(codBarras);
    }

    @FXML
    public void initialize() {
        // Configurações das colunas do TableView
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorProduto"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        // Configuração da Coluna Item
        colunaItem.setCellFactory(column -> {
            return new TableCell<Produto, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || this.getTableRow() == null) {
                        setText(null);
                    } else {
                        setText(String.valueOf(this.getTableRow().getIndex() + 1));
                    }
                }
            };
        });

        // Configuração da Coluna Valor Unitário
        colunaValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorProduto"));
        colunaValorUnitario.setCellFactory(new Callback<TableColumn<Produto, Double>, TableCell<Produto, Double>>() {
            @Override
            public TableCell<Produto, Double> call(TableColumn<Produto, Double> param) {
                return new TableCell<Produto, Double>() {
                    @Override
                    protected void updateItem(Double valor, boolean empty) {
                        super.updateItem(valor, empty);

                        if (empty || valor == null) {
                            setText(null);
                        } else {
                            setText(NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(valor));
                        }
                    }
                };
            }
        });

        // Configuração da Coluna Categoria
        colunaCategoria.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCategoria()));
        colunaCategoria.setCellFactory(column -> {
            return new TableCell<Produto, Categoria>() {
                @Override
                protected void updateItem(Categoria categoria, boolean empty) {
                    super.updateItem(categoria, empty);

                    if (empty || categoria == null) {
                        setText(null);

                    } else {

                        // Certifique-se de que categoriaDAO não seja nulo
                        if (categoriaDAO != null) {
                            // Adicione mensagens de depuração para verificar o valor de categoria
                            System.out.println("Categoria: " + categoria.getNomeCategoria());

                            setText(categoria.getNomeCategoria());
                        } else {
                            setText("categoriaDAO é nulo");
                        }
                    }
                }
            };
        });

        toggleCodRef.setOnAction(event -> {
            if (toggleCodRef.isSelected()) {
                toggleCodRef.setText("Ref.:");
            } else {
                toggleCodRef.setText("Cód.:");
            }
        });

        connectionFactory = new ConnectionFactory();

        try (Connection connection = dbManager.connect()) {
            produtoDAO = new ProdutoDAO(connectionFactory);
            categoriaDAO = new CategoriaDAO(connectionFactory);

            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (SQLException ex) {
            System.err.println("Erro ao estabelecer a conexão com o banco de dados:");
            ex.printStackTrace();
        }
    }

    public void buscarProdutoComCodBarras(String codBarras) {
        Produto produto = produtoDAO.getByCodBarras(codBarras);

        if (produto != null) {
            // Verificar se o produto já está na lista
            Optional<Produto> produtoExistente = listaDeProdutos.stream()
                    .filter(p -> p.getId().equals(produto.getId()))
                    .findFirst();

            if (produtoExistente.isPresent()) {
                // Aumenta a quantidade do produto na lista
                produtoExistente.get().setQuantidade(produtoExistente.get().getQuantidade() + 1);
                System.out.println("Produto existente na tabela. Quantidade atualizada.");

            } else {
                // Se o produto não existe
                produto.setQuantidade(1);
                listaDeProdutos.add(produto);
                System.out.println("Novo produto adicionado ao cupom.");

            }

            System.out.println("Produto encontrado: " + produto);

            // Atualizar a TableView
            tabelaProdutos.setItems(listaDeProdutos);
            tabelaProdutos.refresh();

        } else {
            System.out.println("Produto não encontrado para o código de barras: " + codBarras);
        }
    }
}
