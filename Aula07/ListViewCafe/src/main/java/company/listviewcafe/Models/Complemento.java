package company.listviewcafe.Models;

public class Complemento {
    private String tipoComplementos;
    private double preco;

    public Complemento(String tipoComplementos, double preco) {
        this.tipoComplementos = tipoComplementos;
        this.preco = preco;
    }

    public String getNomeComplemento() {
        return tipoComplementos;
    }

    public double getPreco() {
        return preco;
    }

    public String toString() {
        return tipoComplementos;
    }
}

