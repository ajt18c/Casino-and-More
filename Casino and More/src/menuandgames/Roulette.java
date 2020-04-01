package menuandgames;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Roulette extends ScreenConfig{
    Image RouletteTable = new ImageIcon("Casino and More/res/RouletteTable2.jpg").getImage();
    Image RouletteWheel = new ImageIcon("Casino and More/res/RouletteWheel.png").getImage();

    private JButton[] buttons = new JButton[49];
    private int[] numBets = new int[49];
    public static final int defaultNum = 1000;

    private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 50);
    private JLabel scoreCounter;
    private int currentBet;
    private int payout;

    private JButton spin;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(0,105,0));
        g.drawImage(RouletteTable, 0, 90, 1185, 780, this);
        g.drawImage(RouletteWheel, 488, 7, 225, 225, this);
    }

    public Roulette(){
        Image spinImage = new ImageIcon("Casino and More/res/SpinButton.png").getImage().getScaledInstance(230,230,java.awt.Image.SCALE_SMOOTH);
        Icon spinButton = new ImageIcon(spinImage);
        spin = new JButton(spinButton);
        this.setLayout(null);
        this.add(spin);
        spin.setContentAreaFilled(false);
        spin.addActionListener(new gameListener());
        spin.setBorderPainted(false);
        spin.setFocusPainted(true);
        spin.setBounds(850, 25, 200, 200);

        this.setLayout(null);
        scoreCounter = new JLabel(Integer.toString(defaultNum));
        scoreCounter.setFont(font);
        scoreCounter.setForeground(Color.RED);
        this.add(scoreCounter);
        scoreCounter.setBounds(250, 105, 150, 50);

        for(int i = 0; i < 49; i++)
        {
            buttons[i] = new JButton();
            this.setLayout(null);
            this.add(buttons[i]);
            buttons[i].setContentAreaFilled(false);
            buttons[i].addActionListener(new buttonListener());
        }
        int x = 111;
        int spot = 3;
        for(int i = 0; i < 13; i++)
        {
            buttons[i].setActionCommand(Integer.toString(spot));
            spot += 3;
            buttons[i].setBounds(x, 238, 80,115);
            x+=80;
        }
        spot = 2;
        x = 111;
        for(int i = 13; i < 26; i++)
        {
            buttons[i].setActionCommand(Integer.toString(spot));
            spot += 3;
            buttons[i].setBounds(x, 353, 80,115);
            x+=80;
        }
        spot = 1;
        x = 111;
        for(int i = 26; i < 39; i++)
        {
            buttons[i].setActionCommand(Integer.toString(spot));
            spot += 3;
            buttons[i].setBounds(x, 468, 80,115);
            x+=80;
        }
        spot = 40;
        x=111;
        for(int i = 39; i < 42; i++)
        {
            buttons[i].setActionCommand(Integer.toString(spot));
            spot++;
            buttons[i].setBounds(x, 580, 320, 90);
            x+=320;
        }
        x=111;
        spot = 43;
        for(int i = 42; i < 48; i++)
        {
            buttons[i].setActionCommand(Integer.toString(spot));
            spot++;
            buttons[i].setBounds(x, 668, 160, 88);
            x+=161;
        }
        buttons[48].setBounds(35, 353, 75, 115);
        buttons[48].setActionCommand(Integer.toString(0));
    }

    public int score(int bet){
        return Integer.parseInt(scoreCounter.getText()) - bet;
    }

    public void currentBet(int bet){
        currentBet = currentBet + bet;
        System.out.println(currentBet);
    }
    class buttonListener implements ActionListener{
        private JLabel gameOver;
        private Font font2 = new Font(Font.SANS_SERIF, Font.BOLD, 150);
        String gameOverStr = "GAME OVER";
        public void actionPerformed(ActionEvent event){
            if(Integer.parseInt(scoreCounter.getText()) == 0)
            {
                if(currentBet != 0)
                    return;
                scoreCounter.setText(Integer.toString(score(-25)));
                setLayout(null);
                gameOver = new JLabel("GAME OVER");
                gameOver.setFont(font2);
                gameOver.setForeground(Color.BLACK);
                add(gameOver);
                for(int i = 0; i < 40; i++)
                    buttons[i].setEnabled(false);
                gameOver.setBounds(125, 5, 1200, 800);
            }
            scoreCounter.setText(Integer.toString(score(25)));
            currentBet(25);
        }
    }
    class gameListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            
        }
    }
}
