package java3_lesson5;

import java.util.concurrent.Semaphore;

public class SemaphoreClass {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for(int i =0; i<10; i++){
            final int w = i;

            new Thread(()->{
            try {
                System.out.println("поток "+ w+ " ожидает перед симафором");
                semaphore.acquire();                                        // поток захвативает Семафор
                System.out.println("поток "+ w+ " работает");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();                                        // поток освобождает Семафор
                System.out.println("поток "+ w+ " вышел из семафора");
            }
        }).start();
        }
    }
}
