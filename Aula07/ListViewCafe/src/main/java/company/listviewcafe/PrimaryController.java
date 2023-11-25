package company.listviewcafe;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import company.listviewcafe.DAO.BebidasDAO;
import company.listviewcafe.DAO.ComplementosDAO;
import company.listviewcafe.DAO.TamanhosDAO;
import company.listviewcafe.Models.Bebida;
import company.listviewcafe.Models.Complemento;
import company.listviewcafe.Models.Tamanho;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PrimaryController implements Initializable{
    private ObservableList<Bebida> observableBebidas;
    private ObservableList<Complemento> observableComplementos;
    private ObservableList<Tamanho> observableTamanhos;
    
    @FXML
    private Label labelValorTotal;

    @FXML
    private Label labelValorTres;

    @FXML
    private Label labelValorDois;
 
    @FXML
    private Label labelValorUm;
    
    @FXML
    private Button irListaBebidas;

    @FXML
    private Button irListaComplementos;
    
    @FXML
    private Button fazerPedido;

    @FXML
    private ListView<Bebida> listaDeBebidas;
    
    @FXML
    private ListView<Complemento> listaDeComplementos;
    
    @FXML
    private ListView<Tamanho> listaDeTamanhos;
    
    @FXML
    void bebidaSelecionada() {
        Bebida bebidaSelecionada = listaDeBebidas.getSelectionModel().getSelectedItem();
        if (bebidaSelecionada != null) {
            listaDeBebidas.setDisable(true);
            listaDeComplementos.setDisable(false);
            irListaBebidas.setDisable(false);
        }
        System.out.println(bebidaSelecionada);    
    }

    @FXML
    void complementoSelecionado(){
        Complemento complementoSelecionado = listaDeComplementos.getSelectionModel().getSelectedItem();
        if (complementoSelecionado != null) {
            listaDeComplementos.setDisable(true);
            irListaBebidas.setDisable(true);

            listaDeTamanhos.setDisable(false);
            irListaComplementos.setDisable(false);
            fazerPedido.setDisable(false);
        }
        System.out.println(complementoSelecionado);  
    }

    @FXML
    void voltarListaBebidas(){
        listaDeBebidas.setDisable(false);

        listaDeComplementos.setDisable(true);
        irListaBebidas.setDisable(true);
    }

    @FXML
    void voltarListaComplementos(){
        listaDeTamanhos.setDisable(true);
        fazerPedido.setDisable(true);
        irListaComplementos.setDisable(true);

        listaDeComplementos.setDisable(false);
        irListaBebidas.setDisable(false);
    }

    @FXML
    void finalizarPedido(){
        Tamanho tamSelecionado = listaDeTamanhos.getSelectionModel().getSelectedItem();
        System.out.println(tamSelecionado);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Populando lista de Bebidas ☕
        BebidasDAO bebidasDAO = new BebidasDAO();
        List<Bebida> bebidas = bebidasDAO.carregarDados();
        
        observableBebidas = FXCollections.observableArrayList(bebidas);
        
        listaDeBebidas.setItems(observableBebidas);

        // Adicionando valor nos labels 💲
        listaDeBebidas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                labelValorUm.setText("Preço: R$" + newValue.getPreco());
            } else {
                labelValorUm.setText(""); // Limpa o preço se nada estiver selecionado
            }
        });

        // Populando lista de Complementos 🍫
        ComplementosDAO complementosDAO = new ComplementosDAO();
        List<Complemento> complementos = complementosDAO.carregarDados();
        
        observableComplementos = FXCollections.observableArrayList(complementos);
        
        listaDeComplementos.setItems(observableComplementos);
        
        // Adicionando valor nos labels 💲
        listaDeComplementos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                labelValorDois.setText("Preço: R$" + newValue.getPreco());
            } else {
                labelValorDois.setText(""); // Limpa o preço se nada estiver selecionado
            }
        });

        // Populando lista de Tamanhos🥤
        TamanhosDAO tamanhosDAO = new TamanhosDAO();
        List<Tamanho> tamanhos = tamanhosDAO.carregarDados();
        
        observableTamanhos = FXCollections.observableArrayList(tamanhos);
        
        listaDeTamanhos.setItems(observableTamanhos);

        // Adicionando valor nos labels 💲
        listaDeTamanhos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                labelValorTres.setText("Preço: R$" + newValue.getPreco());
            } else {
                labelValorTres.setText(""); // Limpa o preço se nada estiver selecionado
            }
        });

    }   

}
