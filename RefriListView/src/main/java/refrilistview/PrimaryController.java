package refrilistview;

import DAO.RefriDAO;
import Model.Refrigerante;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PrimaryController {

    private ObservableList<Refrigerante> observableRefri;

    @FXML
    private ListView<Refrigerante> listViewRefri;

    @FXML
    private Label melhorRefri;

    @FXML
    void RefriSelecionado() {
        Refrigerante refriSelecionado = listViewRefri.getSelectionModel().getSelectedItem();
        melhorRefri.setText(refriSelecionado.getMarcaDoRefri());
    }

    public void carregarDados() {
        RefriDAO refriDAO = new RefriDAO();
        List<Refrigerante> refrigerantes = refriDAO.carregarDados();

        // Converte a lista em um ObservableList
        observableRefri = FXCollections.observableArrayList(refrigerantes);

        // Define o ObservableList como modelo de dados do ListView
        listViewRefri.setItems(observableRefri);
    }

}
