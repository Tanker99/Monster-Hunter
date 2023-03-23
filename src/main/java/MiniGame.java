import javax.swing.*;
import java.awt.*;

import static java.awt.Color.blue;
import static java.awt.Color.green;

public class MiniGame {
    //Standard
    GamePanel gp;
    Graphics2D g2;


    //variable
    int maxWight;
    int maxHight;
    int x;
    int y;

    public int currentSlotValueY;
    public int currentSlotValueX;
    public int currentSlot;


    //JPanel
    private JPanel slot[]  = new JPanel[9];


    public MiniGame(GamePanel gp){
        x = 200;
        y = 100;
        maxHight = gp.screenHeight/2;
        maxWight = gp.screenWidth /2;
        this.gp = gp;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;
        tickTackToe();


    }
    public void tickTackToe(){
        int fWight = (int) (maxWight * 0.33);
        int fHigh = (int) (maxHight * 0.33);
        g2.drawRoundRect(x,y,fWight *3,fHigh*3 ,0,0);

        // Vertikal
        g2.drawLine(x, y +fHigh,fWight *3 + x,y + fHigh);
        g2.drawLine(x, y +fHigh *2,fWight *3 + x,y + fHigh*2);

        //Horizontal
        g2.drawLine(x +fWight , y ,x + fWight,y + fHigh *3);
        g2.drawLine(x +fWight*2 , y ,x +fWight *2,y + fHigh *3);

        //
        int i = 0;
        for (int yi = 0; yi < 3; yi++) {
            for( int xi = 0; xi < 3; xi++) {
                //Create Panel for Mouse
                slot[i] = new JPanel();
                slot[i].setBounds(x + xi * fWight,y + yi* fHigh ,(int) (maxWight * 0.33),  (int) (maxHight * 0.33));
                slot[i].setName("Slot: " + i);
                slot[i].addMouseListener(gp.mous);
                gp.add(slot[i]);
                slot[i].setVisible(true);
                i++;
                g2.setColor(blue);
               // g2.drawRoundRect(x + xi * fWight,y + yi* fHigh ,(int) (maxWight * 0.33),  (int) (maxHight * 0.33),0,0);
            }
        }
        g2.setColor(green);

        g2.drawRoundRect(x + currentSlotValueX * fWight,y + currentSlotValueY* fHigh ,(int) (maxWight * 0.33),  (int) (maxHight * 0.33),0,0);
        g2.drawImage(gp.image.imgX,0,0,200,200,null);

    }


















}
