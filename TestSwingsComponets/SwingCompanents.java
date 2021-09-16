package TestSwingsComponets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwingCompanents extends JFrame {
    JButton buttonOk;
    JButton button1;
    JPanel Panel;
    JCheckBox checkBox;
    JLabel label;
    SwingCompanents(){
        setSize(400,400);
        setTitle("Test window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);
        setLayout(null);
        buttonOk = new JButton("Ok");
        button1 = new JButton("Ok");
        buttonOk.setBounds(50,220,50,50);
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Panel.getComponentCount ();
                // устанавливаем активность всех компонентов
                // в соответствии со статусом чекбокса
                for (int i=0;i <n;i++)
                     {Panel.getComponent(i).setEnabled(!checkBox.isSelected ());}
                // если чекбокс выбран. задаем серый фон панели
                if(checkBox.isSelected ())
                    {Panel.setBackground (Color. GRAY);}
                else {Panel.setBackground(Color.WHITE);}                               // если чекбокс не выбран, задаем белый фон панели
            }
        });
        checkBox = new JCheckBox("Скрыть панель");
        checkBox.setBounds(50,160,150,50);
        label = new JLabel("Тестовая строка отображения на панели");
        Panel = new JPanel();
        Panel.setBackground(Color.WHITE);
        Panel.setBounds(0,0,300,150);



        Panel.add(label);
        Panel.add(button1);
        add(Panel);
        add(buttonOk);
        add(checkBox);

    };


    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SwingCompanents().setVisible(true);
            }
        });
    }
}
