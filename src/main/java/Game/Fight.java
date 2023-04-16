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
    int MonsterX;
    boolean fight = false;









    int level;

    int lebenMonster;

    int lebenSpieler;



    private JPanel slot[]=new JPanel[3];

    public Fight(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        if(setup) {
            loadFigh();
        }

        //Draw Background
        //drawBackground();

        //Draw Player
        drawcharakter();

        //drawMonster
        drawmonster();

        //DrawButton
        if(!(fight)) {
            drawButton();
        }

        //Kampf
        if(fight) {
            kampf();
        }
    }
    public void update(){

    }
    public void loadFigh(){
        playerX = (int) (gp.screenWidth*0.05);


        monster = (int) (Math.random() * gp.monster.mAnzahl);
        monsterlive = gp.monster.getHealth(monster);
        monsterattack = gp.monster.getAttack(monster);
        setup = false;
    }

    public void drawcharakter() {
       // int pX= (int) (gp.screenWidth*0.05);
        int pY= (int) (gp.screenHeight * 0.55);
        int pWidth= (int) (gp.screenWidth * 0.15);
        int pHight = (int) (gp.screenHeight * 0.22);

        g2.drawRect(playerX,pY,pWidth,pHight);

        if(gp.player.equip[1] != -1){
            g2.drawImage(gp.image.iRBild[gp.player.equip[1]],playerX,pY,pWidth,pHight,null);
        }else {
            g2.drawImage(gp.image.iRDefault,playerX,pY,pWidth,pHight,null);
        }

        //drawState

        int sX = (int) (gp.screenWidth*0.05);
        int sY = (int) (gp.screenHeight * 0.4);
        int swight = (int) (gp.screenWidth * 0.15);
        int shight = (int) (gp.screenHeight * 0.1);

       // g2.drawRect(sX,sY,swight,shight);

        String leben = String.valueOf(gp.player.leben);
        String attack = String.valueOf(gp.player.kraft);
        String defense = String.valueOf(gp.player.defense);

        gp.text.draw3StringsInBox(g2,"Leben :" + leben, "Angriff : " + attack,"Defense : " + defense,sX,sY,swight,shight);

    }
    public void drawmonster() {
        int mX= (int) (gp.screenWidth*0.8);
        int mY= (int) (gp.screenHeight * 0.55);
        int mWidth= (int) (gp.screenWidth * 0.15);
        int mHight = (int) (gp.screenHeight * 0.22);

       // g2.drawRect(mX,mY,mWidth,mHight);

        g2.drawImage(gp.monster.getBild(monster),mX,mY,mWidth,mHight,null);

        int sX = (int) (gp.screenWidth*0.8);
        int sY = (int) (gp.screenHeight * 0.4);
        int swight = (int) (gp.screenWidth * 0.15);
        int shight =(int) (gp.screenHeight * 0.1);

       // g2.drawRect(sX,sY,swight,shight);

        String leben = String.valueOf(monsterlive);
        String attack = String.valueOf(monsterattack);

        gp.text.draw2StringsInBox(g2,"Leben :" + leben, "Angriff : " + attack,sX,sY,swight,shight);
    }

    public void drawButton() {
        int bX = (int) (gp.screenWidth/2 - gp.screenWidth*0.08);
        int bY = (int) (gp.screenHeight * 0.6);
        int bWight = (int) (( gp.screenWidth*0.08)*2);
        int bHigh = (int) (gp.screenHeight * 0.08);
        int yab = (int) (bHigh + gp.screenHeight * 0.02);

        String[] btext = {"Fight" , "Back"};

        for (int i = 0; i < 2; i++) {
            slot[i] = new JPanel();
            slot[i].setBounds(bX, bY + i * yab, bWight, bHigh);
            slot[i].setName("Fight Button: " + i);
            slot[i].addMouseListener(gp.mous);
            gp.add(slot[i]);
            slot[i].setVisible(true);
            gp.text.drawTextInBox(g2,btext[i],bX, bY + i * yab, bWight, bHigh);
            g2.drawRect(bX,  bY+ i * yab, bWight, bHigh);

        }
    }
    public void drawBackground(){
        BufferedImage back = null;
        try {
            back = ImageIO.read(Fight.class.getResource("/back.png"));
            g2.drawImage(back, 0, 0, gp.screenWidth, gp.screenHeight, null);
        } catch (IOException e) {
            System.out.println("Error Loading Background");
        }
    }

    public void kampf() {
        System.out.println("Fight Beginn");

        for(int i = 10; i > 0; i--){
            playerX = playerX + 5;
        }
        fight = false;









            /*
            for(int i=0;i<=lebenSpieler||i<=lebenMonster;i++){
                lebenMonster-=(gp.player.kraft);
                lebenSpieler-=(gp.monster.attack);
            }
            if(lebenSpieler<=0){
                gp.gameState=gp.uiState;
            }
            if(lebenMonster<=0){
                gp.gameState= gp.playerState;

            }

             */
        }
    }




