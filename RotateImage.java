import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract class RotateImage implements ActionListener {
    private Timer timer = new Timer(10, this);
    private long endwheel;
//    timer.schedule(new Timertask(){
//        public abstract void run() {
//            timer.cancel();
//            timer.purge();
//        }
//    }, );

    class RotateImagepanel extends JPanel implements ActionListener{
        Image image;
        int Rotation = 0;
        // Create a constructor method
        public RotateImagepanel(){
            super();
            // Load an image to play with.
            image  = Toolkit.getDefaultToolkit().getImage("RouletteWheel.png");
        }

        public void actionPerformed(ActionEvent e) {
            repaint();
            if(System.currentTimeMillis() == endwheel){
                timer.stop();
            }
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d=(Graphics2D)g;
            g2d.rotate(Math.toRadians(Rotation), 300, 300); // Create a Java2D version of g.
            g.drawImage(image, 200, 200, 200, 200, this);
            // g2d.translate(170, 0); // Translate the center of our coordinates.
            // g2d.rotate(50);  // Rotate the image by 1 radian.
            Rotation += 5;
        }

    }
    public static void main(String arg[]){
        JFrame frame = new JFrame("RotateImage");
        RotateImagepanel panel = new RotateImagepanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.add(panel);
        JButton spinButton = new JButton("Click Me");
        spinButton.setbounds(200, 30, 100, 100);

        // add the listener to the jbutton to handle the "pressed" event
        spinButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // display/center the jdialog when the button is pressed
                timer.start();
                endwheel = System.currentTimeMillis() + 3500;
            }
        });
        frame.add(spinButton);
        frame.setVisible(true);
    }
}

