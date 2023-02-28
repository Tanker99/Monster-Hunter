

import javax.swing.*;
import java.awt.*;

public class Shop {

    GamePanel gp;
    Graphics2D g2;


    public Shop() {
        this.gp = gp;
    }


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


    public void draw(Graphics2D g2){

        g2.draw(s);

    }
}
