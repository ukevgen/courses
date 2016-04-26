package useSwing.AllFrame;

/**
 * Created by Администратор on 26.04.2016.
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Администратор on 24.04.2016.
 */
public class MainPanel extends JPanel {

    private static final int NEXT = 15;
    private static final int COLORRANGE = 256;
    private int[] array = null;

    MainPanel() {
        this.setSize(400, 400);
    }


    public void paint(Graphics g) {

        super.paint(g);
        int width = getWidth();
        int height = getHeight();
        //(ось х, отступ от верха панели, ширина столбца, высота столбца)
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                Rectangle r = new Rectangle(NEXT * i, height - array[i], 10, array[i]);
                g.fillRect(r.x, r.y, r.width, r.height);
            }
        }
        this.repaint();

    }


    private Color getColor() {
        Random random = new Random();
        int colorRed = random.nextInt(COLORRANGE);
        int colorBlack = random.nextInt(COLORRANGE);
        int colorGreen = random.nextInt(COLORRANGE);
        Color color = new Color(colorRed, colorBlack, colorGreen);
        return color;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

}


