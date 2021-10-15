package algoritm_lesson_3;

import java.util.Scanner;

/**
 *
 *   Домашняя работа к 3 лекции Шевеленко Андрея
 *
 *   п.3*   Оптимизирована очередь, очередь сделана циклической.
 *          В ней отслеживаются позиции начала очереди и ее конца,
 *          так же контролируются перемещение head и tail по массиву
 *          и в зависимости от их положения выводим находящиеся в
 *          очереди элементы методом toString().
 */
public class QueueMassive<E> implements Queue<E>{
    protected final E[] data;
    protected int size;

    protected int tail;
    protected int head;

    final int HEAD_DEFAULT = 0;
    final int TAIL_DEFAULT = -1;

    public QueueMassive(int maxSize) {
        this.data = (E[])new Object[maxSize];
        head = HEAD_DEFAULT;
        tail = TAIL_DEFAULT;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            System.out.println("Очередь заполнена");
            return false;
        }
        if(tail == data.length-1){
            tail = TAIL_DEFAULT;
        }
        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        E value = data[head];
        data[head] = null;
        if(head == data.length-1){
            head = HEAD_DEFAULT;
        }else{
            head++;
        }
        size--;
        if(size==0){
            head=HEAD_DEFAULT;
            tail=TAIL_DEFAULT;
        }
        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        if (head <= tail) {                              // если конец очереде не перешел на начало массива то просто перебираем элементы
            for(int i=head,j=0;  j<size;  i++,j++) {
                sb.append(data[i] + " ");
            }
        } else if (head > tail) {                        // если  конец очереди перешел на начало массива и голова находится дальше
            for(int i = head, j=0; j < size; j++) {
                if (i == data.length - 1) {
                    sb.append(data[i]+" ");
                    i = 0;
                    continue;
                }
                sb.append(data[i]+" ");
                i++;
            }
        }
        sb.append(" ]");
    return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        QueueMassive <Integer> arrQueue = new QueueMassive<>(5);
        while(true){
            System.out.println("Добавить число 1: \n Забрать число 2:");
            switch (scaner.nextInt()){
                case 1:
                    System.out.print("Добавить : ");
                    arrQueue.insert(scaner.nextInt());
                    arrQueue.display();
                    System.out.println(" size : "+arrQueue.size);
                    System.out.println(" head : "+arrQueue.head);
                    System.out.println(" tail : "+arrQueue.tail);
                    continue;
                case 2:
                    System.out.print("Забрали : ");
                    System.out.println(arrQueue.remove());
                    arrQueue.display();
                    System.out.println(" size : "+arrQueue.size);
                    System.out.println(" head : "+arrQueue.head);
                    System.out.println(" tail : "+arrQueue.tail);
                    continue;
            }
            if(arrQueue.isFull()) {
                break;
            }
        }
    }
}
