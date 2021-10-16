package algoritm_lesson_4;
/**
 *    Для корерктной работы цикла foreach необъодимо расширить интерфейс  LinkedList<E> extends Iterable<E>
 *    P.S. Ваше задача, решение которой лежало на поверхности заставило перечитать описание библиотек ))) спасибо!
 */
public interface LinkedList<E> extends Iterable<E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}