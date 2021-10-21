package algoritm_lesson_5;

import java.util.LinkedList;
import java.util.List;

public class  ListSet{
    List<Element> listElements;
    ListSet(){
        listElements = new LinkedList<>();
        listElements.add(new Element(50, 1, "Часы"));
        listElements.add(new Element(100, 3, "Телефон"));
        listElements.add(new Element(30, 5, "Гиря"));
        listElements.add(new Element(80, 4, "Планшет"));
        listElements.add(new Element(10, 3, "Газировка"));
    }
    public List <Element> getList(){
        return listElements;
    }
}