package java2_lesson5;

public class HomeWork {
    private final Object mon = new Object();
    volatile char aChar = 'A';
    public void printA(){
        synchronized (mon){
            try {
                for(int i=0;i<10;i++) {
                   if(aChar != 'A') mon.wait();
                   System.out.print(aChar+" ");
                   aChar = 'B';
                   mon.notify();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void printB(){
        synchronized (mon){
            try {
                for(int i=0;i<10;i++) {
                    if(aChar != 'B')mon.wait();
                    System.out.print(aChar+" ");
                    aChar = 'A';
                    mon.notify();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        HomeWork obj = new HomeWork();
        new Thread(()->{
            obj.printA();
        }).start();
        new Thread(()->{
            obj.printB();
        }).start();

    }
}
