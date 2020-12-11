package com.company;

import java.awt.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Нажмите");
    private JTextField hello = new JTextField("Привет");
    private JTextField word = new JTextField("Мир!");

    public SimpleGUI () {
        super("Простая программа");
        this.setBounds(100, 250, 200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(hello);
        container.add(word);
        container.add(button);
    }

}
