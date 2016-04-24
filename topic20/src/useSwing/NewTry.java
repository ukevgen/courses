package useSwing;

import useSwing.AllFrame.MyChart;

import javax.swing.*;

/**
 * Created by Администратор on 24.04.2016.
 */
public class NewTry {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
             MyChart main = new MyChart();
                main.init();

            }
        });
    }
}
