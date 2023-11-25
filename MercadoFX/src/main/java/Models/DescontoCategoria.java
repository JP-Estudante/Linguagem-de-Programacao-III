package Models;

public class DescontoCategoria extends Desconto {
    private String categoria;

    public DescontoCategoria(String categoria, double percentualDesconto){
        super(percentualDesconto);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return this.categoria;
    }

}
