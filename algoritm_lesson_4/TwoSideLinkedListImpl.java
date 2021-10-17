package algoritm_lesson_4;
//ДЗ 4 для сдачи преподавателю
public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    protected Node<E> last;
    protected Node<E> lastObj;

    @Override
    public void insertFirst(E value) {
        Node<E> tmp;
        tmp=first;

        first = new Node<>(value, first, last);
        if(tmp!=null){
            tmp.prev = first;
        }
        first.prev = tmp;
        size++;
        if (size == 1) {
            lastObj = first;
            System.out.println("обьект lastObj - "+lastObj.item);
            if(lastObj.next!=null)System.out.println("lastObj.next - "+lastObj.next);else  System.out.println("lastObj.next - null");
            System.out.println("lastObj.prev - "+lastObj.prev);
        }
        if(size==2){
            System.out.println("size - "+size);
            System.out.println("обьект lastObj - "+lastObj.item);
            if(lastObj.next!=null)System.out.println("lastObj.next - "+lastObj.next);else  System.out.println("lastObj.next - null");
            System.out.println("lastObj.prev - "+lastObj.prev);
        }
        System.out.println("Объект № - "+first.item);
        if(tmp!=null)System.out.println("tmp.item - "+tmp.item); else System.out.println("tmp - null");
        System.out.println("first.next "+first.next);
        if(tmp!=null)System.out.println("tmp.prev "+tmp.prev);else System.out.println("tmp - null");
        if(last!=null)System.out.println("last - "+last.item); else  System.out.println("last - null");
//        if(lastObj!=null)System.out.println("первый обьект поле lastObj - "+lastObj.item); else System.out.println("первый обьект поле lastObj - null");
        System.out.println("Создан элемент - size = "+size+"\n");

        last = tmp;
    }

//    first = new Node<>(value, first, last);
//        if (size == 1) {
//        last = first;
//    }



    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null);

        if (isEmpty()) {
            insertFirst(value);
            return;
        }
        lastObj.next = newNode;
        newNode.prev = lastObj;
        lastObj = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();

        if (isEmpty()) {
            last = null;
        }

        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> prev = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == first) {
            removeFirst();
            return true;
        } else if(current == last) {
            last = prev;
            last.next = null;
        }
        prev.next = current.next;

        current.next = null;
        size--;

        return true;
    }

    @Override
    public E getLast() {
        return lastObj.item;
    }
}