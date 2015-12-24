package co.za.obothlale.kganane.queues.use_singularlinkedlist;

import co.za.obothlale.kganane.exceptions.SingularLinkedListOutOfBounds;
import co.za.obothlale.kganane.linkedlist.singular.SingularLinkedList;

/**
 * Created by Obothlale on 2015-05-16.
 *
 */
public class Queue<T extends Comparable<? super T>> {

    SingularLinkedList<T> singularLinkedList;

    public Queue(){
        singularLinkedList = new SingularLinkedList<T>();
    }

    public void enqueue(T data){

        singularLinkedList.addToTail(data);
    }

    public T dequeue(){
        return singularLinkedList.deleteFromTail();
    }

    public boolean isEmpty(){

        return singularLinkedList.isEmpty();
    }

    public String print(){

        return singularLinkedList.print();
    }

    public T peekFrontQueue(){
        return singularLinkedList.getHead();
    }

    public T peekBackQueue(){
        return singularLinkedList.getTail();
    }

    public  T peekAtIndex(int index) throws SingularLinkedListOutOfBounds {
        return singularLinkedList.get(index);
    }
}
