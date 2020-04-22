package menuandgames;

import javax.swing.*;
import java.awt.*;

public abstract class ScreenConfig extends JPanel{ //this class allows for a basic background and button display that will be on every JFrame
    
    private Image background = new ImageIcon("Casino and More/res/MainMenuBackground.jpg").getImage();
    //private Image background = new ImageIcon(getClass().getResource("Casino and More/res/MainMenuBackground.jpg")).getImage();

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    public ScreenConfig(){
        
    }
}
