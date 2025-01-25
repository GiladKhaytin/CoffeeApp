package coffeeApp.recipes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class shaksukaRecPanel extends JPanel {

    private BufferedImage backgroundImage;

    public shaksukaRecPanel(String recipeTitle, String imagePath) {
        this.setLayout(null);
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            backgroundImage = blurImage(originalImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel titleLabel = new JLabel(recipeTitle);
        titleLabel.setBounds(50, 20, 300, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.cyan);
        this.add(titleLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    private BufferedImage blurImage(BufferedImage image) {
        float[] blurKernel = {

                1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f,
                1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f,
                1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f,
                1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f,
                1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f, 1f / 25f
        };
        Kernel kernel = new Kernel(5, 5, blurKernel);
        ConvolveOp convolveOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        BufferedImage blurredImage = image;
        for (int i = 0; i < 5; i++) {
            blurredImage = convolveOp.filter(blurredImage, null);
        }
        return blurredImage;
    }
}
