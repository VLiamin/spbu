package ru.liamin.vladimir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/** Class implements image */
public class Landscape extends JPanel implements ActionListener {
    private int firstBeginHillCoordinate = 130;
    private int firstTop = 245;
    private int firstEndHillCoordinate = 380;
    private int secondBeginHillCoordinate = 530;
    private int secondTop = 710;
    private int secondEndHillCoordinate = 890;
    private double secondHillSlope = (double) 27 / 80;
    private int minPossibleX = 10;
    private int maxPossibleX = 910;
    private Timer mainTimer = new Timer(15, this);
    private Image img = new ImageIcon(getClass().getResource("/Landscape.jpg")).getImage();
    private Core core = new Core(this);
    private Player p = new Player(core, this);

    public Landscape() throws IOException {
        mainTimer.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    /**
     * Method which creates a picture
     * @param g variable needed for drawing
     */
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
        g.drawImage(p.getRenderedInitialCannonImage(), p.getX(), p.getY(), null);
        if (core.getX() != -100) {
            g.drawImage(core.getImage(), core.getX(), core.getY(), null);
        }
    }

    /**
     * Method which return the abscissa of the first base of the first hill
     * @return the abscissa of the first base of the first hill
     */
    public int getFirstBeginHillCoordinate() {
        return firstBeginHillCoordinate;
    }

    /**
     * Method which return the abscissa of the top of the first hill
     * @return the abscissa of the top of the first hill
     */
    public int getFirstTop() {
        return firstTop;
    }

    /**
     * Method which return the abscissa of the second base of the first hill
     * @return the abscissa of the second base of the first hill
     */
    public int getFirstEndHillCoordinate() {
        return firstEndHillCoordinate;
    }

    /**
     * Method which return the abscissa of the first base of the second hill
     * @return the abscissa of the first base of the second hill
     */
    public int getSecondBeginHillCoordinate() {
        return secondBeginHillCoordinate;
    }

    /**
     * Method which return the abscissa of the top of the second hill
     * @return the abscissa of the top of the second hill
     */
    public int getSecondTop() {
        return secondTop;
    }

    /**
     * Method which return the abscissa of the second base of the second hill
     * @return the abscissa of the second base of the second hill
     */
    public int getSecondEndHillCoordinate() {
        return secondEndHillCoordinate;
    }

    /**
     * Method which return slope of the second hill
     * @return slope of the second hill
     */
    public double getSecondHillSlope() {
        return secondHillSlope;
    }

    /**
     * Method returning the right border for the cannon
     * @return the right border for the cannon
     */
    public int getMinPossibleX() {
        return minPossibleX;
    }

    /**
     * Method returning the left border for the cannon
     * @return the left border for the cannon
     */
    public int getMaxPossibleX() {
        return maxPossibleX;
    }

    private class MyKeyAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }
    }

    /**
     * Method which Invoked when an action occurs
     * @param e variable which indicates that a component-defined action occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        p.move();
        if (core.getX() != -100) {
            core.move();
        }
        repaint();
    }
}