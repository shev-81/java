package java2_lesson1;
/**
 * Игрок Робот
 */
public class Robot implements Participant{
    int maxrun;
    int maxjump;
    String name;

    public String getName() {
        return name;
    }

    public Robot(int maxrun, int maxjump, String name) {
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
    @Override
    public int getMaxrun() {
        return maxrun;
    }
    @Override
    public int getMaxjump() {
        return maxjump;
    }
}