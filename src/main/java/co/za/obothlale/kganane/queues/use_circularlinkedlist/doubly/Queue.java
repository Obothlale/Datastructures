package co.za.obothlale.kganane.queues.use_circularlinkedlist.doubly;

import co.za.obothlale.kganane.exceptions.CircularLinkedListOutOfBounds;
import co.za.obothlale.kganane.linkedlist.circular.doubly.CircularDoublyLinkedList;

/**
 * Created by Obothlale on 2015-05-16.
 *
 */
public class Queue<T extends Comparable<? super T>> {

    CircularDoublyLinkedList<T> circularDoublyLinkedList;

    public Queue(){
        circularDoublyLinkedList = new CircularDoublyLinkedList<T>();
    }

    public void enqueue(T data){

        circularDoublyLinkedList.addToTail(data);
    }

    public T dequeue(){
        return circularDoublyLinkedList.deleteFromTail();
    }

    public boolean isEmpty(){

        return circularDoublyLinkedList.isEmpty();
    }

    public String print(){

        return circularDoublyLinkedList.print();
    }

    public T peekFrontQueue(){
        return circularDoublyLinkedList.getHead();
    }

    public T peekBackQueue(){
        return circularDoublyLinkedList.getTail();
    }

    public  T peekAtIndex(int index) throws CircularLinkedListOutOfBounds {
        return circularDoublyLinkedList.get(index);
    }
}
