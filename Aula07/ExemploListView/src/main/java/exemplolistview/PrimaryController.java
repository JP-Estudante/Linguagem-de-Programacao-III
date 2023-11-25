package exemplolistview;

import java.util.List;

import DAO.AlunoDAO;
import Model.Aluno;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PrimaryController {
    private ObservableList<Aluno> observableAlunos;

    @FXML
    private ListView<Aluno> listView;

    @FXML
    private Button removerButton;

    @FXML
    private Label selecionadoLabel;

    @FXML
    void selecionarItem() {
        Aluno alunoSelecionado = listView.getSelectionModel().getSelectedItem();
        selecionadoLabel.setText(alunoSelecionado.getNomeCompleto());
    }

    @FXML
    void removerItem() {
        Aluno alunoSelecionado = listView.getSelectionModel().getSelectedItem();
        if (alunoSelecionado != null) {
            observableAlunos.remove(alunoSelecionado);
        }
        selecionadoLabel.setText("");
        imprimirLista();
    }

    void imprimirLista() {
        System.out.println("Lista de Alunos: ");
        for (Aluno aluno : observableAlunos)
            System.out.println(aluno);
    }

    public void carregarDados() { // Carrega os dados dos alunos usando o AlunoDAO
        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> alunos = alunoDAO.carregarDados();

        // Converte a lista em um ObservableList
        observableAlunos = FXCollections.observableArrayList(alunos);

        // Define o ObservableList como modelo de dados do ListView
        listView.setItems(observableAlunos);
    }

}
