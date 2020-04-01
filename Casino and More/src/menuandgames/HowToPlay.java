package menuandgames;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class HowToPlay extends ScreenConfig{

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    public HowToPlay(JTextArea area){
        area.setEditable(false);
        area.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        
        try{
            String str = new String(Files.readAllBytes(Paths.get("Casino and More/res/howtoplay.txt")));
            area.append(str);
        }
        catch(IOException e){}
    }
}