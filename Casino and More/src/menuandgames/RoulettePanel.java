package menuandgames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoulettePanel extends JPanel{

    private Image RouletteTable = new ImageIcon("Casino and More/res/RouletteTable2.jpg").getImage();
    //private Image RouletteTable = new ImageIcon(getClass().getResource("Casino and More/res/RouletteTable2.jpg")).getImage();

    private Image BlackChip = new ImageIcon("Casino and More/res/BlackChip.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    //private Image BlackChip = new ImageIcon(getClass().getResource("Casino and More/res/BlackChip.png")).getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    private Icon BlackChipIcon = new ImageIcon(BlackChip);

    private Image RedChip = new ImageIcon("Casino and More/res/RedChip.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    //private Image RedChip = new ImageIcon(getClass().getResource("Casino and More/res/RedChip.png")).getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    private Icon RedChipIcon = new ImageIcon(RedChip);

    private Image GreenChip = new ImageIcon("Casino and More/res/GreenChip.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    //private Image GreenChip = new ImageIcon(getClass().getResource("Casino and More/res/GreenChip.png")).getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    private Icon GreenChipIcon = new ImageIcon(GreenChip);

    private Image WhiteChip = new ImageIcon("Casino and More/res/WhiteChip.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    //private Image WhiteChip = new ImageIcon(getClass().getResource("Casino and More/res/WhiteChip.png")).getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    private Icon WhiteChipIcon = new ImageIcon(WhiteChip);

    

    private Image FiveChip = new ImageIcon("Casino and More/res/5Chip.png").getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
    //private Image FiveChip = new ImageIcon(getClass().getResource("Casino and More/res/5Chip.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
    private Icon FiveChipIcon = new ImageIcon(FiveChip);

    private Image TwentyFiveChip = new ImageIcon("Casino and More/res/25Chip.png").getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
    //private Image TwentyFiveChip = new ImageIcon(getClass().getResource("Casino and More/res/25Chip.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
    private Icon TwentyFiveChipIcon = new ImageIcon(TwentyFiveChip);

    private Image HundredChip = new ImageIcon("Casino and More/res/100Chip.png").getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
    //private Image HundredChip = new ImageIcon(getClass().getResource("Casino and More/res/100Chip.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
    private Icon HundredChipIcon = new ImageIcon(HundredChip);

    private Image FiveHundredChip = new ImageIcon("Casino and More/res/500Chip.png").getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
    //private Image FiveHundredChip = new ImageIcon(getClass().getResource("Casino and More/res/500Chip.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
    private Icon FiveHundredChipIcon = new ImageIcon(FiveHundredChip);

    private Image spinImage = new ImageIcon("Casino and More/res/SpinButton.png").getImage().getScaledInstance(325,325,java.awt.Image.SCALE_SMOOTH);
    //private Image spinImage = new ImageIcon(getClass().getResource("Casino and More/res/SpinButton.png")).getImage().getScaledInstance(225, 225, java.awt.Image.SCALE_SMOOTH);
    private Icon spinButton = new ImageIcon(spinImage);

    public JTextArea winningNumberArea;

    private JTextArea currentTurnArea;

    public int defaultNum = 10000;
    public int defaultNum2 = 10000;
    public int defaultNum3 = 10000;
    public int defaultNum4 = 10000;

    private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 33);

    private JLabel scoreCounter;
    private JLabel scoreCounterPre;
    private JLabel betCounter;
    private JLabel betCounterPre;
    private JLabel handCounter;
    private JLabel handCounterPre;
    private JLabel playerNum1;

    private JLabel scoreCounter2;
    private JLabel scoreCounterPre2;
    private JLabel betCounter2;
    private JLabel betCounterPre2;
    private JLabel handCounter2;
    private JLabel handCounterPre2;
    private JLabel playerNum2;

    private JLabel scoreCounter3;
    private JLabel scoreCounterPre3;
    private JLabel betCounter3;
    private JLabel betCounterPre3;
    private JLabel handCounter3;
    private JLabel handCounterPre3;
    private JLabel playerNum3;

    private JLabel scoreCounter4;
    private JLabel scoreCounterPre4;
    private JLabel betCounter4;
    private JLabel betCounterPre4;
    private JLabel handCounter4;
    private JLabel handCounterPre4;
    private JLabel playerNum4;

    private int payout;
    private int payout2;
    private int payout3;
    private int payout4;
    private int currentBet;

    private int currentPlayer = 1;

    private int winningNumber;

    private JButton spin;

    private JButton fiveChip;
    private JButton twentyFiveChip;
    private JButton hundredChip;
    private JButton fiveHundredChip;

    private RouletteMyButton[][] buttons = new RouletteMyButton[4][157]; //array of possible betting spots on roulette board

    private RouletteRotatePanel rotate = new RouletteRotatePanel(this);

    private gameListener gl;

    private int numPlayers;

    public RoulettePanel(int num, int payroll){
        numPlayers = num;
        defaultNum = payroll;
        defaultNum2 = payroll;
        defaultNum3 = payroll;
        defaultNum4 = payroll;
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 157; j++){
                final int temp = i;
                final int temp2 = j;
                buttons[i][j] = new RouletteMyButton();
                buttons[i][j].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(handCounter(0, currentPlayer) != 0 )
                        {
                            buttons[currentPlayer - 1][temp2].currentBet += handCounter(0, currentPlayer); //add money to spot where bet was placed
                            currentBet += handCounter(0, currentPlayer); //increment current bet counter
                            if(currentPlayer == 1){ //set all the text labels
                                scoreCounter.setText(Integer.toString(defaultNum - currentBet));
                                betCounter.setText(Integer.toString(currentBet));
                                handCounter.setText(Integer.toString(0));
                                buttons[temp][temp2].setIcon(RedChipIcon);
                            }
                            else if(currentPlayer == 2){
                                scoreCounter2.setText(Integer.toString(defaultNum2 - currentBet));
                                betCounter2.setText(Integer.toString(currentBet));
                                handCounter2.setText(Integer.toString(0));
                                buttons[temp][temp2].setIcon(BlackChipIcon);
                            }
                            else if(currentPlayer == 3){
                                scoreCounter3.setText(Integer.toString(defaultNum3 - currentBet));
                                betCounter3.setText(Integer.toString(currentBet));
                                handCounter3.setText(Integer.toString(0));
                                buttons[temp][temp2].setIcon(WhiteChipIcon);
                            }
                            else{
                                scoreCounter4.setText(Integer.toString(defaultNum4 - currentBet));
                                betCounter4.setText(Integer.toString(currentBet));
                                handCounter4.setText(Integer.toString(0));
                                buttons[temp][temp2].setIcon(GreenChipIcon);
                            }
                        }
                    }
                });
                this.add(buttons[i][j]);
        }
        }
        for(int i = 0; i < numPlayers; i++) //these for loops will set bounds for all possible betting spots acting as buttons
            buttons[i][0].setBounds(340, 507, 50, 50);

        int x = 392;
        for(int j = 0; j < numPlayers; j++){
            x = 392;
            for(int i = 1; i < 25; i++)
            {
                buttons[j][i].setBounds(x, 393, 40, 50);
                x+=40;
            }
        }

        x = 392;
        for(int j = 0; j < numPlayers; j++){
            x = 392;
            for(int i = 25; i < 49; i++)
            {
                buttons[j][i].setBounds(x, 450, 40, 45);
                x+=40;
            }
        }

        x = 392;
        for(int j = 0; j < numPlayers; j++){
            x = 392;
            for(int i = 49; i < 73; i++)
            {
                buttons[j][i].setBounds(x, 507, 40, 50);
                x+=40;
            }
        }

        x = 392;
        for(int j = 0; j < numPlayers; j++){
            x = 392;
            for(int i = 73; i < 97; i++)
            {
                buttons[j][i].setBounds(x, 564, 40, 45);
                x+=40;
            }
        }

        x = 392;
        for(int j = 0; j < numPlayers; j++){
            x = 392;
            for(int i = 97; i < 121; i++)
            {
                buttons[j][i].setBounds(x, 621, 40, 50);
                x+=40;
            }
        }

        x = 392;
        for(int j = 0; j < numPlayers; j++){
            x = 392;
            for(int i = 121; i < 145; i++)
            {
                buttons[j][i].setBounds(x, 680, 40, 36);
                x+=40;
            }
        }
        for(int j = 0; j < numPlayers; j++){
            buttons[j][145].setBounds(1375, 358, 80, 115);
            buttons[j][146].setBounds(1375, 473, 80, 115);
            buttons[j][147].setBounds(1375, 588, 80, 115);
            buttons[j][148].setBounds(410, 715, 320, 75);
            buttons[j][149].setBounds(730, 715, 320, 75);
            buttons[j][150].setBounds(1050, 715, 320, 75);
        }

        x = 412;
        for(int j = 0; j < numPlayers; j++){
            x = 412;
            for(int i = 151; i < 157; i++)
            {
                buttons[j][i].setBounds(x, 790, 160, 85);
                x+= 160;
            }
        }


        // POKER CHIPS
        this.setLayout(null);

        fiveChip = new JButton(FiveChipIcon); //button set ups for each poker chip
        fiveChip.setBounds(50,50,200,200);
        fiveChip.setContentAreaFilled(false);
        fiveChip.setBorderPainted(false);
        fiveChip.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(handCounter(0, currentPlayer) <= scoreCounter(0, currentPlayer) - 5)
                {
                    if(currentPlayer == 1) //adding money to hand by clicking on chip
                        handCounter.setText(Integer.toString(handCounter(5, 1)));
                    else if(currentPlayer == 2)
                        handCounter2.setText(Integer.toString(handCounter(5, 2)));
                    else if(currentPlayer == 3)
                        handCounter3.setText(Integer.toString(handCounter(5, 3)));
                    else
                        handCounter4.setText(Integer.toString(handCounter(5, 4)));
                }
            }
        });
        this.add(fiveChip);

        twentyFiveChip = new JButton(TwentyFiveChipIcon);
        twentyFiveChip.setBounds(50,300,200,200);
        twentyFiveChip.setContentAreaFilled(false);
        twentyFiveChip.setBorderPainted(false);
        twentyFiveChip.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(handCounter(0, currentPlayer) <= scoreCounter(0, currentPlayer) - 25)
                {
                    if(currentPlayer == 1)
                        handCounter.setText(Integer.toString(handCounter(25, 1)));
                    else if(currentPlayer == 2)
                        handCounter2.setText(Integer.toString(handCounter(25, 2)));
                    else if(currentPlayer == 3)
                        handCounter3.setText(Integer.toString(handCounter(25, 3)));
                    else
                        handCounter4.setText(Integer.toString(handCounter(25, 4)));
                }
                
            }
        });
        this.add(twentyFiveChip);

        hundredChip = new JButton(HundredChipIcon);
        hundredChip.setBounds(50,550,200,200);
        hundredChip.setContentAreaFilled(false);
        hundredChip.setBorderPainted(false);
        hundredChip.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(handCounter(0, currentPlayer) <= scoreCounter(0, currentPlayer) - 100)
                {
                    if(currentPlayer == 1)
                        handCounter.setText(Integer.toString(handCounter(100, 1)));
                    else if(currentPlayer == 2)
                        handCounter2.setText(Integer.toString(handCounter(100, 2)));
                    else if(currentPlayer == 3)
                        handCounter3.setText(Integer.toString(handCounter(100, 3)));
                    else
                        handCounter4.setText(Integer.toString(handCounter(100, 4)));
                }
            }
        });
        this.add(hundredChip);

        fiveHundredChip = new JButton(FiveHundredChipIcon);
        fiveHundredChip.setBounds(50,800,200,200);
        fiveHundredChip.setContentAreaFilled(false);
        fiveHundredChip.setBorderPainted(false);
        fiveHundredChip.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(handCounter(0, currentPlayer) <= scoreCounter(0, currentPlayer) - 500)
                {
                    if(currentPlayer == 1)
                        handCounter.setText(Integer.toString(handCounter(500, 1)));
                    else if(currentPlayer == 2)
                        handCounter2.setText(Integer.toString(handCounter(500, 2)));
                    else if(currentPlayer == 3)
                        handCounter3.setText(Integer.toString(handCounter(500, 3)));
                    else
                        handCounter4.setText(Integer.toString(handCounter(500, 4)));
                }
            }
        });
        this.add(fiveHundredChip);


        //SPIN BUTTON
        spin = new JButton(spinButton);
        this.add(spin);
        spin.setContentAreaFilled(false);
        spin.setBorderPainted(false);
        gl = new gameListener();
        spin.addActionListener(gl);
        spin.setBounds(1550, 400, 300, 300);

        //PLAYER NUMBER LABEL
        playerNum1 = new JLabel("Player 1");
        playerNum1.setFont(font);
        playerNum1.setForeground(Color.WHITE);
        this.add(playerNum1);
        playerNum1.setBounds(480, 5, 190, 45);


        //SCORE COUNTER LABEL
        scoreCounter = new JLabel(Integer.toString(defaultNum));
        scoreCounter.setFont(font);
        scoreCounter.setForeground(Color.WHITE);
        this.add(scoreCounter);
        scoreCounter.setBounds(640, 50, 390, 45);

        // "Current Payroll: " Label
        scoreCounterPre = new JLabel("Current Payroll: $");
        scoreCounterPre.setFont(font);
        scoreCounterPre.setForeground(Color.RED);
        this.add(scoreCounterPre);
        scoreCounterPre.setBounds(362, 50, 390, 45);

        //Current Bet COUNTER LABEL
        betCounter = new JLabel(Integer.toString(0));
        betCounter.setFont(font);
        betCounter.setForeground(Color.WHITE);
        this.add(betCounter);
        betCounter.setBounds(585, 85, 390, 45);

        // "Current Bet: " Label
        betCounterPre = new JLabel("Current Bet: $");
        betCounterPre.setFont(font);
        betCounterPre.setForeground(Color.RED);
        this.add(betCounterPre);
        betCounterPre.setBounds(362, 85, 390, 45);

        //ChipsInHand Bet COUNTER LABEL
        handCounter = new JLabel(Integer.toString(0));
        handCounter.setFont(font);
        handCounter.setForeground(Color.WHITE);
        this.add(handCounter);
        handCounter.setBounds(620, 120, 390, 45);

        // "Chips in Hand: " Label
        handCounterPre = new JLabel("Chips in Hand: $");
        handCounterPre.setFont(font);
        handCounterPre.setForeground(Color.RED);
        this.add(handCounterPre);
        handCounterPre.setBounds(362, 120, 390, 45);


         //PLAYER NUMBER 2 LABEL
         playerNum2 = new JLabel("Player 2");
         playerNum2.setFont(font);
         playerNum2.setForeground(Color.WHITE);
         if(numPlayers > 1)
            this.add(playerNum2);
         playerNum2.setBounds(930, 5, 190, 45);
 
 
         //SCORE COUNTER 2 LABEL
         scoreCounter2 = new JLabel(Integer.toString(defaultNum2));
         scoreCounter2.setFont(font);
         scoreCounter2.setForeground(Color.WHITE);
         if(numPlayers > 1)
            this.add(scoreCounter2);
         scoreCounter2.setBounds(1090, 50, 390, 45);
 
         // "Current Payroll: " 2 Label
         scoreCounterPre2 = new JLabel("Current Payroll: $");
         scoreCounterPre2.setFont(font);
         scoreCounterPre2.setForeground(Color.RED);
         if(numPlayers > 1)
            this.add(scoreCounterPre2);
         scoreCounterPre2.setBounds(812, 50, 390, 45);
 
         //Current Bet 2 COUNTER LABEL
         betCounter2 = new JLabel(Integer.toString(0));
         betCounter2.setFont(font);
         betCounter2.setForeground(Color.WHITE);
         if(numPlayers > 1)
            this.add(betCounter2);
         betCounter2.setBounds(1035, 85, 390, 45);
 
         // "Current Bet: " 2 Label
         betCounterPre2 = new JLabel("Current Bet: $");
         betCounterPre2.setFont(font);
         betCounterPre2.setForeground(Color.RED);
         if(numPlayers > 1)
            this.add(betCounterPre2);
         betCounterPre2.setBounds(812, 85, 390, 45);
 
         //ChipsInHand Bet 2 COUNTER LABEL
         handCounter2 = new JLabel(Integer.toString(0));
         handCounter2.setFont(font);
         handCounter2.setForeground(Color.WHITE);
         if(numPlayers > 1)
            this.add(handCounter2);
         handCounter2.setBounds(1070, 120, 390, 45);
 
         // "Chips in Hand: " 2 Label
         handCounterPre2 = new JLabel("Chips in Hand: $");
         handCounterPre2.setFont(font);
         handCounterPre2.setForeground(Color.RED);
         if(numPlayers > 1)
            this.add(handCounterPre2);
         handCounterPre2.setBounds(812, 120, 390, 45);


         //PLAYER NUMBER 3 LABEL
        playerNum3 = new JLabel("Player 3");
        playerNum3.setFont(font);
        playerNum3.setForeground(Color.WHITE);
        if(numPlayers > 2)
            this.add(playerNum3);
        playerNum3.setBounds(480, 165, 190, 45);


        //SCORE COUNTER 3 LABEL
        scoreCounter3 = new JLabel(Integer.toString(defaultNum3));
        scoreCounter3.setFont(font);
        scoreCounter3.setForeground(Color.WHITE);
        if(numPlayers > 2)
            this.add(scoreCounter3);
        scoreCounter3.setBounds(640, 210, 390, 45);

        // "Current Payroll: " 3 Label
        scoreCounterPre3 = new JLabel("Current Payroll: $");
        scoreCounterPre3.setFont(font);
        scoreCounterPre3.setForeground(Color.RED);
        if(numPlayers > 2)
            this.add(scoreCounterPre3);
        scoreCounterPre3.setBounds(362, 210, 390, 45);

        //Current Bet 3 COUNTER LABEL
        betCounter3 = new JLabel(Integer.toString(0));
        betCounter3.setFont(font);
        betCounter3.setForeground(Color.WHITE);
        if(numPlayers > 2)
            this.add(betCounter3);
        betCounter3.setBounds(585, 245, 390, 45);

        // "Current Bet: " 3 Label
        betCounterPre3 = new JLabel("Current Bet: $");
        betCounterPre3.setFont(font);
        betCounterPre3.setForeground(Color.RED);
        if(numPlayers > 2)
            this.add(betCounterPre3);
        betCounterPre3.setBounds(362, 245, 390, 45);

        //ChipsInHand Bet 3 COUNTER LABEL
        handCounter3 = new JLabel(Integer.toString(0));
        handCounter3.setFont(font);
        handCounter3.setForeground(Color.WHITE);
        if(numPlayers > 2)
            this.add(handCounter3);
        handCounter3.setBounds(620, 280, 390, 45);

        // "Chips in Hand: " 3 Label
        handCounterPre3 = new JLabel("Chips in Hand: $");
        handCounterPre3.setFont(font);
        handCounterPre3.setForeground(Color.RED);
        if(numPlayers > 2)
            this.add(handCounterPre3);
        handCounterPre3.setBounds(362, 280, 390, 45);


        //PLAYER NUMBER 4 LABEL
         playerNum4 = new JLabel("Player 4");
         playerNum4.setFont(font);
         playerNum4.setForeground(Color.WHITE);
         if(numPlayers > 3)
            this.add(playerNum4);
         playerNum4.setBounds(930, 165, 190, 45);
 
 
         //SCORE COUNTER 4 LABEL
         scoreCounter4 = new JLabel(Integer.toString(defaultNum4));
         scoreCounter4.setFont(font);
         scoreCounter4.setForeground(Color.WHITE);
         if(numPlayers > 3)
            this.add(scoreCounter4);
         scoreCounter4.setBounds(1090, 210, 390, 45);
 
         // "Current Payroll: " 4 Label
         scoreCounterPre4 = new JLabel("Current Payroll: $");
         scoreCounterPre4.setFont(font);
         scoreCounterPre4.setForeground(Color.RED);
         if(numPlayers > 3)
            this.add(scoreCounterPre4);
         scoreCounterPre4.setBounds(812, 210, 390, 45);
 
         //Current Bet 4 COUNTER LABEL
         betCounter4 = new JLabel(Integer.toString(0));
         betCounter4.setFont(font);
         betCounter4.setForeground(Color.WHITE);
         if(numPlayers > 3)
            this.add(betCounter4);
         betCounter4.setBounds(1035, 245, 390, 45);
 
         // "Current Bet: " 4 Label
         betCounterPre4 = new JLabel("Current Bet: $");
         betCounterPre4.setFont(font);
         betCounterPre4.setForeground(Color.RED);
         if(numPlayers > 3)
            this.add(betCounterPre4);
         betCounterPre4.setBounds(812, 245, 390, 45);
 
         //ChipsInHand Bet 4 COUNTER LABEL
         handCounter4 = new JLabel(Integer.toString(0));
         handCounter4.setFont(font);
         handCounter4.setForeground(Color.WHITE);
         if(numPlayers > 3)
            this.add(handCounter4);
         handCounter4.setBounds(1070, 280, 390, 45);
 
         // "Chips in Hand: " 4 Label
         handCounterPre4 = new JLabel("Chips in Hand: $");
         handCounterPre4.setFont(font);
         handCounterPre4.setForeground(Color.RED);
         if(numPlayers > 3)
            this.add(handCounterPre4);
         handCounterPre4.setBounds(812, 280, 390, 45);

        currentTurnArea = new JTextArea("Player 1's Turn!");
        currentTurnArea.setVisible(true);
        currentTurnArea.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        currentTurnArea.setForeground(Color.WHITE);
        currentTurnArea.setBackground(new Color(0,105,0));
        currentTurnArea.setEditable(false);
        this.add(currentTurnArea);
        currentTurnArea.setBounds(1450, 750, 500, 150);

        rotate.setBounds(1378, 8, 350,350);
        this.add(rotate);
    }

    //Get payroll from scoreCounter
    public int scoreCounter(int bet, int PlayerNum){
        if(PlayerNum == 1)
            return Integer.parseInt(scoreCounter.getText()) + bet;
        else if(PlayerNum == 2)
            return Integer.parseInt(scoreCounter2.getText()) + bet;
        else if(PlayerNum == 3)
            return Integer.parseInt(scoreCounter3.getText()) + bet;
        else
            return Integer.parseInt(scoreCounter4.getText()) + bet;
    }

    //Get currentBet from betCounter
    public int betCounter(int bet, int PlayerNum){
        if(PlayerNum == 1)
            return Integer.parseInt(betCounter.getText()) + bet;
        else if(PlayerNum == 2)
            return Integer.parseInt(betCounter2.getText()) + bet;
        else if(PlayerNum == 3)
            return Integer.parseInt(betCounter3.getText()) + bet;
        else
            return Integer.parseInt(betCounter4.getText()) + bet;
    }

    //get chips in hand from handCounter
    public int handCounter(int bet, int PlayerNum){
        if(PlayerNum == 1)
            return Integer.parseInt(handCounter.getText()) + bet;
        else if(PlayerNum == 2)
            return Integer.parseInt(handCounter2.getText()) + bet;
        else if(PlayerNum == 3)
            return Integer.parseInt(handCounter3.getText()) + bet;
        else
            return Integer.parseInt(handCounter4.getText()) + bet;
    }

    public void goToGame(){ //start a game once timer is done
        gl.hideMessage();
        gl.gameStart();
    }

    //draw roulette wheel and table
    @Override
    public void paintComponent(Graphics g)
    {
        //this.setLayout(null);
        super.paintComponent(g);
        setBackground(new Color(0,105,0));
        g.drawImage(RouletteTable, 300, 210, 1185, 780, this);
    }

    public void showWinningNumber(int winningNumber){ //show the winning number on the bottom
        winningNumberArea = new JTextArea("Winning Number: " + Integer.toString(winningNumber));
        winningNumberArea.setVisible(true);
        winningNumberArea.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 80));
        winningNumberArea.setForeground(Color.WHITE);
        winningNumberArea.setBackground(new Color(0,105,0));
        winningNumberArea.setEditable(false);
        this.add(winningNumberArea);
        winningNumberArea.setBounds(500, 900, 800, 150);
    }

    public void hideWinningNumber() //hide the winning number if necessary
    {
        winningNumberArea = new JTextArea("");
        winningNumberArea.setVisible(false);
        winningNumberArea.setBounds(0,0,0,0);
        this.add(winningNumberArea);
    }

    //when spin button is pressed 
    class gameListener implements ActionListener{
        private JTextArea winningMessage = new JTextArea("");
        private JTextArea winningMessage2 = new JTextArea("");
        private JTextArea winningMessage3 = new JTextArea("");
        private JTextArea winningMessage4 = new JTextArea("");
        private Font font3 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        public void winningMessage(){ //blue +MONEYWON signs above each payroll for each turn
                setLayout(null);
                winningMessage = new JTextArea("+" + payout);
                winningMessage.setVisible(true);
                winningMessage.setFont(font3);
                winningMessage.setForeground(Color.CYAN);
                winningMessage.setBackground(new Color(0,105,0));
                winningMessage.setEditable(false);
                add(winningMessage);
                winningMessage.setBounds(640, 25, 100, 25);

                winningMessage2 = new JTextArea("+" + payout2);
                winningMessage2.setVisible(true);
                winningMessage2.setFont(font3);
                winningMessage2.setForeground(Color.CYAN);
                winningMessage2.setBackground(new Color(0,105,0));
                winningMessage2.setEditable(false);
                if(numPlayers > 1)
                    add(winningMessage2);
                winningMessage2.setBounds(1090, 25, 100, 25);

                winningMessage3 = new JTextArea("+" + payout3);
                winningMessage3.setVisible(true);
                winningMessage3.setFont(font3);
                winningMessage3.setForeground(Color.CYAN);
                winningMessage3.setBackground(new Color(0,105,0));
                winningMessage3.setEditable(false);
                if(numPlayers > 2)
                    add(winningMessage3);
                winningMessage3.setBounds(640, 185, 100, 25);

                winningMessage4 = new JTextArea("+" + payout4);
                winningMessage4.setVisible(true);
                winningMessage4.setFont(font3);
                winningMessage4.setForeground(Color.CYAN);
                winningMessage4.setBackground(new Color(0,105,0));
                winningMessage4.setEditable(false);
                if(numPlayers > 3)
                    add(winningMessage4);
                winningMessage4.setBounds(1090, 185, 100, 25);
        }

        public void hideMessage(){//hide the blue tickers above each payroll
            winningMessage = new JTextArea("");
            winningMessage.setVisible(false);
            winningMessage2 = new JTextArea("");
            winningMessage2.setVisible(false);
            winningMessage3 = new JTextArea("");
            winningMessage3.setVisible(false);
            winningMessage4 = new JTextArea("");
            winningMessage4.setVisible(false);
        }

        private JTextArea gameOver; //message for when a game is over in single player mode that forces the user to restart as they have ran out of money
        private Font font2 = new Font(Font.SANS_SERIF, Font.BOLD, 150);
        public void gameOverMessage(){
            if(numPlayers > 1)
                return;
            if(scoreCounter(0, currentPlayer) == 0 && betCounter(0, currentPlayer) == 0)
            {
                setLayout(null);
                gameOver = new JTextArea("GAME OVER");
                gameOver.setVisible(true);
                gameOver.setFont(font2);
                gameOver.setForeground(Color.BLACK);
                gameOver.setBackground(new Color(0,105,0));
                gameOver.setEditable(false);
                add(gameOver);
                gameOver.setBounds(600, 400, 950, 200);
                spin.setEnabled(false);
            }
        }

        public void actionPerformed(ActionEvent e){ //action performed for when the spin button is pressed
            hideMessage();
            hideWinningNumber();
            currentBet = 0;
            if(currentPlayer != numPlayers)
            {
                currentPlayer++;
                currentTurnArea.setText("Player " + currentPlayer + "'s Turn!");
                return;
            }

            rotate.startTimer(); //if last player has gone its time to spin that wheel and play game
        }
        public void gameStart(){ //throw button array to Game class to get payouts and then assign those answers to payouts below
            RouletteGame game = new RouletteGame(numPlayers);
            winningNumber = game.getWinningNumber();
            showWinningNumber(winningNumber);
            buttons = game.setButtons(buttons);

            payout = game.getPayout(buttons, 0);
            payout2 = game.getPayout(buttons, 1);
            payout3 = game.getPayout(buttons, 2);
            payout4 = game.getPayout(buttons, 3);

            scoreCounter.setText(Integer.toString(payout + scoreCounter(0, 1)));
            scoreCounter2.setText(Integer.toString(payout2 + scoreCounter(0, 2)));
            scoreCounter3.setText(Integer.toString(payout3 + scoreCounter(0, 3)));
            scoreCounter4.setText(Integer.toString(payout4 + scoreCounter(0, 4)));
            defaultNum = scoreCounter(0, 1); //reseting all values accumulating to new values and current back and current player turn back to 0 and 1 respectively
            defaultNum2 = scoreCounter(0, 2);
            defaultNum3 = scoreCounter(0, 3);
            defaultNum4 = scoreCounter(0, 4);
            currentBet = 0;
            currentPlayer = 1;
            betCounter.setText(Integer.toString(0));
            betCounter2.setText(Integer.toString(0));
            betCounter3.setText(Integer.toString(0));
            betCounter4.setText(Integer.toString(0));
            winningMessage();
            gameOverMessage();
            for(int j = 0; j < numPlayers; j++){ //clear current bet and payout rate for all buttons
                for(int i = 0; i < buttons[0].length; i++)
                    buttons[j][i].clear();
            }
            currentTurnArea.setText("Player " + currentPlayer + "'s Turn!");
        }
    }
}