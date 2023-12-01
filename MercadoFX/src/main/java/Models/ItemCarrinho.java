package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ItemCarrinho {
    private Produto produto;
    private final IntegerProperty quantidade = new SimpleIntegerProperty();

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade.set(quantidade);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade.get();
    }

    public void setQuantidade(int quantidade) {
        this.quantidade.set(quantidade);
    }

    public IntegerProperty quantidadeProperty() {
        return quantidade;
    }
}
