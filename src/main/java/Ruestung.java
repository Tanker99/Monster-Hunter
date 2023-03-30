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
    public static final int rAnzahl = 2;
    BufferedImage rBild[] = new BufferedImage[2];
    
    //Datenbank
    public static String[] rName={"Eisenrüstung","Goldrüstung"};
    public static int[] rKraft={20,12};
    public static int[] rGoldwert={34,50};
    public static String[] rText = {
    "Damals wie heute bietet eine Rüstung aus hochwertigem Eisen einen guten Schutz, welcher dem Träger im Kampf einen Vorteil verschafft.",
    "Auch wenn die Weichheit des Materials im Kampf von Nachteil ist, drückt man durch diese Rüstung Erfolg und Mut aus."
    }
    
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
            rBild[0] = ImageIO.read(Ruestung.class.getResource("/items/Eisenrüstung.png"));
            rBild[1] = ImageIO.read(Ruestung.class.getResource("/items/Goldrüstung.png"));
            

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("DB.Rüstung Image Error");
     }
}

