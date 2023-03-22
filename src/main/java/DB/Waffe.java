package DB;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Waffe {
    GamePanel gp;
    public static final int Wanzahl = 0;
    public String name;
    public int Kraft;
    public int Goldwert;
    BufferedImage waffe[] new BufferedImage[7];

    public static String[] Waffen = {"Schwacher Bogen", "Starker Bogen", "Streitaxt (Eine KLinge)", "Streitaxt (Doppelte Klinge)", "Schwert", "Feuerschwert", "Morgenstern", "Armbrust"};
    public static int[] WKraft = {2, 5, 4, 6, 3, 5, 6, 4};
    public static int[] WGoldwert = {3, 7, 4, 8, 4, 9, 6, 5};

    public void getWaffe(int n) {
        name = Waffe.Waffen[n];
        Kraft = Waffe.WKraft[n];
        Goldwert = Waffe.WGoldwert[n];
    }

    public IMage(GamePanel gp){
        this.gp = gp;
        waffe[] = new BufferedImage[gp.waffe.Wanzahl];
        
        try{
        waffe[1] = ImageIO.read(waffe.class.getResource("main/resources/items/Feuerschwert.png"));
        } 
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Waffe Image Error");
        }
    
    }
    public BufferedImage loadImage() throws IOException {
        int i = 0;
        BufferedImage test;
        test = ImageIO.read(waffe.class.getResource("main/resources/items/Feuerschwert.png"));
        switch (i){
            case 1:
                return test;
        }

        
        try {
            waffe[0] = ImageIO.read(waffe.class.getResource("main/resources/items/Schwacher Bogen.png"));
            waffe[1] = ImageIO.read(waffe.class.getResource("main/resources/items/Starker Bogen.png"));
            waffe[2] = ImageIO.read(waffe.class.getResource("main/resources/items/Streitaxt (Eine KLinge).png"));
            waffe[3] = ImageIO.read(waffe.class.getResource("main/resources/items/Streitaxt (Doppelte Klinge).png"));
            waffe[4] = ImageIO.read(waffe.class.getResource("main/resources/items/Schwert.png"));
            waffe[5] = ImageIO.read(waffe.class.getResource("main/resources/items/Feuerschwert.png"));
            waffe[6] = ImageIO.read(waffe.class.getResource("main/resources/items/Morgenstern.png"));
            waffe[7] = ImageIO.read(waffe.class.getResource("main/resources/items/Armbrust.png"));
            

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Waffe Image Error");
        }
         
        return test;
    }
}