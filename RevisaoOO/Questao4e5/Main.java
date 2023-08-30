package RevisaoOO.Questao4e5;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // Configura o scanner para usar o padrão de ponto decimal

        System.out.println("Bem-vindo à aplicação de compra de ingressos de cinema!");
        System.out.print("Informe a data do filme (AAAA-MM-DD): ");
        String dataDoFilmeStr = scanner.nextLine();
        LocalDate dataDoFilme = LocalDate.parse(dataDoFilmeStr);

        System.out.print("Informe o horário do filme (ex: 15.30): ");
        float horario = scanner.nextFloat();

        System.out.print("Informe o número da sala: ");
        int sala = scanner.nextInt();

        System.out.print("Informe o valor do ingresso: ");
        float valor = scanner.nextFloat();

        EntradaDeCinema entrada = new EntradaDeCinema(dataDoFilme, horario, sala, valor);

        System.out.print("Informe a data de nascimento do cliente (AAAA-MM-DD): ");
        String dataNascimentoStr = scanner.next();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);

        entrada.calculaDesconto(dataNascimento);

        System.out.print("O cliente possui carteira de estudante? (1 - Sim / 0 - Não): ");
        int possuiCarteiraEstudante = scanner.nextInt();

        if (possuiCarteiraEstudante == 1) {
            System.out.print("Informe o número da carteira de estudante: ");
            int numeroCarteiraEstudante = scanner.nextInt();
            entrada.calculaDesconto(dataNascimento, numeroCarteiraEstudante);
        }

        entrada.calculaDescontoHorario();

        System.out.println("\nIngresso:");
        System.out.println(entrada.toString());

        scanner.close();
    }
}
