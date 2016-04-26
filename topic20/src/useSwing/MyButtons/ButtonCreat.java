package useSwing.MyButtons;

import useSwing.AllFrame.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Администратор on 26.04.2016.
 */

public class ButtonCreat extends MainButton implements ActionListener, Runnable {

    private static final int SIZE = 100;

    public ButtonCreat(ArrayList<MainPanel> panels) {
        super(panels);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.update();
        for (MainPanel mp : panels) {
            mp.setArray(creatArray());
        }
    }

    @Override
    public void run() {

        System.out.println("Creat New Thread");
    }

    private int[] creatArray() {
        int[] array = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }


}