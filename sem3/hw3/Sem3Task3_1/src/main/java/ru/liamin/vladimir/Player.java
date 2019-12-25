package ru.liamin.vladimir;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Class class that implements gun movement */
public class Player {
    private BufferedImage renderedLeftSideCannon = ImageIO.read(getClass().getResource("/CannonRight.png"));
    private BufferedImage leftSideCannon = ImageIO.read(getClass().getResource("/CannonRight.png"));
    private BufferedImage renderedRightSideCannon = ImageIO.read(getClass().getResource("/CannonLeft.png"));
    private BufferedImage rightSideCannon = ImageIO.read(getClass().getResource("/CannonLeft.png"));
    private BufferedImage renderedInitialCannonImage = renderedLeftSideCannon;
    private BufferedImage initialCannonImage = leftSideCannon;
    private Core core;
    private final int horizonOrdinate = 175;
    private double angle = 0;
    private double angularVelocity = 0;
    private int x = 890;
    private int y = horizonOrdinate;
    private int speed = 0;
    private boolean isNormalDirection = true;
    private Landscape landscape;

    public Player(Core core, Landscape landscape) throws IOException {
        this.core = core;
        this.landscape = landscape;
    }

    /**
     * Method which return gun image
     * @retur gun image
     */
    public BufferedImage getRenderedInitialCannonImage() {
        return renderedInitialCannonImage;
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
            renderedInitialCannonImage = initialCannonImage;
            rotate();
        }
        if (((speed > 0) && (x > landscape.getMinPossibleX())) || ((speed < 0) && (x < landscape.getMaxPossibleX()))) {
            x -= speed;
        }
        updateCurrentY();
        if (((angle <= maxAngle) && (angularVelocity > 0)) || ((angle >= 0) && (angularVelocity < 0))) {
            angle += angularVelocity;
        }
    }

    /** By given x coordinate of cannon sets correct value to y */
    // In this method, y is reconstructed using the equation of the mountain slope
    private void updateCurrentY() {
        int copyX = x;
        if (!isNormalDirection)
            copyX += 80;
        if ((copyX < landscape.getFirstBeginHillCoordinate()) || (copyX >= landscape.getSecondEndHillCoordinate()) ||
                ((copyX >= landscape.getFirstEndHillCoordinate()) && (copyX < landscape.getSecondBeginHillCoordinate()))) {
            y = horizonOrdinate;
        }
        if ((copyX < landscape.getFirstTop()) && (copyX >= landscape.getFirstBeginHillCoordinate())) {
            y = (-copyX + 290);
        }
        if ((copyX >= landscape.getFirstTop()) && (copyX < landscape.getFirstEndHillCoordinate())) {
            y = (copyX - 205);
        }
        if ((copyX >= landscape.getSecondBeginHillCoordinate()) && (copyX < landscape.getSecondTop())) {
            y = (int) (copyX * (-landscape.getSecondHillSlope()) + 353);
        }
        if ((copyX >= landscape.getSecondTop()) && (copyX < landscape.getSecondEndHillCoordinate())) {
            y = (int) (copyX * (landscape.getSecondHillSlope()) - 125);
        }
    }

    /**
     * Method that implements the action when the button is released
     * @param e an event which indicates that a keystroke occurred in a component
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_LEFT)) {
            speed = 0;
        }
        if ((key == KeyEvent.VK_DOWN) || (key == KeyEvent.VK_UP)) {
            angularVelocity = 0;
        }
    }

    /**
     * Method that implements the action when the button is pressed
     * @param e an event which indicates that a keystroke occurred in a component
     */
    public void keyPressed(KeyEvent e) {
        int maxSpeed = 2;
        double maxAngularVelocity = 0.5;
        int angleOfBarrel = 25;
        int barrelHeight = 120;
        int barrelLength = 52;
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            System.out.println(x + " " + y);
            if (isNormalDirection) {
                renderedInitialCannonImage = renderedRightSideCannon;
                isNormalDirection = false;
                initialCannonImage = rightSideCannon;
                rotate();
            }
            speed = -maxSpeed;
        }

        if (key == KeyEvent.VK_LEFT) {
            System.out.println(x + " " + y);
            if (!isNormalDirection) {
                renderedInitialCannonImage = renderedLeftSideCannon;
                initialCannonImage = leftSideCannon;
                isNormalDirection = true;
                rotate();
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
            if (isNormalDirection) {
                core.setValues(angle + angleOfBarrel, x - barrelLength, (int) (y - barrelHeight + 10 * Math.sin(angle)), true);
            }
            else {
                core.setValues(angle + angleOfBarrel, x + barrelLength * 2 + 20 - (int) (15 * Math.sin(angle)), y - 125, false);
            }
        }

    }

    /** Method which rotates gun */
    public void rotate() {
        // Calculate the new size of the image based on the angle of rotaion
        double radians = Math.toRadians(angle);
        if (!isNormalDirection) {
            radians = -radians;
        }
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        int newWidth = (int) Math.round(renderedInitialCannonImage.getWidth() * cos + renderedInitialCannonImage.getHeight() * sin + 70 * sin) + 10;
        if (!isNormalDirection) {
            newWidth += 20;
        }
        int newHeight = (int) Math.round(renderedInitialCannonImage.getWidth() * sin + renderedInitialCannonImage.getHeight() * cos + 40 * sin) + 10;

        // Create a new image
        BufferedImage rotate = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotate.createGraphics();
        // Calculate the "anchor" point around which the image will be rotated
        int x = (newWidth - renderedInitialCannonImage.getWidth()) / 2;
        int y = (newHeight - renderedInitialCannonImage.getHeight()) / 2 - 5 - (int) (20 * sin);
        // Transform the origin point around the anchor point
        AffineTransform at = new AffineTransform();
        if (isNormalDirection) {
            at.setToRotation(radians,  x + (renderedInitialCannonImage.getWidth() / 2) + 75, y + (renderedInitialCannonImage.getHeight() / 2) - 110);
        }
        else {
            at.setToRotation(radians, x + (renderedInitialCannonImage.getWidth() / 2) - 40, y + (renderedInitialCannonImage.getHeight() / 2) - 100);
        }
        at.translate(x, y);
        g2d.setTransform(at);
        // Paint the originl image
        g2d.drawImage(renderedInitialCannonImage, 0, 0, null);
        g2d.dispose();
        renderedInitialCannonImage = rotate;
    }
}

