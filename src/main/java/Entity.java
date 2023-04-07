import java.awt.image.BufferedImage;

public class Entity {

    public int leben;
    public int defense;
    public int gold;
    public int x,y;
    public int speed;

    
    public BufferedImage up,down,left1,left2,right1,right2,still;
    public String ImageDirection;
    public int timer = 0; //1 bis 2
    public int animation = 1; // 1 oder 2

}
