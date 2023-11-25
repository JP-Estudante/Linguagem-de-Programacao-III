package Models;

public abstract class Desconto {
    protected double percentualDesconto;

    public Desconto (double percentualDesconto){
        this.percentualDesconto = percentualDesconto;
    }

    public double calcularDesconto(double valorOriginal) {
        return valorOriginal * (1 - percentualDesconto / 100);
    }

    
}
