package Game;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Image {
    //default
    BufferedImage defaultImage;

    public BufferedImage imgX, imgO;
    //Waffe
    public BufferedImage[] wBild = new BufferedImage[8];
    public String[] waffe = {"/items/Schwacher Bogen.png"
            ,"/items/Starker Bogen.png"
            ,"/items/Axt.png"
            ,"/items/Streitaxt.png"
            ,"/items/Schwert.png"
            ,"/items/Feuerschwert.png"
            ,"/items/Morgenstern.png"
            ,"/items/Armbrust.png"};

    //Ruestung

    //Trank


    public Image() {
        try {
            defaultImage = ImageIO.read(Image.class.getResource("/back.png"));
        } catch (IOException e) {
            System.err.print("default Game.Image error!!!!!!");
        }
        for (int i = 0; i <= waffe.length -1; i++){

           wBild[i] = loadImage(waffe[i],defaultImage);
        }
        loadImageee();

    }

    public BufferedImage loadImage(String filePath,BufferedImage defaultImage) {
        try {
            BufferedImage object = ImageIO.read(Objects.requireNonNull(Image.class.getResource(filePath)));
            System.err.println(object + ""+ filePath);
            return object;
        } catch (IOException e) {
            System.err.print("Bild wurde nicht gefunden: " + filePath);
            return defaultImage;
        }
    }

    public void loadImageee(){

        try {
            imgX = ImageIO.read(Image.class.getResource("/Kreis.png"));
            imgO = ImageIO.read(Player.class.getResource("/x.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("player Game.Image Error");
        }
    }
}