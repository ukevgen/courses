/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package invasionballs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    private  int xPosition;
    private  int yPosition;
    private List<Ball> ballsList = new ArrayList<>();
   
    public MainFrame() {
        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                xPosition = e.getX();
                yPosition = e.getY();
                Ball b = new Ball();
                ballsList.add(0,b);
                //repaint();
            }
        });
    }
    private  JPanel jpanel = new JPanel(){
      
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            if (!ballsList.isEmpty()){
                int radius = ballsList.get(0).getD()/2;
                super.paintComponent(g);
                g2d.setColor(ballsList.get(0).getColor());
                g2d.fillOval(xPosition-radius,yPosition-radius,radius*2,radius*2);
            }
        }
    };
    
    public  void init(){
        this.add(jpanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
    }
   
    
   
    
}
