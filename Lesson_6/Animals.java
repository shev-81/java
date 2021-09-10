package Lesson_6;

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