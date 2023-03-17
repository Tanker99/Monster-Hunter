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
    private JPanel test[] = new JPanel[4];
    public Container container;


    public UI(GamePanel gp) {

        this.gp = gp;
    }
    public void draw(Graphics2D g2){

        this.g2 = g2;

        //Hintergrund
        BufferedImage back = null;
        try {
            back = ImageIO.read(Player.class.getResource("/back.png"));
            g2.drawImage(back, 0, 0, gp.screenWidth, gp.screenHeight, null);
        } catch (IOException e) {
            System.out.println("Error Loading Background");
        }


        if(!(menustate == oldmenustate)){
            gp.removeAll();
            gp.validate();
            gp.repaint();
            oldmenustate = menustate;
        }
        if (menustate == 0) {
            titleScreen();
        }
        if(menustate == newandplaystat){
            ///playScreen();
            newAndPlayScreen();
        }else if(menustate == settingsstate){
           // settingsScreen();
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
        int chay = (int) (gp.screenHeight*0.2);
        int chaWight = (int) (chax * 0.6);
        int chaHigh = (int) (gp.screenHeight * 0.63);

        g2.drawImage(cha, chax , chay, chaWight, chaHigh, null);


        //Game name Title
        int textX;
        int textY;
        String text;

        g2.setFont(g2.getFont().deriveFont(70F));
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

    public void newAndPlayScreen(){
        int textX;
        int textY;
        String text;

        g2.setFont(g2.getFont().deriveFont(70F));
        if (newsave){
            text = "New Game";
        }else {
            text = "Gespeicherte Spiele";
        }
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


        //kasten

        int kX = 100;
        int kY = 100;
        int kWight = 100;
        int kHigh = 100;

        for( int x = 0; x< 2; x++) {
            int i = 0;
            for (int y = 0; y < 2; y++) {
                g2.setColor(Color.white);
                g2.drawRoundRect(kX + x *100, kY + y*100, kWight, kHigh, 10, 10);

                // Panel für mous Listener
                test[i] = new JPanel();
                test[i].setName(String.valueOf(i));
                test[i].setBounds(kX + x* 100, kY + y * 100, kWight, kHigh);
                gp.add(test[i]);
                test[i].setVisible(true);
                test[i].addMouseListener(gp.mous);
                i++;
            }
        }
        g2.setColor(Color.green);
        g2.drawRoundRect(kX + 100* countX, kY + 100*countY, kWight, kHigh, 10, 10);


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
