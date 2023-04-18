package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI{
    //Standard
    GamePanel gp;
    Graphics2D g2;

    //States
    public int menuState = 2;
    private int oldMenuState;

    final int loadingState = 1;
    final int titleState = 2;
    final int newAndPlayState =3;

    //variable
    public int sellectValueX;
    public int sellectValueY;
    public boolean newsave;
    private int progress;


    //JPanel
    private JPanel slot[]  = new JPanel[10];

    public UI(GamePanel gp) {
        this.gp = gp;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;

        //System.out.println("countX" + countX + " " +"CountY" +  countY);
        g2.setFont(g2.getFont().deriveFont(70F));
        //Draw Background
        drawBackground();

        //remove old State Panel
        if(!(menuState == oldMenuState)){
            gp.removeAll();
            gp.validate();
            gp.repaint();
            oldMenuState = menuState;
            sellectValueX = 0;
            sellectValueY = 0;
        }
        //Draw State
        if(menuState == loadingState) {
            drawLoadingState();
        } else if(menuState == titleState) {
            drawTitleState();
        }else if(menuState == newAndPlayState) {
            drawNewAndPlayState();
        }
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
    public void drawLoadingState(){


        int tX = (int) (0+ gp.screenWidth*0.2);
        int tY = (int) (gp.screenHeight /2.8);
        int twidght = (int) (gp.screenWidth *0.6);

        g2.setColor(Color.RED);
        g2.drawString("Gesundheitswarnung: ",tX,tY - 100);
        g2.setColor(Color.WHITE);
        String text = "Willkommen bei Monster-Hunter! Bevor du startest, m�chten wir dich darauf hinweisen, dass es wichtig ist, auf deine Gesundheit zu achten. Wir empfehlen, w�hrend jeder Spielstunde des Spielens regelm��ige eine Pause von 15 Minuten einzulegen, um eine �beranstrengung zu vermeiden. Wenn du k�rperliche Beschwerden wie M�digkeit oder Schmerzen versp�rst, solltest du das Spiel unterbrechen und dich ausruhen. Bitte sorge au�erdem daf�r, dass du in einer angenehmen Sitzposition sitzt und ausreichend beleuchtet bist, um deine Augen zu schonen. Vielen Dank f�r deine Aufmerksamkeit und viel Spa� beim Spielen!";
        Font font = new Font("Arial", Font.PLAIN, 25);
        g2.setFont(font);
        gp.text.drawTextBetweenBox(g2,text,tX,tY,twidght);


        int x = (int) (gp.screenWidth/1.2);
        int y = (int) (gp.screenHeight /1.2);
        g2.drawString("Loading...", x, y);
        g2.drawRect(x, y + 10, 200, 20);
        g2.fillRect(x, y+ 10, (int) (progress * 0.4), 20);

        progress ++;
        if(progress >= 500){
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            progress =0;
            menuState = titleState;
        }
    }
    public void drawTitleState(){
        String text;
        g2.setColor(Color.WHITE);

        //Character
        BufferedImage cha = null;
        try {
            cha = ImageIO.read(UI.class.getResource("/player/default/playerc2.png"));//player/playercc.png
        } catch (IOException e) {
            System.out.println("Home screen loading error!!");
        }
        int chax = (int) (gp.screenWidth * 0.57);
        int chay = (int) (gp.screenHeight*0.25);
        int chaWight = (int) (chax * 0.6);
        int chaHigh = (int) (gp.screenHeight * 0.63);

        g2.drawImage(cha, chax , chay, chaWight, chaHigh, null);


        //Game Name Title

        //umrandung
        int textrX = (int) (gp.screenWidth *0.05);
        int textrY = (int) (gp.screenHeight *0.083);
        int textrWight = gp.screenWidth - 2*textrX;
        int textrHigh = (int) (100);

        g2.drawRoundRect(textrX, textrY, textrWight, textrHigh, 10, 10);
        text = "Monster - Hunter";
        gp.text.drawTextInBox(g2,text,textrX,textrY,textrWight,textrHigh);


        //Kasten
        int kX = (int) (gp.screenWidth * 0.05);
        int kY = (int) (gp.screenHeight * 0.31);
        int kWight = (int) (gp.screenWidth * 0.4);
        int kHigh = 100;
        int ab = (int) ( kHigh + (gp.screenHeight * 0.06));

        text = "New Game";
        gp.text.drawTextInBox(g2,text,kX,kY + ab*0,kWight,kHigh);
        g2.drawRoundRect(kX,kY + ab*0,kWight,kHigh,10,10);

        text = "Play";
        gp.text.drawTextInBox(g2,text,kX,kY + ab*1,kWight,kHigh);
        g2.drawRoundRect(kX,kY + ab*1,kWight,kHigh,10,10);

        text = "Settings";
        gp.text.drawTextInBox(g2,text,kX,kY + ab*2,kWight,kHigh);
        g2.drawRoundRect(kX,kY + ab*2 ,kWight,kHigh,10,10);

        text = "Exit";
        gp.text.drawTextInBox(g2,text,kX,kY + ab*3,kWight,kHigh);
        g2.drawRoundRect(kX,kY + ab*3 ,kWight,kHigh,10,10);


        //Select Title
        for( int i = 0; i< 4; i++){
            //Create Panel for Mouse
            slot[i] = new JPanel();
            slot[i].setBounds(kX,kY + ab*i,kWight,kHigh);
            slot[i].setName("Tile Screen: " + i);
            slot[i].addMouseListener(gp.mous);
            gp.add(slot[i]);
            slot[i].setVisible(true);

            g2.setColor(Color.white);
            g2.drawRoundRect(kX, kY, kWight, kHigh, 10, 10);

        }

        //Draw select Green
        g2.setColor(Color.green);
        g2.drawRoundRect(kX, kY + ab*sellectValueY, kWight, kHigh, 10, 10);

    }
    public void drawNewAndPlayState() {
        //Variable for Values
        g2.setColor(Color.WHITE);
        String text;


        //check new or play
        if (newsave) {
            text = "New Game";
        } else {
            text = "Gespeicherte Spiele";
        }

        //Draw Game.Text

        //umrandung
        int textrX = (int) (gp.screenWidth * 0.05);
        int textrY = (int) (gp.screenHeight * 0.083);
        int textrWight = gp.screenWidth - 2 * textrX;
        int textrHigh = (int) (100);
        g2.drawRoundRect(textrX, textrY, textrWight, textrHigh, 10, 10);

        gp.text.drawTextInBox(g2,text,textrX,textrY,textrWight,textrHigh);


        //kasten
        int kX = (int) (gp.screenWidth * 0.08);
        int kY = (int) (gp.screenHeight * 0.3);
        int kWight = (int) (gp.screenWidth * 0.38);
        int kHigh = (int) (gp.screenHeight * 0.11);
        int xab = kWight + (int) (gp.screenWidth * 0.076);
        int yab = kHigh + (int) (gp.screenHeight * 0.15);
        int i = 0;

        Font oldfront = g2.getFont();
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 2; x++) {
                g2.setFont(oldfront);
                //Create Panel for Mouse
                slot[i] = new JPanel();
                slot[i].setBounds(kX + x * xab, kY + y * yab, kWight, kHigh);
                slot[i].setName("Save Screen: " + i);
                slot[i].addMouseListener(gp.mous);
                gp.add(slot[i]);
                slot[i].setVisible(true);

                g2.setColor(Color.white);
                g2.drawString("Game " + String.valueOf(i + 1), kX + x * xab, kY + y * yab);


                if(gp.config.load(i,"used") == 0) {
                    g2.drawString("nicht verwendet", kX + x * xab, kY + y * yab+kHigh/2);
                }else{
                    gp.text.draw3StringsInBox(g2,"Leben " + gp.config.load(gp.save, "leben") ,"Gold " + gp.config.load(gp.save, "gold"),"",kX + x*xab,kY + y*yab, kWight,kHigh);
                }
                g2.drawRoundRect(kX + x * xab, kY + y * yab, kWight, kHigh, 10, 10);
                i++;
            }
        }

        //Back Button
        int bX = (int) (gp.screenWidth * 0.25);
        int bY = (int) (gp.screenHeight * 0.8);
        int bWight = (int) (gp.screenWidth * 0.38);
        int bHigh = (int) (gp.screenHeight * 0.11);
        text = "Back";
        gp.text.drawTextInBox(g2,text,bX,bY,bWight,bHigh);
        g2.drawRoundRect(bX, bY, bWight, bHigh, 10, 10);
        //Back Create Panel for Mouse
        slot[i] = new JPanel();
        slot[i].setBounds(bX, bY, bWight, bHigh);
        slot[i].setName("Save Screen: Back");
        slot[i].addMouseListener(gp.mous);
        gp.add(slot[i]);
        slot[i].setVisible(true);
        g2.setColor(Color.green);


        //Draw Select Green
        if (sellectValueY == 2) {
            g2.drawRoundRect(bX, bY, bWight, bHigh, 10, 10);
        } else
            g2.drawRoundRect(kX + xab * sellectValueX, kY + yab * sellectValueY, kWight, kHigh, 10, 10);
    }


    public void setShadow( String text,int x, int y, Color color){
        g2.setColor(color);
        g2.drawString(text,x+5,y+5);
    }

    public int setTextCenter(String text, int x, int width){
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int xOffset = (width - textWidth) / 2;
        return x + xOffset;
    }

    public int getXfromText(String txt){
        int lenght = (int) g2.getFontMetrics().getStringBounds(txt,g2).getWidth();
        int x = - lenght/2;
        return x;

    }


}
