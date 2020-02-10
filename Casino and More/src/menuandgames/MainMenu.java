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

@Override
    public void paintComponent(Graphics g){
        g.clearRect(0,0, getWidth(), getHeight());
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
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
    Image tempHowToImg = tempHowTo.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
    Icon howToButton = new ImageIcon(tempHowToImg);

    howTo = new JButton(howToButton);
    this.add(howTo);
    howTo.setBounds(250, 250, 50, 50);
    howTo.setOpaque(false);
    howTo.setContentAreaFilled(false);
    howTo.setFocusPainted(false);



    blackjack = new JButton("");
    this.add(blackjack);
    blackjack.setBounds(50, 50, 50, 50);

    solitaire = new JButton("");
    this.add(solitaire);
    solitaire.setBounds(50, 50, 50, 50);

    spit = new JButton("");
    this.add(spit);
    spit.setBounds(50, 50, 50, 50);

    slapjack = new JButton("");
    this.add(slapjack);
    slapjack.setBounds(50, 50, 50, 50);

    roulette = new JButton("");
    this.add(roulette);
    roulette.setBounds(50, 50, 50, 50);
}

}