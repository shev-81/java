package java2_lesson5;

public class ThreadTest1 extends Thread{
    private static final Object block = new Object();
    private volatile int var=0;
    private volatile int var1=0;               // если переменная объявлена как статичная то при создании 2 разных объектов и их sync методов она все равно будет изменена.
    public int getVar() {                     // вызывая 1 и тот же синхронизированный метод у разных экземпляров для изменения статичной переменной нельзя добиться
        return var;                           // потоко безопасности переменной.
    }

    public synchronized void increment(){
       var++;
           System.out.println("+");
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

    }
    public synchronized void increment2(){
        var1++;
        System.out.println("-");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   public void run(){
        int count=0;
        for(int i=0; i<10;i++){
            count++;
        }
        System.out.println("метод ран добавил "+count);
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadTest1 obj1 = new ThreadTest1();

        Thread thr1 = new Thread(()->{
            for(int i=0; i<10;i++){
                obj1.increment();
            }
        });

        Thread thr2 = new Thread(()->{
            for(int i=0; i<10;i++){
                obj1.increment2();
            }
        });

        thr1.start();   // запуск потока через лямбда выражение не затрагивает метод run()
        thr2.start();   // этого класса, лиш тот код что передан в лямбда выражении
//        obj3.start();   // Запуск экземпляра класса в отдельном потоке

        thr1.join();
        thr2.join();
//        obj3.join();    //  !!!!!!!

        System.out.println("\n"+obj1.var);
        System.out.println("\n"+obj1.var1);


    }
}
