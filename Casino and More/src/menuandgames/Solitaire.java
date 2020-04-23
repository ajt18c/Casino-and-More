package menuandgames;

import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Solitaire extends ScreenConfig{

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    private ArrayList<CardButton>[] tableau;
    private ArrayList<CardButton>[] foundations;
    private ArrayList<CardButton> hand;
    private ArrayList<CardButton> waste;
    
    public Solitaire(){
        Deck deck = new Deck();
        tableau = new ArrayList[7];
        for(int i = 0; i < 7; i++) {
            tableau[i] = new ArrayList<CardButton>(0);
            for(int j = 0; j < 5; j++) {
                tableau[i].add(new CardButton(deck.draw()));
            }
        }
    }
}

class CardButton extends JButton {
    Card card;

    public CardButton(Card card) {
        super();
        this.card = card;
    }
}