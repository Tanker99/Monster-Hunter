package Game;

import Game.GamePanel;

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
        if (gp.gameState == gp.settingsState){
            settingStateClick(e);
        }
        if(gp.gameState == gp.inventoryState){
            inventoryStateClick(e);
        }
        if(gp.gameState == gp.shopState){
            shopStateClick(e);
        }
        if(gp.gameState == gp.miniGameState){
            miniGameStateClick(e);
        }
        if(gp.gameState == gp.fightState){
            fightStateClick(e);
        }if(gp.gameState == gp.gameOverState){
            gameOverStateClick(e);
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
        System.out.println("mouse entered" + e.getComponent().getName());
        if (gp.gameState == gp.uiState) {
            menueStateEntered(e);
        }
        if (gp.gameState == gp.settingsState){
            settingStateEntered(e);
        }
        if(gp.gameState == gp.inventoryState){
            inventoryStateEntered(e);
        }
        if(gp.gameState == gp.shopState){
            shopStateEntered(e);
        }
        if(gp.gameState == gp.miniGameState){
            miniGameStateEntered(e);
        }
        if(gp.gameState==gp.fightState){
            fightStateEntered(e);
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
                gp.gameState = gp.settingsState;
                gp.playSound(3);
            }
            if (gp.ui.sellectValueY == 3) {
                gp.playSound(2);
                System.exit(0);

            }
        } else if (gp.ui.menuState == gp.ui.newAndPlayState) {
            if (gp.ui.sellectValueY == 0) {
                if (gp.ui.sellectValueX == 0) {
                    gp.save = 0;
                    if (gp.ui.newsave || gp.config.load(gp.save, "used") ==0) {
                        gp.config.copyFile(4, gp.save);
                        gp.config.loadAll(gp.save);
                    } else {
                        gp.config.loadAll(gp.save);
                    }
                    gp.gameState = gp.playerState;
                    gp.playSound(3);

                }
                if (gp.ui.sellectValueX == 1) {
                    gp.save = 1;
                    if (gp.ui.newsave || gp.config.load(gp.save, "used") ==0) {
                        gp.config.copyFile(4, gp.save);
                        gp.config.loadAll(gp.save);
                    } else {
                        gp.config.loadAll(gp.save);
                    }
                    gp.gameState = gp.playerState;
                    gp.playSound(3);
                }
            }
            if (gp.ui.sellectValueY == 1) {
                if (gp.ui.sellectValueX == 0) {
                    gp.save = 2;
                    if (gp.ui.newsave || gp.config.load(gp.save, "used") ==0) {
                        gp.config.copyFile(4, gp.save);
                        gp.config.loadAll(gp.save);
                    } else {
                        gp.config.loadAll(gp.save);
                    }
                    gp.gameState = gp.playerState;
                    gp.playSound(3);
                }
                if (gp.ui.sellectValueX == 1) {
                    gp.save = 3;
                    if (gp.ui.newsave || gp.config.load(gp.save, "used") ==0) {
                        gp.config.copyFile(4, gp.save);
                        gp.config.loadAll(gp.save);
                    } else {
                        gp.config.loadAll(gp.save);
                    }
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

        }
    }
    public void settingStateClick(MouseEvent e){
        String i = e.getComponent().getName();
        System.out.println(i);
        switch (i) {
            case "Setting Screen: 0":
                break;
            case "Setting Screen: 1":
                if (gp.sound.volumeScale == 0) {
                    gp.sound.volumeScale = 4;
                } else {
                    gp.sound.volumeScale = 0;
                }
                break;
            case "Setting Screen: 2":
                gp.ui.sellectValueY = 2;
                break;
            case "Setting Screen: 3":
               // gp.ui.menuState = gp.ui.controllState;
                break;
            case "Setting Screen: Back":
                gp.gameState = gp.uiState;
                break;
            case "Setting Screen: Save & Quit":
                gp.config.saveAll(gp.save);
                gp.gameState = gp.uiState;
                gp.ui.menuState = gp.ui.titleState;
                break;

            case "Musik: +":
                break;
            case "Musik: -":
                break;

            case "SE: -":
                gp.sound.volumeScale ++;
                gp.sound.volume();;
                break;
            case "SE: +":
                gp.sound.volumeScale --;
                gp.sound.volume();
                break;
        }
    }
    public void settingStateEntered(MouseEvent e){

    }
    public void inventoryStateClick(MouseEvent e){
        System.out.println("Panel Name " + e.getComponent().getName() + " Clicked");
        switch (gp.inventory.currentSlot){
            case 0,1,2,3,4,5,6,7:
                if(!(gp.inventory.select)){
                    gp.inventory.selectSlot = gp.inventory.currentSlot;
                    gp.inventory.select = true;
                }else {
                    gp.inventory.twoSelectSlot = gp.inventory.currentSlot;
                    gp.inventory.twoSelect = true;
                }
                break;
            case 8:
                if(gp.inventory.select){
                gp.inventory.tryequip = true;
                }
                break;
            case 9:
               if(gp.shopEntry){
                   gp.inventory.trysell = true;
               }
                break;
            case 10:
                if(gp.shopEntry){
                    gp.gameState = gp.shopState;
                }else {
                    gp.gameState = gp.playerState;
                }
                break;
        }



    }
    public void inventoryStateEntered(MouseEvent e){
        System.out.println("Panel Name " + e.getComponent().getName() + " Entered");
        String i = e.getComponent().getName();
        System.err.println(i);
        switch (i) {
            case "Slot: 0":
                gp.inventory.currentSlotValueY = 0;
                gp.inventory.currentSlotValueX = 0;
                gp.inventory.currentSlot = 0;
                gp.playSound(1);
                break;
            case "Slot: 1":
                gp.inventory.currentSlotValueY = 0;
                gp.inventory.currentSlotValueX = 1;
                gp.inventory.currentSlot = 1;
                gp.playSound(1);
                break;
            case "Slot: 2":
                gp.inventory.currentSlotValueY = 0;
                gp.inventory.currentSlotValueX = 2;
                gp.inventory.currentSlot = 2;
                gp.playSound(1);
                break;
            case "Slot: 3":
                gp.inventory.currentSlotValueY = 0;
                gp.inventory.currentSlotValueX = 3;
                gp.inventory.currentSlot = 3;
                gp.playSound(1);
                break;
            case "Slot: 4":
                gp.inventory.currentSlotValueY = 1;
                gp.inventory.currentSlotValueX = 0;
                gp.inventory.currentSlot = 4;
                gp.playSound(1);
                break;
            case "Slot: 5":
                gp.inventory.currentSlotValueY = 1;
                gp.inventory.currentSlotValueX = 1;
                gp.inventory.currentSlot = 5;
                gp.playSound(1);
                break;
            case "Slot: 6":
                gp.inventory.currentSlotValueY = 1;
                gp.inventory.currentSlotValueX = 2;
                gp.inventory.currentSlot = 6;
                gp.playSound(1);
                break;
            case "Slot: 7":
                gp.inventory.currentSlotValueY = 1;
                gp.inventory.currentSlotValueX = 3;
                gp.inventory.currentSlot = 7;
                gp.playSound(1);
                break;
            case "Button: equip":
                gp.inventory.currentSlot = 8;
                gp.playSound(1);
                break;
            case "Button: sell":
                gp.inventory.currentSlot = 9;
                gp.playSound(1);
                break;
            case "Button: back":
                gp.inventory.currentSlot = 10;
                gp.playSound(1);
                break;
        }


    }
    public void shopStateClick(MouseEvent e) {
        String i = e.getComponent().getName();
        System.out.println(i + " Click");
            switch (i) {
                case "Item: 0":
                    gp.shop.selectItem = 0;
                    gp.shop.select = true;
                    break;
                case "Item: 1":
                    gp.shop.selectItem = 1;
                    gp.shop.select = true;
                    break;
                case "Item: 2":
                    gp.shop.selectItem = 2;
                    gp.shop.select = true;
                    break;
                case "Item: 3":
                    gp.shop.selectItem = 3;
                    gp.shop.select = true;
                    break;
                case "Button: 0":
                    gp.shop.resetCurser();
                    gp.gameState = gp.playerState;
                    break;
                case "Button: 1":
                    gp.shop.resetCurser();
                    gp.shopEntry = true;
                    gp.gameState = gp.inventoryState;
                    break;
                case "Button: 2":
                    int freeslot = -1;
                    for (int ii = 0; ii < 8; ii++) {
                        if (gp.player.item[ii][0] == 0) {
                            freeslot = ii;
                            break;
                        }
                    }
                    if (freeslot >= 0) {
                        if (gp.player.goldcheck(gp.dba.getItem(gp.shop.item[gp.shop.selectItem][0], gp.shop.item[gp.shop.selectItem][1]).getGoldwert())) {
                            gp.player.item[freeslot][0] = gp.shop.item[gp.shop.selectItem][0];
                            gp.player.item[freeslot][1] = gp.shop.item[gp.shop.selectItem][1];
                            gp.shop.console = "Letze Aktion : " + gp.dba.getItem(gp.shop.item[gp.shop.selectItem][0],gp.shop.item[gp.shop.selectItem][1]).getName() + " - " + gp.dba.getItem(gp.shop.item[gp.shop.selectItem][0],gp.shop.item[gp.shop.selectItem][1]).getGoldwert() + "€";
                            gp.shop.item[gp.shop.selectItem][0] = 0;
                        } else {
                            gp.shop.console = "Du hast nicht genug Geld";
                        }
                    } else {
                        gp.shop.console = "Du hast keinen Freien Slot";
                    }
                    break;
                case "Button: 3":
                    if(gp.player.goldcheck(20)){
                        gp.shop.console = "Letzter Aktion: Randome -20";
                        gp.shop.newShop = true;
                    }
                    break;
            }
    }
    public void shopStateEntered(MouseEvent e){
        String i = e.getComponent().getName();
        System.out.println(i + " Entered");
        switch (i){
            case "Item: 0":
                gp.shop.currentItem = 0;
                break;
            case "Item: 1":
                gp.shop.currentItem = 1;
                break;
            case "Item: 2":
                gp.shop.currentItem = 2;
                break;
            case "Item: 3":
                gp.shop.currentItem = 3;
                break;
        }
    }
    public void miniGameStateClick(MouseEvent e){
        System.out.println("Panel Name " + e.getComponent().getName() + " Clicked");
        if(gp.miniGame.amZug == 1 && !gp.miniGame.end && gp.miniGame.slotState[gp.miniGame.currentSlot] == 0 ) {
                gp.miniGame.slotState[gp.miniGame.currentSlot] = 1;
                gp.miniGame.amZug = 2;
        }
    }
    public void miniGameStateEntered(MouseEvent e){
        System.out.println("Panel Name " + e.getComponent().getName() + " Entered");
        String i = e.getComponent().getName();
        System.err.println(i);
            switch (i) {
                case "Slot: 0":
                    gp.miniGame.currentSlotValueY = 0;
                    gp.miniGame.currentSlotValueX = 0;
                    gp.miniGame.currentSlot = 0;
                    gp.playSound(1);
                    break;
                case "Slot: 1":
                    gp.miniGame.currentSlotValueY = 0;
                    gp.miniGame.currentSlotValueX = 1;
                    gp.miniGame.currentSlot = 1;
                    gp.playSound(1);
                    break;
                case "Slot: 2":
                    gp.miniGame.currentSlotValueY = 0;
                    gp.miniGame.currentSlotValueX = 2;
                    gp.miniGame.currentSlot = 2;
                    gp.playSound(1);
                    break;
                case "Slot: 3":
                    gp.miniGame.currentSlotValueY = 1;
                    gp.miniGame.currentSlotValueX = 0;
                    gp.miniGame.currentSlot = 3;
                    gp.playSound(1);
                    break;
                case "Slot: 4":
                    gp.miniGame.currentSlotValueY = 1;
                    gp.miniGame.currentSlotValueX = 1;
                    gp.miniGame.currentSlot = 4;
                    gp.playSound(1);
                    break;
                case "Slot: 5":
                    gp.miniGame.currentSlotValueY = 1;
                    gp.miniGame.currentSlotValueX = 2;
                    gp.miniGame.currentSlot = 5;
                    gp.playSound(1);
                    break;
                case "Slot: 6":
                    gp.miniGame.currentSlotValueY = 2;
                    gp.miniGame.currentSlotValueX = 0;
                    gp.miniGame.currentSlot = 6;
                    gp.playSound(1);
                    break;
                case "Slot: 7":
                    gp.miniGame.currentSlotValueY = 2;
                    gp.miniGame.currentSlotValueX = 1;
                    gp.miniGame.currentSlot = 7;
                    gp.playSound(1);
                    break;
                case "Slot: 8":
                    gp.miniGame.currentSlotValueY = 2;
                    gp.miniGame.currentSlotValueX = 2;
                    gp.miniGame.currentSlot = 8;
                    gp.playSound(1);
                    break;
            }
        }
        public void fightStateClick(MouseEvent e) {
            String i = e.getComponent().getName();
            System.out.println(i + " Click");
            switch (i) {
                case "Fight Button: 0":
                    gp.fight.fight = true;
                    break;
                case "Fight Button: 1":
                    if(!(gp.fight.first)) {
                        gp.gameState = gp.playerState;
                    }
                    break;
                case "Item: 0":
                    gp.fight.useItem(2);
                    break;
                case "Item: 1":
                    gp.fight.useItem(3);
                    break;



            }
        }
        public void fightStateEntered(MouseEvent e){
            String i= e.getComponent().getName();
            System.out.println(i+ " Enter");
        }
    public void gameOverStateClick(MouseEvent e){
        String i = e.getComponent().getName();
        if(i == "BACK"){
            gp.gameState = gp.uiState;
            gp.ui.menuState = gp.ui.titleState;
        }
    }
}

