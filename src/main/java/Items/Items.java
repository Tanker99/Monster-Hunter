package Items;

import java.awt.image.BufferedImage;

public class Items {


    //Variablen
    private String name;
    private int kraft;
    private int goldwert;
    private String itemText;
    private BufferedImage image;

   public Items(String name, int kraft, int goldwert,String itemText, BufferedImage image) {
       this.name = name;
       this.kraft = kraft;
       this.goldwert = goldwert;
       this.itemText = itemText;
       this.image = image;
   }
    public String getName() {
        return name;
    }

    public int getKraft() {
        return kraft;
    }

    public int getGoldwert() {
        return goldwert;
    }

    public String getText() {
        return itemText;
    }

    public BufferedImage getImagee(){
        return image;
    }
}

