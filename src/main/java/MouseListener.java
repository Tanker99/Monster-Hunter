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

        if(gp.gameState == gp.menueState){
            menueStateClick(e);
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
        if(gp.gameState == gp.menueState){
            menueStateEntered(e);
        }



    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public void menueStateClick(MouseEvent e) {

        if (gp.ui.menustate == gp.ui.newandplaystat) {
            if (gp.ui.countX == 0) {
                if (gp.ui.countY == 0) {
                    gp.save = 1;
                    gp.gameState = gp.playerState;
                    gp.playSound(2);
                }
                if (gp.ui.countY == 1) {
                    gp.save = 3;
                    gp.gameState = gp.playerState;
                    gp.playSound(2);
                }
            }
            if (gp.ui.countX == 1) {
                if (gp.ui.countY == 0) {
                    gp.save = 2;
                    gp.gameState = gp.playerState;
                    gp.playSound(2);

                }
                if (gp.ui.countY == 1) {
                    gp.save = 4;
                    gp.gameState = gp.playerState;
                    gp.playSound(2);
                }
            }
            if (gp.ui.countY == 2) {
                gp.ui.menustate = gp.ui.titlestate;
                gp.playSound(2);
            }
        }else
            if (gp.ui.menustate == gp.ui.titlestate) {
            if (gp.ui.countY == 0) {
                gp.ui.menustate = 2;
                gp.ui.newsave = true;
                gp.playSound(2);
            }
            if (gp.ui.countY == 1) {
                gp.ui.menustate = 2;
                gp.ui.newsave = false;
                gp.playSound(2);
            }
            if (gp.ui.countY == 2) {
                gp.ui.menustate = 3;
                gp.playSound(2);
            }
            if (gp.ui.countY == 3) {
                System.exit(0);
                gp.playSound(2);
            }
        }else
            if(gp.ui.menustate == gp.ui.settingsstate){
                gp.ui.menustate = gp.ui.titlestate;
                gp.playSound(2);
            }
    }
    public void menueStateEntered(MouseEvent e) {
        System.out.println("Panel Name " + e.getComponent().getName());
        if(gp.ui.menustate == gp.ui.titlestate) {
            gp.ui.countY = Integer.parseInt(e.getComponent().getName());
            gp.playSound(1);
        }else
            if (gp.ui.menustate == gp.ui.newandplaystat){
            int i = Integer.parseInt(e.getComponent().getName());
            switch (i){
                case 0:
                    gp.ui.countY = 0;
                    gp.ui.countX = 0;
                    gp.playSound(1);
                    break;
                case 1:
                    gp.ui.countY = 0;
                    gp.ui.countX = 1;
                    gp.playSound(1);
                    break;
                case 2:
                    gp.ui.countY = 1;
                    gp.ui.countX = 0;
                    gp.playSound(1);
                    break;
                case 3:
                    gp.ui.countY = 1;
                    gp.ui.countX = 1;
                    gp.playSound(1);
                    break;
                case 4:
                    gp.ui.countY = 2;
                    gp.playSound(1);
                    break;
            }
        }else
            if(gp.ui.menustate == gp.ui.settingsstate){

            }
    }


}
