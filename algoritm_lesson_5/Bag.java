package algoritm_lesson_5;

import java.util.LinkedList;
import java.util.List;

// класс рюкзака
public class Bag {
    private List<Element> bestElements = null;
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
            }
        }
        else {
            if(calcMaxWeght(lst)<=bagVolume && calcPrice(lst)>betterPrice){
                bestElements=lst;
                betterPrice=calcPrice(lst);
            }
        }
    }

    // рекурсивный метод перебирающий сборные сеты вещей
    public void createSetElements (List<Element> lst){
        //если список не пустой
        if(lst.size() > 0) {
            checListSet(lst);
        }
//        for(int i=0; i<lst.size();i++){
//            List<Element> tmp = new LinkedList<>(lst);
//            tmp.remove(i);
//            createSetElements(tmp);
//            System.out.println(i+" - Набор элементов");
//            for (Element u: getBestElements()){
//                System.out.println(u.name+ "\n вес - " +u.weght+ "кг стоимость " +u.cost+" $");
//            }
//        }
        for (Element u: lst){
            List<Element> tmp = new LinkedList<>(lst);
            tmp.remove(u);
            createSetElements(tmp);
        }
    }
    public List<Element> getBestElements(){
        return bestElements;
    }
}