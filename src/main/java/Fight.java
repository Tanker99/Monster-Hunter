import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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
    }
    public void update(){

    }

    public void drawcharakter() {

    }

    public void drawButton(){
        int x= (int)(gp.screenWidth/2);
        int y= (int)(gp.screenHeight*0.3);
        int width= 100;
        int height= 100;

        g2.drawRect(x,y,width,height);
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