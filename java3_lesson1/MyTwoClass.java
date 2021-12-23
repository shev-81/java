package java3_lesson1;
/**
 *  Домашнее задание Шевеленко Андрея Александровича к 1 лекции Java 3
 *  Написать метод, который преобразует массив в ArrayList;
 */
import java.util.ArrayList;

public class MyTwoClass <T> {
    ArrayList arrayList;
    T [] myArray;
    MyTwoClass(T [] myArray){
        arrayList = new ArrayList(myArray.length);
        this.myArray = myArray;
    }
    //Написать метод, который преобразует массив в ArrayList;
    ArrayList toArrayList(){
        for (T u: myArray)
            arrayList.add(u);
        return arrayList;
    }
    public void showMyArray() {
        for(T u:myArray){
            System.out.print(u+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MyTwoClass myTwoClass = new MyTwoClass(new Integer[] {111,222,333,444,555,} );
        // вывод массива
        myTwoClass.showMyArray();
        // вывод коллекции
        System.out.println(myTwoClass.toArrayList());
    }
}
