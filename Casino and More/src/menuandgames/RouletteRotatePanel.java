package menuandgames;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

  public class RouletteRotatePanel extends JPanel implements ActionListener{
      private Timer time = new Timer(10, this) ; //this is used for current jpanel
      private Image wheel = Toolkit.getDefaultToolkit().getImage("Casino and More/res/RouletteWheel.png");
      //private Image wheel = new ImageIcon(getClass().getResource("Casino and More/res/RouletteWheel.png")).getImage();
      private int Rotation = 0;
      private Date startdate;
      private Date enddate = null;
      private RoulettePanel pan;
          public RouletteRotatePanel(RoulettePanel p){
            super();
            this.setSize(350,350);
            this.setBackground(new Color(0,105,0));
            pan = p;
          }
          public void startTimer(){
            time.start();
            startdate = new Date();
            enddate = new Date();
            enddate.setTime(startdate.getTime() + 3000); //spin for 3 seconds
          }


          @Override
          public void actionPerformed(ActionEvent e) {
              Rotation += 5; //rotate by 5 degrees
              repaint();
          }

          public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d=(Graphics2D)g;
            g2d.rotate(Math.toRadians(Rotation), 175, 175);
            g.drawImage(wheel, 0, 0, 350, 350, this);

            if(enddate != null && (new Date().getTime() >= enddate.getTime())){ //when timer is to stop goToGame and get payouts for current bets
                time.stop();
                enddate = null;
                pan.goToGame();
            }
        }
}
