import javax.swing.*;
import java.awt.*;

import static java.awt.Color.blue;
import static java.awt.Color.green;

public class MiniGame {
    //Standard
    GamePanel gp;
    Graphics2D g2;


    //variable
    public int slotState[] = new int[9];
    int maxWight;
    int maxHight;
    int x;
    int y;
    int fWight;
    int fHigh;
    public  int amZug = 1;
    private  int warAmZug;
    public  int kiState = 2;
    public  int gewinner;

    public int currentSlotValueY;
    public int currentSlotValueX;
    public int currentSlot;


    //JPanel
    private JPanel slot[] = new JPanel[9];


    public MiniGame(GamePanel gp){
        x = 200;
        y = 100;
        maxHight = gp.screenHeight / 2;
        maxWight = gp.screenWidth / 2;
        fWight = (int) (maxWight * 0.33);
        fHigh = (int) (maxHight * 0.33);
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        gewinnerCheck();
        if(gewinner == 1|| gewinner == 2){
            drawEnd();

        }else {
            tickTackToe();
            drawSlotState();
            if(amZug == 2){
                if(kiState == 1){
                    kiEasy();
                }else {
                    kiHard();
                }
            }

        }
    }

    public void tickTackToe() {

        g2.drawRoundRect(x, y, fWight * 3, fHigh * 3, 0, 0);

        // Vertikal
        g2.drawLine(x, y + fHigh, fWight * 3 + x, y + fHigh);
        g2.drawLine(x, y + fHigh * 2, fWight * 3 + x, y + fHigh * 2);

        //Horizontal
        g2.drawLine(x + fWight, y, x + fWight, y + fHigh * 3);
        g2.drawLine(x + fWight * 2, y, x + fWight * 2, y + fHigh * 3);

        //
        int i = 0;
        for (int yi = 0; yi < 3; yi++) {
            for (int xi = 0; xi < 3; xi++) {
                //Create Panel for Mouse
                slot[i] = new JPanel();
                slot[i].setBounds(x + xi * fWight, y + yi * fHigh, (int) (maxWight * 0.33), (int) (maxHight * 0.33));
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

        g2.drawRoundRect(x + currentSlotValueX * fWight, y + currentSlotValueY * fHigh, (int) (maxWight * 0.33), (int) (maxHight * 0.33), 0, 0);
        g2.drawImage(gp.image.imgX, 0, 0, 200, 200, null);

    }

    public void drawSlotState() {
        int i = 0;
        for (int yi = 0; yi < 3; yi++) {
            for (int xi = 0; xi < 3; xi++) {
                if (slotState[i] == 1) {
                    g2.drawImage(gp.image.imgX, x + xi * fWight, y + yi * fHigh, (int) (maxWight * 0.33), (int) (maxHight * 0.33), null);
                } else if (slotState[i] == 2) {
                    g2.drawImage(gp.image.imgO, x + xi * fWight, y + yi * fHigh, (int) (maxWight * 0.33), (int) (maxHight * 0.33), null);
                }
                i++;
            }
        }
    }
    public void gewinnerCheck(){
        for(int i= 1; i< 3; i++) {

            //Horizontal
            if (slotState[0] == i && slotState[1] == i && slotState[2] == i){
                gewinner = i;
            }
            else if(slotState[3] == i && slotState[4] == i && slotState[5] == i){
                gewinner = i;
            }
            else if(slotState[6] == i && slotState[7] == i && slotState[8] == i){
                gewinner = i;
            }
            //Vertikal
            else if(slotState[0] == i && slotState[3] == i && slotState[6] == i){
                gewinner = i;
            }
            else if(slotState[1] == i && slotState[4] == i && slotState[7] == i){
                gewinner = i;
            }
            else if(slotState[2] == i && slotState[5] == i && slotState[8] == i){
                gewinner = i;
            }
            //links rechts
            if (slotState[0] == i && slotState[4] == i && slotState[8] == i){
                gewinner = i;
            }
            else if(slotState[2] == i && slotState[4] == i && slotState[6] == i){
                gewinner = i;
            }
        }
    }
    public void drawEnd(){
        String text = null;
        if(gewinner == 1){
            text = "O";
        }else if(gewinner == 2){
            text = "X";
        }
        g2.drawString(text + " Hat Gewonnen", maxHight/2,  maxWight/2);
    }
    public void kiEasy(){
        int randomNumber = (int) (Math.random() * 9);
        System.out.println(randomNumber);
        if(slotState[randomNumber] == 0){
            slotState[randomNumber] = 2;
            amZug = 1;
        }
    }
    public void kiHard() {
        for(int i= 1; i< 3; i++) {
            //Horizontal 1
            if (slotState[0] == 1 && slotState[1] == 1 && slotState[2] == 0) {
                slotState[2] = 2;
                amZug = 1;
            }else  if (slotState[0] == 1 && slotState[1] == 0 && slotState[2] == 1) {
                slotState[1] = 2;
                amZug = 1;
            }else  if (slotState[0] == 0 && slotState[1] == 1 && slotState[2] == 1) {
                slotState[0] = 2;
                amZug = 1;
            }
            //Horizontal 2
            else if (slotState[3] == 1 && slotState[4] == 1 && slotState[5] == 0) {
                slotState[5] = 2;
                amZug = 1;
            }else  if (slotState[3] == 1 && slotState[4] == 0 && slotState[5] == 1) {
                slotState[4] = 2;
                amZug = 1;
            }else  if (slotState[3] == 0 && slotState[4] == 1 && slotState[5] == 1) {
                slotState[3] = 2;
                amZug = 1;
            }
            //Horizontal 3
            else if (slotState[6] == 1 && slotState[7] == 1 && slotState[8] == 0) {
                slotState[8] = 2;
                amZug = 1;
            }else  if (slotState[6] == 1 && slotState[7] == 0 && slotState[8] == 1) {
                slotState[7] = 2;
                amZug = 1;
            }else  if (slotState[6] == 0 && slotState[7] == 1 && slotState[8] == 1) {
                slotState[6] = 2;
                amZug = 1;
            }


            //Vertikal 1
            else if (slotState[0] == 1 && slotState[3] == 1 && slotState[6] == 0) {
                slotState[6] = 2;
                amZug = 1;
            }else  if (slotState[0] == 1 && slotState[3] == 0 && slotState[6] == 1) {
                slotState[3] = 2;
                amZug = 1;
            }else  if (slotState[0] == 0 && slotState[3] == 1 && slotState[6] == 1) {
                slotState[0] = 2;
                amZug = 1;
            }
            //Vertikal 2
            else if (slotState[1] == 1 && slotState[4] == 1 && slotState[7] == 0) {
                slotState[7] = 2;
                amZug = 1;
            }else  if (slotState[1] == 1 && slotState[4] == 0 && slotState[7] == 1) {
                slotState[4] = 2;
                amZug = 1;
            }else  if (slotState[1] == 0 && slotState[4] == 1 && slotState[7] == 1) {
                slotState[1] = 2;
                amZug = 1;
            }
            //Vertikal 3
            else if (slotState[2] == 1 && slotState[5] == 1 && slotState[8] == 0) {
                slotState[8] = 2;
                amZug = 1;
            }else  if (slotState[2] == 1 && slotState[5] == 0 && slotState[8] == 1) {
                slotState[5] = 2;
                amZug = 1;
            }else  if (slotState[2] == 0 && slotState[5] == 1 && slotState[8] == 1) {
                slotState[2] = 2;
                amZug = 1;
            }else {
                kiEasy();
            }



            /*
            //links rechts
            if (slotState[0] == i && slotState[4] == i && slotState[8] == i) {
                gewinner = i;
            } else if (slotState[2] == i && slotState[4] == i && slotState[6] == i) {
                gewinner = i;
            }

             */
        }
    }


    public void reset(){
        for (int i = 0; i< 9; i++){
            slotState[i] = 0;
        }
    }
}



