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


    //console
    boolean popUP = false;
    boolean popUPB = false;
    String popuPt ="";
    int popWait = 0;





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
        if (gp.config.load(gp.save,"equip1") == -1) {
            slotnr = -1;
        }else {
             slotnr = item[equip[1]][1];
        }

        BufferedImage[] walkImage = null;
        switch (slotnr){
            case -1:
                System.out.println("dasdasdasdasd");
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
    public void drawPopup(Graphics2D g2){

        int x = (int) (gp.screenWidth/2 - gp.screenWidth*0.15);
        int y = (int) (gp.screenHeight * 0.25);
        int wight = (int) (( gp.screenWidth*0.15)*2);
        int high = (int) (gp.screenHeight * 0.08);
            g2.setColor(Color.black);
            g2.fillRect(x,y,wight,high);
            g2.drawRoundRect(x,y,wight,high,10,10);
            g2.setColor(Color.white);
            gp.text.drawTextInBox(g2,popuPt,x,y,wight,high);
    }
    public void drawPopupB(Graphics2D g2){

        int x = (int) (gp.screenWidth/2 - gp.screenWidth*0.35);
        int y = (int) (gp.screenHeight * 0.15);
        int wight = (int) (( gp.screenWidth*0.35)*2);
        int high = (int) (gp.screenHeight * 0.23);
        g2.setColor(Color.black);
        g2.fillRect(x,y,wight,high);
        g2.drawRoundRect(x,y,wight,high,10,10);
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(20F));
        gp.text.drawTextBetweenBox(g2,popuPt, (int) (x + gp.screenWidth * 0.02), (int) (y + gp.screenHeight * 0.04), (int) (wight - gp.screenWidth * 0.02));
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
        //GeschichteHaus
        if(worldy == 996 && worldx >= 940 && worldx <= 996){
            System.out.println("GeschichtenHaus");
            popuPt = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
            popUPB = true;

            worldx = 964; //Spawns
            worldy = 1036; //Spawns
        }

        //Haus Fight1
        if(worldy == 1156 && worldx >= 1252 && worldx <= 1316){
            System.out.println("Haus1");
            if(gp.monsterDB.getTot(0) == 1){
                popuPt = "Du hast das Monster schon besiegt";
                popUP = true;

            }else {
                gp.fight.loadFigh(0,0);
                gp.gameState = gp.fightState;
            }
            worldx = 1280; //Spawns nach dem fight
            worldy = 1260; //Spawns nach dem fight
        }
        //Haus Fight2
        if(worldy == 1796 && worldx >= 2528 && worldx <= 2608){
            System.out.println("Haus2");
            if(gp.monsterDB.getTot(3) == 1){
                popuPt = "Du hast das Monster schon besiegt";
                popUP = true;

            }else {
                gp.fight.loadFigh(0,3);
                gp.gameState = gp.fightState;
            }
            worldx = 2564; //Spawns nach dem fight
            worldy = 1836; //Spawns nach dem fight
        }

        //Erde Fight
        if(worldy >= 2436 && worldy <= 2480&& worldx >= 1710 && worldx <= 1780){
            System.out.println("Erde Loch");
            if(gp.monsterDB.getTot(1) == 1){
                popuPt = "Du hast das Monster schon besiegt";
                popUP = true;
            }else {
                gp.fight.loadFigh(2,1);
                gp.gameState = gp.fightState;
            }
            worldx = 1604; //Spawns nach dem fight
            worldy = 2392; //Spawns nach dem fight
        }

        //Stein Fight
        if(worldy >= 2276 && worldy <= 2336&& worldx >= 2456 && worldx <= 2500){
            System.out.println("Stein Loch");
            if(gp.monsterDB.getTot(4) == 1){
                popuPt = "Du hast das Monster schon besiegt";
                popUP = true;
            }else {
                gp.fight.loadFigh(1,4);
                gp.gameState = gp.fightState;
            }

            worldx = 1768; //Spawns nach dem fight
            worldy = 2552; //Spawns nach dem fight
        }

        //Baum Fight
        if(worldy == 2356 && worldx >= 1012 && worldx <= 1080){
            System.out.println("Baum");
            if(gp.monsterDB.getTot(2) == 1){
                popuPt = "Du hast das Monster schon besiegt";
                popUP = true;
            }else {
                gp.fight.loadFigh(4,2);
                gp.gameState = gp.fightState;
            }
            worldx = 1040; //Spawns nach dem fight
            worldy = 2388; //Spawns nach dem fight
        }

        //END BOSS Fight
        if(worldy == 1236 && worldx >= 2312 && worldx <= 2404 ) {
            System.out.println("Schloss");
            if(gp.monsterDB.getTot(5) == 1){

            }else if(gp.monsterDB.getTot(0) == 1 && gp.monsterDB.getTot(1) == 1 && gp.monsterDB.getTot(2) == 1 && gp.monsterDB.getTot(3) == 1 && gp.monsterDB.getTot(4) == 1 && gp.monsterDB.getTot(5) == 1){
                gp.fight.loadFigh(3,5);
                gp.gameState = gp.fightState;
            }else {
                popuPt = "Du musst erst alle Monster besiegen";
                popUP = true;

            }
            worldx = 2356;
            worldy = 1280;

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
        if(popUP) {
            if(popWait < 250) {
                popWait ++;
                drawPopup(g2);
            }else {
                popWait = 0;
                popUP = false;
            }
        }
        if(popUPB) {
            if(popWait < 250) {
                popWait ++;
                drawPopupB(g2);
            }else {
                popWait = 0;
                popUPB = false;
            }
        }
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
