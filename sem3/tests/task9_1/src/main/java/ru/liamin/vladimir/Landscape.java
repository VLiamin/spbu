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
    private Core core2 = new Core(this);
    private Player player = new Player(core, this);
    private Player player2 = new Player(core2, this);
    private ICannon iCannon;

    public Landscape(ICannon iCannon) throws IOException {
        mainTimer.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
        this.iCannon = iCannon;
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
        try {
            String s = iCannon.receive();

            if (s.equals("true"))
                System.out.println(s);
            if (s.equals("true")) {
                core.setValues(player2.getAngle(), player2.getX() - 50, player2.getY() - 120);
            } else if (s.contains(".")) {
                player2.setAngle(Double.parseDouble(s));
            } else {
                player2.setX(Integer.parseInt(s));
                player2.updateCurrentY();
            }

        } catch (Exception e) {

        }
        if (player.getFire() == 1) {

            player.setFire(0);
            iCannon.send("true");
        } else if (player.getRotate() == 1) {
            iCannon.send(Double.toString(player.getAngle()));
            player.setRotate(0);
        } else {
            iCannon.send(Integer.toString(player.getX()));
        }
        player.rotate(g);
        player2.rotate(g);
        g.drawImage(player.getWheelImage(), player.getWheelX(), player.getWheelY(), null);
        g.drawImage(player2.getWheelImage(), player2.getWheelX(), player2.getWheelY(), null);
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