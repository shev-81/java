package lesson_7;

/**
 * Домашнее задание Шевеленко Андрея Александровича к 7 лекции
 */
public class HomeWork7 {
    public static void main(String[] args) {
        //свора голодных котов
        Cat [] catArray = new Cat [5];
        catArray[0] = new Cat("Barsik", 5);
        catArray[1] = new Cat("Мурзик", 10);
        catArray[2] = new Cat("Кот Артем", 90);
        catArray[3] = new Cat("Арбузик", 5);
        catArray[4] = new Cat("Тишка", 20);
        Plate plate = new Plate(100);
        // покормим свору голодных кисек
        for(Cat cats: catArray){
            cats.eat(plate);
            plate.info();
        }
    System.out.printf("Все котики поели и в тарелке осталось - :");
    plate.info();

    }
}
