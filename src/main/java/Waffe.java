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
    public static String[] wText = {"",""};

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