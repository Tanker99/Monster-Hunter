
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
            case 2:
                if (!(item > Ruestung.rAnzahl)) {
                    return Ruestung.ruestung[item];
                }
            case 3:
                if(!( item > Trank.tAnzahl)){
                    return Trank.trank[item];
                }
        }


        return null;
    }

}