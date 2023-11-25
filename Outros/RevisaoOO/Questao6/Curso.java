package RevisaoOO.Questao6;

class Curso {
    private int codigo;
    private int quantidadeAlunosMatriculados;
    private double valorMensalidade;
    private int alunosAprovados;

    public Curso(int codigo, double valorMensalidade) {
        this.codigo = codigo;
        this.valorMensalidade = valorMensalidade;
        this.quantidadeAlunosMatriculados = 0;
        this.alunosAprovados = 0;
    }

    public void matricularAluno() {
        if (quantidadeAlunosMatriculados < 5) {
            quantidadeAlunosMatriculados++;
        }
    }

    public void registrarNota(double nota) {
        if (nota >= 0 && nota <= 10) {
            if (nota >= 7.0) {
                alunosAprovados++;
            }
        }
    }

    public double calcularReceita() {
        return quantidadeAlunosMatriculados * valorMensalidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getAlunosAprovados() {
        return alunosAprovados;
    }

    public int getQuantidadeAlunosMatriculados() {
        return quantidadeAlunosMatriculados;
    }
}