

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;

    public boolean up, down, left, right, ee, esc;


    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        //Menu State
        if (gp.gameState == gp.menueState) {
            menueState(key);
        }
        //Player State
        else if (gp.gameState == gp.playerState) {
            playerState(key);
        }
    }

    public void menueState(int key) {
        if (key == KeyEvent.VK_W) {
            if(gp.ui.count >0){
                gp.ui.count --;
                gp.playSound(1);
            }else {
                gp.playSound(2);
            }
        }
        if (key == KeyEvent.VK_S) {
            if(gp.ui.count <3){
                gp.ui.count ++;
                gp.playSound(1);
            }else {
                gp.playSound(2);
            }

        }
        if (key == KeyEvent.VK_ENTER) {
            if(gp.ui.count == 1) {
                gp.gameState = 1;
                gp.playSound(2);
            }
        }
    }

    public void playerState(int key) {
        if (key == KeyEvent.VK_W) {
            System.out.println("w pressed");
            up = true;
        }
        if (key == KeyEvent.VK_A) {
            left = true;
        }
        if (key == KeyEvent.VK_S) {
            down = true;
        }
        if (key == KeyEvent.VK_D) {
            right = true;
        }
        if (key == KeyEvent.VK_E) {
            ee = true;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            esc = true;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            System.out.println("w stop");
            up = false;
        }
        if (key == KeyEvent.VK_A) {
            left = false;
        }
        if (key == KeyEvent.VK_S) {
            down = false;
        }
        if (key == KeyEvent.VK_D) {
            right = false;
        }
        if (key == KeyEvent.VK_E) {
            ee = false;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            esc = false;
        }


    }
}
