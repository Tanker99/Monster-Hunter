package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Shop {
    //Standart
    GamePanel gp;
    Graphics2D g2;

    //SHOP VAR
    int sX ;
    int sY ;
    int sWight ;
    int sHigh;
    boolean test = true;

    //select
    public boolean select = false;
    public int currentItem;
    public int selectItem;

    //Zusatz
    public String console = "";


    //JPanel

    private JPanel slot[] = new JPanel[4];
    private JPanel button[] = new JPanel[4];
    public int item[][] = new int[4][2];

    public Shop(GamePanel gp){
        this.gp = gp;
    }
    public void draw (Graphics2D g2){
        this.g2 = g2;
        g2.setColor(Color.white);

        if(test){
            test = false;
            randomeItem();
        }


        drawShop();

        drawItems();

        drawdeteilPanel();

        drawButtons();

        drawanzeige();
    }

    public void drawShop(){
        this.sX = (int) (gp.screenWidth * 0.01);
        this.sY = gp.screenHeight/4 ;
        this.sWight = gp.screenWidth - 2 * sX;
        this.sHigh = gp.screenHeight /2 ;

        g2.drawRoundRect(sX,sY,sWight,sHigh,10,10);

        BufferedImage back = null;
        try {
            back = ImageIO.read(Shop.class.getResource("/Hintergruende/Shop.png"));
            g2.drawImage(back, 0, 0, gp.screenWidth, gp.screenHeight, null);
        } catch (IOException e) {
            System.out.println("Error Loading Background");
        }
    }
    public void drawItems(){

        int iX = (int) (gp.screenWidth* 0.07);
        int iY = (int) (gp.screenHeight * 0.45);
        int iWight = 100;
        int iHigh = 100;

        for( int i = 0; i < 2; i++) {
            slot[i] = new JPanel();
            slot[i].setName("Item: " + i);
            slot[i].setBounds(iX +i*(iX + iWight), iY, iWight, iHigh);
            gp.add(slot[i]);
            slot[i].setVisible(true);
            slot[i].addMouseListener(gp.mous);

           // g2.drawRoundRect(iX +i*(iX + iWight), iY, iWight, iHigh, 10, 10);
            if(item[i][0] != 0){
                g2.drawImage(gp.dba.getItem(item[i][0], item[i][1]).getImagee(), iX + i * (iX + iWight), iY, iWight, iHigh, null);
            }
        }
        int ii = 2;
        for( int i = 0; i < 2; i++) {
            slot[ii] = new JPanel();
            slot[ii].setName("Item: " + ii);
            slot[ii].setBounds(gp.screenWidth - ((iX + iWight) + i*(iX + iWight)), iY, iWight, iHigh);
            gp.add(slot[ii]);
            slot[ii].setVisible(true);
            slot[ii].addMouseListener(gp.mous);
          //  g2.drawRoundRect( gp.screenWidth - ((iX + iWight) + i*(iX + iWight)), iY, iWight, iHigh, 10, 10);
            if(item[ii][0] != 0){
                g2.drawImage(gp.dba.getItem(item[ii][0], item[ii][1]).getImagee(), gp.screenWidth - ((iX + iWight) + i * (iX + iWight)), iY, iWight, iHigh, null);
            }
            ii++;
        }


    }
    public void drawdeteilPanel(){
        int pX = (int) (gp.screenWidth/2 - gp.screenWidth*0.09);
        int pY = (int) (gp.screenHeight * 0.3);
        int pWight = (int) (( gp.screenWidth*0.09)*2);
        int pHigh = (int) (gp.screenHeight * 0.3);

        g2.drawRoundRect(pX,pY,pWight,pHigh,10,10);;

        if(!select || item[selectItem][0] == 0){
            gp.text.drawTextInBox(g2,"Wähle einen Item aus",pX,pY ,pWight,pHigh);
        }else {
            //picture
            int piX = (int) (gp.screenWidth / 2 - 50);
            int piY = (int) (gp.screenHeight * 0.31);
            int piWight = (int) 100;
            int piHigh = 100;
            g2.drawRoundRect(piX, piY, piWight, piHigh, 10, 10);
            g2.drawImage(gp.dba.getItem(item[selectItem][0],item[selectItem][1]).getImagee(),piX,piY,piWight,piHigh,null);

            gp.text.drawTextBetweenBox(g2,gp.dba.getItem(item[selectItem][0],item[selectItem][1]).getText(), (int) (pX + gp.screenWidth * 0.01), (int) (piY + piWight + gp.screenHeight * 0.03), (int) (pWight - gp.screenWidth * 0.01));


            int db = item[selectItem][0];
            int itemnr = item[selectItem][1];

            gp.text.drawTextcentered(g2, (gp.dba.getItem(db, itemnr).getGoldwert()) + " Muenzen", pX, (int) (gp.screenHeight * 0.58), pWight / 2);

            if(db == 3){
                gp.text.drawTextcentered(g2, "Heilt um: "+gp.dba.getItem(db, itemnr).getKraft() , pX + pWight/2, (int) (gp.screenHeight * 0.58),pWight/2);
            }else {
                gp.text.drawTextcentered(g2,(gp.dba.getItem(db, itemnr).getKraft()) + " Kraft", pX + pWight/2, (int) (gp.screenHeight * 0.58),pWight/2);
            }

        }
    }
    public void drawButtons() {

        //Back
        int bX = (int) (sX + (gp.screenWidth * 0.01));
        int bY = (int) (sY + (gp.screenHeight * 0.03));
        int bWight = (int) (gp.screenWidth * 0.12);
        int bHigh = (int) (gp.screenHeight * 0.08);
        g2.drawRoundRect(bX, bY, bWight, bHigh, 10, 10);
        gp.text.drawTextInBox(g2, "Back", bX, bY, bWight, bHigh);

        button[0] = new JPanel();
        button[0].setName("Button: 0" );
        button[0].setBounds(bX, bY, bWight, bHigh);
        gp.add(button[0]);
        button[0].setVisible(true);
        button[0].addMouseListener(gp.mous);

        //INV
        int invWight = (int) (gp.screenWidth * 0.12);
        int invX = (int) (gp.screenWidth - (sX + gp.screenWidth * 0.01 + invWight));
        int invY = (int) (sY + (gp.screenHeight * 0.03));

        int invHigh = (int) (gp.screenHeight * 0.08);
        g2.drawRoundRect(invX, invY, invWight, invHigh, 10, 10);
        gp.text.drawTextInBox(g2, "INV", invX, invY, invWight, invHigh);

        button[1] = new JPanel();
        button[1].setName("Button: 1" );
        button[1].setBounds(invX, invY, invWight, invHigh);
        gp.add(button[1]);
        button[1].setVisible(true);
        button[1].addMouseListener(gp.mous);

        //Buy

        int buyX = (int) (gp.screenWidth/2 - gp.screenWidth*0.08);
        int buyY = (int) (gp.screenHeight * 0.65);
        int buyWight = (int) (( gp.screenWidth*0.08)*2);
        int buyHigh = (int) (gp.screenHeight * 0.08);
        g2.drawRoundRect(buyX, buyY, buyWight, buyHigh, 10, 10);
        gp.text.drawTextInBox(g2, "BUY", buyX, buyY, buyWight, buyHigh);

        button[2] = new JPanel();
        button[2].setName("Button: 2" );
        button[2].setBounds(buyX, buyY, buyWight, buyHigh);
        gp.add(button[2]);
        button[2].setVisible(true);
        button[2].addMouseListener(gp.mous);

        //Random
        int rWight = (int) (gp.screenWidth * 0.12);
        int rX = (int) (gp.screenWidth - (sX + gp.screenWidth * 0.01 + invWight));
        int rY = (int) (sY + (gp.screenHeight * 0.4));

        int rHigh = (int) (gp.screenHeight * 0.08);
        g2.drawRoundRect(rX, rY, rWight, rHigh, 10, 10);
        gp.text.drawTextInBox(g2, "Randome 100€", rX, rY, rWight, rHigh);

        button[3] = new JPanel();
        button[3].setName("Button: 3");
        button[3].setBounds(rX, rY, rWight, rHigh);
        gp.add(button[3]);
        button[3].setVisible(true);
        button[3].addMouseListener(gp.mous);
    }
    public void drawanzeige(){
        int buyX = (int) (gp.screenWidth/2 - gp.screenWidth*0.07);
        int buyY = (int) (gp.screenHeight * 0.61);
        int buyWight = (int) (( gp.screenWidth*0.07)*2);
        int buyHigh = (int) (gp.screenHeight * 0.03);
        g2.drawRoundRect(buyX, buyY, buyWight, buyHigh, 10, 10);
        gp.text.drawTextInBox(g2, "Gold: " + String.valueOf(gp.player.gold), buyX, buyY, buyWight, buyHigh);

        int cX = (int) (sX + (gp.screenWidth * 0.01));
        int cY = (int) (gp.screenHeight * 0.7);
        int cWight = (int) ( gp.screenWidth*0.2);
        int cHigh = (int) (gp.screenHeight * 0.03);
       // g2.drawRoundRect(cX, cY, cWight, cHigh, 10, 10);
        gp.text.drawTextInBox(g2, console, cX, cY, cWight, cHigh);
    }
    public void randomeItem(){
        for( int i = 0; i < slot.length ; i++){
            int db;
            if(i == 2){
                db = 3;
            }else {
                 db = (int) (Math.random() * 3 + 1);
            }
            int itemnr = (int) (Math.random() * gp.dba.getcount(db));
            item[i][0] = db;
            item[i][1] = itemnr;
            System.out.println("DB" + db + " " + "Item" + itemnr);


        }
    }
    public void update(){

    }
    public void resetCurser(){
        select = false;
        console = "";
    }
}