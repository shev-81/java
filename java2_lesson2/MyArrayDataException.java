package java2_lesson2;

public class MyArrayDataException extends RuntimeException{
    int i;
    int j;
    MyArrayDataException(int i, int j){
        this.i = i;
        this.j = j;
    }
    @Override
    public void printStackTrace(){
        System.out.println("\n Ошибка преобразования элемента по координатам: "+i+" | "+j);
    }
}
