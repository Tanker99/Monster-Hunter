

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean up,down,left,right,ee,esc;

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W){
            System.out.println("w pressed");
            up = true;
        }
        if(key == KeyEvent.VK_A){
            left = true;
        }
        if(key == KeyEvent.VK_S){
            down = true;
        }
        if(key == KeyEvent.VK_D){
            right = true;
        }
        if(key == KeyEvent.VK_E){
            ee = true;
        }
        if(key == KeyEvent.VK_ESCAPE){
            esc = true;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W){
            System.out.println("w stop");
            up = false;
        }
        if(key == KeyEvent.VK_A){
            left = false;
        }
        if(key == KeyEvent.VK_S){
            down = false;
        }
        if(key == KeyEvent.VK_D){
            right = false;
        }
        if(key == KeyEvent.VK_E){
            ee = false;
        }
        if(key == KeyEvent.VK_ESCAPE){
            esc = false;
        }


    }
}
