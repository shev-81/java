package java2_lesson2;

/**
 *  Домашняя работа Шевеленко Андрея Александровича ко 2-ой лекции Java Core 2.
 */

public class TestClass {
     public static String [][] strArr1 = {
            {"1","2","3","4"},
            {"3","5","6","7"},
            {"8","9","10","11"},
            {"12","13","14","15"}
    };
    public static String [][] strArr2 = new String [3][3];

    // метод анализа строки
    public static boolean  analizeStrArray(String[][] array){
        int arrVar;
        int summ=0;
        //проверяем является ли массив заданного размера
        if(array.length == 4 && array[0].length == 4){
           for (int i=0; i<array.length; i++){
               for (int j=0; j<array.length; j++){
                   // проверяем корерктность преобразований
                   try{
                   arrVar = Integer.parseInt(array[i][j]);
                   summ = summ+arrVar;
                   }catch (NumberFormatException e){
                       //т.к. MyArrayDataException  и  MyArraySizeException наследуют RuntimeException
                       //нет необходимости в использовании trows в названии метода их содержащего.
                      throw new MyArrayDataException(i,j);
                   }
                   //преобразование прошло успешно выводим на экран
                   System.out.print(arrVar+" ");
               }
               System.out.println();
           }
            System.out.println("Сумма элементов: "+summ);
           return true;
        }else{
           throw new MyArraySizeException();
        }
    }



    public static void main(String[] args) {
        try{
           analizeStrArray(strArr1);
        }catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Конец программы");
        }

    }
}
