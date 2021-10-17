package algoritm_lesson_5;

import java.util.LinkedList;
import java.util.List;

/**
 * Домашнее задание Шевеленко Андрея задача о рюкзаке
 */

public class BagRec {
    public static void main(String[] args) {

        // создадим несколько вещей с разным весом и стоимостью
        List <Element> listElements = new LinkedList<>();
        listElements.add(new Element(50, 1, "Часы"));
        listElements.add(new Element(100, 3, "Телефон"));
        listElements.add(new Element(30, 5, "Гиря"));
        listElements.add(new Element(80, 4, "Планшет"));
//        listElements.add(new Element(10, 3, "Газировка"));

        for (Element u: listElements){
            System.out.println(u.name+ "\n вес - " +u.weght+ "кг стоимость " +u.cost+" $");
        }

        //создадим рюкзак с объемом в 10 кг и попробуем положить туда вещи
        Bag bag = new Bag(10,listElements);
        System.out.println("\nМаксимальный вес всех элементов - "+bag.calcMaxWeght(listElements)+" кг.");
        System.out.println("Максимальная стоимость всех элементов - "+bag.calcPrice(listElements));
//        bag.createSetElements(listElements);

//        System.out.println("\nНабор самых дорогих вещей");
//        for (Element u: bag.getBestElements()){
//            System.out.println(u.name+ "\n вес - " +u.weght+ "кг стоимость " +u.cost+" $");
//        }
    }
}

// класс элементов для рюкзака
class Element {
     int cost;
     int weght;
     String name;

    Element(int cost,int weght,String name){
        this.cost = cost;
        this.weght = weght;
        this.name = name;
    }
}
// класс рюкзака
class Bag {
    private List <Element> bestElements = null;
    private int bagVolume;
    private int betterPrice;
    Bag (int bagVolume, List<Element> lst){
        this.bagVolume=bagVolume;
        createSetElements(lst);
    }

    // Метод метод вычисления максимальной суммы веса элементов переданных для рюкзака
    int calcMaxWeght (List<Element> lst){
        int sumWeght=0;
        for(Element u: lst)
        {
            sumWeght+=u.weght;
        }
        return sumWeght;
    }

    // метод вычисления стоимости всего набора элементов
    int calcPrice(List<Element> lst){
        int sumPrice=0;
        for(Element u: lst)
        {
            sumPrice+=u.cost;
        }
        return sumPrice;
    }
    // метод сравнивающий лист переданный, с тем, что сохранен в текущем объекте.
    private void checListSet (List<Element> lst){
        if(bestElements == null){
            if(calcMaxWeght(lst)<=bagVolume){
                bestElements=lst;
                betterPrice=calcPrice(lst);
            }else {
                if(calcMaxWeght(lst)<=bagVolume && calcPrice(lst)>betterPrice){
                    bestElements=lst;
                    betterPrice=calcPrice(lst);
                }
            }
        }
    }
    // рекурсивный метод перебирающий сеты вещей
    public void createSetElements (List<Element> lst){
        //если список не пустой
        if(lst.size() > 0) {
            checListSet(lst);
        }
        for(int i=0; i<lst.size();i++){
            List<Element> tmp = new LinkedList<>(lst);
            tmp.remove(i);
            createSetElements(tmp);
            System.out.println(i+" - Набор элементов");
            for (Element u: getBestElements()){
                System.out.println(u.name+ "\n вес - " +u.weght+ "кг стоимость " +u.cost+" $");
            }
        }
//        for (Element u: lst){
//            List<Element> tmp = new LinkedList<>(lst);
//            tmp.remove(u);
//            createSetElements(tmp);
//        }
    }
    public List<Element> getBestElements(){
        return bestElements;
    }
}









