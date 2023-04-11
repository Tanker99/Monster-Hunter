import java.awt.*;
import java.awt.image.BufferedImage;

public class Fight {

    GamePanel gp;

    Graphics2D g2;

    KeyHandler keyH;



    public Fight(GamePanel gp,KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;
        drawcha();
    }

   public void drawcha(){

   }

}
