package useSwing.AllFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Администратор on 24.04.2016.
 */
public class MainPanel extends JPanel {

    private static  final int NEXT=15;
    private static  final int COLORRANGE=256;
    private int[] array = new int [100];

    MainPanel(){
        this.setSize(400,400);

    }


    public void paint(Graphics g) {

        super.paint(g);
        int width = getWidth();             // width of window in pixels
        int height = getHeight();
        //(ось х, отступ от верха панели, ширина столбца, высота столбца)
        creatArr();
        for (int i=0;i<array.length;i++){
            Rectangle r = new Rectangle(NEXT*i,height-array[i], 10, array[i] );
            g.setColor(getColor());
            g.fillRect (r.x, r.y, r.width, r.height );
            System.out.println(array[i]);
        }
    }

    public void animatePanel() {
        new Timer(15, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }).start();
    }

    private Color getColor(){
        Random random = new Random();
        int colorRed=random.nextInt(COLORRANGE);
        int colorBlack=random.nextInt(COLORRANGE);
        int colorGreen=random.nextInt(COLORRANGE);
        Color color = new Color(colorRed,colorBlack,colorGreen);
        return color;
    }

    private void creatArr() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
          array  [i] = random.nextInt(100);
        }
    }


}
