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
        if(gp.gameState == gp.inventoryState){
            inventoryStateClick(e);
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
        if(gp.gameState == gp.inventoryState){
            inventoryStateEntered(e);
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
    public void inventoryStateClick(MouseEvent e){
        System.out.println("Panel Name " + e.getComponent().getName());
        gp.inventory.sllectSlot = gp.inventory.currentSlot;
        if(gp.inventory.sellect){
            gp.inventory.sellect = false;
        }else {
            gp.inventory.sellect = true;
        }
    }
    public void inventoryStateEntered(MouseEvent e){
        System.out.println("Panel Name " + e.getComponent().getName());
        String i = e.getComponent().getName();
        System.err.println(i);
        switch (i) {
            case "Slot: 0":
                gp.inventory.countY = 0;
                gp.inventory.countX = 0;
                gp.inventory.currentSlot = 0;
                gp.playSound(1);
                break;
            case "Slot: 1":
                gp.inventory.countY = 0;
                gp.inventory.countX = 1;
                gp.inventory.currentSlot = 1;
                gp.playSound(1);
                break;
            case "Slot: 2":
                gp.inventory.countY = 0;
                gp.inventory.countX = 2;
                gp.inventory.currentSlot = 2;
                gp.playSound(1);
                break;
            case "Slot: 3":
                gp.inventory.countY = 0;
                gp.inventory.countX = 3;
                gp.inventory.currentSlot = 3;
                gp.playSound(1);
                break;
            case "Slot: 4":
                gp.inventory.countY = 1;
                gp.inventory.countX = 0;
                gp.inventory.currentSlot = 4;
                gp.playSound(1);
                break;
            case "Slot: 5":
                gp.inventory.countY = 1;
                gp.inventory.countX = 1;
                gp.inventory.currentSlot = 5;
                gp.playSound(1);
                break;
            case "Slot: 6":
                gp.inventory.countY = 1;
                gp.inventory.countX = 2;
                gp.inventory.currentSlot = 6;
                gp.playSound(1);
                break;
            case "Slot: 7":
                gp.inventory.countY = 1;
                gp.inventory.countX = 3;
                gp.inventory.currentSlot = 7;
                gp.playSound(1);
                break;
        }


    }
}

