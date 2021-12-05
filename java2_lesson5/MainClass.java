package java2_lesson5;

public class MainClass {
    static Thread thr1;
    static Thread thr2;
    public static void main(String[] args) throws InterruptedException {
        thr1 = new Thread(() ->{
            for (int i=0;i<20;i++){
                System.out.print(". ");
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("\n"+thr1.getName()+" закончил свою работу ");

        });
        thr2 = new Thread(() ->{
            for (int i=0;i<10;i++){
                System.out.print(". ");
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            try {
                System.out.println("\n"+thr2.getName()+" Ожидает завершения "+thr1.getName());
                thr1.join();
                System.out.println(thr2.getName()+" Вышел из ожидания "+thr1.getName());
                System.out.println(thr2.getName()+" засыпает на 10 секунд");
                for(int i=0; i<10;i++){
                    Thread.sleep(1000);
                    System.out.print(". ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thr1.start();
        thr2.start();

        if(thr2.isAlive()) {
            System.out.println(Thread.currentThread().getName()+" в режиме ожидания завершения - "+thr2.getName());
            thr2.join();
            System.out.println(Thread.currentThread().getName()+" дождался завершения - "+thr2.getName());
        }
        System.out.println("\nпрограмма завершается!");


    }
}
