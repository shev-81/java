package java2_lesson5;

public class ThreadTest2 {
    private volatile int var1=0;
    private int var2=0;
    Object bloc1 = new Object();
    Object bloc2 = new Object();


    public void incrementVar1() {
        for(int i=0; i<1000000;i++){
            synchronized (bloc1){ var1 ++;} // синхронизация отдельной переменной без блокировки всего объекта
        }
    }

    public void incrementVar2() {
        for (int i = 0; i < 1000000; i++) {
            synchronized (bloc1){ var1 ++;}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest2 obj1 = new ThreadTest2();

        Thread thr1 = new Thread(()->{
            obj1.incrementVar1();
        });

        Thread thr2 = new Thread(()->{
            obj1.incrementVar2();
        });

        thr1.start();
        thr2.start();
        thr1.join();
        thr2.join();

        System.out.println(obj1.var1);
//        System.out.println(obj1.var2);

    }
}
