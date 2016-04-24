package useSwing.AllFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Администратор on 24.04.2016.
 */
public class MyChart extends JFrame{

    public void init() {
        MainPanel panel = new MainPanel();
       // panel.animatePanel();
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        gd.setFullScreenWindow(this);

    }

}
