package lesson_7;

/**
 * Класс корма из тарелки для котов
 */

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        food -= n;
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println(" В тарелке осталось "+food+" еды.");
    }
}