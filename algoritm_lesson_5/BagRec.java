package algoritm_lesson_5;


import java.util.List;

/**
 * Домашнее задание по 5 лекции Шевеленко Андрея Александровича для сдачи преподавателю.
 *
 * п.2 Задача о Рюкзаке на консоли. P/S смотерть файл BagSwing,
 * там реализация в графическом интерфейсе.
 */

public class BagRec {
    public static void main(String[] args) {

// создадим несколько вещей с разным весом и стоимостью
        List <Element> listElements = new ListSet().getList();
        for (Element u: listElements){
            System.out.println(u.name+ "\n вес - " +u.weght+ "кг стоимость " +u.cost+" $");
        }
//возьмем рюкзак объемом на 10 кг и решим какие  вещи из списка туда положить
        Bag bag = new Bag(10,listElements);
        System.out.println("\nМаксимальный вес всех элементов - "+bag.calcMaxWeght(listElements)+" кг.");
        System.out.println("Максимальная стоимость всех элементов - "+bag.calcPrice(listElements));
// покажем что мы взяли
        System.out.println("\nНабор самых дорогих вещей\n");
        int maxV=0; // максимальный вес вещей в рюкзаке
        int maxC=0; // максимальная стоимость вещей
        for (Element u: bag.getBestElements()){
            maxV += u.weght;
            maxC += u.cost;
            System.out.println(u.name+ " вес - " +u.weght+ "кг стоимость " +u.cost+" $");
        }
        System.out.println("\nВес всех вещей в рюкзаке - "+ maxV);
        System.out.println("Стоимость вещей в рюкзаке - "+ maxC);
    }
}











