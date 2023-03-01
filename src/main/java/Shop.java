

import javax.swing.*;
import java.awt.*;

public class Shop {

    GamePanel gp;
    Graphics2D g2;


    public Shop(GamePanel gp) {
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

        int iX = 10;
        int iY = (int) (gp.screenHeight/4 - 20);
        int iWight = gp.screenWidth -20;
        int iHigh = gp.screenHeight/2 - 20;

        g2.drawRoundRect(iX,iY,iWight,iHigh,10,10);

    }

    public void equipPanel(Graphics2D g2){

    }
    public void detailPanel(Graphics2D g2){

    }
}
