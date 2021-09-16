package Lesson_6;

/**
 * Домашнее задание Шевеленко Андрея Александровича к 6 Уроку продвинутое ООП
 */

public class HomeWork6 {
    public static void main(String[] args) {
    // Счетчики созданных объектов
    int countDogs=0;
    int countCats=0;
    int unknowObg=0;
    // создадим массив животных
    Animals [] animalsArr = new Animals[7];
    animalsArr[0] = new Cat("Барсик","Серый",100,20 );
    animalsArr[1] = new Cat();
    animalsArr[2] = new Cat("Мурзик","Черный",350,30 );
    animalsArr[3] = new Dog("Наган","Белый",200,100 );
    animalsArr[4] = new Dog();
    animalsArr[5] = new Dog("Тузик","Коричневый",1000,70 );
    animalsArr[6] = new Animals();
    // пройдемся по массиву и проверим каждый объект на принадлежность к классам, а заодно и напечатаем его содерживмое
    for(Animals u: animalsArr){
        if(u instanceof Cat) {
            countCats++;
            u.printRun();
            u.printToSail();
        }
        else if(u instanceof Dog){
            countDogs++;
            u.printRun();
            u.printToSail();
        }
        else {
            u.printRun();
            u.printToSail();
            unknowObg++;
        }
    }
    System.out.println("Создано Котов - "+countCats+" шт.\nСоздано Собак - "+countDogs+" шт.\nСозданно неопознанных животных - "+unknowObg+" шт." );
    }
}
