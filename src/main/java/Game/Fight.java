package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Fight {

    //Standart
    GamePanel gp;
    Graphics2D g2;

    //setup
    boolean setup = true;
    BufferedImage background;

    //Level detail
    String console = "";
    int monster;
    int monsterlive;
    int monsterattack;

    //ANIMATION

    BufferedImage[] pWalkBild;
    int timer = 0; //1 bis 2
    int animation = 1; // 1 oder 2
    String direction = "";

    //Fight
    boolean back = false;
    int playerX;
    int monsterX;
    boolean fight = false;
    boolean first = false;
    int playerWalk;
    int playerWalkBack;
    int monsterWalk;
    int monsterWalkBack;
    boolean playerAllow;
    boolean monsterAllow;
    boolean mosnterAbzug;
    boolean playerAbzug;
    int winner;



    private JPanel slot[] = new JPanel[3];

    public Fight(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        //Draw Background
        drawBackground();

        drawConsole();
        loadPlayerImage();

        if(winner > 0){
            first = false;
            if(winner == 1 && monster == 5){
                gp.gameState = gp.winnerState;

            }else
            if( winner == 1){
                console = "Du hast Gewonnen der Shop wurde für dich erneuert";
                gp.shop.newShop = true;
                gp.monsterDB.mtot[monster] = 1;
                drawBackButton();
            }else if(winner == 2){
                gp.gameState = gp.gameOverState;
                console = "Du hast Verloren";
            }

        }else {
            back = false;
            //Draw Player
            drawcharakter();

            //drawMonster
            drawmonster();



            //DrawButton
            if (!(fight)) {
                resetFightAnimation();
                drawFightButton();
                if (!first) {
                    drawBackButton();
                }
                drawItems();
            }
        }


        //Kampf
        if (fight) {
            first = true;
            kampf();
        }
    }

    public void update() {

    }

    public void loadFigh(int tbackground,int tmonster) {
        resetFightAnimation();
        fight = false;
        winner = 0;
        playerX = (int) (gp.screenWidth * 0.05);
        monsterX = (int) (gp.screenWidth * 0.8);

        console = "";
        if(tmonster == -1){
            monster = (int) (Math.random() * gp.monsterDB.mAnzahl);
        }else {
            monster = tmonster;
        }
        background = gp.image.hFBild[tbackground];

        if(tmonster == 5){
            gp.stopLoopSound();
            gp.playLoopSound(1);
        }else {
            gp.stopLoopSound();
            gp.playLoopSound(2);
        }



        monsterlive = gp.monsterDB.getHealth(monster);
        monsterattack = gp.monsterDB.getAttack(monster);
        setup = false;
    }

    public void drawcharakter() {
        // int pX= (int) (gp.screenWidth*0.05);
        int pY = (int) (gp.screenHeight * 0.72);
        int pWidth = (int) (gp.screenWidth * 0.15);
        int pHight = (int) (gp.screenHeight * 0.22);

        // g2.drawRect(playerX, pY, pWidth, pHight);
        BufferedImage drawImage = null;


        switch (direction) {
            case "vor":
                if (animation == 1) {
                    drawImage = pWalkBild[6];

                }
                if (animation == 2) {
                    drawImage = pWalkBild[7];
                }
                break;
            case "back":
                if (animation == 1) {
                    drawImage = pWalkBild[4];
                }
                if (animation == 2) {
                    drawImage = pWalkBild[5];
                }
                break;
            case "":
                drawImage = pWalkBild[2];//gp.image.iRBild[gp.player.item[gp.player.equip[1]][1]];
                break;
        }
        g2.drawImage(drawImage,playerX,pY,pWidth,pHight,null);
        //g2.drawImage(pWalkBild, playerX, pY, pWidth, pHight, null);
        /*
        if (gp.player.equip[1] != -1) {
            g2.drawImage(gp.image.iRBild[gp.player.item[gp.player.equip[1]][1]], playerX, pY, pWidth, pHight, null);
        } else {
            g2.drawImage(gp.image.iRDefault, playerX, pY, pWidth, pHight, null);
        }

         */

        //drawState

        int sX = (int) (gp.screenWidth * 0.05);
        int sY = (int) (gp.screenHeight * 0.4);
        int swight = (int) (gp.screenWidth * 0.15);
        int shight = (int) (gp.screenHeight * 0.1);

         g2.drawRect(sX,sY,swight,shight);
        g2.setColor(Color.white);
         g2.fillRect(sX,sY,swight,shight);
        g2.setColor(Color.black);

        String leben = String.valueOf(gp.player.leben);
        String attack = String.valueOf(gp.player.attack);
        String defense = String.valueOf(gp.player.defense);

        gp.text.draw3StringsInBox(g2, "Leben : " + leben, "Angriff : " + attack, "Defense : " + defense, sX, sY, swight, shight);

    }
    public void drawmonster() {
        //int mX = (int) (gp.screenWidth * 0.8);
        int mY = (int) (gp.screenHeight * 0.72);
        int mWidth = (int) (gp.screenWidth * 0.15);
        int mHight = (int) (gp.screenHeight * 0.22);

        // g2.drawRect(mX,mY,mWidth,mHight);

        g2.drawImage(gp.monsterDB.getBild(monster), monsterX, mY, mWidth, mHight, null);

        int sX = (int) (gp.screenWidth * 0.8);
        int sY = (int) (gp.screenHeight * 0.4);
        int swight = (int) (gp.screenWidth * 0.15);
        int shight = (int) (gp.screenHeight * 0.1);

         g2.drawRect(sX,sY,swight,shight);
         g2.setColor(Color.white);
        g2.fillRect(sX,sY,swight,shight);
        g2.setColor(Color.black);

        String leben = String.valueOf(monsterlive);
        String attack = String.valueOf(monsterattack);

        gp.text.draw2StringsInBox(g2, "Leben :" + leben, "Angriff : " + attack, sX, sY, swight, shight);
    }
    public void drawFightButton() {
        g2.setFont(g2.getFont().deriveFont(30F));

        int bX = (int) (gp.screenWidth / 2 - gp.screenWidth * 0.08);
        int bY = (int) (gp.screenHeight * 0.4);
        int bWight = (int) ((gp.screenWidth * 0.08) * 2);
        int bHigh = (int) (gp.screenHeight * 0.08);
        int yab = (int) (bHigh + gp.screenHeight * 0.02);

        slot[0] = new JPanel();
        slot[0].setBounds(bX, bY + 0 * yab, bWight, bHigh);
        slot[0].setName("Fight Button: 0");
        slot[0].addMouseListener(gp.mous);
        gp.add(slot[0]);
        slot[0].setVisible(true);
        g2.setColor(Color.white);
        g2.fillRect(bX, bY + 0 * yab, bWight, bHigh);
        g2.setColor(Color.black);
        gp.text.drawTextInBox(g2, "Fight", bX, bY + 0 * yab, bWight, bHigh);

        g2.drawRect(bX, bY + 0 * yab, bWight, bHigh);

    }
    public void drawBackButton(){
        back = true;
        int bX = (int) (gp.screenWidth / 2 - gp.screenWidth * 0.08);
        int bY = (int) (gp.screenHeight * 0.4);
        int bWight = (int) ((gp.screenWidth * 0.08) * 2);
        int bHigh = (int) (gp.screenHeight * 0.08);
        int yab = (int) (bHigh + gp.screenHeight * 0.02);


        slot[1] = new JPanel();
        slot[1].setBounds(bX, bY + 1 * yab, bWight, bHigh);
        slot[1].setName("Fight Button: 1");
        slot[1].addMouseListener(gp.mous);
        gp.add(slot[1]);
        slot[1].setVisible(true);
        g2.setColor(Color.white);
        g2.fillRect(bX, bY + 1 * yab, bWight, bHigh);
        g2.setColor(Color.black);
        gp.text.drawTextInBox(g2, "Back", bX, bY + 1 * yab, bWight, bHigh);
        g2.drawRect(bX, bY + 1 * yab, bWight, bHigh);

    }
    public void drawItems(){
        int iX = (int) (gp.screenWidth / 2 - gp.screenWidth * 0.07);
        int iY = (int) (gp.screenHeight * 0.65);
        int iWight = (int) ((gp.screenWidth * 0.068));
        int iHigh = (int) (gp.screenHeight * 0.08);

        for( int i = 0; i <2; i++) {
            slot[i] = new JPanel();
            slot[i].setBounds(iX + i* iWight, iY, iWight, iHigh);
            slot[i].setName("Item: " + i);
            slot[i].addMouseListener(gp.mous);
            gp.add(slot[i]);
            slot[i].setVisible(true);
            if (!(gp.player.equip[2+i] == -1)) {
                int slotnr = gp.player.equip[2+i];
                g2.drawImage(gp.dba.getItem(gp.player.item[slotnr][0], gp.player.item[slotnr][1]).getImagee(), iX + i* iWight, iY, iWight, iHigh, null);
            }
           // g2.drawRoundRect(iX + i* iWight, iY, iWight, iHigh, 10, 10);
        }
    }
    public void drawConsole(){

        int cX = (int) (gp.screenWidth / 2 - gp.screenWidth * 0.12);
        int cY = (int) (gp.screenHeight * 0.76);
        int cWight = (int) ((gp.screenWidth * 0.12) * 2);
        int cHigh = (int) (gp.screenHeight * 0.05);

        g2.drawRect(cX, cY, cWight, cHigh);
        g2.setColor(Color.white);
        g2.fillRect(cX, cY, cWight, cHigh);
        g2.setColor(Color.black);
        gp.text.drawTextInBox(g2, console, cX, cY, cWight, cHigh);


    }
    public void drawBackground() {
        g2.drawImage(background, 0, 0, gp.screenWidth, gp.screenHeight, null);
    }
    public void kampf() {
        if (playerAllow) {
            if (playerWalk <= 50) {
                playerWalk++;
                playerWalkAnimation("vor");
                playerX = (int) (playerX + playerWalk * 0.6);

            }else if(playerWalk >= 50 && playerWalkBack <=85){
                playerWalkBack ++;
                playerWalkAnimation("back");
                playerX = (int) (playerX - playerWalkBack * 0.2);


            }else if(playerWalk >= 50 && playerWalkBack >= 85){
                if(mosnterAbzug) {
                    gp.playSound(4);
                    monsterlive = monsterlive - gp.player.attack;
                    console = "Du hast dem Monster " + gp.player.attack + " schaden angerichtet";
                    mosnterAbzug = false;
                    winnerCheck();
                }
                playerWalkAnimation("");
                playerX = (int) (gp.screenWidth * 0.05);
                monsterAllow = true;
                playerAllow = false;
            }
        }else
        if (monsterAllow) {
            if (monsterWalk <= 50) {
                monsterX = (int) (monsterX - monsterWalk * 0.6);
                monsterWalk++;
            }else
            if(monsterWalk >= 50 && monsterWalkBack <=90){
                monsterWalkBack ++;
                monsterX = (int) (monsterX + monsterWalkBack * 0.2);

            }else if(monsterWalk >= 50 && monsterWalkBack >= 85){
                if(playerAbzug) {
                    gp.playSound(4);
                    int temp = gp.player.defense - monsterattack;
                    if (temp  < 0) {
                        gp.player.leben = gp.player.leben + temp;
                        console = "Du hast " + temp + " schaden bekommen";
                    }
                    playerAbzug = false;
                }
                winnerCheck();
                monsterX = (int) (gp.screenWidth * 0.8);
                monsterAllow = false;
                fight = false;
            }

        }
    }
    public void winnerCheck(){
        if(monsterlive <= 0){
            winner = 1;
            gp.player.gold += (int)Math.round(20*Math.random()+10);
            gp.playSound(6);
        }
        if(gp.player.leben <= 0)
            winner = 2;
    }
    public void useItem(int i) {
        int slotnr = gp.player.equip[i];
        if (!(slotnr == -1)) {

            int itemKraft = gp.dba.getItem(gp.player.item[slotnr][0], gp.player.item[slotnr][1]).getKraft();
            String itemName = gp.dba.getItem(gp.player.item[slotnr][0], gp.player.item[slotnr][1]).getName();
            gp.player.equip[i] = -1;
            gp.player.item[slotnr][0] = 0;
            gp.player.item[slotnr][1] = 0;
            System.out.println(itemKraft);
            if (itemKraft > 0) {
                gp.player.leben = gp.player.leben + itemKraft;

            } else {
                monsterlive = monsterlive + itemKraft;
            }
            console = "Du hast erfolgreich " + itemName + " eingesetzt";
            winnerCheck();
        } else {
            console = "Du Hast hier kein Item";
        }
    }
    public void playerWalkAnimation(String trydirection) {
        this.direction = trydirection;
        timer++;
        if (timer > 10) {
            if (animation == 1) {
                animation = 2;
            } else if (animation == 2) {
                animation = 1;
            }
            timer = 0;
        }

    }

    public void loadPlayerImage() {
        int slotnr;
        if (gp.player.equip[1] == -1) {
            slotnr = -1;
        } else {
            slotnr = gp.player.item[gp.player.equip[1]][1];
        }
        pWalkBild = null;
        switch (slotnr) {
            case -1:
                pWalkBild = gp.image.wdBild;
                break;
            case 0:
                pWalkBild = gp.image.wiBild;
                break;
            case 1:
                pWalkBild = gp.image.wgBild;
                break;
            case 2:
                pWalkBild = gp.image.wlBild;
                break;
            case 3:
                pWalkBild = gp.image.wdiBild;
                break;
            case 4:
                pWalkBild = gp.image.wjBild;
                break;
            case 5:
                pWalkBild = gp.image.wuBild;
                break;


        }
    }
    public void resetFightAnimation(){
        playerAllow = true;
        playerAbzug = true;
        playerWalk = 0;
        playerWalkBack = 0;
        mosnterAbzug = true;
        monsterWalk = 0;
        monsterWalkBack = 0;
    }
}

