package ru.liamin.vladimir;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/** Class which implements core movement */
public class Core {
    private BufferedImage img = ImageIO.read(getClass().getResource("/Core.png"));
    private int speed = 20;
    private int angle;
    private double speedY = speed;
    private double speedX = speed;
    private int x;
    private int y;
    private boolean isNormalDirection;

    public Core() throws IOException {
    }

    /** Method which implements core movement */
    public void move() {
        int horizonDeletedCore = 120;
        int firstBeginHillCoordinate = 130;
        int firstTop = 245;
        int firstEndHillCoordinate = 380;
        if (y < horizonDeletedCore) {
            speedY -= 0.6;
            y -= speedY;
            if (isNormalDirection)
                x -= speedX;
            else
                x += speedX;
        } else {
            speedX = 0;
            speedY = 0;
            x = 0;
        }

        if ((x < firstTop) && (x >= firstBeginHillCoordinate) && (y >= -x + firstTop)) {
            speedX = 0;
            speedY = 0;
            x = 0;
        }

        if ((x >= firstTop) && (x < firstEndHillCoordinate) && (y >= x - firstTop)) {
            speedX = 0;
            speedY = 0;
            x = 0;
        }
    }

    /**
     * Method which set core location
     * @param angle core angle
     * @param x coordinate
     * @param y coordinate
     */
    public void setValues(int angle, int x, int y, boolean isNormalDirection) {
        this.angle = angle;
        this.x = x;
        this.y = y;
        this.isNormalDirection = isNormalDirection;
        double radians = Math.toRadians(this.angle);
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        speedY = speed * sin;
        speedX = speed * cos;
    }

    /**
     * Method which returns X coordinate
     * @return X coordinate
     */
    public int getX() {
       return x;
    }

    /**
     * Method which returns Y coordinate
     * @return Y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Method which return core image
     * @return core image
     */
    public BufferedImage getImage() {
        return img;
    }
}
