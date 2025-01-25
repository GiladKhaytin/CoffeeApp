/**
 * Setting a new frame with width and height, and creating a new function called panel
 * 
 */

package coffeeApp;

import javax.swing.JFrame;

public class appFrame extends JFrame {

    appPanel panel;

    appFrame() {
        this.setTitle("Coffee Shop");
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        panel = new appPanel(this.getWidth());
        this.add(panel);
        this.setVisible(true);
    }
}