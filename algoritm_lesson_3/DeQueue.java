package algoritm_lesson_3;

import java.util.Scanner;

/**
 *    Домашняя работа к 3 лекции Шевеленко Андрея
 *
 * 2. Создан класс DeQueue расширяющий QueueMassive.
 *    в него добавлены методы описывающие новую
 *    структуру данных Дек.  insertInHead(E value),
 *    removeInTail().
 */
public class DeQueue<E> extends QueueMassive<E>{
    public DeQueue(int maxSize) {
        super(maxSize);
    }
    // метод добавления элемента в голове очереди
    public boolean insertInHead(E value) {
        if (isFull()) {
            System.out.println("Очередь заполнена");
            return false;
        }
        if(head == 0){
            head = data.length;
        }
        data[--head] = value;
        size++;
        return true;
    }

    //Метод удаления елемента из головы очереди
    public E removeInTail() {
        if (isEmpty()) {
            return null;
        }
        E value = data[tail];
        data[tail] = null;
        if(tail == 0){
            tail = data.length-1;
        }else{
            tail--;
        }
        size--;
        if(size==0){
            head=HEAD_DEFAULT;
            tail=TAIL_DEFAULT;
        }
        return value;
    }
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        DeQueue <Integer> arrQueue = new DeQueue<>(5);
        while(true){
            System.out.println("\nДобавить в голове : 1:\nДобавить в хвост очереди: 2:\nЗабрать из головы очереди 3:\nЗабрать со стороны хвоста 4: ");
            switch (scaner.nextInt()){
                case 1:
                    System.out.print("Добавить в голове : ");
                    arrQueue.insertInHead(scaner.nextInt());
                    arrQueue.display();
                    System.out.println(" size : "+arrQueue.size);
                    System.out.println(" head : "+arrQueue.head);
                    System.out.println(" tail : "+arrQueue.tail);
                    continue;
                case 2:
                    System.out.print("Добавить в хвост очереди: ");
                    arrQueue.insert(scaner.nextInt());
                    arrQueue.display();
                    System.out.println(" size : "+arrQueue.size);
                    System.out.println(" head : "+arrQueue.head);
                    System.out.println(" tail : "+arrQueue.tail);
                    continue;
                case 3:
                    System.out.print("Забрали из головы очереди: ");
                    System.out.println(arrQueue.remove());
                    arrQueue.display();
                    System.out.println(" size : "+arrQueue.size);
                    System.out.println(" head : "+arrQueue.head);
                    System.out.println(" tail : "+arrQueue.tail);
                    continue;
                case 4:
                    System.out.print("Забрали со стороны хвоста : ");
                    System.out.println(arrQueue.removeInTail());
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



