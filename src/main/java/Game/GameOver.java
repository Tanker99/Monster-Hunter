package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameOver {

    GamePanel gp;
    Graphics2D g2;


    GameOver(GamePanel gp){
        this.gp = gp;

    }
    public void draw(Graphics2D g2){
        this.g2 = g2;

        gp.config.copyFile(4,gp.save);
        g2.setColor(Color.black);
       // g2.drawRect(0,0,gp.screenWidth,gp.screenHeight);
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
        g2.setColor(Color.white);
        int bX = (int) (gp.screenWidth / 2 - gp.screenWidth * 0.08);
        int bY = (int) (gp.screenHeight * 0.7);
        int bWight = (int) ((gp.screenWidth * 0.08) * 2);
        int bHigh = (int) (gp.screenHeight * 0.08);

        JPanel button = new JPanel();
        button.setBounds(bX,bY,bWight,bHigh);
        button.setName("BACK");
        button.addMouseListener(gp.mous);
        gp.add(button);
        button.setVisible(true);


        g2.drawRoundRect(bX,bY,bWight,bHigh,10,10);
        gp.text.drawTextInBox(g2,"BACK",bX,bY,bWight,bHigh);

        int tX = (int) (gp.screenWidth / 2 - gp.screenWidth * 0.08);
        int tY = (int) (gp.screenHeight * 0.48);
        int tWight = (int) ((gp.screenWidth * 0.08) * 2);
        int tHigh = (int) (gp.screenHeight * 0.08);

        //g2.drawRoundRect(tX,tY,tWight,tHigh,10,10);
        g2.setColor(Color.RED);
        g2.setFont(g2.getFont().deriveFont(40F));
        gp.text.drawTextInBox(g2,"DU HAST VERLOREN",tX,tY,tWight,tHigh);


        int pX = (int) (gp.screenWidth / 2 - gp.screenWidth * 0.08);
        int pY = (int) (gp.screenHeight * 0.25);
        int pWight = (int) ((gp.screenWidth * 0.08) * 2);
        int pHigh = (int) (gp.screenHeight * 0.2);
        BufferedImage cha = null;
        try {
            cha = ImageIO.read(GameOver.class.getResource("/Background/playertot.png"));
            System.out.println("Home screen loading error!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g2.drawImage(cha,pX,pY,pWight,pHigh,null);


    }
}
