package DB;

public class Trank {
    public static final int Tanzahl = 0;
    public String name;
    public int Kraft;
    public int Goldwert;
    public static String[] Traenke={"Trank der Wahrnehmung","Rote Bete Saft","Rüstung3","Rüstung4","Rüstung5","Rüstung6","Rüstung7","Rüstung8"};
    public static int[] TKraft={1,2,3,4,5,6,7,8};
    public static int[] TGoldwert={1,2,3,4,5,6,7,8};

    public void getTrank(int n){
        name = Trank.Traenke[n];
        Kraft = Trank.TKraft[n];
        Goldwert = Trank.TGoldwert[n];
    }
}