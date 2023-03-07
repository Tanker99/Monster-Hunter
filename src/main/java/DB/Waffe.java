package DB;


public class Waffe {
    public static final int Wanzahl = 0;
    public String name;
    public int Kraft;
    public int Goldwert;
    public static String[] Waffen = {"Waffe1", "Waffe2", "Waffe3", "Waffe4", "Waffe5", "Waffe6", "Waffe7", "Waffe8"};
    public static int[] WKraft = {1, 2, 3, 4, 5, 6, 7, 8};
    public static int[] WGoldwert = {1, 2, 3, 4, 5, 6, 7, 8};

    public void getWaffe(int n) {
        name = Waffe.Waffen[n];
        Kraft = Waffe.WKraft[n];
        Goldwert = Waffe.WGoldwert[n];
    }
}