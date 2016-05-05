package useSwing.MyButtons;

import useSwing.AllFrame.MainPanel;
import useSwing.sortThread.Lock;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Администратор on 26.04.2016.
 */
public abstract class MainButton {

    protected ArrayList<MainPanel> panels;
    protected static Lock lock;

    public MainButton(ArrayList<MainPanel> panels) {
        this.panels = panels;
    }

    public MainButton(ArrayList<MainPanel> panels, Lock lock) {
        this.panels = panels;
        this.lock = lock;
    }

    protected void update() {
        for (JPanel pl : panels) {
            pl.repaint();
        }
    }
}
