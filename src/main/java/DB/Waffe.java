package DB;


public class Waffe {
    public static final int Wanzahl = 0;
    public String name;
    public int Kraft;
    public int Goldwert;
    public static String[] Waffen = {"Schwacher Bogen", "Starker Bogen", "Streitaxt (Eine KLinge)", "Streitaxt (Doppelte Klinge)", "Schwert", "Feuerschwert", "Morgenstern", "Armbrust"};
    public static int[] WKraft = {2, 5, 4, 6, 3, 5, 6, 4};
    public static int[] WGoldwert = {3, 7, 4, 8, 4, 9, 6, 5};

    public void getWaffe(int n) {
        name = Waffe.Waffen[n];
        Kraft = Waffe.WKraft[n];
        Goldwert = Waffe.WGoldwert[n];
    }
}