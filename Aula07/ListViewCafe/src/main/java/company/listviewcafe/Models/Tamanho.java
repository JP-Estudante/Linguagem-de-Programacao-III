package company.listviewcafe.Models;

public class Tamanho {
    private String modeloDeTamanhos;
    private double preco;

    public Tamanho(String modeloDeTamanhos, double preco) {
        this.modeloDeTamanhos = modeloDeTamanhos;
        this.preco = preco;
    }

    public String getTamanhos() {
        return modeloDeTamanhos;
    }

    public double getPreco() {
        return preco;
    }

    public String toString() {
        return modeloDeTamanhos;
    }
}

