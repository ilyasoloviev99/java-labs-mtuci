package com.company;
import java.awt.*;
import javax.swing.*;

public class Enter_your_name extends JFrame {
    private JLabel your_name = new JLabel("Введите имя");
    private JTextField name = new JTextField();
    private JButton is_ready = new JButton("Всё готово");
    private JCheckBox agree = new JCheckBox("Согласны?");
    public Enter_your_name () {
        super("Простая программа");
        this.setBounds(300, 250, 300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        name.setBackground(Color.RED);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 2, 2, 2));
        container.add(your_name);
        container.add(name);
        container.add(is_ready);
        container.add(agree);
    }
}
