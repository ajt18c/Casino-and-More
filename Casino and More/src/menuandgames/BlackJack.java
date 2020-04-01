package menuandgames;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;

public class BlackJack extends ScreenConfig implements ActionListener{

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawLine(420, 0, 420, 1080);
        g.drawLine(1500, 0, 1500, 1080);
        g.drawLine(420, 420, 1500, 420);
        g.drawLine(420, 660, 1500, 660);
        for(int i = 0; i < 26; i++)
            g.drawImage(Card.getBack(), 600-i, 450-i, 135, 200, this);
        

        if(currentPlayer != numPlayers)
            g.drawImage(Card.getBack(), 420, 0, 135, 200, this);
        else
            g.drawImage(players[numPlayers].getCard(0).getImg(), 420, 0, 135, 200, this);
        
        for(int i = 1; i < players[numPlayers].getHand().size(); i++)
            g.drawImage(players[numPlayers].getCard(i).getImg(), i * 135 + 420, 0, 135, 200, this);

        for(int i = 0; i < players[0].getHand().size(); i++)
            g.drawImage(players[0].getCard(i).getImg(), i * 135 + 420, 660, 135, 200, this);
        
        if(numPlayers >= 2) {
            for(int i = 0; i < players[1].getHand().size(); i++)
                g.drawImage(players[1].getCard(i).getImg(), i%2 * 135, i/2 * 200, 135, 200, this);
        }

        if(numPlayers == 3) {
            for(int i = 0; i < players[2].getHand().size(); i++)
                g.drawImage(players[2].getCard(i).getImg(), i%2 * 135 + 1500, i/2 * 200, 135, 200, this);
        }
    }

    private Deck deck;
    private JButton hit;
    private JButton stand;
    private JButton newGame;
    private int numPlayers = 3;
    private int currentPlayer;
    private BJPlayer[] players;

    BlackJack() {
        setLayout(null);
        deck = new Deck();
        players = new BJPlayer[numPlayers+1];

        hit = new JButton("HIT");
	    hit.setBounds(960, 450, 150, 75);
		hit.addActionListener(this);
        add(hit);

        stand = new JButton("STAND");
	    stand.setBounds(960, 555, 150, 75);
		stand.addActionListener(this);
        add(stand);

        newGame = new JButton("NEWGAME");
	    newGame.setBounds(1210, 450, 150, 75);
		newGame.addActionListener(this);
        add(newGame);

        newGame();
    }
    
    public void newGame() {
        deck.shuffle();
        currentPlayer = 0;
        for(int i = 0; i <= numPlayers; i++) {
            players[i] = new BJPlayer();
            players[i].draw(deck.draw());
            players[i].draw(deck.draw());
        }

        while(players[currentPlayer].getTotal() >= 21 && currentPlayer != numPlayers)
            currentPlayer++;

        if(currentPlayer == numPlayers) {
            while(players[currentPlayer].getTotal() < 17) {
                players[currentPlayer].draw(deck.draw());
            }
            repaint();
        }

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String act = e.getActionCommand();

        if(act.equals("HIT") && currentPlayer != numPlayers) {
            players[currentPlayer].draw(deck.draw());

            while(players[currentPlayer].getTotal() >= 21 && currentPlayer != numPlayers)
                currentPlayer++;
            if(currentPlayer == players.length-1) {
                while(players[currentPlayer].getTotal() < 17) {
                    players[currentPlayer].draw(deck.draw());
                }
            }

            repaint();
        }
        else if(act.equals("STAND") && currentPlayer != numPlayers) {
            currentPlayer++;
            while(players[currentPlayer].getTotal() >= 21 && currentPlayer != numPlayers)
                currentPlayer++;
            if(currentPlayer == players.length-1) {
                while(players[currentPlayer].getTotal() < 17) {
                    players[currentPlayer].draw(deck.draw());
                }
                repaint();
            }
           
        }
        else if(act.equals("NEWGAME")) {
            newGame();
            repaint();
        }

    }
}