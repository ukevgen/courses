/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package invasionballs;

import java.awt.Color;
import java.util.Random;

/**
 * @author User
 */
public class Ball implements Shape {
    private static final int MINRADIUS = 5;
    private static final int MAXRADIUS = 60;
    private static final int COLORRANGE = 256;
    private static final int SPEED_VECTORX=15;
    private static final int SPEED_VECTORY=20;
    private int xPosition;
    private int yPosition;
    private Color color;
    private int r;
    private int xInc;
    private int yInc;


    public Ball(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        init();
    }

    @Override
    public void init() {
        Random random = new Random();
        r = random.nextInt(MAXRADIUS) + MINRADIUS;
        int colorRed = random.nextInt(COLORRANGE);
        int colorBlack = random.nextInt(COLORRANGE);
        int colorGreen = random.nextInt(COLORRANGE);
        xInc = random.nextInt(SPEED_VECTORX) - random.nextInt(SPEED_VECTORX);
        yInc = random.nextInt(SPEED_VECTORY) - random.nextInt(SPEED_VECTORY);
        color = new Color(colorRed, colorBlack, colorGreen);
    }

    public int getR() {
        return r;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getxInc() {
        return xInc;
    }

    public int getyInc() {
        return yInc;
    }

    public void setxInc(int xInc) {
        this.xInc = xInc;
    }

    public void setyInc(int yInc) {
        this.yInc = yInc;
    }


}
