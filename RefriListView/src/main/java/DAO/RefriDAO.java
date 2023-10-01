package DAO;

import java.util.ArrayList;
import java.util.List;
import Model.Refrigerante;

public class RefriDAO {
    
    public List<Refrigerante> carregarDados() {
        List<Refrigerante> refrigerantes = new ArrayList<>();
        refrigerantes.add(new Refrigerante("Coca-Cola"));
        refrigerantes.add(new Refrigerante("Guaraná Antarctica"));
        refrigerantes.add(new Refrigerante("Pepsi"));
        refrigerantes.add(new Refrigerante("Dolly"));
        refrigerantes.add(new Refrigerante("Sukita"));
        refrigerantes.add(new Refrigerante("Kuat"));

        return refrigerantes;
    }
}
