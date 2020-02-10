
package menuandgames;
// The cards in the deck
public class Card {
	private enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS}
	private int num;
    private Suit suit;
    private String img;
	
	public Card(int num, int suit) {
        this.num = num + 1;
        switch(suit){
            case 0:
                this.suit = Suit.SPADES;
                break;
            case 1:
                this.suit = Suit.HEARTS;
                break;
            case 2:
                this.suit = Suit.CLUBS;
                break;
            case 3:
                this.suit = Suit.DIAMONDS;
        }
	}
	
	public int getNum() {
		return num;
	}
	
	public Suit getSuit() {
        return suit;
    }
    
    public String getImg() {
        return img;
    }
}