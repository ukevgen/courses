/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package invasionballs;

import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author User
 */
public class MainPanel extends JPanel {

    private List<Ball> ballsList = new ArrayList<>();

    MainPanel() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int xPosition = e.getX();
                int yPosition = e.getY();
                Ball ball = new Ball(xPosition, yPosition);
                creatThread(ThreadType.COLOR, ball);
                creatThread(ThreadType.VEKTOR, ball);
                ballsList.add(ball);

            }
        });
    }

    public void paint(Graphics g) {

        super.paint(g);
        for (Ball ball : ballsList) {
            int radius = ball.getR();
            g.setColor(ball.getColor());
            g.fillOval(ball.getxPosition() - radius / 2, ball.getyPosition() - radius / 2, radius, radius);
            moveBall(ball);
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

    private void moveBall(Ball ball) {
        int xinc = ball.getxInc();
        int yinc = ball.getyInc();
        int xPosition = ball.getxPosition() + xinc;
        int yPosition = ball.getyPosition() + yinc;
        if (xPosition >= getWidth() - ball.getR() || xPosition <= 0) {
            xinc *= -1;
            ball.setxInc(xinc);
        }
        if (yPosition >= getHeight() - ball.getR() || yPosition <= 0) {
            yinc *= -1;
            ball.setyInc(yinc);
        }
        ball.setxPosition(xPosition);
        ball.setyPosition(yPosition);

    }

    private void creatThread(ThreadType type, Ball ball) {
        if (type.equals(ThreadType.COLOR)) {
            MyThread p1 = new MyThread();
            Thread thread = new Thread(p1);
            thread.start();
            p1.setColor(ball);
        } else if (type.equals(ThreadType.VEKTOR)) {
            MyThread p2 = new MyThread();
            Thread thread = new Thread(p2);
            thread.start();
            p2.setVektor(ball);
        } else
            System.out.println("type missmuch");
    }
}
