package algoritm_lesson_4;

public class DeqTwoSideList<E> extends TwoSideLinkedListImpl<E> implements TwoSideLinkedList<E>{
    public E DeleteLast() {
        Node <E> del =  lastObj.prev;
        del.next = null;
        lastObj=del;
//        System.out.println("крайний обьект значение lastObg.item - "+ lastObj.item);
//        System.out.println("крайний обьект значение last.next - "+ lastObj.next);
//        System.out.println("крайний обьект значение last.prev - "+ lastObj.prev);
//        System.out.println("крайний обьект значение size "+ size);
        return lastObj.item;
    }
}
