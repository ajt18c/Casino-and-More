package menuandgames;

import java.util.ArrayList;

public abstract class Player {
    protected ArrayList<Card> hand;
	
	Player() {
		hand = new ArrayList<Card>(0);
	}
	
	public void draw(Card card) {
		hand.add(card);
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
}

class BJPlayer extends Player {
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
        if(card.getNum() > 10)
            total += 10;
        else if(card.getNum() == 1) {
            total += 11;
            aces++;
        }
        else
            total += card.getNum();
        
        while(total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }    
    }

    public int getTotal() {
        return total;
    }
}