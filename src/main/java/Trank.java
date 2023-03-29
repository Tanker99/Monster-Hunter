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
    BufferedImage tBild[] = new BufferedImage[8];

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

     public void getImage(){
        this.gp = gp;
     
        try {
            tBild[0] = ImageIO.read(Trank.class.getResource("/items/Schwacher Bogen.png"));
            tBild[1] = ImageIO.read(Trank.class.getResource("/items/Starker Bogen.png"));
            tBild[2] = ImageIO.read(Trank.class.getResource("/items/Axt.png"));
            tBild[3] = ImageIO.read(Trank.class.getResource("/items/Streitaxt.png"));
            tBild[4] = ImageIO.read(Trank.class.getResource("/items/Schwert.png"));
            tBild[5] = ImageIO.read(Trank.class.getResource("/items/Feuerschwert.png"));
            tBild[6] = ImageIO.read(Trank.class.getResource("/items/Morgenstern.png"));
            tBild[7] = ImageIO.read(Trank.class.getResource("/items/Armbrust.png"));
            

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("DB.Trank Image Error");
     }
}