package menuandgames;

import java.util.ArrayList;

public class Deck {
	// Holds all the remaining cards in the deck
    private ArrayList<Card> cards;
	
	public Deck() {
		// Fills the deck with cards
		cards = new ArrayList<Card>(0);
		for(int i = 0; i < 52; i++) {
			cards.add(new Card(i%13, i%4));
		}
	}
	
	// Choses a rendom card from the deck and returns it, removing it from the deck
	public Card draw() {
		int index = (int)(Math.random() * cards.size());
		return cards.remove(index);
	}

	// Resets the deck to full
	// Does not actually shuffle as pseudorandomness caused by shuffling is handled in draw
	public void shuffle() {
		cards.clear();
		for(int i = 0; i < 52; i++) {
			cards.add(new Card(i%13, i%4));
		}
	}
}
