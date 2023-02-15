

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;




    public Player(GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;
        Values();
        getImage();

    }
    public void Values(){
         x = 100;
         y = 100;
         speed = 4;

        ImageDirection = "still";

    }

    public void getImage(){

        try{
            up =  ImageIO.read(Player.class.getResource("figur.png"));
            down =  ImageIO.read(Player.class.getResource("figur.png"));
            left =  ImageIO.read(Player.class.getResource("figur.png"));
            right =  ImageIO.read(Player.class.getResource("figur.png"));
            still =  ImageIO.read(Player.class.getResource("figur.png"));
            System.out.println("test");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Image Error");
        }


    }
    public void update (){
        if(keyH.up == true){
            y -= speed;
            ImageDirection = "up";
        }else if(keyH.down == true){
            y += speed;
            ImageDirection = "down";
        }else if(keyH.left == true){
            x -= speed;
            ImageDirection = "left";
        }else if(keyH.right == true){
            x += speed;
            ImageDirection = "right" ;
        }
    }
    public void draw(Graphics2D g2){

       // g2.setColor(Color.blue);
       // g2.fillRect(x, y, gp.titleSize, gp.titleSize);

        BufferedImage image = null;

        switch (ImageDirection){
            case "up":
                image = up;
                break;
            case "down":
                image = down;
                break;
            case "left":
                image = left;
                break;
            case "right":
                image = right;
                break;
            case "still":
                image = still;
                break;

        }


       g2.drawImage(image, x,y ,gp.titleSize,gp.titleSize,null);
    }
}
