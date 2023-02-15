

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends Window implements ActionListener {

    private JButton shop = new JButton("shop");
    private JButton test = new JButton("test");

    public Menu(){

        System.out.println("tex");


        shop.setBounds(250, 100, 50, 50);
        shop.addActionListener(this);
        super.menu.add(shop);
        shop.setVisible(true);
        test.addActionListener(this);
        super.menu.add(test);
        test.setVisible(true);




        super.menu.setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == this.shop){
            System.out.println("Shop wurde betätigt");
              //new Shop();
            new Test();
        }
        else if(ae.getSource() == this.test){
            System.out.println("test wurde betätigt");
        }

    }
}
