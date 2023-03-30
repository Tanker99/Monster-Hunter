import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ruestung {
    //Standart
    GamePanel gp;

    //Get Variablen
    public String name;
    public int kraft;
    public int goldwert;
    public String text;

    //Define Variablen
    public static final int rAnzahl = 6;
    BufferedImage rBild[] = new BufferedImage[6];
    
    //Datenbank
    public static String[] rName={"Rüstung1","Rüstung2","Rüstung3","Rüstung4","Rüstung5","Rüstung6","Rüstung7","Rüstung8"};
    public static int[] rKraft={1,2,3,4,5,6,7,8};
    public static int[] rGoldwert={1,2,3,4,5,6,7,8};
    public static String[] rText = {"",""}
    
    public Trank(GamePanel gp){
        this.gp = gp;
        getImage();
        
    }

    public String getName(int n){
        return rName[n];
    }

    public int getKraft(int n){
        return rKraft[n];
    }

    public int getGoldwert(int n){
        return rGoldwert[n];
    }

    public String getText(int n){
        return rText[n];
    }
    
    public void getImage(){
        this.gp = gp;
     
        try {
            rBild[0] = ImageIO.read(Ruestung.class.getResource("/items/Einhorn-Pipi.png"));
            rBild[1] = ImageIO.read(Ruestung.class.getResource("/items/Rote Bete Saft.png"));
            rBild[2] = ImageIO.read(Ruestung.class.getResource("/items/Pep-sie Gemisch.png"));
            rBild[3] = ImageIO.read(Ruestung.class.getResource("/items/Ingwer-Shot.png"));
            rBild[4] = ImageIO.read(Ruestung.class.getResource("/items/Met.png"));
            rBild[5] = ImageIO.read(Ruestung.class.getResource("/items/Wasser.png"));
            

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("DB.Rüstung Image Error");
     }
}

