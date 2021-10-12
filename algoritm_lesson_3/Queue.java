package algoritm_lesson_3;

/**
 *
 *   Домашняя работа к 3 лекции Шевеленко Андрея
 *
 *   От Queue<E> интерфейса реализованно 2 класса - QueueMassive<E> и
 *   DeQueue<E> расширяющий класс QueueMassive<E>.
 */

public interface Queue<E> {

    boolean insert(E value);

    E remove();

    E peekFront();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();

}
