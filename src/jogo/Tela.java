package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tela extends JPanel implements ActionListener {

    Image imagem;
    Personagem personagem;
    Bola bola;
    Timer timer, pausa;

    public Tela() {
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());

        ImageIcon ref = new ImageIcon("res\\Fundo.png");
        personagem = new Personagem();
        
        imagem = ref.getImage();

        timer = new Timer(15, this);
        timer.start();

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(imagem, 0, 0, null);
        g.drawImage(personagem.getImage(), personagem.getX(), personagem.getY(), 70, 120, this);
        List<Bola> bola = personagem.getMisseis();

        for (int i = 0; i < bola.size(); i++) {
            Bola vrau = (Bola) bola.get(i);
            g.drawImage(vrau.getImage(), vrau.getX(), vrau.getY(), 40, 40, this);
        }
        
        //g.drawImage(bola.getImage(), personagem.getX()+55, personagem.getY() +55,40,40,this);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        List<Bola> bola = personagem.getMisseis();

        for (int i = 0; i < bola.size(); i++){
            Bola vrau = (Bola) bola.get(i);
            if (vrau.isVisivel()) {
                vrau.mover();
            } else {
                bola.remove(i);
            }
        }
        
        personagem.mover();

        repaint();
    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            personagem.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            personagem.keyReleased(e);
        }
    }

}
