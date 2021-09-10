package lesson_7;

/**
 * Домашнее задание Шевеленко Андрея Александровича к 7 лекции
 */
public class HomeWork7 {
    public static void main(String[] args) {
/** п.4  Создать массив котов и тарелку с едой, попросить всех котов покушать
*        из этой тарелки и потом вывести информацию о сытости котов в консоль.
*/
        // дадим пустую тарелку
        Plate plate = new Plate();

        // наполним ее едой
        plate.setFood(100);

        //позовем свору голодных котиков
        Cat [] catArray = new Cat [5];
        catArray[0] = new Cat("Barsik", 5);
        catArray[1] = new Cat("Мурзик", 10);
        catArray[2] = new Cat("Кот Артем", 90);
        catArray[3] = new Cat("Арбузик", 5);
        catArray[4] = new Cat("Тишка", 20);

        // покормим голодных кисек
        for(Cat cats: catArray){
            cats.eat(plate);
            plate.info();
        }
    System.out.printf("Все котики поели и в тарелке осталось - :");
    plate.info();

    }
}
