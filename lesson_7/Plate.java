package lesson_7;

/**
 * Класс тарелки для котов
 */

public class Plate {
    private int food;

    public Plate() {
        this.food = 0;
    }
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        food -= n;
    }

/**
*   п.5 Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
*/
    public void setFood(int food) {
        if(food>0)this.food = food;
            else System.out.printf("Тарелка не должна быть пустой");
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println(" В тарелке осталось "+food+" еды.");
    }
}