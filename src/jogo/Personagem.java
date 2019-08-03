package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Personagem {
    // Fricção - contante que diminui a velocidade horizontal (faz parar).
    // Gravidade - constante que aumenta a velocidade vertical (faz cair).
    double gravity;
    //variavel que verifica se o boneco ta na ação pular
    boolean up;

    private int altura, largura;
    private int x, y;
    private int dx, dy;
    private Image imagem;
    ImageIcon pular, correr, reverso, parado, paradoInverso, ataque, ataqueInverso;
    private List<Bola> bola;

    private static final int CHAO = 578;
    private static final int MAXALTURAPULO = 478;

    public Personagem() {
        correr = new ImageIcon("res\\corre.gif");
        pular = new ImageIcon("res\\pular.png");
        parado = new ImageIcon("res\\p.png");
        reverso = new ImageIcon("res\\corre2.gif");
        paradoInverso = new ImageIcon("res\\paradoInverso.png");
        ataque = new ImageIcon("res\\ataque.png");
        ataqueInverso = new ImageIcon("res\\ataqueReverso.png");

        imagem = parado.getImage();
        this.x = 50;
        this.y = 578;
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);

        bola = new ArrayList<Bola>();

        up = false;

        gravity = 1;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public Image getImage() {
        return imagem;
    }

    public void mover() {
        dy += gravity;
        x += dx;
        y += dy + gravity;
        y+= dy;

        if (this.y <= CHAO) {
            up = false;
        }

        if (this.x > 1228) {
            this.x = 1228;
        }
        if (this.x < -8) {
            this.x = -8;
        }
        if (this.y < MAXALTURAPULO) {
            this.y = MAXALTURAPULO;
        }
        if (this.y > CHAO) {
            y = CHAO;
        }

    }

    public List<Bola> getMisseis() {
        return bola;
    }

    public void lancarBola() {
        bola.add(new Bola(getX()+55,getY() +55));
    }

    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_LEFT) {
            imagem = reverso.getImage();
            dx = -4;
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            imagem = correr.getImage();
            dx = 4;
        }
        if (up == false) {
            if (codigo == KeyEvent.VK_UP) {

                this.imagem = pular.getImage();
                if (up == false && y == CHAO) {  //CONDIÇÃO PARA MELHORAR O PULO
                    dy = -100;
                }
                mover();
                dy = -5;

            }
        }
        if (codigo == KeyEvent.VK_SPACE) {
            imagem = ataque.getImage();
            lancarBola();

        }
        
        if (codigo == KeyEvent.VK_DOWN) {
            imagem = ataque.getImage();
            dy = 5;

        }

    }

    public void keyReleased(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_LEFT) {
            imagem = paradoInverso.getImage();
            dx = 0;
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            imagem = parado.getImage();
            dx = 0;
        }

        if (codigo == KeyEvent.VK_UP) {
            dy = 0;

        }

        if (codigo == KeyEvent.VK_SPACE) {
            this.imagem = parado.getImage();

        }
    }
}
 