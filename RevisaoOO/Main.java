package RevisaoOO;

public class Main {
    public static void main(String[] args) {
        Pais brasil = new Pais("BRA", "Brasil", 8515767.049);

        System.out.println(brasil);
    
        brasil.getVizinhos();
    }
}
