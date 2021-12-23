package java3_lesson1;

public class Apple extends Fruit{
    int weight;
    public Apple(int weight) {
        this.weight = weight;
    }
    @Override
    public int getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return "Apple "+weight+", ";
    }
}
