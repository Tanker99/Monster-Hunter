package Game;

import Game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;

    public boolean up, down, left, right, ee, esc,enter,ff;


    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        //key accept menuState
        if (gp.gameState == gp.uiState) {
            menueState(key);
        }
        //key accept playerState
        else if (gp.gameState == gp.playerState) {
            playerState(key);
        }
        //key accept inventoryState
        else if(gp.gameState == gp.inventoryState){
            inventarState(key);
        }
        //key accept shopState
        else if(gp.gameState == gp.shopState){
            shopState(key);
        }
        //TEST
        if(key == KeyEvent.VK_L){
            gp.config.saveAll(gp.save);
            gp.config.save(gp.save,"used", 1);
            System.err.println("Save Game "+gp.save + " wurde Gespeichert");
        }
        if(key == KeyEvent.VK_S){
            gp.gameState = gp.shopState;
        }
    }

    public void menueState(int key) {
        System.out.println(key);
        //EXTRA
        if (key == 109) {
            gp.updateScreen(-100);
            //gp.gameState = gp.testState;
        }
        if(key == 107){
            gp.updateScreen(100);

        }
        if(gp.ui.menuState == gp.ui.titleState){
            if (key == KeyEvent.VK_W) {
                if (gp.ui.sellectValueY > 0) {
                    gp.ui.sellectValueY --;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }
            }
            if (key == KeyEvent.VK_S) {
                if (gp.ui.sellectValueY < 3) {
                    gp.ui.sellectValueY++;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }

            }
            if (key == KeyEvent.VK_ENTER) {
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
        }
        else if(gp.ui.menuState == gp.ui.newAndPlayState){
            if(key == KeyEvent.VK_ESCAPE){
                gp.ui.menuState = gp.ui.titleState;
                gp.playSound(3);
            }
            if (key == KeyEvent.VK_W) {
                if (gp.ui.sellectValueY > 0) {
                    gp.ui.sellectValueY --;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }
            }
            if (key == KeyEvent.VK_S) {
                if (gp.ui.sellectValueY < 2) {
                    gp.ui.sellectValueY++;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }

            }
            if (key == KeyEvent.VK_A) {
                if (!(gp.ui.sellectValueY == 2)) {
                    if (gp.ui.sellectValueX > 0) {
                        gp.ui.sellectValueX--;
                        gp.playSound(1);
                    } else {
                        gp.playSound(2);
                    }
                } else {
                    gp.playSound(2);
                }
            }
            if (key == KeyEvent.VK_D) {
                if (!(gp.ui.sellectValueY == 2)) {
                    if (gp.ui.sellectValueX < 1) {
                        gp.ui.sellectValueX++;
                        gp.playSound(1);
                    } else {
                        gp.playSound(2);
                    }

                }else {
                    gp.playSound(2);
                }
            }
            if (key == KeyEvent.VK_ENTER) {
                if (gp.ui.sellectValueY == 0) {
                    if (gp.ui.sellectValueX == 0) {
                        gp.save = 0;
                        if(gp.ui.newsave){
                            gp.config.copyFile(4,gp.save);
                            gp.config.loadAll(gp.save);
                        }else {
                            gp.config.loadAll(gp.save);
                        }
                        gp.gameState = gp.playerState;
                        gp.playSound(3);

                    }
                    if (gp.ui.sellectValueX == 1) {
                        gp.save = 1;
                        if(gp.ui.newsave){
                            gp.config.copyFile(4,gp.save);
                            gp.config.loadAll(gp.save);
                        }else {
                            gp.config.loadAll(gp.save);
                        }
                        gp.gameState = gp.playerState;
                        gp.playSound(3);
                    }
                }
                if (gp.ui.sellectValueY == 1) {
                    if (gp.ui.sellectValueX == 0) {
                        gp.save = 2;
                        if(gp.ui.newsave){
                            gp.config.copyFile(4,gp.save);
                            gp.config.loadAll(gp.save);
                        }else {
                            gp.config.loadAll(gp.save);
                        }
                        gp.gameState = gp.playerState;
                        gp.playSound(3);
                    }
                    if (gp.ui.sellectValueX == 1) {
                        gp.save = 3;
                        if(gp.ui.newsave){
                            gp.config.copyFile(4,gp.save);
                            gp.config.loadAll(gp.save);
                        }else {
                            gp.config.loadAll(gp.save);
                        }
                        gp.gameState = gp.playerState;
                        gp.playSound(3);
                    }
                }
                if (gp.ui.sellectValueY == 2) {
                    gp.ui.menuState = gp.ui.titleState;
                    gp.playSound(3);
                }else
                if (gp.ui.newsave) {
                    gp.config.copyFile(4, gp.save);
                }
            }

        }
        else if(gp.ui.menuState == gp.ui.settingsState){
            if(key == KeyEvent.VK_ESCAPE){
                gp.ui.menuState = gp.ui.titleState;
                gp.playSound(3);
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
            gp.inventory.resetCurser();
            gp.gameState = gp.inventoryState;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            gp.gameState = gp.uiState;
        }


    }
    public void inventarState(int key) {
            if (key == KeyEvent.VK_W) {
                if (gp.inventory.currentSlotValueY > 0) {
                    gp.inventory.currentSlotValueY--;
                    gp.inventory.currentSlot = gp.inventory.currentSlot -4;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }
            }
            if (key == KeyEvent.VK_A) {
                if (gp.inventory.currentSlotValueX > 0) {
                    gp.inventory.currentSlotValueX--;
                    gp.inventory.currentSlot = gp.inventory.currentSlot -1;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }
            }
            if (key == KeyEvent.VK_S) {
                if (gp.inventory.currentSlotValueY < 1) {
                    gp.inventory.currentSlotValueY++;
                    gp.inventory.currentSlot = gp.inventory.currentSlot +4;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }
            }
            if (key == KeyEvent.VK_D) {
                if (gp.inventory.currentSlotValueX < 3) {
                    gp.inventory.currentSlotValueX++;
                    gp.inventory.currentSlot = gp.inventory.currentSlot +1;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }
            }
            if (key == KeyEvent.VK_ENTER) {
                if(!(gp.inventory.select)){
                    gp.inventory.selectSlot = gp.inventory.currentSlot;
                    gp.inventory.select = true;
                }else {
                    gp.inventory.twoSelectSlot = gp.inventory.currentSlot;
                    gp.inventory.twoSelect = true;
                }

            }
            if (key == KeyEvent.VK_E) {
                if(gp.shopEntry){
                    gp.gameState = gp.shopState;
                }else {
                    gp.gameState = gp.playerState;
                }

            }
        }



    public void shopState(int key) {

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
        if (key == KeyEvent.VK_F) {
            ff = false;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            esc = false;
        }
        if (key == KeyEvent.VK_ENTER) {
            enter = false;
        }


    }
}
