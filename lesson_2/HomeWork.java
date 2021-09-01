package lesson_2;
/**
 * Домашнее задание к второму уроку Шевеленко Андрея Алексадровича
 *
*/
import java.util.Scanner;

 public class HomeWork {
    public static void main(String[] args){
        int a=5, b= 22, c= -10, yearInt;
        String Str = "Строка для четвертого пункта задания";

    // пункт 1 домашнего задания Метод проверки суммы 2 чисел лежащих в диапазоне от 10 до 20.
        System.out.println("Пункт 1 домашнего задания Метод проверки суммы 2 чисел лежащих в диапазоне от 10 до 20.");
        if(checkSum(a,b))   System.out.println("Сумма чисел "+a+" + "+b+" в пределах диапазона от 10 до 20");
            else            System.out.println("Сумма чисел "+a+" + "+b+" за пределами диапазона от 10 до 20");
        System.out.println();

    // пункт 2 домашнего задания Метод проверки какое число - отрицательное или положительное.
        System.out.println("Пункт 2 домашнего задания Метод проверки какое число - отрицательное или положительное.");
        checkMinusOrPlus (c);
        System.out.println();

    // пункт 3 домашнего задания Метод проверки какое число - отрицательное или положительное с возвратом boolean значения
        System.out.println("Пункт 3 домашнего задания Метод проверки какое число - отрицательное или положительное с возвратом boolean значения.");
        if(checkMinusOrPlusBool (b))    System.out.println(+b+" - число отрицательоне");
            else                        System.out.println(+b+" - число положительное");
        System.out.println();

    // Пункт 4 домашнего задания Метод выводящийф на печать строку 'Str' - 'a' раз
        System.out.println("Пункт 4 домашнего задания Метод выводящий на печать строку 'Str' - "+a+" раз.");
        printStr (a, Str);
        System.out.println();

    // Пункт 5* домашнего задания Метод определяющий является ли год високосным
        System.out.println("Пункт 5* домашнего задания Метод определяющий является ли год високосным");
        System.out.println("Введите год, что бы определить является ли он високосным:");
        Scanner input = new Scanner(System.in);      // Создаем объект - "input" класса "Scanner"
        yearInt = input.nextInt();                   // Используем метод nextInt(); в объекте input и введем данные.
        input.close();
        if(chekVisokos(yearInt))    System.out.println(yearInt+" - это висакосный год.");
            else                    System.out.println(yearInt+" - этот год не висакосный.");
    }


     // Метод проверки суммы 2 чисел лежащих в диапазоне от 10 до 20
public static boolean checkSum (int a, int b){
    if((a+b) >= 10 && (a+b) <= 20) return true;
        else return false;
    }
// Метод проверки знака у числа
public static void checkMinusOrPlus (int a) {
    if (a >= 0) System.out.println(+a + " - это число положительное.");
        else    System.out.println(+a + " - это число отрицательное.");
    }
// Метод проверки знака у числа с возвратом значения boolean ( 0 считаем положительным числом)
public static boolean checkMinusOrPlusBool (int a) {
    if (a < 0) return true;
        else return false;
    }
// Метод принимающий строку и число "n" и печатающий эту строку "n" раз.
public static void printStr (int n, String Str){
    for(; n>0 ; n--) System.out.println(Str);
    }
// Метод определяющий является ли год високосным.
public static boolean chekVisokos(int year) {
    if(year%4 == 0) {
        if (year%400 == 0)  return true;
        if (year%100 == 0)  return false;
        return true;}
    else return false;
    }
 }
