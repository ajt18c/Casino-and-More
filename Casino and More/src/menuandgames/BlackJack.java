
package menuandgames;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BlackJack extends JPanel{

    private Deck deck;

    private JButton hit;
    private JButton stand;
    private JLabel playerStatus;
    private JLabel dealerStatus;
    private Player[] players;

    BlackJack(int numPlayers) {
        this.setLayout(null);
        deck = new Deck();
        players = new BJPlayer[numPlayers];

        hit = new JButton("HIT");
	    //hit.setBounds(400, 310, 150, 75);
		//hit.addActionListener(new hitListener());
        this.add(hit);

        stand = new JButton("STAND");
	    //stand.setBounds(600, 310, 150, 75);
		//hit.addActionListener(new standListener());
        this.add(stand);

        playerStatus = new JLabel("");
        dealerStatus = new JLabel("");
    }

    public void newGame() {
        deck.shuffle();
    }
}