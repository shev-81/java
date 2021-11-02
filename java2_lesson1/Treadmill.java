package java2_lesson1;

/**
 * Беговая дорожка
 */

public class Treadmill implements Obstacle{

    int weight;

    public Treadmill(int weight) {
        this.weight = weight;
    }
    // проверяем может ли пробежать игрок по дорожке
    @Override
    public boolean canDoit(Participant can) {
        return this.weight <= can.runs();

    }
}
