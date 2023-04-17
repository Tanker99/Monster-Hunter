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

    //Level detail
    int monster;
    int monsterlive;
    int monsterattack;

    //Fight
    int playerX;
    int monsterX;
    boolean fight = false;
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
        //drawBackground();

        if (setup) {
            loadFigh();
        }
        if(winner > 0){
            if( winner == 1){
                g2.drawString("1",100,100);
            }else if(winner == 2){

            }
        }else {
            //Draw Player
            drawcharakter();

            //drawMonster
            drawmonster();

            //DrawButton
            if (!(fight)) {
                resetFightAnimation();
                drawButton();
                drawItems();
            }
        }


        //Kampf
        if (fight) {

            kampf();
        }
    }

    public void update() {

    }

    public void loadFigh() {
        playerX = (int) (gp.screenWidth * 0.05);
        monsterX = (int) (gp.screenWidth * 0.8);


        monster = (int) (Math.random() * gp.monster.mAnzahl);
        monsterlive = gp.monster.getHealth(monster);
        monsterattack = gp.monster.getAttack(monster);
        setup = false;
    }

    public void drawcharakter() {
        // int pX= (int) (gp.screenWidth*0.05);
        int pY = (int) (gp.screenHeight * 0.55);
        int pWidth = (int) (gp.screenWidth * 0.15);
        int pHight = (int) (gp.screenHeight * 0.22);

        g2.drawRect(playerX, pY, pWidth, pHight);

        if (gp.player.equip[1] != -1) {
            g2.drawImage(gp.image.iRBild[gp.player.equip[1]], playerX, pY, pWidth, pHight, null);
        } else {
            g2.drawImage(gp.image.iRDefault, playerX, pY, pWidth, pHight, null);
        }

        //drawState

        int sX = (int) (gp.screenWidth * 0.05);
        int sY = (int) (gp.screenHeight * 0.4);
        int swight = (int) (gp.screenWidth * 0.15);
        int shight = (int) (gp.screenHeight * 0.1);

        // g2.drawRect(sX,sY,swight,shight);

        String leben = String.valueOf(gp.player.leben);
        String attack = String.valueOf(gp.player.kraft);
        String defense = String.valueOf(gp.player.defense);

        gp.text.draw3StringsInBox(g2, "Leben :" + leben, "Angriff : " + attack, "Defense : " + defense, sX, sY, swight, shight);

    }

    public void drawmonster() {
        //int mX = (int) (gp.screenWidth * 0.8);
        int mY = (int) (gp.screenHeight * 0.55);
        int mWidth = (int) (gp.screenWidth * 0.15);
        int mHight = (int) (gp.screenHeight * 0.22);

        // g2.drawRect(mX,mY,mWidth,mHight);

        g2.drawImage(gp.monster.getBild(monster), monsterX, mY, mWidth, mHight, null);

        int sX = (int) (gp.screenWidth * 0.8);
        int sY = (int) (gp.screenHeight * 0.4);
        int swight = (int) (gp.screenWidth * 0.15);
        int shight = (int) (gp.screenHeight * 0.1);

        // g2.drawRect(sX,sY,swight,shight);

        String leben = String.valueOf(monsterlive);
        String attack = String.valueOf(monsterattack);

        gp.text.draw2StringsInBox(g2, "Leben :" + leben, "Angriff : " + attack, sX, sY, swight, shight);
    }

    public void drawButton() {
        int bX = (int) (gp.screenWidth / 2 - gp.screenWidth * 0.08);
        int bY = (int) (gp.screenHeight * 0.4);
        int bWight = (int) ((gp.screenWidth * 0.08) * 2);
        int bHigh = (int) (gp.screenHeight * 0.08);
        int yab = (int) (bHigh + gp.screenHeight * 0.02);

        String[] btext = {"Fight", "Back"};

        for (int i = 0; i < 2; i++) {
            slot[i] = new JPanel();
            slot[i].setBounds(bX, bY + i * yab, bWight, bHigh);
            slot[i].setName("Fight Button: " + i);
            slot[i].addMouseListener(gp.mous);
            gp.add(slot[i]);
            slot[i].setVisible(true);
            gp.text.drawTextInBox(g2, btext[i], bX, bY + i * yab, bWight, bHigh);
            g2.drawRect(bX, bY + i * yab, bWight, bHigh);

        }
    }
    public void drawItems(){
        int iX = (int) (gp.screenWidth / 2 - gp.screenWidth * 0.07);
        int iY = (int) (gp.screenHeight * 0.65);
        int iWight = (int) ((gp.screenWidth * 0.068));
        int iHigh = (int) (gp.screenHeight * 0.08);

        for( int i = 0; i <2; i++) {
            slot[i] = new JPanel();
            slot[i].setBounds(iX + i* iWight, iY, iWight, iHigh);
            slot[i].setName("Fight Button: " + i);
            slot[i].addMouseListener(gp.mous);
            gp.add(slot[i]);
            slot[i].setVisible(true);
            if (!(gp.player.equip[2+i] == -1)) {
                int slotnr = gp.player.equip[2+i];
                g2.drawImage(gp.dba.getItem(gp.player.item[slotnr][0], gp.player.item[slotnr][1]).getImagee(), iX + i* iWight, iY, iWight, iHigh, null);
            }
            g2.drawRoundRect(iX + i* iWight, iY, iWight, iHigh, 10, 10);
        }
    }

    public void drawBackground() {
        BufferedImage back = null;
        try {
            back = ImageIO.read(Shop.class.getResource("/Hintergründe/Kampfhaus.png"));
            g2.drawImage(back, 0, 0, gp.screenWidth, gp.screenHeight, null);
        } catch (IOException e) {
            System.out.println("Error Loading Background");
        }
    }



        public void kampf() {
        if (playerAllow) {
            if (playerWalk <= 90) {
                playerWalk++;
                playerX = (int) (playerX + playerWalk * 0.2);

            }else if(playerWalk >= 90 && playerWalkBack <=85){
                playerWalkBack ++;
                playerX = (int) (playerX - playerWalkBack * 0.2);


            }else if(playerWalk >= 90 && playerWalkBack >= 85){
                if(mosnterAbzug) {
                    monsterlive = monsterlive - gp.player.kraft;
                    mosnterAbzug = false;
                    if(monsterlive <= 0){
                        winner = 1;
                    }
                }
                playerX = (int) (gp.screenWidth * 0.05);
                monsterAllow = true;
                playerAllow = false;
            }
        }else
        if (monsterAllow) {
            if (monsterWalk <= 90) {
                monsterX = (int) (monsterX - monsterWalk * 0.2);
                monsterWalk++;
            }else
            if(monsterWalk >= 90 && monsterWalkBack <=90){
                monsterWalkBack ++;
                monsterX = (int) (monsterX + monsterWalkBack * 0.2);

            }else if(monsterWalk >= 90 && monsterWalkBack >= 85){
                if(playerAbzug) {
                    int temp = gp.player.defense - monsterattack;
                    if (temp  < 0) {
                        gp.player.leben = gp.player.leben + temp;
                    }
                    playerAbzug = false;
                }
                if(gp.player.leben <= 0){
                    winner = 2;
                }
                    monsterX = (int) (gp.screenWidth * 0.8);
                monsterAllow = false;
                    fight = false;
                }

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

