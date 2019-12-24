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
    private Image img = new ImageIcon(getClass().getResource("/Landscape.jpg")).getImage();
    private Core core = new Core();
    private Player p = new Player(core);

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
        g.drawImage(p.getImg(), p.getX(), p.getY(), null);
        if (core.getX() != 0) {
            g.drawImage(core.getImage(), core.getX(), core.getY(), null);
        }
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
        if (core.getX() != 0) {
            core.move();
        }
        repaint();
    }
}