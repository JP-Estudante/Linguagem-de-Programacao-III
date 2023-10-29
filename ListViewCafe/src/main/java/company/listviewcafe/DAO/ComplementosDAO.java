package company.listviewcafe.DAO;

import java.util.ArrayList;
import java.util.List;

import company.listviewcafe.Models.Complemento;

public class ComplementosDAO {
    
    public List<Complemento> carregarDados() {
        List<Complemento> complementos = new ArrayList<>();
        complementos.add(new Complemento("Chantily", 1.5));
        complementos.add(new Complemento("Açúcar", 0.5));
        complementos.add(new Complemento("Chocolate em Pó", 2.0));
        complementos.add(new Complemento("Canela em Pó", 1.0));
        complementos.add(new Complemento("Marshmallow", 1.5));
        
        
        return complementos;
    }
}
