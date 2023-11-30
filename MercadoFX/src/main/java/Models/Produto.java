package Models;

public class Produto {

    private Categoria categoria;

    private String id;
    private String nome;
    private double valorProduto;
    private Categoria idCategoria;
    private String codBarras;
    private Integer quantidade;

    public Produto(String id, String nome, double valorProduto, Categoria idCategoria, String codBarras) {
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

    public Categoria getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodBarras() {
        return this.codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nome='" + getNome() + "'" +
                ", valorProduto='" + getValorProduto() + 
                "'" + getIdCategoria() + ", codBarras='" 
                + getCodBarras() + "'" +
                "}";
    }

}
