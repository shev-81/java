package java3_lesson5;
/**
 *  Домашняя работа к 5 лекции по Java 3 Шевеленко Андрея Александровича
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
    public static final CountDownLatch cdl1 = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch cdl2 = new CountDownLatch(CARS_COUNT);
    public static final Semaphore semaphore = new Semaphore(CARS_COUNT/2);
    public static final Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException{
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40), new Finish());
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        cdl1.await();  // Ждем пока все будут готовы стартовать
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        cdl2.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}







