package java2_lesson3;

/**
 *  Домашняя работа к 3 ей лекции по Java 2 Шевеленко Андрея
 *  п.2
 */

import java.util.*;

public class TelephoneDirectory {
    private LinkedHashMap telDirectory;

    public TelephoneDirectory() {
        telDirectory = new LinkedHashMap();
    }
    //Добавление Элемента
    public boolean add (String key, String value){
        telDirectory.put(key,value);
        return true;
    }
    //  получение списка элементов по фамилии
    public LinkedList get (String value){
        LinkedList<String> listValue = new LinkedList<String>();
        var listset = telDirectory.entrySet();
        for (Object u:  listset){
            var mapEntry = (Map.Entry) u;
            if(mapEntry.getValue().equals(value)){
                listValue.add((String) mapEntry.getKey());
                System.out.println(value+" tel: "+mapEntry.getKey());
            }
        }
        return listValue;
    }

    public static void main(String[] args) {

        TelephoneDirectory telDir = new TelephoneDirectory();

        telDir.add("1-111-111-1111","Иванов");
        telDir.add("2-222-222-2222","Петров");
        telDir.add("3-333-333-3333","Сидоров");
        telDir.add("4-444-444-4444","Иванов");
        telDir.add("5-555-555-5555","Петров");
        telDir.add("6-666-666-6666","Сидоров");
        telDir.add("7-777-777-7777","Иванов");
        telDir.add("8-888-888-8888","Петров");
        telDir.add("9-999-999-9999","Шевеленко");

        telDir.get("Иванов");
        telDir.get("Сидоров");
        telDir.get("Жуков");
        telDir.get("Петров");
        telDir.get("Шевеленко");
    }
}
