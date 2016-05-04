package useSwing.AllFrame;

import useSwing.MyButtons.ButtonCreat;
import useSwing.MyButtons.ButtonPause;
import useSwing.MyButtons.ButtonStart;
import useSwing.sortThread.Lock;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Администратор on 26.04.2016.
 */

public class MyChart extends JFrame {

    private final Lock lock = new Lock();


    public void init() {

        JPanel gui = new JPanel();
        gui.setBackground(Color.BLUE);
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        gui.setLayout(new GridLayout(7, 1));

        ArrayList<MainPanel> panels = new ArrayList();

        for (int i = 0; i < 6; i++) {
            MainPanel panel = new MainPanel();
            gui.add(panel);
            panels.add(panel);
        }

        JButton b1 = new JButton("CreatArray");
        JButton b2 = new JButton("Start");
        JButton b3 = new JButton("Pause");

        ButtonCreat bc = new ButtonCreat(panels);
        ButtonPause bp = new ButtonPause(panels, lock);
        ButtonStart bs = new ButtonStart(panels, lock);

        b1.addActionListener(bc);
        b2.addActionListener(bp);
        b3.addActionListener(bs);

        Button b4 = new Button("Clear");

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 4));

        buttons.add((b1));
        buttons.add((b2));
        buttons.add((b3));
        buttons.add((b4));

        gui.add(buttons);

        this.getContentPane().add(gui);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(400, 400);
        //GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        //gd.setFullScreenWindow(this);


    }

}
