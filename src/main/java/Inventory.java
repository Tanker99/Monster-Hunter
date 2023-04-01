import Items.Waffe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.Color.blue;
import static java.awt.Color.green;

public class Inventory {
    //Standard
    GamePanel gp;
    KeyHandler keyH;
    Graphics2D g2;

    //variable
    public boolean select;
    public int currentSlot;
    public int selectSlot;
    public int currentSlotValueX;
    public int currentSlotValueY;

    //JPanel
    private JPanel slot[] = new JPanel[8];
    private JPanel button[] = new JPanel[3];







    private int panelid = 1;


    public int countX ;
    public int countY;
    public int sellectcountY = 0;

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
        g2.setColor(Color.black);
        g2.drawString("Inventar", gp.screenWidth/2,50);

        g2.drawRoundRect(gp.screenWidth/2,0,200,100,10,10);

    }

    public void drawInventory(){
       // System.err.println(currentSlot);
        //draw Inventory rand
        g2.drawRoundRect(inX,inY,inWight,inHigh,10,10);

        //Draw Slots
        drawSlot();

        //Draw detail/equip Panel
        drawItemPanel();

        // Draw etc Buttons
        drawButton();

        //Move
        drawMove();

    }

    public void drawSlot(){

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


                g2.drawImage(gp.dba.getItem(1,2).getImagee(),sloX+gp.dba.getItem(1,2).getImagee().getWidth(), sloY+ gp.dba.getItem(1,2).getImagee().getHeight(),null );
                g2.drawString("Preis " + gp.dba.getItem(1,2).getGoldwert(), sloX + sloWight / 2,sloY + sloHigh);
                String text = gp.dba.getItem(1,2).getName();
                g2.drawString(text,100,100);
                gp.dba.getItem(1,3).getName();
                String textt = gp.dba.getItem(2,1).getName();
                g2.drawString(textt,200,100);


                 g2.drawImage(gp.dba.getItem(1,2).getImagee(),100,100,null);


            //    g2.drawImage(gp.waffe.getImage(0),100,100,null );
                i++;
            }
        }

    }
    public void drawItemPanel(){
        this.panX = inX + 10;
        this.panY = (int) (inY + inHigh*0.1);
        this.panWight= 200;
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



    }
    public void drawEquipPanel(){
        for(int i = 0; i<=3; i++){
            int ii = i*60 ;
            g2.drawRoundRect(panX + 10, (int) (panY + panHigh*0.15 ) + ii  ,50,50, 10,10);
        }
    }
    public void drawMove(){
        if(select) {
            int sx =selectSlot;
            int sy = 0;
            if(selectSlot > 3){
                sx =selectSlot -4;
                sy = 1 ;
            }
                g2.setColor(blue);
                g2.drawRoundRect(sloX + sx * 200, sloY + sy * 200, sloWight, sloHigh, 10, 10);
            }
            g2.setColor(green);
            g2.drawRoundRect(sloX + currentSlotValueX * 200, sloY + currentSlotValueY * 200, sloWight, sloHigh, 10, 10);



    }
    public void drawButton(){
        this.sonX = (int) (inWight*0.9) + inX;
        this.sonY = (int) (inHigh*0.6) + inY;
        this.sonWight = 100;
        this.sonHigh = 50;
        String[] text = new String[]{"equip", "sell", "back"};

        if(gp.shopEntry){
            g2.drawString(text[1],sonX + 20 ,sonY+ 20+ 1*50);
            g2.drawRoundRect(sonX , sonY + 1 * 50, sonWight, sonHigh, 10, 10);
        }
        if(select){
            g2.drawString(text[0],sonX + 20 ,sonY+ 20+ 0*50);
            g2.drawRoundRect(sonX , sonY + 0 * 50 , sonWight, sonHigh, 10, 10);
        }
        int e = 30;
        g2.drawString(text[2],sonX + 20 ,sonY+ 20+ 2*50 + e);
        g2.drawRoundRect(sonX , sonY + 2 * 50 + e, sonWight, sonHigh, 10, 10);
    }


    public void update() {
    }



    public void resetCurser(){
        currentSlotValueY = 0;
        currentSlotValueX = 0;
        currentSlot = 0;
        select = false;
        selectSlot = 0;
        countX =0;
        countY = 0;
    }

    public int getx(Graphics2D g2,String text){
        int lenght = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = lenght/2;
        return x;
    }
}



