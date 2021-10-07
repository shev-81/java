package algoritms_lesson_1;
import java.util.Random;

public class MainClass {
    /**
     *  Создание массива обьектов ноутбуков
     */
    private static Long time;
    public static MyNbook [] getArray(){
        MyNbook [] massive = new MyNbook[10000];
        for(int i=0; i<massive.length; i++) {
            massive[i] = new MyNbook();
        }
    return massive;

    }
    public static void startTime() {
        time = System.currentTimeMillis();
    }

    public static void endTime() {
        time = System.currentTimeMillis() - time;
        System.out.println(time);

    }

    /**
     * Сортировка выбором
      */

    public static void Selectsort(MyNbook [] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].cost < arr[min].cost) {
                    min = j;
                }
//                if (arr[j].cost == arr[min].cost) {
//                    if (arr[j].memory < arr[min].memory){
//                        min = j;
//                    }
//                }

            }

            if (i == min) {
                continue;
            }

            int temp = arr[i].cost;
            arr[i].cost = arr[min].cost;
            arr[min].cost = temp;
        }
    }

    public static void main(String[] args) {
        MyNbook [] arr;
        arr =getArray();
        System.out.println("Это не отсортированный массив");
        for (MyNbook u: arr) {
            System.out.println("Производитель : "+u.nameBook+", Память : "+ u.memory+", Цена : "+u.cost);
        }
        startTime();
        Selectsort(arr);
        System.out.println("А это Отсортированный");
        for (MyNbook u: arr) {
            System.out.println("Производитель : "+u.nameBook+", Память : "+ u.memory+", Цена : "+u.cost);
        }
        System.out.print("Затраченное время на сортировку - "); endTime();
    }
}
/** Класс создания экземпляра ноутбука
 *  Lenuvo > Asos > MacNote > Eser > Xamiou
 */

class MyNbook{
    private static final Random random = new Random();
    int cost;
    int memory;
    int numBook;
    String nameBook;

    MyNbook(){
        cost = random.nextInt(40)*50;
        memory = random.nextInt(6)*4;
        numBook = random.nextInt(5);
        if (memory==0) memory=4;
        if (cost<500) cost=cost+500;
        switch (numBook) {
            case 0: nameBook="Xamiou";
                break;
            case 1: nameBook="Eser";
                break;
            case 2: nameBook="MacNote";
                break;
            case 3: nameBook="Asos";
                break;
            case 4: nameBook="Lenuvo";
                break;
            default: nameBook = "Xamiou";
        }
    }
}




