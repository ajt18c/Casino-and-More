package menuandgames;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Settings extends ScreenConfig{
    private int numPlayers = 1;
    private JLabel numPlayerLabel;
    private JLabel bankRollLabel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private JTextArea area;


    public Settings(){
        this.setLayout(null);
        button1 = new JButton("1");
        button1.setBounds(425, 150, 250, 50);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               numPlayers = 1;
            }
        });
        button2 = new JButton("2");
        button2.setBounds(700, 150, 250, 50);
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               numPlayers = 2;
            }
        });
        button3 = new JButton("3");
        button3.setBounds(975, 150, 250, 50);
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               numPlayers = 3;
            }
        });
        button4 = new JButton("4");
        button4.setBounds(1250, 150, 250, 50);
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               numPlayers = 4;
            }
        });
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);

        numPlayerLabel = new JLabel("Choose number of Players:");
        numPlayerLabel.setBounds(710, 5, 600, 80);
        numPlayerLabel.setForeground(Color.WHITE);
        numPlayerLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        this.add(numPlayerLabel);
        
        JLabel maxNum = new JLabel("(Max. 3 for BlackJack)");
        maxNum.setBounds(750, 50, 600, 80);
        maxNum.setForeground(Color.WHITE);
        maxNum.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        this.add(maxNum);

        bankRollLabel = new JLabel("Enter Bankroll Amount: ");
        bankRollLabel.setBounds(740, 300, 600, 100);
        bankRollLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        bankRollLabel.setForeground(Color.WHITE);
        this.add(bankRollLabel);

        area = new JTextArea("10000");
        area.setBounds(740, 400, 400, 100);
        area.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        area.setVisible(true);
        this.add(area);

        this.setVisible(true);
    }

    public int getPlayerNum(){
        return numPlayers;
    }

    public int getBankRoll(){
        return Integer.parseInt(area.getText());
    }
}