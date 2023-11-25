package RevisaoOO.Questao4e5;

import java.time.LocalDate;

public class EntradaDeCinema {
    private LocalDate dataDoFilme;
    private float horario;
    private int sala;
    private float valor;

    public EntradaDeCinema(LocalDate dataDoFilme, float horario, int sala, float valor) {
        this.dataDoFilme = dataDoFilme;
        this.horario = horario;
        this.sala = sala;
        this.valor = valor;
    }

    public void calculaDesconto(LocalDate dataNascimento) {
        int idade = calcularIdade(dataNascimento);
        if (idade < 12) {
            valor *= 0.5; // 50% de desconto
        } else if (idade >= 12 && idade <= 15) {
            valor *= 0.6; // 40% de desconto
        } else if (idade >= 16 && idade <= 20) {
            valor *= 0.7; // 30% de desconto
        } else if (idade > 20) {
            valor *= 0.8; // 20% de desconto
        }
    }

    public void calculaDesconto(LocalDate dataNascimento, int numeroCarteiraEstudante) {
        calculaDesconto(dataNascimento);

        int idade = calcularIdade(dataNascimento);
        if (idade >= 12 && idade <= 15) {
            if (numeroCarteiraEstudante != 0) {
                valor *= 0.9; // 10% de desconto adicional
            }
        }
    }

    public void calculaDescontoHorario() {
        if (horario < 16.0) {
            valor *= 0.9; // 10% de desconto no horário
        }
    }

    public String toString() {
        return "Data do Filme: " + dataDoFilme +
                "\nHorário: " + horario +
                "\nSala: " + sala +
                "\nValor: " + valor;
    }

    private int calcularIdade(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        return hoje.getYear() - dataNascimento.getYear();
    }
}
