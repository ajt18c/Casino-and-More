package menuandgames;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class MainMenu extends ScreenConfig{

    private JButton settings;
    private JButton howTo;
    private JButton blackjack;
    private JButton solitaire;
    //private JButton spit;
    //private JButton slapjack;
    private JButton roulette;

    Image CasinoAndMoreLogo = new ImageIcon("Casino and More/res/CasinoAndMoreLogo.png").getImage();

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(CasinoAndMoreLogo, 600, 50, 720, 300, this); //add the logo to the mainmenu
    }


    public MainMenu(){
        //settings button
        Image tempSetting = new ImageIcon("Casino and More/res/SettingsButton.png").getImage();
        Image tempSettingImg = tempSetting.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
        Icon settingsButton = new ImageIcon(tempSettingImg);
        this.setLayout(null);
        settings = new JButton(settingsButton);
        this.add(settings);
        settings.setBounds(25, 25, 50, 50);
        settings.setOpaque(false);
        settings.setContentAreaFilled(false);
        settings.setFocusPainted(false);
        settings.addActionListener(new settingsListener());

        //how to play / information button
        Image tempHowTo = new ImageIcon("Casino and More/res/InformationHowToIcon.jpg").getImage();
        Image tempHowToImg = tempHowTo.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        Icon howToButton = new ImageIcon(tempHowToImg);
        howTo = new JButton(howToButton);
        this.add(howTo);
        howTo.setBounds(85, 25, 50, 50);
        howTo.setOpaque(false);
        howTo.setContentAreaFilled(false);
        howTo.setFocusPainted(false);
        howTo.addActionListener(new howToListener());

        //blackjack logo button
        Image tempBlackjack = new ImageIcon("Casino and More/res/BlackJackMenuLogo.png").getImage();
        Image tempBlackjackImg = tempBlackjack.getScaledInstance(400,175,java.awt.Image.SCALE_SMOOTH);
        Icon blackjackButton = new ImageIcon(tempBlackjackImg);
        blackjack = new JButton(blackjackButton);
        this.add(blackjack);
        blackjack.setBounds(280, 400, 400, 175);
        blackjack.setFocusPainted(false);
        blackjack.addActionListener(new blackjackListener());

        //solitaire logo button
        Image tempSolitaire = new ImageIcon("Casino and More/res/SolitaireMenuLogo.png").getImage();
        Image tempSolitaireImg = tempSolitaire.getScaledInstance(400,175,java.awt.Image.SCALE_SMOOTH);
        Icon solitaireButton = new ImageIcon(tempSolitaireImg);
        solitaire = new JButton(solitaireButton);
        this.add(solitaire);
        solitaire.setBounds(280, 650, 400, 175);
        solitaire.setFocusPainted(false);
        solitaire.addActionListener(new solitaireListener());

        
        //spit logo button
        /*
        Image tempSpit = new ImageIcon("Casino and More/res/SpitMenuLogo.png").getImage();
        Image tempSpitImg = tempSpit.getScaledInstance(400,175,java.awt.Image.SCALE_SMOOTH);
        Icon SpitButton = new ImageIcon(tempSpitImg);
        spit = new JButton(SpitButton);
        this.add(spit);
        spit.setBounds(780, 400, 400, 175);
        spit.setFocusPainted(false);
        spit.addActionListener(new spitListener());
        */


        //slapjack logo button
        /*
        Image tempSlapjack = new ImageIcon("Casino and More/res/SlapJackMenuLogo.jpg").getImage();
        Image tempSlapjackImg = tempSlapjack.getScaledInstance(400,175,java.awt.Image.SCALE_SMOOTH);
        Icon SlapJackButton = new ImageIcon(tempSlapjackImg);
        slapjack = new JButton(SlapJackButton);
        this.add(slapjack);
        slapjack.setBounds(780, 650, 400, 175);
        slapjack.setFocusPainted(false);
        slapjack.addActionListener(new slapjackListener());
        */

        //roulette logo button
        Image tempRoulette = new ImageIcon("Casino and More/res/RouletteMenuLogo.png").getImage();
        Image tempRouletteImg = tempRoulette.getScaledInstance(400,150,java.awt.Image.SCALE_SMOOTH);
        Icon RouletteButton = new ImageIcon(tempRouletteImg);
        roulette = new JButton(RouletteButton);
        this.add(roulette);
        roulette.setBounds(1250, 525, 400, 175);
        roulette.setFocusPainted(false);
        roulette.addActionListener(new rouletteListener());
    }
}

class settingsListener implements ActionListener {
    JFrame settingsFrame = new JFrame();
    
    @Override
    public void actionPerformed(ActionEvent event){ //go to new JFrame for button clicked for each actionlistener
        settingsFrame.setSize(1920,1080);
        settingsFrame.setVisible(true);
        settingsFrame.setResizable(false);
        Settings settings = new Settings();
        settingsFrame.add(settings);
    }
}

class howToListener implements ActionListener {
    JFrame howToFrame = new JFrame();

    @Override
    public void actionPerformed(ActionEvent event){
        howToFrame.setSize(1920,1080);
        howToFrame.setVisible(true);
        howToFrame.setResizable(false);

        JTextArea textArea = new JTextArea(); //actual text box area for text to display
        JScrollPane scroll = new JScrollPane(textArea); //gives ability to see entire document by scrolling
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //set a vertical bar at all times
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //never have a horizontal bar
        howToFrame.add(new HowToPlay(textArea));
        howToFrame.add(scroll);
        textArea.setCaretPosition(0); //start at the top of the document when clicked on
    }
}

class blackjackListener implements ActionListener {
    JFrame blackjackFrame = new JFrame();

    @Override
    public void actionPerformed(ActionEvent event){
        blackjackFrame.setSize(1920,1080);
        blackjackFrame.setVisible(true);
        blackjackFrame.setResizable(false);
        BlackJack blackjack = new BlackJack();
        blackjackFrame.add(blackjack);
    }
}
/*
class spitListener implements ActionListener {
    JFrame spitFrame = new JFrame();

    @Override
    public void actionPerformed(ActionEvent event){
        spitFrame.setSize(1920,1080);
        spitFrame.setVisible(true);
        spitFrame.setResizable(false);
        Spit spit = new Spit();
        spitFrame.add(spit);
    }
}
*/
class solitaireListener implements ActionListener {
    JFrame solitaireFrame = new JFrame();

    @Override
    public void actionPerformed(ActionEvent event){
        solitaireFrame.setSize(1920,1080);
        solitaireFrame.setVisible(true);
        solitaireFrame.setResizable(false);
        Solitaire solitaire = new Solitaire();
        solitaireFrame.add(solitaire);
    }
}
/*
class slapjackListener implements ActionListener {
    JFrame slapjackFrame = new JFrame();

    @Override
    public void actionPerformed(ActionEvent event){
        slapjackFrame.setSize(1920,1080);
        slapjackFrame.setVisible(true);
        slapjackFrame.setResizable(false);
        SlapJack slapjack = new SlapJack();
        slapjackFrame.add(slapjack);
    }
}
*/
class rouletteListener implements ActionListener {
    JFrame screen = new JFrame("Roulette");

    @Override
    public void actionPerformed(ActionEvent event){
        screen.setSize(1200,800); //set default size to 1200,800
        screen.setVisible(true);
        screen.setResizable(false);
        Roulette roulette = new Roulette(); //add a new a Roulettepanel (JPanel) into the JFrame
        screen.add(roulette);
    }
}