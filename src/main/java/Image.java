import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image {

    GamePanel gp;
    BufferedImage player[] = new BufferedImage[5]; //
    BufferedImage waffe[] = new BufferedImage[gp.waffe.Wanzahl]; //
    BufferedImage ruestung[] = new BufferedImage[gp.ruestung.Ranzahl];
    BufferedImage trank[] = new BufferedImage[gp.trank.Tanzahl];

    public Image(GamePanel gp) {
        this.gp = gp;

    }

    public void loadImage() throws IOException {

        try {
            player[0] = ImageIO.read(Player.class.getResource("/player/playerb.png"));
            player[1] = ImageIO.read(Player.class.getResource("/player/playerc.png"));
            player[2] = ImageIO.read(Player.class.getResource("/player/playerl1.png"));
            player[3] = ImageIO.read(Player.class.getResource("/player/playerl2.png"));
            player[4] = ImageIO.read(Player.class.getResource("/player/playerr1.png"));
            player[5] = ImageIO.read(Player.class.getResource("/player/playerr2.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("player Image Error");
        }

    }
}
