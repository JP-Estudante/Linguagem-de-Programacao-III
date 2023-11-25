package Models;

public class DescontoProdutos extends Desconto {
    private int idProduto;

    public DescontoProdutos(int idProduto, double percentualDesconto) {
        super(percentualDesconto);
        this.idProduto = idProduto;
    }

    public int getIdProduto() {
        return this.idProduto;
    }

}
