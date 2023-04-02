

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    public int item[][] = new int[8][2];
    //[8] == slot
    // [][0] == DB
    // [][1] == item


    public int equip[] = new int[4];
    public boolean equipb[] = new boolean[4];
    // [] == slot





    public Player(GamePanel gp, KeyHandler keyH){

        equip[0] = 7;
        equipb[0] = true;
        equip[1] = -1;
        equipb[1] = false;
        equip[2] = 2;
        equipb[2] = true;
        equip[3] = -1;
        equipb[3] = false;
        /*
        item[0][0] = 1;
        item[0][1] = 1;

        item[2][0] = 2;
        item[2][1] = 4;

        item[4][0] = 3;
        item[4][1] = 1;

        item[6][0] = 2;
        item[6][1] = 1;

        item[7][0] = 2;
        item[7][1] = 4;


         */
        this.gp = gp;
        this.keyH = keyH;
        Values();
        getImage();

    }
    public void Values(){
         x = gp.config.load(1,"dsadasd");
         y = 100;
         speed = 4;

        ImageDirection = "still";

    }

    public void getImage(){

        try{
            up =  ImageIO.read(Player.class.getResource("/player/playerb.png"));
            down =  ImageIO.read(Player.class.getResource("/player/playercc.png"));
            left1 =  ImageIO.read(Player.class.getResource("/player/playerl1.png"));
            left2 =  ImageIO.read(Player.class.getResource("/player/playerl2.png"));
            right1 =  ImageIO.read(Player.class.getResource("/player/playerr1.png"));
            right2 =  ImageIO.read(Player.class.getResource("/player/playerr2.png"));
            System.out.println("test");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Image Error");
        }


    }
    public void update (){

        if((keyH.up | keyH.down | keyH.left | keyH.right )== true){
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
            timer ++;
            if (timer >10 ){
                if (animation == 1){
                    animation = 2;
                }else if (animation == 2) {
                    animation = 1;
                }
                timer = 0;
            }
            System.out.println("Timer: "+ timer + "Animation: " +animation);
        }
    }



    public void draw(Graphics2D g2){
        BufferedImage image = null;

        switch (ImageDirection){
            case "up":
                image = up;
                break;
            case "down":
                image = down;
                break;
            case "left":
                if(animation == 1){
                    image = left2;

                }if(animation == 2){
                    image = left1;
                }
                break;
            case "right":
                if(animation     == 1){
                    image = right2;
                }if(animation == 2){
                    image = right1;
                }
                break;
            case "still":
                image = still;
                break;

        }


       g2.drawImage(image, x,y ,gp.titleSize,gp.titleSize,null);
    }
}
