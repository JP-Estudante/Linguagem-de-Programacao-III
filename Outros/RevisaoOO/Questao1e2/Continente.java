package RevisaoOO.Questao1e2;

import java.util.ArrayList;
import java.util.List;

public class Continente {
    private String nome;
    private List<Pais> paises;

    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList<>();
    }

    // Adicionar país ao continente
    public void adicionarPais(Pais pais) {
        paises.add(pais);
    }

    // Calcular dimensão total do continente
    public double calcularDimensaoTotal() {
        double dimensaoTotal = 0;
        for (Pais pais : paises) {
            dimensaoTotal += pais.getDimensaoKm2();
        }
        return dimensaoTotal;
    }

    // Calcular população total do continente
    public double calcularPopulacaoTotal() {
        double populacaoTotal = 0;
        for (Pais pais : paises) {
            populacaoTotal += pais.getPopulacao();
        }
        return populacaoTotal;
    }

    // Calcular densidade populacional do continente
    public double calcularDensidadePopulacional() {
        return calcularPopulacaoTotal() / calcularDimensaoTotal();
    }

    // Encontrar país com maior população
    public Pais encontrarPaisMaiorPopulacao() {
        Pais maiorPopulacao = null;
        double maxPopulacao = 0;
        for (Pais pais : paises) {
            if (pais.getPopulacao() > maxPopulacao) {
                maxPopulacao = pais.getPopulacao();
                maiorPopulacao = pais;
            }
        }
        return maiorPopulacao;
    }

    // Encontrar país com menor população
    public Pais encontrarPaisMenorPopulacao() {
        Pais menorPopulacao = null;
        double minPopulacao = Double.MAX_VALUE;
        for (Pais pais : paises) {
            if (pais.getPopulacao() < minPopulacao) {
                minPopulacao = pais.getPopulacao();
                menorPopulacao = pais;
            }
        }
        return menorPopulacao;
    }

    // Encontrar país de maior dimensão territorial
    public Pais encontrarPaisMaiorDimensao() {
        Pais maiorDimensao = null;
        double maxDimensao = 0;
        for (Pais pais : paises) {
            if (pais.getDimensaoKm2() > maxDimensao) {
                maxDimensao = pais.getDimensaoKm2();
                maiorDimensao = pais;
            }
        }
        return maiorDimensao;
    }

    // Encontrar país de menor dimensão territorial
    public Pais encontrarPaisMenorDimensao() {
        Pais menorDimensao = null;
        double minDimensao = Double.MAX_VALUE;
        for (Pais pais : paises) {
            if (pais.getDimensaoKm2() < minDimensao) {
                minDimensao = pais.getDimensaoKm2();
                menorDimensao = pais;
            }
        }
        return menorDimensao;
    }

    // Calcular razão territorial do maior e menor país
    public double calcularRazaoTerritorial() {
        Pais maiorDimensao = encontrarPaisMaiorDimensao();
        Pais menorDimensao = encontrarPaisMenorDimensao();
        return maiorDimensao.getDimensaoKm2() / menorDimensao.getDimensaoKm2();
    }
}
