package java3_lesson1;
/**
 *  Домашнее задание Шевеленко Андрея Александровича к 1 лекции Java 3
 *  Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа
 */
public class MyClass<T extends Number> {
    T [] arr;
    public MyClass(T [] arr) {
        this.arr = arr;
    }
    //Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    public void changeArray(){
        T tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }
    public void show(){
        for(T u: arr)
            System.out.print(u+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        MyClass<Integer> myClass = new MyClass<>(new Integer[]{111,222});
        myClass.show();
        myClass.changeArray();
        myClass.show();
    }
}
