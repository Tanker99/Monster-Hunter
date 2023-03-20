import java.awt.*;
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

        if (gp.gameState == gp.uiState) {
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
        if (gp.gameState == gp.uiState) {
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
        System.out.println("Panel " + e.getComponent().getName() + " Clicked");

        if (gp.ui.menuState == gp.ui.titleState) {
            if (gp.ui.sellectValueY == 0) {
                gp.ui.newsave = true;
                gp.ui.menuState = gp.ui.newAndPlayState;
                gp.playSound(3);
            }
            if (gp.ui.sellectValueY == 1) {
                gp.ui.newsave = false;
                gp.ui.menuState = gp.ui.newAndPlayState;
                gp.playSound(3);
            }
            if (gp.ui.sellectValueY == 2) {
                gp.ui.menuState = gp.ui.settingsState;
                gp.playSound(3);
            }
            if (gp.ui.sellectValueY == 3) {
                gp.playSound(2);
                System.exit(0);

            }
        }
        else if (gp.ui.menuState == gp.ui.newAndPlayState) {
            if (gp.ui.sellectValueY == 0) {
                if (gp.ui.sellectValueX == 0) {
                    gp.save = 0;
                    gp.gameState = gp.playerState;
                    gp.playSound(3);

                }
                if (gp.ui.sellectValueX == 1) {
                    gp.save = 1;
                    gp.gameState = gp.playerState;
                    gp.playSound(3);
                }
            }
            if (gp.ui.sellectValueY == 1) {
                if (gp.ui.sellectValueX == 0) {
                    gp.save = 2;
                    gp.gameState = gp.playerState;
                    gp.playSound(3);
                }
                if (gp.ui.sellectValueX == 1) {
                    gp.save = 3;
                    gp.gameState = gp.playerState;
                    gp.playSound(3);
                }
            }
            if (gp.ui.sellectValueY == 2) {
                gp.ui.menuState = gp.ui.titleState;
                gp.playSound(3);
            }

        }
        else if(gp.ui.menuState == gp.ui.settingsState){
            if (gp.ui.sellectValueY == 0) {
                    if(gp.fullScreen) {
                        gp.fullScreen = false;
                    }else {
                        gp.fullScreen = true;
                    }
                    gp.playSound(1);

                }
            if (gp.ui.sellectValueY == 1) {
                if (gp.ui.sellectValueX == 0) {
                    if(gp.sound.volumeScale < 1){
                        gp.playSound(2);
                    }else {
                        gp.sound.volumeScale--;
                        gp.playSound(3);
                    }
                    if(gp.sound.volumeScale > 3){
                        gp.sound.volume();
                        gp.playSound(2);
                    }else {
                        gp.sound.volumeScale++;
                        gp.sound.volume();
                        gp.playSound(3);
                    }
                }
                if (gp.ui.sellectValueX == 1) {
                    gp.save = 4;
                    gp.gameState = gp.playerState;
                    gp.playSound(3);
                }
                if (gp.ui.sellectValueX == 2) {
                    gp.save = 4;
                    gp.gameState = gp.playerState;
                    gp.playSound(3);
                }
            }
            if (gp.ui.sellectValueY == 2) {
                gp.ui.menuState = gp.ui.titleState;
                gp.playSound(3);
            }
        }
    }

    /*
            if (gp.ui.menuState == gp.ui.newandplaystat) {
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

     */
    public void menueStateEntered(MouseEvent e) {
        System.out.println("Panel " + e.getComponent().getName() + " Entered");
        if (gp.ui.menuState == gp.ui.titleState) {
            gp.playSound(1);
            String i = e.getComponent().getName();
            switch (i) {
                case "Tile Screen: 0":
                    gp.ui.sellectValueY = 0;
                    break;
                case "Tile Screen: 1":
                    gp.ui.sellectValueY = 1;
                    break;
                case "Tile Screen: 2":
                    gp.ui.sellectValueY = 2;
                    break;
                case "Tile Screen: 3":
                    gp.ui.sellectValueY = 3;
                    break;
            }
        }else if(gp.ui.menuState == gp.ui.newAndPlayState) {
            gp.playSound(1);
            String i = e.getComponent().getName();
            switch (i) {
                case "Save Screen: 0":
                    gp.ui.sellectValueX = 0;
                    gp.ui.sellectValueY = 0;

                    break;
                case "Save Screen: 1":
                    gp.ui.sellectValueX = 1;
                    gp.ui.sellectValueY = 0;
                    break;
                case "Save Screen: 2":
                    gp.ui.sellectValueX = 0;
                    gp.ui.sellectValueY = 1;
                    break;
                case "Save Screen: 3":
                    gp.ui.sellectValueX = 1;
                    gp.ui.sellectValueY = 1;
                    break;
                case "Save Screen: Back":
                    gp.ui.sellectValueX = 0;
                    gp.ui.sellectValueY = 2;
                    break;
            }

        }else if(gp.ui.menuState == gp.ui.settingsState) {
        }
    }
    public void inventoryStateClick(MouseEvent e){
        System.out.println("Panel Name " + e.getComponent().getName() + " Clicked");
        gp.inventory.sllectSlot = gp.inventory.currentSlot;
        if(gp.inventory.sellect){
            gp.inventory.sellect = false;
        }else {
            gp.inventory.sellect = true;
        }
    }
    public void inventoryStateEntered(MouseEvent e){
        System.out.println("Panel Name " + e.getComponent().getName() + " Entered");
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

