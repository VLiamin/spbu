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

    private Timer mainTimer = new Timer(15, this);
    private Image img = new ImageIcon(getClass().getResource("/backGround.png")).getImage();
    private Core core = new Core(this);
    private Player player = new Player(core, this);

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
        if (core.getX() != -100) {
            g.drawImage(core.getImage(), core.getX(), core.getY(), null);
        }
        player.rotate(g);
        g.drawImage(player.getWheelImage(), player.getWheelX(), player.getWheelY(), null);
    }

    private class MyKeyAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }

    /**
     * Method which Invoked when an action occurs
     * @param e variable which indicates that a component-defined action occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        player.move();
        if (core.getX() != -100) {
            core.move();
        }
        repaint();
    }
}