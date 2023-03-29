

public class Trank {
    public static final int Tanzahl = 0;
    public String name;
    public int Kraft;
    public int Goldwert;
    public static String[] Traenke={"Einhorn-Pipi","Rote Bete Saft","Pep-sie Gemisch","Ingwer-shot","Met","Rüstung6","Rüstung7","Rüstung8"};
    public static int[] TKraft={6,8,4,12,-4,6,7,8};
    public static int[] TGoldwert={10,4,2,7,9,6,7,8};

    public void getTrank(int n){
        name = Trank.Traenke[n];
        Kraft = Trank.TKraft[n];
        Goldwert = Trank.TGoldwert[n];
    }
}