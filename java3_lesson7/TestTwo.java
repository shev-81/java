package java3_lesson7;
/**
 *  Домашняя работа к 7 лекции по Java 3 Шевеленко Андрея Александровича
 */
public class TestTwo {
    public static void main(String[] args) {
    }

    @BeforeSuite
    public static void zero() {
        System.out.println("класс TestTwo метод zero() @BeforeSuite");
    }

    @Test(priority = 1)
    public static void one() {
        System.out.println("класс TestTwo метод one() @Test priority = 1");
    }

    @Test
    public static void two() {
        System.out.println("класс TestTwo метод two() @Test priority = default 5 ");
    }

    @Test(priority = 6)
    public static void three() {
        System.out.println("класс TestTwo метод three() @Test priority = 6");
    }
    //метод без анотации
    public static void five() {
        System.out.println("класс TestTwo метод five()");
    }

    @AfterSuite
    public static void four() {
        System.out.println("класс TestTwo метод four() @AfterSuite");
    }
}
