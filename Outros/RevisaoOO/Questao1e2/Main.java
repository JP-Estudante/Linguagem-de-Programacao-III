package RevisaoOO.Questao1e2;

public class Main {
    public static void main(String[] args) {
        // Criar países
        Pais brasil = new Pais("BRA", "Brasil", 211049527, 8515767.049);
        Pais argentina = new Pais("ARG", "Argentina", 45195777, 2780400.0);
        Pais chile = new Pais("CHL", "Chile", 19116201, 756950.0);

        // Adicionar fronteiras
        brasil.adicionarFronteira(argentina);
        brasil.adicionarFronteira(chile);
        argentina.adicionarFronteira(chile);

        // Criar continente
        Continente americaDoSul = new Continente("América do Sul");
        americaDoSul.adicionarPais(brasil);
        americaDoSul.adicionarPais(argentina);
        americaDoSul.adicionarPais(chile);

        // Realizar cálculos e exibir informações
        System.out.println("Dimensão total do continente: " + americaDoSul.calcularDimensaoTotal() + " km²");
        System.out.println("População total do continente: " + americaDoSul.calcularPopulacaoTotal());
        System.out.println("Densidade populacional do continente: " + americaDoSul.calcularDensidadePopulacional());

        Pais maiorPopulacao = americaDoSul.encontrarPaisMaiorPopulacao();
        System.out.println("País com maior população: " + maiorPopulacao.getNome());

        Pais menorPopulacao = americaDoSul.encontrarPaisMenorPopulacao();
        System.out.println("País com menor população: " + menorPopulacao.getNome());

        Pais maiorDimensao = americaDoSul.encontrarPaisMaiorDimensao();
        System.out.println("País com maior dimensão territorial: " + maiorDimensao.getNome());

        Pais menorDimensao = americaDoSul.encontrarPaisMenorDimensao();
        System.out.println("País com menor dimensão territorial: " + menorDimensao.getNome());

        double razaoTerritorial = americaDoSul.calcularRazaoTerritorial();
        System.out.println("Razão territorial entre o maior e menor país: " + razaoTerritorial);
    }
}
