package algoritm_lesson_2;

import java.util.Random;

/**
 * Домашнее задание Шевеленко Андрея - Бинарный поиск
 */

public class MainClass {

    public  static int search(int [ ]arr, int num){

        int start=0;
        int end = arr.length-1;
        int base;
        int i=0;

        while (end >= start) {
            i++;
            base = (start + end) / 2;
            System.out.print("\nBase: "+base);
            if (arr[base] == num) {
                System.out.println("\nКол-во интерций: "+i);
                return base;
            } else if (arr[base] < num) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }

        return -1;
    }
    public static void Selectsort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i == min) {
                continue;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    public static void main(String[] args) {

        Random random = new Random();
        int [] array = new int[20];
        int numsearch = 30;
        System.out.println("Новый массив ");
        for(int i=0; i<array.length; i++){
            array[i] = random.nextInt(20)*10;
            System.out.print(array[i]+", ");
        }
        System.out.println("\n  Отсортируем массив");
        // отсортируем массив перед поиском
        Selectsort(array);
        for (int u: array){
            System.out.print(u+", ");
        }
        System.out.println("\n Значение "+numsearch+" состоит в массиве с индексом  "+search(array, numsearch));

    }
}
