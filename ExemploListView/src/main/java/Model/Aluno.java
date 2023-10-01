package Model;

public class Aluno {
    private String nomeCompleto;


    public Aluno(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    @Override
    public String toString() {
        return nomeCompleto;
    }

}
