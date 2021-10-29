package algoritm_lesson_8;
/**
 *      Домашнее задание к 8 лекции Шевеленко Андрея Александровича
 */
public class Main {

    public static void main(String[] args) {

//        var hashTable = new DoubleHashTable<>(5); //5*2
        var hashTable = new HashTableLinkimp<>(5); //5*2


        hashTable.put(new Product(1, "Orange"), 150);  //1
        hashTable.put(new Product(77, "Banana"), 100); //7
        hashTable.put(new Product(67, "Carrot"), 228); //8
        hashTable.put(new Product(60, "Lemon"), 250);   //0
        hashTable.put(new Product(51, "Milk"), 120);    //2
        hashTable.put(new Product(21, "Potato"), 67);   //3
        hashTable.put(new Product(27, "Дыня"), 128); //8
        hashTable.put(new Product(30, "Арбуз"), 150);   //0
        hashTable.put(new Product(33, "Сгущенка"), 520);    //2
        hashTable.put(new Product(22, "Сыр"), 6);   //3


        hashTable.display();
//
//        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
//        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
//        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));
//
        hashTable.remove(new Product(21, "Potato"));
        hashTable.remove(new Product(33, "Сгущенка"));
//        hashTable.remove(new Product(77, "Banana"));
//
//        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
//        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
//        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));
//
//        if(hashTable.put(new Product(47, "Pineapple"), 228)) System.out.println("Элемент Pineapple добален");   //3;
        System.out.println("Size is " + hashTable.size());
//
        hashTable.display();
    }
}
