package lesson_8;

/**
 *   Домашняя работа Шевеленко Андрея к 8 лекции
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeWork8 extends JFrame {
    Font countFont = new Font("Arial",Font.BOLD, 50);
    Font resetFont = new Font("Arial",Font.BOLD, 30);
    private int count = 0;              // Переменная счетчика
    private int saveCount;              // Переменная сохранения результата счетчика
    private boolean saveMode=false;     // Переменная статуса переключателя сохранения значения счетчика
    public HomeWork8(){
        setBounds(300,300,280,180);
        setTitle("Счетчик");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);         //отменяем работу компановщика
/**
 *    метка счетчика
 */
        JLabel countLabel = new JLabel("0");
        countLabel.setFont(countFont);
        countLabel.setBounds(110, 15, 80, 60);
        add(countLabel);
/**
 *    метка сохранения показателя счетчика
 */
        JLabel saveCountLabel = new JLabel("0");
        saveCountLabel.setFont(resetFont);
        saveCountLabel.setBounds(210, 80, 40, 30);
        add(saveCountLabel);
/**
 *    кнопка минуса
 */
        JButton minusButton = new JButton(" < ");
        minusButton.setBounds(20, 20, 50, 50);
        minusButton.setFont(new java.awt.Font("Dialog", 1, 14));
        add(minusButton);
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count--;
                countLabel.setText(String.valueOf(count));
            }
        });
/**
 *    кнопка плюса
 */
        JButton plusButton = new JButton();
        plusButton.setText(" > ");
        plusButton.setBounds(200, 20, 50, 50);
        plusButton.setFont(new java.awt.Font("Dialog", 1, 14));
        add(plusButton);
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count++;
                countLabel.setText(String.valueOf(count));
            }
        });
/**
 *    кнопка сброса
 */
        JButton resetButton = new JButton("C");
        resetButton.setBounds(20, 80, 50, 30);
        resetButton.setForeground(Color.red);
        add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count = 0;
                countLabel.setText(String.valueOf(count));
            }
        });
/**
 *    кнопка сохранения
 */
        JButton saveButton = new JButton("Save count");
        saveButton.setBounds(80, 80, 110, 30);
        add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!saveMode){
                    saveCount = count;
                    saveCountLabel.setText(String.valueOf(count));
                    saveButton.setText("Saved..");
                    saveMode=true;
                }else{
                    count=saveCount;
                    countLabel.setText(String.valueOf(count));
                    saveMode=false;
                    saveButton.setText("Save count");
                }
            }
        });
        setLocationRelativeTo (null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new HomeWork8();
    }
}
