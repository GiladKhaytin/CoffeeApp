package coffeApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class appPanel extends JPanel {

    private Image backgroundImage;
    private JLabel menuTitle;
    private appPictures pictures;

    public appPanel(int frameWidth) {

        // Load the background image
        backgroundImage = new ImageIcon("/home/gilad/Desktop/BASIC/CoffeeApp/coffeApp/Images/Coffe Background.jpg").getImage();

        if (backgroundImage == null) {
            System.out.println("Image not found or failed to load.");
        } else {
            // Convert the background image to a BufferedImage for processing
            backgroundImage = blurImage(toBufferedImage(backgroundImage));
        }

        // Create the main title label
        menuTitle = new JLabel("Welcome to CoffeeApp");
        menuTitle.setBounds(420, 20, 400, 50);
        menuTitle.setHorizontalAlignment(JLabel.CENTER);
        menuTitle.setForeground(Color.white);
        menuTitle.setFont(new Font("Arial", Font.BOLD, 30));

        this.setLayout(null);
        this.add(menuTitle);

        pictures = new appPictures(frameWidth);

        for (int i = 0; i < pictures.buttons.length; i++) {
            
            this.add(pictures.buttons[i]);
            this.add(pictures.labels[i]);

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {

            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);

        }
         else {

            System.out.println("Background image is null.");
        }
    }


    // Helper method to convert Image to BufferedImage
    private BufferedImage toBufferedImage(Image img) {

        if (img instanceof BufferedImage) {

            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bimage.getGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();

        return bimage;
    }

    private BufferedImage blurImage(BufferedImage image) {
        float[] matrix = {

            1f/25f, 1f/25f, 1f/25f, 1f/25f, 1f/25f,
            1f/25f, 1f/25f, 1f/25f, 1f/25f, 1f/25f,
            1f/25f, 1f/25f, 1f/25f, 1f/25f, 1f/25f,
            1f/25f, 1f/25f, 1f/25f, 1f/25f, 1f/25f,
            1f/25f, 1f/25f, 1f/25f, 1f/25f, 1f/25f
            
        };
    
        ConvolveOp op = new ConvolveOp(new Kernel(5, 5, matrix), ConvolveOp.EDGE_NO_OP, null);
        return op.filter(image, null);
    }
}