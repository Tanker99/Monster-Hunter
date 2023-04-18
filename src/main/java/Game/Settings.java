package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Settings {
    //Standard
    GamePanel gp;
    Graphics2D g2;

    //JPanel
    private JPanel slot[]  = new JPanel[10];

    public Settings(GamePanel gp){
        this.gp = gp;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(g2.getFont().deriveFont(70F));
        drawBackground();

        drawSettingsState();
    }
    public void drawBackground(){
        BufferedImage back = null;
        try {
            back = ImageIO.read(Player.class.getResource("/back.png"));
            g2.drawImage(back, 0, 0, gp.screenWidth, gp.screenHeight, null);
        } catch (IOException e) {
            System.out.println("Error Loading Background");
        }
    }
    public void drawSettingsState(){
        String text;
        //Kasten
        int kX = (int) (gp.screenWidth/2 - (gp.screenWidth * 0.4)/2);
        int kY = (int) (gp.screenHeight * 0.1);
        int kWight = (int) (gp.screenWidth * 0.4);
        int kHigh = 100;
        int ab = (int) ( kHigh + (gp.screenHeight * 0.09));

        String[] textt = {"Full Screen","Music" , "Se", "Controll", "Back" , "Save & Quit"};
        String[] texth = {"+", "-"};

        for( int i = 0; i< 4; i++) {
            //Create Panel for Mouse
            slot[i] = new JPanel();
            slot[i].setBounds(kX, kY + ab * i, kWight, kHigh);
            slot[i].setName("Setting Screen: " + i);
            slot[i].addMouseListener(gp.mous);
            gp.add(slot[i]);
            slot[i].setVisible(true);


            g2.setColor(Color.white);
            gp.text.drawTextInBox(g2, textt[i], kX, kY + ab * i, kWight, kHigh);
        }

        //back and save Button
        int t;
        if( gp.settingOldState == gp.uiState) {
            t = 4;
        }else {
            t = 5;
        }
        slot[4] = new JPanel();
        slot[4].setBounds(kX, kY + ab * 4, kWight, kHigh);
        slot[4].setName("Setting Screen: " + textt[t]);
        slot[4].addMouseListener(gp.mous);
        gp.add(slot[4]);
        slot[4].setVisible(true);


        g2.setColor(Color.white);
        gp.text.drawTextInBox(g2, textt[t], kX, kY + ab * 4, kWight, kHigh);







            //Kontroll K�sten
            // g2.drawRoundRect(kX,kY + ab*i,kWight,kHigh,10,10);

            //g2.drawRoundRect(kX, kY, kWight, kHigh, 10, 10);
        //+- f�r MUSIK und SE
        BufferedImage symbole1 = null;
        BufferedImage symbole2 = null;
        try {
            symbole1 = ImageIO.read(UI.class.getResource("/symbole/-.png"));
            symbole2 = ImageIO.read(UI.class.getResource("/symbole/+.png"));

        } catch (IOException e) {
            System.out.println("Error Loading Background");
        }

        //Musik
        int musikwight = kWight /6;
        g2.drawRoundRect(kX,kY + ab*1 + kHigh,kWight,kHigh /2,10,10);
        g2.drawImage(symbole1, kX, kY + ab*1 + kHigh, musikwight,kHigh/2,null);
        g2.drawImage(symbole2, kX + kWight - musikwight, kY + ab*1 + kHigh, musikwight,kHigh/2,null);


        //SE
        g2.drawRoundRect(kX,kY + ab*2 + kHigh,kWight,kHigh /2,10,10);
        g2.drawImage(symbole1, kX, kY + ab*2 + kHigh, musikwight,kHigh/2,null);
        g2.drawImage(symbole2, kX + kWight - musikwight, kY + ab*2 + kHigh, musikwight,kHigh/2,null);

        //setzte button

        slot[5] = new JPanel();
        slot[6] = new JPanel();
        slot[7] = new JPanel();
        slot[8] = new JPanel();
        slot[5].setBounds(kX, kY + ab*1 + kHigh, musikwight,kHigh/2);
        slot[6].setBounds(kX + kWight - musikwight, kY + ab*1 + kHigh, musikwight,kHigh/2);
        slot[7].setBounds(kX, kY + ab*2 + kHigh, musikwight,kHigh/2);
        slot[8].setBounds(kX + kWight - musikwight, kY + ab*2 + kHigh, musikwight,kHigh/2);
        slot[5].setName("Musik: -");
        slot[6].setName("Musik: +");
        slot[7].setName("SE: -");
        slot[8].setName("SE: +");
        for (int i = 5; i< 9; i++) {
            slot[i].addMouseListener(gp.mous);
            gp.add(slot[i]);
            slot[i].setVisible(true);
        }


        //Draw select Green
        g2.setColor(Color.green);
     //   g2.drawRoundRect(kX, kY + ab * sellectValueY, kWight, kHigh, 10, 10);



    }
    public void drawControllState(){
        int kX = (int) (gp.screenWidth/2 - (gp.screenWidth * 0.4)/2);
        int kY = (int) (gp.screenHeight * 0.1);
        int kWight = (int) (gp.screenWidth * 0.4);
        int kHigh = 100;
        int ab = (int) ( kHigh + (gp.screenHeight * 0.09));

        BufferedImage back = null;
        try {
            back = ImageIO.read(Player.class.getResource("/PCControl.png"));
            g2.drawImage(back, 0, 0, gp.screenWidth, gp.screenHeight, null);
        } catch (IOException e) {
            System.out.println("Error Loading Background");
        }
        String text = "Back";

        slot[0] = new JPanel();
        slot[0].setBounds(kX, kY + ab * 4, kWight, kHigh);
        slot[0].setName("Controll Screen: " + text);
        slot[0].addMouseListener(gp.mous);
        gp.add(slot[0]);
        slot[0].setVisible(true);

        g2.drawRoundRect(kX, kY, kWight, kHigh, 10, 10);
        gp.text.drawTextInBox(g2, text, kX, kY + ab * 4, kWight, kHigh);
    }
}
