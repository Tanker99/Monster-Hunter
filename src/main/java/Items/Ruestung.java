package Items;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ruestung extends Items{

    //Get Variablen
    public String name;
    public int kraft;
    public int goldwert;
    public String text;

    //Define Variablen
    public static final int rAnzahl = 3;
    static BufferedImage rBild[] = new BufferedImage[3];
    public static Ruestung ruestung[];
    
    //Datenbank
    public static String[] rName={"Eisenr�stung","Goldr�stung","Lederr�stung","Jader�stung","Leichte r�stung","Die Unsichtbare"};
    public static int[] rKraft={20,12,7};
    public static int[] rGoldwert={34,50,24,345,10,556};
    public static String[] rText = {
    "Damals wie heute bietet eine R�stung aus hochwertigem Eisen einen guten Schutz, welcher dem Tr�ger im Kampf einen Vorteil verschafft.",
    "Auch wenn die Weichheit des Materials im Kampf von Nachteil ist, dr�ckt man durch diese R�stung Erfolg und Mut aus.",
    "Weich aber robust. Leder ist in jedem Handwerk gefragt. Auch im Handwerk mit Schwertern!"
    };

    public Ruestung(String name, int kraft, int goldwert, String itemText, BufferedImage image){
        super(name, kraft, goldwert, itemText, image);
    }
    public static void loadItem(){
        loadImage();
        ruestung = new Ruestung[rAnzahl];
        for (int i = 0; i < rAnzahl; i++){
            ruestung[i] = new Ruestung(rName[i],rKraft[i],rGoldwert[i],rText[i],rBild[i]);
        }
    }
    public static Ruestung getRuestung(int i){
        return ruestung[i];
    }

    public static void loadImage(){

        try {
            rBild[0] = ImageIO.read(Ruestung.class.getResource("/items/Eisenruestung.png"));
            rBild[1] = ImageIO.read(Ruestung.class.getResource("/items/Goldruestung.png"));
            rBild[2] = ImageIO.read(Ruestung.class.getResource("/items/Lederruestung.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("DB.R�stung Image Error");
        }
    }
}

