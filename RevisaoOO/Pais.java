package RevisaoOO;

import java.util.ArrayList;

public class Pais {
    private String codISO;
    private String nome;
    private int populacao;
    private double dimensao;
    private ArrayList<Pais> fronteira = new ArrayList();

    public Pais(String codISO, String nome, double dimensao) {
        this.codISO = codISO;
        this.nome = nome;
        this.dimensao = dimensao;
    }

    public String getCodISO() {
        return this.codISO;
    }

    public void setCodISO(String codISO) {
        this.codISO = codISO;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao() {
        return this.populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return this.dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public boolean iguais(Pais outroPais) {
        if (this.codISO == outroPais.getCodISO())
            return true;
        else
            return false;

    }

    public boolean limitrofe(Pais outroPais) {
        boolean status = false;

        for (Pais paisVizinho : this.fronteira) { // Pega um objeto de this.fronteira e verifica e guarda em paisVizinho
            if (paisVizinho.iguais(outroPais) == true)
                status = true;
        }
        return status;
    }

    public double calcularDensidadePopulacional() {
        if (dimensao == 0) {
            return 0; // Não divide por 0
        }
        return populacao / dimensao;
    }

    public ArrayList<Pais> getVizinhos() {
        return this.fronteira;
    }

    public ArrayList<Pais> vizinhosComuns(Pais outroPais) {
        ArrayList<Pais> vizinhosComuns = new ArrayList<>();
        
        for (Pais umVizinho : this.fronteira) {
            if (outroPais.limitrofe(umVizinho)) {
                vizinhosComuns.add(umVizinho);
            }
        }
        return vizinhosComuns;
    }

    public void addPaisVizinho(Pais vizinho){
        this.fronteira.add(vizinho);
    }

    @Override
    public String toString() {
        return "{" +
                " codISO='" + getCodISO() + "'" +
                ", nome='" + getNome() + "'" +
                ", populacao='" + getPopulacao() + "'" +
                ", dimensao='" + getDimensao() + "'" +
                "}";
    }

}