package java3_lesson7;
/**
 *  Домашняя работа к 7 лекции по Java 3 Шевеленко Андрея Александровича
 */
import java.lang.reflect.Method;
import java.util.Comparator;

public class ComporatorMetods implements Comparator<Method> {
    @Override
    public int compare(Method m1, Method m2) {
        return m1.getAnnotation(Test.class).priority() - m2.getAnnotation(Test.class).priority();
    }
}

