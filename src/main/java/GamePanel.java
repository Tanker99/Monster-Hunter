




import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int size = 16; //pixel größe von obcejten max 16x16
    final int scale = 5; //vergrößerung
    public final int titleSize = size * scale; // pixel 48x48
    final int maxWidth = 16;
    final int maxHeight = 12;

    final int screenHeight = titleSize * maxHeight;
    final int screenWidth = titleSize * maxWidth;

    KeyHandler keyH = new KeyHandler(this);
    Sound sound = new Sound();
    public UI ui = new UI(this);
    Thread gameThread;
    Player player = new Player(this, keyH);


    public int gameState = 0;
    public int menueState = 0;
    public int playerState = 1;
    public int shopState = 2;


    int FPS = 60;
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 5;

    public GamePanel() {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        playLoopSound(0);


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
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(gameState == 0){
            ui.draw(g2);
            g2.dispose();
        }else if(gameState == 1) {
            player.draw(g2);
            g2.dispose();
        }else if(gameState == 2){
            Shop.draw(g2);
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



