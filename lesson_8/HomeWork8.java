package lesson_8;

/**
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeWork8 extends JFrame {
    Font countFont = new Font("Arial",Font.BOLD, 50);
    Font resetFont = new Font("Arial",Font.BOLD, 30);
    private int count = 0;
    private int saveCount;
    private boolean saveMode=false;
    public HomeWork8(){
        setBounds(300,300,280,180);
        setTitle("Счетчик");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel countLabel = new JLabel("0");                    //метка счетчика
        countLabel.setFont(countFont);
        countLabel.setBounds(110, 15, 80, 60);
        add(countLabel);

        JLabel saveCountLabel = new JLabel("0");                //метка сохранения опказателя счетчика
        saveCountLabel.setFont(resetFont);
        saveCountLabel.setBounds(210, 80, 40, 30);
        add(saveCountLabel);

        JButton minusButton = new JButton(" < ");               //кнопка минуса
        minusButton.setBounds(20, 20, 50, 50);
        add(minusButton);
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count--;
                countLabel.setText(String.valueOf(count));
            }
        });

        JButton plusButton = new JButton();                         //кнопка плюса
        plusButton.setText(" > ");
        plusButton.setBounds(200, 20, 50, 50);
        add(plusButton);
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count++;
                countLabel.setText(String.valueOf(count));
            }
        });

        JButton resetButton = new JButton("C");                 //кнопка сброса
        resetButton.setBounds(20, 80, 50, 30);
        add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count = 0;
                countLabel.setText(String.valueOf(count));
            }
        });

        JButton saveButton = new JButton("Save count");         //кнопка сохранения
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
//    @Override
//    public void paint(Graphics g) {
//        Graphics2D graf = (Graphics2D) g;
//        graf.setColor(Color.RED);
//        graf.setFont(resetFont);
//    }

    public static void main(String[] args) {
        new HomeWork8();
    }
}
