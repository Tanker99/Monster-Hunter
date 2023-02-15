
import javax.swing.*;
import java.awt.*;

public class Window {

    JFrame Window = new JFrame("Das Game");
    JPanel menu;
    JPanel base;
    JPanel shop;
    JPanel Inventar;

    public Window(){

        Window.setSize(1600, 900);
        Window.setLocationRelativeTo(null); //Fenster ist in der Mitte
        Window.setLayout(null);
        Window.setResizable(false); //kann nicht größeer oder kleiner gezogen werden
        Window.setVisible(true);




        shop = new JPanel();
        shop.setBackground(Color.blue);
        // Test.setBounds(20, 20, 550, 550);
        shop.setSize(1600,900);
        shop.setLayout(null);
        Window.add(shop);
        shop.setVisible(false);

        menu = new JPanel();
        menu.setBackground(Color.blue);
        menu.setSize(1600,900);
        menu.setLayout(null);
        Window.add(menu);
        menu.setVisible(false);

        base = new JPanel();
        base.setBackground(Color.blue);
       // Test.setBounds(20, 20, 550, 550);
        base.setSize(1600,900);
        Window.add(base);
        base.setVisible(false);













    }
}
