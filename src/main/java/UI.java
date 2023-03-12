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


    private int menustate;
    private int playstate;
    private int newstate;
    private int settingsstate;
    private JPanel test[] = new JPanel[4];
    public Container container;


    public UI(GamePanel gp) {

        this.gp = gp;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        if (menustate == 0) {
            titleScreen();
        }else if(menustate == playstate){
            playScreen();
        }else if(menustate == newstate){
            newScreen();
        }else if(menustate == settingsstate){
            settingsScreen();
        }

    }
    public void titleScreen(){

        int textX;
        int textY;
        String text;

        //Hintergrund
        BufferedImage back = null;
        try {
            back = ImageIO.read(Player.class.getResource("/back.png"));
            g2.drawImage(back, 0, 0, gp.screenWidth, gp.screenHeight, null);
        } catch (IOException e) {
            System.out.println("Error Loading Background");
        }
        //Game name Title
        text = "Hunter Game";
        textX = getxCenter(text);
        textY = gp.titleSize;

        g2.drawString(text, textX, textY);

        BufferedImage cha = null;
        try {
            cha = ImageIO.read(Player.class.getResource("cha.png"));
        } catch (IOException e) {
            System.out.println("Home screen loading error!!");
        }
        int xcha = cha.getWidth();
        g2.drawImage(cha, gp.screenWidth / 2 - xcha, 300, 200, 200, null);


        //umrandung
        int rX = gp.screenWidth / 4;
        int rY = gp.screenHeight / 2;
        int rWight = gp.screenWidth / 2;
        int rHigh = (int) (gp.screenHeight / 2.2);
        g2.drawRoundRect(rX, rY, rWight, rHigh, 10, 10);

        //Text
        textX = rX / 2;
        textY = rY;
        g2.setColor(Color.white);
        text = "New Game";
        g2.drawString(text, getxCenter(text), textY + gp.titleSize);
        text = "Play";
        g2.drawString(text, getxCenter(text), textY + gp.titleSize);
        text = "Settings";
        g2.drawString(text, getxCenter(text), textY + gp.titleSize);
        text = "Exit";
        g2.drawString(text, getxCenter(text), textY + gp.titleSize);


        //Kasten

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));

        int kX;
        int kY;
        int kWight;
        int kHigh;


         kWight = (int) (rWight - 2*rWight*0.01);
         kHigh = (int) (rHigh * 1/4 - 2*rHigh*0.01);
         kX = (int) (rX + rWight*0.01);



        for( int i = 0; i< 4; i++){
            kY = (int) (rY + 2*rHigh*0.01 + i*kHigh);
            g2.setColor(Color.white);
            g2.drawRoundRect(kX, kY, kWight, kHigh, 10, 10);

            // Panel für mous Listener
            test[i] = new JPanel();
            container = test[i].getParent();
            test[i].setName(String.valueOf(i));
            test[i].setBounds(kX,kY,kWight,kHigh);
            gp.add(test[i]);
            test[i].setVisible(true);
            test[i].addMouseListener(gp.mous);
        }
        g2.setColor(Color.green);
        kY = (int) (rY + 2*rHigh*0.01 + countY*kHigh);
        g2.drawRoundRect(kX, kY, kWight, kHigh, 10, 10);




    }
    public void playScreen(){

    }

    public void newScreen(){

    }

    public void settingsScreen(){



    }




       public void menuSettings(Graphics2D g2){

        int textX;
        int textY;

        String text;
        //Title
           text ="Settings";
           g2.drawString(text,getxCenter(text),gp.screenHeight/2);

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
