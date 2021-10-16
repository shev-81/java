package algoritm_lesson_4;

import algoritm_lesson_3.Queue;

public class LinkedQueue<E>  extends TwoSideLinkedListImpl implements Queue<E>{
//    private final TwoSideLinkedList<E> data;
    private final LinkedQueue<E> data;

    public LinkedQueue() {
//      this.data = new TwoSideLinkedListImpl<>();
        this.data = new LinkedQueue<>();

    }

    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return (E) data.removeFirst();
    }

    @Override
    public E peekFront() {
        return (E) data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedQueue{" + "data=" + data + '}';
    }
}

