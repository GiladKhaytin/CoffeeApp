package coffeeApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import coffeeApp.recipes.shaksukaRec;

public class appPictures {
    public JButton[] buttons;
    public JLabel[] labels;
    public static String[] imagePaths = {
            "coffeeApp/Images/Shaksuka.jpg",
            "coffeeApp/Images/omlet.png",
            "coffeeApp/Images/Croissant sandwich .jpg"
    };
    private String[] labelTexts = {
            "Shakshuka 15$",
            "Omelet 10$",
            "Croissant 20$"
    };
    private int imageWidth = 250;
    private int imageHeight = 250;
    private int spacing = 50;

    public appPictures(int frameWidth) {
        int numImages = imagePaths.length;
        buttons = new JButton[numImages];
        labels = new JLabel[numImages];

        int totalWidth = (numImages * imageWidth) + ((numImages - 1) * spacing);
        int startX = (frameWidth - totalWidth) / 2; // Calculate the starting X position

        shaksukaRec recipeFrameOpener = new shaksukaRec(); // Create an instance of shaksukaRec

        for (int i = 0; i < numImages; i++) {
            // Load and scale the image for the button
            ImageIcon icon = new ImageIcon(imagePaths[i]);
            Image image = icon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            icon = new ImageIcon(image);

            // Create the button
            buttons[i] = new JButton();
            buttons[i].setIcon(icon);
            buttons[i].setBounds(startX + i * (imageWidth + spacing), 100, imageWidth, imageHeight);

            int index = i;
            buttons[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    recipeFrameOpener.openNewFrame(labelTexts[index], imagePaths[index]); // Pass the image path to the
                                                                                          // new frame

                }

            });

            // Calculate Y-position for the label to place it directly under the button
            int labelY = buttons[i].getY() + buttons[i].getHeight() + 10;

            // Create the label for text and position it under the button
            labels[i] = new JLabel(labelTexts[i]);
            labels[i].setBounds(startX + i * (imageWidth + spacing), labelY, imageWidth, 30);
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            labels[i].setForeground(Color.cyan);
            labels[i].setFont(new Font("Arial", Font.BOLD, 20));
            labels[i].setOpaque(false);
        }
    }

    public static String[] getImagePaths() {
        return imagePaths;
    }
}
