package Models;

public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = quantidade * produto.getValorUnitario();
    }

    public Produto getProduto() {
        return this.produto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }
    
}
