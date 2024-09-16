package ru.liamin.vladimir;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Class class that implements gun movement */
public class Player {

    private BufferedImage Cannon = ImageIO.read(getClass().getResource("/Cannon.png"));
    private BufferedImage Wheel = ImageIO.read(getClass().getResource("/Wheel.png"));
    private Core core;
    private double angle = 0;
    private double angularVelocity = 0;
    private int x = 600;
    private int y = ConstantOfLandscape.HORIZON_ORDINARY;
    private int speed = 0;
    private Landscape landscape;
    private ICannon iCannon;
    private int fire;
    private int rotate = 0;

    public Player(Core core, Landscape landscape) throws IOException {
        this.core = core;
        this.landscape = landscape;
    }

    public void setICAnnon(ICannon iCannon) {
        this.iCannon = iCannon;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public int getFire() {
        return fire;
    }

    /**
     * Method which return gun image
     * @retur gun image
     */
    public BufferedImage getWheelImage() {
        return Wheel;
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
    /**
     * Method which return Y coordinate of Wheel
     * @return Y coordinate of Wheel
     */
    public int getWheelY() {
        return y + ConstantsOFCannon.CANNON_HEIGHT;
    }

    public int getWheelX() {
        return x + ConstantsOFCannon.CANNON_LENGTH;
    }

    /** Method which implements gun movement */
    public void move() {
        if (((speed > 0) && (x > ConstantOfLandscape.MIN_POSSIBLE_X)) || ((speed < 0) && (x < ConstantOfLandscape.MAX_POSSIBLE_X))) {
            x -= speed;
        }
        updateCurrentY();
        if ((angle <= ConstantsOFCannon.MAX_ANGLE) && (angle >= ConstantsOFCannon.MIN_ANGLE))
            angle += angularVelocity;
        if (angle > ConstantsOFCannon.MAX_ANGLE)
            angle = ConstantsOFCannon.MAX_ANGLE;
        if (angle < ConstantsOFCannon.MIN_ANGLE)
            angle = ConstantsOFCannon.MIN_ANGLE;
    }

    /** By given x coordinate of cannon sets correct value to y */
    public void updateCurrentY() {
        if (x >= ConstantOfLandscape.FIRST_BEGIN_HILL_COORDINATE && x <= ConstantOfLandscape.FIRST_TOP)
            y = ConstantOfLandscape.HORIZON_ORDINARY - x + ConstantOfLandscape.FIRST_BEGIN_HILL_COORDINATE;

        if (x >= 810 && x <= 970)
            y = ConstantOfLandscape.HORIZON_ORDINARY - x + ConstantOfLandscape.SECOND_BEGIN_HILL_COORDINATE;

        if (x >= ConstantOfLandscape.FIRST_TOP && x <= ConstantOfLandscape.FIRST_END_HILL_COORDINATE)
            y = ConstantOfLandscape.HORIZON_ORDINARY + x - ConstantOfLandscape.FIRST_END_HILL_COORDINATE;

        if (x >= ConstantOfLandscape.SECOND_TOP && x <= ConstantOfLandscape.SECOND_END_HILL_COORDINATE)
            y = ConstantOfLandscape.HORIZON_ORDINARY + x - ConstantOfLandscape.SECOND_END_HILL_COORDINATE;
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
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            speed = -maxSpeed;
        }

        if (key == KeyEvent.VK_LEFT) {
            speed = maxSpeed;
        }

        if (key == KeyEvent.VK_UP) {
            rotate = 1;
            angularVelocity = maxAngularVelocity;
        }
        if (key == KeyEvent.VK_DOWN) {
            rotate = 1;
            angularVelocity = -maxAngularVelocity;
        }

        if (key == KeyEvent.VK_ENTER) {
            fire = 1;
            core.setValues(angle, x - 50, y - 120);
        }

    }

    /** Method which rotates gun */
    public void rotate(Graphics g) {
        BufferedImage image = Cannon;
        double locationX = image.getWidth() / 2;
        double locationY = image.getHeight() / 2;

        AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians(-angle + 20), locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g.drawImage(op.filter(image, null), getX(), getY(), null);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    public void setRotate(int rotate) {
        this.rotate = rotate;
    }

    public int getRotate() {
        return rotate;
    }

}