package ru.liamin.vladimir;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/** Class which implements core movement */
public class Core {
    private BufferedImage img = ImageIO.read(new File("src\\main\\resources\\Core.png"));
    private int speed = 20;
    private int angle;
    private double speedY = speed;
    private double speedX = speed;
    private int x;
    private int y;

    public Core() throws IOException {
    }

    /** Method which implements core movement */
    public void move() {
        if (y < 120) {
            speedY -= 0.6;
            y -= speedY;
            x -= speedX;
        } else {
            speedX = 0;
            speedY = 0;
            x = 0;
        }

        if ((x < 245) && (x >= 130) && (y >= -x + 240)) {
            speedX = 0;
            speedY = 0;
            x = 0;
        }

        if ((x >= 245) && (x < 380) && (y >= x - 245)) {
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
    public void setValues(int angle, int x, int y) {
        this.angle = angle + 30;
        this.x = x - 52;
        this.y = y - 120;
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
