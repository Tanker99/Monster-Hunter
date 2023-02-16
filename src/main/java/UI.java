import java.awt.*;

public class UI{

    GamePanel gp;

    public UI(GamePanel gp) {
        this.gp = gp;
    }


    public void titleScreen(Graphics2D g2){
        //Background
        g2.setColor(Color.white);
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
        //config Title
        g2.setFont(new Font("Arial",Font.PLAIN,80));
        String text = "Hunter Game";
        int x  = getx(g2,text);
        int y = gp.titleSize *3;
        //Set Shadow
        setShadow(g2,text,x,y);
        //SetTitle
        g2.setColor(Color.green);
       g2.drawString("Hunter Game ",x,y );


    }

    public void draw(Graphics2D g2){
        titleScreen(g2);
        g2.setFont(new Font("Arial",Font.PLAIN,40));
        g2.setColor(Color.black);
        g2.drawString("ee", 50,50);

    }

    public void setShadow(Graphics2D g2, String text,int x, int y){
        g2.setColor(Color.black);
        g2.drawString(text,x+5,y+5);
    }

    public int getx(Graphics2D g2,String text){
        int lenght = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - lenght/2;
        return x;
    }
}
