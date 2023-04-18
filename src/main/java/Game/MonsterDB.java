package Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MonsterDB {

    //Get Variablen
    public String name;
    public int health;
    public int defense;
    public int attack;

    //Define Variablen
    public static final int mAnzahl = 6;
    static BufferedImage mBild[] = new BufferedImage[6];
    public static MonsterDB monsterDB[];

    //Datenbank
    public static String[] mName={"tollwütiges Schwein","Saurons Auge","hungriger Ork","Ghoul","fliegender Dämon","Untoter Ritter"};
    public static Integer[] mtot = {0,0,0,0,0,0};
    public static int[] mHealth={60,80,100,105,115,145};
    public static int[] mDefense={7,12,9,16,25,40};
    public static int[] mAttack={6,12,9,12,15,20};

    public MonsterDB(String name, int health, int defense, int attack, BufferedImage bild, int tot){

    }
    public MonsterDB(){
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
    public Integer getTot(int n){
        return mtot[n];
    }
    public static void loadItem(){
        loadImage();
        monsterDB = new MonsterDB[mAnzahl];
        for (int i = 0; i < mAnzahl; i++){
            monsterDB[i] = new MonsterDB(mName[i],mHealth[i],mDefense[i],mAttack[i],mBild[i],mtot[i]);
        }
    }
    //public static Monste getMonster(int i){
     //   return monster[i];
   // }

    public static void loadImage(){

        try {
            mBild[0] = ImageIO.read(MonsterDB.class.getResource("/monster/pig.png"));
            mBild[1] = ImageIO.read(MonsterDB.class.getResource("/monster/eye.png"));
            mBild[2] = ImageIO.read(MonsterDB.class.getResource("/monster/ork.png"));
            mBild[3] = ImageIO.read(MonsterDB.class.getResource("/monster/ghoul.png"));
            mBild[4] = ImageIO.read(MonsterDB.class.getResource("/monster/spyker.png"));
            mBild[5] = ImageIO.read(MonsterDB.class.getResource("/monster/rittertot.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("DB.Game.Monster Game.Image Error");
        }
    }
}