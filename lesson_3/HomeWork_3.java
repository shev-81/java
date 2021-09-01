package lesson_3;

/**
 *  Домашнее задание Шевеленко Андрея Александровича к 3 уроку.
 */
public class HomeWork_3 {

    public static void main(String[] args) {

// Пункт 1 домашнего задания
        System.out.println("Пункт 1 домашнего задания.");
        int [] mas = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i: mas) System.out.print(i+", ");
        System.out.println();
        for (int i=0; i<mas.length; i++){
            if (mas[i] == 1)    mas[i] = 0;
                else            mas[i] = 1;
            System.out.print(mas[i]+" ");
            }
        System.out.println("\n");

// Пункт 2 домашнего задания
        System.out.println("Пункт 2 домашнего задания.");
        int [] mas2 = new int[100];
        for (int i=0; i<mas2.length; i++) {
            mas2[i] = i+1;
            System.out.print(mas2[i] + " ");
            if(mas2[i]%10==0) System.out.println();
        }
        System.out.println("");

// Пункт 3 домашнего задания
        System.out.println("Пункт 3 домашнего задания.");
        int [] mas3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Исходный масив:");
        for(int i: mas3) System.out.print(i+" ");

        System.out.println("\nИзмененный масив с числами меньшие 6 умноженными на 2:");
        for(int i: mas3) {
            if(i<6) i=i*2;
            System.out.print(i+" ");
        }
        System.out.println("\n");

// Пункт 4 домашнего задания
        System.out.println("Пункт 4 домашнего задания.");
        int [][] mas4 = new int [5][5];
        int iB = 4;             // Обратный индекс для обратной диагонали
        for (int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if (i==j)   mas4[i][i] =1;
                    else    mas4[i][j]  =0;
                if (j == iB){
                    mas4[i][j] =1;
                    iB--;
                }
                System.out.print(mas4[i][j]+" ");
                if (j == mas4.length-1)  System.out.println();
            }
        }
        System.out.println();

// Пункт 5 домашнего задания
        System.out.println("Пункт 5 домашнего задания.");
        int len = 10 , initialValue = 8; int [] masCreated;
        masCreated=createMas(len, initialValue);
        for(int x : masCreated) System.out.print(x+" ");
        System.out.println("\n");

// Пункт 6* домашнего задания используем заданный созданный масив из п3.
        System.out.println("Пункт 6* домашнего задания используем заданный созданный масив из п3.");
        for(int i: mas3) System.out.print(i+" ");
        System.out.println("\nМаксимальное значение в масиве - "+valueMax(mas3));
        System.out.println("Минимальное значение в масиве - "+valueMin(mas3)+"\n");

// Пункт 7** домашнего задания
        System.out.println("Пункт 7** домашнего задания.");
        int [] mas7 = {3, 6, 3, 3, 5, 4};
        if(checkBalance(mas7)) System.out.println   ("В массиве есть место, в котором сумма левой и правой части массива равны. \n");
            else System.out.println                 ("Левая и правая части массива НЕ равны. \n");

// Пункт 8*** домашнего задания
        System.out.println("Пункт 8*** домашнего задания.");
        int [] mas8 = {1, 2, 3, 4, 5, 6}; int mov=2;
        System.out.println("Исходный массив.");
        for(int i: mas8) System.out.print(i+", ");
        System.out.println();
        System.out.println("Массив со сдвигом на "+mov);
        changeMassiv(mov, mas8);
    }




// Метод для п.5 создание и возврат масива с переданными методу параметрами
    public static int[] createMas(int len, int initialValue){
        int [] mas5 = new int[len];
        for(int i=0; i<mas5.length;i++) mas5[i] = initialValue;
        return mas5;
    }
// Методы для п.6 возврат максимального и минимального значений массива
    public static int valueMax (int[]mas){
        int maxVar=mas[0];
        for (int i:mas) {
            if(i>maxVar)  maxVar=i;
        }
        return maxVar;
    }
    public static int valueMin (int[]mas){
        int minVar=mas[0];
        for (int i:mas){
            if(i<minVar) minVar=i;
        }
        return minVar;
    }
// Метод для Пункта 7** домашнего задания
    public static boolean checkBalance(int[]mas){
        int sumFirst=mas[0], sumSecond=mas[mas.length-1];
        for(int i=0, j=mas.length-1;;){
           System.out.println("Сумма элементов левой части "+sumFirst+ " и правой "+sumSecond); // просмотр значений на разных шагах интераций цикла
           if(i==j) break;
           if(sumFirst==sumSecond) return true;
           if(sumFirst<sumSecond) {
               sumFirst = sumFirst + mas[i + 1];
               i++;
               continue;
           }
           if(sumFirst>sumSecond) {
               sumSecond = sumSecond + mas[j - 1];
               j--;
               continue;
           }
        }
        return false;
    }
 ///Метод для Пункта 8*** домашнего задания
    public static void changeMassiv(int move, int [] mas){
        int tVar;
        if (move<0)move=mas.length+move;
        for (int i=0; i<mas.length; i++){
            if (move >= mas.length) move = i;
            for (int j = move; i != j; j--) {
                tVar = mas[j - 1];
                mas[j - 1] = mas[j];
                mas[j] = tVar;
            }
            move++;
            System.out.print(+mas[i]+", ");
        }
  }
}
