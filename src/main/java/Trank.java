import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Trank {
    //Standart
    GamePanel gp;

    //Get Variablen
    public String name;
    public int kraft;
    public int goldwert;
    public String text;

    //Defin Variablen
    public static final int tAnzahl = 8;
    BufferedImage trank[] = new BufferedImage[8];

    //Datenbank
    public static String[] tName = {"Einhorn-Pipi","Rote Bete Saft","Pep-sie Gemisch","Ingwer-shot","Met","Rüstung6","Rüstung7","Rüstung8"};
    public static int[] tKraft = {6,8,4,12,-4,6,7,8};
    public static int[] tGoldwert = {10,4,2,7,9,6,7,8};
    public static String[] tText = {"",""};

    public Trank(GamePanel gp){
        this.gp = gp;
        getImage();
        
    }

    public String getName(int n){
        return tName[n];
    } 

    public int getKraft(int n){
        return tKraft[n];
    }

    public int getGoldwert(int n){
        return tGoldwert[n];
    }
    
    public String getText(int n){
        return tText[n];

    }

}