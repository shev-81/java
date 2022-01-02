package java3_lesson5;

public class Finish extends Stage{

    @Override
    public void go(Car c) {
        MainClass.lock.lock();
        if(Car.winnerFlag){
            System.out.println(c.getName()+" пришел на финиш первым.");
            Car.winnerFlag=false;
        }else{
            System.out.println(c.getName()+" пришел на финиш.");
        }
        MainClass.lock.unlock();
    }
}