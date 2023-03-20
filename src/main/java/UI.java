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
    public int menuState = 1;
    private int oldMenuState;

    final int loadingState = 1;
    final int titleState = 2;
    final int newAndPlayState =3;
    final int settingsState = 4;

    //variable
    public int sellectValueX;
    public int sellectValueY;
    public boolean newsave;
    private int progress;


    //JPanel
    private JPanel slot[] = new JPanel[6];

    public UI(GamePanel gp) {
        this.gp = gp;
    }
    public void draw(Graphics2D g2){
        System.out.println("dsad");
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
        }else if(menuState == settingsState) {
           // drawSettingsState();
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
        g2.setColor(Color.WHITE);
        g2.drawString("Loading...", gp.screenWidth/2 - 200, 420);
        g2.drawRect(gp.screenWidth/2- 200, 450, 200, 20);
        g2.fillRect(gp.screenWidth/2 - 200, 450, (int) (progress * 0.8), 20);

        progress ++;
        if(progress >= 250){
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

        //Character
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


        //Game Name Title
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
        int textX;
        int textY;
        String text;


        //check new or play
        if (newsave) {
            text = "New Game";
        } else if (!(newsave)) {
            text = "Gespeicherte Spiele";
        } else {
            System.err.println("ERROR in drawNewAndPlayState");
            text = "ERROR";
        }

        //Draw Text
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
                //Create Panel for Mouse
                slot[i] = new JPanel();
                slot[i].setBounds(kX + x * xab, kY + y * yab, kWight, kHigh);
                slot[i].setName("Save Screen: " + i);
                slot[i].addMouseListener(gp.mous);
                gp.add(slot[i]);
                slot[i].setVisible(true);

                g2.setColor(Color.white);
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
        g2.drawString(text, bX, bY);
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
    /*




    public void newAndPlayScreen() {



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

     */





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
