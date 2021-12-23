package java3_lesson6.test;
/**
 *  Домашняя работа Шевеленко Андрея к 6 лекции java 3
 */

import java3_lesson6.LogerClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LogerClassTest {
    LogerClass logerClass;

    @BeforeEach
    public void logerInit() {
        logerClass = new LogerClass();
    }

    @Test
    public void newArrTest() {

        Assertions.assertArrayEquals(new int[]{7, 6, 2, 3, 2, 10}, logerClass.newArr(new int[]{1, 2, 3, 2, 5, 4, 7, 6, 2, 3, 2, 10}));
    }

    @Test
    public void newArrTest1() {
        Assertions.assertArrayEquals(new int[]{2, 3, 2, 10}, logerClass.newArr(new int[]{1, 2, 3, 2, 5, 3, 7, 4, 2, 3, 2, 10}));
    }

    @Test
    public void newArrTest3() {
        Assertions.assertArrayEquals(new int[]{2, 10}, logerClass.newArr(new int[]{1, 2, 3, 2, 5, 3, 7, 4, 2, 4, 2, 10}));
    }

    @Test
    @Disabled
    public void newArrTest4() {     // этот тест не должен пройти
        Assertions.assertArrayEquals(new int[]{2, 2, 10}, logerClass.newArr(new int[]{1, 2, 3, 2, 5, 3, 7, 4, 2, 4, 2, 10}));
    }

    // параметизированный тест на основе стрима данных подготовленного методом dataForArray
    @ParameterizedTest
    @MethodSource("dataForArray")
    public void newArrTest5(int[] arr, int[] rez) {
        Assertions.assertArrayEquals(rez, logerClass.newArr(arr));
    }
    public static Stream<Arguments> dataForArray() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 3, 2, 5, 3, 7, 4, 2, 3, 2, 10}, new int[]{2, 3, 2, 10}));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 2, 5, 4, 7, 2, 2, 1, 2, 10}, new int[]{7, 2, 2, 1, 2, 10}));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 2, 5, 4, 7, 2, 2, 1, 1, 10}, new int[]{7, 2, 2, 1, 1, 10}));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 2, 5, 3, 7, 4, 4, 1, 2, 10}, new int[]{1, 2, 10}));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 2, 5, 3, 4, 2, 2, 1, 2, 10}, new int[]{2, 2, 1, 2, 10}));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 2, 5, 3, 7, 4, 2, 4, 2, 10}, new int[]{2, 10}));
        return out.stream();
    }

    // тест на вылет по RuntimeException из за отсутствия в массиве числа - 4.
    @Test
    public void newArrTest6() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            logerClass.newArr(new int[]{1, 2, 3, 2, 5, 3, 7, 2, 2, 5, 2, 10});
        });
    }

    //тетс метода testArray(int[] arr) - содержащего 1 и 4 ки
    @ParameterizedTest
    @MethodSource("dataArray")
    public void testArrayTest(int[] arr) {
        Assertions.assertEquals(true, logerClass.testArray(arr));
    }
    public static Stream<Arguments> dataArray() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 4, 4, 1, 4, 1, 4, 1, 1, 4, 1}));
        out.add(Arguments.arguments(new int[]{1, 1, 4, 4, 1, 4, 1, 4, 1, 1, 4, 1}));
        out.add(Arguments.arguments(new int[]{1, 1, 4, 4, 1, 4, 1, 4, 1, 1, 4, 1}));
        out.add(Arguments.arguments(new int[]{1, 1, 4, 4, 1, 4, 1, 4, 1, 1, 4, 1}));
        out.add(Arguments.arguments(new int[]{1, 1, 4, 4, 1, 4, 1, 4, 1, 1, 4, 1}));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1})); // провальный  все 1
        out.add(Arguments.arguments(new int[]{1, 1, 4, 4, 1, 4, 1, 1, 1, 1, 4, 1})); // провальный есть число 3
        return out.stream();
    }
}
