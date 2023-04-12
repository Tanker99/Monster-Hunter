import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Fight {

    GamePanel gp;

    Graphics2D g2;

    KeyHandler keyH;

    private JPanel slot[]=new JPanel[3];

    public Fight(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        drawcharakter();
        drawmonster();
        drawButton();
    }
    public void update(){

    }

    public void drawcharakter() {
        int x= 10;
        int y= 700;
        int width= 100;
        int height= 100;
        g2.drawRect(x,y,width,height);

        //drawState
        g2.drawRect();
    }
    public void drawmonster() {
        int x= 800;
        int y= 700;
        int width= 100;
        int height= 100;
        g2.drawRect(x,y,width,height);
    }

    public void drawButton() {
        int x = (int) (gp.screenWidth / 2);
        int y = (int) (gp.screenHeight * 0.3);
        int width = 100;
        int height = 100;
        int yab = 150;

        for (int i = 0; i < 2; i++) {
            slot[i] = new JPanel();
            slot[i].setBounds(x, y + i * yab, width, height);
            slot[i].setName("Fight Button: " + i);
            slot[i].addMouseListener(gp.mous);
            gp.add(slot[i]);
            slot[i].setVisible(true);
            g2.drawRect(x, y + i * yab, width, height);

        }
    }
        public void drawBackground(){
            BufferedImage back = null;
            try {
                back = ImageIO.read(Fight.class.getResource("/back.png"));
                g2.drawImage(back, 0, 0, gp.screenWidth, gp.screenHeight, null);
            } catch (IOException e) {
                System.out.println("Error Loading Background");
            }
        }


    }


    /*public void kampf() {
        for(int i=0;i<=lebenSpieler||i<=lebenMonster;i++){      //leben aus DB???
            int kraftSpieler=  gp.player.kraft;     //aus DB???
            int kraftMonster=
        if()   {        //keyHandler???
            lebenMonster-=(kraftSpieler);
        }else{          //zeit nachdem Monster angreift?? oder nacheinenader???
            lebenSpieler-=(kraftMonster);
        }
        if(lebenSpieler<=0){
                                //in gp tot???
        }
        if(lebenMonster<=0){

        }
        }
    }


     */
}