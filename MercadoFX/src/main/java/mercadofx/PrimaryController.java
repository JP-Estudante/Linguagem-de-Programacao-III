package mercadofx;

import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import db.ConnectionFactory;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Accordion;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;

import DAO.CategoriaDAO;
import DAO.DescontoDAO;
import DAO.ProdutoDAO;
import Models.Categoria;
import Models.ItemCarrinho;
import Models.Produto;

public class PrimaryController {

    private ConnectionFactory connectionFactory;
    private ProdutoDAO produtoDAO;
    private CategoriaDAO categoriaDAO;
    private DescontoDAO descontoDAO;
    private Connection connection;
    private App app;
    private double valorTotalAcumulado = 0.0;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private Text statusCupom;

    @FXML
    private Text nomeClienteLabel;

    @FXML
    private TextField vlrTotlTextField;

    public String getValorTotal() {
        return vlrTotlTextField.getText();
    }

    @FXML
    private TextField vlrVendTextField;

    @FXML
    private TextField qtdTextField;

    @FXML
    private TextField codBarrasTextField;

    @FXML
    private TableView<ItemCarrinho> tabelaProdutos;
    ObservableList<ItemCarrinho> itensCarrinho = FXCollections.observableArrayList();

    @FXML
    private TableColumn<ItemCarrinho, Integer> colunaItem;

    @FXML
    private TableColumn<ItemCarrinho, String> colunaDescricao;

    @FXML
    private TableColumn<ItemCarrinho, Categoria> colunaCategoria;

    @FXML
    private TableColumn<ItemCarrinho, Double> colunaValorUnitario;

    @FXML
    private TableColumn<ItemCarrinho, Integer> colunaQuantidade;

    @FXML
    private TableColumn<ItemCarrinho, String> colunaDesconto;

    @FXML
    private Accordion finalizarCupomAccordion;

