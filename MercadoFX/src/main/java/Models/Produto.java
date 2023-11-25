package Models;

public class Produto {
    private String item;
    private String descricao;
    private double valorUnitario;

    public Produto(String item, String descricao, int quantidade, double valorUnitario) {
        this.item = item;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
    }

    public String getItem() {
        return item;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

}

