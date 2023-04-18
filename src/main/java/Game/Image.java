package Game;
import Items.Ruestung;
import Items.Trank;
import Items.Waffe;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {
    //default0
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
            , "/player/diamond/playercd1.png"
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
    //Gold
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
    //Leather
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
    //dia
    public  BufferedImage[] wdiBild;
    public String[] wdiString = {
            "/player/diamond/playerbd1.png"
            , "/player/diamond/playerbd2.png"
            , "/player/diamond/playercd1.png"
            , "/player/diamond/playercd2.png"
            , "/player/diamond/playerld1.png"
            , "/player/diamond/playerld2.png"
            , "/player/diamond/playerrd1.png"
            , "/player/diamond/playerrd2.png"
    };
    //jade
    public  BufferedImage[] wjBild;
    public String[] wjString = {
            "/player/jade/playerbj1.png"
            , "/player/jade/playerbj2.png"
            , "/player/jade/playercj1.png"
            , "/player/jade/playercj2.png"
            , "/player/jade/playerlj1.png"
            , "/player/jade/playerlj2.png"
            , "/player/jade/playerrj1.png"
            , "/player/jade/playerrj2.png"
    };
    //invisible
    public  BufferedImage[] wuBild;
    public String[] wuString = {
            "/player/invisible/playerbinv.png"
            ,"/player/invisible/playerbinv.png"
            ,"/player/invisible/playercinv.png"
            ,"/player/invisible/playercinv.png"
            ,"/player/invisible/playerlinv.png"
            ,"/player/invisible/playerlinv.png"
            ,"/player/invisible/playerrinv.png"
            ,"/player/invisible/playerrinv.png"
            /*
            "/player/invisible/playerbl1.png"
            , "/player/invisible/playerbl2.png"
            , "/player/invisible/playercl1.png"
            , "/player/invisible/playercl2.png"
            , "/player/invisible/playerll1.png"
            , "/player/invisible/playerll2.png"
            , "/player/invisible/playerrl1.png"
            , "/player/invisible/playerrl2.png"
    */
    };
    //Hintergrund Fight
    public  BufferedImage[] hFBild;
    public String[] hFString = {
            "/Background/fight/KampfHaus.png"
            ,"/Background/fight/Kampfhoele.png"
            ,"/Background/fight/Kampfgrass.png"
            ,"/Background/fight/castleinnen.png"
            ,"/Background/fight/Baum.png"
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

        //läd animation Bilder
        loadWalkBilder();

        //Läd Hintergrund
        loadBackground();


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
    public void loadBackground() {

        hFBild = new BufferedImage[5];
        for (int i = 0; i <= hFBild.length -1; i++){

            hFBild[i] = loadImage(hFString[i],defaultImage);
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