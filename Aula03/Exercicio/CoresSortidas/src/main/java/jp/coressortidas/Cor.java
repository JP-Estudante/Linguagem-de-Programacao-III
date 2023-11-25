package jp.coressortidas;

import java.util.Random;

public class Cor {
    int r, g, b;

    public Cor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
    
    public Cor gerarCorAleatoriamente(){
        Random randColor = new Random();
        r = randColor.nextInt(256);
        g = randColor.nextInt(256);
        b = randColor.nextInt(256);
        return new Cor(r, g, b);
    }

    @Override
    public String toString() {
        return "Cor{" + "r=" + r + ", g=" + g + ", b=" + b + '}';
    }
}
