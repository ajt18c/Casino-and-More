package menuandgames;

import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class BlackJack extends ScreenConfig{

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    private Deck deck;

    public BlackJack() {
        deck = new Deck();
    }
    
    public void newGame() {
        deck.shuffle();
    }
}