package Game;
import Items.Ruestung;
import Items.Trank;
import Items.Waffe;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Image {
    //default
    BufferedImage defaultImage;
    //Waffe
    public BufferedImage[] wBild;
    public String[] waffe = {
            "/items/Schwacher Bogen.png"
            ,"/items/Starker Bogen.png"
            ,"/items/Axt.png"
            ,"/items/Streitaxt.png"
            ,"/items/Schwert.png"
            ,"/items/Feuerschwert.png"
            ,"/items/Morgenstern.png"
            ,"/items/Armbrust.png"
            };

    //Ruestung
    public BufferedImage[] rBild;
    public String[] ruestung = {
            "/items/Eisenruestung.png"
            ,"/items/Goldruestung.png"
            ,"/items/Lederruestung.png"
            ,"/items/Diamantruestung.png"
            ,"/items/Jaderuestung.png"
            ,"/items/unsichtbareruestung.png"
            };
    //Trank
    public BufferedImage[] tBild;
    public String[] trank = {
            "/items/Einhorn-Pipi.png"
            ,"/items/Rote Bete Saft.png"
            ,"/items/Pep-sie Gemisch.png"
            ,"/items/Ingwer-Shot.png"
            ,"/items/Met.png"
            ,"/items/Wasser.png"
            };
    //INV Rüstung
    public  BufferedImage[] iRBild;
    public String[] iRString = {
            "/player/iron/playerci1.png"
            , "/player/gold/playercg1.png"
            , "/player/leather/playercl1.png"
            , "/player/dia/playercd1.png"
            , "/player/jade/playercj1.png"
            , "/player/invisible/playerci1.png"
    };
    public  BufferedImage iRDefault;
    public String iRDefaultString = "/player/playerc1.png";

    //Sonstige images
    public BufferedImage imgX, imgO;

    public Image() {
        //load Default Image
        loadDefault();

        //load db image
        loadDBImage();

        //Load Inventory Image
        loadInvBilder();


        loadImageee();

    }

    public void loadDefault(){
        try {
            defaultImage = ImageIO.read(Image.class.getResource("/back.png"));
        } catch (IOException e) {
            System.err.print("default image konnte nicht geladen werden");
        }
    }
    public void loadDBImage(){
        wBild = new BufferedImage[Waffe.wAnzahl];
        for (int i = 0; i <= wBild.length -1; i++){

            wBild[i] = loadImage(waffe[i],defaultImage);
        }
        rBild = new BufferedImage[Ruestung.rAnzahl];
        for (int i = 0; i <= rBild.length -1; i++){

            rBild[i] = loadImage(ruestung[i],defaultImage);
        }
        tBild = new BufferedImage[Trank.tAnzahl];
        for (int i = 0; i <= tBild.length -1; i++){

            tBild[i] = loadImage(trank[i],defaultImage);
        }
    }
    public void loadInvBilder(){
        iRBild = new BufferedImage[Ruestung.rAnzahl];
        for (int i =0; i<= iRBild.length -1; i++){
            iRBild[i] = loadImage(iRString[i],defaultImage);
        }
        iRDefault = loadImage(iRDefaultString,defaultImage);
    }

    public BufferedImage loadImage(String filePath,BufferedImage defaultImage) {
        BufferedImage object = null;
        File file = new File("src/main/resources/"+ filePath);
        if(file.exists()){
            try {
                object = ImageIO.read(Image.class.getResource(filePath));
            } catch (IOException e) {
                System.err.print("default Game.Image error!!!!!!");
            }
        }else {
            System.err.println(" error" + " Bild pfad: " + "|" + filePath +"|" +  " doesn´t exist ");
            object = defaultImage;
        }
            return object;
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