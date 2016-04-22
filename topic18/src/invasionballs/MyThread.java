package invasionballs;

import java.awt.*;
import java.util.Random;

/**
 * Created by Администратор on 22.04.2016.
 */
public class MyThread implements Runnable {
    private static final int COLORRANGE=256;
    private static final int SPEED_VECTORX=15;
    private static final int SPEED_VECTORY=20;
    private Color color;

    @Override
    public void run() {

    }
    public void setColor (Ball ball){
        Random random = new Random();
        int colorRed=random.nextInt(COLORRANGE);
        int colorBlack=random.nextInt(COLORRANGE);
        int colorGreen=random.nextInt(COLORRANGE);
        color = new Color(colorRed,colorBlack,colorGreen);
        ball.setColor(color);
        System.out.println("Created new color");
    }
    public void setVektor (Ball ball){
        Random random = new Random();
        int xInc=random.nextInt(SPEED_VECTORX)-SPEED_VECTORX;
        int yInc=random.nextInt(SPEED_VECTORY)-SPEED_VECTORY;
        ball.setxInc(xInc);
        ball.setyInc(yInc);
        System.out.println("Created new vektor");

    }
}
