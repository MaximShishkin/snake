package ru.shishkin.maxim.snake;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame() {
        Panel panel = new Panel();
        add(panel);
        setTitle("Snake");
        setBounds(0, 0, 800, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}