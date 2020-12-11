package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class message extends JFrame {
    private JTextField text = new JTextField();
    private JButton display = new JButton("Отобразить");
    private boolean flag = true;
    public message() {
        super("Простая программа");
        this.setBounds(900, 250, 300, 70);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 2, 2, 2));
        container.add(text);
        display.addActionListener(new ButtonEventListener());
        container.add(display);
    }
    class ButtonEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            String message = text.getText();
            if(message.length()==0){
                JOptionPane.showMessageDialog(null, "Введите текст", "Ошибка", JOptionPane.PLAIN_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, message, "Информация", JOptionPane.PLAIN_MESSAGE);
        }
    }
}