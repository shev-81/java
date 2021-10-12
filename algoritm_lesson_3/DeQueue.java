package algoritm_lesson_3;

public class DeQueue<E> extends QueueMassive<E>{
    public DeQueue(int maxSize) {
        super(maxSize);
    }
    public boolean insertInHead(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = TAIL_DEFAULT;
        }
        if(head == data.length-1){
            head = HEAD_DEFAULT;
        }
        data[++head] = value;
        size++;
        return true;
    }

}
