import Items.Ruestung;
import Items.Trank;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int size = 16; //pixel größe von obcejten max 16x16
    final int scale = 5; //vergrößerung
    public final int titleSize = size * scale; // pixel 80x80
    final int maxWidth = 16;
    final int maxHeight = 12;

     int screenHeight = titleSize * maxHeight; //960
     int screenWidth = titleSize * maxWidth; //1280


    //Listerner
    KeyHandler keyH = new KeyHandler(this);
    MouseListener mous = new MouseListener(this);

    //DB
    public DBaufruf dba = new DBaufruf(this);

    //dasd
    public Text text = new Text(this);
    public Sound sound = new Sound();
    public Config config = new Config(this);

    public Image image = new Image(this);
    public Test test = new Test(this,keyH);


    //Classes
    public UI ui = new UI(this);
    public Player player = new Player(this, keyH);
    public TickTackToe miniGame = new TickTackToe(this);
    public Shop shop = new Shop(this, keyH);
    public Inventory inventory = new Inventory(this,keyH);

    public Fight fight = new Fight(this, keyH);


    Thread gameThread;

    //STATES
    public int gameState;
    private  int oldGameState;
    final int uiState = 1;
    final int playerState = 2;
    final int miniGameState =3;
    final int shopState = 4;
    final int inventoryState = 5;
    final int fightState = 6;
    final int testState = 10;

    //Variable
    public boolean shopEntry = true;
    public boolean fullScreen;
    public int save = 0;
    int FPS = 60;

    //TEST ZWECKE

    //public int gold = 0;
    public int starke =100;
    public int xx = screenWidth;

    public GamePanel(){

        setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);



    }

    public void setup(){
        //playLoopSound(0);
        gameState = 6;


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
           // shop.update();
        }
        if (gameState == fightState) {
             fight.update();
        }
        if (gameState == testState) {
            test.update();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (!(gameState == oldGameState)) {
            this.removeAll();
            this.validate();
            this.repaint();
            oldGameState = gameState;
        }
        if (gameState == uiState) {
            ui.draw(g2);
            g2.dispose();
        } else if (gameState == playerState) {
            player.draw(g2);
            g2.dispose();
        } else if(gameState == miniGameState){
            miniGame.draw(g2);
            g2.dispose();
        }else if (gameState == inventoryState) {
            inventory.draw(g2);
            g2.dispose();
        } else if (gameState == shopState) {
            shop.draw(g2);
            g2.dispose();
        } else if (gameState == fightState) {
            fight.draw(g2);
            g2.dispose();
        } else if (gameState == testState) {
            test.draw(g2);
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
    public void updateScreen(int i){
            Dimension currentSize = this.getSize();
            int newWidth = currentSize.width;
            int newHeight = currentSize.height;

            if (i > 0) {
                newWidth += 100;
                newHeight += 100;
            } else if (i < 0) {
                newWidth -= 100;
                newHeight -= 100;
            }

            Dimension newSize = new Dimension(newWidth, newHeight);
            screenWidth = newWidth;
            screenHeight = newHeight;
            this.setSize(newSize);
        }
}



