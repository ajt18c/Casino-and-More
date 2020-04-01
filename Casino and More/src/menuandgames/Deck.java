package menuandgames;

import java.util.ArrayList;

public class Deck {
	
    private ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>(0);
		for(int i = 0; i < 52; i++) {
			cards.add(new Card(i%13, i%4));
		}
	}
	
	public Card draw() {
		int index = (int)(Math.random() * cards.size());
		return cards.remove(index);
	}

	public void shuffle() {
		cards.clear();
		for(int i = 0; i < 52; i++) {
			cards.add(new Card(i%13, i%4));
		}
	}
}
