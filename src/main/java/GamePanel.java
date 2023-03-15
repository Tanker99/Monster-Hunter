




import DB.Ruestung;
import DB.Trank;
import DB.Waffe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable {

    final int size = 16; //pixel größe von obcejten max 16x16
    final int scale = 5; //vergrößerung
    public final int titleSize = size * scale; // pixel 80x80
    final int maxWidth = 16;
    final int maxHeight = 12;

    final int screenHeight = titleSize * maxHeight; //960
    final int screenWidth = titleSize * maxWidth; //1280


    KeyHandler keyH = new KeyHandler(this);
    MouseListener mous = new MouseListener(this);
    Sound sound = new Sound();
    Config config = new Config(this);
    public UI ui = new UI(this);
    public JPanel uip = new JPanel();
    public Player player = new Player(this, keyH);
    public Shop shop = new Shop(this, keyH);
    public Inventory inventory = new Inventory(this,keyH);
    public Fight fight = new Fight(this, keyH);

    public Waffe waffe = new Waffe();
    public Trank trank = new Trank();
    public Ruestung ruestung = new Ruestung();

    public Image image = new Image(this);
    Thread gameThread;


    public int gameState = 0;
    final int menueState = 0;
    final int playerState = 1;
    final int shopState = 2;
    final int inventoryState = 3;
    final int fightState = 4;

    //TEST ZWECKE

    public int gold = 0;
    public int starke =100;


    //TEST ZWECKE

    int FPS = 60;
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 5;

    public GamePanel(){

        setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);




    }

    public void setup(){
        playLoopSound(0);
        gameState = 0;

        this.add(uip);
        uip.setBounds(0,0,screenWidth,screenHeight);
        uip.setOpaque(false);

    }

    public void startThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currenTime;
        long timer = 0;
        long deawcount = 0;


        while (gameThread != null) {

            currenTime = System.nanoTime();
            delta += (currenTime - lastTime) / drawInterval;
            timer += (currenTime - lastTime);
            lastTime = currenTime;


            if (delta >= 1) {
                update();
                repaint();
                delta--;
                deawcount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS" + deawcount);
                deawcount = 0;
                timer = 0;
            }


        }
    }


    public void update() {
        if(gameState == playerState) {
            player.update();
        }
        if (gameState == inventoryState) {
            inventory.update();
        }
        if (gameState == shopState) {
            shop.update();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(gameState == 0) {
            ui.draw(g2);

            g2.dispose();
        }else {
            uip.setVisible(false);
        }if(gameState == playerState) {
                player.draw(g2);
                g2.dispose();
            }else {
        }
        if(gameState == shopState){
                shop.draw(g2);
                g2.dispose();
            }else {
        }
        if( gameState == inventoryState){
                inventory.draw(g2);
                g2.dispose();
            }

        g2.dispose();
    }


    public void playLoopSound(int i) {
        sound.selectSound(i);
        sound.play();
        sound.loop();
    }
    public void playSound(int i){
        sound.selectSound(i);
        sound.play();
    }
}



