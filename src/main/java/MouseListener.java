import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener {


    GamePanel gp;
    public MouseListener(GamePanel gp) {
        this.gp = gp;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
            if(gp.ui.countY == 1) {
                gp.gameState = 1;
                gp.playSound(2);
            }
            if(gp.ui.countY == 3) {
                System.exit(0);
                gp.playSound(2);
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    System.out.println("mouse pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse entered");
        System.out.println("Panel Name "+ e.getComponent().getName() );
        gp.ui.countY = Integer.parseInt(e.getComponent().getName());
        gp.playSound(1);


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
