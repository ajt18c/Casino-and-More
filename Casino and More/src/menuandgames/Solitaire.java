package menuandgames;

import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Solitaire extends ScreenConfig implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //private Deck deck = new Deck();
    private Icon icon;
    private JButton pile;
    String oldreport;
    //int change = 25;

    private ArrayList<ArrayList<CardButton>> tableau;
    private Deck deck;
    private ArrayList<CardButton> newpile ;
    private ArrayList<CardButton> flippedpile;
    private ArrayList<CardButton> spade;
    private ArrayList<CardButton> heart;
    private ArrayList<CardButton> diamond;
    private ArrayList<CardButton> club;
    private boolean selected;
    private CardButton temp;


    public Solitaire(){
        setLayout(null);
        flippedpile = new ArrayList<CardButton>(52);
        deck = new Deck();

        spade = new ArrayList<CardButton>(15);
        heart = new ArrayList<CardButton>(15);
        diamond = new ArrayList<CardButton>(15);
        club = new ArrayList<CardButton>(15);

        tableau = new ArrayList<ArrayList<CardButton> >(7);
        selected = false;
        icon = new ImageIcon(Card.getBack().getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH));
        pile = new JButton(icon);
        pile.setSize(100, 150);
        pile.setLocation(50,25);
        pile.addActionListener(this);
        pile.setActionCommand("Pile");
        this.add(pile);
        newpile = new ArrayList<CardButton>(53);
        temp = new CardButton();
        temp.addActionListener(this);
        temp.setActionCommand("flippedpile");
        //temp.setVisible(true);

        //pile = new ArrayList<CardButton>(52);
        for(int i = 0; i < 52; i++){
            newpile.add(new CardButton(deck.draw()));
            //System.out.print(i);
        }

        //System.out.print(deck.getsize());




        ArrayList<CardButton> a1 = new ArrayList<CardButton>(15);
        a1.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        tableau.add(a1);
        // for(int i = 0; i < count ; i ++){
        //     if(i == count -1){
        // a1.get(i).flipcard();
        // a1.get(i).setSize(100,150);
        // a1.get(i).setLocation(x, y);
        // a1.get(i).setActionCommand("00");
        // this.add(a1.get(i));
        //     }
        //     else{

        //     }
        // }
        // count++;

        ArrayList<CardButton> a2 = new ArrayList<CardButton>(15);
        a2.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a2.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        tableau.add(a2);

        ArrayList<CardButton> a3 = new ArrayList<CardButton>(15);
        a3.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a3.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a3.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        tableau.add(a3);

        ArrayList<CardButton> a4 = new ArrayList<CardButton>(15);
        a4.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a4.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a4.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a4.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        tableau.add(a4);

        ArrayList<CardButton> a5 = new ArrayList<CardButton>(15);
        a5.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a5.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a5.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a5.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a5.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        tableau.add(a5);

        ArrayList<CardButton> a6 = new ArrayList<CardButton>(15);
        a6.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a6.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a6.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a6.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a6.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a6.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        tableau.add(a6);

        ArrayList<CardButton> a7 = new ArrayList<CardButton>(15);
        a7.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a7.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a7.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a7.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a7.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        //System.out.print(newpile.size());
        a7.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        a7.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
        tableau.add(a7);

        //int count = 1;
        int x = 1000;
        int y = 170 + (26* (tableau.get(6).size()) );


        for(int i = 6; i >=0 ; i --){

            for(int j = tableau.get(i).size()-1; j >=0 ; j--){

                if(j == tableau.get(i).size()-1){

                    tableau.get(i).get(j).flipcard();
                    tableau.get(i).get(j).setSize(90,130);
                    tableau.get(i).get(j).setLocation(x, y);
                    String action = String.valueOf(i);
                    action = action + String.valueOf(j);
                    tableau.get(i).get(j).addActionListener(this);
                    tableau.get(i).get(j).setActionCommand(action);
                    this.add(tableau.get(i).get(j));
                    y -= 26;

                }
                else if(j == 0){
                    tableau.get(i).get(j).setSize(90,130);
                    tableau.get(i).get(j).setLocation(x, y);
                    String action = String.valueOf(i);
                    action = action + String.valueOf(j);
                    tableau.get(i).get(j).addActionListener(this);
                    tableau.get(i).get(j).setActionCommand(action);
                    this.add(tableau.get(i).get(j));
                    y = 170 + (26* (tableau.get(i).size()-1));
                    x -= 150;
                }

                else{
                    //tableau.get(i).get(j).flipcard();
                    tableau.get(i).get(j).setSize(90,130);
                    tableau.get(i).get(j).setLocation(x, y);
                    String action = String.valueOf(i);
                    action = action + String.valueOf(j);
                    tableau.get(i).get(j).addActionListener(this);
                    tableau.get(i).get(j).setActionCommand(action);
                    this.add(tableau.get(i).get(j));
                    y -= 26;
                }
            }

        }


    }




    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);


        g.drawRect(50, 25, 100, 150);
        g.drawRect(200, 25, 100, 150);
        int x = 450;
        int y = 25;

        for(int i =0; i< 4; i++){
            g.drawRect(x, y, 100, 150);
            x+= 150;
        }


    }



    @Override
    public void actionPerformed(ActionEvent e) {



        String report = e.getActionCommand();

        //System.out.print("/n");
        // System.out.println(report);

        if(report.equals("Pile") ){
            if(flippedpile.size()> 0){
                remove(temp);
                flippedpile.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
                //System.out.print(flippedpile.size());
                temp = new CardButton(flippedpile.get(flippedpile.size()-1).getcard());
                temp.addActionListener(this);
                temp.setActionCommand("flippedpile");
                temp.flipcard();
                temp.setSize(100,150);
                temp.setLocation(200, 25);
                add(temp);
            }
            else{
                flippedpile.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
                //System.out.print(flippedpile.size());
                temp = new CardButton(flippedpile.get(flippedpile.size()-1).getcard());
                temp.addActionListener(this);
                temp.setActionCommand("flippedpile");
                temp.flipcard();
                temp.setSize(90,130);
                temp.setLocation(200, 25);
                add(temp);
            }
            if(newpile.size() == 0){
                remove(pile);
            }

        }

        else if(report.equals("flippedpile") && newpile.size() == 0){
            int si = flippedpile.size();

            for(int i = si; i > 0; i -- ){
                newpile.add(flippedpile.remove(i-1));
            }

            remove(temp);
            icon = new ImageIcon(Card.getBack().getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH));
            pile = new JButton(icon);
            pile.setSize(100, 150);
            pile.setLocation(50,25);
            pile.addActionListener(this);
            pile.setActionCommand("Pile");
            add(pile);
        }
        else{
            selected = !selected;
            String i2 = report.substring(0,1);
            String j2 = report.substring(1,2);

            if(selected == true){
                oldreport = report;
                if(report.equals("flippedpile") && flippedpile.get(flippedpile.size()-1).getcard().getName().equals("Ace")){ //move ace from flipped pile to suit pile
                    if(flippedpile.get(flippedpile.size()-1).getcard().getSuit() == Card.Suit.SPADES){
                        flippedpile.get(flippedpile.size()-1).setLocation(450, 25);
                        flippedpile.get(flippedpile.size()-1).addActionListener(this);
                        flippedpile.get(flippedpile.size()-1).setActionCommand("spade pile");
                        flippedpile.get(flippedpile.size()-1).flipcard();
                        add(flippedpile.get(flippedpile.size()-1));
                        spade.add(flippedpile.remove(flippedpile.size()-1));

                        remove(temp);
                        flippedpile.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
                        //System.out.print(flippedpile.size());
                        temp = new CardButton(flippedpile.get(flippedpile.size()-1).getcard());
                        temp.addActionListener(this);
                        temp.setActionCommand("flippedpile");
                        temp.flipcard();
                        temp.setLocation(200, 25);
                        add(temp);
                    }
                    else if(flippedpile.get(flippedpile.size()-1).getcard().getSuit() == Card.Suit.HEARTS){
                        flippedpile.get(flippedpile.size()-1).setLocation(600, 25);
                        flippedpile.get(flippedpile.size()-1).addActionListener(this);
                        flippedpile.get(flippedpile.size()-1).setActionCommand("heart pile");
                        flippedpile.get(flippedpile.size()-1).flipcard();
                        add(flippedpile.get(flippedpile.size()-1));
                        heart.add(flippedpile.remove(flippedpile.size()-1));

                        remove(temp);
                        flippedpile.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
                        //System.out.print(flippedpile.size());
                        temp = new CardButton(flippedpile.get(flippedpile.size()-1).getcard());
                        temp.addActionListener(this);
                        temp.setActionCommand("flippedpile");
                        temp.flipcard();
                        temp.setLocation(200, 25);
                        add(temp);
                    }
                    else if(flippedpile.get(flippedpile.size()-1).getcard().getSuit() == Card.Suit.DIAMONDS){
                        flippedpile.get(flippedpile.size()-1).setLocation(750, 25);
                        flippedpile.get(flippedpile.size()-1).addActionListener(this);
                        flippedpile.get(flippedpile.size()-1).setActionCommand("diamond pile");
                        flippedpile.get(flippedpile.size()-1).flipcard();
                        add(flippedpile.get(flippedpile.size()-1));
                        diamond.add(flippedpile.remove(flippedpile.size()-1));

                        remove(temp);
                        flippedpile.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
                        //System.out.print(flippedpile.size());
                        temp = new CardButton(flippedpile.get(flippedpile.size()-1).getcard());
                        temp.addActionListener(this);
                        temp.setActionCommand("flippedpile");
                        temp.flipcard();
                        temp.setLocation(200, 25);
                        add(temp);
                    }
                    else{
                        flippedpile.get(flippedpile.size()-1).setLocation(900, 25);
                        flippedpile.get(flippedpile.size()-1).addActionListener(this);
                        flippedpile.get(flippedpile.size()-1).setActionCommand("club pile");
                        flippedpile.get(flippedpile.size()-1).flipcard();
                        add(flippedpile.get(flippedpile.size()-1));
                        club.add(flippedpile.remove(flippedpile.size()-1));

                        remove(temp);
                        flippedpile.add(new CardButton(newpile.remove(newpile.size()-1).getcard()));
                        //System.out.print(flippedpile.size());
                        temp = new CardButton(flippedpile.get(flippedpile.size()-1).getcard());
                        temp.addActionListener(this);
                        temp.setActionCommand("flippedpile");
                        temp.flipcard();
                        temp.setLocation(200, 25);
                        add(temp);
                    }
                    selected = !selected;

                }
                else{ //move ace from row to suitpile
                    int x3 = Integer.valueOf(i2);
                    int x4 = Integer.valueOf(j2);
                    if(tableau.get(x3).get(x4).getcard().getName() == "Ace"&& x4 == tableau.get(x3).size()-1 ){
                        if(tableau.get(x3).get(x4).getcard().getSuit() == Card.Suit.SPADES){
                            tableau.get(x3).get(x4).setLocation(450, 25);
                            tableau.get(x3).get(x4-1).flipcard();
                            spade.add(tableau.get(x3).remove(x4));
                        }
                        else if(tableau.get(x3).get(x4).getcard().getSuit() == Card.Suit.HEARTS){
                            tableau.get(x3).get(x4).setLocation(600, 25);
                            tableau.get(x3).get(x4-1).flipcard();
                            heart.add(tableau.get(x3).remove(x4));
                        }
                        else if(tableau.get(x3).get(x4).getcard().getSuit() == Card.Suit.DIAMONDS){
                            tableau.get(x3).get(x4).setLocation(750, 25);
                            tableau.get(x3).get(x4-1).flipcard();
                            diamond.add(tableau.get(x3).remove(x4));
                        }
                        else{
                            tableau.get(x3).get(x4).setLocation(900, 25);
                            tableau.get(x3).get(x4-1).flipcard();
                            club.add(tableau.get(x3).remove(x4));
                        }
                        selected = !selected;
                    }
                    else if(tableau.get(x3).get(x4).getcard().getName().equals("King")){
                        for(int i =0; i < 7; i++){
                            if(tableau.get(i).size() == 0){
                                if(i==0){
                                    tableau.get(x3).get(x4).setLocation(100, 200);
                                }
                                else if(i ==1){
                                    tableau.get(x3).get(x4).setLocation(250, 200);
                                }
                                else if(i ==2){
                                    tableau.get(x3).get(x4).setLocation(400, 200);
                                }
                                else if(i == 3){
                                    tableau.get(x3).get(x4).setLocation(550, 200);
                                }
                                else if(i == 4){
                                    tableau.get(x3).get(x4).setLocation(700, 200);
                                }
                                else if(i == 5){
                                    tableau.get(x3).get(x4).setLocation(850, 200);
                                }
                                else if(i == 6){
                                    tableau.get(x3).get(x4).setLocation(1000, 170);
                                }

                                if(tableau.get(x3).get(x4-1).facedown == true){
                                    tableau.get(x3).get(x4-1).flipcard();
                                }

                                selected = !selected;
                                break;
                            }
                            else{
                                continue;
                            }
                        }
                    }

                }
            }
            else{

                int x3 = Integer.valueOf(i2);
                int x4 = Integer.valueOf(j2);
                int xcoor = tableau.get(x3).get(x4).getX();
                int ycoor = tableau.get(x3).get(x4).getY();
                if(i2.equals("c") || i2.equals("d") || i2.equals("s") || i2.equals("h")){ //move from row to suit pile
                    String i = oldreport.substring(0,1);
                    String j = oldreport.substring(1,2);
                    int x1 = Integer.valueOf(i);
                    int x2 = Integer.valueOf(j);

                    if(i2.equals("s")){
                        if(tableau.get(x1).get(x2).getcard().getSuit() == Card.Suit.SPADES && tableau.get(x1).get(x2).getcard().getVal() == spade.get(spade.size()-1).getcard().getVal()+1){
                            remove(spade.get(spade.size()-1));
                            tableau.get(x1).get(x2).setLocation(450, 25);
                            tableau.get(x1).get(x2).setActionCommand("spade pile");
                            spade.add(tableau.get(x1).remove(x2));
                        }
                    }
                    else if(i2.equals("c")){
                        if(tableau.get(x1).get(x2).getcard().getSuit() == Card.Suit.CLUBS && tableau.get(x1).get(x2).getcard().getVal() == club.get(club.size()-1).getcard().getVal()+1){
                            remove(club.get(club.size()-1));
                            tableau.get(x1).get(x2).setLocation(900, 25);
                            tableau.get(x1).get(x2).setActionCommand("club pile");
                            club.add(tableau.get(x1).remove(x2));
                        }
                    }
                    else if(i2.equals("d")){
                        if(tableau.get(x1).get(x2).getcard().getSuit() == Card.Suit.DIAMONDS&& tableau.get(x1).get(x2).getcard().getVal() == diamond.get(diamond.size()-1).getcard().getVal()+1){
                            remove(diamond.get(diamond.size()-1));
                            tableau.get(x1).get(x2).setLocation(750, 25);
                            tableau.get(x1).get(x2).setActionCommand("diamond pile");
                            diamond.add(tableau.get(x1).remove(x2));
                        }
                    }
                    else{
                        if(tableau.get(x1).get(x2).getcard().getSuit() == Card.Suit.HEARTS && tableau.get(x1).get(x2).getcard().getVal() == heart.get(heart.size()-1).getcard().getVal()+1){
                            remove(heart.get(heart.size()-1));
                            tableau.get(x1).get(x2).setLocation(600, 25);
                            tableau.get(x1).get(x2).setActionCommand("heart pile");
                            heart.add(tableau.get(x1).remove(x2));
                        }
                    }

                }

                else if(oldreport.equals("flippedpile") && x4 == tableau.get(x3).size()-1 && flippedpile.get(flippedpile.size()-1).getcard().getVal() == tableau.get(x3).get(x4).getcard().getVal()-1 && flippedpile.get(flippedpile.size()-1).getcard().getcolornumber() != tableau.get(x3).get(x4).getcard().getcolornumber()){ //move from flipped pile to row


                    flippedpile.get(flippedpile.size()-1).setLocation(xcoor, ycoor+26);

                    String action = String.valueOf(x3);
                    action = action + String.valueOf(x4+1);

                    flippedpile.get(flippedpile.size()-1).addActionListener(this);
                    flippedpile.get(flippedpile.size()-1).setActionCommand(action);

                    tableau.get(x3).add(flippedpile.remove(flippedpile.size()-1));
                    tableau.get(x3).get(x4+1).flipcard();
                    add(tableau.get(x3).get(x4+1));

                    remove(temp);

                    temp = new CardButton(flippedpile.get(flippedpile.size()-1).getcard());
                    temp.addActionListener(this);
                    temp.setActionCommand("flippedpile");
                    temp.flipcard();
                    temp.setLocation(200, 25);

                    add(temp);
                }
                else{                   //move card around board
                    String i = oldreport.substring(0,1);
                    String j = oldreport.substring(1,2);
                    int x1 = Integer.valueOf(i);
                    int x2 = Integer.valueOf(j);
                    //int x3 = Integer.valueOf(i2);
                    //int x4 = Integer.valueOf(j2);


                    if(movepossible(x1, x2, x3, x4) && x4 == tableau.get(x3).size()-1){
                        //int xc;
                        int yc = ycoor+26;

                        String action = String.valueOf(x3);


                        if(x2 < tableau.get(x1).size()-1){
                            for(int a = x2; a < tableau.get(x1).size(); a++){
                                action = action + String.valueOf(x4++);
                                tableau.get(x1).get(a).setActionCommand(action);
                                //remove(tableau.get(x1).get(a));
                                tableau.get(x1).get(a).setLocation(xcoor, yc);
                                //add(tableau.get(x1).get(a));
                                tableau.get(x3).add(tableau.get(x1).remove(a));
                                yc +=26;
                            }
                        }

                        else{
                            //remove(tableau.get(x1).get(x2));
                            //remove(tableau.get(x3).get(x4));
                            action = action + String.valueOf(x4+1);
                            tableau.get(x1).get(x2).setActionCommand(action);
                            CardButton temp2 = new CardButton(tableau.get(x1).get(x2).getcard());
                            temp2.setLocation(xcoor,ycoor);
                            temp2.setSize(90, 140);
                            temp2.addActionListener(this);
                            temp2.setActionCommand(tableau.get(x3).get(x4).getActionCommand());
                            add(temp2);
                            //remove(tableau.get(x1).get(x2));
                            tableau.get(x1).get(x2).setLocation(xcoor, yc);

                            //add(tableau.get(x1).get(x2));
                            //add(tableau.get(x3).get(x4));
                            //tableau.get(x3).get(x4).flipcard();
                            //add(tableau.get(x1).get(x2));
                            tableau.get(x3).add(tableau.get(x1).remove(x2));
                        }

                        if(tableau.get(x1).get(x2-1).facedown == true){
                            tableau.get(x1).get(x2-1).flipcard();
                        }

                    }

                }


            }
        }



        repaint();
    }

    public boolean movepossible(int a, int b, int c, int d){

        if(tableau.get(a).get(b).getcard().getVal() == tableau.get(c).get(d).getcard().getVal()-1){
            if(tableau.get(a).get(b).getcard().getcolornumber() ==1 && tableau.get(c).get(d).getcard().getcolornumber()==2){
                return true;
            }
            else if(tableau.get(a).get(b).getcard().getcolornumber() ==2 && tableau.get(c).get(d).getcard().getcolornumber()==1){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }



}

class CardButton extends JButton {
    private Card card;

    // private Image img;
    // public ImageIcon icon;
    public boolean facedown = true;
    String ActionCommand = new String();
    Icon cardback;
    Icon face;
    public CardButton(Card card) {
        super();
        this.card = card;
        cardback = new ImageIcon(Card.getBack().getScaledInstance(90, 130, java.awt.Image.SCALE_SMOOTH));
        face = new ImageIcon(card.getImg().getScaledInstance(90, 130, java.awt.Image.SCALE_SMOOTH));
        this.setIcon(cardback);
        this.setSize(90, 130);
    }
    public CardButton(){

    }

    public Card getcard(){
        return this.card;
    }

    // // public void setActionCommand(String str){
    // //     ActionCommand = str;
    // // }

    // public String getActionCommand(){
    //     return ActionCommand;
    // }

    public void flipcard(){
        if(this.getIcon()== cardback){
            this.setIcon(face);
            facedown = false;
        }
        else{
            this.setIcon(cardback);
            facedown = true;
        }

    }
}