package menuandgames;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BlackJack extends ScreenConfig implements ActionListener{
    private Deck deck;
    private JTextArea status;
    private int numPlayers;
    private int currentPlayer;
    private BJPlayer[] players;

    BlackJack(int numPlayers) {
        setLayout(null);
        deck = new Deck();
        // Max of 3 players + Dealer
        this.numPlayers = (numPlayers <= 3)? numPlayers : 3;
        players = new BJPlayer[this.numPlayers+1];

        /* Sets up the buttons for recieving a card, ending your turn,
            and starting a new game, respectively */
        JButton hit = new JButton("HIT");
	    hit.setBounds(960, 450, 150, 75);
		hit.addActionListener(this);
        add(hit);

        JButton stand = new JButton("STAND");
	    stand.setBounds(960, 555, 150, 75);
		stand.addActionListener(this);
        add(stand);

        JButton newGame = new JButton("NEWGAME");
	    newGame.setBounds(1210, 450, 150, 75);
		newGame.addActionListener(this);
        add(newGame);

        // Sets a status bar for player turn and location, also tells who won
        status = new JTextArea();
        status.setBounds(1210, 555, 200, 100);
        status.setForeground(Color.RED);
        status.setOpaque(false);
        status.setEditable(false);
        status.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        add(status);

        // Starts a game
        newGame();
    }
    
    // Starts a new game
    public void newGame() {
        // Resets the deck and draws 2 cards for each player
        deck.shuffle();
        currentPlayer = 0;
        for(int i = 0; i <= numPlayers; i++) {
            players[i] = new BJPlayer();
            players[i].draw(deck.draw());
            players[i].draw(deck.draw());
        }

        // Sets the initial status for player 1 and then updates based on the starting cards
        status.setText("Player 1's turn (Bottom)");
        checkStatus();
    }

    // Updates the status based on the cards held by the players
    // If it gets to the dealers turn, then it automatically goes the dealers turn
    private void checkStatus() {
        // Checks if the player busted or has 21
        // In both cases their turn is ended
        while(players[currentPlayer].getTotal() >= 21 && currentPlayer != numPlayers){
            currentPlayer++;
            String local;
            if(currentPlayer == 1)
                local = "Left";
            else
                local = "Right";
            status.setText("Player " + (currentPlayer+1) + "\'s turn (" + local + ")");
        }

        // Goes the dealers turn and then gives winners
        if(currentPlayer == numPlayers) {
            // If all the players busted, then the computer does not need to go its turn
            if(!playersBust()) {
                while(players[currentPlayer].getTotal() < 17)
                    players[currentPlayer].draw(deck.draw());
            }
            status.setText("Winners:");
            for(int i = 0; i < numPlayers; i++) {
                if(players[i].getTotal() <= 21 && (players[i].getTotal() > players[numPlayers].getTotal() || players[numPlayers].getTotal() > 21)) {
                    status.setText(status.getText() + "\nPlayer " + (i+1));
                }
            }
            if(status.getText().equals("Winners:"))
                status.setText("Dealer Wins");    
        }
        // Displays changes made
        repaint();
    }

    // Tells if all the players busted
    private boolean playersBust() {
        for(int i = 0; i < numPlayers; i++)
            if(players[i].getTotal() <= 21)
                return false;
        return true;
    }

    // Reacts to the buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        String act = e.getActionCommand();

        // Starts a new game
        if(act.equals("NEWGAME"))
            newGame();
        // If the game is ended then the hit and stand buttons should not do anything
        else if(currentPlayer != numPlayers) {
            // Adds a card to the players hand
            if(act.equals("HIT"))
                players[currentPlayer].draw(deck.draw());
            // Moves on to the next player and updates the status accordingly
            else if(act.equals("STAND")){
                currentPlayer++;
                String local;
                if(currentPlayer == 1)
                    local = "Left";
                else
                    local = "Right";
                status.setText("Player " + (currentPlayer+1) + "\'s turn (" + local + ")");
            }
            // Updates based on the current cards in play
            checkStatus();
        }
    }

    // Displays cards
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // Separates player's card areas
        g.drawLine(420, 0, 420, 1080);
        g.drawLine(1500, 0, 1500, 1080);
        g.drawLine(420, 420, 1500, 420);
        g.drawLine(420, 660, 1500, 660);
        // Displays the deck
        for(int i = 0; i < 26; i++)
            g.drawImage(Card.getBack(), 600-i, 450-i, 135, 200, this);
        
        // Sets the color to red for players that have busted
        g.setColor(Color.RED);
        // Depending on the current player, the dealer's first card may be revealed
        if(currentPlayer != numPlayers)
            g.drawImage(Card.getBack(), 420, 0, 135, 200, this);
        else
            g.drawImage(players[numPlayers].getCard(0).getImg(), 420, 0, 135, 200, this);
        // Displays the rest of the dealer's cards
        for(int i = 1; i < players[numPlayers].getHand().size(); i++)
            g.drawImage(players[numPlayers].getCard(i).getImg(), i * 135 + 420, 0, 135, 200, this);
        // Places a red x on the dealer's space if he has busted
        if(players[numPlayers].getTotal() > 21) {
            g.drawLine(420, 0, 1500, 420);
            g.drawLine(420, 420, 1500, 0);
        }

        // Displays player 1's cards and if they have busted
        for(int i = 0; i < players[0].getHand().size(); i++)
            g.drawImage(players[0].getCard(i).getImg(), i * 135 + 420, 660, 135, 200, this);
        if(players[0].getTotal() > 21) {
            g.drawLine(420, 660, 1500, 1080);
            g.drawLine(420, 1080, 1500, 660);
        }

        // If there is a player 2, then displays their cards and if they have busted
        if(numPlayers >= 2) {
            for(int i = 0; i < players[1].getHand().size(); i++)
                g.drawImage(players[1].getCard(i).getImg(), i%2 * 135, i/2 * 200, 135, 200, this);
            if(players[1].getTotal() > 21) {
                g.drawLine(0, 0, 420, 1080);
                g.drawLine(0, 1080, 420, 0);
            }
        }

        // If there is a player 3, then displays their cards and if they have busted
        if(numPlayers == 3) {
            for(int i = 0; i < players[2].getHand().size(); i++)
                g.drawImage(players[2].getCard(i).getImg(), i%2 * 135 + 1500, i/2 * 200, 135, 200, this);
            if(players[2].getTotal() > 21) {
                g.drawLine(1500, 0, 1920, 1080);
                g.drawLine(1500, 1080, 1920, 0);
            }
        }
    }
}