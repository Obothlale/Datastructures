package co.za.obothlale.kganane.queues.use_circularlinkedlist.singular;

import co.za.obothlale.kganane.exceptions.CircularLinkedListOutOfBounds;
import co.za.obothlale.kganane.linkedlist.circular.singular.CircularLinkedList;

/**
 * Created by Obothlale on 2015-05-16.
 *
 */
public class Queue<T extends Comparable<? super T>> {

    CircularLinkedList<T> circularLinkedList;

    public Queue(){
        circularLinkedList = new CircularLinkedList<T>();
    }

    public void enqueue(T data){

        circularLinkedList.addToTail(data);
    }

    public T dequeue(){
        return circularLinkedList.deleteFromTail();
    }

    public boolean isEmpty(){

        return circularLinkedList.isEmpty();
    }

    public String print(){

        return circularLinkedList.print();
    }

    public T peekFrontQueue(){
        return circularLinkedList.getHead();
    }

    public T peekBackQueue(){
        return circularLinkedList.getTail();
    }

    public  T peekAtIndex(int index) throws CircularLinkedListOutOfBounds {
        return circularLinkedList.get(index);
    }
}
