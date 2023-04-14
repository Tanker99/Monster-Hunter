package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static java.awt.Color.*;

public class Shop {
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





    public Shop(GamePanel gp,KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        this.inX = 10;
        this.inY = gp.screenHeight/4 - 20;
        this.inWight = gp.screenWidth -20;
        this.inHigh = (int) (gp.screenHeight/1.5 - 20);

    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        drawInventory();
        g2.setFont(new Font("Arial",Font.PLAIN,40));
        g2.setColor(Color.black);
        g2.drawString("SHOP", gp.screenWidth/2,50);

        g2.drawRoundRect(gp.screenWidth/2,0,200,100,10,10);

    }
    public void drawInventory(){
        //draw Game.Inventory rand
        g2.drawRoundRect(inX,inY,inWight,inHigh,10,10);
        g2.drawString("Gold: " + gp.player.gold,(int) (inWight*0.9) + inX,250);

        //Draw Slots
       // drawSlot();

        //Draw detail/equip Panel
        drawItemPanel();

        // Draw etc Buttons
        drawButton();

        //Move
        drawMove();


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


        }

        int i = 0;
        BufferedImage cha = null;
        try {
            switch (i) {
                case 1:
                    cha = ImageIO.read(Player.class.getResource("/back.png"));
                    break;
                case 2:
                    cha = ImageIO.read(Player.class.getResource("/back.png"));
                    break;
                case 3:
                    cha = ImageIO.read(Player.class.getResource("/back.png"));
                    break;
            }
            g2.drawImage(cha, 0, 0, gp.screenWidth, panWight, null);
        } catch (IOException e) {
            System.out.println("Error Loading Background");
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
        }


    }

    public void drawButton(){
        this.sonX = (int) (inWight*0.9) + inX;
        this.sonY = (int) (inHigh*0.6) + inY;
        this.sonWight = 100;
        this.sonHigh = 50;
        String[] text = new String[]{"equip", "sell", "back [e]", "unequip"};

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
        if(gp.shopEntry){
            g2.drawString(text[1],sonX + 20 ,sonY+ 20+ 1*100);
            g2.drawRoundRect(sonX , sonY + 1 * 100 , sonWight, sonHigh, 10, 10);
        }

        g2.drawString(text[2],sonX + 20 ,sonY+ 20+ 2*100);
        g2.drawRoundRect(sonX , sonY + 2 * 100 , sonWight, sonHigh, 10, 10);


    }

    public void update() {
    }
    public void resetCurser(){
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



