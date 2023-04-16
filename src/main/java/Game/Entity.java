package Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int leben;
    public int defense;
    public int kraft;
    public int gold;
    public int x,y;
    public int speed;
    public int worldx, worldy;
    //public Rectangle hitbox;
    //public boolean collitionan = false;

    
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2,still;
    public String ImageDirection;
    public int timer = 0; //1 bis 2
    public int animation = 1; // 1 oder 2

}
