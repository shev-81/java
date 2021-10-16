package algoritm_lesson_4;

public interface TwoSideLinkedList<E>  extends LinkedList<E> {
    void insertLast(E value);
    E getLast();
}