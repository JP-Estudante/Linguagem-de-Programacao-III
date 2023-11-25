package company.listviewcafe.DAO;

import java.util.ArrayList;
import java.util.List;

import company.listviewcafe.Models.Tamanho;

public class TamanhosDAO {

    public List<Tamanho> carregarDados() {
        List<Tamanho> tamanhos = new ArrayList<>();
        tamanhos.add(new Tamanho("Pequeno", 3.0));
        tamanhos.add(new Tamanho("Médio", 4.0));
        tamanhos.add(new Tamanho("Grande", 5.0));
        tamanhos.add(new Tamanho("Extra Grande", 6.0));
        

        return tamanhos;
    }
}
