package menuandgames;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

import java.awt.*;

public class Settings extends ScreenConfig {
    private int numPlayers = 1;
    private JTextArea area;
    private JTextField file;
    private JFileChooser chooser;
    private JButton set;


    public Settings(){
        setLayout(null);

        // Sets the labels and buttons for choosing the number of players
        JLabel numPlayerLabel = new JLabel("Choose number of Players:");
        numPlayerLabel.setBounds(710, 5, 600, 80);
        numPlayerLabel.setForeground(Color.WHITE);
        numPlayerLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        add(numPlayerLabel);
        
        JLabel maxNum = new JLabel("(Max. 3 for BlackJack)");
        maxNum.setBounds(750, 50, 600, 80);
        maxNum.setForeground(Color.WHITE);
        maxNum.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        add(maxNum);

        JButton[] players = new JButton[4];
        ActionListener numListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPlayers = Integer.parseInt(e.getActionCommand());
            }
        };
        for(int i = 0; i < 4; i++) {
            players[i] = new JButton(Integer.toString(i+1));
            players[i].setBounds(425 + 275*i, 150, 250, 50);
            players[i].addActionListener(numListener);
            add(players[i]);
        }

        // Sets the label and text area for choosing the bankroll
        JLabel bankRollLabel = new JLabel("Enter Bankroll Amount: ");
        bankRollLabel.setBounds(740, 300, 600, 100);
        bankRollLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        bankRollLabel.setForeground(Color.WHITE);
        add(bankRollLabel);

        area = new JTextArea("10000");
        area.setBounds(740, 400, 400, 100);
        area.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        area.setVisible(true);
        add(area);

        // Sets the labels and buttons for choosing a card back
        JLabel cardBackLabel = new JLabel("Choose a card back:");
        cardBackLabel.setBounds(710, 600, 600, 80);
        cardBackLabel.setForeground(Color.WHITE);
        cardBackLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        add(cardBackLabel);

        JLabel select = new JLabel("Or, select your own:");
        select.setBounds(710, 750, 800, 80);
        select.setForeground(Color.WHITE);
        select.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        add(select);

        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String action = e.getActionCommand();

                if(action.equals("Black") || action.equals("Red") || action.equals("Blue")) {
                    Card.setBack("Casino and More/res/cards/backs/" + action + ".png");
                }
                else if(action.equals("Get Image")) {
                    if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        file.setText(chooser.getSelectedFile().getAbsolutePath());
                        set.setActionCommand(file.getText());
                    }
                }
                else if(!action.equals("Set Image")) {
                    Card.setBackFromComp(action);
                }
            }
        };
        JButton[] backs = new JButton[3];
        backs[0] = new JButton("Black");
        backs[1] = new JButton("Red");
        backs[2] = new JButton("Blue");
        for(int i = 0; i < 3; i++) {
            backs[i].setBounds(500 + 300*i, 700, 250, 50);
            backs[i].addActionListener(backListener);
            add(backs[i]);
        }

        // Allows a custom card back;
        JButton choose = new JButton("Get Image");
        choose.setBounds(500, 850, 150, 50);
        choose.addActionListener(backListener);
        add(choose);
        set = new JButton("Set Image");
        set.setBounds(650, 850, 150, 50);
        set.addActionListener(backListener);
        add(set);
        file = new JTextField("");
        file.setBounds(800, 850, 550, 50);
        file.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        file.setEditable(false);
        add(file);
        chooser = new JFileChooser("c:/");
        chooser.setFileFilter(new FileNameExtensionFilter("image files: jpeg, jpg, png", "jpeg", "jpg", "png"));

        setVisible(true);
    }

    public int getPlayerNum(){ //getter function for access outside class
        return numPlayers;
    }

    public int getBankRoll(){ //getter function for access outside class
        return Integer.parseInt(area.getText());
    }
}