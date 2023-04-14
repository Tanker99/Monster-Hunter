import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Fight {

    GamePanel gp;

    Graphics2D g2;

    KeyHandler keyH;

    boolean fight=false;

    int level;

    int lebenMonster;

    int lebenSpieler;



    private JPanel slot[]=new JPanel[3];

    public Fight(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        drawBackground();
        drawcharakter();
        drawmonster();
        drawButton();
        kampf();
    }
    public void update(){

    }

    public void drawcharakter() {
        int x= 100;
        int y= 700;
        int width= 100;
        int height= 100;
        g2.drawRect(x,y,width,height);

        //drawState

        int sX = 100;
        int sY = 100;
        int swight = 100;
        int sheight = 100;

        g2.drawRect(sX,sY,swight,swight);

        String leben = String.valueOf(gp.player.leben);
        String attack = String.valueOf(gp.player.kraft);
        String defense = String.valueOf(gp.player.defense);

        gp.text.draw3StringsInBox(g2,"Leben :" + leben, "Angriff : " + attack,"Defense : " + defense,sX,sY,swight,sheight);

    }
    public void drawmonster() {
        int x= 1000;
        int y= 700;
        int width= 100;
        int height= 100;
        g2.drawRect(x,y,width,height);

        int sX = 1000;
        int sY = 100;
        int swight = 100;
        int sheight = 100;

        g2.drawRect(sX,sY,swight,swight);

        String leben = String.valueOf(gp.monster.getHealth(level));
        String attack = String.valueOf(gp.monster.attack);

        gp.text.draw2StringsInBox(g2,"Leben :" + leben, "Angriff : " + attack,sX,sY,swight,sheight);
    }

    public void drawButton() {
        int x = (int) (gp.screenWidth /2.55  );
        int y = (int) (gp.screenHeight * 0.5);
        int width = 200;
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

    public void setupKampf() {
        lebenSpieler =gp.player.leben;
        lebenMonster = gp.monster.getHealth(level);
    }


    public void kampf() {

        if(fight) {
            fight=false;
            System.out.println("Start");
            for(int i=0;i<=lebenSpieler||i<=lebenMonster;i++){
                    lebenMonster-=(gp.player.kraft);
                    lebenSpieler-=(gp.monster.attack);
                }
                if(lebenSpieler<=0){
                    gp.gameState=gp.uiState;
                }
                if(lebenMonster<=0){
                    gp.gameState= gp.playerState;
                }
            }
        }





}




