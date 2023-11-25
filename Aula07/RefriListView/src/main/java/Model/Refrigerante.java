package Model;

public class Refrigerante {
    private String marcaDoRefri;

    public Refrigerante(String marcaDoRefri) {
        this.marcaDoRefri = marcaDoRefri;
    }

    public String getMarcaDoRefri() {
        return this.marcaDoRefri;
    }

    @Override
    public String toString() {
        return marcaDoRefri;
    }

}
