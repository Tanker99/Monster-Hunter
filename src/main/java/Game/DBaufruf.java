package Game;

import Items.Items;
import Items.Waffe;
import Items.Trank;
import Items.Ruestung;

public class DBaufruf {
    GamePanel gp;

    public DBaufruf(GamePanel gp){
        this.gp = gp;

       Waffe.loadItem();
        Trank.loadItem();
        Ruestung.loadItem();
    }

    public Items getItem(int db, int item) {
        switch (db) {
            case 0:
                return null;
            case 1:
                if (!(item > Waffe.wAnzahl)) {
                    return Waffe.waffe[item];
                }
                return null;
            case 2:
                if (!(item > Ruestung.rAnzahl)) {
                    return Ruestung.ruestung[item];
                }
                return null;
            case 3:
                if(!( item > Trank.tAnzahl)){
                    return Trank.trank[item];
                }
                return null;
        }


        return null;
    }
    /*public Integer getcount(int db){
        switch (db) {
            case 0:
                return 0;
            case 1:
                return Waffe.wAnzahl;
            case 2:
                return Ruestung.rAnzahl;
            case 3:
               return Trank.tAnzahl;
        }


        return null;

    }


     */

}