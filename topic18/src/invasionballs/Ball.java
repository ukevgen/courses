/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package invasionballs;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author User
 */
public class Ball implements Shape{
    private static final int MINRADIUS=5;
    private static final int MAXRADIUS=60;
    private static final int COLORRANGE=256;
    private Color color;
    private int r;

    public Ball() {
        draw();
    }

    @Override
    public void draw() {
        Random random = new Random();
        r=random.nextInt(MAXRADIUS)+MINRADIUS;
        int colorRed=random.nextInt(COLORRANGE);
        int colorBlack=random.nextInt(COLORRANGE);
        int colorGreen=random.nextInt(COLORRANGE);
        color=new Color(colorRed,colorBlack,colorGreen);
    }
    public int getD() {
        return 2*r;
    }

    @Override
    public Color getColor() {
        return color;
    }
    
    
    
    
}
