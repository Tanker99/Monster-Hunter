package Game;

import Items.Ruestung;
import Items.Trank;
import Items.Waffe;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int size = 16; //pixel größe von obcejten max 16x16
    final int scale = 5; //vergrößerung
    public final int tileSize = size * scale; // pixel 80x80
    public final int maxWidth = 16;
    public final int maxHeight = 12;

    public int screenHeight = tileSize * maxHeight; //960
    public int screenWidth = tileSize * maxWidth; //1280

    //Welteneinstellungen
    public final int maxWelttilescol = 44;
    public final int maxWelttilesrow = 44;

    public final int maxWeltbreite = tileSize * maxWelttilescol;
    public final int maxWeltHoehe = tileSize * maxWelttilesrow;

    //Listerner
    KeyHandler keyH = new KeyHandler(this);
    MouseListener mous = new MouseListener(this);

    //Tiles
    public Tilemanager tileT = new Tilemanager(this);
    public Collision CCheck= new Collision(this);

    //dasd
    public Text text = new Text(this);
    public Sound sound = new Sound();
    public Config config = new Config(this);

    public Image image = new Image();
    public MonsterDB monsterDB = new MonsterDB();
    public Test test = new Test(this,keyH);


    //Classes
    public UI ui = new UI(this);
    public Settings settings = new Settings(this);
    public Player player = new Player(this, keyH);
    public TickTackToe miniGame = new TickTackToe(this);
    public Shop shop = new Shop(this);
    public Inventory inventory = new Inventory(this,keyH);

    public Fight fight = new Fight(this);
    public GameOver gameOver = new GameOver(this);


    Thread gameThread;

    //STATES
    public int gameState;
    private  int oldGameState;
    int settingOldState;
    final int uiState = 1;
    final int playerState = 2;
    final int miniGameState =3;
    final int shopState = 4;
    final int inventoryState = 5;
    final int fightState = 6;
    final int gameOverState = 7;
    final int settingsState = 10;
    final int testState = 11;

    //Variable
    public boolean shopEntry;
    public boolean fullScreen;
    public int save = 0;
    int FPS = 60;

    //TEST ZWECKE
    public Trank trank = new Trank(this);
    public Ruestung ruestung = new Ruestung(this);
    public Waffe waffe = new Waffe(this);
    public DBaufruf dba = new DBaufruf(this);
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
        playLoopSound(0);
        gameState = 1;


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
            settingOldState = uiState;
            ui.draw(g2);
            g2.dispose();
        } else if (gameState == playerState) {
            settingOldState = playerState;
            tileT.draw(g2);
            player.draw(g2);
            g2.dispose();
        } else if(gameState == miniGameState){
            settingOldState = miniGameState;
            miniGame.draw(g2);
            g2.dispose();
        }else if (gameState == inventoryState) {
            settingOldState = inventoryState;
            inventory.console = "";
            inventory.draw(g2);
            g2.dispose();
        } else if (gameState == shopState) {
            settingOldState = shopState;
            shop.console = "";
            shop.draw(g2);
            g2.dispose();
        } else if (gameState == fightState) {
            settingOldState = fightState;
            fight.draw(g2);
            g2.dispose();
        }else if (gameState == settingsState) {
            settings.draw(g2);
            g2.dispose();
        } else if (gameState == gameOverState) {
            gameOver.draw(g2);
            g2.dispose();
        } else if (gameState == testState) {
            test.draw(g2);
            g2.dispose();
        }
        g2.dispose();
    }


    public void playLoopSound(int i) {
       //// sound.selectSound(i);
       // sound.play();
       // sound.loop();
    }
    public void playSound(int i){
       // sound.selectSound(i);
       // sound.play();
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



