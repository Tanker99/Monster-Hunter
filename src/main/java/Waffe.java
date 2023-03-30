import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Waffe {
    //Standart
    GamePanel gp;

    //Get Variablen
    public String name;
    public int kraft;
    public int goldwert;
    public String text;

    //Defin Variablen
    public static final int wAnzahl = 8;
    BufferedImage wBild[] = new BufferedImage[8];

    //Datenbank
    public static String[] wName = {"Schwacher Bogen", "Starker Bogen", "Streitaxt (Eine KLinge)", "Streitaxt (Doppelte Klinge)", "Schwert", "Feuerschwert", "Morgenstern", "Armbrust"};
    public static int[] wKraft = {2, 5, 4, 6, 3, 5, 6, 4};
    public static int[] wGoldwert = {3, 7, 4, 8, 4, 9, 6, 5};
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

    public Waffe(GamePanel gp){
        this.gp = gp;
        getImage();
        
    }

    public String getName(int n){
        return wName[n];
    }

    public int getKraft(int n){
        return wKraft[n];
    }

    public int getGoldwert(int n){
        return wGoldwert[n];
    }
    
    public String getText(int n){
        return wText[n];
    }

    public void getImage(){
        this.gp = gp;
        
        try {
            wBild[0] = ImageIO.read(Waffe.class.getResource("/items/Schwacher Bogen.png"));
            wBild[1] = ImageIO.read(Waffe.class.getResource("/items/Starker Bogen.png"));
            wBild[2] = ImageIO.read(Waffe.class.getResource("/items/Axt.png"));
            wBild[3] = ImageIO.read(Waffe.class.getResource("/items/Streitaxt.png"));
            wBild[4] = ImageIO.read(Waffe.class.getResource("/items/Schwert.png"));
            wBild[5] = ImageIO.read(Waffe.class.getResource("/items/Feuerschwert.png"));
            wBild[6] = ImageIO.read(Waffe.class.getResource("/items/Morgenstern.png"));
            wBild[7] = ImageIO.read(Waffe.class.getResource("/items/Armbrust.png"));
            

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("DB.Waffe Image Error");
        }
    }
}