
package menuandgames;

import java.util.ArrayList;

public class Deck {
	
    private ArrayList<Card> cards;
	
	public Deck() {
		for(int i = 1; i <= 52; i++) {
			cards.add(new Card(i%13, i%4));
		}
	}
	
	public Card draw() {
		int index = (int)(Math.random() * cards.size());
		Card temp = cards.remove(index);
		return temp;
	}
}
