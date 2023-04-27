import Game.GamePanel;

import javax.swing.*;

public class Main {

    public static JFrame window;

    public static void main(String[] args) {

        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); //kann nicht größeer oder kleiner gezogen werden
        window.setTitle("Game");
        ImageIcon img = new ImageIcon("src/main/resources/player/playercc.png");
        window.setIconImage(img.getImage());

        window.setLocationRelativeTo(null); //Fenster ist in der Mitte

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.setup();
        gamePanel.startThread();
    }
}
