package ru.liamin.vladimir;

import javax.swing.*;
import java.io.IOException;

/** Class which shows game */
public class Cannon {
    public static void main(String[] args) throws IOException {
        JFrame f = new JFrame("Cannon");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(1150, 652);
        f.add(new Landscape());
        f.setVisible(true);
    }
}