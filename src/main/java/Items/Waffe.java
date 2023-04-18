package Items;
import Game.GamePanel;
import java.awt.image.BufferedImage;

public class Waffe extends Items {


    GamePanel gp;
    //Get Variablen
    public String name;
    public int kraft;
    public int goldwert;
    public String text;

    //Defin Variablen
    public static final int wAnzahl = 8;
    public static Waffe waffe[];

    //Datenbank
    public static String[] wName = {"Schwacher Bogen", "Starker Bogen", "Streitaxt (Eine KLinge)", "Streitaxt (Doppelte Klinge)", "Schwert", "Feuerschwert", "Morgenstern", "Armbrust"};
    public static int[] wKraft = {12, 18, 14, 20, 16, 22, 18, 24};
    public static int[] wGoldwert = {15, 20, 19, 26, 30, 45, 50, 65};
    public static String[] wText = {
            "Aus einem weichen Holz gefertig, doch trotzdem tödlich.",
            "Verstärkte Wurfarme machen den bereits guten Bogen noch BESSER. Höher, Weiter, Tödlicher!",
            "Einst ein Werkzeug für Bauern. Heute ein Werkzeug des Todes!",
            "Warum nur auf einer Seite schneiden können? Aus einem Werkzeug wird ein rundrum scharfes Tötungsgerät!",
            "Nur ein wahrer Ritter wie du ist dazu in der Lage, ein geschliffenes Stück Metall, wie dieses, kunstvoll durch die Körper deine Feinde gleiten zu lassen.",
            "Nachdem mit diesem Schwert ein Drache erlegt wurde, fing es feuer und hörte seitdem nicht mehr auf alles und jeden zu verbrennen, mit dem es in Berührung kam.",
            "Es ist ein Wunder, was ein großer Hebel und gespitzter Stahl in Kombination miteinander anrichten können.",
            "Klein aber fein. Mit diesem Gerät Bolzen Sie wortwörtlich alles aus dem Weg!"
    };

    public Waffe(String name, int kraft, int goldwert, String itemText, BufferedImage image) {
        super(name, kraft, goldwert, itemText, image);

    }

    public Waffe(GamePanel gp) {
        super(gp);
        this.gp = gp;
    }

    public void loadItem() {
        waffe = new Waffe[wAnzahl];
        for (int i = 0; i < wAnzahl; i++) {
            waffe[i] = new Waffe(wName[i], wKraft[i], wGoldwert[i], wText[i], gp.image.wBild[i]);
        }
    }

    public static Waffe getWaffe(int i) {
        return waffe[i];
    }
}