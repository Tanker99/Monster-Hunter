package Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Monster{

    //Get Variablen
    public String name;
    public int health;
    public int defense;
    public int attack;

    //Define Variablen
    public static final int mAnzahl = 4;
    static BufferedImage mBild[] = new BufferedImage[4];
    public static Monster monster[];

    //Datenbank
    public static String[] mName={"tollwütiges Schwein","hungriger Ork","Ghoul","Untoter Ritter"};
    public static int[] mHealth={80,95,104,110,140};
    public static int[] mDefense={5,9,12,16,20};
    public static int[] mAttack={4,7,9,12,17};


    public String getName(int n){
        return mName[n];
    }

    public int getHealth(int n){
        return mHealth[n];
    }
    public int getDefense(int n){
        return mDefense[n];
    }

    public int getAttack(int n){
        return mAttack[n];
    }
    public static void loadItem(){
        loadImage();
        monster = new Monster[mAnzahl];
        for (int i = 0; i < mAnzahl; i++){
           // monster[i] = new Game.Monster(mName[i],mDefense[i],mAttack[i],rBild[i]);
        }
    }
    //public static Monste getMonster(int i){
     //   return monster[i];
   // }

    public static void loadImage(){

        try {
            mBild[0] = ImageIO.read(Monster.class.getResource("/monster/pig.png"));
            mBild[1] = ImageIO.read(Monster.class.getResource("/monster/ork.png"));
            mBild[2] = ImageIO.read(Monster.class.getResource("/monster/ghoul.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("DB.Game.Monster Game.Image Error");
        }
    }
}