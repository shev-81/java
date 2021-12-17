package java3_lesson7;
/**
 *  Домашняя работа к 7 лекции по Java 3 Шевеленко Андрея Александровича
 */
public class TestOne {
    public static void main(String[] args) {
    }

    @BeforeSuite
    public static void zero() {
        System.out.println("класс TestOne метод zero() @BeforeSuite");
    }

    @Test
    public static void one() {
        System.out.println("класс TestOne метод one() @Test priority = default 5 ");
    }

    @Test(priority = 4)
    public static void two() {
        System.out.println("класс TestOne метод two() Test priority = 4");
    }

    @Test(priority = 2)
    public static void three() {
        System.out.println("класс TestOne метод three() Test priority = 2");
    }

    //метод без анотации

    public static void five() {
        System.out.println("класс TestOne метод five()");
    }

    @AfterSuite
    public static void four() {
        System.out.println("класс TestOne метод four() @AfterSuite");
    }
}
