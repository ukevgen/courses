package useSwing.MyButtons;

import useSwing.AllFrame.MainPanel;
import useSwing.sortThread.Lock;
import useSwing.swingSort.BubbleSort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by Администратор on 26.04.2016.
 */
public class ButtonStart extends MainButton implements ActionListener {

    private Thread threadPanels = new Thread(new UpdatePanel());
    private static BubbleSort bubbleSort;

    public ButtonStart(ArrayList<MainPanel> panels, Lock lock) {

        super(panels, lock);
        bubbleSort = new BubbleSort(lock);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!threadPanels.isAlive()) {
            threadPanels.start();
        }

        if (lock.isWait()) {
            System.out.println("Стартуем");
            synchronized (lock) {
                lock.setWait(false);
                lock.notifyAll();
            }
        } else {
            initSort();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (!lock.isWait()) {
                            for (MainPanel p : panels) {
                                p.setArray(bubbleSort.getArray());
                               // p.setArray(testChanger(p.getArray()));
                            }
                        }
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    private int[] testChanger(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] += 2;
        }
        return array;
    }

    private void initSort() {
        Thread th1 = new Thread(bubbleSort);
        th1.start();
    }

    class UpdatePanel implements Runnable {
        @Override
        public void run() {
            while (true) {
                for (MainPanel panel : panels) {
                    panel.repaint();
                }
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}