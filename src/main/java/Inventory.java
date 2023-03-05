import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.Color.green;

public class Inventory {

    GamePanel gp;
    KeyHandler keyH;

    Graphics2D g2;


    int [][]equip = new int[3][];
    private int panelid = 1;

    public boolean sellect = false;

    public int countX ;
    public int countY;
    public int sellectcountY = 0;

    //inventar
    private int inX = 0;
    private int inY = 0;
    private int inWight =0;
    private int inHigh =0;


    //Panel
    private int panX =0;
    private int panY = 0;
    private int panWight= 0;
    private int panHigh = 0;

    //Slot

    private int sloX =0;
    private int sloY = 0;
    private int sloWight= 0;
    private int sloHigh = 0;

    //sonstig

    private int sonX =0;
    private int sonY = 0;
    private int sonWight= 0;
    private int sonHigh = 0;





    public Inventory(GamePanel gp,KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        this.inX = 10;
        this.inY = gp.screenHeight/4 - 20;
        this.inWight = gp.screenWidth -20;
        this.inHigh = gp.screenHeight/2 - 20;

    }




    public void draw(Graphics2D g2){
        this.g2 = g2;
        inventory();
        g2.setFont(new Font("Arial",Font.PLAIN,40));
        g2.setColor(Color.black);
        g2.drawString("Inventar", gp.screenWidth/2,50);

        g2.drawRoundRect(gp.screenWidth/2,0,200,100,10,10);

    }

    public void inventory(){
        g2.drawRoundRect(inX,inY,inWight,inHigh,10,10);

        //panel
        panel();
        //slots
        slot();
        //sonstig
        sonstig();
        //move
        move();

    }

    public void update() {

    }

    public void move(){
        int e = 0;
        if(sellect){

            if (sellectcountY ==2 ){
                e = 30;

            }

            g2.setColor(green);
            g2.drawRoundRect(sonX  , sonY + sellectcountY * 50 + e, sonWight, sonHigh, 10, 10);

        }else if(!sellect) {
            g2.setColor(green);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(sloX + countX * 200 +3, sloY + countY * 200 +3 , sloWight -6, sloHigh -6, 30, 30);
        }
    }

    public void slot(){

        this.sloX = (int) (inWight*0.2) + inX;
        this.sloY = (int) (inHigh*0.05) + inY;
        this.sloWight = 200;
        this.sloHigh =200;
        for(int ix = 0; ix<=3;ix++){
            for(int iy = 0;iy<=1;iy++) {
                g2.drawRoundRect(sloX + ix*200, sloY + iy*200, sloWight, sloHigh, 10, 10);
            }
        }

    }
    public void sonstig(){

        this.sonX = (int) (inWight*0.9) + inX;
        this.sonY = (int) (inHigh*0.6) + inY;
        this.sonWight = 100;
        this.sonHigh = 50;

        String[] text = new String[]{"equip", "sell", "back"};

        for(int i = 0; i<=2;i++) {
            int e = 0;
            if (i == 2){
                e = 30;
            }
            g2.drawString(text[i],sonX + 20 ,sonY+ 20+ i*50 + e);
            g2.drawRoundRect(sonX , sonY + i * 50 + e, sonWight, sonHigh, 10, 10);
        }

    }

    public void panel(){

        this.panX = inX + 10;
        this.panY = (int) (inY + inHigh*0.1);
        this.panWight= 200;
        this.panHigh = (int) (inHigh /1.3);

        g2.drawRoundRect(panX,panY,panWight,panHigh, 10,10);

        if(sellect){
            detailPanel(g2);

        }
        if (!sellect) {
            equipPanel(g2);
        }




    }

    public void equipPanel(Graphics2D g2){

        for(int i = 0; i<=3; i++){
          int ii = i*60 ;

            g2.drawRoundRect(panX + 10, (int) (panY + panHigh*0.15 ) + ii  ,50,50, 10,10);
        }

       // equip[]



    }
    public void detailPanel(Graphics2D g2){



    }
    public void resetCurser(){
        sellect = false;
        sellectcountY = 0;
        countX =0;
        countY = 0;
    }

    public int getx(Graphics2D g2,String text){
        int lenght = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = lenght/2;
        return x;
    }
}


 /*
        stack.setBackground(Color.red);
        stack.setBounds(150, 100, 800, 500);
        stack.setLayout(new GridLayout(2, 3, 10, 10));
        super.shop.add(stack);
        stack.setVisible(true);

        for(int i = 0; i <= 5; ++i) {
            item[i] = new JPanel();
            item[i].setBounds(0, 0, 100, 100);
            item[i].setBackground(Color.green);
            item[i].setLayout((LayoutManager)null);
            item[i].setVisible(true);
            stack.add(item[i]);
        }
          super.shop.setVisible(true);
     */



