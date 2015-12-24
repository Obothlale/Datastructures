package co.za.obothlale.kganane.queues.use_doublylinkedlist;

import co.za.obothlale.kganane.exceptions.DoublyLinkedListOutOfBounds;
import co.za.obothlale.kganane.linkedlist.doubly.DoublyLinkedList;

/**
 * Created by Obothlale on 2015-05-16.
 *
 */
public class Queue<T extends Comparable<? super T>> {

    DoublyLinkedList<T> doublyLinkedList;

    public Queue(){
        doublyLinkedList = new DoublyLinkedList<T>();
    }

    public void enqueue(T data){

        doublyLinkedList.addToTail(data);
    }

    public T dequeue(){
        return doublyLinkedList.deleteFromTail();
    }

    public boolean isEmpty(){

        return doublyLinkedList.isEmpty();
    }

    public String print(){

        return doublyLinkedList.printStartFromHead();
    }

    public T peekFrontQueue(){
        return doublyLinkedList.getHead();
    }

    public T peekBackQueue(){
        return doublyLinkedList.getTail();
    }

    public  T peekAtIndex(int index) throws DoublyLinkedListOutOfBounds {
        return doublyLinkedList.get(index);
    }
}
