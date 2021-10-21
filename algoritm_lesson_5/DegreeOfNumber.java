package algoritm_lesson_5;

/**
 * Домашнее задание к 5 лекции Шевеленко Андрея Александровича
 * п.1 Написать программу по возведению числа в степень с помощью рекурсии
 */

public class DegreeOfNumber {
    public static void main(String[] args) {
        int n=5;
        int s=3;

        System.out.println("\n"+n+" в "+s+" степени = "+degreeNum (n,n,s));
        }

public static int degreeNum (int n, int m, int s) {
        if (s==1)
            return n;
        return degreeNum(n*m,m,s-1);
    }
}
