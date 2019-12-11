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
    private BufferedImage imgLeft = ImageIO.read(new File("src\\main\\resources\\GunRight.png"));
    private BufferedImage imageLeft2 = ImageIO.read(new File("src\\main\\resources\\GunRight.png"));
    private BufferedImage imgRight = ImageIO.read(new File("src\\main\\resources\\GunLeft.png"));
    private BufferedImage imageRight2 = ImageIO.read(new File("src\\main\\resources\\GunLeft.png"));
    private BufferedImage img = imgLeft;
    private BufferedImage img2 = imageLeft2;
    private Core core;
    private final int horizon = 175;
    private int angle = 0;
    private int angularVelocity = 0;
    private int x = 910;
    private int y = horizon;
    private int speed = 0;
    private boolean isNormalDirection = true;

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

        int maxAngle = 10;
        if ((angle <= maxAngle) && (angle >= 0) && (angularVelocity != 0)) {
            img = img2;
            rotate();
        }
        if (((speed > 0) && (x > 10)) || ((speed < 0) && (x < 990)))
            x -= speed;
        correctY();
        if (((angle <= 10) && (angularVelocity > 0)) || ((angle >= 0) && (angularVelocity < 0)))
            angle += angularVelocity;
    }

    /** Method that sets the correct Y coordinate */
    private void correctY() {
        int firstBeginHillCoordinate = 130;
        int firstTop = 245;
        int firstEndHillCoordinate = 380;
        int secondBeginHillCoordinate = 530;
        int secondTop = 710;
        int secondEndHillCoordinate = 890;
        double secondHillSlope = (double) 27 / 80;
        int copyX = x;
        if (!isNormalDirection)
            copyX += 50;
        if ((copyX < firstBeginHillCoordinate) || (copyX >= secondBeginHillCoordinate) ||
                ((copyX >= firstEndHillCoordinate) && (copyX < secondBeginHillCoordinate)))
            y = horizon;
        if ((copyX < firstTop) && (copyX >= firstBeginHillCoordinate))
            y = (-copyX + 290);
        if ((copyX >= firstTop) && (copyX < firstEndHillCoordinate))
            y = (copyX - 205);
        if ((copyX >= secondBeginHillCoordinate) && (copyX < secondTop))
            y = (int) (copyX * (-secondHillSlope) + 353);
        if ((copyX >= secondTop) && (copyX < secondEndHillCoordinate))
            y = (int) (copyX * (secondHillSlope) - 125);
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
        int maxSpeed = 2;
        int maxAngularVelocity = 1;
        int angleOfBarrel = 30;
        int barrelHeight = 120;
        int barrelLength = 52;
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            if (isNormalDirection) {
                img = imgRight;
                isNormalDirection = false;
                img2 = imageRight2;
            }
            speed = -maxSpeed;
        }

        if (key == KeyEvent.VK_LEFT) {
            if (!isNormalDirection) {
                img = imgLeft;
                img2 = imageLeft2;
                isNormalDirection = true;
            }

            speed = maxSpeed;
        }

        if (key == KeyEvent.VK_UP) {
            angularVelocity = maxAngularVelocity;
        }
        if (key == KeyEvent.VK_DOWN) {
            angularVelocity = -maxAngularVelocity;
        }
        if (key == KeyEvent.VK_ENTER) {
            if (isNormalDirection)
                core.setValues(angle + angleOfBarrel, x - barrelLength, y - barrelHeight, isNormalDirection);
            else
                core.setValues(angle + angleOfBarrel, x + barrelLength * 2 + 20, y - barrelHeight, isNormalDirection);
        }

    }

    /** Method which rotates gun */
    public void rotate() {
        // Calculate the new size of the image based on the angle of rotaion
        double radians = Math.toRadians(angle);
        if (!isNormalDirection)
            radians = -radians;
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        int newWidth = (int) Math.round(img.getWidth() * cos + img.getHeight() * sin + 70 * sin);
        if (!isNormalDirection)
            newWidth +=20;
        int newHeight = (int) Math.round(img.getWidth() * sin + img.getHeight() * cos + 40 * sin);

        // Create a new image
        BufferedImage rotate = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotate.createGraphics();
        // Calculate the "anchor" point around which the image will be rotated
        int x = (newWidth - img.getWidth()) / 2;
        int y = (newHeight - img.getHeight()) / 2 - (int) (20 * sin);
        // Transform the origin point around the anchor point
        AffineTransform at = new AffineTransform();
        if (isNormalDirection)
        at.setToRotation(radians, x + (img.getWidth() / 2), y + (img.getHeight() / 2) - 150);
        else
            at.setToRotation(radians, x + (img.getWidth() / 2), y + (img.getHeight() / 2));
        at.translate(x, y);
        g2d.setTransform(at);
        // Paint the originl image
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();
        img = rotate;
    }
}

