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
    static BufferedImage mBild[] = new BufferedImage[6];
    public static Monster monster[];

    //Datenbank
    public static String[] mName={"tollwütiges Schwein","Saurons Auge","hungriger Ork","Ghoul","fliegender Dämon","Untoter Ritter"};
    public static int[] mHealth={80,95,104,125};
    public static int[] mDefense={5,9,12,16,25};
    public static int[] mAttack={4,7,9,12,18};

    public Monster(String name,int health,int defense,int attack, BufferedImage bild){

    }
    public Monster(){
        loadItem();
    }


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
    public BufferedImage getBild(int n){
        return mBild[n];
    }
    public static void loadItem(){
        loadImage();
        monster = new Monster[mAnzahl];
        for (int i = 0; i < mAnzahl; i++){
            monster[i] = new Monster(mName[i],mHealth[i],mDefense[i],mAttack[i],mBild[i]);
        }
    }
    //public static Monste getMonster(int i){
     //   return monster[i];
   // }

    public static void loadImage(){

        try {
            mBild[0] = ImageIO.read(Monster.class.getResource("/monster/pig.png"));
            mBild[1] = ImageIO.read(Monster.class.getResource("/monster/eye.png"));
            mBild[2] = ImageIO.read(Monster.class.getResource("/monster/ork.png"));
            mBild[3] = ImageIO.read(Monster.class.getResource("/monster/ghoul.png"));
            mBild[4] = ImageIO.read(Monster.class.getResource("/monster/spyker.png"));
            mBild[5] = ImageIO.read(Monster.class.getResource("/monster/rittertot.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("DB.Game.Monster Game.Image Error");
        }
    }
}