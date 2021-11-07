package java2_lesson1;

/**
 *  Стена
 */

public class Wall implements Obstacle{

    int height;
    String name =" Стена";
    public Wall(int height) {
        this.height = height;
    }
    // проверяем может ли игрок перепрыгнуть препятствие
    @Override
    public boolean canDoit(Participant can) {
        return this.height <= can.getMaxjump();
    }
    @Override
    public String toString(){
        return name.concat(" ").concat(Integer.toString(height));
    }
}
