package Models;

public class Produto {
    private String id;
    private String nome;
    private double valorProduto;
    private int idCategoria;
    private String codBarras;


    public Produto(String id, String nome, double valorProduto, int idCategoria, String codBarras) {
        this.id = id;
        this.nome = nome;
        this.valorProduto = valorProduto;
        this.idCategoria = idCategoria;
        this.codBarras = codBarras;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorProduto() {
        return this.valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodBarras() {
        return this.codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }
   

}

