package menuandgames;

import javax.swing.*;

public class CasinoAndMore extends JFrame{

private final int FRAME_WIDTH = 1920;
private final int FRAME_HEIGHT = 1080;

public CasinoAndMore(){
    //setting up background
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    // To make full screen
    // Add to settings?
    //setExtendedState(MAXIMIZED_BOTH); 
    //setUndecorated(true);
    setLocationRelativeTo(null);
    setTitle("Casino and More");

    add(new MainMenu());
    setResizable(false);
}

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame screen = new CasinoAndMore();
                screen.setVisible(true); //set mainmenu to be visible
            }
        });
    }
}
