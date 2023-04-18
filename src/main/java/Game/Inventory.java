package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static java.awt.Color.*;

public class Inventory {
    //Standard
    GamePanel gp;
    KeyHandler keyH;
    Graphics2D g2;

    //variable
    public boolean select;
    public boolean twoSelect;
    public int currentSlot;
    public int selectSlot;
    public int twoSelectSlot;
    public int currentSlotValueX;
    public int currentSlotValueY;

    public boolean tryequip;
    public boolean trysell;

    //JPanel
    private JPanel slot[] = new JPanel[8];
    private JPanel button[] = new JPanel[3];


    //inventar
    private int inX = 0;
    private int inY = 0;
    private int inWight =0;
    private int inHigh =0;


    //Panel
    private int panX =0;
    private int panY = 0;
    private int panWight= 0;
    private int panHigh = 0;

    //Slot
    private int sloX =0;
    private int sloY = 0;
    private int sloWight= 0;
    private int sloHigh = 0;

    //sonstig

    private int sonX =0;
    private int sonY = 0;
    private int sonWight= 0;
    private int sonHigh = 0;
    String console = "";





    public Inventory(GamePanel gp,KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        this.inX = 10;
        this.inY = gp.screenHeight/4 - 20;
        this.inWight = gp.screenWidth -20;
        this.inHigh = gp.screenHeight/2 - 20;

    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        drawInventory();
        g2.setFont(new Font("Arial",Font.PLAIN,40));
        g2.setColor(white);

        int iX = (int) (gp.screenWidth / 2 - gp.screenWidth * 0.08);
        int iY = (int) (gp.screenHeight * 0.1);
        int iWight = (int) ((gp.screenWidth * 0.08) * 2);
        int iHigh = (int) (gp.screenHeight * 0.08);



        g2.drawRoundRect(iX,iY,iWight,iHigh,10,10);
        gp.text.drawTextInBox(g2,"Inventar",iX,iY,iWight,iHigh);

    }
    public void drawInventory(){

        g2.setColor(white);

        //drawBackground
        drawBackground();

        //draw Console
        drawConsole();


        //draw Inventory rand
        g2.drawRoundRect(inX,inY,inWight,inHigh,10,10);
        g2.drawString("Gold: " + gp.player.gold,(int) (inWight*0.9) + inX,250);

        //Draw Slots
        drawSlot();

        //Draw detail/equip Panel
        drawItemPanel();

        // Draw etc Buttons
        drawButton();

        //Move
        drawMove();

        //draw Swap;

        drawSwap();

        tryeuipcheck();

        sell();

    }
    public void drawBackground(){
        BufferedImage back = null;
        try {
            back = ImageIO.read(Shop.class.getResource("/Background/inventar.png"));
            g2.drawImage(back, 0, 0, gp.screenWidth, gp.screenHeight, null);
        } catch (IOException e) {
            System.out.println("Error Loading Background");
        }
    }
    public void drawConsole(){
       int cX = inX + 10;
       int cY = (int) (gp.screenHeight * 0.66);
       int cWight= (int) (gp.screenWidth * 0.18);
       int cHigh = (int) (gp.screenHeight * 0.025);

        //g2.drawRoundRect(cX,cY,cWight,cHigh, 10,10);
        gp.text.drawTextInBox(g2, console, cX, cY, cWight, cHigh);

    }
    public void drawSlot(){

        //int slotx = (int) (gp.screenWidth * 0.18);
        //int slotwight = (int) (gp.screenWidth * 0.88);

       // g2.drawRoundRect(slotx,slotwight /4,100,100,10,10);

        this.sloX = (int) (inWight * 0.2) + inX;
        this.sloY = (int) (inHigh * 0.05) + inY;
        this.sloWight = 150;
        this.sloHigh = 150;
        int i =0;
        for (int iy = 0; iy <= 1; iy++) {
            for (int ix = 0; ix <= 3; ix++) {
                slot[i] = new JPanel();
                slot[i].setName("Slot: " + i);
                slot[i].setBounds(sloX + ix * 200,sloY + iy * 200,sloWight,sloHigh);
                gp.add(slot[i]);
                slot[i].setVisible(true);
                slot[i].addMouseListener(gp.mous);
                g2.drawRoundRect(sloX + ix * 200, sloY + iy * 200, sloWight, sloHigh, 10, 10);

                int db = gp.player.item[i][0];
                int item = gp.player.item[i][1];
                if(!(gp.player.item[i][0] == 0)) {
                    int x = sloWight /2 - gp.dba.getItem(db,item).getImagee().getWidth() /2;
                    g2.drawImage(gp.dba.getItem(db,item).getImagee(),sloX + x  +ix *200 ,sloY + iy * 200 + 5,null);


                    gp.text.drawTextcentered(g2,gp.dba.getItem(gp.player.item[i][0], gp.player.item[i][1]).getName(), sloX + ix * 200, sloY + iy * 200 + 100, sloWight);
                   // g2.drawString(gp.dba.getItem(gp.player.item[i][0], gp.player.item[i][1]).getName(), sloX + ix * 200, sloY + iy * 200 + 100);
                    gp.text.drawTextcentered(g2,(gp.dba.getItem(db,item).getGoldwert()) + " Muenzen",sloX + ix * 200,sloY + iy * 200+ 115,sloWight);
                   // g2.drawString(String.valueOf(gp.dba.getItem(db,item).getGoldwert()) + " Muenzen",sloX + ix * 200,sloY + iy * 200+ 115);
                    if(db == 3 ){
                        gp.text.drawTextcentered(g2, "Heilt um :"+ gp.dba.getItem(db, item).getKraft(), sloX + ix * 200, sloY + iy * 200 + 130, sloWight);
                    }else {
                        gp.text.drawTextcentered(g2, (gp.dba.getItem(db, item).getKraft()) + " Kraft", sloX + ix * 200, sloY + iy * 200 + 130, sloWight);
                    }
                    // g2.drawString(String.valueOf(gp.dba.getItem(db,item).getKraft()) + " Kraft",sloX + ix * 200,sloY + iy * 200 + 130 );
                }
                i++;
            }
        }

    }
    public void drawItemPanel(){
        this.panX = inX + 10;
        this.panY = (int) (inY + inHigh*0.1);
        this.panWight= (int) (gp.screenWidth * 0.16);
        this.panHigh = (int) (inHigh /1.3);

        g2.drawRoundRect(panX,panY,panWight,panHigh, 10,10);

        if(select){
            drawDetailPanel();
        }
        if (!select) {
            drawEquipPanel();
        }
    }
    public void drawDetailPanel(){
        int db = gp.player.item[selectSlot][0];
        int item = gp.player.item[selectSlot][1];

        if(!(gp.player.item[selectSlot][0] == 0)) {

            int x = panWight /2 - gp.dba.getItem(db,item).getImagee().getWidth() /2;
            g2.drawImage(gp.dba.getItem(db, item).getImagee(), panX + x, panY + 20, null);


            gp.text.drawTextcentered(g2,gp.dba.getItem(db, item).getName(), panX, panY + 100, panWight);
            gp.text.drawTextcentered(g2, (gp.dba.getItem(db, item).getGoldwert()) + " Muenzen", panX, panY + 300, panWight / 2);
            gp.text.drawTextBetweenBox(g2,gp.dba.getItem(db, item).getText(),panX + 5, panY +150 , panWight);
            if(db == 3){
                gp.text.drawTextcentered(g2, "Heilt um: "+gp.dba.getItem(db, item).getKraft() , panX + panWight/2, panY + 300,panWight/2);
            }else {
                gp.text.drawTextcentered(g2,(gp.dba.getItem(db, item).getKraft()) + " Kraft", panX + panWight/2, panY + 300,panWight/2);
            }

        }else {
            g2.drawString("Hier liegt kein Item",panX,panY + 150);
        }



    }
    public void drawEquipPanel(){
        for(int i = 0; i< 4; i++) {
            int ii = i * 60;
            g2.drawRoundRect(panX + 10, (int) (panY + panHigh * 0.15) + ii, 50, 50, 10, 10);

            if (!(gp.player.equip[i] == -1)) {
                int slotnrr = gp.player.equip[i];
                g2.drawImage(gp.dba.getItem(gp.player.item[slotnrr][0], gp.player.item[slotnrr][1]).getImagee(), panX + 10, (int) (panY + panHigh * 0.15) + ii, null);
            }
        }

        gp.text.drawTextcentered(g2,"Kraft: " + gp.player.kraft,panX ,panY + 340,panWight/2);
        gp.text.drawTextcentered(g2,"Defense: " + gp.player.defense, panX + panWight/2, panY + 340,panWight/2);

        //Draw Picture
        int pcX = (int) (panX + gp.screenWidth * 0.06);
        int pcY = (int) (panY + gp.screenHeight * 0.08);
        int pcWight = (int) (gp.screenWidth * 0.09);
        int pcHigh = (int) (inHigh /2.6);
        g2.drawRoundRect(pcX,pcY,pcWight,pcHigh,10,10);
        if(gp.player.equip[1] != -1){
            g2.drawImage(gp.image.iRBild[gp.player.item[gp.player.equip[1]][1]],pcX,pcY,pcWight,pcHigh,null);
        }else {
            g2.drawImage(gp.image.iRDefault,pcX,pcY,pcWight,pcHigh,null);
        }


    }
    public void drawMove() {
        if (select) {
            int sx = selectSlot;
            int sy = 0;
            if (selectSlot > 3) {
                sx = selectSlot - 4;
                sy = 1;
            }
            g2.setColor(blue);
            g2.drawRoundRect(sloX + sx * 200, sloY + sy * 200, sloWight, sloHigh, 10, 10);
        }
        if (!(currentSlot > 7)) {
            g2.setColor(green);
            g2.drawRoundRect(sloX + currentSlotValueX * 200, sloY + currentSlotValueY * 200, sloWight, sloHigh, 10, 10);
        } else {
            g2.setColor(green);
            if (currentSlot == 8 && select) {
                g2.drawRoundRect(sonX, sonY + (currentSlot - 8) * 100, sonWight, sonHigh, 10, 10);
            }
            if (currentSlot == 9 && gp.shopEntry) {
                g2.drawRoundRect(sonX, sonY + (currentSlot - 8) * 100, sonWight, sonHigh, 10, 10);
            }
            if (currentSlot == 10) {
                g2.drawRoundRect(sonX, sonY + 2 * 100, sonWight, sonHigh, 10, 10);
            }
        }


    }
    public void drawSwap() {
        int a = -1;
        int b = -1;
        if (select) {
            if (twoSelect) {
                for( int i = 0; i < 4; i++){
                        if(gp.player.equip[i] == twoSelectSlot){
                           b = i;
                        }else if(gp.player.equip[i] == selectSlot){
                           a = i;
                        }
                    }
                if(!(a == -1)) {
                    gp.player.equip[a] = twoSelectSlot;
                }
                if(!(b == -1)) {
                    gp.player.equip[b] = selectSlot;
                }




                int sdb = gp.player.item[twoSelectSlot][0];
                int sitem = gp.player.item[twoSelectSlot][1];

                gp.player.item[twoSelectSlot][0] = gp.player.item[selectSlot][0];
                gp.player.item[twoSelectSlot][1] = gp.player.item[selectSlot][1];

                gp.player.item[selectSlot][0] = sdb;
                gp.player.item[selectSlot][1] = sitem;

                select = false;
                twoSelect = false;
                selectSlot = 0;
                twoSelectSlot = 0;


            }
        }
    }
    public void drawButton(){
        this.sonX = (int) (inWight*0.9) + inX;
        this.sonY = (int) (inHigh*0.6) + inY;
        this.sonWight = 100;
        this.sonHigh = 50;
        String[] text = new String[]{"equip", "sell", "back", "unequip"};

        for(int i = 0; i < 3; i++) {
            button[i] = new JPanel();
            button[i].setName("Button: " + text[i]);
            button[i].setBounds(sonX , sonY + i * 100 , sonWight, sonHigh);
            gp.add(button[i]);
            button[i].addMouseListener(gp.mous);
            button[i].setVisible(true);

        }
        if(select){
            if(gp.player.equip[0] == selectSlot || gp.player.equip[1] == selectSlot || gp.player.equip[2] == selectSlot || gp.player.equip[3] == selectSlot) {
                g2.drawString(text[3],sonX + 20 ,sonY+ 20+ 0*100);
            }else {
                g2.drawString(text[0],sonX + 20 ,sonY+ 20+ 0*100);
            }

            g2.drawRoundRect(sonX , sonY + 0 * 100 , sonWight, sonHigh, 10, 10);
        }
        if(gp.shopEntry && select){
            g2.drawString(text[1],sonX + 20 ,sonY+ 20+ 1*100);
            g2.drawRoundRect(sonX , sonY + 1 * 100 , sonWight, sonHigh, 10, 10);
        }

        g2.drawString(text[2],sonX + 20 ,sonY+ 20+ 2*100);
        g2.drawRoundRect(sonX , sonY + 2 * 100 , sonWight, sonHigh, 10, 10);


    }
    public void tryeuipcheck(){
        String[] equip = {"Aüsgerüstet", "Entrüstet"};
        int i = 0;
        if(tryequip){
            System.out.println(selectSlot);
            if(gp.player.item[selectSlot][0] == 1){
                if(gp.player.equip[0] == selectSlot){
                    gp.player.equip[0] = -1;
                    i = 1;
                    gp.player.kraft = 0;
                }else {
                    gp.player.equip[0] = selectSlot;
                    gp.player.kraft = gp.dba.getItem(1, gp.player.item[selectSlot][1]).getKraft();
                }
            }
            if(gp.player.item[selectSlot][0] == 2){
                if(gp.player.equip[1] == selectSlot){
                    gp.player.equip[1] = -1;
                    gp.player.defense = 0;
                    i = 1;
                    gp.player.getImage();
                }else {
                    gp.player.equip[1] = selectSlot;
                    gp.player.defense = gp.dba.getItem(2, gp.player.item[selectSlot][1]).getKraft();
                    gp.player.getImage();
                }
            }
            if(gp.player.item[selectSlot][0] == 3) {
                if (gp.player.equip[2] == selectSlot) {
                    gp.player.equip[2] = -1;
                    i = 1;
                } else if (gp.player.equip[3] == selectSlot) {
                    gp.player.equip[3] = -1;
                    i = 1;
                } else if (gp.player.equip[2] == -1) {
                    gp.player.equip[2] = selectSlot;
                } else if (gp.player.equip[3] == -1) {
                    gp.player.equip[3] = selectSlot;
                } else {
                    gp.player.equip[2] = selectSlot;
                }
            }


            tryequip = false;
            select = false;
            //Console
            String iName = gp.dba.getItem(gp.player.item[selectSlot][0],gp.player.item[selectSlot][1]).getName();
            console = "Du hast " + iName + " " + equip[i];
        }
    }
    public void sell(){
        if(trysell && select) {
            String iName = gp.dba.getItem(gp.player.item[selectSlot][0],gp.player.item[selectSlot][1]).getName();
            int iWert = (int) (gp.dba.getItem(gp.player.item[selectSlot][0],gp.player.item[selectSlot][1]).getGoldwert() * 0.8);
            gp.player.gold =  gp.player.gold + iWert;
            console = "Du hast " + iName + " für " + iWert + "€ Verkauft";
            for(int i = 0; i < 3; i++) {
                if(gp.player.equip[i] == selectSlot){
                    gp.player.equip[i] = -1;
                    if(i == 0){
                        gp.player.kraft = 0;
                    }
                    if( i == 1){
                        gp.player.defense = 0;
                    }
                }
            }
            gp.player.item[selectSlot][0] = 0;
            gp.player.item[selectSlot][1] = 0;
            trysell = false;
            select = false;
        }
    }
    public void update() {
    }
    public void resetCurser(){
        console = "";
        gp.shopEntry = false;
        currentSlotValueY = 0;
        currentSlotValueX = 0;
        currentSlot = 0;
        select = false;
        twoSelect = false;
        selectSlot = 0;
        twoSelectSlot = 0;
    }
    private int getx(Graphics2D g2,String text){
        int lenght = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = lenght/2;
        return x;
    }
    private void drawStringInBox(String text, int x, int y, int width) {
        // prüft ob Game.Text zu breit
        FontMetrics metrics = g2.getFontMetrics();
        int textWidth = metrics.stringWidth(text);
        if (textWidth > width) {
            // Umrechnung von text
            String[] lines = text.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (String word : lines) {
                if (metrics.stringWidth(sb.toString() + " " + word) > width) {
                    g2.drawString(sb.toString(), x, y);
                    y += metrics.getHeight();
                    sb.setLength(0);
                }
                sb.append(word).append(" ");
            }
            g2.drawString(sb.toString(), x, y);
        } else {
           // zeichnet wenn doch passst
            g2.drawString(text, x, y);
        }
    }
}



