package lesson_7;

/**
 * Домашнее задание Шевеленко Андрея Александровича к 7 лекции
 */
public class HomeWork7 {
    public static void main(String[] args) {
        //свора голодных котов
        Cat [] catArray = new Cat [5];
        catArray[0] = new Cat("Barsik", 5);
        catArray[1] = new Cat("Мурзик", 10);
        catArray[2] = new Cat("Кот Артем", 90);
        catArray[3] = new Cat("Арбузик", 5);
        catArray[4] = new Cat("Тишка", 20);
        Plate plate = new Plate(100);
        // покормим свору голодных кисек
        for(Cat cats: catArray){
            cats.eat(plate);
            plate.info();
        }
    System.out.printf("Все котики поели и в тарелке осталось - :");
    plate.info();

    }
}

class Plate {
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

class Cat {
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

