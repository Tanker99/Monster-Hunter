

import java.awt.*;
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
        //Menu State
        if (gp.gameState == gp.menueState) {
            menueState(key);
        }
        //Player State
        else if (gp.gameState == gp.playerState) {
            playerState(key);
        }
        //Inventory State
        else if(gp.gameState == gp.inventoryState){
            inventarState(key);
        }
        else if(gp.gameState == gp.shopState){
            shopState(key);
        }
    }

    public void menueState(int key) {
        if(gp.ui.menustate == 0) {
            if (key == KeyEvent.VK_W) {
                if (gp.ui.countY > 0) {
                    gp.ui.countY--;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }
            }
            if (key == KeyEvent.VK_S) {
                if (gp.ui.countY < 3) {
                    gp.ui.countY++;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }

            }
            if (key == KeyEvent.VK_ENTER) {
                if (gp.ui.countY == 0) {
                    gp.ui.menustate = 2;
                    gp.ui.newsave = true;
                    gp.playSound(2);
                }
                if (gp.ui.countY == 1) {
                    gp.ui.menustate = 2;
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
        if (key == KeyEvent.VK_F) {
            gp.shop.resetCurser();
            gp.gameState = gp.shopState;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            gp.gameState = gp.menueState;
        }


    }
    public void inventarState(int key) {
            if (key == KeyEvent.VK_W) {
                if (gp.inventory.sellect == true) {
                    if (gp.inventory.sellectcountY > 0) {
                        gp.inventory.sellectcountY--;
                        gp.playSound(1);
                    } else {
                        gp.playSound(2);
                    }

                } else {
                    if (gp.inventory.countY > 0) {
                        gp.inventory.countY--;
                        gp.playSound(1);
                    } else {
                        gp.playSound(2);
                    }
                }
            }
            if (key == KeyEvent.VK_A) {
                if (gp.inventory.countX > 0) {
                    gp.inventory.countX--;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }
            }
            if (key == KeyEvent.VK_S) {
                if (gp.inventory.sellect == true) {
                    if (gp.inventory.sellectcountY < 2) {
                        gp.inventory.sellectcountY++;
                        gp.playSound(1);
                    } else {
                        gp.playSound(2);
                    }

                } else {
                    if (gp.inventory.countY < 1) {
                        gp.inventory.countY++;
                        gp.playSound(1);
                    } else {
                        gp.playSound(2);
                    }
                }

            }
            if (key == KeyEvent.VK_D) {
                if (gp.inventory.countX < 3) {
                    gp.inventory.countX++;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }
            }
            if (key == KeyEvent.VK_ENTER) {
                if (!gp.inventory.sellect) {
                    gp.inventory.sellect = true;
                } else if (gp.inventory.sellect) {
                    gp.inventory.sellectcountY = 0;
                    gp.inventory.sellect = false;
                }

            }
            if (key == KeyEvent.VK_E) {
                gp.gameState = gp.playerState;

            }
        }



    public void shopState(int key) {
        if (key == KeyEvent.VK_W) {
            if (gp.shop.waehlen == true) {
                if (gp.shop.sellectcountY > 0) {
                    gp.shop.sellectcountY--;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }

            } else {
                if (gp.shop.countY > 0) {
                    gp.shop.countY--;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }
            }
        }
        if (key == KeyEvent.VK_A) {
            if (gp.shop.countX > 0) {
                gp.shop.countX--;
                gp.playSound(1);
            } else {
                gp.playSound(2);
            }
        }
        if (key == KeyEvent.VK_S) {
            if (gp.shop.waehlen == true) {
                if (gp.shop.sellectcountY < 2) {
                    gp.shop.sellectcountY++;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }

            } else {
                if (gp.shop.countY < 1) {
                    gp.shop.countY++;
                    gp.playSound(1);
                } else {
                    gp.playSound(2);
                }
            }

        }
        if (key == KeyEvent.VK_D) {
            if (gp.shop.countX < 3) {
                gp.shop.countX++;
                gp.playSound(1);
            } else {
                gp.playSound(2);
            }
        }
        if (key == KeyEvent.VK_ENTER) {
            if (!gp.shop.waehlen) {
                gp.shop.waehlen = true;
            } else if (gp.shop.waehlen) {
                gp.shop.sellectcountY = 0;
                gp.shop.waehlen = false;
            }

        }
        if (key == KeyEvent.VK_F) {
            gp.gameState = gp.playerState;

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
