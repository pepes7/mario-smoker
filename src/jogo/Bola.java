package jogo;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Bola{

    private static int LARG = 1300;
    private Image imagem;
    ImageIcon fogo;
    private int x, y,largura,altura;
    boolean isVisivel;

    public Bola(int x, int y) {
        this.x = x;
        this.y = y;

        fogo = new ImageIcon("res\\Rasengan.png");
        imagem = fogo.getImage();
        
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);

        isVisivel = true;
    }

    public void mover() {
        x += 2; // Adiciona Velocidade
        if (this.x > 2) { //faz sumir se passar da tela 
            isVisivel = false;
        }

    }

    public Image getImage() {
        return imagem;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
}
