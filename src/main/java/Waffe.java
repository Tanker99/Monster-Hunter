

import java.awt.image.BufferedImage;

public class Waffe {
    //Standart
    GamePanel gp;

    //Get Variablen
    public String name;
    public int kraft;
    public int goldwert;
    public String text;

    //Defin Variablen
    public static final int Wanzahl = 7;
    BufferedImage waffe[];

    //Datenbank
    public static String[] Waffen = {"Schwacher Bogen", "Starker Bogen", "Streitaxt (Eine KLinge)", "Streitaxt (Doppelte Klinge)", "Schwert", "Feuerschwert", "Morgenstern", "Armbrust"};
    public static int[] WKraft = {2, 5, 4, 6, 3, 5, 6, 4};
    public static int[] WGoldwert = {3, 7, 4, 8, 4, 9, 6, 5};

    public Waffe(GamePanel gp){
        this.gp = gp;
        waffe[] = new BufferedImage[Wanzahl];
        getImage();
        
    }

    public void getWaffedetails(int n) {
        name = Waffe.Wname[n];
        kraft = Waffe.Wkraft[n];
        goldwert = Waffe.Wgoldwert[n];
    }

    public void getImage(){
        this.gp = gp;
        
        try {
            waffe[0] = ImageIO.read(Waffe.class.getResource("main/resources/items/Schwacher Bogen.png"));
            waffe[1] = ImageIO.read(Waffe.class.getResource("main/resources/items/Starker Bogen.png"));
            waffe[2] = ImageIO.read(Waffe.class.getResource("main/resources/items/Streitaxt (Eine KLinge).png"));
            waffe[3] = ImageIO.read(Waffe.class.getResource("main/resources/items/Streitaxt (Doppelte Klinge).png"));
            waffe[4] = ImageIO.read(Waffe.class.getResource("main/resources/items/Schwert.png"));
            waffe[5] = ImageIO.read(Waffe.class.getResource("main/resources/items/Feuerschwert.png"));
            waffe[6] = ImageIO.read(Waffe.class.getResource("main/resources/items/Morgenstern.png"));
            waffe[7] = ImageIO.read(Waffe.class.getResource("main/resources/items/Armbrust.png"));
            

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("DB.Waffe Image Error");
        }
    }
}