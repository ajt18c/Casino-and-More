package menuandgames;

import java.util.ArrayList;

// Generic player for use with multiple games
public abstract class Player {
    // The cards in the players hand
    protected ArrayList<Card> hand;
    
	Player() {
		hand = new ArrayList<Card>(0);
	}
    
    // Gives a card to the players hand
	public void draw(Card card) {
		hand.add(card);
	}
    
    // Returns the players hand
	public ArrayList<Card> getHand() {
		return hand;
    }
    
    // Returns the card at index i in the players hand
    public Card getCard(int i) {
        return hand.get(i);
    }
}

// Adds extra features to the player for blackjack
class BJPlayer extends Player {
    // The total value of the hand and the number of aces in the hand
    private int total;
    private int aces;
    
    BJPlayer() {
        super();
        total = 0;
        aces = 0;
    }

    @Override
    public void draw(Card card) {
        super.draw(card);
        // Adds to total and aces based on the card drawn
        if(card.getVal() > 10)
            total += 10;
        else if(card.getVal() == 1) {
            total += 11;
            aces++;
        }
        else
            total += card.getVal();
        
        // If an ace exists and 21 is exceeded then the ace will instead count as a 1
        while(total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }    
    }

    // Returns the total value
    public int getTotal() {
        return total;
    }
}