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
    public static final int rAnzahl = 6;
    public static Ruestung ruestung[];
    
    //Datenbank
    public static String[] rName={"Eisenrüstung","Goldrüstung","Lederrüstung","Diamantrüstung","Jaderüstung","Die Unsichtbare"};
    public static int[] rKraft={10,8,7,28,22,30};
    public static int[] rGoldwert={28,50,24,70,75,80};
    public static String[] rText = {
    "Damals wie heute bietet eine R�stung aus hochwertigem Eisen einen guten Schutz, welcher dem Träger im Kampf einen Vorteil verschafft.",
    "Auch wenn die Weichheit des Materials im Kampf von Nachteil ist, drückt man durch diese R�stung Erfolg und Mut aus.",
    "Weich aber robust. Leder ist in jedem Handwerk gefragt. Auch im Handwerk mit Schwertern!",
    "Dank seiner unfassbaren Robustheit bietet der Diamant auch im Kampf einen Schutz, der nahezu unzerstörbar ist!",
    "Sein grünes Schimmern könnte den Gegner blenden. Zu deinem Vorteil.",
    "Aus Asteroiden-Material geschmiedet macht diese Rüstung seinen Träger fast vollstädig unsichtbar."
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