    @FXML
    public void initialize() {
        Platform.runLater(() -> codBarrasTextField.requestFocus());

        connectionFactory = new ConnectionFactory();

        try {
            connection = connectionFactory.getConnection();

            produtoDAO = new ProdutoDAO(connectionFactory);
            categoriaDAO = new CategoriaDAO(connectionFactory);
            descontoDAO = new DescontoDAO(connectionFactory);

            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (SQLException ex) {
            System.err.println("Erro ao estabelecer a conexão com o banco de dados:");
            ex.printStackTrace();
        }

        // Alterando a mensagem quando a tabela está vazia
        tabelaProdutos.setPlaceholder(new Text("Cupom Vazio 💳"));
        tabelaProdutos.getPlaceholder().getStyleClass().add("tabela-vazia-texto");

        // Configurações das colunas do TableView
        colunaDescricao.setCellValueFactory(
                cellData -> new SimpleObjectProperty<>(cellData.getValue().getProduto().getNome()));

        colunaValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorProduto"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        // Configuração da Coluna Item
        colunaItem.setCellFactory(column -> {
            return new TableCell<ItemCarrinho, Integer>() {
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
        colunaValorUnitario.setCellValueFactory(cellData -> {
            Produto produto = cellData.getValue().getProduto();
            double percentualDesconto = descontoDAO.obterPorcentagemDesconto(Integer.parseInt(produto.getId()));
            double valorComDesconto = produto.getValorProduto()
                    - (produto.getValorProduto() * (percentualDesconto / 100.0));
            valorComDesconto = Math.max(valorComDesconto, 0.0);
            return new SimpleObjectProperty<>(valorComDesconto);
        });

        colunaValorUnitario
                .setCellFactory(new Callback<TableColumn<ItemCarrinho, Double>, TableCell<ItemCarrinho, Double>>() {

                    @Override
                    public TableCell<ItemCarrinho, Double> call(TableColumn<ItemCarrinho, Double> param) {
                        return new TableCell<ItemCarrinho, Double>() {
                            @Override
                            protected void updateItem(Double valor, boolean empty) {
                                super.updateItem(valor, empty);

                                if (empty || valor == null) {
                                    setText(null);
                                } else {
                                    setText(NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))
                                            .format(valor));
                                }
                            }
                        };
                    }
                });

        // Configuração da Coluna Categoria
        colunaCategoria.setCellFactory(column -> {
            return new TableCell<ItemCarrinho, Categoria>() {

                @Override
                protected void updateItem(Categoria categoria, boolean empty) {
                    super.updateItem(categoria, empty);

                    if (empty || categoria == null) {
                        setText(null);
                    } else {
                        if (categoriaDAO != null) {
                            // Mensagens de depuração para o valor de categoria
                            System.out.println("Categoria: " + categoria.getNomeCategoria());

                            setText(categoria.getNomeCategoria());
                        } else {
                            setText("categoriaDAO é nulo");
                        }
                    }
                }
            };
        });

        // Configuração da Coluna Desconto
        colunaDesconto.setCellValueFactory(cellData -> {
            ItemCarrinho item = cellData.getValue();
            Produto produto = item.getProduto();
            double percentualDesconto = descontoDAO.obterPorcentagemDesconto(Integer.parseInt(produto.getId()));

            if (percentualDesconto > 0) {
                // Formata a porcentagem para remover o zero após a casa decimal
                DecimalFormat decimalFormat = new DecimalFormat("#.#");
                String percentualFormatado = decimalFormat.format(percentualDesconto);

                return new SimpleStringProperty(percentualFormatado + "%");
            } else {
                return new SimpleStringProperty("Sem desconto");
            }
        });
    }

    private static List<OnChangeScreenListener> listeners = new ArrayList<>();

    public static interface OnChangeScreenListener {
        void onScreenChanged(String newScreen, Object userData);
    }

    public static void addOnChangeScreenListener(OnChangeScreenListener listener) {
        listeners.add(listener);
    }

    public static void changeScreen(String newScreen, Object userData) {
        notifyAllListeners(newScreen, userData);
    }

    public static void notifyAllListeners(String newScreen, Object userData) {
        for (OnChangeScreenListener listener : listeners) {
            listener.onScreenChanged(newScreen, userData);
        }
    }

    @FXML
    void pagarComCartao(ActionEvent event) {
        App appInstance = new App();
        if (appInstance != null) {
            try {
                appInstance.openCartaoWindow(connection);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void pagarEmDinheiro(ActionEvent event) {
        try {
            String valorTotal = vlrTotlTextField.getText();

            notifyAllListeners("DinheiroController", valorTotal);

            App.openDinheiroWindow(connection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cancelarItemOnClicked(ActionEvent event) {
        // Obtém o item selecionado na tabela
        ItemCarrinho itemSelecionado = tabelaProdutos.getSelectionModel().getSelectedItem();

        if (itemSelecionado != null) {
            // Subtrai o valor do produto do total acumulado
            double valorProduto = itemSelecionado.getProduto().getValorProduto();
            double desconto = itemSelecionado.getDesconto();
            valorTotalAcumulado -= (valorProduto - (valorProduto * (desconto / 100.0)))
                    * itemSelecionado.getQuantidade();
            valorTotalAcumulado = Math.max(valorTotalAcumulado, 0.0);

            // Reduz a quantidade do item em 1
            int novaQuantidade = itemSelecionado.getQuantidade() - 1;

            // Se for maior que zero, atualiza a quantidade, caso contrário, remove o item
            if (novaQuantidade > 0) {
                itemSelecionado.setQuantidade(novaQuantidade);
            } else {
                itensCarrinho.remove(itemSelecionado);
            }

            // Recalcula o valor total considerando apenas os itens ainda no carrinho
            valorTotalAcumulado = itensCarrinho.stream()
                    .mapToDouble(item -> {
                        double percentualDesconto = descontoDAO
                                .obterPorcentagemDesconto(Integer.parseInt(item.getProduto().getId()));
                        double valorComDesconto = item.getProduto().getValorProduto()
                                - (item.getProduto().getValorProduto() * (percentualDesconto / 100.0));
                        return Math.max(valorComDesconto, 0.0) * item.getQuantidade();
                    })
                    .sum();

            // Atualiza a exibição do valor total nos TextFields
            vlrTotlTextField.setText(
                    NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(valorTotalAcumulado));

            // Atualiza a TableView
            tabelaProdutos.setItems(itensCarrinho);
            tabelaProdutos.refresh();

            // Atualiza os campos qtdTextField e vlrVendTextField
            atualizarCampos();
        } else {
            System.out.println("Nenhum item selecionado para cancelar.");
        }
    }

    @FXML
    void limparCupomOnClicked(ActionEvent event) {
        App newApp = new App();

        Stage newPrimaryStage = new Stage();

        try {
            newApp.start(newPrimaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Fechando o estágio anterior (o estágio atual)
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

        // Fechando a conexão com o banco de dados
        if (categoriaDAO != null) {
            categoriaDAO.closeConnection();
        }
    }

    @FXML // Evento de leitura do codigo de barras
    void actionCodigoDeBarra(ActionEvent event) {
        String codBarras = codBarrasTextField.getText();
        System.out.println(codBarras);

        buscarProdutoComCodBarras(codBarras);
    }

    @FXML // Evento de seleção de linha
    void linhaSelecionadaMouse(MouseEvent event) {
        if (event.getClickCount() == 1)
            mostrarValoresLinhaSelecionada();
    }

    @FXML
    void linhaSelecionadaTeclado(KeyEvent event) {
        if (event.getCode().isArrowKey())
            mostrarValoresLinhaSelecionada();
    }

    // Método para atualizar os campos qtdTextField e vlrVendTextField
    private void atualizarCampos() {
        // Obtém o item selecionado na tabela
        ItemCarrinho itemSelecionado = tabelaProdutos.getSelectionModel().getSelectedItem();

        if (itemSelecionado != null) {
            // Preenche os TextFields com os valores do item selecionado
            vlrVendTextField.setText(NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))
                    .format(itemSelecionado.getProduto().getValorProduto()));
            qtdTextField.setText(String.valueOf(itemSelecionado.getQuantidade()));
        } else {
            // Se nenhum item estiver selecionado, limpa os TextFields
            vlrVendTextField.clear();
            qtdTextField.clear();
        }
    }

    private void mostrarValoresLinhaSelecionada() {
        // Obtém a linha selecionada
        ItemCarrinho itemSelecionado = tabelaProdutos.getSelectionModel().getSelectedItem();

        if (itemSelecionado != null) {
            // Preenche os TextFields com os valores da linha selecionada
            vlrVendTextField.setText(NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))
                    .format(itemSelecionado.getProduto().getValorProduto()));
            qtdTextField.setText(String.valueOf(itemSelecionado.getQuantidade()));
        }
    }

    public void buscarProdutoComCodBarras(String codBarras) {
        statusCupom.setVisible(false);

        Produto produto = produtoDAO.getByCodBarras(codBarras);

        if (produto != null) {
            finalizarCupomAccordion.setDisable(false);

            // Verifica se o produto já está no carrinho
            Optional<ItemCarrinho> itemExistente = itensCarrinho.stream()
                    .filter(item -> item.getProduto().getId().equals(produto.getId()))
                    .findFirst();

            if (itemExistente.isPresent()) {
                // Aumenta a quantidade do item no carrinho
                ItemCarrinho itemCarrinhoExistente = itemExistente.get();
                itemCarrinhoExistente.setQuantidade(itemCarrinhoExistente.getQuantidade() + 1);

                tabelaProdutos.refresh();

                System.out.println("Produto existente no carrinho. Quantidade atualizada.");
            } else {
                // Se o produto não está no carrinho, adiciona como um novo item
                ItemCarrinho novoItem = new ItemCarrinho(produto, 1);

                // Verifica se o produto possui desconto e exibe a porcentagem
                double percentualDesconto = descontoDAO.obterPorcentagemDesconto(Integer.parseInt(produto.getId()));
                if (percentualDesconto > 0) {
                    DecimalFormat decimalFormat = new DecimalFormat("#.#");
                    String percentualFormatado = decimalFormat.format(percentualDesconto);

                    statusCupom.setVisible(true);
                    statusCupom.setText(percentualFormatado + "% de desconto aplicado!");
                }

                itensCarrinho.add(novoItem);
                System.out.println("Novo produto adicionado ao carrinho.");
            }

            // Atualiza a TableView
            tabelaProdutos.setItems(itensCarrinho);
            tabelaProdutos.refresh();
            atualizarCampos();

            // Recalcula o valor total acumulado considerando todos os itens no carrinho
            valorTotalAcumulado = itensCarrinho.stream()
                    .mapToDouble(item -> {
                        double percentualDesconto = descontoDAO
                                .obterPorcentagemDesconto(Integer.parseInt(item.getProduto().getId()));
                        double valorComDesconto = item.getProduto().getValorProduto()
                                - (item.getProduto().getValorProduto() * (percentualDesconto / 100.0));
                        return Math.max(valorComDesconto, 0.0) * item.getQuantidade();
                    })
                    .sum();

            // Atualiza a exibição do valor total nos TextFields
            vlrTotlTextField.setText(NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))
                    .format(valorTotalAcumulado));
        } else {
            // Produto não encontrado
            statusCupom.setVisible(true);
            statusCupom.setText("Produto não encontrado!");

            System.out.println("Produto não encontrado para o código de barras: " + codBarras);
        }
    }

}
