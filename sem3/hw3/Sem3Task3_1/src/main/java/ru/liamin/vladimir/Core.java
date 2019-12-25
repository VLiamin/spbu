package ru.liamin.vladimir;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Class which implements core movement */
public class Core {
    private BufferedImage img = ImageIO.read(getClass().getResource("/Core.png"));
    private int speed = 20;
    private double angle;
    private double speedY = speed;
    private double speedX = speed;
    private int x = -100;
    private int y;
    private boolean isNormalDirection;
    private Landscape landscape;

    public Core(Landscape landscape) throws IOException {
        this.landscape = landscape;
    }

    /** Method which implements core movement */
    public void move() {
        int horizonDeletedCore = 120;
        if (y < horizonDeletedCore) {
            speedY -= 0.6;
            y -= speedY;
            if (isNormalDirection) {
                x -= speedX;
            }
            else {
                x += speedX;
            }
        } else {
            speedX = 0;
            speedY = 0;
            x = -100;
        }

        if ((x < landscape.getFirstTop()) && (x >= landscape.getFirstBeginHillCoordinate()) && (y >= -x + landscape.getFirstTop())) {
            speedX = 0;
            speedY = 0;
            x = -100;
        }

        if ((x >= landscape.getFirstTop()) && (x < landscape.getFirstEndHillCoordinate()) && (y >= x - landscape.getFirstTop())) {
            speedX = 0;
            speedY = 0;
            x = -100;
        }
    }

    /**
     * Method which set core location
     * @param angle core angle
     * @param x coordinate
     * @param y coordinate
     */
    public void setValues(double angle, int x, int y, boolean isNormalDirection) {
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
