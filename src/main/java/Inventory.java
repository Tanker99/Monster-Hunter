import java.awt.*;

public class Inventory {

    GamePanel gp;

    Graphics2D g2;


    //inventar
    private int inX = 0;
    private int inY = 0;
    private int inWight =0;
    private int inHigh =0;
    private int panelid= 0;

    //Panel
    private int panX = inX + 10;
    private int panY = (int) (inY + inHigh*0.1);
    private int panWight= 200;
    int panHigh = (int) (inHigh /1.3);





    public Inventory(GamePanel gp) {
        this.gp = gp;

        this.inX = 10;
        this.inY = (int) (gp.screenHeight/4 - 20);
        this.inWight = gp.screenWidth -20;
        this.inHigh = gp.screenHeight/2 - 20;

    }




    public void draw(Graphics2D g2){

        inventory(g2);
        g2.setFont(new Font("Arial",Font.PLAIN,40));
        g2.setColor(Color.black);
        g2.drawString("ee", 50,50);

    }

    public void inventory(Graphics2D g2){



        g2.drawRoundRect(inX,inY,inWight,inHigh,10,10);
        g2.drawRoundRect(0,0,200,100,10,10);
        //panel
        panel(g2);
        //slots
        slot(g2);
        //sonstig
        sonstig(g2);

    }

    public void slot(Graphics2D g2){

    }
    public void sonstig(Graphics2D g2){

    }

    public void panel(Graphics2D g2){

        g2.drawRoundRect(panX,panY,panWight,panHigh, 10,10);

        if(panelid == 1){
            equipPanel(g2);

        }else if (panelid == 2){
            detailPanel(g2);

        }else {

        }




    }

    public void equipPanel(Graphics2D g2){

    }
    public void detailPanel(Graphics2D g2){

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



