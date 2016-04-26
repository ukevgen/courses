package useSwing.MyButtons;

import useSwing.AllFrame.MainPanel;
import useSwing.sortThread.Lock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Администратор on 26.04.2016.
 */
public class ButtonStart extends MainButton implements ActionListener {

    public ButtonStart(ArrayList<MainPanel> panels, Lock lock) {
        super(panels, lock);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (lock.isWait()) {
            System.out.println("Start pressed");
            synchronized (lock) {
                lock.setWait(false);
                lock.notifyAll();
            }
        } else {
        }//"создаем потоки для сортировки"}
    }

}