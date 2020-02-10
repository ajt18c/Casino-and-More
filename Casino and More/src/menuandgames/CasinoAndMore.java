package menuandgames;

import javax.swing.*;

public class CasinoAndMore extends JFrame{

private final int FRAME_WIDTH = 1920;
private final int FRAME_HEIGHT = 1080;

public CasinoAndMore(){
    //setting up background
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setLocationRelativeTo(null);
    setTitle("Casino and More");

    add(new MainMenu());

    setResizable(false);
}

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame menu = new CasinoAndMore();
                menu.setVisible(true);
            }
        });
    }
}
