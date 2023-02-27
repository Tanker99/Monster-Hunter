import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI{

    GamePanel gp;
    Graphics2D g2;

    public int count;


    public UI(GamePanel gp) {

        this.gp = gp;
    }


    public void titleScreen(Graphics2D g2) {
        int sektion = 0;
        //Background Image
        //g2.setColor(Color.white);
        //g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
        BufferedImage back = null;
        try {
            back = ImageIO.read(Player.class.getResource("/back.png"));
        } catch (IOException e) {
            System.out.println("Error Loading Background");
        }

        g2.drawImage(back, 0, 0, gp.screenWidth, gp.screenHeight, null);
        //config Title
        g2.setFont(new Font("Arial", Font.PLAIN, 80));
        String text = "Hunter Game";
        int x = getx(g2, text);
        int y = gp.titleSize * 2;
        //Set Shadow
        setShadow(g2, text, x, y, Color.white);
        //SetTitle
        g2.setColor(Color.green);
        g2.drawString("Hunter Game ", x, y);
        //Charackter
        BufferedImage cha = null;
        try {
            cha = ImageIO.read(Player.class.getResource("cha.png"));
        } catch (IOException e) {
            System.out.println("Home screen loading error!!");
        }
        int xcha = cha.getWidth();
        g2.drawImage(cha, gp.screenWidth / 2 - xcha, 300, 200, 200, null);

        //Text
        titleText(g2);
    }
    public void titleText(Graphics2D g2){

        //Rand
        int rX = gp.screenWidth/4;
        int rY = gp.screenHeight/2;
        int rWight = gp.screenWidth/2;
        int rHigh = (int) (gp.screenHeight/2.2);
        g2.drawRoundRect(rX,rY,rWight,rHigh,10,10);

        //Text
        int textX = rX /2;
        int textY = rY;

        String text;
        g2.setColor(Color.white);
        text = "New Game";
        g2.drawString(text,getx(g2,text),textY + 100);
        text = "Play";
        g2.drawString(text,getx(g2,text),textY + 200);
        text = "Settings";
        g2.drawString(text,getx(g2,text),textY+ 300);
        text = "Exit";
        g2.drawString(text,getx(g2,text),textY+ 400);

        //Kasten

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));

       switch (count){
           case 0:
               g2.drawRoundRect(rX + 10, textY, rWight - 20, 100, 10, 10);
               break;
           case 1:
               g2.drawRoundRect(rX + 10, textY + 120, rWight - 20, 100, 10, 10);
               break;
           case 2:
               g2.drawRoundRect(rX + 10, textY + 220, rWight - 20, 100, 10, 10);
               break;
           case 3:
               g2.drawRoundRect(rX + 10, textY + 340, rWight - 20, 100, 10, 10);
               break;
       }




    }

    public void draw(Graphics2D g2){
        titleScreen(g2);
        g2.setFont(new Font("Arial",Font.PLAIN,40));
        g2.setColor(Color.black);
        g2.drawString("ee", 50,50);

    }

    public void setShadow(Graphics2D g2, String text,int x, int y, Color color){
        g2.setColor(color);
        g2.drawString(text,x+5,y+5);
    }

    public int getx(Graphics2D g2,String text){
        int lenght = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - lenght/2;
        return x;
    }
}
