package algoritm_lesson_3;

/**
 * Домашняя работа к 3 лекции Шевеленко Андрея
 */

/**
 * п.1 Ищем бинарным поиском пропущенное число в массиве
 */
public class SearchSkip {

    public  static int search(int []arr){

        int start=0;
        int end = arr.length-1;
        int base;
        int i=0;
        if (arr.length==0) {
            return 1;
        }
        if (arr.length==arr[arr.length-1]
                && arr[0]==1
                && arr[arr.length-1]==arr.length) {     // если значение последнего элемента массива равно длине массива
            return 1;                                   // то массив не содержит потерянных элементов.
        }else {
            while (end >= start) {
                i++;
                System.out.println("\nИтерация : " + i);
                base = (start + end) / 2;
                System.out.println("base на индексe : " + base);
                if (base + 1 == arr[base]) {            // если маркер базы соответствует значению массива, то в 1 половине arr[] все ок.
                    System.out.println("Ошибка во второй половине");
                    if(arr[base+1]-arr[base]==1){        // перед тем как сдвинуть маркер проверим шаг элементов
                        start = base + 1;               // и мы передвигаем марке на вторую половину
                    } else{
                        return arr[base+1]-1;
                    }
                    System.out.println("start перенесен на индекс : " + start);
                    System.out.println("end на индексе : " + end);
                } else {
                    end = base;                     // а иначе в первой половине пропуск и переносим маркер конца на base
                    System.out.println("Ошибка в первой половине");
                    System.out.println("start на индексе : " + start);
                    System.out.println("end перенесен на индекс : " + end);
                }
                if (arr[start + 1] - arr[start] != 1) {
                    return arr[start + 1] - 1;
                }
                if (arr[end] - arr[end - 1] != 1) {
                    return arr[end - 1] + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] array1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,18,19,20};
        int [] array2 = {1,2,3,4,5,6,7,8,9,10};
        int [] array3 = {};
        System.out.println("В первом массив потеряно число - "+search(array1));
        System.out.println("Во втором массиве потеряно число - "+search(array2));
//        System.out.println("В третьем массиве потеряно число - "+search(array3));
    }
}
