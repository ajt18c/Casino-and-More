package menuandgames;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;


public class MainMenu extends ScreenConfig{

    private JButton settings;
    private JButton howTo;
    private JButton blackjack;
    private JButton solitaire;
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
        blackjack.setBounds(480, 400, 400, 175);
        blackjack.setFocusPainted(false);
        blackjack.addActionListener(new blackjackListener());

        //solitaire logo button
        Image tempSolitaire = new ImageIcon("Casino and More/res/SolitaireMenuLogo.png").getImage();
        Image tempSolitaireImg = tempSolitaire.getScaledInstance(400,175,java.awt.Image.SCALE_SMOOTH);
        Icon solitaireButton = new ImageIcon(tempSolitaireImg);
        solitaire = new JButton(solitaireButton);
        this.add(solitaire);
        solitaire.setBounds(480, 650, 400, 175);
        solitaire.setFocusPainted(false);
        solitaire.addActionListener(new solitaireListener());

        //roulette logo button
        Image tempRoulette = new ImageIcon("Casino and More/res/RouletteMenuLogo.png").getImage();
        Image tempRouletteImg = tempRoulette.getScaledInstance(400,150,java.awt.Image.SCALE_SMOOTH);
        Icon RouletteButton = new ImageIcon(tempRouletteImg);
        roulette = new JButton(RouletteButton);
        this.add(roulette);
        roulette.setBounds(1050, 525, 400, 175);
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
        textArea.setBackground(new Color(0,105,0));
        textArea.setForeground(Color.WHITE);
        JScrollPane scroll = new JScrollPane(textArea); //gives ability to see entire document by scrolling
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //set a vertical bar at all times
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //never have a horizontal bar
        textArea.setEditable(false); //dont let text be editable
        textArea.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        
        try{
            InputStream in = CasinoAndMore.class.getResourceAsStream("Casino and More/res/howtoplay.txt");
            char[] cbuf = new char[3400];
            InputStreamReader inr = new InputStreamReader(in);
            while(inr.read(cbuf, 0, cbuf.length) != -1){}
            String str = new String(cbuf);
            textArea.append(str);
        }
        catch(IOException e){}
        howToFrame.add(textArea);
        howToFrame.add(scroll);
        //textArea.setCaretPosition(0); //start at the top of the document when clicked on
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

class rouletteListener implements ActionListener {
    JFrame screen = new JFrame("Roulette");

    @Override
    public void actionPerformed(ActionEvent event){
        RoulettePanel roulette = new RoulettePanel(); //add a new a Roulettepanel (JPanel) into the JFrame
        screen.add(roulette);
        screen.setSize(1920,1080); //set default size to 1920,1080
        screen.setVisible(true);
        screen.setResizable(false);
    }
}