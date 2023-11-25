package company.listviewcafe.Models;

public class Bebida {
    private String nomeBebida;
    private double preco;


    public Bebida(String nomeBebida, double preco) {
        this.nomeBebida = nomeBebida;
        this.preco = preco; 
    }

    public String getNomeBebida(){
        return nomeBebida;
    }

    public double getPreco(){
        return preco;
    }

    public String toString(){
        return nomeBebida;
    }
}
