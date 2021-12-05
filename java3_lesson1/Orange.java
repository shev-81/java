package java3_lesson1;

public class Orange extends Fruit{
    int weight;
    public Orange(int weight) {
        this.weight = weight;
    }
    @Override
    public int getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return "Orange "+weight+", ";
    }
}
