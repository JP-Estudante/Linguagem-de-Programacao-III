package Models;

public class Produto {
    private String item;
    private String descricao;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;

    public Produto(String item, String descricao, int quantidade, double valorUnitario) {
        this.item = item;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = quantidade * valorUnitario;
    }

    public String getItem() {
        return item;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}

