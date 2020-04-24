
package menuandgames;

import java.awt.Image;
import javax.swing.ImageIcon;
// The cards in the deck
public class Card {
    // The card back
    private static Image back = new ImageIcon("Casino and More/res/cards/backs/Red.png").getImage();
	private enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS}
	private int val;
    private Suit suit;
    private Image img;
	
	public Card(int num, int suit) {
        // Sets up the card with a suit, number, and image
        val = num + 1;
        switch(suit){
            case 0:
                this.suit = Suit.SPADES;
                img = new ImageIcon("Casino and More/res/cards/" + String.valueOf(val) + "spade.png").getImage();
                break;
            case 1:
                this.suit = Suit.HEARTS;
                img = new ImageIcon("Casino and More/res/cards/" + String.valueOf(val) + "heart.png").getImage();
                break;
            case 2:
                this.suit = Suit.CLUBS;
                img = new ImageIcon("Casino and More/res/cards/" + String.valueOf(val) + "club.png").getImage();
                break;
            case 3:
                this.suit = Suit.DIAMONDS;
                img = new ImageIcon("Casino and More/res/cards/" + String.valueOf(val) + "diamond.png").getImage();
        }
	}
    
    // Sets a new card back
    public static void setBack(String imgLocation) {
        back = new ImageIcon(imgLocation).getImage();
    }
    public static void setBackFromComp(String imgLocation) {
        back = new ImageIcon(imgLocation).getImage();
    }

    // returns the value of the card
	public int getVal() {
		return val;
    }
    
    // Returns the name of the card
    public String getName() {
        switch(val) {
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return String.valueOf(val);
        }
    }
    
    // Returns the suit of the card
	public Suit getSuit() {
        return suit;
    }
    
    // Returns the card image
    public Image getImg() {
        return img;
    }

    // Returns the image for the card back
    public static Image getBack() {
        return back;
    }
}