import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image {
    GamePanel gp;

    public BufferedImage imgX, imgO;


    public Image(GamePanel gp) {
        this.gp = gp;
        loadImage();

    }

    public void loadImage(){

        try {
            imgX = ImageIO.read(Image.class.getResource("/Kreis.png"));
            imgO = ImageIO.read(Player.class.getResource("/x.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("player Image Error");
        }
    }
}
