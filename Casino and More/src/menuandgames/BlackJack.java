
package menuandgames;

import javax.swing.JPanel;

public class BlackJack extends JPanel{

    private Deck deck;

    BlackJack() {
        deck = new Deck();

        
    }

    public void newGame() {
        deck.shuffle();
    }
}