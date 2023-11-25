package Models;

public class CupomDesconto extends Desconto {
    private String codigoCupom;

    public CupomDesconto(String codigoCupom, double valorFixoDesconto){
        super(valorFixoDesconto);

        this.codigoCupom = codigoCupom;
    }

    public String getCodigoCupom() {
        return this.codigoCupom;
    }

}
