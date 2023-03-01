import java.awt.*;

public class ds {

    GamePanel gp;

    Graphics2D g2;

    int inX = 10;
    int inY = (int) (gp.screenHeight/4 - 20);
    int inWight = gp.screenWidth -20;
    int inHigh = gp.screenHeight/2 - 20;



    public ds(GamePanel gp) {
        this.gp = gp;
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






    public void draw(Graphics2D g2){

        inventory(g2);
        g2.setFont(new Font("Arial",Font.PLAIN,40));
        g2.setColor(Color.black);
        g2.drawString("ee", 50,50);

    }

    public void inventory(Graphics2D g2){



        g2.drawRoundRect(inX,inY,inWight,inHigh,10,10);
        panel(g2);

    }

    public void panel(Graphics2D g2){

        int panX = inX + 10;
        int panY = (int) (inHigh/4.5);
        int panHigh = inHigh /2;
        int panWight= 20;

        g2.drawRoundRect(panX,panY,panHigh,panWight, 10,10);


    }

    public void equipPanel(Graphics2D g2){

    }
    public void detailPanel(Graphics2D g2){

    }
}
