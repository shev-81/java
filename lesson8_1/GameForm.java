package lesson8_1;
/**
 * Домашнее задание Шевеленко Андрея Александровича к 8 лекции
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

import static java.lang.Thread.sleep;

public class GameForm extends JFrame{
    private JPanel rootPan;
    private JPanel upPane;
    private JPanel gamePane;
    public static JLabel labl;
    private JButton virtButton;
    private static JButton [][] map;   // игровое поле
    public static  String DOT_X = "X"; // ход игрока
    public static  String DOT_O = "O"; // ход cpu
    public static  String DOT_EMPTY = " ";
    public static int xbloc;
    public static int ybloc;
    public static int SIZE = 3;
    public static Random rand = new Random();
    Font gameFont = new Font("Arial",Font.BOLD, 50);

    GameForm(){
       //настройки главной панели
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       labl = new JLabel("Съиграем");
       labl.setFont(gameFont);
       upPane.add(labl);
       setBounds(200,200,500,600);

       //настройки верхней панели
       upPane.setBounds(0,0,500,100);

       //настройки игровой панели
       gamePane.setBounds(0,100,500,500);
       gamePane.setLayout(new GridLayout(3,3));

       //инициализируем игровое поле
       map = new JButton[3][3];
       for(int x=0; x<3; x++){
           for(int y=0; y<3; y++) {
               map[x][y] = new JButton(" ");
               gamePane.add(map[x][y]).setFont(gameFont);
               virtButton= map[x][y];
               virtButton.addActionListener(e -> {humanTurn(e);});
           }
       }
       add(rootPan);

    }
    //ход игрока
    public  static void humanTurn(ActionEvent avt) {
       for(int i=0;i<3;i++)
          for(int j=0;j<3;j++)
             if(avt.getSource().hashCode()==map[i][j].hashCode())
                 map[i][j].setText(DOT_X);

        if(checkWin(DOT_X)) {
            TestThread thObj = new TestThread(labl);
            Thread thr = new Thread(thObj);
            thr.start();
            labl.setText("Победа");
            System.out.println("Человек победил");
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e);
            }
            System.exit(0);
        }
        if(isMapFull()) {
            labl.setText("О.П Ничья");
            System.out.println(labl.getText());
            TestThread thObj = new TestThread(labl);
            Thread thr = new Thread(thObj);
            thr.start();
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e);
            }
            System.exit(0);
        }
        aiTurn();

        if(checkWin(DOT_O)){
            labl.setText("Поражение");
            TestThread thObj = new TestThread(labl);
            Thread thr = new Thread(thObj);
            thr.start();
            System.out.println("Компьютер победил");
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e);
            }
            System.exit(0);
        }

    }
    //Ход CPU
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        xbloc = x; ybloc = y;
        BlokWinHuman();
    }
    // Метод Блокировки победы человека
    public static boolean BlokWinHuman() {
        for (int i=0; i < map.length; i++){
            //проверяем победит ли пользователь на ветках i
            if(isCellValid(i,0) && map[i][1].getText().equals(DOT_X) && map[i][2].getText().equals(DOT_X)){ xbloc=i; ybloc=0; map[xbloc][ybloc].setText(DOT_O);  return true;}
            if(map[i][0].getText().equals(DOT_X) && map[i][1].getText().equals(DOT_X) && isCellValid(i,2)) { xbloc=i; ybloc=2; map[xbloc][ybloc].setText(DOT_O); return true;}
            //проверяем победит ли пользователь на ветках y
            if(isCellValid(0,i) && map[1][i].getText().equals(DOT_X) && map[2][i].getText().equals(DOT_X)) { xbloc=0; ybloc=i; map[xbloc][ybloc].setText(DOT_O); return true;}
            if(map[0][i].getText().equals(DOT_X) && map[1][i].getText().equals(DOT_X) && isCellValid(2,i)) { xbloc=2; ybloc=i; map[xbloc][ybloc].setText(DOT_O); return true;}
            //проверяем победит ли пользователь на диагональных ветках
            if(isCellValid(0,0)  && map[1][1].getText().equals(DOT_X) && map[2][2].getText().equals(DOT_X)) { xbloc=0; ybloc=0; map[xbloc][ybloc].setText(DOT_O); return true;}
            if(map[0][0].getText().equals(DOT_X) && map[1][1].getText().equals(DOT_X) && isCellValid(2,2)) { xbloc=2; ybloc=2; map[xbloc][ybloc].setText(DOT_O); return true;}
            // обратная диагональ
            if(isCellValid(0,2) && map[1][1].getText().equals(DOT_X) && map[2][0].getText().equals(DOT_X)) { xbloc=0; ybloc=2; map[xbloc][ybloc].setText(DOT_O); return true;}
            if(map[0][2].getText().equals(DOT_X) && map[1][1].getText().equals(DOT_X) && isCellValid(2,0)) { xbloc=2; ybloc=0; map[xbloc][ybloc].setText(DOT_O); return true;}
        }
        map[xbloc][ybloc].setText(DOT_O);
//        labl.setText("CPU походил");
        return false;
    }
    // проверка пустое ли поле
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y].getText().equals(DOT_EMPTY)) return true;
        return false;
    }
    // Модифицирован  метод проверки победы
    public static boolean checkWin(String symb) {
        for (int i=0; i < map.length; i++){
            if(map[i][0].getText().equals(symb) && map[i][1].getText().equals(symb) && map[i][2].getText().equals(symb)) return true;
            if(map[0][i].getText().equals(symb) && map[1][i].getText().equals(symb) && map[2][i].getText().equals(symb)) return true;
            if(map[0][0].getText().equals(symb) && map[1][1].getText().equals(symb) && map[2][2].getText().equals(symb)) return true;
            if(map[0][2].getText().equals(symb) && map[1][1].getText().equals(symb) && map[2][0].getText().equals(symb)) return true;
        }
        return false;
    }
    // метод проверки полноты игрововго поля
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j].getText().equals(DOT_EMPTY)) return false;
            }
        }
        return true;
    }
}
class TestThread implements Runnable{
    public static JLabel lbl;
    // присваиваем ссылку с метки из основного окна и потока, на метку для объекта второго потока
    // обе переменные имеют ссылки на один объект метки.
    TestThread(JLabel able){
        lbl = able;
    }
    @Override
    public void run(){
        System.out.println("работает параллельный поток");
        System.out.println("П.П. переданное значение метки"+lbl.getText());
        //SwingUtilities.invokeLater(()->lbl.setText("Работаем"));
        java.awt.EventQueue.invokeLater(()->lbl.setText("Работаем"));
        //lbl.setText("П.П. Работаем");
        System.out.println("П.П. значение метки через диспетчер "+lbl.getText());
    }
}