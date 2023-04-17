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
    String console = "";
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

        drawConsole();

        if (setup) {
            loadFigh();
        }
        if(winner > 0){
            if( winner == 1){
                console = "Du hast Gewonnen der Shop wurde für dich erneuert";
                gp.shop.newShop = true;
                gp.monsterDB.mtot[monster] = 1;
            }else if(winner == 2){
                console = "Du hast Verloren";
            }
            drawBackButton();
        }else {
            //Draw Player
            drawcharakter();

            //drawMonster
            drawmonster();



            //DrawButton
            if (!(fight)) {
                resetFightAnimation();
                drawFightButton();
                drawBackButton();
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
        resetFightAnimation();
        fight = false;
        winner = 0;
        playerX = (int) (gp.screenWidth * 0.05);
        monsterX = (int) (gp.screenWidth * 0.8);

        console = "";

        monster = (int) (Math.random() * gp.monsterDB.mAnzahl);
        monsterlive = gp.monsterDB.getHealth(monster);
        monsterattack = gp.monsterDB.getAttack(monster);
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

        g2.drawImage(gp.monsterDB.getBild(monster), monsterX, mY, mWidth, mHight, null);

        int sX = (int) (gp.screenWidth * 0.8);
        int sY = (int) (gp.screenHeight * 0.4);
        int swight = (int) (gp.screenWidth * 0.15);
        int shight = (int) (gp.screenHeight * 0.1);

        // g2.drawRect(sX,sY,swight,shight);

        String leben = String.valueOf(monsterlive);
        String attack = String.valueOf(monsterattack);

        gp.text.draw2StringsInBox(g2, "Leben :" + leben, "Angriff : " + attack, sX, sY, swight, shight);
    }

    public void drawFightButton() {
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
            gp.text.drawTextInBox(g2, "Fight", bX, bY + 0 * yab, bWight, bHigh);
            g2.drawRect(bX, bY + 0 * yab, bWight, bHigh);

        }
        public void drawBackButton(){
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
            g2.drawRoundRect(iX + i* iWight, iY, iWight, iHigh, 10, 10);
        }
    }
    public void drawConsole(){
        int cX = (int) (gp.screenWidth / 2 - gp.screenWidth * 0.09);
        int cY = (int) (gp.screenHeight * 0.76);
        int cWight = (int) ((gp.screenWidth * 0.09) * 2);
        int cHigh = (int) (gp.screenHeight * 0.08);

       // g2.drawRoundRect(cX,cY,cWight,cHigh,10,10);
        gp.text.drawTextInBox(g2, console, cX, cY, cWight, cHigh);


    }

    public void drawBackground() {
        BufferedImage back = null;
        try {
            back = ImageIO.read(Shop.class.getResource("/Background/Kampfhaus.png"));
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
                    console = "Du hast dem Monster " + gp.player.kraft + " schaden angerichtet";
                    mosnterAbzug = false;
                    winnerCheck();
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

