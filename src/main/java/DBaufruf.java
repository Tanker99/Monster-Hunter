public class DBaufruf(){
    int n;
    int m;

    public DBaufruf(int n,int m){
        this.n = n;
        this.m = m;
    }
    switch(n){
        case 1:
        Waffe.getName(m);
        Waffe.getKraft(m);
        Waffe.getGoldwert(m);
        Waffe.getText(m);
        break;

        case 2:
        Trank.getName(m);
        Trank.getKraft(m);
        Trank.getGoldwert(m);
        Trank.getText(m);
        break;

        case 3:
        Ruestung.getName(m);
        Ruestung.getKraft(m);
        Ruestung.getGoldwert(m);
        Ruestung.getText(m);
        break;   
    }

}