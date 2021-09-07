package Lesson_6;

/**
 * Домашнее задание Шевеленко Андрея Александровича к 6 Уроку
 */
// п.1  Создать классы Собака и Кот с наследованием от класса Животное.

class Animals{
    String name;
    String color;

    //конструктор по умолчанию
    Animals() {
        name="None";
        color="None";
    }
    // Конструктор со свойствами
    Animals(String name, String color) {
        this.name=name;
        this.color=color;
    }
    //Методы супер класса
    void printRun(){System.out.println(color+" животное "+name+" может пробежать.");}
    void printToSail(){System.out.println(color+" животное "+name+" может проплыть.\n");}
}

    /**
     * Класс Cat расширяет класс Animals
     */

class Cat extends Animals{
    int canRun;
    int canToSail;
    int maxDistance=200;
    //конструктор по умолчанию класса Кот
    Cat () {
        super();
        this.canRun=0;
        this.canToSail=0;
    }
    // Конструктор со свойствами класса Кот
    Cat (String name, String color,int canRun, int canToSail) {
        super (name,color);
        //прежде убедимся, что кот не супермен :)
        if(canRun>0 && canRun<=maxDistance)
            {this.canRun=canRun;}
        else
            {this.canRun=maxDistance;}
        //коты не умеют плавать! поэтому даже если получим в конструкторе параметр присвоим ему 0
        this.canToSail=0;
    }
    // Переопределенные методы для класса кот
    @Override
    void printRun(){System.out.println(color+" кот "+name+" может пробежать "+canRun+" м.");}
    @Override
    void printToSail(){System.out.println(color+" кот "+name+" не умеет плавать.\n");}
}

    /**
     * Класс Dog расширяет класс Animals
    */

class Dog extends Animals{
    int canRun;
    int canToSail;
    int maxDistanceRun=500;
    int maxDistanceToSail=10;
    //конструктор по умолчанию класса Кот
    Dog () {
        super();
        this.canRun=0;
        this.canToSail=0;
    }
    // Конструктор со свойствами класса Кот
    Dog (String name, String color,int canRun, int canToSail) {
        super (name,color);
        this.canRun=canRun;
        //а собаки умеют плавать!
        //прежде убедимся, что пес не супермен :)
        if(canRun>0 && canRun<=maxDistanceRun)
            {this.canRun=canRun;}
        else
            {this.canRun=maxDistanceRun;}
        //и так же по плаванию
        if(canToSail>0 && canRun<=maxDistanceToSail)
            {this.canToSail=canToSail;}
        else
            {this.canToSail=maxDistanceToSail;}
    }
    // Переопределенные методы для класса Кот
    @Override
    void printRun(){System.out.println(color+" пёс "+name+" может пробежать "+canRun+" м.");}
    @Override
    void printToSail(){System.out.println(color+" пёс "+name+" может проплыть "+canToSail+" м.\n");}

}




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
        }
    }
    System.out.println("Создано Котов - "+countCats+" шт.\nСоздано Собак - "+countDogs+" шт.\nСозданно неопознанных животных - "+unknowObg+" шт." );
    }
}
