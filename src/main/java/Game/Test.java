package Game;

import javax.swing.*;
import java.awt.*;

public class Test{

    GamePanel gp;

    Graphics2D g2;

    KeyHandler keyH;

    private JSlider volumeSlider;


    public Test(GamePanel gp,KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

    }

    public void draw(Graphics2D g2){
        this.g2 = g2;
        System.err.println("Game.Test start");
        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        volumeSlider.setBounds(0,0,100,100);
        volumeSlider.setName("asdasdsad");
        gp.add(volumeSlider);
        volumeSlider.setVisible(true);
    }


    public void update() {
    }
}