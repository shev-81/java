package java3_lesson7;
/**
 *  Домашняя работа к 7 лекции по Java 3 Шевеленко Андрея Александровича
 *
 *
 * В качестве тестов выступают классы с наборами методов, снабженных аннотациями @Test.
 * Класс, запускающий тесты, должен иметь статический метод start(Class testClass),
 * которому в качестве аргумента передается объект типа Class. Из «класса-теста» вначале
 * должен быть запущен метод с аннотацией @BeforeSuite, если он присутствует. Далее
 * запускаются методы с аннотациями @Test, а по завершении всех тестов – метод с
 * аннотацией @AfterSuite.
 * К каждому тесту необходимо добавить приоритеты (int-числа от 1 до 10), в соответствии
 * с которыми будет выбираться порядок их выполнения. Если приоритет одинаковый, то порядок
 * не имеет значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать
 * в единственном экземпляре. Если это не так – необходимо бросить RuntimeException при
 * запуске «тестирования».
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class MainClass {
    public static void main(String[] args) throws Exception {

        Class cl1 = TestOne.class;
        Class cl2 = TestTwo.class;

        start(cl1);

        System.out.println();

        start(cl2);
    }



    public static void start(Class cl) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = cl.getDeclaredMethods();
        Method metodBefore = null;
        Method metodAfter = null;
        Comparator comparator = new ComporatorMetods();
        ArrayList<Method> list = new ArrayList<>();
        for (Method m : methods) {
            // проверка на уникальность метода с анотацией @BeforeSuite
            if (m.isAnnotationPresent(BeforeSuite.class))
                if(metodBefore == null)
                    metodBefore = m;
                else throw new RuntimeException("Метод с анотацией BeforeSuite уже определен.");
            // проверка на уникальность метода с анотацией @AfterSuite
            if (m.isAnnotationPresent(AfterSuite.class))
                if(metodAfter == null)
                    metodAfter = m;
                else throw new RuntimeException("Метод с анотацией AfterSuite уже определен.");
            // заполняем методами список запуска
            if (m.isAnnotationPresent(Test.class)) {
                list.add(m);
            }
        }
        if (metodBefore == null && metodAfter == null) {
            throw new RuntimeException("Не задан метод предшествующий или завершающий серию тестов.");
        }
        // сортируем методы по их приоритету priority() default 5
        list.sort(comparator);
        // добавляем к списку методов методы начала и окончания тестов если они есть
        if (metodBefore != null) {
            list.add(0, metodBefore);
        }
        if (metodAfter != null) {
            list.add(list.size(), metodAfter);
        }
        // запускаем методы тестов
        for (Method m : list) {
            m.invoke(null);
        }

    }
}
