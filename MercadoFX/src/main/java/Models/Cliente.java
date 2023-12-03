package Models;

public class Cliente {

    private Integer id;
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf, int id) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}