package DB;

public class Ruestung {
    public static final int Ranzahl = 0;
    public String name;
    public int Kraft;
    public int Goldwert;
    public static String[] Ruestungen={"Rüstung1","Rüstung2","Rüstung3","Rüstung4","Rüstung5","Rüstung6","Rüstung7","Rüstung8"};
    public static int[] RKraft={1,2,3,4,5,6,7,8};
    public static int[] RGoldwert={1,2,3,4,5,6,7,8};

    public void getRuestung(int n){
        name = Ruestung.Ruestungen[n];
        Kraft = Ruestung.RKraft[n];
        Goldwert = Ruestung.RGoldwert[n];
    }
}

