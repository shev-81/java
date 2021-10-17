package algoritm_lesson_4;

/**
 *   Домашнее Задание Шевеленко Андрея Александровича к 4 лекции.
 */

public class TestMain4 {

    public static void main(String[] args) {
        testLinkedList();
    }

    private static void testLinkedList() {
//        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
//        TwoSideLinkedListImpl<Integer> linkedList = new TwoSideLinkedListImpl<>();
/**
*  Реализация Дека на основе дву направленного списка DeqTwoSideList
*/
        DeqTwoSideList<Integer> linkedList = new  DeqTwoSideList<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
//        linkedList.insertFirst(6);
//        linkedList.insertFirst(7);
//        linkedList.insertFirst(8);

// Добавим элемент с др стороны
        linkedList.insertLast(21);
        linkedList.insertLast(22);
        linkedList.display();
// удалим последний элемент
        System.out.println("Удален последний элемент - " +linkedList.DeleteLast());

//        System.out.println("Find 2: " + linkedList.contains(2));
//        System.out.println("Find 1: " + linkedList.contains(1));
//        System.out.println("Find 4: " + linkedList.contains(4));
//        System.out.println("Find 4444: " + linkedList.contains(4444));

//        linkedList.removeFirst();
//        linkedList.remove(4);


        linkedList.display();
        System.out.println("Работа итератора");

        System.out.println("");

        /**
         * Вариант перебора элементов списка без interface LinkedList<E> extends Iterable<E>
         *
         * Iterator iter = ((SimpleLinkedListImpl<Integer>) linkedList).iterator();
         * for (Iterator it = iter; it.hasNext(); ) {
         *    Integer value = (Integer) it.next();
         *    System.out.println("value: " + value);
         * } */
        //ДОЛЖНО РАБОТАТЬ! Iterable - LinkedListIterator impl Iterator
        /**
         *  Работает !!!
         */
        for (Object value : linkedList) {
            System.out.println("value: " + value);
        }
    }
}


