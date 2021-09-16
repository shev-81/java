package Lesson_6;

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