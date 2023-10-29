package company.listviewcafe.DAO;

import java.util.ArrayList;
import java.util.List;

import company.listviewcafe.Models.Bebida;

public class BebidasDAO {
    
    public List<Bebida> carregarDados() {
        List<Bebida> bebidas = new ArrayList<>();

        bebidas.add(new Bebida("Café Expresso", 2.5));
        bebidas.add(new Bebida("Café Latte", 3.0));
        bebidas.add(new Bebida("Cappuccino", 3.5));
        bebidas.add(new Bebida("Mocha", 4.0));
        bebidas.add(new Bebida("Chá Verde", 2.0));
        bebidas.add(new Bebida("Chá Preto", 2.0));
        bebidas.add(new Bebida("Chá de Hortelã", 2.0));
        bebidas.add(new Bebida("Chocolate Quente", 3.5));   
        
        return bebidas;
    }
}
