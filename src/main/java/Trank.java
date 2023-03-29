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
    public static final int tAnzahl = 6;
    BufferedImage tBild[] = new BufferedImage[6];

    //Datenbank
    public static String[] tName = {"Einhorn-Pipi","Rote Bete Saft","Pep-sie Gemisch","Ingwer-shot","Met","Wasser"};
    public static int[] tKraft = {6,8,4,12,-4,2};
    public static int[] tGoldwert = {10,4,2,7,9,1};
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

     public void getImage(){
        this.gp = gp;
     
        try {
            tBild[0] = ImageIO.read(Trank.class.getResource("/items/Einhorn-Pipi.png"));
            tBild[1] = ImageIO.read(Trank.class.getResource("/items/Rote Bete Saft.png"));
            tBild[2] = ImageIO.read(Trank.class.getResource("/items/Pep-sie Gemisch.png"));
            tBild[3] = ImageIO.read(Trank.class.getResource("/items/Ingwer-Shot.png"));
            tBild[4] = ImageIO.read(Trank.class.getResource("/items/Met.png"));
            tBild[5] = ImageIO.read(Trank.class.getResource("/items/Wasser.png"));
            

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("DB.Trank Image Error");
     }
}