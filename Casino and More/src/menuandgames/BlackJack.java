package menuandgames;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BlackJack extends ScreenConfig implements ActionListener{
    private Deck deck;
    private JButton hit;
    private JButton stand;
    private JButton newGame;
    private JTextArea status;
    private int numPlayers;
    private int currentPlayer;
    private BJPlayer[] players;

    BlackJack(int numPlayers) {
        setLayout(null);
        deck = new Deck();
        this.numPlayers = (numPlayers <= 3)? numPlayers : 3;
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

        status = new JTextArea("Player 1's turn (Bottom)");
        status.setBounds(1210, 555, 200, 75);
        status.setForeground(Color.RED);
        status.setOpaque(false);
        status.setEditable(false);
        status.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        add(status);

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

        while(players[currentPlayer].getTotal() >= 21 && currentPlayer != numPlayers){
            currentPlayer++;
            String local;
            if(currentPlayer == 1)
                local = "Left";
            else if(currentPlayer == 2)
                local = "Right";
            else
                local = "Top";
            status.setText("Player " + (currentPlayer+1) + "\'s turn (" + local + ")"); 
        }

        if(currentPlayer == numPlayers) {
            while(players[currentPlayer].getTotal() < 17) {
                players[currentPlayer].draw(deck.draw());
            }
            status.setText("Winners: ");
                for(int i = 0; i < numPlayers; i++) {
                    if(players[i].getTotal() < 21 && (players[i].getTotal() > players[numPlayers].getTotal() || players[numPlayers].getTotal() > 21)) {
                        status.setText(status.getText() + "\nPlayer " + (i+1));
                    }
                }
            repaint();
        }

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawLine(420, 0, 420, 1080);
        g.drawLine(1500, 0, 1500, 1080);
        g.drawLine(420, 420, 1500, 420);
        g.drawLine(420, 660, 1500, 660);
        for(int i = 0; i < 26; i++)
            g.drawImage(Card.getBack(), 600-i, 450-i, 135, 200, this);
        
        g.setColor(Color.RED);
        if(currentPlayer != numPlayers)
            g.drawImage(Card.getBack(), 420, 0, 135, 200, this);
        else
            g.drawImage(players[numPlayers].getCard(0).getImg(), 420, 0, 135, 200, this);
        
        for(int i = 1; i < players[numPlayers].getHand().size(); i++)
            g.drawImage(players[numPlayers].getCard(i).getImg(), i * 135 + 420, 0, 135, 200, this);
        if(players[numPlayers].getTotal() > 21) {
            g.drawLine(420, 0, 1500, 420);
            g.drawLine(420, 420, 1500, 0);
        }

        for(int i = 0; i < players[0].getHand().size(); i++)
            g.drawImage(players[0].getCard(i).getImg(), i * 135 + 420, 660, 135, 200, this);
        if(players[0].getTotal() > 21) {
            g.drawLine(420, 660, 1500, 1080);
            g.drawLine(420, 1080, 1500, 660);
        }


        if(numPlayers >= 2) {
            for(int i = 0; i < players[1].getHand().size(); i++)
                g.drawImage(players[1].getCard(i).getImg(), i%2 * 135, i/2 * 200, 135, 200, this);
            if(players[1].getTotal() > 21) {
                g.drawLine(0, 0, 420, 1080);
                g.drawLine(0, 1080, 420, 0);
            }
        }

        if(numPlayers == 3) {
            for(int i = 0; i < players[2].getHand().size(); i++)
                g.drawImage(players[2].getCard(i).getImg(), i%2 * 135 + 1500, i/2 * 200, 135, 200, this);
            if(players[2].getTotal() > 21) {
                g.drawLine(1500, 0, 1920, 1080);
                g.drawLine(1500, 1080, 1920, 0);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String act = e.getActionCommand();

        if(act.equals("HIT") && currentPlayer != numPlayers) {
            players[currentPlayer].draw(deck.draw());

            while(players[currentPlayer].getTotal() >= 21 && currentPlayer != numPlayers) {
                currentPlayer++;
                String local;
                if(currentPlayer == 1)
                    local = "Left";
                else if(currentPlayer == 2)
                    local = "Right";
                else
                    local = "Top";
                status.setText("Player " + (currentPlayer+1) + "\'s turn (" + local + ")");  
            }
            
            if(currentPlayer == players.length-1) {
                while(players[currentPlayer].getTotal() < 17) {
                    players[currentPlayer].draw(deck.draw());
                }
                status.setText("Winners: ");
                for(int i = 0; i < numPlayers; i++) {
                    if(players[i].getTotal() < 21 && (players[i].getTotal() > players[numPlayers].getTotal() || players[numPlayers].getTotal() > 21)) {
                        status.setText(status.getText() + "\nPlayer " + (i+1));
                    }
                }

            }

            repaint();
        }
        else if(act.equals("STAND") && currentPlayer != numPlayers) {
            currentPlayer++;
            while(players[currentPlayer].getTotal() >= 21 && currentPlayer != numPlayers) {
                currentPlayer++;
                String local;
                if(currentPlayer == 1)
                    local = "Left";
                else
                    local = "Right";
                status.setText("Player " + (currentPlayer+1) + "\'s turn (" + local + ")");  
            }
            if(currentPlayer == players.length-1) {
                while(players[currentPlayer].getTotal() < 17) {
                    players[currentPlayer].draw(deck.draw());
                }
                status.setText("Winners: ");
                for(int i = 0; i < numPlayers; i++) {
                    if(players[i].getTotal() < 21 && (players[i].getTotal() > players[numPlayers].getTotal() || players[numPlayers].getTotal() > 21)) {
                        status.setText(status.getText() + "\nPlayer " + (i+1));
                    }
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