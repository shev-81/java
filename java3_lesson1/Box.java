package java3_lesson1;
/**
 *  Домашнее задание Шевеленко Андрея Александровича к 1 лекции Java 3
 *  Задача:
 * Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
 * фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * Для хранения фруктов внутри коробки можно использовать ArrayList;
 * Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта
 * и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * Внутри класса Box сделать метод compare(), который позволяет сравнить текущую
 * коробку с той, которую подадут в compare() в качестве параметра. true – если их
 * массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
 * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
 * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
 * объекты, которые были в первой;
 * Не забываем про метод добавления фрукта в коробку.
 */
import java.util.ArrayList;
import java.util.Collection;

public class Box <T extends Fruit> {
    int weight;
    //Для хранения фруктов внутри коробки можно использовать ArrayList;
    ArrayList <T> fruitArr;
    Box(){
        weight=0;
        fruitArr = new ArrayList<>();
    }
    // Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
    // вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
    public int getWeight(){
        for(T fruit:fruitArr)
            weight += fruit.getWeight();
        return weight;
    }

    public ArrayList<T> getFruitArr() {
        return fruitArr;
    }
    //Не забываем про метод добавления фрукта в коробку.
    boolean put(T fruit){
        fruitArr.add(fruit);
        return true;
    }
    // Внутри класса Box сделать метод compare(), который позволяет
    // сравнить текущую коробку с той, которую подадут в compare()
    // в качестве параметра. true – если их массы равны, false в
    // противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
    boolean compare(Box <?> box){
        return this.weight==box.weight;
    }
    //Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
    // Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
    // Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
    // объекты, которые были в первой;
    boolean fillBox(Box <? extends Fruit> box){
        this.getFruitArr().addAll((Collection<? extends T>) box.getFruitArr());
        box.getFruitArr().clear();
        return true;
    }
    void show (){
        for(T fruit:fruitArr) System.out.print(fruit);
        System.out.println();
    }

    public static void main(String[] args) {
        Box <Orange> boxOrange = new Box();
        Box <Apple> boxApple = new Box();
        Box <Fruit> box = new Box();

        boxOrange.put(new Orange(1));
        boxOrange.put(new Orange(2));
        boxOrange.put(new Orange(2));
        boxApple.put(new Apple(1));
        boxApple.put(new Apple(1));
        boxApple.put(new Apple(3));

        System.out.println("В коробке boxOrange лежат:");
        boxOrange.show();
        System.out.println("Коробка boxOrange весит: "+boxOrange.getWeight()+"\n");
        System.out.println("В коробке boxApple лежат:");
        boxApple.show();
        System.out.println("Коробка boxApple весит: "+boxApple.getWeight()+"\n");
        System.out.println("Вес коробок boxApple и boxOrange одинаков? - "+boxApple.compare(boxOrange)+"\n");
        System.out.println("Переложим boxOrange в новую коробку - box: "+box.fillBox(boxOrange)+"\n");
        box.show();
        System.out.println("Orange в boxOrange?");
        boxOrange.show();
    }
}
