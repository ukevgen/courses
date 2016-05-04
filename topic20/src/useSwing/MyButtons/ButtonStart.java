package useSwing.MyButtons;

import useSwing.AllFrame.MainPanel;
import useSwing.sortThread.Lock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static useSwing.swingSort.BubbleSort.bubbleSort;


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

            for (MainPanel p : panels) {
                // p.setArray(bubbleSort(p.getArray()));
                p.setArray(testChanger(p.getArray()));
            }
        }//"создаем потоки для сортировки"}
    }

    private int[] testChanger(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] += 2;
        }
        return array;
    }


}