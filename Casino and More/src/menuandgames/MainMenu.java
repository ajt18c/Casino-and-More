package menuandgames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel{

private JButton settings;
private JButton howTo;
private JButton blackjack;
private JButton solitaire;
private JButton spit;
private JButton slapjack;
private JButton roulette;
Image background = new ImageIcon("res/MainMenuBackground.jpg").getImage();
Image CasinoAndMoreLogo = new ImageIcon("res/CasinoAndMoreLogo.png").getImage();

@Override
    public void paintComponent(Graphics g){
        g.clearRect(0,0, getWidth(), getHeight());
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(CasinoAndMoreLogo, 600, 50, 720, 300, this);
    }

public MainMenu(){
    //settings button
    Image tempSetting = new ImageIcon("res/SettingsButton.png").getImage();
    Image tempSettingImg = tempSetting.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
    Icon settingsButton = new ImageIcon(tempSettingImg);
    this.setLayout(null);
    settings = new JButton(settingsButton);
    this.add(settings);
    settings.setBounds(25, 25, 50, 50);
    settings.setOpaque(false);
    settings.setContentAreaFilled(false);
    settings.setFocusPainted(false);


    //how to play / information button
    Image tempHowTo = new ImageIcon("res/InformationHowToIcon.jpg").getImage();
    Image tempHowToImg = tempHowTo.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    Icon howToButton = new ImageIcon(tempHowToImg);
    howTo = new JButton(howToButton);
    this.add(howTo);
    howTo.setBounds(85, 25, 50, 50);
    howTo.setOpaque(false);
    howTo.setContentAreaFilled(false);
    howTo.setFocusPainted(false);

    //blackjack logo button
    Image tempBlackjack = new ImageIcon("res/BlackJackMenuLogo.png").getImage();
    Image tempBlackjackImg = tempBlackjack.getScaledInstance(400,175,java.awt.Image.SCALE_SMOOTH);
    Icon blackjackButton = new ImageIcon(tempBlackjackImg);
    blackjack = new JButton(blackjackButton);
    this.add(blackjack);
    blackjack.setBounds(250, 400, 400, 175);
    blackjack.setFocusPainted(false);

    //solitaire logo button
    Image tempSolitaire = new ImageIcon("res/SolitaireMenuLogo.png").getImage();
    Image tempSolitaireImg = tempSolitaire.getScaledInstance(400,175,java.awt.Image.SCALE_SMOOTH);
    Icon solitaireButton = new ImageIcon(tempSolitaireImg);
    solitaire = new JButton(solitaireButton);
    this.add(solitaire);
    solitaire.setBounds(250, 650, 400, 175);
    solitaire.setFocusPainted(false);


    Image tempSpit = new ImageIcon("res/SpitMenuLogo.png").getImage();
    Image tempSpitImg = tempSpit.getScaledInstance(400,175,java.awt.Image.SCALE_SMOOTH);
    Icon SpitButton = new ImageIcon(tempSpitImg);
    spit = new JButton(SpitButton);
    this.add(spit);
    spit.setBounds(750, 400, 400, 175);
    spit.setFocusPainted(false);

    
    Image tempSlapjack = new ImageIcon("res/SlapJackMenuLogo.jpg").getImage();
    Image tempSlapjackImg = tempSlapjack.getScaledInstance(400,175,java.awt.Image.SCALE_SMOOTH);
    Icon SlapJackButton = new ImageIcon(tempSlapjackImg);
    slapjack = new JButton(SlapJackButton);
    this.add(slapjack);
    slapjack.setBounds(750, 650, 400, 175);
    slapjack.setFocusPainted(false);


    Image tempRoulette = new ImageIcon("res/RouletteMenuLogo.png").getImage();
    Image tempRouletteImg = tempRoulette.getScaledInstance(400,150,java.awt.Image.SCALE_SMOOTH);
    Icon RouletteButton = new ImageIcon(tempRouletteImg);
    roulette = new JButton(RouletteButton);
    this.add(roulette);
    roulette.setBounds(1250, 525, 400, 175);
    roulette.setFocusPainted(false);
}

}