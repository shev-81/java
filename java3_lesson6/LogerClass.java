package java3_lesson6;
/**
 *  Домашняя работа Шевеленко Андрея к 6 лекции java 3
 */
public class LogerClass {

    public static void main(String[] args) {
        int[] arr1;
        try {
            arr1 = newArr(new int[]{1, 2, 3, 2, 5, 4, 7, 6, 2, 3, 2, 10});
            for (int i = 0; i < arr1.length; i++) {
                System.out.print(" " + arr1[i]);
            }
        } catch (RuntimeException e) {
            System.out.println("Массив не содержит цифру 4.");
        }
        System.out.println();
        System.out.println("\n" + testArray(new int[]{4, 1, 4, 4}));

    }

    // Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    // Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
    // идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
    // иначе в методе необходимо выбросить RuntimeException.
    // Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    // Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    public static int[] newArr(int[] arr) {
        int sizeNewArr = 0;
        int index = 0;
        boolean check = false;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (check) continue;
            if (arr[i] == 4) {
                index = i + 1;
                sizeNewArr = arr.length - index;
                check = true;
            }
            if (!check && i == 0) throw new RuntimeException();
        }
        int[] newArr = new int[sizeNewArr];
        for (int i = 0; i < sizeNewArr; i++) {
            newArr[i] = arr[i + index];
        }
        return newArr;
    }

//    Написать метод, который проверяет состав массива из чисел 1 и 4.
//    Если в нем нет хоть одной четверки или единицы, то метод вернет false;
//    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//            [ 1 1 1 4 4 1 4 4 ] -> true
//            [ 1 1 1 1 1 1 ] -> false
//            [ 4 4 4 4 ] -> false
//            [ 1 4 4 1 1 4 3 ] -> false
    public static boolean testArray(int[] arr) {
        boolean haveOne = false;
        boolean haveFour = false;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 1:
                    haveOne = true;
                    continue;
                case 4:
                    haveFour = true;
                    continue;
                default:
                    return false;
            }
        }
        return haveOne & haveFour;
    }
}
