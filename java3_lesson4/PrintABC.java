package java3_lesson4;

/**
 *  Домашняя работа Шевеленко Андрея Александровича ко 4-ой лекции Java Core 3.
 */

public class PrintABC {
    private final Object mon = new Object();
    volatile char aChar = 'A';
    public void printA(){
        synchronized (mon){
            try {
                for(int i=0;i<5;i++) {
                    while(aChar != 'A') mon.wait();
                    System.out.print(aChar+" ");
                    aChar = 'B';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void printB(){
        synchronized (mon){
            try {
                for(int i=0;i<5;i++) {
                    while(aChar != 'B')mon.wait();
                    System.out.print(aChar+" ");
                    aChar = 'C';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void printC(){
        synchronized (mon){
            try {
                for(int i=0;i<5;i++) {
                    while(aChar != 'C')mon.wait();
                    System.out.print(aChar+" ");
                    aChar = 'A';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        PrintABC obj = new PrintABC();
        new Thread(()->{
            obj.printA();
        }).start();
        new Thread(()->{
            obj.printB();
        }).start();
        new Thread(()->{
            obj.printC();
        }).start();

    }
}
