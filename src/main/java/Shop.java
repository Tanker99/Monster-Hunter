

import javax.swing.*;
import java.awt.*;

public class Shop {
    GamePanel gp;
    Graphics2D g2;

    public Shop(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2){
        g2.drawString("SHOP", 100, 100);
    }



}
