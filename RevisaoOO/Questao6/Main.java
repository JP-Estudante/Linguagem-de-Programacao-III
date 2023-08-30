package RevisaoOO.Questao6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Curso[] cursos = new Curso[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Informe o código do curso " + (i + 1) + ": ");
            int codigo = scanner.nextInt();

            System.out.println("Informe o valor da mensalidade do curso " + (i + 1) + ": ");
            double valorMensalidade = scanner.nextDouble();

            cursos[i] = new Curso(codigo, valorMensalidade);

            for (int j = 0; j < 5; j++) {
                double nota;
                do {
                    System.out.println("Informe a nota do aluno " + (j + 1) + " do curso " + (i + 1) + ": ");
                    nota = scanner.nextDouble();
                    if (nota < 0 || nota > 10) {
                        System.out.println("Nota inválida. Digite uma nota entre 0 e 10.");
                    }
                } while (nota < 0 || nota > 10);

                cursos[i].matricularAluno();
                cursos[i].registrarNota(nota);
            }
        }

        int totalAprovados = 0;
        int totalReprovados = 0;
        int codigoMaiorReceita = -1;
        double maiorReceita = 0;

        for (int i = 0; i < 3; i++) {
            totalAprovados += cursos[i].getAlunosAprovados();
            totalReprovados += cursos[i].getQuantidadeAlunosMatriculados() - cursos[i].getAlunosAprovados();

            double receitaCurso = cursos[i].calcularReceita();
            if (receitaCurso > maiorReceita) {
                maiorReceita = receitaCurso;
                codigoMaiorReceita = cursos[i].getCodigo();
            }
        }

        System.out.println("Quantidade total de alunos aprovados: " + totalAprovados);
        System.out.println("Quantidade total de alunos reprovados: " + totalReprovados);
        System.out.println("Código do curso com maior receita: " + codigoMaiorReceita);

        scanner.close();
    }
}
