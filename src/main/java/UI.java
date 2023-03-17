import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI{

    GamePanel gp;
    Graphics2D g2;

    public int countX;
    public int countY;
    public int countYMax;
    public int countXMax;


    public int menustate;
    private int oldmenustate;

    public boolean newsave = false;
    public int newandplaystat = 2;
    public int settingsstate = 3;
    private JPanel test[] = new JPanel[6];
    public Container container;


    public UI(GamePanel gp) {

        this.gp = gp;
    }
    public void draw(Graphics2D g2){
        //System.out.println("countX" + countX + " " +"CountY" +  countY);

        this.g2 = g2;

        //Hintergrund
        BufferedImage back = null;
        try {
            back = ImageIO.read(Player.class.getResource("/back.png"));
            g2.drawImage(back, 0, 0, gp.screenWidth, gp.screenHeight, null);
        } catch (IOException e) {
            System.out.println("Error Loading Background");
        }
        g2.setFont(g2.getFont().deriveFont(70F));


        if(!(menustate == oldmenustate)){
            gp.removeAll();
            gp.validate();
            gp.repaint();
            oldmenustate = menustate;
            countX =0;
            countY = 0;
        }
        if (menustate == 0) {
            titleScreen();
        }
        if(menustate == newandplaystat){
            newAndPlayScreen();
        }else if(menustate == settingsstate){
            settingsScreen();
        }

    }
    public void titleScreen() {




        //charakter

        BufferedImage cha = null;
        try {
            cha = ImageIO.read(Player.class.getResource("cha.png"));
        } catch (IOException e) {
            System.out.println("Home screen loading error!!");
        }
        int chax = (int) (gp.screenWidth * 0.57);
        int chay = (int) (gp.screenHeight*0.25);
        int chaWight = (int) (chax * 0.6);
        int chaHigh = (int) (gp.screenHeight * 0.63);

        g2.drawImage(cha, chax , chay, chaWight, chaHigh, null);


        //Game name Title
        int textX;
        int textY;
        String text;


        text = "Hunter Game";
        textX =  gp.screenWidth/2 + getXTxt(text);
        textY = (int) (gp.screenHeight * 0.15);

        g2.setColor(Color.WHITE);
        g2.drawString(text, textX, textY);


        //umrandung
        int textrX = (int) (gp.screenWidth *0.05);
        int textrY = (int) (gp.screenHeight *0.083);
        int textrWight = gp.screenWidth - 2*textrX;
        int textrHigh = (int) (100);
        g2.drawRoundRect(textrX, textrY, textrWight, textrHigh, 10, 10);

        //Kasten

        int kX = (int) (gp.screenWidth * 0.05);
        int kY = (int) (gp.screenHeight * 0.31);
        int kWight = (int) (gp.screenWidth * 0.4);
        int kHigh = 100;
        int ab = (int) ( kHigh + (gp.screenHeight * 0.06));

        text = "New Game";
        g2.drawString(text, kWight + getXTxt(text),kY + ab*0 );
        g2.drawRoundRect(kX,kY + ab*0,kWight,kHigh,10,10);

        text = "Play";
        g2.drawString(text, kWight + getXTxt(text), kY + ab*1);
        g2.drawRoundRect(kX,kY + ab*1,kWight,kHigh,10,10);

        text = "Settings";
        g2.drawString(text, kWight + getXTxt(text), kY + ab*2);
        g2.drawRoundRect(kX,kY + ab*2 ,kWight,kHigh,10,10);

        text = "Exit";
        g2.drawString(text, kWight + getXTxt(text), kY + ab*3);
        g2.drawRoundRect(kX,kY + ab*3 ,kWight,kHigh,10,10);





        for( int i = 0; i< 4; i++){
            g2.setColor(Color.white);
            g2.drawRoundRect(kX, kY, kWight, kHigh, 10, 10);

            // Panel für mous Listener
            test[i] = new JPanel();
            test[i].setName(String.valueOf(i));
            test[i].setBounds(kX,kY + ab*i,kWight,kHigh);
            gp.add(test[i]);
            test[i].setVisible(true);
            test[i].addMouseListener(gp.mous);
        }
        g2.setColor(Color.green);
        g2.drawRoundRect(kX, kY + ab*countY, kWight, kHigh, 10, 10);

    }

    public void newAndPlayScreen() {
        int textX;
        int textY;
        String text;

        g2.setFont(g2.getFont().deriveFont(70F));
        if (newsave) {
            text = "New Game";
        } else {
            text = "Gespeicherte Spiele";
        }
        textX = gp.screenWidth / 2 + getXTxt(text);
        textY = (int) (gp.screenHeight * 0.15);

        g2.setColor(Color.WHITE);
        g2.drawString(text, textX, textY);


        //umrandung
        int textrX = (int) (gp.screenWidth * 0.05);
        int textrY = (int) (gp.screenHeight * 0.083);
        int textrWight = gp.screenWidth - 2 * textrX;
        int textrHigh = (int) (100);
        g2.drawRoundRect(textrX, textrY, textrWight, textrHigh, 10, 10);


        //kasten

        int kX = (int) (gp.screenWidth * 0.08);
        int kY = (int) (gp.screenHeight * 0.3);
        int kWight = (int) (gp.screenWidth * 0.38);
        int kHigh = (int) (gp.screenHeight * 0.11);
        int xab = kWight + (int) (gp.screenWidth * 0.076);
        int yab = kHigh + (int) (gp.screenHeight * 0.15);
        int i = 0;
        for (int y = 0; y < 2; y++) {

            for (int x = 0; x < 2; x++) {
                g2.setColor(Color.white);
                g2.drawRoundRect(kX + x * xab, kY + y * yab, kWight, kHigh, 10, 10);

                // Panel für mous Listener
                test[i] = new JPanel();
                test[i].setName(String.valueOf(i));
                g2.drawString("Game " + String.valueOf(i + 1),kX + x * xab, kY + y * yab);
                test[i].setBounds(kX + x * xab, kY + y * yab, kWight, kHigh);
                gp.add(test[i]);
                test[i].setVisible(true);
                test[i].addMouseListener(gp.mous);
                i++;
            }
        }
        //back
        int bX = (int) (gp.screenWidth * 0.25);
        int bY = (int) (gp.screenHeight * 0.8);
        int bWight = (int) (gp.screenWidth * 0.38);
        int bHigh = (int) (gp.screenHeight * 0.11);
        text = "Back";
        g2.drawString(text, bX ,bY);
        g2.drawRoundRect(bX, bY, bWight, bHigh, 10, 10);
        test[4] = new JPanel();
        test[4].setName(String.valueOf(4));
        test[4].setBounds(bX, bY, bWight, bHigh);
        gp.add(test[4]);
        test[4].setVisible(true);
        test[4].addMouseListener(gp.mous);

        g2.setColor(Color.green);
        if (countY == 2) {
            g2.drawRoundRect(bX,bY,bWight,bHigh, 10, 10);
        } else
            g2.drawRoundRect(kX + xab * countX, kY + yab * countY, kWight, kHigh, 10, 10);
    }



    public void settingsScreen(){
        String text;
        //back
        int bX = (int) (gp.screenWidth * 0.25);
        int bY = (int) (gp.screenHeight * 0.8);
        int bWight = (int) (gp.screenWidth * 0.38);
        int bHigh = (int) (gp.screenHeight * 0.11);
        text = "Back";
        g2.setColor(Color.WHITE);
        g2.drawString(text, bX ,bY);
        g2.drawRoundRect(bX, bY, bWight, bHigh, 10, 10);
        test[4] = new JPanel();
        test[4].setName(String.valueOf(4));
        test[4].setBounds(bX, bY, bWight, bHigh);
        gp.add(test[4]);
        test[4].setVisible(true);
        test[4].addMouseListener(gp.mous);

        g2.setColor(Color.green);
            g2.drawRoundRect(bX,bY,bWight,bHigh, 10, 10);



    }





    public void setShadow( String text,int x, int y, Color color){
        g2.setColor(color);
        g2.drawString(text,x+5,y+5);
    }

    public int getxCenter(String text){
        int lenght = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - lenght/2;
        return x;
    }
    public int getXTxt(String txt){
        int lenght = (int) g2.getFontMetrics().getStringBounds(txt,g2).getWidth();
        int x = - lenght/2;
        return x;

    }


}
