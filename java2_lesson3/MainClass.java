package java2_lesson3;
/**
 *  Домашняя работа к 3 ей лекции по Java 2 Шевеленко Андрея
 *  п.1
 */

import java.util.Collections;
import java.util.LinkedHashSet;

public class MainClass {
    //создаем массив городов
    public static String [] arr = {"Москва","Ленинград","Москва","Ленинград","Воронеж","Калининград","Воронеж","Калининград","Волгоград","Пицунда","Сочи"
                                    ,"Ленинград","Воронеж","Калининград","Воронеж","Калининград","Волгоград","Волгоград","Пицунда","Сочи"};
    // создаем массив счетчиков для каждого элемента
    public static int [] countArr;

    public static void main(String[] args) {
        //создаем структуру для хранения уникальных данных
        LinkedHashSet<String> set = new LinkedHashSet<>();
        // заполняем ее уникальными значениями
        Collections.addAll(set, arr);
        System.out.println("Начальный список: ");
        for (String u: arr){
            System.out.print(u+" ");
        }
        System.out.println();
        System.out.println("\nУникальный список: \n" + set);
        //Запускаем методо анализа количества повторов городов
        analize(set,  arr);
    }

    public static void analize (LinkedHashSet<String> setTowons, String [] arrTowns){
        // индекс города
        int indexTown = 0;
        //массив счетчиков повторений аналогичный по размеру колличеству уникальных элементов в сете городов
        countArr = new int [setTowons.size()];
        System.out.println("\nПовторяющиеся элементы: ");
        for (String uSet: setTowons){
            for (int i=0; i < arrTowns.length; i++){
                if (uSet.equals(arrTowns[i])){
                    countArr[indexTown]++;
                }
            }
            System.out.print(uSet+": "+countArr[indexTown]+", ");
            indexTown++;
        }
    }
}

