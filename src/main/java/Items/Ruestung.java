package Items;

import Game.GamePanel;

import java.awt.image.BufferedImage;

public class Ruestung extends Items{

    //Get Variablen
    GamePanel gp;
    public String name;
    public int kraft;
    public int goldwert;
    public String text;

    //Define Variablen
    public static final int rAnzahl = 5;
    public static Ruestung ruestung[];
    
    //Datenbank
    public static String[] rName={"Eisenrüstung","Goldrüstung","Lederrüstung","Diamantrüstung","Die Unsichtbare"};
    public static int[] rKraft={20,12,7,28};
    public static int[] rGoldwert={34,50,24,200,556};
    public static String[] rText = {
    "Damals wie heute bietet eine R�stung aus hochwertigem Eisen einen guten Schutz, welcher dem Tr�ger im Kampf einen Vorteil verschafft.",
    "Auch wenn die Weichheit des Materials im Kampf von Nachteil ist, dr�ckt man durch diese R�stung Erfolg und Mut aus.",
    "Weich aber robust. Leder ist in jedem Handwerk gefragt. Auch im Handwerk mit Schwertern!"
    "Dank seiner unfassbaren Robustheit bietet der Diamant auch im Kampf einen Schutz, der nahezu unzerstörbar ist!"
    };

    public Ruestung(String name, int kraft, int goldwert, String itemText, BufferedImage image){
        super(name, kraft, goldwert, itemText, image);
    }
    public Ruestung(GamePanel gp) {
        super(gp);
        this.gp = gp;
    }
    public void loadItem(){
        ruestung = new Ruestung[rAnzahl];
        for (int i = 0; i < rAnzahl; i++){
            ruestung[i] = new Ruestung(rName[i],rKraft[i],rGoldwert[i],rText[i],gp.image.rBild[i]);
        }
    }
    public static Ruestung getRuestung(int i){
        return ruestung[i];
    }


}

