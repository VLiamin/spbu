package ru.liamin.vladimir;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/** Class class that implements gun movement */
public class Player {
    private BufferedImage img = ImageIO.read(new File("src\\main\\resources\\gun.png"));
    private BufferedImage image2 = ImageIO.read(new File("src\\main\\resources\\gun.png"));
    private Core core;
    private int angle = 0;
    private int angularVelocity = 0;
    private int x = 910;
    private int y = 175;
    private int speed = 0;

    public Player(Core core) throws IOException {
        this.core = core;
    }

    /**
     * Method which return gun image
     * @retur gun image
     */
    public BufferedImage getImg() {
        return img;
    }

    /**
     * Method which return X coordinate
     * @return X coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Method which return Y coordinate
     * @return Y coordinate
     */
    public int getY() {
        return y;
    }

    /** Method which implements gun movement */
    public void move() {

        if ((angle <= 10) && (angle >= 0) && (angularVelocity != 0)) {
            img = image2;
            rotate();
        }
        if ((speed > 0) && (x > 10))
            x -= speed;
        if ((speed < 0) && (x < 990))
            x -= speed;
        correctY();
        if ((angle <= 10) && (angularVelocity > 0))
            angle += angularVelocity;
        if ((angle >= 0) && (angularVelocity < 0))
            angle += angularVelocity;
    }

    /** Method that sets the correct Y coordinate */
    private void correctY() {
        if ((x < 210) || (x >= 960) || ((x >= 450) && (x < 620)))
            y = 175;
        if ((x < 245) && (x >= 130))
            y = (-x + 290);
        if ((x >= 245) && (x < 380))
            y = (x - 205);
        if ((x >= 530) && (x < 710))
            y = (int) (x * ((double)-27 / 80) + 353);
        if ((x >= 710) && (x < 890))
            y = (int) (x * ((double)27 / 80) - 125);
    }

    /**
     * Method that implements the action when the button is released
     * @param e an event which indicates that a keystroke occurred in a component
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_LEFT))
            speed = 0;
        if ((key == KeyEvent.VK_DOWN) || (key == KeyEvent.VK_UP))
            angularVelocity = 0;
    }

    /**
     * Method that implements the action when the button is pressed
     * @param e an event which indicates that a keystroke occurred in a component
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            speed = -2;
        }

        if (key == KeyEvent.VK_LEFT) {
            speed = 2;
        }

        if (key == KeyEvent.VK_UP) {
            angularVelocity = 1;
        }
        if (key == KeyEvent.VK_DOWN) {
            angularVelocity = -1;
        }
        if (key == KeyEvent.VK_ENTER) {
            core.setValues(angle, x, y);
        }

    }

    /** Method which rotates gun */
    public void rotate() {
        // Calculate the new size of the image based on the angle of rotaion
        double radians = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        int newWidth = (int) Math.round(img.getWidth() * cos + img.getHeight() * sin + 70 * sin);
        int newHeight = (int) Math.round(img.getWidth() * sin + img.getHeight() * cos + 40 * sin);

        // Create a new image
        BufferedImage rotate = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotate.createGraphics();
        // Calculate the "anchor" point around which the image will be rotated
        int x = (newWidth - img.getWidth()) / 2;
        int y = (newHeight - img.getHeight()) / 2 - (int) (20 * sin);
        // Transform the origin point around the anchor point
        AffineTransform at = new AffineTransform();
        at.setToRotation(radians, x + (img.getWidth() / 2), y + (img.getHeight() / 2) - 150);
        at.translate(x, y);
        g2d.setTransform(at);
        // Paint the originl image
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();
        img = rotate;
    }
}

