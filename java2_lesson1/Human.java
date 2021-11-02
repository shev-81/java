package java2_lesson1;
/**
 * Игрок Человек
 */
public class Human implements Participant{
    String name;
    int maxrun;
    int maxjump;

    public String getName() {
        return name;
    }
    @Override
    public int getMaxrun() {
        return maxrun;
    }
    @Override
    public int getMaxjump() {
        return maxjump;
    }

    public Human(int maxrun, int maxjump, String name) {
        this.maxrun = maxrun;
        this.maxjump = maxjump;
        this.name = name;
    }

    @Override
    public int runs() {
        return maxrun;
    }

    @Override
    public int jumps() {
        return maxjump;
    }
}
