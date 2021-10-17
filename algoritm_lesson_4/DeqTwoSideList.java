package algoritm_lesson_4;
//ДЗ 4 для сдачи преподавателю
/**
 *   Реализация Дека на структуре двунаправленного списка добавлен метод добавления и метод удаления.
 */
public class DeqTwoSideList<E> extends TwoSideLinkedListImpl<E> implements TwoSideLinkedList<E>{

    // метод удаления элемента
    public E DeleteLast() {
        Node <E> retObj = lastObj;
        Node <E> del =  lastObj.prev;
        del.next = null;
        lastObj=del;
        return retObj.item;
    }
    // метод добавления
    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null, lastObj);
        if (isEmpty()) {
            insertFirst(value);
            return;
        }
        lastObj.next = newNode;
        lastObj = newNode;
        size++;
    }
}
