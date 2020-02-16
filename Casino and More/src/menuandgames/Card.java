
package menuandgames;
// The cards in the deck
public class Card {
	private enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS}
	private int num;
    private Suit suit;
    private String img;
	
	public Card(int num, int suit) {
        this.num = num + 1;
        img  = String.valueOf(num);
        switch(suit){
            case 0:
                this.suit = Suit.SPADES;
                img += "spade";
                break;
            case 1:
                this.suit = Suit.HEARTS;
                img += "heart";
                break;
            case 2:
                this.suit = Suit.CLUBS;
                img += "club";
                break;
            case 3:
                this.suit = Suit.DIAMONDS;
                img += "diamond";
        }
	}
	
	public int getNum() {
		return num;
    }

    
    
    public String getName() {
        switch(num) {
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return String.valueOf(num);
        }
    }
	
	public Suit getSuit() {
        return suit;
    }
    
    public String getImg() {
        return img;
    }
}