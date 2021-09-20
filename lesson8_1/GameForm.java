package lesson8_1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GameForm extends JFrame {
    private JPanel rootPan;
    private JPanel upPane;
    private JPanel gamePane;
    public  JLabel labl;
    public JButton virtButton;
    private static JButton [][] map;   // игровое поле
    public static  String DOT_X = "X"; // ход игрока
    public static  String DOT_O = "O"; // ход cpu
    public static  String DOT_EMPTY = " ";   // '•'
    public static int xbloc;
    public static int ybloc;
    public static int SIZE = 3;
    public static Random rand = new Random();
    Font gameFont = new Font("Arial",Font.BOLD, 70);

    GameForm(){
       //настройки главной панели
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
               virtButton.addActionListener(e -> {
                   try {
                       humanTurn(e,labl);
                   } catch (InterruptedException interruptedException) {
                       interruptedException.printStackTrace();
                   }
               });
           }
       }
       add(rootPan);
       setVisible(true);

    }
    //ход игрока
    public void humanTurn(ActionEvent avt, JLabel lbl) throws InterruptedException {
        if(avt.getActionCommand().equals(DOT_O)) {
            lbl.setText("Ходи еще");
        }
        else {
            lbl.setText("Ход игрока");
            System.out.println(avt.getSource().hashCode());
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++)
                    if(avt.getSource().hashCode()==map[i][j].hashCode())
                        map[i][j].setText(DOT_X);

        }

        if(checkWin(DOT_X)) {
            lbl.setText("Человек победил");
            System.out.println("Человек победил");
            System.exit(0);
        }
        if(isMapFull()) {
            labl.setText("Ничья");
            System.out.println("Ничья");
            System.exit(0);
        }
        aiTurn();

        if(checkWin(DOT_O)){
            lbl.setText("Компьютер победил");
            System.out.println("Компьютер победил");
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
