package menuandgames;

import javax.swing.JButton;

public class RouletteMyButton extends JButton{
    public int currentBet;
    public int payoutRate;

    public RouletteMyButton(){ //a button that stores payout rates and current bets
        currentBet = 0;
        payoutRate = 0;
        this.setContentAreaFilled(false); //keep button clear
        this.setBorderPainted(false);
        this.setVisible(true);

    }
    public void clear(){ //empty a button
        currentBet = 0;
        payoutRate = 0;
        this.setIcon(null);
    }
}