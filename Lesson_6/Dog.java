package Lesson_6;

/**
 * Класс Dog расширяет класс Animals
 */

class Dog extends Animals{
    int canRun;
    int canToSail;
    int maxDistanceRun=500;
    int maxDistanceToSail=10;
    //конструктор по умолчанию класса Собака
    Dog () {
        super();
        this.canRun=0;
        this.canToSail=0;
    }
    // Конструктор со свойствами класса Собака
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
        if(canToSail>0 && canToSail<=maxDistanceToSail)
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