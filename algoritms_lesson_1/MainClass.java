package algoritms_lesson_1;

/**
 *  Домашнее задание Шевеленко Андрея ко 2-ой лекции .
 */
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
                if(arr[j].cost == arr[min].cost && arr[j].memory < arr[min].memory){
                    min = j;
                }
                if(arr[j].cost == arr[min].cost && arr[j].memory == arr[min].memory &&  arr[j].nameBook.charAt(0) < arr[min].nameBook.charAt(0)){
                    min = j;
                }
            }
            if (i == min) {
                continue;
            }
            MyNbook temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        MyNbook [] arr;
        arr = getArray();
        System.out.println("Это не отсортированный массив");
        for (MyNbook u: arr) {
            System.out.println("Производитель : "+u.nameBook+", Память : "+ u.memory+", Цена : "+u.cost);
        }
        startTime();
        Selectsort(arr);
        endTime();
        System.out.println("А это Отсортированный");
        for (MyNbook u: arr) {
            System.out.println("Производитель : "+u.nameBook+", Память : "+ u.memory+", Цена : "+u.cost);
        }
        System.out.print("Затраченное время на сортировку - ");
        endTime();
    }
}






