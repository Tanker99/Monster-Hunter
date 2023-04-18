package Game;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.blue;
import static java.awt.Color.green;

public class TickTackToe {
    //Standard
    GamePanel gp;
    Graphics2D g2;


    //variable
    int difficult = 0;
    boolean start = false;
    public int slotState[] = new int[9];
    int maxWight;
    int maxHight;
    int x;
    int y;
    int fWight;
    int fHigh;
    public  int amZug = 1;
    public  int gewinner;
    public  boolean end;

    public int currentSlotValueY;
    public int currentSlotValueX;
    public int currentSlot;


    //JPanel
    private JPanel slot[] = new JPanel[9];
    private JPanel button[] = new JPanel[4];


    public TickTackToe(GamePanel gp){
        x = (int) (gp.screenWidth * 0.25);
        y = (int) (gp.screenHeight * 0.25);
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
            end = true;
        }
        if(end){
            drawEnd();
            drawButton();
        }

        drawname();
        drawBack();
        drawLabel();

        tickTackToe();
        drawSlotState();
        drawMove();
        if(amZug == 2) {
            if (difficult == 0) {
                kiEasy();
            } else if (difficult == 1) {
                kiMedium();
            } else {
                kiMedium();
            }
        }

    }
    public void drawname() {
        int nX = (int) (gp.screenWidth / 2 - gp.screenWidth * 0.08);
        int nY = (int) (gp.screenHeight * 0.1);
        int nWight = (int) ((gp.screenWidth * 0.08) * 2);
        int nHigh = (int) (gp.screenHeight * 0.08);

        g2.setFont(g2.getFont().deriveFont(30F));
        gp.text.drawTextInBox(g2, "TIKTAKTOE", nX, nY, nWight, nHigh);
        g2.drawRect(nX, nY, nWight, nHigh);


    }
    public void drawLabel() {
        int lX = (int) (gp.screenWidth * 0.8);
        int lY = (int) (gp.screenHeight * 0.26);
        int lWight = (int) ((gp.screenWidth * 0.08) * 2);
        int lHigh = (int) (gp.screenHeight * 0.08);
        int lab = (int) (lHigh + gp.screenHeight * 0.02);

        String[] text = {"Du bist X", "Spiel: Leicht","Spiel: Mittel","Spiel: Schwer"};

        g2.setFont(g2.getFont().deriveFont(18F));
        gp.text.drawTextInBox(g2, text[0], lX, lY + 0*lab, lWight, lHigh);
        g2.drawRect(lX, lY + 0*lab, lWight, lHigh);

        button[1] = new JPanel();
        button[1].setBounds(lX, lY + 1*lab, lWight, lHigh);
        button[1].setName("difficult");
        button[1].addMouseListener(gp.mous);
        gp.add(button[1]);
        button[1].setVisible(true);
        g2.setFont(g2.getFont().deriveFont(18F));
        gp.text.drawTextInBox(g2, text[1 + difficult], lX, lY + 1*lab, lWight, lHigh);
        g2.drawRect(lX, lY + 1*lab, lWight, lHigh);


    }
    public void drawButton(){
        int lX = (int) (gp.screenWidth * 0.8);
        int lY = (int) (gp.screenHeight * 0.26);
        int lWight = (int) ((gp.screenWidth * 0.08) * 2);
        int lHigh = (int) (gp.screenHeight * 0.08);
        int lab = (int) (lHigh + gp.screenHeight * 0.02);

        button[2] = new JPanel();
        button[2].setBounds(lX, lY + 2*lab, lWight, lHigh);
        button[2].setName("restart");
        button[2].addMouseListener(gp.mous);
        gp.add(button[2]);
        button[2].setVisible(true);
        g2.setFont(g2.getFont().deriveFont(18F));
        gp.text.drawTextInBox(g2, "restart", lX, lY + 2*lab, lWight, lHigh);
        g2.drawRect(lX, lY + 2*lab, lWight, lHigh);
    }
    public void drawBack(){
    int bX = (int) (gp.screenWidth * 0.8);
    int bY = (int) (gp.screenHeight * 0.8);
    int bWight = (int) ((gp.screenWidth * 0.08) * 2);
    int bHigh = (int) (gp.screenHeight * 0.08);


    button[0] = new JPanel();
    button[0].setBounds(bX, bY , bWight, bHigh);
    button[0].setName("Back");
    button[0].addMouseListener(gp.mous);
    gp.add(button[0]);
    button[0].setVisible(true);
    g2.setFont(g2.getFont().deriveFont(18F));

    gp.text.drawTextInBox(g2, "Back", bX, bY , bWight, bHigh);
    g2.drawRect(bX, bY , bWight, bHigh);
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

    }
    public void drawMove(){
        g2.setColor(green);
        if(!(end)) {
            g2.drawRoundRect(x + currentSlotValueX * fWight, y + currentSlotValueY * fHigh, (int) (maxWight * 0.33), (int) (maxHight * 0.33), 0, 0);
        }
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
        if(!(slotState[0] == 0) && !(slotState[1] == 0) && !(slotState[2] == 0) && !(slotState[3] == 0) && !(slotState[4] == 0) && !(slotState[5] == 0) && !(slotState[6] == 0) && !(slotState[7] == 0) && !(slotState[8] == 0)){
            end = true;
        }
    }
    public void drawEnd(){
        String text = null;
        if(gewinner == 1){
            gp.player.gold = gp.player.gold + 5 + difficult * 5;
            text = "X";
        }else if(gewinner == 2){
            text = "O";
        }else {
            text = "Niemand";
        }
        int x = (int) (gp.screenWidth * 0.83);
        int y = (int) (gp.screenHeight * 0.65);
        g2.setFont(g2.getFont().deriveFont(18F));
        g2.drawString(text + " hat Gewonnen", x,  y);
    }
    public void kiEasy(){
        int randomNumber = (int) (Math.random() * 9);
        System.out.println(randomNumber);
        if(slotState[randomNumber] == 0){
            slotState[randomNumber] = 2;
            amZug = 1;
        }
    }
    public void kiMedium() {
        for (int i = 1; i < 3; i++) {
            //Horizontal 1
            if (slotState[0] == 1 && slotState[1] == 1 && slotState[2] == 0) {
                slotState[2] = 2;
                amZug = 1;
                break;
            } else if (slotState[0] == 1 && slotState[1] == 0 && slotState[2] == 1) {
                slotState[1] = 2;
                amZug = 1;
                break;
            } else if (slotState[0] == 0 && slotState[1] == 1 && slotState[2] == 1) {
                slotState[0] = 2;
                amZug = 1;
                break;
            }
            //Horizontal 2
            else if (slotState[3] == 1 && slotState[4] == 1 && slotState[5] == 0) {
                slotState[5] = 2;
                amZug = 1;
                break;
            } else if (slotState[3] == 1 && slotState[4] == 0 && slotState[5] == 1) {
                slotState[4] = 2;
                amZug = 1;
                break;
            } else if (slotState[3] == 0 && slotState[4] == 1 && slotState[5] == 1) {
                slotState[3] = 2;
                amZug = 1;
                break;
            }
            //Horizontal 3
            else if (slotState[6] == 1 && slotState[7] == 1 && slotState[8] == 0) {
                slotState[8] = 2;
                amZug = 1;
                break;
            } else if (slotState[6] == 1 && slotState[7] == 0 && slotState[8] == 1) {
                slotState[7] = 2;
                amZug = 1;
                break;
            } else if (slotState[6] == 0 && slotState[7] == 1 && slotState[8] == 1) {
                slotState[6] = 2;
                amZug = 1;
                break;
            }


            //Vertikal 1
            else if (slotState[0] == 1 && slotState[3] == 1 && slotState[6] == 0) {
                slotState[6] = 2;
                amZug = 1;
                break;
            } else if (slotState[0] == 1 && slotState[3] == 0 && slotState[6] == 1) {
                slotState[3] = 2;
                amZug = 1;
                break;
            } else if (slotState[0] == 0 && slotState[3] == 1 && slotState[6] == 1) {
                slotState[0] = 2;
                amZug = 1;
                break;
            }
            //Vertikal 2
            else if (slotState[1] == 1 && slotState[4] == 1 && slotState[7] == 0) {
                slotState[7] = 2;
                amZug = 1;
                break;
            } else if (slotState[1] == 1 && slotState[4] == 0 && slotState[7] == 1) {
                slotState[4] = 2;
                amZug = 1;
                break;
            } else if (slotState[1] == 0 && slotState[4] == 1 && slotState[7] == 1) {
                slotState[1] = 2;
                amZug = 1;
                break;
            }
            //Vertikal 3
            else if (slotState[2] == 1 && slotState[5] == 1 && slotState[8] == 0) {
                slotState[8] = 2;
                amZug = 1;
                break;
            } else if (slotState[2] == 1 && slotState[5] == 0 && slotState[8] == 1) {
                slotState[5] = 2;
                amZug = 1;
                break;
            } else if (slotState[2] == 0 && slotState[5] == 1 && slotState[8] == 1) {
                slotState[2] = 2;
                amZug = 1;
                break;
            }
            //Links rechts 1
            else if (slotState[0] == 1 && slotState[4] == 1 && slotState[8] == 0) {
                slotState[8] = 2;
                amZug = 1;
                break;
            } else if (slotState[0] == 1 && slotState[4] == 0 && slotState[8] == 1) {
                slotState[4] = 2;
                amZug = 1;
                break;
            } else if (slotState[0] == 0 && slotState[4] == 1 && slotState[8] == 1) {
                slotState[0] = 2;
                amZug = 1;
                break;
            }
            //Links rechts 2
            else if (slotState[2] == 1 && slotState[4] == 1 && slotState[6] == 0) {
                slotState[6] = 2;
                amZug = 1;
                break;
            } else if (slotState[2] == 1 && slotState[4] == 0 && slotState[6] == 1) {
                slotState[4] = 2;
                amZug = 1;
                break;
            } else if (slotState[2] == 0 && slotState[4] == 1 && slotState[6] == 1) {
                slotState[2] = 2;
                amZug = 1;
                break;
            }

        }
        if (amZug == 2) {
            int randomNumber = (int) (Math.random() * 9);
            if (slotState[randomNumber] == 0) {
                slotState[randomNumber] = 2;
                amZug = 1;
                System.out.println("eeee");
            }
        }
    }




    public void reset(){
        end = false;
        gewinner = 0;

        for (int i = 0; i< 9; i++){
            slotState[i] = 0;
        }
    }
}



