/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package invasionballs;

import javax.swing.SwingUtilities;

public class InvasionBalls {

    private static MainFrame main;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                main = new MainFrame();
                main.init();

            }
        });

    }
}
