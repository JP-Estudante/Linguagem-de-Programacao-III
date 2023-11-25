package Models;

public class DescontoQuantidade extends Desconto {
    private int quantidadeMinima;

    public DescontoQuantidade(int quantidadeMinima, double percentualDesconto) {
        super(percentualDesconto);
        this.quantidadeMinima = quantidadeMinima;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }
}
