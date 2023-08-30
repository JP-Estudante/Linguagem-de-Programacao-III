package RevisaoOO.Questao1e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pais {
    private String codigoISO;
    private String nome;
    private double populacao;
    private double dimensaoKm2;
    private List<Pais> fronteiras;

    public Pais(String codigoISO, String nome, double populacao, double dimensaoKm2) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.populacao = populacao;
        this.dimensaoKm2 = dimensaoKm2;
        this.fronteiras = new ArrayList<>();
    }

    // Getters e Setters
    public String getCodigoISO() {
        return codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(double populacao) {
        this.populacao = populacao;
    }

    public double getDimensaoKm2() {
        return dimensaoKm2;
    }

    public void setDimensaoKm2(double dimensaoKm2) {
        this.dimensaoKm2 = dimensaoKm2;
    }

    // Verificar igualdade por código ISO
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(codigoISO, pais.codigoISO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoISO);
    }

    // Verificar se outro país é limítrofe
    public boolean eLimitrofe(Pais outroPais) {
        return fronteiras.contains(outroPais);
    }

    // Calcular densidade populacional
    public double calcularDensidadePopulacional() {
        return populacao / dimensaoKm2;
    }

    // Vizinhos em comum
    public List<Pais> vizinhosComuns(Pais outroPais) {
        List<Pais> vizinhosComuns = new ArrayList<>();
        for (Pais pais : fronteiras) {
            if (outroPais.eLimitrofe(pais)) {
                vizinhosComuns.add(pais);
            }
        }
        return vizinhosComuns;
    }

    // Adicionar país como fronteira
    public void adicionarFronteira(Pais outroPais) {
        fronteiras.add(outroPais);
        outroPais.fronteiras.add(this);
    }
}
