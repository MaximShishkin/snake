package ru.shishkin.snake;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame()
    {
        Panel p = new Panel();
        Container cont = getContentPane();
        cont.add(p);
        setTitle("Snake");
        setBounds(0,0,800,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
