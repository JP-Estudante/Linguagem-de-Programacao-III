package RevisaoOO.Questao3;

public class Main {
    public static void main(String[] args) {
        Pessoa avoMaterno1 = new Pessoa("Avo Materno 1", null, null);
        Pessoa avoMaterno2 = new Pessoa("Avo Materno 2", null, null);

        Pessoa mae = new Pessoa("Mae", null, null);
        Pessoa pai = new Pessoa("Pai", null, null);

        Pessoa pessoa1 = new Pessoa("Filho 1", pai, mae);
        Pessoa pessoa2 = new Pessoa("Filho 2", pai, mae);

        Pessoa pessoa3 = new Pessoa("Filha 1", pai, mae);
        Pessoa pessoa4 = new Pessoa("Filha 2", pai, mae);

        mae = new Pessoa("Nova Mae", avoMaterno1, avoMaterno2);
        pai = new Pessoa("Novo Pai", null, null);

        Pessoa pessoa5 = new Pessoa("Neto", pai, mae);

        // Verificar igualdade semântica
        System.out.println("Pessoa1 é igual à Pessoa2? " + pessoa1.equals(pessoa2));

        // Verificar se são irmãs
        System.out.println("Pessoa3 e Pessoa4 são irmãs? " + pessoa3.saoIrmas(pessoa4));

        // Verificar se é antecessora
        System.out.println("Pessoa5 é antecessora de Pessoa3? " + pessoa5.ehAntecessoraDe(pessoa3));
    }
}
