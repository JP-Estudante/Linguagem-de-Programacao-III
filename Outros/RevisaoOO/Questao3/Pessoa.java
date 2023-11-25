package RevisaoOO.Questao3;

public class Pessoa {
    private String nome;
    private Pessoa pai;
    private Pessoa mae;

    public Pessoa(String nome, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.pai = pai;
        this.mae = mae;
    }

    // Verificar igualdade semântica
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pessoa pessoa = (Pessoa) o;
        return nome.equals(pessoa.nome) && mesmaMae(pessoa);
    }

    private boolean mesmaMae(Pessoa pessoa) {
        if (mae == null && pessoa.mae == null) {
            return true;
        }
        if (mae == null || pessoa.mae == null) {
            return false;
        }
        return mae.equals(pessoa.mae);
    }

    // Verificar se duas pessoas são irmãs
    public boolean saoIrmas(Pessoa pessoa) {
        return mesmaMae(pessoa) && !this.equals(pessoa);
    }

    // Verificar se é antecessora
    public boolean ehAntecessoraDe(Pessoa pessoa) {
        if (pessoa == null) {
            return false;
        }
        return this.equals(pessoa.pai) || this.equals(pessoa.mae)
                || ehAntecessoraDe(pessoa.pai) || ehAntecessoraDe(pessoa.mae);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public Pessoa getPai() {
        return pai;
    }

    public Pessoa getMae() {
        return mae;
    }
}
