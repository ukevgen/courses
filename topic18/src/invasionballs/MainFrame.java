/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package invasionballs;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {


    public void init() {
        MainPanel panel = new MainPanel();
        panel.animatePanel();
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);


    }
}

    
   
    

