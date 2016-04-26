package useSwing.MyButtons;

import useSwing.AllFrame.MainPanel;
import useSwing.sortThread.Lock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Администратор on 26.04.2016.
 */

public class ButtonPause extends MainButton implements ActionListener {

    public ButtonPause(ArrayList<MainPanel> panels, Lock lock) {
        super(panels, lock);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        synchronized (lock) {
            lock.setWait(true);
            System.out.println("lock = true");
        }
    }

}

