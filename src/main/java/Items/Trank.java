package Items;

import Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Trank extends Items{

    GamePanel gp;

    //Get Variablen
    public String name;
    public int kraft;
    public int goldwert;
    public String text;

    //Defin Variablen
    public static final int tAnzahl = 6;
    public static Trank trank[];

    //Datenbank
    public static String[] tName = {"Einhorn-Pipi", "Rote Bete Saft", "Pep-sie Gemisch", "Ingwer-shot", "Met", "Wasser"};
    public static int[] tKraft = {18, 16, 40, 24, -29, 14};
    public static int[] tGoldwert = {22, 39, 14, 20, 25, 6};
    public static String[] tText = {
            "Tatsächlich kacken Einhörner nicht nur Muffins und Donuts. Sie pieseln sogar Regenbögen.",
            "Nicht jedem schmeckt es, aber in diesem Fall kann es Dein Leben retten.",
            "Nachdem ein Zauberer unzählige Pülverchen vermischt hatte entstand dieses gut schmeckende Koffeinhaltige Gesöff.",
            "Wie der Name schon sagt, ballert dir diese Plörre echt die Geschmacksknospen von der Zunge!",
            "Schon die Wickinger wussten einen guten Tropfen hiervon wert zu schätzen. Auch wenn es nicht unbedingt der Gesundheit gut tat!",
            "Aus der unberührten Natur entnommenes Felsquellwasser."
    };

    public Trank(String name, int kraft, int goldwert, String itemText, BufferedImage image){
        super(name, kraft, goldwert, itemText, image);
    }
    public Trank(GamePanel gp) {
        super(gp);
        this.gp = gp;
    }
    public void loadItem(){
        trank = new Trank[tAnzahl];
        for (int i = 0; i < tAnzahl; i++){
            trank[i] = new Trank(tName[i],tKraft[i],tGoldwert[i],tText[i],gp.image.tBild[i]);
        }
    }
    public static Trank getTrank(int i){
        return trank[i];
    }

}