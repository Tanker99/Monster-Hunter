package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenx;
    public final int screeny;
    public int item[][] = new int[8][2];
    //[8] == slot
    // [][0] == DB
    // [][1] == item


    public int equip[] = new int[4];
    // [] == slot





    public Player(GamePanel gp, KeyHandler keyH){
        //equip[1]= -1;
        this.gp = gp;
        this.keyH = keyH;
        screenx = gp.screenWidth/2 - (gp.tileSize/2);
        screeny = gp.screenHeight/2- (gp.tileSize/2);
        hitbox = new Rectangle(24,44,32,32);
        Values();
        getImage();


    }
    public void Values(){
         worldx = gp.tileSize*18;
         worldy = gp.tileSize*16;
         speed = 4;

        ImageDirection = "still";

    }

    public void getImage(){
        int slotnr;
        if (equip[1] == -1) {
            slotnr = -1;
        }else {
             slotnr = item[equip[1]][1];
        }

        BufferedImage[] walkImage = null;
        switch (slotnr){
            case -1:
                walkImage = gp.image.wdBild;
                break;
            case 0:
                walkImage = gp.image.wiBild;
                break;
            case 1:
                walkImage = gp.image.wgBild;
                break;
            case 2:
                walkImage = gp.image.wlBild;
                break;
            case 3:
                walkImage = gp.image.wdiBild;
                break;
            case 4:
                walkImage = gp.image.wjBild;
                break;
            case 5:
                walkImage = gp.image.wuBild;
                break;


        }
        System.err.println(slotnr);
            up1 =  walkImage[0];
            up2 =  walkImage[1];
            down1 =  walkImage[2];
            down2 =  walkImage[3];
            left1 =  walkImage[4];
            left2 =  walkImage[5];
            right1 =  walkImage[6];
            right2 =  walkImage[7];
            System.out.println("test");



        /*

        try{
            down1 =  ImageIO.read(Player.class.getResource("/player/default/playerc1.png"));
            down2 =  ImageIO.read(Player.class.getResource("/player/default/playerc2.png"));
            up1 =  ImageIO.read(Player.class.getResource("/player/default/playerb1.png"));
            up2 =  ImageIO.read(Player.class.getResource("/player/default/playerb2.png"));
            left1 =  ImageIO.read(Player.class.getResource("/player/default/playerl1.png"));
            left2 =  ImageIO.read(Player.class.getResource("/player/default/playerl2.png"));
            right1 =  ImageIO.read(Player.class.getResource("/player/default/playerr1.png"));
            right2 =  ImageIO.read(Player.class.getResource("/player/default/playerr2.png"));
            System.out.println("test");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Game.Image Error");
        }
        */


    }
    public void update (){
        //SHOP
        if( worldy >= 1232 && worldy <= 1280 && worldx == 1016 ){
            System.out.println("Shop enter");
            worldy = 1260;
            worldx = gp.tileSize * 14;
            gp.shopEntry = true;
            gp.gameState = gp.shopState;
        }

        //Haus Fight
        if(worldy == 1156 && worldx >= 1252 && worldx <= 1316){
            System.out.println("Haus1");
            if(gp.monsterDB.getTot(0) == 1){

            }else {
                gp.fight.loadFigh(0,0);
                gp.gameState = gp.fightState;
            }
        }

        //Erde Fight
        if(worldy >= 2436 && worldy <= 2480&& worldx >= 1710 && worldx <= 1780){
            System.out.println("Erde Loch");
            //worldx = 1604; //Spawns nach dem fight
            //worldy = 2392; //Spawns nach dem fight
        }

        //Stein Fight
        if(worldy >= 2276 && worldy <= 2336&& worldx >= 2456 && worldx <= 2500){
            System.out.println("Stein Loch");
            //worldx = 2400; //Spawns nach dem fight
            //worldy = 2376; //Spawns nach dem fight
        }

        //Baum Fight
        if(worldy == 2356 && worldx >= 1012 && worldx <= 1080){
            System.out.println("Baum");
            //worldx = 1196; //Spawns nach dem fight
            //worldy = 2388; //Spawns nach dem fight
        }

        //END BOSS Fight
        if(worldy == 1236 && worldx >= 2312 && worldx <= 2404 ) {
            System.out.println("Schloss");
            //if()
            gp.gameState = gp.fightState;
        }

        if((keyH.up | keyH.down | keyH.left | keyH.right )== true){
            if(keyH.up == true){
                ImageDirection = "up";

            }else if(keyH.down == true){
                ImageDirection = "down";

            }else if(keyH.left == true){
                ImageDirection = "left";

            }else if(keyH.right == true){
                ImageDirection = "right" ;
            }

            collisionan = false;
            gp.CCheck.checker(this);

            if(collisionan == false){
                switch (ImageDirection){
                    case "up":
                        worldy -= speed;
                        break;

                    case "down":
                        worldy += speed;
                        break;

                    case "left":
                        worldx -= speed;
                        break;

                    case "right":
                        worldx += speed;
                        break;
                }
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
            System.out.println("X-Achse: "+ worldx/ gp.tileSize + "    Y-Achse: " +worldy/gp.tileSize+ "    |      X-Achsereal: "+ worldx + "    Y-Achsereal: " +worldy);
            //System.out.println("Timer: "+ timer + "Animation: " +animation);
        }
    }



    public void draw(Graphics2D g2){
        BufferedImage image = null;

        switch (ImageDirection){
            case "up":
                if(animation == 1) {
                    image = up2;
                }if(animation == 2) {
                image = up1;
            }
                break;
            case "down":
                if(animation == 1) {
                    image = down2;
                }if(animation == 2) {
                image = down1;
                }
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


       g2.drawImage(image, screenx, screeny,gp.tileSize,gp.tileSize,null);
    }
    public boolean goldcheck(int trygold){
        int temp = gold - trygold;
        if(temp >= 0){
            gold = gold- trygold;
            return true;
        }else {
            return false;
        }
    }
}
