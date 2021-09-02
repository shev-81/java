package lesson_4;

/**
 *   Домашнее задание к 4 уроку Шевеленко Андрея Александровича
 *
 */

import java.util.Random;
import java.util.Scanner;


public class HomeWork {
    public static int SIZE = 3;
    //public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static int xbloc;
    public static int ybloc;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            if (BlokWinHuman(xbloc, ybloc)) {
                System.out.println("Компьютер Блокировал победу пользователю и походил в точку" + (xbloc + 1) + " " + (ybloc + 1));
            } else {
                aiTurn();
                map[xbloc][ybloc] = DOT_O;
                System.out.println("Компьютер походил в точку " + (xbloc + 1) + " " + (ybloc + 1));
            }
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    // Метод Блокировки победы человека
    public static boolean BlokWinHuman(int x, int y) {
        for (int i=0; i < map.length; i++){
            //проверяем победит ли пользователь на ветках i
            if(isCellValid(i,0) && map[i][1] == DOT_X && map[i][2] == DOT_X){ xbloc=i; ybloc=0; map[xbloc][ybloc] = DOT_O; return true;}
            if(map[i][0] == DOT_X && isCellValid(i,1) && map[i][2] == DOT_X) { xbloc=i; ybloc=1; map[xbloc][ybloc] = DOT_O; return true;}
            if(map[i][0] == DOT_X && map[i][1] == DOT_X && isCellValid(i,2)) { xbloc=i; ybloc=2; map[xbloc][ybloc] = DOT_O; return true;}
            //проверяем победит ли пользователь на ветках y
            if(isCellValid(0,i) && map[1][i] == DOT_X && map[2][i] == DOT_X) { xbloc=0; ybloc=i; map[xbloc][ybloc] = DOT_O; return true;}
            if(map[0][i] == DOT_X && isCellValid(1,i) && map[2][i] == DOT_X) { xbloc=1; ybloc=i; map[xbloc][ybloc] = DOT_O; return true;}
            if(map[0][i] == DOT_X && map[1][i] == DOT_X && isCellValid(2,i)) { xbloc=2; ybloc=i; map[xbloc][ybloc] = DOT_O; return true;}
            //проверяем победит ли пользователь на диагональных ветках
            if(isCellValid(0,0)  && map[1][1] == DOT_X && map[2][2] == DOT_X) { xbloc=0; ybloc=0; map[xbloc][ybloc] = DOT_O;return true;}
            if(map[0][0] == DOT_X && isCellValid(1,1) && map[2][2] == DOT_X) { xbloc=1; ybloc=1; map[xbloc][ybloc] = DOT_O; return true;}
            if(map[0][0] == DOT_X && map[1][1] == DOT_X && isCellValid(2,2)) { xbloc=2; ybloc=2; map[xbloc][ybloc] = DOT_O; return true;}
            // обратная диагональ
            if(isCellValid(0,2) && map[1][1] == DOT_X && map[2][0] == DOT_X) { xbloc=0; ybloc=2; map[xbloc][ybloc] = DOT_O; return true;}
            if(map[0][2] == DOT_X && isCellValid(1,1) && map[2][0] == DOT_X) { xbloc=1; ybloc=1; map[xbloc][ybloc] = DOT_O; return true;}
            if(map[0][2] == DOT_X && map[1][1] == DOT_X && isCellValid(2,0)) { xbloc=2; ybloc=0; map[xbloc][ybloc] = DOT_O; return true;}
        }
        return false;
    }
    // Модифицирован  метод проверки победы
    public static boolean checkWin(char symb) {
        for (int i=0; i < map.length; i++){
            if(map[i][0] == symb && map[i][1] == symb && map[i][2] == symb) return true;
            if(map[0][i] == symb && map[1][i] == symb && map[2][i] == symb) return true;
            if(map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
            if(map[0][2] == symb && map[1][1] == symb && map[2][0] == symb) return true;
        }
        System.out.println ();
        return false;
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        xbloc = x; ybloc = y;
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[x][y] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    // Поле вывода карты изменено
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++)
            if (i==0)  System.out.print("  Y ");
                else System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i <= SIZE; i++) {
            if (i == 0) System.out.print("X ");
            System.out.print("--");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("|");
        }
        for (int i = 0; i <= SIZE; i++) {
            if (i == 0) System.out.print("  ");
            System.out.print("--");

        }
        System.out.println();
    }

}
