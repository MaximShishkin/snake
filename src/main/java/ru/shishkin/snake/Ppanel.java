package ru.shishkin.snake;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ppanel extends JPanel {
    private class myKey1 implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            System.out.println(keyCode);
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
    }

    public Ppanel() {
        addKeyListener(new myKey1());
        setFocusable(true);
    }
}
