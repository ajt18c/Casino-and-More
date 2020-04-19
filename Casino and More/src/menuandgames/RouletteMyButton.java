package menuandgames;

import javax.swing.JButton;

public class RouletteMyButton extends JButton{
    public int currentBet;
    public int payoutRate;

    public RouletteMyButton(){
        currentBet = 0;
        payoutRate = 0;
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setVisible(true);

    }
    public void clear(){
        currentBet = 0;
        payoutRate = 0;
        this.setIcon(null);
    }
}