package lesson_7;

public class Cat {
    private String name;
    private int appetite;
    // изначально каждый кот голоден
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        //Если в предложенной тарелке еды недостаточно то кот ее не трогает
        if(appetite>p.getFood()) System.out.printf("Котик "+this.name+" не наестся едой в тарелке и остается голоден.");
            // если в тарелке еды достаточно что бы удовлетворить его апетит он ее съедает и становится сыт
        else {
            p.decreaseFood(appetite);
            satiety=true;
            System.out.printf("Котик "+this.name+" съел из тарелки "+this.appetite+" еды и стал сыт.");
        }
    }
}