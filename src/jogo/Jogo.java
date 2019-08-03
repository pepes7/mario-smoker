package jogo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Jogo extends JFrame {
    Tela tela;
    
    public Jogo() {
        //define todos as configurações da tela
        tela = new Tela();
        add(tela);
        setTitle("Running");
        setSize(1300, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }


    public static void main(String[] args) {
        new Jogo();
    }

}
