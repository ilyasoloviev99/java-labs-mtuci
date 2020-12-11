package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class hide extends JFrame {
    private JLabel your_number = new JLabel("Введите число");
    private JTextField text = new JTextField();
    private JButton hide_field = new JButton("Скрыть поле");
    private boolean flag = true;
    public hide() {
        super("Простая программа");
        this.setBounds(600, 250, 300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text.setBackground(Color.RED);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 2, 2, 2));
        container.add(your_number);
        container.add(text);
        hide_field.addActionListener(new ButtonEventListener());
        container.add(hide_field);
    }
    class ButtonEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (flag) {
                hide_field.setText("Показать поле");
                text.setVisible(false);
            }
            else{
                hide_field.setText("Скрыть поле");
                text.setVisible(true);
            }
            flag=!flag;
        }
    }
}
