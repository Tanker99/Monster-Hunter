package Game;
import Items.Ruestung;
import Items.Trank;
import Items.Waffe;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
            , "/player/invisible/playercinv.png"
    };
    public  BufferedImage iRDefault;
    public String iRDefaultString = "/player/default/playerc1.png";

    //walk BIlder
    public  BufferedImage[] wdBild;
    public String[] wdString = {
            "/player/default/playerb1.png"
            , "/player/default/playerb2.png"
            , "/player/default/playerc1.png"
            , "/player/default/playerc2.png"
            , "/player/default/playerl1.png"
            , "/player/default/playerl2.png"
            , "/player/default/playerr1.png"
            , "/player/default/playerr2.png"
    };
    //Iron
    public  BufferedImage[] wiBild;
    public String[] wiString = {
            "/player/iron/playerbi1.png"
            , "/player/iron/playerbi2.png"
            , "/player/iron/playerci1.png"
            , "/player/iron/playerci2.png"
            , "/player/iron/playerli1.png"
            , "/player/iron/playerli2.png"
            , "/player/iron/playerri1.png"
            , "/player/iron/playerri2.png"
    };
    public  BufferedImage[] wgBild;
    public String[] wgString = {
            "/player/gold/playerbg1.png"
            , "/player/gold/playerbg2.png"
            , "/player/gold/playercg1.png"
            , "/player/gold/playercg2.png"
            , "/player/gold/playerlg1.png"
            , "/player/gold/playerlg2.png"
            , "/player/gold/playerrg1.png"
            , "/player/gold/playerrg2.png"
    };
    public  BufferedImage[] wlBild;
    public String[] wlString = {
            "/player/leather/playerbl1.png"
            , "/player/leather/playerbl2.png"
            , "/player/leather/playercl1.png"
            , "/player/leather/playercl2.png"
            , "/player/leather/playerll1.png"
            , "/player/leather/playerll2.png"
            , "/player/leather/playerrl1.png"
            , "/player/leather/playerrl2.png"
    };
    public  BufferedImage[] wdiBild;
    public String[] wdiString = {
            "/player/dia/playerbl1.png"
            , "/player/dia/playerbl2.png"
            , "/player/dia/playercl1.png"
            , "/player/dia/playercl2.png"
            , "/player/dia/playerll1.png"
            , "/player/dia/playerll2.png"
            , "/player/dia/playerrl1.png"
            , "/player/dia/playerrl2.png"
    };
    public  BufferedImage[] wjBild;
    public String[] wjString = {
            "/player/jade/playerbl1.png"
            , "/player/jade/playerbl2.png"
            , "/player/jade/playercl1.png"
            , "/player/jade/playercl2.png"
            , "/player/jade/playerll1.png"
            , "/player/jade/playerll2.png"
            , "/player/jade/playerrl1.png"
            , "/player/jade/playerrl2.png"
    };
    public  BufferedImage[] wuBild;
    public String[] wuString = {
            "/player/invisible/playerbl1.png"
            , "/player/invisible/playerbl2.png"
            , "/player/invisible/playercl1.png"
            , "/player/invisible/playercl2.png"
            , "/player/invisible/playerll1.png"
            , "/player/invisible/playerll2.png"
            , "/player/invisible/playerrl1.png"
            , "/player/invisible/playerrl2.png"
    };

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

        loadWalkBilder();

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

    public void loadWalkBilder(){

        wdBild = new BufferedImage[8];
        for (int i = 0; i <= wdBild.length -1; i++){

            wdBild[i] = loadImage(wdString[i],defaultImage);
        }

        wiBild = new BufferedImage[8];
        for (int i = 0; i <= wiBild.length -1; i++){

            wiBild[i] = loadImage(wiString[i],defaultImage);
        }

        wgBild = new BufferedImage[8];
        for (int i = 0; i <= wgBild.length -1; i++){

            wgBild[i] = loadImage(wgString[i],defaultImage);
        }
        wlBild = new BufferedImage[8];
        for (int i = 0; i <= wlBild.length -1; i++){

            wlBild[i] = loadImage(wlString[i],defaultImage);
        }
        wdiBild = new BufferedImage[8];
        for (int i = 0; i <= wdiBild.length -1; i++){

            wdiBild[i] = loadImage(wdiString[i],defaultImage);
        }
        wjBild = new BufferedImage[8];
        for (int i = 0; i <= wjBild.length -1; i++){

            wjBild[i] = loadImage(wjString[i],defaultImage);
        }
        wuBild = new BufferedImage[8];
        for (int i = 0; i <= wuBild.length -1; i++){

            wuBild[i] = loadImage(wuString[i],defaultImage);
        }

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