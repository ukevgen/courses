package useSwing.sortThread;

import useSwing.AllFrame.MyChart;
import javax.swing.*;

/**
 * Created by Администратор on 26.04.2016.
 */
public class SortThread {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MyChart main = new MyChart();
                main.init();
            }
        });
    }

}
