package Game;

import Items.Items;
import Items.Waffe;
import Items.Trank;
import Items.Ruestung;

public class DBaufruf {
    GamePanel gp;

    public DBaufruf(GamePanel gp){
        this.gp = gp;

        gp.waffe.loadItem();
        gp.trank.loadItem();
        gp.ruestung.loadItem();
    }

    public Items getItem(int db, int item) {
        switch (db) {
            case 0:
                return null;
            case 1:
                if (!(item > gp.waffe.wAnzahl)) {
                    return gp.waffe.waffe[item];
                }
                return null;
            case 2:
                if (!(item > gp.ruestung.rAnzahl)) {
                    return gp.ruestung.ruestung[item];
                }
                return null;
            case 3:
                if(!( item > gp.trank.tAnzahl)){
                    return gp.trank.trank[item];
                }
                return null;
        }


        return null;
    }
    public Integer getcount(int db){
        switch (db) {
            case 0:
                return 0;
            case 1:
                return gp.waffe.wAnzahl;
            case 2:
                return gp.ruestung.rAnzahl;
            case 3:
               return gp.trank.tAnzahl;
        }


        return null;

    }




}