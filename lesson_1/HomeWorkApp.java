package lesson_1;
/**
 * Практическая работа к 1 уроку Шевеленко Андрея Александровича
 */
public class HomeWorkApp {
  public static void main(String[]args) {
    printThreeWords();
    checkSumSign();
    printColor();
    compareNumbers();
  }
// *************************************
  public static void printThreeWords(){
      System.out.println("Orange");
      System.out.println("Banana");
      System.out.println("Apple");
    }
// *************************************
    public static void checkSumSign(){
      int a,b;
      a=10; b=30;
      if((a+b)>=0)  System.out.println("Сумма положительная");
        else        System.out.println("Сумма отрицательная");
    }
// *************************************
    public static void printColor(){
      int value;
      value =30;
      if(value<=0)              System.out.println("Красный");
      if(value>0 && value<=100) System.out.println("Желтый");
      if(value>100)             System.out.println("Зеленый");
    }
// *************************************
    public static void compareNumbers(){
      int a,b;
      a=10; b=20;
      if (a >= b)   System.out.println("a >= b");
        else        System.out.println("a < b");
    }
}
