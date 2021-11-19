package java2_lesson5;
/**
 * Домашняя работа Шевеленко Андрея к 5 лекции java 2
 */
public class HomeWorkDz {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    // однопоточный метод обработки
    public static void firstMetod() {
        float[] arr = new float[SIZE];
        for (int i=0;i<SIZE;i++){arr[i] = 1.0f;}
        long startTime = System.currentTimeMillis();
        for (int i=0;i<SIZE;i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: "+(System.currentTimeMillis()-startTime)+" ms.");
    }

    // Двупоточный метод обработки
    public static void secondMetod() throws InterruptedException {

        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        // Создаем два массива для левой и правой части исходного
        float[] arrLeft = new float[HALF];
        float[] arrRight = new float[HALF];
        // Копируем в них значения из большого массива
        System.arraycopy(arr, 0, arrLeft, 0, HALF);
        System.arraycopy(arr, HALF, arrRight, 0, HALF);
        // Запускает два потока и параллельно просчитываем каждый малый массив
        Thread thr1 = new Thread(()->{
            for (int i = 0; i < arrLeft.length; i++) {
                arrLeft[i] = (float) (arrLeft[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thr2 = new Thread(()->{
            for (int i = 0; i < arrRight.length; i++) {
                arrRight[i] = (float) (arrRight[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        // Запускаем потоки
        thr1.start();
        thr2.start();
        // Ждем пока оба потока внесут изменения
        thr1.join();
        thr2.join();
        // Склеиваем малые массивы обратно в один большой
        System.arraycopy(arrLeft,0,arr,0,arrLeft.length);
        System.arraycopy(arrRight,0,arr,arrRight.length,arrRight.length);
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void main(String[] args) throws InterruptedException {
        firstMetod();
        secondMetod();
    }
}
