package java2_lesson2;

public class MyArraySizeException extends Throwable{
    @Override
    public void printStackTrace(){
        System.out.println("Задан не верный размер массива");
    }
}
