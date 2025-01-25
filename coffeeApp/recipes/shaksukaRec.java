package coffeApp.recipes;

import javax.swing.JFrame;

public class shaksukaRec {

    public void openNewFrame(String recipeTitle, String imagePath) {

        JFrame frame = new JFrame(recipeTitle);
        shaksukaRecPanel panel = new shaksukaRecPanel(recipeTitle, imagePath);
        frame.setContentPane(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        
    }
}
