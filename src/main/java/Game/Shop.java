package Game;

import javax.swing.*;
import java.awt.*;

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


    //JPanel

    private JPanel slot[] = new JPanel[4];
    public int item[][] = new int[4][2];

    public Shop(GamePanel gp){
        this.gp = gp;
    }
    public void draw (Graphics2D g2){
        this.g2 = g2;

        if(test){
            test = false;
            randomeItem();
        }


        drawShop();

        drawItems();

    }

    public void drawShop(){
        this.sX = (int) (gp.screenWidth * 0.01);
        this.sY = gp.screenHeight/4 ;
        this.sWight = gp.screenWidth - 2 * sX;
        this.sHigh = gp.screenHeight /2 ;

        g2.drawRoundRect(sX,sY,sWight,sHigh,10,10);
    }
    public void drawItems(){

        int iX = (int) (gp.screenWidth* 0.1);
        int iY = (int) (gp.screenHeight * 0.45);
        int iWight = 100;
        int iHigh = 100;
        int iab = 100;

        for( int i = 0; i < 2; i++) {
            slot[i] = new JPanel();
            slot[i].setName("Item: " + i);
            slot[i].setBounds(iX +i*(iX + iWight), iY, iWight, iHigh);
            gp.add(slot[i]);
            slot[i].setVisible(true);
            slot[i].addMouseListener(gp.mous);

            g2.drawRoundRect(iX +i*(iX + iWight), iY, iWight, iHigh, 10, 10);
            g2.drawImage(gp.dba.getItem(item[i][0],item[i][1]).getImagee(),iX +i*(iX + iWight), iY,null);

        }
        int ii = 2;
        for( int i = 0; i < 2; i++) {
            slot[ii] = new JPanel();
            slot[ii].setName("Item: " + ii);
            slot[ii].setBounds(iX +i*(iX + iWight) +  gp.screenWidth/2, iY, iWight, iHigh);
            gp.add(slot[ii]);
            slot[ii].setVisible(true);
            slot[ii].addMouseListener(gp.mous);
            g2.drawRoundRect( iX +i*(iX + iWight) +  gp.screenWidth/2, iY, iWight, iHigh, 10, 10);
            g2.drawImage(gp.dba.getItem(item[ii][0],item[ii][1]).getImagee(),iX +i*(iX + iWight) +  gp.screenWidth/2,iY,null);
            ii++;
        }


    }
    public void randomeItem(){
        for( int i = 0; i < slot.length; i++){
            int db = (int) (Math.random() * 3 + 1);
            int itemnr = (int) (Math.random() * gp.dba.getcount(db));
            item[i][0] = db;
            item[i][1] = itemnr;
            System.out.println("DB" + db + " " + "Item" + itemnr);

        }
    }
}